/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.controller;

import com.conjuntoResidencial.dao.CargoDAO.CargoDAOImpl;
import com.conjuntoResidencial.dao.ConsejoDAO.ConsejoDAOImpl;
import com.conjuntoResidencial.dao.PersonaDAO.PersonaDAOImpl;
import com.conjuntoResidencial.model.Consejo;
import com.conjuntoResidencial.model.ConsejoPK;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author julianolarte
 */
@WebServlet(name = "ConsejoController", urlPatterns = {"/Consejo"})
public class ConsejoController extends HttpServlet {

    private ConsejoDAOImpl consejoimpl = new ConsejoDAOImpl();
    private PersonaDAOImpl personaimpl = new PersonaDAOImpl();
    private CargoDAOImpl cargoimpl = new CargoDAOImpl();
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
            out.println("<title>Servlet ConsejoController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsejoController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public void mostrarResultados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("consejos", this.consejoimpl.findAll());
        request.setAttribute("personas", this.personaimpl.findAll());
        request.setAttribute("cargos", this.cargoimpl.findAll());
        request.getRequestDispatcher("/Consejo.jsp").forward(request, response);
    }
      public void deleteConsejo(HttpServletRequest request) throws ParseException {
        String persona = request.getParameter("persona");
        int cargo = Integer.parseInt(request.getParameter("cargo"));
        
        Date fechainicio = new Date(Long.valueOf(request.getParameter("fechainicio")));
        this.consejoimpl.deleteById(new ConsejoPK(persona, cargo, fechainicio));
    }
    
    public void registrarConsejo(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        String persona = request.getParameter("persona");
        int cargo = Integer.parseInt(request.getParameter("cargo"));
        Date fechainicio = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechainicio"));
        Date fechafin = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechafin"));
        
        Consejo consejo = new Consejo(persona, cargo, fechainicio);
        consejo.setFechafin(fechafin);
        
        this.consejoimpl.save(consejo);
    }
    
    public void editarConsejo(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        String persona = request.getParameter("persona");
        int cargo = Integer.parseInt(request.getParameter("cargo"));
        Date fechainicio = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechainicio"));
        Date fechafin = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechafin"));
        
        Consejo consejo = new Consejo(persona, cargo, fechainicio);
        consejo.setFechafin(fechafin);
        
        this.consejoimpl.update(consejo);
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
            try {
                this.deleteConsejo(request);
            } catch (ParseException ex) {
                Logger.getLogger(ConsejoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.mostrarResultados(request, response);
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
        try {
            String param = request.getParameter("action");
            if(param!=null && param.equals("save")) {
                this.registrarConsejo(request, response);
            }
            if(param!=null && param.equals("editar")) {
                this.editarConsejo(request, response);
            }
        } catch (ParseException ex) {
            Logger.getLogger(PagoController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR: " + ex.getMessage());
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
