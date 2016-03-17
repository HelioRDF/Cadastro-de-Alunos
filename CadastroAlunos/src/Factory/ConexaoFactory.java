package Factory;

import gui.CadAluno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author helio
 */


//Padrão singleton para conexão de BD.
public class ConexaoFactory {

    public static Connection con;

    public static Connection getConection() throws ClassNotFoundException, SQLException {

        if (con == null) {

            //Define o driver do Banco de dados. Nesse caso o mysql.
            Class.forName("com.mysql.jdbc.Driver");

            //Define o caminho para acessar o banco de dados.
            String uri;
            uri = "jdbc:mysql://localhost:3306/teste";

            //Usuário e senha da conexão do banco de dados.
            String user = "root";
            String pass = "root";

            //Realiza a conexão do BD.
            con = DriverManager.getConnection(uri, user, pass);
            
            return con;

        } else {

            return con;
        }

    }

}
