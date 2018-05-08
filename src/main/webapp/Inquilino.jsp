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
        <link rel="stylesheet" type="text/css" href="css.css" media="screen" />
        <title>JSP Page</title>
    </head>

    <body>

        <div class="container">
            <div class="row">
                <div class="col-6">
                    <h1 class="text-primary">Inquilino</h1>
                </div>
                <div class="col-2 offset-4">
                    <div id="volver">    
                        <a  href="index.jsp">Volver</a>
                    </div>
                </div>
            </div>

            <form action="Inquilino?action=save" method="post">
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="vivienda">Vivienda</label>
                            <select name="vivienda" id="vivienda" class="form-control">
                                <c:forEach items="${viviendas}" var="vivienda">
                                    <option selected value="${vivienda.getNumero()}">${vivienda.getNumero()} - ${vivienda.getResponsable().getNombre()}</option>
                                </c:forEach>
                            </select>
                        </div> 


                        <div class="form-group">
                            <label for="persona">Persona</label>
                            <select name="cabeza" id="cabeza" class="form-control">
                                <c:forEach items="${persona}" var="persona">
                                    <option selected value="${persona.getDocumento()}">${persona.getDocumento()} - ${persona.getNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="fecha">Fecha Inicio</label>
                            <input type="date" class="form-control" id="fecha" placeholder="Fecha Inicio" name="fecha">
                        </div>

                    </div>
                    <div class="col-6">

                        <div class="form-group">
                            <label for="fechaF">Fecha Fin</label>
                            <input type="date" class="form-control" id="fechaF" placeholder="Fecha Fin" name="fechaF">
                        </div>

                        <div class="form-group">
                            <label for="persona">Responsable</label>
                            <select name="responsable" id="responsable" class="form-control">
                                <c:forEach items="${persona}" var="persona">
                                    <option selected value="${persona.getDocumento()}">${persona.getDocumento()} - ${persona.getNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>

                    </div>
                    <div class="col-4 offset-4">
                        <input type="submit" value="registrar" class="btn btnf btn-primary">
                    </div>
                </div> 

            </form>

            <div class="row mt-5">
                <div class="col-12">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>
                                    Vivienda
                                </th>
                                <th>
                                    Persona
                                </th>                   
                                <th>
                                    Fecha Inicio
                                </th>                   
                                <th>
                                    Fecha Fin
                                </th> 

                                <th>
                                    Responsasble
                                </th>  
                                <th>
                                    Acciones
                                </th> 
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${inquilino}" var="inquilino">
                                <tr>
                                    <td>
                                        ${inquilino.getVivienda1().getNumero()}
                                    </td>
                                    <td>
                                        ${inquilino.getPersona1().getNombre()}
                                    </td>
                                    <td>
                                        <c:out value = "${inquilino.getInquilinoPK().getFechainicio()}"/>
                                    </td>
                                    <td>
                                        <c:out value = "${inquilino.getFechafin()}"/>
                                    </td>
                                    <td>
                                        ${inquilino.getResponsable()}
                                    </td>


                                    <td>
                                        <a href="Inquilino?action=delete&vivienda=${inquilino.getInquilinoPK().getVivienda()}&persona=${inquilino.getInquilinoPK().getPersona()}&fechai=${inquilino.getInquilinoPK().getFechainicio()}" class="btn btn-danger">Eliminar</a>
                                        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal${inquilino.getInquilinoPK().getVivienda()}${inquilino.getInquilinoPK().getPersona()}${inquilino.getInquilinoPK().getFechainicio()}">Actualizar</button>
                                        <!-- Modal -->
                                        <div id="myModal${inquilino.getInquilinoPK().getVivienda()}${inquilino.getInquilinoPK().getPersona()}${inquilino.getInquilinoPK().getFechainicio()}" class="modal fade" role="dialog">
                                            <div class="modal-dialog">

                                                <!-- Modal content-->
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title"></h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p>Editar el Registro ${inquilino.getInquilinoPK().getVivienda()}${inquilino.getInquilinoPK().getPersona()}${inquilino.getInquilinoPK().getFechainicio()}</p>
                                                        <form action="Inquilino?action=editar" method="post">
                                                            <div class="row">
                                                                <div class="col-6">
                                                                    
                                                                    <div class="form-group">
                                                                        <label for="fecha">Vivienda</label>
                                                                        <input readonly="readonly" type="text" value=${inquilino.getInquilinoPK().getVivienda()} class="form-control" id="vivienda" placeholder="vivienda" name="vivienda">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="fecha">Persona</label>
                                                                        <input readonly="readonly" type="text" value=${inquilino.getInquilinoPK().getPersona()} class="form-control" id="cabeza" placeholder="persona" name="cabeza">
                                                                    </div>


                                                                    <div class="form-group">
                                                                        <label for="fecha">Fecha Inicio</label>
                                                                        <input readonly="readonly" type="date" value=${inquilino.getInquilinoPK().getFechainicio()} class="form-control" id="fecha" placeholder="Fecha Inicio" name="fecha">
                                                                    </div>

                                                                </div>
                                                                <div class="col-6">

                                                                    <div class="form-group">
                                                                        <label for="fechaF">Fecha Fin</label>
                                                                        <input type="date" value=${inquilino.getFechafin()} class="form-control" id="fechaF" placeholder="Fecha Fin" name="fechaF">
                                                                    </div>

                                                                    <div class="form-group">
                                                                        <label for="persona">Responsable</label>
                                                                        <select name="responsable" id="responsable" class="form-control">
                                                                            <c:forEach items="${persona}" var="persona">
                                                                                <c:choose>
                                                                                    <c:when test = "${persona.getDocumento() == inquilino.getResponsable()}">
                                                                                        <option selected value="${persona.getDocumento()}">${persona.getDocumento()} - ${persona.getNombre()}</option>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <option value="${persona.getDocumento()}">${persona.getDocumento()} - ${persona.getNombre()}</option>
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </c:forEach>
                                                                        </select>
                                                                    </div>



                                                                </div>
                                                                <div class="col-4 offset-4">
                                                                    <input type="submit" value="Actualizar" class="btn btnf btn-primary">
                                                                </div>
                                                            </div> 

                                                        </form>




                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>

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
