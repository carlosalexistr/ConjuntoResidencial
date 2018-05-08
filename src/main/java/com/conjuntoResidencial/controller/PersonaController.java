/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.controller;

import com.conjuntoResidencial.dao.PersonaDAO.PersonaDAOImpl;
import com.conjuntoResidencial.model.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julian Olarte Torres
 */
@WebServlet(name = "PersonaController", urlPatterns = {"/Persona"})
public class PersonaController extends HttpServlet {

    private PersonaDAOImpl personaimpl = new PersonaDAOImpl();
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
            out.println("<title>Servlet PersonaController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PersonaController at " + request.getContextPath() + "</h1>");
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
            this.eliminarPersona(request.getParameter("id"));
        }
        this.mostrarPersonas(request, response);
        
    }
    
    public void mostrarPersonas(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Persona> personas = this.personaimpl.findAll();
        request.setAttribute("personas", personas);
        request.getRequestDispatcher("/Persona.jsp").forward(request, response);
    }
    public void eliminarPersona(String doc) {
        this.personaimpl.deleteById(doc);
    }
    
    public void savePersona(HttpServletRequest request, HttpServletResponse response) {
        String doc = request.getParameter("documento");
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String celular = request.getParameter("celular");
        String direccion = request.getParameter("direccion");
        String clave = request.getParameter("clave");
        Persona persona = new Persona();
        
        persona.setDocumento(doc);
        persona.setNombre(nombre);
        persona.setEmail(email);
        persona.setCelular(celular);
        persona.setDireccion(direccion);
        persona.setClave(clave);
        this.personaimpl.save(persona);
    }
    
     public void actualizarPersona(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String doc = request.getParameter("documento");
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String celular = request.getParameter("celular");
        String direccion = request.getParameter("direccion");
        String clave = request.getParameter("clave");
        Persona persona = new Persona();
        
        persona.setDocumento(doc);
        persona.setNombre(nombre);
        persona.setEmail(email);
        persona.setCelular(celular);
        persona.setDireccion(direccion);
        persona.setClave(clave);
        this.personaimpl.update(persona);
        
        
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
            this.savePersona(request, response);
        }
        
         if(param!=null && param.equals("editar")) {
            this.actualizarPersona(request, response);
        }
    
        this.mostrarPersonas(request, response);
        
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
