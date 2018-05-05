<%-- 
    Document   : Pago
    Created on : 3/05/2018, 04:03:33 PM
    Author     : MoNica AlejaNdra
--%>

<%@page import="com.conjuntoResidencial.model.Persona"%>
<%@page import="com.conjuntoResidencial.dao.PersonaDAO.PersonaDAOImpl"%>
<%@page import="com.conjuntoResidencial.model.Recibo"%>
<%@page import="java.util.List"%>
<%@page import="com.conjuntoResidencial.dao.ReciboDAO.ReciboDAOImpl"%>
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
                    <h1 class="text-primary">Pago</h1>
                </div>
                <div class="col-2 offset-4">
                    <div id="volver">    
                        <a  href="index.jsp">Volver</a>
                    </div>
                </div>
            </div>

            <form action="Pago?action=save" method="post">
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="id">Id</label>
                            <input type="text" class="form-control" id="id" placeholder="Id" name="id">
                        </div>

                        <div class="form-group">
                            <label for="description">Tipo</label>
                            <input type="text" class="form-control" id="tipo" placeholder="Tipo" name="tipo">
                        </div>

                        <div class="form-group">
                            <label for="recibo">Recibo</label>
                            <select name="recibo" id="recibo" class="form-control">
                                <c:forEach items="${recibo}" var="recibo">
                                    <option selected value="${recibo.getNumero()}">${recibo.getNumero()} - ${recibo.getUsuario()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="persona">Usuario</label>
                            <select name="usuario" id="usuario" class="form-control">
                                <c:forEach items="${persona}" var="persona">
                                    <option selected value="${persona.getDocumento()}">${persona.getDocumento()} - ${persona.getNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="description">Valor</label>
                            <input type="text" class="form-control" id="valor" placeholder="Valor" name="valor">
                        </div>
                        <div class="form-group">
                            <label for="fecha">Fecha</label>
                            <input type="date" class="form-control" id="fecha" placeholder="Fecha" name="fecha">
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
                                    Tipo
                                </th>
                                <th>
                                    Recibo
                                </th>                   
                                <th>
                                    Usuario
                                </th>                   
                                <th>
                                    Valor
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
                            <c:forEach items="${pago}" var="pago">
                                <tr>
                                    <td>
                                        ${pago.getNumero()}
                                    </td>
                                    <td>
                                        ${pago.getTipo()}
                                    </td>
                                    <td>
                                        ${pago.getRecibo().getNumero()}
                                    </td>
                                    <td>
                                        ${pago.getUsuario()}
                                    </td>
                                    <td>
                                        ${pago.getValor()}
                                    </td>
                                    <td>
                                        <c:out value = "${pago.getFechapago()}"/>
                                    </td>
                                    <td>
                                        <a href="Pago?action=delete&id=${pago.getNumero()}" class="btn btn-danger">Eliminar</a>
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
