<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ACTUALIZACIONES</title>
    </head>
     <link href="Estilo.css" rel="stylesheet" type="text/css">
      <form method="post" action="ServletDatos">
       <body>

        <table align="center" width="289" border="1" class="datos_form">
          <tr class=titulo_tabla><td colspan=2>DATOS </td></tr>
            <tr>
               <td>ID</td>
               <td><input type ="text" name="ID" class="texto"></td>
                
            </tr>
            <tr>
                <td>Nombre</td>
                <td><input type ="text" name="NOMBRE" class="texto"></td>
            </tr> 
             <tr>
                <td>Apellido</td>
                <td><input type ="text" name="APELLIDO" class="texto"></td>
            </tr> 
             <tr>
                <td>Fecha</td>
                <td><input type ="text" name="FECHA" class="texto"></td>
            </tr> 
            

        </table>
           <table align="center">
               <tr></tr>
               <tr>  
                <td><input type ="submit" name="Boton" value="Agregar" class="texto"></td>
                <td><input type ="submit" name="Boton" value="Actualizar" class="texto"></td>
                <td><input type ="submit" name="Boton" value="Eliminar" class="texto"></td>
                <td><input type ="submit" name="Boton" value="Listado" class="texto"></td>
            </tr>
               
           </table>
       </body>
      </form>
</html>
