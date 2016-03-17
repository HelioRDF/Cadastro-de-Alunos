package dao;

import Factory.ConexaoFactory;
import static Factory.ConexaoFactory.con;
import entity.Cidade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author helio
 */
public class CidadeDAO {

    private Connection con;
    private Statement stmt;
    private Statement stmtCidade;
    private Statement stmtNavegar;
    //private Statement stmtNavegar2;
    private ResultSet rsNavegar;
    ResultSet rs;

    public CidadeDAO() throws ClassNotFoundException, SQLException {

        //Realiza a conexão do BD.
        con = ConexaoFactory.getConection();
        stmt = con.createStatement();

        stmtNavegar = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     
        rsNavegar = stmtNavegar.executeQuery("select *from teste.CIDADE;");
    }

    //Resgata o primeiro registro do DB
    public Cidade primeiro() throws SQLException {

        if (rsNavegar.first()) {

            setRsNavegar();

            return setRsNavegar();
        } else {
            return null;
        }
    }

    //Volta um registro no DB
    public Cidade anterior() throws SQLException {

        if (!rsNavegar.isFirst()) {

            rsNavegar.previous();

            setRsNavegar();

            return setRsNavegar();
        } else {
            return null;
        }
    }

    //Buscar o proximo registro no DB
    public Cidade proximo() throws SQLException {

        if (!rsNavegar.isLast()) {

            rsNavegar.next();

            setRsNavegar();

            return setRsNavegar();
        } else {
            return null;
        }
    }

    //Busca o ultimo registro do DB
    public Cidade ultimo() throws SQLException {

        if (rsNavegar.last()) {

            setRsNavegar();

            return setRsNavegar();
        } else {
            return null;
        }
    }

    public Cidade pesquisarCidade(int cod) throws SQLException {

        rs = stmt.executeQuery("select *from CIDADE where COD=" + cod);

        if (rs.next()) {

            setRs();

            return setRs();

        } else {
            return null;
        }

    }

    public boolean excluirRegistro(int cod) throws SQLException {
        stmt.executeUpdate("delete from teste.CIDADE where COD=" + cod);
        refresh();
        return true;
    }

    public boolean salvarRegistro(Cidade cidade) throws SQLException {

        //Captura as informações dos campos de texto da interface gráfica, e atribui as variáveis do método salvar.
        int COD = cidade.getCod();
        String nomeCidade = cidade.getNomeCidade();
        String nomeEstado = cidade.getNomeEstado();

        try {
            //Comando que realiza o insert no banco de dados.
            stmt.executeUpdate("insert into teste.CIDADE(COD,NOMECIDADE,NOMEESTADO)"
                    + "Values" + "(" + COD + ",'" + nomeCidade + "','" + nomeEstado + "')");

            
            return true;

        } catch (SQLException e) {
            stmt.executeUpdate("update  CIDADE set "
                    + "COD='" + COD + "'," + "NOMECIDADE='" + nomeCidade + "'," + "NOMEESTADO='" + nomeEstado + "' where COD='" + COD + "';");
            
          
            return true;
        }finally{
            refresh();
        }
        
    }

    public Cidade setRs() throws SQLException {
        Cidade cidade = new Cidade();
        cidade.setCod(rs.getInt("COD"));
        cidade.setNomeCidade(rs.getString("NOMECIDADE"));
        cidade.setNomeEstado(rs.getString("NOMEESTADO"));

        return cidade;
    }

    public Cidade setRsNavegar() throws SQLException {
        Cidade cidade = new Cidade();
        cidade.setCod(rsNavegar.getInt("COD"));
        cidade.setNomeCidade(rsNavegar.getString("NOMECIDADE"));
        cidade.setNomeEstado(rsNavegar.getString("NOMEESTADO"));

        return cidade;

    }

    public int getCodCidadeByNome(String nomeCidade) throws SQLException {

        ResultSet rsCidade = stmt.executeQuery("select *from CIDADE where NOMECIDADE='" + nomeCidade + "'");

        if (rsCidade.next()) {

            return rsCidade.getInt("COD");

        } else {
            return -1;
        }

    }

    public String getNomeCidadeByCod(int CodCidade) throws SQLException {

        ResultSet rsCidade = stmt.executeQuery("select *from CIDADE where COD='" + CodCidade + "'");

        if (rsCidade.next()) {

            return rsCidade.getString("NOMECIDADE");

        } else {
            return "";
        }

    }

    public List<Cidade> montarListaCidade() throws SQLException {

        ArrayList<Cidade> lista = new ArrayList<Cidade>();
        ResultSet rsCidade = stmt.executeQuery("select *from teste.CIDADE;");

        while (rsCidade.next()) {

            Cidade cidade = new Cidade();
            cidade.setCod(rsCidade.getInt("COD"));
            cidade.setNomeCidade(rsCidade.getString("NOMECIDADE"));
            cidade.setNomeEstado(rsCidade.getString("NOMEESTADO"));

            lista.add(cidade);

        }

        return lista;

    }
    
    public void refresh(){
        
        try {
            rsNavegar = stmtNavegar.executeQuery("select *from teste.CIDADE;");
            primeiro();
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
