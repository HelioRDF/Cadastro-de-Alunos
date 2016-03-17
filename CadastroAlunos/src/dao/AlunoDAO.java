/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Factory.ConexaoFactory;
import static Factory.ConexaoFactory.con;
import gui.Aluno;
import gui.CadAluno;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author helio
 */
public class AlunoDAO {

    private Connection con;
    private Statement stmt;

    private Statement stmtNavegar;
    //private Statement stmtNavegar2;
    private ResultSet rsNavegar;
    ResultSet rs;

    public AlunoDAO() throws ClassNotFoundException, SQLException {

        //Realiza a conexão do BD.
        con = ConexaoFactory.getConection();
        stmt = con.createStatement();

        stmtNavegar = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        //stmtNavegar2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        rsNavegar = stmtNavegar.executeQuery("select *from teste.ALUNO;");
    }

    //Resgata o primeiro registro do DB
    public Aluno primeiro() throws SQLException {

        if (rsNavegar.first()) {

            setRsNavegar();

            return setRsNavegar();
        } else {
            return null;
        }
    }

    //Volta um registro no DB
    public Aluno anterior() throws SQLException {

        if (!rsNavegar.isFirst()) {

            rsNavegar.previous();

            setRsNavegar();

            return setRsNavegar();
        } else {
            return null;
        }
    }

    //Buscar o proximo registro no DB
    public Aluno proximo() throws SQLException {

        if (!rsNavegar.isLast()) {

            rsNavegar.next();

            setRsNavegar();

            return setRsNavegar();
        } else {
            return null;
        }
    }

    //Busca o ultimo registro do DB
    public Aluno ultimo() throws SQLException {

        if (rsNavegar.last()) {

            setRsNavegar();

            return setRsNavegar();
        } else {
            return null;
        }
    }

    public Aluno pesquisarAluno(int cod) throws SQLException {

        rs = stmt.executeQuery("select *from ALUNO where COD=" + cod);

        if (rs.next()) {

            setRs();

            return setRs();

        } else {
            return null;
        }

    }

    public boolean excluirRegistro(int cod) throws SQLException {
        stmt.executeUpdate("delete from teste.ALUNO where COD=" + cod);
        refresh();
        return true;
    }

    public boolean salvarRegistro(Aluno aluno) throws SQLException {

        //Captura as informações dos campos de texto da interface gráfica, e atribui as variáveis do método salvar.
        int COD = aluno.getCod();
        String NOME = aluno.getNome();
        String SOBRENOME = aluno.getSobrenome();
        int CODCIDADE = aluno.getCodcidade();

        try {
            //Comando que realiza o insert no banco de dados.
            stmt.executeUpdate("insert into ALUNO(COD,NOME,SOBRENOME,CODCIDADE) "
                    + "VALUES(" + COD + ",'" + NOME + "','" + SOBRENOME + "'," + CODCIDADE + ");");

            
            return true;

        } catch (SQLException e) {
            stmt.executeUpdate("update  ALUNO set "
                    + "COD='" + COD + "'," + "NOME='" + NOME + "'," + "SOBRENOME='" + SOBRENOME + "'," + "CODCIDADE='" + CODCIDADE + "' where COD='" + COD + "';");

            
            return true;
        }finally{
            refresh();
        }
    }

    public Aluno setRs() throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setCod(rs.getInt("COD"));
        aluno.setNome(rs.getString("NOME"));
        aluno.setSobrenome(rs.getString("SOBRENOME"));
        aluno.setCodcidade(rs.getInt("CODCIDADE"));

        return aluno;
    }

    public Aluno setRsNavegar() throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setCod(rsNavegar.getInt("COD"));
        aluno.setNome(rsNavegar.getString("NOME"));
        aluno.setSobrenome(rsNavegar.getString("SOBRENOME"));
        aluno.setCodcidade(rsNavegar.getInt("CODCIDADE"));

        return aluno;

    }

    public void refresh() {

        try {
            rsNavegar = stmtNavegar.executeQuery("select *from teste.ALUNO;");
            primeiro();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
