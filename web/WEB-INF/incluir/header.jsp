<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Deliver IT! é um sistema de disk-entrega">
        <meta name="author" content="Leonardo Dias, Vander, Octavio - PUC MINAS">

        <title>- Deliver IT! -</title>    

        <!-- Bootstrap Core CSS -->
        <link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="../resources/bootstrap/css/sb-admin.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="../resources/bootstrap/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- jQuery -->
        <script src="../resources/bootstrap/js/jquery.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="../resources/bootstrap/js/bootstrap.min.js"></script>
        <!-- RowSorter -->
        <script src="../resources/bootstrap/js/RowSorter.js"></script>
    </head>
    <%
        if (session.getAttribute("usuario") == null) {
            response.sendRedirect("../index.jsp");
        }
    %>