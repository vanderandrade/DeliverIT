package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        MySqlController conexao = new MySqlController();
        
        if(conexao.CheckLogin(usuario, senha))
        {       
            HttpSession session = request.getSession();
            session.setAttribute("usuario",conexao.getUsu().getName());            
            session.setAttribute("tipo",conexao.getUsu().getTipo());
            session.setAttribute("conexao", conexao);
            session.setMaxInactiveInterval(10*60); // 10 minutos de inatividade
                    
            response.sendRedirect("autenticado/index.jsp");
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            PrintWriter out = response.getWriter();
            out.println("<center><font color=red>Usuário ou senha inválidos!</font></center>");
            rd.include(request, response);
        }        
                
    }

}
