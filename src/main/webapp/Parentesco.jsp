<%-- 
    Document   : Parentesco
    Created on : 2/05/2018, 09:09:58 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Parentesco</h1>

        <form action="ParentescoController?action=save" method="post">
            <ul>
                <li><label>Id</label><input type="text" name="id">
                </li>
                <li><label>Descripcion</label><input type="text" name="descripcion">
                </li>
                <br>
                <li><input type="submit" value="registrar" name=""> </li>
            </ul>
        </form>
        
          <table>
            <thead>
                <tr>
                    <th>
                        Id
                    </th>
                    <th>
                        Descripcion
                    </th>                   
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${parentesco}" var="parentesco">
                <tr>
                <td>
                    ${parentesco.getId()}
                </td>
                <td>
                    ${parentesco.getDescripcion()}
                </td>
                </tr>
            </c:forEach>
        </tbody>

    </table>
        <br><br>
        <br>
        
        <form action="ParentescoController?action=delete" method="post">
            <ul>
                <li><label>Id</label><input type="text" name="id">
                </li>
                <br>
                <li><input type="submit" value="eliminar" name=""> </li>
            </ul>
        </form>


</body>
</html>
