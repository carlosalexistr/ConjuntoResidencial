<%-- 
    Document   : Asambleas
    Created on : 8/05/2018, 05:29:40 PM
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
        <title>Detalle Recibo</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-6">
                    <h1 class="text-primary">Detalle Recibo</h1>
                </div>
                <div class="col-2 offset-4">
                    <div id="volver">    
                        <a  href="index.jsp">Volver</a>
                    </div>
                </div>
            </div>

            <form action="DetalleRecibo?action=save" method="post">
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="recibo">Recibo</label>
                            <select class="custom-select" id="recibo" name="recibo">
                                <c:forEach items="${recibos}" var="recibo">
                                    <option selected value="${recibo.getNumero()}">${recibo.getNumero()} - ${recibo.getUsuario()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="concepto">Concepto</label>
                            <select class="custom-select" id="concepto" name="concepto">
                                <c:forEach items="${conceptos}" var="concepto">
                                    <option selected value="${concepto.getId()}">${concepto.getId()} - ${concepto.getDescripcion()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="valor">Valor</label>
                            <input type="text" class="form-control" id="valor" placeholder="Valor" name="valor">
                        </div>
                        <div class="form-group">
                            <label for="observacion">Observacion</label>
                            <input type="text" class="form-control" id="observacion" placeholder="Observacion" name="observacion">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="usuario">Usuario</label>
                            <input type="text" class="form-control" id="usuario" placeholder="Usuario" name="usuario">
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
                                    Recibo
                                </th>
                                <th>
                                    Concepto
                                </th>                   
                                <th>
                                    Valor
                                </th>                   
                                <th>
                                    Observacion
                                </th>                   
                                <th>
                                    usuario
                                </th>                   
                                <th>
                                    Acciones
                                </th>                   
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${detalles}" var="detalle">
                                <tr>
                                    <td>
                                        ${detalle.getRecibo1().getNumero()}
                                    </td>
                                    <td>
                                        ${detalle.getConcepto1().getId()}
                                    </td>
                                    <td>
                                        <c:out value = "${detalle.getValor()}"/>
                                    </td>
                                    <td>
                                        <c:out value = "${detalle.getObservacion()}"/>
                                    </td>
                                    <td>
                                        <c:out value = "${detalle.getUsuario()}"/>
                                    </td>
                                    <td>
                                        <a href="DetalleRecibo?action=delete&recibo=${detalle.getRecibo1().getNumero()}&concepto=${detalle.getConcepto1().getId()}" class="btn btn-danger">Eliminar</a>
                                        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal${detalle.getRecibo1().getNumero()}-${detalle.getConcepto1().getId()}">Actualizar</button>

                                        <!-- Modal -->
                                        <div id="myModal${detalle.getRecibo1().getNumero()}-${detalle.getConcepto1().getId()}" class="modal fade" role="dialog">
                                            <div class="modal-dialog">

                                                <!-- Modal content-->
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title"></h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p>Editar el Registro ${detalle.getRecibo1().getNumero()}-${detalle.getConcepto1().getId()}</p>

                                                        <form action="DetalleRecibo?action=editar" method="post">
                                                            <div class="row">
                                                                <div class="col-6">
                                                                    <div class="form-group">
                                                                        <label for="recibo">Recibo</label>
                                                                        <input type="text" value="${detalle.getRecibo1().getNumero()}" class="form-control" id="recibo" placeholder="Recibo" name="recibo" readonly>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="concepto">Concepto</label>
                                                                        <input type="text" value="${detalle.getConcepto1().getId()}" class="form-control" id="concepto" placeholder="Concepto" name="concepto" readonly>
                                                                    </div>
                                                                </div>
                                                                <div class="col-6">
                                                                    <div class="form-group">
                                                                        <label for="valor">Valor</label>
                                                                        <input type="text" value="${detalle.getValor()}" class="form-control" id="valor" placeholder="Valor" name="valor">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="observacion">Observacion</label>
                                                                        <input type="text" value="${detalle.getObservacion()}" class="form-control" id="observacion" placeholder="Observacion" name="observacion">
                                                                    </div>
                                                                </div>
                                                                <div class="col-6">
                                                                    <div class="form-group">
                                                                        <label for="usuario">Usuario</label>
                                                                        <input type="text" value="${detalle.getUsuario()}" class="form-control" id="usuario" placeholder="Usuario" name="usuario">
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

