<%-- 
    Document   : Asambleas
    Created on : 1/05/2018, 05:29:40 PM
    Author     : Julian Olarte Torres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css.css" media="screen" />
        <title>Asistencia</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-6">
                    <h1 class="text-primary">Asistencia</h1>
                </div>
                <div class="col-2 offset-4">
                    <div id="volver">    
                        <a  href="index.jsp">Volver</a>
                    </div>
                </div>
            </div>

            <form action="Asistencia?action=save" method="post">
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="asamblea">Asamblea</label>
                            <select class="custom-select" id="asamblea" name="asamblea">
                                <c:forEach items="${asambleas}" var="asamblea">
                                    <option selected value="${asamblea.getId()}">${asamblea.getId()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="vivienda">Vivienda</label>
                            <select class="custom-select" id="vivienda" name="vivienda">
                                <c:forEach items="${viviendas}" var="vivienda">
                                    <option selected value="${vivienda.getNumero()}">${vivienda.getNumero()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="observacion">Observacion</label>
                            <input type="text" class="form-control" id="observacion" placeholder="Observacion" name="observacion">
                        </div>
                        <div class="form-group">
                            <div class="form-check">
                                <label class="form-check-label" for="asistio">
                                    <input type="checkbox" class="form-check-input" id="asistio" value="" placeholder="Asistio" name="asistio">
                                    Asistio
                                </label>
                            </div>
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
                                    Asamblea
                                </th>
                                <th>
                                    Vivienda
                                </th>                   
                                <th>
                                    Observacion
                                </th>                   
                                <th>
                                    Asistio
                                </th>                   
                                <th>
                                    Acciones
                                </th>                   
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${asistencias}" var="asistencia">
                                <tr>
                                    <td>
                                        ${asistencia.getAsistenciaPK().getAsamblea()}
                                    </td>
                                    <td>
                                        ${asistencia.getAsistenciaPK().getVivienda()}
                                    </td>
                                    <td>
                                        <c:out value = "${asistencia.getObservacion()}"/>
                                    </td>
                                    <td>
                                        ${asistencia.getAsistio()}
                                    </td>
                                    <td>
                                        <a href="Asistencia?action=delete&asamblea=${asistencia.getAsistenciaPK().getAsamblea()}&vivienda=${asistencia.getAsistenciaPK().getVivienda()}" class="btn btn-danger">Eliminar</a>
                                        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal${asistencia.getAsistenciaPK().getAsamblea()}-${asistencia.getAsistenciaPK().getVivienda()}">Actualizar</button>

                                        <!-- Modal -->
                                        <div id="myModal${asistencia.getAsistenciaPK().getAsamblea()}-${asistencia.getAsistenciaPK().getVivienda()}" class="modal fade" role="dialog">
                                            <div class="modal-dialog">

                                                <!-- Modal content-->
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title"></h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p>Editar el Registro</p>

                                                        <form action="Asistencia?action=save" method="post">
                                                            <div class="row">
                                                                <div class="col-6">
                                                                    <div class="form-group">
                                                                        <label for="asamblea">Asamblea</label>
                                                                        <select class="custom-select" id="asamblea" name="asamblea">
                                                                            <c:forEach items="${asambleas}" var="asamblea">
                                                                                <option selected="${asamblea.getId().equals(asistencia.getAsamblea1().getId()) ? selected : false}" value="${asamblea.getId()}">${asamblea.getId()}</option>
                                                                            </c:forEach>
                                                                        </select>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="vivienda">Vivienda</label>
                                                                        <select class="custom-select" id="vivienda" name="vivienda">
                                                                            <c:forEach items="${viviendas}" var="vivienda">
                                                                                <option selected="${vivienda.getNumero().equals(asistencia.getVivienda1().getNumero()) ? selected : false}" value="${vivienda.getNumero()}">${vivienda.getNumero()}</option>
                                                                            </c:forEach>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div class="col-6">
                                                                    <div class="form-group">
                                                                        <label for="observacion">Observacion</label>
                                                                        <input type="text" value="${asistencia.getObservacion()}" class="form-control" id="observacion" placeholder="Observacion" name="observacion">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="asistio">Asistio</label>
                                                                        <input type="checkbox" ${asistencia.getAsistio().equals(true) ? "checked='checked'" : ""} value="${asistencia.getAsistio()}" class="form-control" id="asistio" placeholder="Asistio" name="asistio">
                                                                    </div>
                                                                </div>

                                                                <div class="col-4 offset-4">
                                                                    <input type="submit" value="registrar" class="btn btnf btn-primary">
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

