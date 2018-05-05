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
        <title>Vivienda</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-6">
                    <h1 class="text-primary">Vivienda</h1>
                </div>
                <div class="col-2 offset-4">
                    <div id="volver">    
                        <a  href="index.jsp">Volver</a>
                    </div>
                </div>
            </div>

            <form action="Vivienda?action=save" method="post">
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="numero">Numero</label>
                            <input type="text" class="form-control" id="numero" placeholder="Numero" name="numero">
                        </div>
                        <div class="form-group">
                            <label for="observacion">Observacion</label>
                            <textarea type="text" class="form-control" id="observacion" placeholder="Observacion" name="observacion"></textarea>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="responsable">Resppnsable</label>
                            <select class="custom-select" id="responsable" name="responsable">
                                <c:forEach items="${personas}" var="persona">
                                    <option selected value="${persona.getDocumento()}">${persona.getDocumento()} - ${persona.getNombre()}</option>
                                </c:forEach>
                            </select>                           
                        </div>
                        <div class="form-group">
                            <label for="tipo">Tipo</label>
                            <select class="custom-select" id="tipo" name="tipo">
                                <c:forEach items="${tipos}" var="tipo">
                                    <option selected value="${tipo.getId()}">Medida: ${tipo.getMedida()} - Condominio: ${tipo.getCondominio()}</option>
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
                                    Responsable
                                </th>                   
                                <th>
                                    Observacion
                                </th>                   
                                <th>
                                    Tipo
                                </th>                   
                                <th>
                                    Acciones
                                </th>                   
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${viviendas}" var="vivienda">
                                <tr>
                                    <td>
                                        ${vivienda.getNumero()}
                                    </td>
                                    <td>
                                        ${vivienda.getResponsable().getDocumento()} - ${vivienda.getResponsable().getNombre()}
                                    </td>
                                    <td>
                                        ${vivienda.getObservacion()}
                                    </td>
                                    <td>
                                        Medida: ${vivienda.getTipo().getMedida()} - Condominio: ${vivienda.getTipo().getCondominio()}
                                    </td>
                                    <td>
                                        <a href="Vivienda?action=delete&id=${vivienda.getNumero()}" class="btn btn-danger">Eliminar</a>
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
