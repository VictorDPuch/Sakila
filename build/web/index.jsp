<%-- 
    Document   : index
    Created on : 24-abr-2018, 20:04:11
    Author     : victor-puch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="reset.css">
	<link href="https://fonts.googleapis.com/css?family=Lato:400,900" rel="stylesheet">
	<link rel="stylesheet" href="main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pagina Principal</h1>
        <a href="Registro.jsp">Registrar</a>
         <form method="post" action="ServletDatos">
         <input type ="submit" name="Boton" value="Listado" class="texto">
        </form>
    </body>
</html>
