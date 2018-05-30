<%-- 
    Document   : Servicio
    Created on : 16-may-2018, 15:35:36
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
        <title>Servicio</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-6">
                    <h1 class="text-primary">Servicio</h1>
                </div>
                <div class="col-2 offset-4">
                    <div id="volver">    
                        <a  href="index.jsp">Volver</a>
                    </div>
                </div>
            </div>

            <form action="Servicio?action=save" method="post">
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="id">Id</label>
                            <input type="text" class="form-control" id="id" placeholder="Id" name="id">
                        </div>
                        <div class="form-group">
                            <label for="description">Descripción</label>
                            <input type="text" class="form-control" id="descripcion" placeholder="Descripción" name="descripcion">
                        </div>
                        <div class="form-group">
                            <label for="observacion">Observación</label>
                            <input type="text" class="form-control" id="observacion" placeholder="observacion" name="observacion">
                        </div>
                        <div class="form-group">
                            <label for="valor">Valor</label>
                            <input type="text" class="form-control" id="valor" placeholder="valor" name="valor">
                        </div>
                    </div>
                    <div class="col-6">
                        <br>
                        <div class="form-group">
                            <div class="form-check">
                                <label class="form-check-label" for="estado">
                                    <input type="checkbox" class="form-check-input" id="estado" value="" placeholder="Estado" name="estado">
                                    Estado
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
                                    Id
                                </th>
                                <th>
                                    Descripcion
                                </th>   
                                <th>
                                    Observacion
                                </th>  
                                <th>
                                    Valor
                                </th>                                  
                                <th>
                                    Estado
                                </th>                                   
                                <th>
                                    Acciones
                                </th>                   
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${servicios}" var="servicio">
                                <tr>
                                    <td>
                                        ${servicio.getId()}
                                    </td>
                                    <td>
                                        ${servicio.getDescripcion()}
                                    </td>
                                    <td>
                                        ${servicio.getObservacion()}
                                    </td>
                                    <td>
                                        ${servicio.getValor()}
                                    </td>
                                    <td>
                                        ${servicio.getEstado()}
                                    </td>
                                    <td>
                                        <a href="Servicio?action=delete&id=${servicio.getId()}" class="btn btn-danger">Eliminar</a>
                                        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal${servicio.getId()}">Actualizar</button>

                                        <!-- Modal -->
                                        <div id="myModal${servicio.getId()}" class="modal fade" role="dialog">
                                            <div class="modal-dialog">

                                                <!-- Modal content-->
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title"></h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p>Editar el Registro ${concepto.getId()}</p>

                                                        <form action="Servicio?action=save" method="post">
                                                            <div class="row">
                                                                <div class="col-6">
                                                                    <div class="form-group">
                                                                        <label for="id">Id</label>
                                                                        <input type="text" class="form-control" id="id" placeholder="Id" name="id">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="description">Descripción</label>
                                                                        <input type="text" class="form-control" id="descripcion" placeholder="Descripción" name="descripcion">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="observacion">Observación</label>
                                                                        <input type="text" class="form-control" id="observacion" placeholder="observacion" name="observacion">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="valor">Valor</label>
                                                                        <input type="text" class="form-control" id="valor" placeholder="valor" name="valor">
                                                                    </div>
                                                                </div>
                                                                <div class="col-6">
                                                                    <br>
                                                                    <div class="form-group">
                                                                        <div class="form-check">
                                                                            <label class="form-check-label" for="estado">
                                                                                <input type="checkbox" class="form-check-input" id="estado" value="" placeholder="Estado" name="estado">
                                                                                Estado
                                                                            </label>
                                                                        </div>
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


