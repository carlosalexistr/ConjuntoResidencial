/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.controller;

import com.conjuntoResidencial.dao.PersonaDAO.PersonaDAOImpl;
import com.conjuntoResidencial.dao.PropietarioDAO.PropietarioDAOImpl;
import com.conjuntoResidencial.dao.ViviendaDAO.ViviendaDAOImpl;
import com.conjuntoResidencial.model.Persona;
import com.conjuntoResidencial.model.Propietario;
import com.conjuntoResidencial.model.PropietarioPK;
import com.conjuntoResidencial.model.Vivienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "PropietarioController", urlPatterns = {"/Propietario"})
public class PropietarioController extends HttpServlet {

    PropietarioDAOImpl propietarioimpl = new PropietarioDAOImpl();
    ViviendaDAOImpl viviendaimpl = new ViviendaDAOImpl();
    PersonaDAOImpl personaImpl = new PersonaDAOImpl();

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
        if (param != null && param.equals("delete")) {
            try {
                eliminarPropietario(Integer.parseInt(request.getParameter("vivienda")), request.getParameter("persona"), new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha")));
            } catch (ParseException ex) {
                Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        mostrarRegistros(request, response);
    }

    public void mostrarRegistros(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Propietario> propietarios = this.propietarioimpl.findAll();
        
        
        request.setAttribute("persona", this.personaImpl.findAll());
        request.setAttribute("viviendas", this.viviendaimpl.findAll());
        request.setAttribute("propietario", this.propietarioimpl.findAll());
        
        request.getRequestDispatcher("/Propietario.jsp").forward(request, response);
    }

    public void registrarPropietarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        Propietario propietario = new Propietario(Integer.parseInt(request.getParameter("vivienda")), request.getParameter("persona"), new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaInicio")));
        propietario.setResponsable(Integer.parseInt(request.getParameter("responsable")));
        propietario.setFechafin(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaFin")));
        this.propietarioimpl.save(propietario);
    }

    public void editarPropietario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        Propietario propietario = new Propietario(Integer.parseInt(request.getParameter("vivienda")), request.getParameter("persona"), new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaInicio")));
        propietario.setResponsable(Integer.parseInt(request.getParameter("responsable")));
         propietario.setFechafin(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaFin")));
        this.propietarioimpl.update(propietario);;
    }

    public void eliminarPropietario(int vivienda, String persona, Date fechainicio)
            throws ServletException, IOException {
        this.propietarioimpl.deleteById(new PropietarioPK(vivienda, persona, fechainicio));

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
        if (param != null && param.equals("save")) {
            try {
                registrarPropietarios(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (param != null && param.equals("editar")) {
            try {
                editarPropietario(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
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
