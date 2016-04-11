package Controller;

import Model.Usuario;
import Model.Categoria;
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
    private Categoria cat;

    public MySqlController() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String serverName = "localhost";  //179.188.16.32
            String mydatabase = "deliverit"; //transtass1
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root"; //transtassi1
            String password = "TheGodfather2"; //agorasim0
            conn = (Connection) DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel estabelecer conexao com o banco");
        } catch (SQLException ex) {
            System.out.println("Não foi possivel estabelecer conexao com o banco");
        }

    }

    public void Fechar() {
        try {
            conn.close();
            conn = null;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean CheckLogin(String usuario, String senha) {

        String query = "SELECT * FROM cad_funcionario WHERE login='" + usuario + "' AND senha='" + senha + "'";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(query);
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
        } catch (SQLException ex) {
            Logger.getLogger(MySqlController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Usuario getUsu() {
        return usu;
    }

    public Categoria[] carregaCategorias() {

        Categoria retorno[] = new Categoria[1];
        PreparedStatement stmt;
        ResultSet rs;
        int i = 0;
        String query = "SELECT COUNT(*) FROM categoria";

        try {
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            rs.next();

            retorno = new Categoria[rs.getInt(1)];
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySqlController.class.getName()).log(Level.SEVERE, null, ex);
        }

        query = "SELECT * FROM categoria";
        try {
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                retorno[i] = new Categoria(rs.getString("nomeCategoria"), rs.getInt("codCategoria"));
                i++;
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySqlController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public void atualizaCategoria(String novoNome, int codigoCategoria) { //UPDATE
        try {
            String instrucao = "UPDATE `categoria` SET `nomeCategoria`= '" + novoNome + "' WHERE codCategoria = '" + codigoCategoria + "'";
            PreparedStatement stmt;

            stmt = conn.prepareStatement(instrucao);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void criarCategoria(String nomeCategoria) { //CREATE
        try {
            PreparedStatement stmt = conn
                    .prepareStatement("INSERT INTO categoria(nomeCategoria) VALUES ('" + nomeCategoria + "')");
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerCategoria(int codCategoria) { //DELETE
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("DELETE FROM categoria WHERE codCategoria= " + codCategoria);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
