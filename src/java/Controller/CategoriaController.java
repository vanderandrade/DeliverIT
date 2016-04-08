package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vander
 */
@WebServlet(name = "CategoriaController", urlPatterns = {"/CategoriaController"})
public class CategoriaController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        MySqlController conexao = new MySqlController();
        
        
        //if(/*Qualquer indicativo de que o usuário deseja inserir*/true) {
            String nomeCategoria = request.getParameter("nomeCategoria");
            
            conexao.criarCategoria(nomeCategoria);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("autenticado/categoria.jsp");
            PrintWriter out = response.getWriter();
            out.println("<center><font color=red>Efetuado com sucesso!</font></center>");
            rd.include(request, response);
            
        //}
        //else if(/*Qualquer indicativo de que o usuário deseja atualizar*/true){
        //    String novoNome = request.getParameter("novoNome");
        //    int codCategoria = Integer.parseInt(request.getParameter("codCategoria"));
        //    
        //    conexao.atualizaCategoria(novoNome, codCategoria);
        //}
        //else if(/*Qualquer indicativo de que o usuário deseja excluir*/true){
        //    int codCategoria = Integer.parseInt(request.getParameter("codCategoria"));
        //    
        //    conexao.removerCategoria(codCategoria);
       // }
        conexao.Fechar();
    }
}
