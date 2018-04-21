<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
        <title>Lista</title>
    </head>
       <link href="Estilo.css" rel="stylesheet" type="text/css">
      <form method="post" action="ServletDatos">
       <body>

        <table align="center" width="289" border="1" class="datos_form">
            <tr>
                <td>Id Actor</td>
                <td>Nombre</td>
            </tr>
            <tr>
                <td><input type ="text" name="ID" class="texto"></td>
                <td><input type ="text" name="APELLIDO" class="texto"></td>
                <td><input type ="submit" name="Buscar" class="texto"></td>
            </tr>

        </table>
    </body>
</html>
