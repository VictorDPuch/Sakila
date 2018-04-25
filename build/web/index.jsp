<%-- 
    Document   : index
    Created on : 24-abr-2018, 20:04:11
    Author     : victor-puch
--%>

<!DOCTYPE html>
<html lang="en">
    <head>
       <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="reset.css">
	<link href="https://fonts.googleapis.com/css?family=Lato:400,900" rel="stylesheet">
	<link rel="stylesheet" href="tablas.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pagina Principal</h1>
        <a href="Registro.jsp">Registrar</a>
        <a href="Buscar.jsp">Buscar</a>
         <form method="post" action="ServletDatos">
         <input type ="submit" class="btn__lista" name="Boton" value="Listado" class="texto">
        </form>
    </body>
</html>
