/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.controller;

import com.conjuntoResidencial.dao.InquilinoDAO.InquilinoDAOImpl;
import com.conjuntoResidencial.dao.PersonaDAO.PersonaDAOImpl;
import com.conjuntoResidencial.dao.ViviendaDAO.ViviendaDAOImpl;
import com.conjuntoResidencial.model.Inquilino;
import com.conjuntoResidencial.model.InquilinoPK;
import com.conjuntoResidencial.model.Persona;
import com.conjuntoResidencial.model.Vivienda;
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
 * @author DELL
 */
@WebServlet(name = "InquilinoController", urlPatterns = {"/Inquilino"})
public class InquilinoController extends HttpServlet {

    ViviendaDAOImpl viviendaimpl = new ViviendaDAOImpl();
    PersonaDAOImpl peresonaImpl = new PersonaDAOImpl();
    InquilinoDAOImpl inquilinoImpl = new InquilinoDAOImpl();

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
            out.println("<title>Servlet InquilinoController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InquilinoController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public void mostrarResultados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("persona", this.peresonaImpl.findAll());
        request.setAttribute("viviendas", this.viviendaimpl.findAll());
        request.setAttribute("inquilino", this.inquilinoImpl.findAll());

        request.getRequestDispatcher("/Inquilino.jsp").forward(request, response);
    }

    public void deleteInquilino(int vivienda, String persona, Date fechaI) {
        
        InquilinoPK inquiPK = new InquilinoPK(vivienda, persona, fechaI);
        System.out.println("recivido:  "+vivienda + persona + fechaI);

          inquilinoImpl.deleteById(inquiPK);
    }

    public void registrarInquilino(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        String fecha = request.getParameter("fechaF");
        String fechaI = request.getParameter("fecha");
        Persona p = new Persona();
        p=peresonaImpl.findById(request.getParameter("cabeza"));
        Vivienda v = new Vivienda();
        
        v= viviendaimpl.findById(Integer.parseInt(request.getParameter("vivienda")));

        Inquilino inquilino = new Inquilino();
        inquilino.setFechafin(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
        inquilino.setPersona1(p);
        inquilino.setVivienda1(v);
        inquilino.setResponsable(Integer.parseInt(request.getParameter("responsable")));
        InquilinoPK inquilinoPk = new InquilinoPK();
        inquilinoPk.setFechainicio(new SimpleDateFormat("yyyy-MM-dd").parse(fechaI));
        inquilinoPk.setPersona(p.getDocumento());
        inquilinoPk.setVivienda(v.getNumero());
        
        inquilino.setInquilinoPK(inquilinoPk);
        inquilinoImpl.save(inquilino);

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
            System.out.println("DATOOSSS:  " + request.getParameter("vivienda") +" - "+ request.getParameter("persona") + " - " + request.getParameter("fechai"));
            int vivienda = Integer.parseInt(request.getParameter("vivienda"));
            String persona = request.getParameter("persona");
             try {
                 Date fechaI = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechai"));
                 System.out.println("fechaaa: " + fechaI);
                 deleteInquilino(vivienda, persona, fechaI);
             } catch (ParseException ex) {
                 Logger.getLogger(InquilinoController.class.getName()).log(Level.SEVERE, null, ex);
             }           
        }
        mostrarResultados(request, response);
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
                this.registrarInquilino(request, response);
            }
        } catch (ParseException ex) {
            Logger.getLogger(MultaController.class.getName()).log(Level.SEVERE, null, ex);
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
