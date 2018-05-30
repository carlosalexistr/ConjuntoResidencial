<%-- 
    Document   : Solicitud
    Created on : 9/05/2018, 11:29:40 PM
    Author     : Carlos Alexis Tapias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css.css" media="screen" />
        <title>Solicitud</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-6">
                    <h1 class="text-primary">Solicitud</h1>
                </div>
                <div class="col-2 offset-4">
                    <div id="volver">    
                        <a  href="index.jsp">Volver</a>
                    </div>
                </div>
            </div>

            <form action="Solicitud?action=save" method="post">
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="numero">Numero</label>
                            <input type="text" class="form-control" id="numero" placeholder="Numero" name="numero">
                        </div>
                        <div class="form-group">
                            <label for="fechaSolicitud">Fecha de Solicitud</label>
                            <input type="date" class="form-control" id="fechaSolicitud" placeholder="Fecha de Solicitud" name="fechaSolicitud">
                        </div>
                        <div class="form-group">
                            <label for="fechaNecesidad">Fecha de Necesidad</label>
                            <input type="date" class="form-control" id="fechaNecesidad" placeholder="Fecha de Necesidad" name="fechaNecesidad">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="estado">Estado</label>
                            <input type="text" class="form-control" id="estado" placeholder="Estado" name="estado">
                        </div>
                        <div class="form-group">
                            <label for="usuario">Usuario</label>
                            <select class="custom-select" id="usuario" name="usuario">
                                <c:forEach items="${personas}" var="persona">
                                    <option selected value="${persona.getDocumento()}">
                                        ${persona.getDocumento()}-${persona.getNombre()}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="vivienda">Vivienda</label>
                            <select class="custom-select" id="vivieda" name="vivienda">
                                <c:forEach items="${viviendas}" var="vivienda">
                                    <option selected value="${vivienda.getNumero()}">${vivienda.getNumero()}
                                    </option>
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
                                    Numero
                                </th>
                                <th>
                                    Fecha Solicitud
                                </th>                   
                                <th>
                                    Fecha Necesidad
                                </th>                   
                                <th>
                                    Estado
                                </th>                   
                                <th>
                                    Usuario
                                </th>  
                                <th>
                                    Vivienda
                                </th> 
                                <th>
                                    Acciones
                                </th> 
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${solicitudes}" var="solicitud">
                                <tr>
                                    <td>
                                        ${solicitud.getNumero()}
                                    </td>
                                    <td>
                                        ${solicitud.getFechaSolicitud()}
                                    </td>
                                    <td>
                                        <c:out value = "${solicitud.getFechanesecidad()}"/>
                                    </td>
                                    <td>
                                        ${solicitud.getEstado()}
                                    </td>
                                    <td>
                                        ${solicitud.getUsuario()}
                                    </td>
                                    <td>
                                        ${solicitud.getVivienda().getNumero()}
                                    </td>
                                    <td>
                                        <a href="Solicitud?action=delete&id=${solicitud.getNumero()}" class="btn btn-danger">Eliminar</a>
                                        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal${solicitud.getNumero()}">Actualizar</button>

                                        <!-- Modal -->
                                        <div id="myModal${solicitud.getNumero()}" class="modal fade" role="dialog">
                                            <div class="modal-dialog">

                                                <!-- Modal content-->
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title"></h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p>Editar el Registro ${solicitud.getNumero()}</p>

                                                        <form action="Solicitud?action=editar" method="post">
                                                            <div class="row">
                                                                <div class="col-6">
                                                                    <div class="form-group">
                                                                        <label for="numero">Numero</label>
                                                                        <input type="text" value="${solicitud.getNumero}" class="form-control" id="numero" placeholder="Numero" name="numero">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="fechaSolicitud">Fecha de Solicitud</label>
                                                                        <input type="date" value="${solicitud.getFechaSolicitud}" class="form-control" id="fechaSolicitud" placeholder="Fecha de Solicitud" name="fechaSolicitud">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="fechaNecesidad">Fecha de Necesidad</label>
                                                                        <input type="date" value="${solicitud.getFechanumero}" class="form-control" id="fechaNecesidad" placeholder="Fecha de Necesidad" name="fechaNecesidad">
                                                                    </div>
                                                                </div>
                                                                <div class="col-6">
                                                                    <div class="form-group">
                                                                        <label for="estado">Estado</label>
                                                                        <input type="text" value="${solicitud.getEstado}" class="form-control" id="estado" placeholder="Estado" name="estado">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="usuario">Usuario</label>
                                                                        <select class="custom-select" id="usuario" name="usuario">
                                                                            <c:forEach items="${personas}" var="persona">
                                                                                <option selected="${solicitud.getNumero().equals(persona.getDocumento()) ? selected : false}" value="${persona.getDocumento()}">
                                                                                    ${persona.getDocumento()}-${persona.getNombre()}
                                                                                </option>
                                                                            </c:forEach>
                                                                        </select>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="vivienda">Vivienda</label>
                                                                        <select class="custom-select" id="vivieda" name="vivienda">
                                                                            <c:forEach items="${viviendas}" var="vivienda">
                                                                                <option selected="${solicitud.getVivienda().getNumero().equals(vivienda.getNumero()) ? selected : false}" value="${persona.getVivienda().getNumero()}">${vivienda.getNumero()}
                                                                                </option>
                                                                            </c:forEach>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div class="col-4 offset-4">
                                                                    <input type="submit" value="Editar" class="btn btnf btn-primary">
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

