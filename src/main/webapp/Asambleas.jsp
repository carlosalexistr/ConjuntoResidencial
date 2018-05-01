<%-- 
    Document   : Asambleas
    Created on : 1/05/2018, 05:29:40 PM
    Author     : Julian Olarte Torres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mostrando Asambleas!</h1>
        <table>
            <thead>
                <tr>
                    <th>
                        Fecha
                    </th>
                    <th>
                        Descripcion
                    </th>
                    <th>
                        Lugar
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${asambleas}" var="asamblea">
                    <tr>
                        <td>
                            <c:out value="${asamblea.getFecha()}"/>
                        </td>
                        <td>
                            ${asamblea.getDescripcion()}
                        </td>
                        <td>
                            ${asamblea.getLugar()}
                        </td>
                    </tr>
                </c:forEach>
        </tbody>

    </table>
</body>
</html>
