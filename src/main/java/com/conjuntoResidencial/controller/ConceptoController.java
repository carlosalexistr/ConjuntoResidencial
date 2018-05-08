/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.controller;
import com.conjuntoResidencial.dao.ConceptoDAO.ConceptoDAOImpl;
import com.conjuntoResidencial.model.Concepto;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
@WebServlet(name = "ConceptoController", urlPatterns = {"/Concepto"})
public class ConceptoController extends HttpServlet {

    ConceptoDAOImpl conceptoImpl = new ConceptoDAOImpl();
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
        }
    }

    public void mostrarResultados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("conceptos", this.conceptoImpl.findAll());
        request.getRequestDispatcher("/Concepto.jsp").forward(request, response);
    }
      public void deleteConcepto(int number) {
        this.conceptoImpl.deleteById(number);
    }
    
    public void registrarConcepto(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
        boolean estado = null!=request.getParameter("estado");
        
        Concepto concepto = new Concepto();
        concepto.setId(id);
        concepto.setDescripcion(descripcion);
        concepto.setEstado(estado);
        
        this.conceptoImpl.save(concepto);
    }
    
    public void editarConcepto(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
        boolean estado = null!=request.getParameter("estado");
        
        Concepto concepto = new Concepto();
        concepto.setId(id);
        concepto.setDescripcion(descripcion);
        concepto.setEstado(estado);
        
        this.conceptoImpl.save(concepto);
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
            this.deleteConcepto(Integer.parseInt(request.getParameter("id")));
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
                this.registrarConcepto(request, response);
            }
            if(param!=null && param.equals("editar")) {
                this.editarConcepto(request, response);
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
