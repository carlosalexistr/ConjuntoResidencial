/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.controller;

import com.conjuntoResidencial.dao.GrupoFamiliarDAO.GrupoFamiliarDAOImpl;
import com.conjuntoResidencial.dao.ParentescoDAO.ParentescoDAOImp;
import com.conjuntoResidencial.dao.PersonaDAO.PersonaDAO;
import com.conjuntoResidencial.dao.PersonaDAO.PersonaDAOImpl;
import com.conjuntoResidencial.model.Grupofamiliar;
import com.conjuntoResidencial.model.Parentesco;
import com.conjuntoResidencial.model.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * @author DELL
 */
@WebServlet(name = "GrupoFamiliarController", urlPatterns = {"/GrupoFamiliar"})
public class GrupoFamiliarController extends HttpServlet {

    GrupoFamiliarDAOImpl grufa = new GrupoFamiliarDAOImpl();
    ParentescoDAOImp parentescoImpl = new ParentescoDAOImp();
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
            out.println("<title>Servlet GrupoFamiliarController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GrupoFamiliarController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
       public void mostrarRegistros(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Grupofamiliar> grupofamiliar = grufa.findAll();
        request.setAttribute("grupofamiliar", grupofamiliar);
        
         List<Parentesco> parentesco = parentescoImpl.findAll();
        request.setAttribute("parentesco", parentesco);
        
         List<Persona> persona = personaImpl.findAll();
        request.setAttribute("persona", persona);
        
        request.getRequestDispatcher("/GrupoFamiliar.jsp").forward(request, response);
    }
         public void registrarGrupoFamiliar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        Grupofamiliar grupoFamiliar = new Grupofamiliar();
             PersonaDAOImpl p = new PersonaDAOImpl();
        grupoFamiliar.setCabeza(p.findById(request.getParameter("cabeza")));
        grupoFamiliar.setCelular(request.getParameter("celular"));
        grupoFamiliar.setFechanacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha")));
             ParentescoDAOImp parentescoImp = new ParentescoDAOImp();
        grupoFamiliar.setParentesco(parentescoImp.findById(Integer.parseInt(request.getParameter("parentesco"))));
        grupoFamiliar.setId(Integer.parseInt(request.getParameter("id")));
        grupoFamiliar.setDocumento(request.getParameter("documento"));
        grupoFamiliar.setNombre(request.getParameter("nombre"));
        grufa.save(grupoFamiliar);
    }
      public void eliminarGrupoFamiiar(int id)
            throws ServletException, IOException {
        this.grufa.deleteById(id);
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
            this.eliminarGrupoFamiiar(Integer.parseInt(request.getParameter("id")));
        }
        this.mostrarRegistros(request, response);
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
                registrarGrupoFamiliar(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(AsistenciaController.class.getName()).log(Level.SEVERE, null, ex);
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
