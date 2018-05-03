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
        <title>Vivienda</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1 class="text-primary">Vivienda</h1>
            </div>
            <div class="row">
                <div class="col-6">
                    <form action="Recibo?action=save" method="post">
                        <div class="form-group">
                            <label for="numero">Numero</label>
                            <input type="text" class="form-control" id="numero" placeholder="Numero" name="numero">
                        </div>
                        <div class="form-group">
                            <label for="vivienda">Vivienda</label>
                            <select class="custom-select" id="vivienda" name="vivienda">
                                <c:forEach items="${viviendas}" var="vivienda">
                                    <option selected value="${vivienda.getNumero()}">${vivienda.getNumero()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="fecha">Fecha</label>
                            <input type="date" class="form-control" id="fecha" placeholder="Fecha" name="fecha">
                        </div>
                        <div class="form-group">
                            <label for="responsable">Responsable</label>
                            <select class="custom-select" id="responsable" name="responsable">
                                <c:forEach items="${personas}" var="persona">
                                    <option selected value="${persona.getDocumento()}">${persona.getDocumento()} - ${persona.getNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="valor">Valor</label>
                            <input type="text" class="form-control" id="valor" placeholder="Valor" name="valor">
                        </div>
                        <div class="form-group">
                            <label for="usuario">Usuario</label>
                            <input type="text" class="form-control" id="usuario" placeholder="Usuario" name="usuario">
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
                                    Numero
                                </th>
                                <th>
                                    Vivienda
                                </th>                   
                                <th>
                                    Fecha
                                </th>                   
                                <th>
                                    Responsable
                                </th>                   
                                <th>
                                    Valor
                                </th>                   
                                <th>
                                    Usuario
                                </th>                   
                                <th>
                                    Acciones
                                </th>                   
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${recibos}" var="recibo">
                                <tr>
                                    <td>
                                        ${recibo.getNumero()}
                                    </td>
                                    <td>
                                        ${recibo.getVivienda().getNumero()}
                                    </td>
                                    <td>
                                        ${recibo.getFecha()}
                                    </td>
                                    <td>
                                        ${recibo.getResponsable().getDocumento()} - ${recibo.getResponsable().getNombre()}
                                    </td>
                                    <td>
                                        ${recibo.getValor()}
                                    </td>
                                    <td>
                                        ${recibo.getUsuario()}
                                    </td>
                                    <td>
                                        <a href="Recibo?action=delete&id=${recibo.getNumero()}" class="btn btn-danger">Eliminar</a>
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
