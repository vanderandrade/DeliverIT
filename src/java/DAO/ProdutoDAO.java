package DAO;

import Controller.MySqlController;
import Model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {
    private MySqlController conn;
    
    public ProdutoDAO(MySqlController conexao)
    {
        conn = conexao;
    }
    public void cadastrarProduto(Produto produto) {
        try {
            System.out.println("INSERT INTO cad_produto(nomeProduto,precoProduto,qtdEstoque,codCategoria) VALUES "
                            + "('" + produto.getNomeProduto() + "','" + produto.getPrecoProduto() + "','" + produto.getQtdEstoque() + "','" + produto.getCodCategoria() + "')");
            
            PreparedStatement stmt = conn.getConn()
                    .prepareStatement("INSERT INTO cad_produto(nomeProduto,precoProduto,qtdEstoque,codCategoria) VALUES "
                            + "('" + produto.getNomeProduto() + "','" + produto.getPrecoProduto() + "','" + produto.getQtdEstoque() + "','" + produto.getCodCategoria() + "')");
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Produto[] carregaProduto() {

        Produto retorno[] = new Produto[1];
        PreparedStatement stmt;
        ResultSet rs;
        int i = 0;
        String query = "SELECT COUNT(*) FROM cad_produto";

        try {
            stmt = conn.getConn().prepareStatement(query);
            rs = stmt.executeQuery();

            rs.next();

            retorno = new Produto[rs.getInt(1)];
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySqlController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        query = "SELECT * FROM cad_produto";
        try {
            stmt = conn.getConn().prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                retorno[i] = new Produto(rs.getInt("codProduto"), rs.getString("nomeProduto"), rs.getInt("qtdEstoque"), rs.getFloat("precoProduto"), rs.getInt("codCategoria"));
                i++;
            }
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySqlController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public void removerProduto(int codProduto) { //DELETE
        try {
            PreparedStatement preparedStatement = conn.getConn()
                    .prepareStatement("DELETE FROM cad_produto WHERE codProduto= " + codProduto);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
      public void atualizaProduto(Produto produto) { //UPDATE
        try {
            String instrucao = "UPDATE `cad_produto` SET `nomeProduto`= '" + produto.getNomeProduto() + "', precoProduto='"+produto.getPrecoProduto()+"'"
                    + ",qtdEstoque='"+produto.getQtdEstoque()+"', codCategoria='"+produto.getCodCategoria()+"' WHERE codProduto = '" + produto.getCodProduto() + "'";
            PreparedStatement stmt;
            System.out.println("Instrucao: "+ instrucao);
            stmt = conn.getConn().prepareStatement(instrucao);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO NO UPDATE" );
        }
    }
}
