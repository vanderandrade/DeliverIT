package Controller;

import Model.Usuario;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlController {
    private Connection conn = null;
    private Usuario usu;
    
    public MySqlController() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String serverName = "localhost";
            String mydatabase ="deliveryit";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";
            String password = "177013aew";
            conn = (Connection) DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel estabelecer conexao com o banco");
        } catch (SQLException ex) {
            System.out.println("Não foi possivel estabelecer conexao com o banco");
        }
        
    }

    public void Fechar(){
        try {
            conn.close();
            conn = null;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean CheckLogin(String usuario, String senha)
    {

        String query = "SELECT * FROM cad_funcionario WHERE login='"+usuario+"' AND senha='"+senha+"'";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                String usuMysql = rs.getString("login");
                String senhaMysql = rs.getString("senha");
                
                if(usuMysql.equals(usuario) && senhaMysql.equals(senha))
                {
                    usu = new Usuario(rs.getString("nomeFuncionario"), rs.getInt("tipoFuncionario"));
                    return true;
                }                    
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySqlController.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return false;
    }

    public Usuario getUsu() {
        return usu;
    }      
    
}
