package br.pucpcaldas.inf.lc.deliverit.controller;

import br.pucpcaldas.inf.lc.deliverit.dao.RegrasNegocioDAO;
import br.pucpcaldas.inf.lc.deliverit.model.RegrasNegocio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RegrasNegocioController", urlPatterns = {"/RegrasNegocioController"})
public class RegrasNegocioController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RegrasNegocio rn;
        
        HttpSession session = request.getSession();
        MySqlController conexao = (MySqlController) session.getAttribute("conexao");
        RegrasNegocioDAO regrasNegocioDAO = new RegrasNegocioDAO(conexao);
        String botao = request.getParameter("button");
        
        switch (botao) {
            case "registrarPQ":
                rn = new RegrasNegocio(0, Integer.parseInt(request.getParameter("produtos")), Integer.parseInt(request.getParameter("quantidade")),
                        Float.parseFloat(request.getParameter("porcentagem")));
                regrasNegocioDAO.criarRegraNegocio(rn);
                break;
            case "registrarCP":
                rn = new RegrasNegocio(1, Integer.parseInt(request.getParameter("categorias")), Float.parseFloat(request.getParameter("precomin")),
                        Float.parseFloat(request.getParameter("porcentagem")));
                regrasNegocioDAO.criarRegraNegocio(rn);
                break;
            case "registrarPP":                  
                rn = new RegrasNegocio(2, Float.parseFloat(request.getParameter("precomin")),
                        Float.parseFloat(request.getParameter("porcentagem")));
                regrasNegocioDAO.criarRegraNegocio(rn);
                break;
            case "registrarPD":                  
                rn = new RegrasNegocio(3, Float.parseFloat(request.getParameter("distancia")),
                        Float.parseFloat(request.getParameter("porcentagem")));
                regrasNegocioDAO.criarRegraNegocio(rn);
                break;
            }
        response.sendRedirect("categoria.jsp");
    }
}
