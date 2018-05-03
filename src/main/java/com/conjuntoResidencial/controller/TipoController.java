/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.controller;

import com.conjuntoResidencial.dao.TipoDAO.TipoDAOImpl;
import com.conjuntoResidencial.model.Persona;
import com.conjuntoResidencial.model.Tipo;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julian Olarte Torres
 */
@WebServlet(name = "TipoController", urlPatterns = {"/Tipo"})
public class TipoController extends HttpServlet {

    private TipoDAOImpl tipoimpl = new TipoDAOImpl();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TipoController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TipoController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("action");
        if(param!=null && param.equals("delete")) {
            this.eliminarTipo(Integer.parseInt(request.getParameter("id")));
        }
        this.mostrarTipos(request, response);
        
    }
    
    public void mostrarTipos(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Tipo> tipos = this.tipoimpl.findAll();
        request.setAttribute("tipos", tipos);
        request.getRequestDispatcher("/Tipo.jsp").forward(request, response);
    }
    
    public void eliminarTipo(int id) {
        this.tipoimpl.deleteById(id);
    }
    
    public void saveTipo(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        BigDecimal medida = new BigDecimal(request.getParameter("medida"));
        Integer condominio = Integer.parseInt(request.getParameter("condominio"));
        Tipo tipo = new Tipo();
        
        tipo.setId(id);
        tipo.setMedida(medida);
        tipo.setCondominio(condominio);
        this.tipoimpl.save(tipo);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("action");
        if(param!=null && param.equals("save")) {
            this.saveTipo(request, response);
        }
        this.mostrarTipos(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
