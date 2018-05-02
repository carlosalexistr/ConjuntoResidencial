/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.controller;

import com.conjuntoResidencial.dao.AsambleaDAO.AsambleaDAOImpl;
import com.conjuntoResidencial.model.Asamblea;
import com.conjuntoResidencial.model.Parentesco;
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
 * @author Julian Olarte Torres
 */
@WebServlet(name="AsambleaController", urlPatterns={"/Asamblea"})
public class AsambleaController extends HttpServlet {

    AsambleaDAOImpl asambleaImpl = new AsambleaDAOImpl();
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
            eliminarAsamblea(Integer.parseInt(request.getParameter("id")));
        }
        mostrarRegistros(request, response);
        
    }
    
   public void mostrarRegistros(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Asamblea> asambleas = asambleaImpl.findAll();
        request.setAttribute("asambleas", asambleas);
        request.getRequestDispatcher("/Asambleas.jsp").forward(request, response);
    }

    public void registrarAsamblea(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        Asamblea asamblea = new Asamblea();
        asamblea.setDescripcion(request.getParameter("descripcion"));
        asamblea.setId(Integer.parseInt(request.getParameter("id")));
        asamblea.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha")));
        asamblea.setLugar(request.getParameter("lugar"));
        asambleaImpl.save(asamblea);
    }
    
    public void eliminarAsamblea(int id)
            throws ServletException, IOException {
        
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
                registrarAsamblea(request, response);
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
