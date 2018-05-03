/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.controller;

import com.conjuntoResidencial.dao.PersonaDAO.PersonaDAOImpl;
import com.conjuntoResidencial.dao.ReciboDAO.ReciboDAOImpl;
import com.conjuntoResidencial.dao.TipoDAO.TipoDAOImpl;
import com.conjuntoResidencial.dao.ViviendaDAO.ViviendaDAOImpl;
import com.conjuntoResidencial.model.Recibo;
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
 * @author Julian Olarte Torres
 */
@WebServlet(name = "ReciboController", urlPatterns = {"/Recibo"})
public class ReciboController extends HttpServlet {

    private ReciboDAOImpl reciboimpl = new ReciboDAOImpl();
    private PersonaDAOImpl personaimpl = new PersonaDAOImpl();
    private TipoDAOImpl tipoimpl = new TipoDAOImpl();
    private ViviendaDAOImpl viviendaimpl = new ViviendaDAOImpl();
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
            out.println("<title>Servlet ReciboController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReciboController at " + request.getContextPath() + "</h1>");
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
            this.deleteRecibo(Integer.parseInt(request.getParameter("id")));
        }
        this.mostrarResultados(request, response);
    }
    
    public void mostrarResultados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("personas", this.personaimpl.findAll());
        request.setAttribute("viviendas", this.viviendaimpl.findAll());
        request.setAttribute("recibos", this.reciboimpl.findAll());
        
        request.getRequestDispatcher("/Recibo.jsp").forward(request, response);
    }
    
    public void deleteRecibo(int number) {
        this.reciboimpl.deleteById(number);
    }
    
    public void saveRecibo(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        int numero = Integer.parseInt(request.getParameter("numero"));
        int vivienda = Integer.parseInt(request.getParameter("vivienda"));
        String fecha = request.getParameter("fecha");
        String responsable = request.getParameter("responsable");
        int valor = Integer.parseInt(request.getParameter("valor"));
        String usuario = request.getParameter("usuario");
        
        Recibo recibo = new Recibo();
        recibo.setNumero(numero);
        recibo.setVivienda(this.viviendaimpl.findById(vivienda));
        recibo.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
        recibo.setResponsable(this.personaimpl.findById(responsable));
        recibo.setValor(valor);
        recibo.setUsuario(usuario);
        
       this.reciboimpl.save(recibo);
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
                this.saveRecibo(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(ReciboController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
