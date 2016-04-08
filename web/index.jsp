<%-- 
    Document   : index.jsp
    Created on : 21/03/2016, 17:22:24
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <title>- Deliver IT! -</title>
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/bootstrap/css/login.css" rel="stylesheet">
        
        

    </head>
    <body>
        <div class="container">            
            <form class="form-login" method="post" action="LoginController">
                <h2 class="form-login-heading">Deliver IT!</h2>                
                    <label for="inputUsuario" class="sr-only">Nome do Usuário</label>
                    <input name="usuario" type="usuario" id="inputUsuario" class="form-control" placeholder="Nome do Usuário" required autofocus>
                    <label for="inputSenha" class="sr-only">Senha</label>
                    <input name="senha" type="senha" id="inputSenha" class="form-control" placeholder="Senha" required>
                    <button class="btn btn-lg btn-primary btn-block" type="submit"> Entrar </button>
            </form>
        </div>
    </body>
</html>
