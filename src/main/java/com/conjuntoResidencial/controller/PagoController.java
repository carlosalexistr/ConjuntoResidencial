/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.controller;

import com.conjuntoResidencial.dao.PagoDAO.PagoDAOImp;
import com.conjuntoResidencial.dao.PersonaDAO.PersonaDAOImpl;
import com.conjuntoResidencial.dao.ReciboDAO.ReciboDAOImpl;
import com.conjuntoResidencial.model.Pago;
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
@WebServlet(name = "PagoController", urlPatterns = {"/Pago"})
public class PagoController extends HttpServlet {
    
    ReciboDAOImpl reciboImpl = new ReciboDAOImpl();
    PersonaDAOImpl personaImpl = new PersonaDAOImpl();
    PagoDAOImp pagoImpl = new PagoDAOImp();

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
            out.println("<title>Servlet PagoController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PagoController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    public void mostrarResultados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("persona", this.personaImpl.findAll());
        request.setAttribute("recibo", this.reciboImpl.findAll());
        request.setAttribute("pago", this.pagoImpl.findAll());

        
        request.getRequestDispatcher("/Pago.jsp").forward(request, response);
    }
      public void deletePago(int number) {
        this.pagoImpl.deleteById(number);
    }
    
    public void registrarPago(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        int numero = Integer.parseInt(request.getParameter("id"));
        String fecha = request.getParameter("fecha");
        int recibo = Integer.parseInt(request.getParameter("recibo"));
        String tipo = request.getParameter("tipo");
        String usuario = request.getParameter("usuario");
     //   Long valor = Long.parseLong(request.getParameter("valor"));
     
        System.out.println("DATOOOOSSS: " + usuario);
     
        Pago pago = new Pago();
        pago.setFechapago(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
        pago.setNumero(numero);
        pago.setRecibo(reciboImpl.findById(recibo));
        pago.setTipo(tipo);
        pago.setUsuario(usuario);
        pago.setValor(null);
        
        pagoImpl.save(pago);
       
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
            this.deletePago(Integer.parseInt(request.getParameter("id")));
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
                this.registrarPago(request, response);
            }
        } catch (ParseException ex) {
            Logger.getLogger(PagoController.class.getName()).log(Level.SEVERE, null, ex);
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
