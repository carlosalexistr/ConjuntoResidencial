/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.controller;

import com.conjuntoResidencial.dao.PersonaDAO.PersonaDAOImpl;
import com.conjuntoResidencial.dao.TipoDAO.TipoDAOImpl;
import com.conjuntoResidencial.dao.ViviendaDAO.ViviendaDAOImpl;
import com.conjuntoResidencial.model.Vivienda;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julian Olarte Torres
 */
@WebServlet(name = "ViviendaController", urlPatterns = {"/Vivienda"})
public class ViviendaController extends HttpServlet {

    private ViviendaDAOImpl viviendaimpl = new ViviendaDAOImpl();
    private PersonaDAOImpl personaimpl = new PersonaDAOImpl();
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
            out.println("<title>Servlet ViviendaController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViviendaController at " + request.getContextPath() + "</h1>");
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
            this.deleteVivienda(Integer.parseInt(request.getParameter("id")));
        }
        this.mostrarResultados(request, response);
    }
    
    public void mostrarResultados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("personas", this.personaimpl.findAll());
        request.setAttribute("tipos", this.tipoimpl.findAll());
        request.setAttribute("viviendas", this.viviendaimpl.findAll());
        
        request.getRequestDispatcher("/Vivienda.jsp").forward(request, response);
    }
    
    public void deleteVivienda(int number) {
        this.viviendaimpl.deleteById(number);
    }
    
    public void saveVivienda(HttpServletRequest request, HttpServletResponse response) {
        int numero = Integer.parseInt(request.getParameter("numero"));
        int tipo = Integer.parseInt(request.getParameter("tipo"));
        String responsable = request.getParameter("responsable");
        String observacion = request.getParameter("observacion");
        
        Vivienda vivienda = new Vivienda();
        vivienda.setNumero(numero);
        vivienda.setObservacion(observacion);
        vivienda.setResponsable(this.personaimpl.findById(responsable));
        vivienda.setTipo(this.tipoimpl.findById(tipo));
       this.viviendaimpl.save(vivienda);
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
            this.saveVivienda(request, response);
        }
        this.mostrarResultados(request, response);
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
