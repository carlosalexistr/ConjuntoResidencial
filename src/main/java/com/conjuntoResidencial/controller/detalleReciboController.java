/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.controller;

import com.conjuntoResidencial.dao.ConceptoDAO.ConceptoDAOImpl;
import com.conjuntoResidencial.dao.DetalleReciboDAO.DetalleReciboDAOImpl;
import com.conjuntoResidencial.dao.ReciboDAO.ReciboDAOImpl;
import com.conjuntoResidencial.model.Detallerecibo;
import com.conjuntoResidencial.model.DetallereciboPK;
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
@WebServlet(name = "DetalleReciboController", urlPatterns = {"/DetalleRecibo"})
public class detalleReciboController extends HttpServlet {

    private DetalleReciboDAOImpl detalleimpl = new DetalleReciboDAOImpl();
    private ReciboDAOImpl reciboimpl = new ReciboDAOImpl();
    private ConceptoDAOImpl conceptoimpl = new ConceptoDAOImpl();
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
            out.println("<title>Servlet detalleReciboController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet detalleReciboController at " + request.getContextPath() + "</h1>");
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
            eliminarDetalle(request);
        }
        mostrarRegistros(request, response);
        
    }
    
   public void mostrarRegistros(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Detallerecibo> detalles = detalleimpl.findAll();
        request.setAttribute("detalles", detalles);
        request.setAttribute("conceptos", conceptoimpl.findAll());
        request.setAttribute("recibos", reciboimpl.findAll());
        request.getRequestDispatcher("/DetalleRecibo.jsp").forward(request, response);
    }

    public void registrarDetalle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        int recibo = Integer.parseInt(request.getParameter("recibo"));
        int concepto = Integer.parseInt(request.getParameter("concepto"));
        int valor = Integer.parseInt(request.getParameter("valor"));
        String usuario = request.getParameter("usuario");
        String observacion = request.getParameter("observacion");
        
        Detallerecibo detalle = new Detallerecibo(new DetallereciboPK(recibo, concepto));
        detalle.setUsuario(usuario);
        detalle.setValor(valor);
        detalle.setObservacion(observacion);
        this.detalleimpl.save(detalle);
    }
    
    public void editarDetalle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        int recibo = Integer.parseInt(request.getParameter("recibo"));
        int concepto = Integer.parseInt(request.getParameter("concepto"));
        int valor = Integer.parseInt(request.getParameter("valor"));
        String usuario = request.getParameter("usuario");
        String observacion = request.getParameter("observacion");
        
        Detallerecibo detalle = new Detallerecibo(new DetallereciboPK(recibo, concepto));
        detalle.setUsuario(usuario);
        detalle.setValor(valor);
        detalle.setObservacion(observacion);
        this.detalleimpl.update(detalle);
    }
    
    public void eliminarDetalle(HttpServletRequest request)
            throws ServletException, IOException {
        int recibo = Integer.parseInt(request.getParameter("recibo"));
        int concepto = Integer.parseInt(request.getParameter("concepto"));
        this.detalleimpl.deleteById(new DetallereciboPK(recibo, concepto));
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
                registrarDetalle(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(AsambleaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(param!=null && param.equals("editar")) {
            try {
                editarDetalle(request, response);
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
