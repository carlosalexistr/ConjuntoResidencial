/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.controller;

import com.conjuntoResidencial.dao.MultaDAO.MultaDAOImpl;
import com.conjuntoResidencial.dao.ReciboDAO.ReciboDAOImpl;
import com.conjuntoResidencial.dao.ViviendaDAO.ViviendaDAOImpl;
import com.conjuntoResidencial.model.Multa;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "MultaController", urlPatterns = {"/Multa"})
public class MultaController extends HttpServlet {

    private ReciboDAOImpl reciboimpl = new ReciboDAOImpl();
    private ViviendaDAOImpl viviendaimpl = new ViviendaDAOImpl();
    private MultaDAOImpl multaimpl = new MultaDAOImpl();
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
            out.println("<title>Servlet MultaController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MultaController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    public void mostrarResultados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("multas", this.multaimpl.findAll());
        request.setAttribute("recibos", this.reciboimpl.findAll());
        request.setAttribute("viviendas", this.viviendaimpl.findAll());
        
        request.getRequestDispatcher("/Multa.jsp").forward(request, response);
    }
      public void deleteMulta(int number) {
        this.multaimpl.deleteById(number);
    }
    
    public void registrarMulta(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        int numero = Integer.parseInt(request.getParameter("numero"));
        int vivienda = Integer.parseInt(request.getParameter("vivienda"));
        String fecha = request.getParameter("fecha");
        String observacion = request.getParameter("observacion");
        int recibo = Integer.parseInt(request.getParameter("recibo"));
        String usuario = request.getParameter("usuario");
        
        Multa multa = new Multa();
        multa.setNumero(numero);
        multa.setVivienda(this.viviendaimpl.findById(vivienda));
        multa.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
        multa.setObservacion(observacion);
        multa.setRecibo(this.reciboimpl.findById(recibo));
        multa.setUsuario(usuario);
        
       this.multaimpl.save(multa);
    }
    
     public void actualizarMulta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
         
         int numero = Integer.parseInt(request.getParameter("numero"));
        int vivienda = Integer.parseInt(request.getParameter("vivienda"));
        String fecha = request.getParameter("fecha");
        String observacion = request.getParameter("observacion");
        int recibo = Integer.parseInt(request.getParameter("recibo"));
        String usuario = request.getParameter("usuario");
        
        Multa multa = new Multa();
        multa.setNumero(numero);
        multa.setVivienda(this.viviendaimpl.findById(vivienda));
        multa.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
        multa.setObservacion(observacion);
        multa.setRecibo(this.reciboimpl.findById(recibo));
        multa.setUsuario(usuario);
        
       this.multaimpl.update(multa);
         
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
            this.deleteMulta(Integer.parseInt(request.getParameter("id")));
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
                this.registrarMulta(request, response);
            }
             if(param!=null && param.equals("editar")) {
             this.actualizarMulta(request, response);
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
