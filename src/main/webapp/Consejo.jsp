<%-- 
    Document   : Asambleas
    Created on : 7/05/2018, 05:29:40 PM
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
        <title>Consejo</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-6">
                    <h1 class="text-primary">Consejo</h1>
                </div>
                <div class="col-2 offset-4">
                    <div id="volver">    
                        <a  href="index.jsp">Volver</a>
                    </div>
                </div>
            </div>

            <form action="Consejo?action=save" method="post">
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="persona">Persona</label>
                            <select class="custom-select" id="persona" name="persona">
                                <c:forEach items="${personas}" var="persona">
                                    <option selected value="${persona.getDocumento()}">${persona.getDocumento()} - ${persona.getNombre()}</option>
                                </c:forEach>
                            </select>                           
                        </div>
                        <div class="form-group">
                            <label for="cargo">Cargo</label>
                            <select class="custom-select" id="cargo" name="cargo">
                                <c:forEach items="${cargos}" var="cargo">
                                    <option selected value="${cargo.getId()}">${cargo.getId()} - ${cargo.getDescripcion()}</option>
                                </c:forEach>
                            </select>                           
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="fechainicio">Fecha Inicio</label>
                            <input type="date" class="form-control" id="fechainicio" placeholder="Fecha inicio" name="fechainicio">
                        </div>
                        <div class="form-group">
                            <label for="fechafin">Fecha Fin</label>
                            <input type="date" class="form-control" id="fechafin" placeholder="Fecha Fin" name="fechafin">
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
                                    Persona
                                </th>
                                <th>
                                    Cargo
                                </th>                                   
                                <th>
                                    Fecha Inicio
                                </th>                                   
                                <th>
                                    Fecha Fin
                                </th>                                   
                                <th>
                                    Acciones
                                </th>                   
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${consejos}" var="consejo">
                                <tr>
                                    <td>
                                        ${consejo.getConsejoPK().getPersona()}
                                    </td>
                                    <td>
                                        ${consejo.getConsejoPK().getCargo()}
                                    </td>
                                    <td>
                                        ${consejo.getConsejoPK().getFechainicio()}
                                    </td>
                                    <td>
                                        ${consejo.getFechafin()}
                                    </td>
                                    <td>
                                        <a href="Consejo?action=delete&persona=${consejo.getConsejoPK().getPersona()}&cargo=${consejo.getConsejoPK().getCargo()}&fechainicio=${consejo.getConsejoPK().getFechainicio()}" class="btn btn-danger">Eliminar</a>
                                        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal${consejo.getConsejoPK().getPersona()}-${consejo.getConsejoPK().getCargo()}-${consejo.getConsejoPK().getFechainicio()}">Actualizar</button>

                                        <!-- Modal -->
                                        <div id="myModal${consejo.getConsejoPK().getPersona()}-${consejo.getConsejoPK().getCargo()}-${consejo.getConsejoPK().getFechainicio()}" class="modal fade" role="dialog">
                                            <div class="modal-dialog">

                                                <!-- Modal content-->
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title"></h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p>Editar el Registro ${consejo.getConsejoPK().getPersona()}-${consejo.getConsejoPK().getCargo()}</p>

                                                        <form action="Consejo?action=editar" method="post">
                                                            <div class="row">
                                                                <div class="col-6">
                                                                    <div class="form-group">
                                                                        <label for="persona">Persona</label>
                                                                        <select class="custom-select" id="persona" name="persona">
                                                                            <c:forEach items="${personas}" var="persona">
                                                                                <option selected="${consejo.getConsejoPK().getPersona().equals(persona.getDocumento()) ? selected : false}" value="${persona.getDocumento()}">${persona.getDocumento()} - ${persona.getNombre()}</option>
                                                                            </c:forEach>
                                                                        </select>                           
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="cargo">Cargo</label>
                                                                        <select class="custom-select" id="cargo" name="cargo">
                                                                            <c:forEach items="${cargos}" var="cargo">
                                                                                <option selected="${consejo.getConsejoPK().getCargo().equals(cargo.getId()) ? selected : false}" value="${cargo.getId()}">${cargo.getId()} - ${cargo.getDescripcion()}</option>
                                                                            </c:forEach>
                                                                        </select>                           
                                                                    </div>
                                                                </div>
                                                                <div class="col-6">
                                                                    <div class="form-group">
                                                                        <label for="fechainicio">Fecha Inicio</label>
                                                                        <input type="date" value="${consejo.getConsejoPK().getFechainicio()}" class="form-control" id="fechainicio" placeholder="Fecha inicio" name="fechainicio">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="fechafin">Fecha Fin</label>
                                                                        <input type="date" value="${consejo.getFechafin()}" class="form-control" id="fechafin" placeholder="Fecha Fin" name="fechafin">
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

