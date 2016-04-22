package br.pucpcaldas.inf.lc.deliverit.controller;

import br.pucpcaldas.inf.lc.deliverit.model.Usuario;
import br.pucpcaldas.inf.lc.deliverit.model.Categoria;
import br.pucpcaldas.inf.lc.deliverit.model.Produto;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlController {

    private Connection conn = null;    
    private Categoria cat;

    public MySqlController() throws ClassNotFoundException, SQLException {
     
            Class.forName("com.mysql.jdbc.Driver");
            String serverName = "localhost";  //179.188.16.32
            String mydatabase = "deliverit"; //transtass1
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root"; //transtassi1
            String password = "177013aew"; //agorasim0
            conn = (Connection) DriverManager.getConnection(url, username, password);

    }

    public Connection getConn() {
        return conn;
    }

    
    
    public void Fechar() {
        try {
            conn.close();            
            conn = null;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean isValid()
    {
        boolean value = false;        
        try {
            value = conn.isValid(0);
        } catch (SQLException ex) {
            Logger.getLogger(MySqlController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }


}
