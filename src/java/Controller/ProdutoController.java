package Controller;

import Model.Produto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProdutoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MySqlController conexao = new MySqlController();

        switch (request.getParameter("action")) {

            case "Excluir":
                conexao.removerProduto(Integer.parseInt(request.getParameter("codProduto")));
                response.sendRedirect("produto.jsp");
                break;
            case "Alterar":
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/autenticado/alteraProduto.jsp");
                request.setAttribute("codProduto", request.getParameter("codProduto"));
                request.setAttribute("nomeProduto", request.getParameter("nomeProduto"));
                request.setAttribute("precoProduto", request.getParameter("precoProduto"));
                request.setAttribute("quantidadeProduto", request.getParameter("quantidadeProduto"));
                request.setAttribute("categoriaProduto", request.getParameter("categoriaProduto"));              
                rd.forward(request, response);
                break;
        }

        conexao.Fechar();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MySqlController conexao = new MySqlController();
        Produto produto;
        switch (request.getParameter("button")) {
            case "cadastrar":
                produto = new Produto(request.getParameter("nomeProduto"), Integer.parseInt(request.getParameter("quantidadeProduto")),
                        Float.parseFloat(request.getParameter("precoProduto")), Integer.parseInt(request.getParameter("categoriaProduto")));
                conexao.cadastrarProduto(produto);
                response.sendRedirect("produto.jsp");
                break;
                
            case "alterar":
                 produto = new Produto(Integer.parseInt(request.getParameter("codProduto")),request.getParameter("nomeProduto"), Integer.parseInt(request.getParameter("quantidadeProduto")),
                        Float.parseFloat(request.getParameter("precoProduto")), Integer.parseInt(request.getParameter("categoriaProduto")));
                conexao.atualizaProduto(produto);
                response.sendRedirect("produto.jsp");
                break;
                
        }
        conexao.Fechar();
    }

}
