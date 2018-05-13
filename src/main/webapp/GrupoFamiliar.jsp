<%-- 
    Document   : GrupoFamiliar
    Created on : 3/05/2018, 06:10:16 PM
    Author     : USUARIO
--%>

<%@page import="com.conjuntoResidencial.model.Parentesco"%>
<%@page import="java.util.List"%>
<%@page import="com.conjuntoResidencial.dao.ParentescoDAO.ParentescoDAOImp"%>
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
                    <h1 class="text-primary">Grupo Familiar</h1>
                </div>
                <div class="col-2 offset-4">
                    <div id="volver">    
                        <a  href="index.jsp">Volver</a>
                    </div>
                </div>
            </div>

            <form action="GrupoFamiliar?action=save" method="post">
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="id">Id</label>
                            <input type="text" class="form-control" id="id" placeholder="Id" name="id">
                        </div>

                        <div class="form-group">
                            <label for="documento">Documento</label>
                            <input type="text" class="form-control" documento="documento" placeholder="Documento" name="documento">
                        </div>

                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control" nombre="nombre" placeholder="Nombre" name="nombre">
                        </div>


                        <div class="form-group">
                            <label for="parentesco">Parentesco</label>
                            <select name="parentesco" id="parentesco" class="form-control">
                                <c:forEach items="${parentesco}" var="parentesco">
                                    <option selected value="${parentesco.getId()}">${parentesco.getId()} - ${parentesco.getDescripcion()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-6">

                        <div class="form-group">
                            <label for="celular">Celular</label>
                            <input type="text" class="form-control" id="celular" placeholder="Celular" name="celular">
                        </div>

                        <div class="form-group">
                            <label for="persona">Cabeza Grupo</label>
                            <select name="cabeza" id="cabeza" class="form-control">
                                <c:forEach items="${persona}" var="persona">
                                    <option selected value="${persona.getDocumento()}">${persona.getDocumento()} - ${persona.getNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="fecha">Fecha Nacimiento</label>
                            <input type="date" class="form-control" id="fecha" placeholder="Fecha Nacimiento" name="fecha">
                        </div>
                    </div>

                    <div class="col-4 offset-4">
                        <input type="submit" value="Registrar" class="btn btnf btn-primary">
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
                                    Documento
                                </th>                   
                                <th>
                                    Nombre
                                </th>                   
                                <th>
                                    Parentesco
                                </th>                   
                                <th>
                                    Celular
                                </th> 

                                <th>
                                    Cabeza Grupo
                                </th> 
                                <th>
                                    Fecha
                                </th> 

                                <th>
                                    Acciones
                                </th> 
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${grupofamiliar}" var="grupofamiliar">
                                <tr>
                                    <td>
                                        ${grupofamiliar.getId()}
                                    </td>
                                    <td>
                                        ${grupofamiliar.getDocumento()}
                                    </td>
                            <a href="GrupoFamiliar.jsp"></a>
                            <td>
                                ${grupofamiliar.getNombre()}
                            </td>
                            <td>
                                ${grupofamiliar.getParentesco().getDescripcion()}
                            </td>
                            <td>
                                ${grupofamiliar.getCelular()}
                            </td>
                            <td>
                                ${grupofamiliar.getCabeza().getNombre()}
                            </td>
                            <td>
                                <c:out value = "${grupofamiliar.getFechanacimiento()}"/>
                            </td>
                            <td>
                                <a href="GrupoFamiliar?action=delete&id=${grupofamiliar.getId()}" class="btn btn-danger">Eliminar</a>
                                <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal${grupofamiliar.getId()}">Actualizar</button>

                                <!-- Modal -->
                                <div id="myModal${grupofamiliar.getId()}" class="modal fade" role="dialog">
                                    <div class="modal-dialog">

                                        <!-- Modal content-->
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                <h4 class="modal-title"></h4>
                                            </div>
                                            <div class="modal-body">
                                                <p>Editar el Registro ${grupofamiliar.getId()}</p>
                                                <form action="GrupoFamiliar?action=editar" method="post">
                                                    <div class="row">
                                                        <div class="col-6">
                                                            <div class="form-group">
                                                                <label for="id">Id</label>
                                                                <input readonly="readonly" type="text" value=${grupofamiliar.getId()} class="form-control" id="id" placeholder="Id" name="id">
                                                            </div>

                                                            <div class="form-group">
                                                                <label for="documento">Documento</label>
                                                                <input type="text" value=${grupofamiliar.getDocumento()} class="form-control" documento="documento" placeholder="Documento" name="documento">
                                                            </div>

                                                            <div class="form-group">
                                                                <label for="nombre">Nombre</label>
                                                                <input type="text" value=${grupofamiliar.getNombre()} class="form-control" nombre="nombre" placeholder="Nombre" name="nombre">
                                                            </div>


                                                            <div class="form-group">
                                                                <label for="parentesco">Parentesco</label>
                                                                <select name="parentesco" id="parentesco" class="form-control">
                                                                    <c:forEach items="${parentesco}" var="parentesco">
                                                                        <c:choose>
                                                                            <c:when test = "${parentesco.getId() == grupofamiliar.getParentesco().getId()}">
                                                                                <option selected value="${parentesco.getId()}">${parentesco.getId()} - ${parentesco.getDescripcion()}</option>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <option value="${parentesco.getId()}">${parentesco.getId()} - ${parentesco.getDescripcion()}</option>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-6">

                                                            <div class="form-group">
                                                                <label for="celular">Celular</label>
                                                                <input type="text" value=${grupofamiliar.getCelular()} class="form-control" id="celular" placeholder="Celular" name="celular">
                                                            </div>

                                                            <div class="form-group">
                                                                <label for="persona">Cabeza Grupo</label>
                                                                <select name="cabeza" id="cabeza" class="form-control">
                                                                    <c:forEach items="${persona}" var="persona">
                                                                        <c:choose>
                                                                            <c:when test = "${persona.getDocumento() == grupofamiliar.getCabeza().getDocumento()}">
                                                                                <option selected value="${persona.getDocumento()}">${persona.getDocumento()} - ${persona.getNombre()}</option>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <option value="${persona.getDocumento()}">${persona.getDocumento()} - ${persona.getNombre()}</option>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>

                                                            <div class="form-group">
                                                                <label for="fecha">Fecha Nacimiento</label>
                                                                <input type="date" value=${grupofamiliar.getFechanacimiento()} class="form-control" id="fecha" placeholder="Fecha Nacimiento" name="fecha">
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
