/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.controller;

import com.conjuntoResidencial.dao.AsambleaDAO.AsambleaDAOImpl;
import com.conjuntoResidencial.dao.AsistenciaDAO.AsistenciaDAO;
import com.conjuntoResidencial.dao.AsistenciaDAO.AsistenciaDAOImpl;
import com.conjuntoResidencial.dao.ViviendaDAO.ViviendaDAOImpl;
import com.conjuntoResidencial.model.Asamblea;
import com.conjuntoResidencial.model.Asistencia;
import com.conjuntoResidencial.model.AsistenciaPK;
import com.conjuntoResidencial.model.Vivienda;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
 * @author Julian Olarte Torres
 */
@WebServlet(name="AsistenciaController", urlPatterns={"/Asistencia"})
public class AsistenciaController extends HttpServlet {

    AsistenciaDAO asistenciaimpl = new AsistenciaDAOImpl();
    AsambleaDAOImpl asambleaimpl = new AsambleaDAOImpl();
    ViviendaDAOImpl viviendaimpl = new ViviendaDAOImpl();
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
            out.println("<title>Servlet AsambleaController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AsambleaController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
            eliminarAsitencia(Integer.parseInt(request.getParameter("asamblea")), Integer.parseInt(request.getParameter("vivienda")));
        }
        mostrarRegistros(request, response);
        
    }
    
   public void mostrarRegistros(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Asistencia> asistencias = this.asistenciaimpl.findAll();
        List<Asamblea> asambleas = this.asambleaimpl.findAll();
        List<Vivienda> viviendas = this.viviendaimpl.findAll();
        request.setAttribute("asistencias", asistencias);
        request.setAttribute("viviendas", viviendas);
        request.setAttribute("asambleas", asambleas);
        request.getRequestDispatcher("/Asistencia.jsp").forward(request, response);
    }

    public void registrarAsistencia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        Asistencia asistencia = new Asistencia(Integer.parseInt(request.getParameter("asamblea")), Integer.parseInt(request.getParameter("vivienda")));
        asistencia.setObservacion(request.getParameter("observacion"));
        asistencia.setAsistio(null!=request.getParameter("asistio"));
        this.asistenciaimpl.save(asistencia);
    }
    
    public void editarAsistencia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        Asistencia asistencia = new Asistencia(Integer.parseInt(request.getParameter("asamblea")), Integer.parseInt(request.getParameter("vivienda")));
        asistencia.setObservacion(request.getParameter("observacion"));
        asistencia.setAsistio(null!=request.getParameter("asistio"));
        this.asistenciaimpl.update(asistencia);
    }
    
    public void eliminarAsitencia(int asamblea, int vivienda)
            throws ServletException, IOException {
        this.asistenciaimpl.deleteById(new AsistenciaPK(asamblea, vivienda));
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
                registrarAsistencia(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(AsambleaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(param!=null && param.equals("editar")) {
            try {
                editarAsistencia(request, response);
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
