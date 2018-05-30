/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.controller;

import com.conjuntoResidencial.controller.AsambleaController;
import com.conjuntoResidencial.controller.AsambleaController;
import com.conjuntoResidencial.dao.SolicitudDAO.SolicitudDAOImpl;
import com.conjuntoResidencial.dao.ViviendaDAO.ViviendaDAOImpl;
import com.conjuntoResidencial.model.Solicitud;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
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
@WebServlet(name = "SolicitudController", urlPatterns = {"/Solicitud"})
public class SolicitudController extends HttpServlet {
    
    SolicitudDAOImpl solicitudImpl = new SolicitudDAOImpl();
    ViviendaDAOImpl viviendaImpl = new ViviendaDAOImpl();

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
            out.println("<title>Servlet SolicitudController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SolicitudController at " + request.getContextPath() + "</h1>");
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
            eliminarSolicitud(Integer.parseInt(request.getParameter("id")));
        }
        mostrarRegistros(request, response);
        
    }
    
   public void mostrarRegistros(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Solicitud> solicitudes = solicitudImpl.findAll();
        request.setAttribute("solicitudes", solicitudes);
        request.getRequestDispatcher("/Solicitud.jsp").forward(request, response);
    }

    public void registrarSolicitud(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        Solicitud solicitud = new Solicitud();
        solicitud.setNumero(Integer.parseInt(request.getParameter("numero")));
        solicitud.setFechasolicitud(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaSolicitud")));
        solicitud.setFechanecesidad(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaNecesidad")));
        solicitud.setEstado(request.getParameter("estado"));
        solicitud.setUsuario(request.getParameter("usuario"));
        solicitud.setVivienda(viviendaImpl.findById(Integer.parseInt(request.getParameter("vivienda"))));
        solicitudImpl.save(solicitud);
    }
    
    public void editarSolicitud(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        Solicitud solicitud = new Solicitud();
        solicitud.setNumero(Integer.parseInt(request.getParameter("numero")));
        solicitud.setFechasolicitud(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaSolicitud")));
        solicitud.setFechanecesidad(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaNecesidad")));
        solicitud.setEstado(request.getParameter("estado"));
        solicitud.setUsuario(request.getParameter("usuario"));
        solicitud.setVivienda(viviendaImpl.findById(Integer.parseInt(request.getParameter("vivienda"))));
        solicitudImpl.update(solicitud);
    }
    
    public void eliminarSolicitud(int id)
            throws ServletException, IOException {
        this.solicitudImpl.deleteById(id);
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
                registrarSolicitud(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(AsambleaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(param!=null && param.equals("editar")) {
            try {
                editarSolicitud(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(AsambleaController.class.getName()).log(Level.SEVERE, null, ex);
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
