<%-- 
    Document   : Multa
    Created on : 2/05/2018, 11:26:39 AM
    Author     : DELL
--%>

<%@page import="com.conjuntoResidencial.model.Persona"%>
<%@page import="com.conjuntoResidencial.dao.PersonaDAO.PersonaDAOImpl"%>
<%@page import="com.conjuntoResidencial.model.Vivienda"%>
<%@page import="com.conjuntoResidencial.dao.ViviendaDAO.ViviendaDAOImpl"%>
<%@page import="com.conjuntoResidencial.model.Recibo"%>
<%@page import="java.util.List"%>
<%@page import="com.conjuntoResidencial.dao.ReciboDAO.ReciboDAOImpl"%>
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
                <h1 class="text-primary">Multa</h1>
            </div>
            <div class="row">
                <div class="col-6">
                    <form action="Multa?action=save" method="post">
                        <div class="form-group">
                            <label for="id">Id</label>
                            <input type="text" class="form-control" id="id" placeholder="Id" name="id">
                        </div>
                        <div class="form-group">
                            <label for="recibo">Recibo</label>

                            <%
                                ReciboDAOImpl re = new ReciboDAOImpl();
                                List<Recibo> recibo = re.findAll();
                            %>
                            <select name="recibo" id="recibo" class="form-control">
                                <%
                                    for (Recibo r : recibo) {

                                %>
                                <option value=<%=r.getNumero()%>><%= r.getNumero()%> - <%=r.getUsuario()%></option> 
                                <%
                                    }
                                %>
                            </select>
                        </div>
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
                            <label for="usuario">Usuario</label>

                            <%
                                 PersonaDAOImpl p = new PersonaDAOImpl();
                                List<Persona> user = p.findAll();
                            %>
                            <select name="persona" id="persona" class="form-control">
                                <%
                                    for (Persona pe : user) {

                                %>
                                <option value=<%= pe.getDocumento()%>><%= pe.getDocumento()%> - <%=pe.getNombre()%></option> 
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="description">Observacion</label>
                            <input type="text" class="form-control" id="observacion" placeholder="Descripción" name="observacion">
                        </div>
                        <div class="form-group">
                            <label for="fecha">Fecha</label>
                            <input type="date" class="form-control" id="fecha" placeholder="Fecha" name="fecha">
                        </div>
                        <input type="submit" value="registrar" class="btn btn-primary">
                    </form>
                </div>

            </div>
            <div class="row mt-5">
                <div class="col-12">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>
                                    Id
                                </th>
                                <th>
                                    Descripcion
                                </th>                   
                                <th>
                                    Fecha
                                </th>                   
                                <th>
                                    Lugar
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
