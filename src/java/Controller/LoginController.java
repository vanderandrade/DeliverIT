package Controller;

import DAO.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        MySqlController conexao = null;        
        PrintWriter out = response.getWriter();
        
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        try{
        conexao = new MySqlController();
        }catch (SQLException sqle)
        {
        out.print("<script> alert('SEM CONEXÃO COM O BANCO!');</script>");
        }catch(ClassNotFoundException cnfe)
        {
        out.print("<script> alert('SEM CONEXÃO COM O BANCO!');</script>");
        }
        LoginDAO logindao = new LoginDAO(conexao);
        try {
            if(conexao!=null && logindao.CheckLogin(usuario, senha))
            {
                HttpSession session = request.getSession();
                session.setAttribute("usuario",logindao.getUsu().getName());
                session.setAttribute("tipo",logindao.getUsu().getTipo());
                session.setAttribute("conexao", conexao);
                session.setMaxInactiveInterval(10*60); // 10 minutos de inatividade                
                response.sendRedirect("autenticado/index.jsp");
            }else{
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");                
                out.println("<div class='alert alert-danger'><p class='text-danger text-center'>Usuário ou senha inválidos!</p></div>");
                rd.include(request, response);        
            }
        } catch (SQLException ex) {
            out.print("<script> alert('SEM CONEXÃO COM O BANCO!');</script>");            
        }
                
    }

}
