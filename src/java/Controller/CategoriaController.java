package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CategoriaController", urlPatterns = {"/CategoriaController"})
public class CategoriaController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        MySqlController conexao = new MySqlController();
        String botao = request.getParameter("button");
        switch (botao) {
            case "cadastrar":
                conexao.criarCategoria(request.getParameter("atividade"));
                break;
            case "atualizar":
                {
                    String novoNome = request.getParameter("novoNome");
                    int codCategoria = Integer.parseInt(request.getParameter("codCategoria"));
                    conexao.atualizaCategoria(novoNome, codCategoria);
                    break;
                }
            case "remover":
                {
                    int codCategoria = Integer.parseInt(request.getParameter("codCategoria"));
                    conexao.removerCategoria(codCategoria);
                    break;
                }
        }
        response.sendRedirect("categoria.jsp");
        
        conexao.Fechar();
    }
}
