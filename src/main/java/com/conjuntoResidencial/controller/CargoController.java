/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.controller;

import com.conjuntoResidencial.dao.CargoDAO.CargoDAOImpl;
import com.conjuntoResidencial.model.Cargo;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author julianolarte
 */
@WebServlet(name = "CargoController", urlPatterns = {"/Cargo"})
public class CargoController extends HttpServlet {

    private CargoDAOImpl cargoImpl = new CargoDAOImpl();
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
            out.println("<title>Servlet CargoController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CargoController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public void mostrarResultados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("cargos", this.cargoImpl.findAll());
        request.getRequestDispatcher("/Cargo.jsp").forward(request, response);
    }
      public void deleteCargo(int number) {
        this.cargoImpl.deleteById(number);
    }
    
    public void registrarCargo(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
        
        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setDescripcion(descripcion);
        
        this.cargoImpl.save(cargo);
    }
    
    public void editarCargo(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
        
        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setDescripcion(descripcion);
        
        this.cargoImpl.update(cargo);
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
            this.deleteCargo(Integer.parseInt(request.getParameter("id")));
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
                this.registrarCargo(request, response);
            }
            if(param!=null && param.equals("editar")) {
                this.editarCargo(request, response);
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
