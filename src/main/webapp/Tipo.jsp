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
        <title>Persona</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1 class="text-primary">Tipo</h1>
            </div>
            <div class="row">
                <div class="col-6">
                    <form action="Tipo?action=save" method="post">
                        <div class="form-group">
                            <label for="id">Id</label>
                            <input type="text" class="form-control" id="id" placeholder="Id" name="id">
                        </div>
                        <div class="form-group">
                            <label for="medida">Medida</label>
                            <input type="text" class="form-control" id="medida" placeholder="Medida" name="medida">
                        </div>
                        <div class="form-group">
                            <label for="condominio">Condominio</label>
                            <input type="text" class="form-control" id="condominio" placeholder="Condominio" name="condominio">
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
                                    Id
                                </th>
                                <th>
                                    Medida
                                </th>                   
                                <th>
                                    Condominio
                                </th>                                    
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${tipos}" var="tipo">
                                <tr>
                                    <td>
                                        ${tipo.getId()}
                                    </td>
                                    <td>
                                        ${tipo.getMedida()}
                                    </td>
                                    <td>
                                        ${tipo.getCondominio()}
                                    </td>
                                    <td>
                                        <a href="Tipo?action=delete&id=${tipo.getId()}" class="btn btn-danger">Eliminar</a>
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
