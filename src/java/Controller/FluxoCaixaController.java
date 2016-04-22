package Controller;

import DAO.FluxoCaixaDAO;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "fluxoCaixaController", urlPatterns = {"/fluxoCaixaController"})
public class FluxoCaixaController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        MySqlController conexao = (MySqlController) session.getAttribute("conexao");
        FluxoCaixaDAO registrodao = new FluxoCaixaDAO(conexao);
        boolean movimentacao;

        if ("entrada".equals(request.getParameter("movimentacao"))) {
            movimentacao = true;
        } else {
            movimentacao = false;
        }

        registrodao.criarRegistro(getData(), getHora(), request.getParameter("descricao"), movimentacao, Float.parseFloat(request.getParameter("valor")));
        response.sendRedirect("fluxoCaixa.jsp");
    }

    public String getHora() {
        StringBuilder sb = new StringBuilder();
        GregorianCalendar d = new GregorianCalendar();

        sb.append(d.get(GregorianCalendar.HOUR_OF_DAY));
        sb.append(":");
        sb.append(d.get(GregorianCalendar.MINUTE));

        return sb.toString();
    }
    
    public String getData() {
        StringBuilder sb = new StringBuilder();
        GregorianCalendar d = new GregorianCalendar();

        sb.append(d.get(GregorianCalendar.DAY_OF_MONTH));
        sb.append("/");
        sb.append(d.get(GregorianCalendar.MONTH));
        sb.append("/");
        sb.append(d.get(GregorianCalendar.YEAR));
        

        return sb.toString();
    }
}
