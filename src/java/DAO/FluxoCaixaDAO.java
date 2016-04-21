package DAO;

import Controller.MySqlController;
import Model.FluxoCaixa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FluxoCaixaDAO {
    private MySqlController conn;
    
    public FluxoCaixaDAO(MySqlController conexao)
    {
        this.conn = conexao;
    }
    
    public void criarRegistro(String data, String horario, String descricao, boolean movimentacao, float valor) { //CREATE
        try {
            PreparedStatement stmt = conn.getConn().
                    prepareStatement("INSERT INTO `cad_fluxocaixa`(`data`,`horario`, `movimentacao`, `valor`, `descricao`) VALUES ('"+ data +"', '"+ horario +"', "+ movimentacao +", "+ Float.toString(valor) +", '"+ descricao +"')");
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public FluxoCaixa[] carregaRegistros() {
        FluxoCaixa retorno[] = new FluxoCaixa[1];
        PreparedStatement stmt;
        ResultSet rs;
        int i = 0;
        String data = getData();
        String query = "SELECT COUNT(*) FROM cad_fluxocaixa WHERE data = '"+ data +"'";
        
        try {
            stmt = conn.getConn().prepareStatement(query);
            rs = stmt.executeQuery();

            rs.next();

            retorno = new FluxoCaixa[rs.getInt(1)];
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySqlController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
        query = "SELECT * FROM cad_fluxocaixa WHERE data = '"+ data +"'";
        try {
            stmt = conn.getConn().prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                retorno[i] = new FluxoCaixa(rs.getString("descricao"), rs.getString("horario"), 
                                            rs.getBoolean("movimentacao"), rs.getFloat("valor"));
                i++;
            }
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySqlController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public String getData() {
        StringBuilder sb = new StringBuilder();
        GregorianCalendar d = new GregorianCalendar();

        sb.append(d.get(GregorianCalendar.DAY_OF_MONTH));
        sb.append("/");
        sb.append(d.get(GregorianCalendar.MONTH));
        sb.append("/");
        sb.append(d.get(GregorianCalendar.YEAR));

        return sb.toString();
    }
}
