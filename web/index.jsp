<%-- 
    Document   : index.jsp
    Created on : 21/03/2016, 17:22:24
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>- Deliver IT! -</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="post" action="autenticado/index.jsp">
            Usuário:<br>
            <input type="text" name="usuario"><br>
            Senha:<br>
            <input type="password" name="senha"><br>
            <input type="submit" value="Acessar">
        </form>
    </body>
</html>
