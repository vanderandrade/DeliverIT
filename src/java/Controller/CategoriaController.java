package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CategoriaController", urlPatterns = {"/CategoriaController"})
public class CategoriaController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        MySqlController conexao = (MySqlController) session.getAttribute("conexao");
        
        String botao = request.getParameter("button");
        switch (botao) {
            case "cadastrar":
                conexao.criarCategoria(request.getParameter("cadastrar"));
                break;
            case "alterar": { // ARRUMAR OS PARÂMETROS P/ COMBO BOX
                String novoNome = request.getParameter("novoNome");
                int codCategoria = Integer.parseInt(request.getParameter("alterarCombo"));
                conexao.atualizaCategoria(novoNome, codCategoria);
                break;
            }
            case "remover": { // ARRUMAR OS PARÂMETROS P/ COMBO BOX                    
                int codCategoria = Integer.parseInt(request.getParameter("alterarCombo"));
                conexao.removerCategoria(codCategoria);
                break;
            }
        }
        response.sendRedirect("categoria.jsp");

    }
}
