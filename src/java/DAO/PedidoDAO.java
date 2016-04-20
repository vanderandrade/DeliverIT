package DAO;

import Controller.MySqlController;
import Model.Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoDAO {
    private MySqlController conn;
    
    public PedidoDAO(MySqlController conexao)
    {
        this.conn = conexao;
    }
     public Pedido[] carregaPedidos() {

        Pedido retorno[] = new Pedido[1];
        PreparedStatement stmt;
        ResultSet rs;
        int i = 0;
        String query = "SELECT COUNT(*) FROM mov_pedido WHERE statusPedido!='Fechado'";

        try {
            stmt = conn.getConn().prepareStatement(query);
            rs = stmt.executeQuery();

            rs.next();

            retorno = new Pedido[rs.getInt(1)];
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySqlController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        query = "SELECT * FROM mov_pedido WHERE statusPedido!='Fechado' order by dataPedido ASC";
        try {
            stmt = conn.getConn().prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                retorno[i] = new Pedido(rs.getInt("codPedido"),rs.getFloat("valorTotal"), rs.getFloat("valorEntrega"), rs.getFloat("valorDesconto"),
                        rs.getInt("codCliente"), rs.getInt("codEstabelecimento"), rs.getString("dataPedido"), rs.getString("statusPedido") );
                i++;
            }
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySqlController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
     
     
    public String[] carregaItemPedido(int codPedido) {

        String retorno[] = new String[1];
        PreparedStatement stmt;
        ResultSet rs;
        int i = 0;
        String query = "SELECT COUNT(*) FROM mov_pedido_item WHERE codPedido="+codPedido;

        try {
            stmt = conn.getConn().prepareStatement(query);
            rs = stmt.executeQuery();

            rs.next();

            retorno = new String[rs.getInt(1)];
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySqlController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        query = "SELECT * FROM mov_pedido_item WHERE codPedido="+codPedido;
        try {
            stmt = conn.getConn().prepareStatement(query);
            rs = stmt.executeQuery();
            ProdutoDAO produtodao = new ProdutoDAO(conn);
            while (rs.next()) {
                retorno[i] = new String(rs.getInt("qtdProduto") + " Unid. - " + produtodao.consultaNomeProduto(rs.getInt("codProduto")));
                i++;
            }
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySqlController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }


    public void atualizaStatus(String novoStatus, int codPedido) { //UPDATE
        try {
            String instrucao = "UPDATE `mov_pedido` SET `statusPedido`= '" + novoStatus + "' WHERE codPedido = '" + codPedido + "'";
            PreparedStatement stmt;
            stmt = conn.getConn().prepareStatement(instrucao);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
