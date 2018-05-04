<%-- 
    Document   : Inquilino
    Created on : 3/05/2018, 07:14:18 PM
    Author     : USUARIO
--%>

<%@page import="com.conjuntoResidencial.model.Persona"%>
<%@page import="com.conjuntoResidencial.dao.PersonaDAO.PersonaDAOImpl"%>
<%@page import="com.conjuntoResidencial.model.Vivienda"%>
<%@page import="java.util.List"%>
<%@page import="com.conjuntoResidencial.dao.ViviendaDAO.ViviendaDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    
    <body>

        <div class="container">
            <div class="row">
                <h1 class="text-primary">Inquilino</h1>
            </div>
            <div class="row">
                <div class="col-6">
                    <form action="Multa?action=save" method="post">
                      <div class="form-group">
                            <label for="vivienda">Vivienda</label>

                            <%
                                ViviendaDAOImpl v = new ViviendaDAOImpl();
                                List<Vivienda> viviendas = v.findAll();
                            %>
                            <select name="vivienda" id="vivienda" class="form-control">
                                <%
                                    for (Vivienda vi : viviendas) {

                                %>
                                <option value=<%= vi.getNumero()%>><%= vi.getNumero()%> - <%=vi.getResponsable().getNombre()%></option> 
                                <%
                                    }
                                %>
                            </select>
                        </div> 
                            
                            <div class="form-group">
                            <label for="persona">Persona</label>

                            <%
                                PersonaDAOImpl p = new PersonaDAOImpl();
                                List<Persona> personas = p.findAll();
                            %>
                            <select name="persona" id="persona" class="form-control">
                                <%
                                    for (Persona pi : personas) {

                                %>
                                <option value=<%= pi.getNombre()%>><%= pi.getNombre()%> - <%=pi.getDocumento()%></option> 
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        
                            <div class="form-group">
                            <label for="fecha">Fecha Inicio</label>
                            <input type="date" class="form-control" id="fecha" placeholder="Fecha Inicio" name="fecha">
                        </div>
                            
                            <div class="form-group">
                            <label for="fechaF">Fecha Fin</label>
                            <input type="date" class="form-control" id="fechaF" placeholder="Fecha Fin" name="fechaF">
                        </div>
                            
                            <div class="form-group">
                            <label for="responsable">Responsable</label>
                            <input type="text" class="form-control" documento="responsable" placeholder="Responsable" name="responsable">
                        </div>
                       
                    </form>
                </div>

            </div>
            <div class="row mt-5">
                <div class="col-12">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>
                                    documento
                                </th>
                                <th>
                                    nombre
                                </th>                   
                                <th>
                                    Email
                                </th>                   
                                <th>
                                    Celular
                                </th> 
                                
                                <th>
                                    Direccion
                                </th> 
                                <th>
                                    Clave
                                </th> 
                                <th>
                                    Acciones
                                </th>                   
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${asambleas}" var="asamblea">
                                <tr>
                                    <td>
                                        ${asamblea.getId()}
                                    </td>
                                    <td>
                                        ${asamblea.getDescripcion()}
                                    </td>
                                    <td>
                                        <c:out value = "${asamblea.getFecha()}"/>
                                    </td>
                                    <td>
                                        ${asamblea.getLugar()}
                                    </td>
                                     <td>
                                        ${asamblea.getLugar()}
                                    </td>
                                     <td>
                                        ${asamblea.getLugar()}
                                    </td>
                          
                                    <td>
                                        <a href="Asamblea?action=delete&id=${asamblea.getId()}" class="btn btn-danger">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
        </div>



        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

    </body>
</html>
