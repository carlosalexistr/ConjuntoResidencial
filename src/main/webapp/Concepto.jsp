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
        <title>Concepto</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-6">
                    <h1 class="text-primary">Concepto</h1>
                </div>
                <div class="col-2 offset-4">
                    <div id="volver">    
                        <a  href="index.jsp">Volver</a>
                    </div>
                </div>
            </div>

            <form action="Concepto?action=save" method="post">
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
                            Estado
                        </th>                                   
                        <th>
                            Acciones
                        </th>                   
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${conceptos}" var="concepto">
                        <tr>
                            <td>
                                ${concepto.getId()}
                            </td>
                            <td>
                                ${concepto.getDescripcion()}
                            </td>
                            <td>
                                ${concepto.getEstado()}
                            </td>
                            <td>
                                <a href="Concepto?action=delete&id=${concepto.getId()}" class="btn btn-danger">Eliminar</a>
                                <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal${concepto.getId()}">Actualizar</button>

                                <!-- Modal -->
                                <div id="myModal${concepto.getId()}" class="modal fade" role="dialog">
                                    <div class="modal-dialog">

                                        <!-- Modal content-->
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                <h4 class="modal-title"></h4>
                                            </div>
                                            <div class="modal-body">
                                                <p>Editar el Registro ${concepto.getId()}</p>

                                                <form action="Concepto?action=editar" method="post">
                                                    <div class="row">
                                                        <div class="col-6">
                                                            <div class="form-group">
                                                                <label for="id">Id</label>
                                                                <input type="text" value=${concepto.getId()} class="form-control" id="id" placeholder="Id" name="id" readonly="readonly">
                                                            </div>
                                                        </div>
                                                        <div class="col-6">
                                                            <div class="form-group">
                                                                <label for="description">Descripción</label>
                                                                <input type="text" value="${concepto.getDescripcion()}" class="form-control" id="descripcion" placeholder="Descripción" name="descripcion">
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="estado">Estado</label>
                                                                <input type="checkbox" ${concepto.getEstado().equals(true) ? "checked='checked'" : ""} value="${concepto.getEstado()}" class="form-control" id="estado" placeholder="Estado" name="estado">
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

