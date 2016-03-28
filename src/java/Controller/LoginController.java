package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String nome = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        //MySqlController conexao = new MySqlController();
        
        //if(conexao.CheckLoginMysql(nome, senha))
        if(nome.equals("destaque") && senha.equals("1234"))
        {
            //request.getRequestDispatcher("/build/web/autenticado/index.jsp").forward(request, response);
            response.sendRedirect("autenticado/index.jsp");            
        }
        else
        {
            out.println("<h2>Usuário e/ou Senha inválidos!</h2>");   
            out.println("<a href=index.jsp>Voltar</a>");   
            
        }
        
//        conexao.FecharConexao();
    }

}
