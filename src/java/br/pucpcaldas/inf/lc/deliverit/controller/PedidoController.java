package br.pucpcaldas.inf.lc.deliverit.controller;

import br.pucpcaldas.inf.lc.deliverit.dao.PedidoDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PedidoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        MySqlController conexao = (MySqlController) session.getAttribute("conexao");        
        PedidoDAO pedidodao = new PedidoDAO(conexao);
              
        if(request.getParameter("button").toString().equals("alterar")){  
            pedidodao.atualizaStatus(request.getParameter("alterarCombo"), Integer.parseInt(request.getParameter("codPedido").toString()));
            if(request.getParameter("alterarCombo").toString().equals("Fechado")){                
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/autenticado/confirmacaoPedido.jsp");                
                rd.forward(request, response);
            }            
            response.sendRedirect("index.jsp");
        }
    }

}
