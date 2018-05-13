<%-- 
    Document   : Persona
    Created on : 3/05/2018, 12:43:19 PM
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
        <title>Persona</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-6">
                    <h1 class="text-primary">Persona</h1>
                </div>
                <div class="col-2 offset-4">
                    <div id="volver">    
                        <a  href="index.jsp">Volver</a>
                    </div>
                </div>
            </div>
            <form action="Persona?action=save" method="post">
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="documento">Documento</label>
                            <input type="text" class="form-control" id="doc" placeholder="Documento" name="documento">
                        </div>
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control" id="nombre" placeholder="Nombre" name="nombre">
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="text" class="form-control" id="email" placeholder="Email" name="email">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="celular">celular</label>
                            <input type="text" class="form-control" id="celular" placeholder="celular" name="celular">
                        </div>
                        <div class="form-group">
                            <label for="direccion">Direccion</label>
                            <input type="text" class="form-control" id="direccion" placeholder="Direccion" name="direccion">
                        </div>
                        <div class="form-group">
                            <label for="clave">Clave</label>
                            <input type="password" class="form-control" id="clave" placeholder="Clave" name="clave">
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
                                    Documento
                                </th>
                                <th>
                                    Nombre
                                </th>                   
                                <th>
                                    Email
                                </th>                   
                                <th>
                                    Celular
                                </th>                   
                                <th>
                                    Acciones
                                </th>                   
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${personas}" var="persona">
                                <tr>
                                    <td>
                                        ${persona.getDocumento()}
                                    </td>
                                    <td>
                                        ${persona.getNombre()}
                                    </td>
                                    <td>
                                        ${persona.getEmail()}
                                    </td>
                                    <td>
                                        ${persona.getCelular()}
                                    </td>
                                    <td>
                                        <a href="Persona?action=delete&id=${persona.getDocumento()}" class="btn btn-danger">Eliminar</a>
                                        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal${persona.getDocumento()}">Actualizar</button>

                                        <!-- Modal -->
                                        <div id="myModal${persona.getDocumento()}" class="modal fade" role="dialog">
                                            <div class="modal-dialog">

                                                <!-- Modal content-->
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title"></h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p>Editar el Registro ${persona.getDocumento()}</p>

                                                        <form action="Persona?action=editar" method="post">
                                                            <div class="row">
                                                                <div class="col-6">
                                                                    <div class="form-group">
                                                                        <label for="documento">Documento</label>
                                                                        <input type="text" readonly="readonly" value=${persona.getDocumento()} class="form-control" id="doc" placeholder="Documento" name="documento">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="nombre">Nombre</label>
                                                                        <input type="text" value=${persona.getNombre()} class="form-control" id="nombre" placeholder="Nombre" name="nombre">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="email">Email</label>
                                                                        <input type="text" value=${persona.getEmail()} class="form-control" id="email" placeholder="Email" name="email">
                                                                    </div>
                                                                </div>
                                                                <div class="col-6">
                                                                    <div class="form-group">
                                                                        <label for="celular">celular</label>
                                                                        <input type="text" value=${persona.getCelular()} class="form-control" id="celular" placeholder="celular" name="celular">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="direccion">Direccion</label>
                                                                        <input type="text" value=${persona.getDireccion()} class="form-control" id="direccion" placeholder="Direccion" name="direccion">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="clave">Clave</label>
                                                                        <input type="password" value=${persona.getClave()} class="form-control" id="clave" placeholder="Clave" name="clave">
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
                                    </td>
                                </c:forEach>

                            </tr>
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
