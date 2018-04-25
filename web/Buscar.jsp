<%-- 
    Document   : Buscar
    Created on : 24-abr-2018, 22:49:36
    Author     : victor-puch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="reset.css">
	<link href="https://fonts.googleapis.com/css?family=Lato:400,900" rel="stylesheet">
	<link rel="stylesheet" href="main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Busqueda</h1>
         <form method="post" action="ServletDatos">
         <input class="input" type="text" name="NOMBRE" placeholder="&#128100;  Nombre(s)" required autofocus>
	 <input class="input" type="text" name="APELLIDOPATERNO" placeholder="&#128100;  Apellido Paterno" required>
         <input type ="submit" name="Boton" value="Buscar" class="texto">
        </form>
    </body>
</html>
