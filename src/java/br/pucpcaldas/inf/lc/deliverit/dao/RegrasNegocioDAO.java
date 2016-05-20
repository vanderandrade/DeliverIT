package br.pucpcaldas.inf.lc.deliverit.dao;

import br.pucpcaldas.inf.lc.deliverit.controller.MySqlController;
import br.pucpcaldas.inf.lc.deliverit.model.RegrasNegocio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegrasNegocioDAO {

    private final MySqlController conn;

    public RegrasNegocioDAO(MySqlController conexao) {
        if (!conexao.isValid() || conexao == null) {
            try {
                conexao = new MySqlController();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.conn = conexao;
    }

    public void criarRegraNegocio(RegrasNegocio rn) { //CREATE
        try {
            PreparedStatement stmt;
            switch (rn.getCodTipo()) {
                case 0:
                    stmt = conn.getConn() 
                            .prepareStatement("INSERT INTO `cad_desconto`(`codTipo`, `codRelacionado`, `quantidade`, `porcentagemDesconto`)"
                                    + " VALUES ("+rn.getCodTipo()+","+rn.getCodRelacionado()+","+rn.getQuantidade()+","+(rn.getPorcentagem()/100)+")");
                    stmt.executeUpdate();
                    break;
                case 1:
                    stmt = conn.getConn() 
                            .prepareStatement("INSERT INTO `cad_desconto`(`codTipo`, `codRelacionado`, `preco/distancia`, `porcentagemDesconto`)"
                                    + " VALUES ("+rn.getCodTipo()+","+rn.getCodRelacionado()+","+rn.getPrecoDistancia()+","+(rn.getPorcentagem()/100)+")");
                    stmt.executeUpdate();
                    break;
                case 2:
                case 3:
                    stmt = conn.getConn() 
                            .prepareStatement("INSERT INTO `cad_desconto`(`codTipo`, `preco/distancia`, `porcentagemDesconto`)"
                                    + " VALUES ("+rn.getCodTipo()+","+rn.getPrecoDistancia()+","+(rn.getPorcentagem()/100)+")");
                    stmt.executeUpdate();
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public RegrasNegocio[] carregaRegras() { //READ

        RegrasNegocio retorno[] = new RegrasNegocio[1];
        PreparedStatement stmt;
        ResultSet rs;
        int i = 0;
        String query = "SELECT COUNT(*) FROM cad_desconto";

        try {
            stmt = conn.getConn().prepareStatement(query);
            rs = stmt.executeQuery();

            rs.next();

            retorno = new RegrasNegocio[rs.getInt(1)];
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySqlController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        query = "SELECT * FROM cad_desconto";
        try {
            stmt = conn.getConn().prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                retorno[i] = new RegrasNegocio(rs.getInt("codDesconto"), rs.getInt("codTipo"), rs.getInt("codRelacionado"), rs.getInt("quantidade"),
                        rs.getFloat("preco/distancia"), rs.getFloat("porcentagemDesconto"));
                i++;
            }
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySqlController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    // SEM UPDATE
    
    public void removerCategoria(int codDesconto) { //DELETE
        try {
            PreparedStatement preparedStatement = conn.getConn()
                    .prepareStatement("DELETE FROM cad_desconto WHERE codDesconto = " + codDesconto);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
