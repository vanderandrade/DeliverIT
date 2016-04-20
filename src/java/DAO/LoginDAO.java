package DAO;

import Controller.MySqlController;
import Model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    private Usuario usu;
    private MySqlController conn;
    
    public LoginDAO(MySqlController conexao)
    {
        conn = conexao;
    }

    public boolean CheckLogin(String usuario, String senha) throws SQLException {

        String query = "SELECT * FROM cad_funcionario WHERE login='" + usuario + "' AND senha='" + senha + "'";
        PreparedStatement stmt;

        stmt = conn.getConn().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String usuMysql = rs.getString("login");
            String senhaMysql = rs.getString("senha");

            if (usuMysql.equals(usuario) && senhaMysql.equals(senha)) {
                usu = new Usuario(rs.getString("nomeFuncionario"), rs.getInt("tipoFuncionario"));
                return true;
            }
        }
        stmt.close();

        return false;
    }

    public Usuario getUsu() {
        return usu;
    }

    
}
