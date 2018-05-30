/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.controller;


import com.conjuntoResidencial.dao.ServicioDAO.ServicioDAOImpl;
import com.conjuntoResidencial.model.Servicio;

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
 * @author Carlos
 */
@WebServlet(name = "ServicioControlller", urlPatterns = {"/Servicio"})
public class ServicioController extends HttpServlet {
    
    ServicioDAOImpl servicioimpl = new ServicioDAOImpl();

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
            out.println("<title>Servlet ServicioControlller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServicioControlller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public void mostrarRegistros(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("servicios", this.servicioimpl.findAll());
        request.getRequestDispatcher("/Servicio.jsp").forward(request, response);
    }
    
      public void deleteServicio(int number) {
        this.servicioimpl.deleteById(number);
    }
    
    public void registrarServcio(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        
        
        boolean estado = null!=request.getParameter("estado");
        
        Servicio servicio = new Servicio();
        
        servicio.setId(Integer.parseInt(request.getParameter("id")));
        servicio.setDescripcion(request.getParameter("descripcion"));
        servicio.setObservacion(request.getParameter("observacion"));
        servicio.setValor(Integer.parseInt(request.getParameter("valor")));
        servicio.setEstado(estado);
        
     
        
        this.servicioimpl.save(servicio);
    }
    
    public void editarServicio(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        boolean estado = null!=request.getParameter("estado");
        
        Servicio servicio = new Servicio();
        
        servicio.setId(Integer.parseInt(request.getParameter("id")));
        servicio.setDescripcion(request.getParameter("descripcion"));
        servicio.setObservacion(request.getParameter("observacion"));
        servicio.setValor(Integer.parseInt(request.getParameter("valor")));
        servicio.setEstado(estado);
        
     
        
        this.servicioimpl.update(servicio);
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
            this.deleteServicio(Integer.parseInt(request.getParameter("id")));
        }
        this.mostrarRegistros(request, response);
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
            try {
                registrarServcio(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(param!=null && param.equals("editar")) {
            try {
                editarServicio(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        mostrarRegistros(request, response);
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
