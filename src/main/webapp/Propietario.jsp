<%-- 
    Document   : Propietario
    Created on : 16-may-2018, 9:40:49
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css.css" media="screen" />
        <title>Propietario</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-6">
                    <h1 class="text-primary">Propietario</h1>
                </div>
                <div class="col-2 offset-4">
                    <div id="volver">    
                        <a  href="index.jsp">Volver</a>
                    </div>
                </div>
            </div>

            <form action="Propietario?action=save" method="post">
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="vivienda">Vivienda</label>
                            <select class="custom-select" id="vivienda" name="vivienda">
                                <c:forEach items="${viviendas}" var="vivienda">
                                    <option selected value="${vivienda.getNumero()}">${vivienda.getNumero()} - ${vivienda.getResponsable().getNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="persona">Personas3</label>
                            <select name="persona" class="custom-select" id="persona" >
                                <c:forEach items="${persona}" var="persona">
                                    <option selected value="${persona.getDocumento()}">${persona.getDocumento()} - ${persona.getNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="fecha">Fecha Inicio</label>
                            <input type="date" class="form-control" id="fecha" placeholder="FechaIni" name="fechaInicio">
                        </div>

                        <div class="form-group">
                            <label for="fecha">Fecha Fin</label>
                            <input type="date" class="form-control" id="fecha" placeholder="FechaFin" name="fechaFin">
                        </div>

                    </div>

                    <div class="col-6">
                        <div class="form-group">
                            <label for="responsable">Responsable</label>
                            <input type="text" class="form-control" id="responsable" placeholder="Responsable" name="responsable">
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
                            <c:forEach items="${propietario}" var="propietario">
                                <tr>
                                    <td>
                                        ${propietario.getVivienda1().getNumero()}
                                    </td>
                                    <td>
                                        ${propietario.getPersona1().getNombre()}
                                    </td>
                                    <td>
                                        <c:out value = "${propietario.getPropietarioPK().getFechainicio()}"/>
                                    </td>                                               
                                    <td>
                                        <c:out value = "${propietario.getFechafin()}"/>
                                    </td>
                                    <td>
                                        ${propietario.getResponsable()}
                                    </td>
                                    <td>
                                        <a href="Propietario?action=delete&vivienda=${propietario.getPropietarioPK().getVivienda()}&persona=${propietario.getPropietarioPK().getPersona()}&fechai=${propietario.getPropietarioPK().getFechainicio()}" class="btn btn-danger">Eliminar</a>
                                        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal${propietario.getPropietarioPK().getVivienda()}${propietario.getPropietarioPK().getPersona()}${propietario.getPropietarioPK().getFechainicio()}">Actualizar</button>

                                        <!-- Modal -->
                                        <div id="myModal${propietario.getPropietarioPK().getVivienda()}${propietario.getPropietarioPK().getPersona()}${propietario.getPropietarioPK().getFechainicio()}" class="modal fade" role="dialog">
                                            <div class="modal-dialog">

                                                <!-- Modal content-->
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title"></h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p>Editar el Registro</p>

                                                        <form action="Propietario?action=editar" method="post">
                                                            <div class="row">
                                                                <div class="col-6">
                                                                    <div class="form-group">
                                                                        <label for="vivienda">Vivienda</label>
                                                                        <select class="custom-select" id="vivienda" name="vivienda">
                                                                            <c:forEach items="${viviendas}" var="vivienda">
                                                                                <option selected value="${vivienda.getNumero()}">${vivienda.getNumero()} - ${vivienda.getResponsable().getNombre()}</option>
                                                                            </c:forEach>
                                                                        </select>
                                                                    </div>

                                                                    <div class="form-group">
                                                                        <label for="persona">Persona</label>
                                                                        <select class="custom-select" id="persona" name="persona">
                                                                            <c:forEach items="${persona}" var="persona">
                                                                                <option selected value="${persona.getDocumento()}">${persona.getDocumento()} - ${persona.getNombre()}</option>
                                                                            </c:forEach>
                                                                        </select>
                                                                    </div>

                                                                    <div class="form-group">
                                                                        <label for="fecha">Fecha Inicio</label>
                                                                        <input type="date" class="form-control" id="fecha" placeholder="FechaIni" name="fechaInicio">
                                                                    </div>

                                                                    <div class="form-group">
                                                                        <label for="fecha">Fecha Fin</label>
                                                                        <input type="date" class="form-control" id="fecha" placeholder="FechaFin" name="fechaFin">
                                                                    </div>

                                                                </div>

                                                                <div class="col-6">
                                                                    <div class="form-group">
                                                                        <label for="responsable">Responsable</label>
                                                                        <input type="text" class="form-control" id="responsable" placeholder="Responsable" name="responsable">
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
