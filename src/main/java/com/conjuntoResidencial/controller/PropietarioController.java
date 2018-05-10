/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.controller;


import com.conjuntoResidencial.dao.PropietarioDAO.PropietarioDAOImpl;
import com.conjuntoResidencial.model.Propietario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kubic
 */
@WebServlet(name = "PropietarioController", urlPatterns = {"/Propitario"})
public class PropietarioController extends HttpServlet {

    private PropietarioDAOImpl propietarioimpl = new PropietarioDAOImpl();
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
            out.println("<title>Servlet PropietarioController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PropietarioController at " + request.getContextPath() + "</h1>");
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
            this.deletePropietario(request.getParameter());
        }
        this.mostrarPropietario(request, response);
        
    }
    
    public void mostrarPropietario(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Propietario> propietarios = this.propietarioimpl.findAll();
        request.setAttribute("propietarios", propietarios);
        request.getRequestDispatcher("/Propietario.jsp").forward(request, response);
    }
    public void deletePropietario(Propietario asdf) {
        this.propietarioimpl.deleteById(asdf);
    }
    
    public void savePropietario(HttpServletRequest request, HttpServletResponse response) {

        Propietario propietario = new Propietario();
        

        this.propietarioimpl.save(propietario);
    }
    
     public void actualizarPropietario(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        Propietario propietario = new Propietario();
        

        
         System.out.println("Actualizo Propietario");
        this.propietarioimpl.update(propietario);
        
        
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
            this.savePropietario(request, response);
        }
        
         if(param!=null && param.equals("editar")) {
            this.actualizarPropietario(request, response);
        }
    
        this.mostrarPropietarios(request, response);
        
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