/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.controller;

import com.conjuntoResidencial.dao.ServicioDAO.ServicioDAOImpl;
import com.conjuntoResidencial.model.Servicio;
import com.conjuntoResidencial.model.Solicitud;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kubic
 */
@WebServlet(name = "ServicioController", urlPatterns = {"/Servicio"})
public class ServicioController {
    private  ServicioDAOImpl servicioimpl=new ServicioDAOImpl();
    
    
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServicioController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServicioController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("action");
        if(param!=null && param.equals("delete")) {
            this.deleteServicio(Integer.parseInt(request.getParameter("id")));
        }
        this.mostrarServicios(request, response);
        
    }
    
    public void mostrarServicios(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Servicio> servicios = this.servicioimpl.findAll();
        request.setAttribute("servicios", servicios);
        request.getRequestDispatcher("/Servicio.jsp").forward(request, response);
    }
    public void deleteServicio(int id) {
        this.servicioimpl.deleteById(id);
    }
    
    public void saveServicio(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
        String observacion = request.getParameter("observacion");
        int valor = Integer.parseInt(request.getParameter("valor"));
        Boolean estado = Boolean.parseBoolean(request.getParameter("estado"));
        //List<Solicitud> = request.getParameter("solicitud");
        Servicio servicio = new Servicio();
        
        servicio.setId(id);
        servicio.setDescripcion(descripcion);
        servicio.setObservacion(observacion);
        servicio.setValor(valor);
        servicio.setEstado(estado);
        //servicio.setSolicitudList(solicitudList);
        this.servicioimpl.save(servicio);
    }
    
     public void actualizarServicio(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
        String observacion = request.getParameter("observacion");
        int valor = Integer.parseInt(request.getParameter("valor"));
        Boolean estado = Boolean.parseBoolean(request.getParameter("estado"));
        Servicio servicio = new Servicio();
        
        servicio.setId(id);
        servicio.setDescripcion(descripcion);
        servicio.setObservacion(observacion);
        servicio.setValor(valor);
        servicio.setEstado(estado);
        
        
         System.out.println("actualizo servicio");
        this.servicioimpl.update(servicio);
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("action");
        if(param!=null && param.equals("save")) {
            this.saveServicio(request, response);
        }
        
         if(param!=null && param.equals("editar")) {
            this.actualizarServicio(request, response);
        }
    
        this.mostrarServicios(request, response);
        
    }
    
   

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
