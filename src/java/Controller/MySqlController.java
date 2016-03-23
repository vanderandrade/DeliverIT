package Controller;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlController {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/EMP";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "1234";
    
    Connection conn = null;
    Statement stmt = null;
    
    public MySqlController() {
        try {
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Execute a query
            System.out.println("Creating statement...");            
            stmt = conn.createStatement();
           
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try      

    }
    
    
    public void FecharConexao()
    {
        try {
            stmt.close();
            conn.close();
            conn = null;
            stmt = null;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlController.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    public boolean CheckLoginMysql(String usuario, String senha)
    {                
                String sql = "SELECT "+usuario+", "+senha+" FROM users";
                ResultSet rs;
        try {
            rs = stmt.executeQuery(sql);
            String usuarioMySql = rs.getString("usuario");
            String senhaMySql = rs.getString("senha");
            rs.close();
                if(usuarioMySql.equals(usuario) && senhaMySql.equals(senha))                   
                    return true;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
