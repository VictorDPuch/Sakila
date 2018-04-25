<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="reset.css">
	<link href="https://fonts.googleapis.com/css?family=Lato:400,900" rel="stylesheet">
	<link rel="stylesheet" href="main.css">
	<title>Formulario</title>
</head>

<body>

	<div class="container">
		<div class="form__top">
			<h2><span>Registro</span></h2>
		</div>
		<form class="form__reg"
                    method="post" action="ServletDatos">
			<input class="input" type="text" name="NOMBRE" placeholder="&#128100;  Nombre(s)" required autofocus>
			<input class="input" type="text" name="APELLIDOPATERNO" placeholder="&#128100;  Apellido Paterno" required>
			<input class="input" type="text" name="APELLIDOMATERNO" placeholder="&#128100;  Apellido Materno" required>
			<input class="input" type="email" name="EMAIL" placeholder="&#9993;  Email" required>
			<input class="input" type="text" name="TELEFONO" placeholder="&#128222;  Telefono" required>
			
			<input class="input" type="text" name="DIRECCION" placeholder="&#8962;  Calle" required>
			<!--<input class="input" type="text" placeholder="&#8962;  Estado" required>
			<input class="input" type="number" placeholder="&#x0023;  Numero Vivienda" required>
			<input class="input" type="text" placeholder="&#8962;  Ciudad" required>
			<input class="input" type="text" placeholder="&#8962;  Codigo Postal" required>
   -->
				<div class="grid-container">
					<div class="grid-item">
<select name="GENERO">
   <option selected value="0">Genero</option>
       <option value="1">Hombre</option>
       <option value="2">Mujer</option>
</select>
	</div>
			<br/>
			<div class="grid-item">
			<h3>Fecha De Nacimiento</h3>
			<br/>
			<div class="dateinput">

				<input type="date" name="CUMPLEANIOS" step="1" min="1900-01-01" max="2040-12-31" value="<?php echo date(" Y-m-d ");">
			</div>
			</div>
			<br/>
<div class="grid-item">
			<select name="TIPOMIEMBRO">
<option selected value="0">Persona</option>
<option value="1">Maestro</option>
<option value="2">Dorcas</option>
<option value="3">Lider</option>
<option value="4">Visitante</option>
<option value="5">Diacono</option>
<option value="6">Pastor Principal</option>
</select>
</div>
			<br/>
<div class="grid-item">
			<select name="ESTADOCIVIL">
<option selected value="0">Estado Civil</option>
<option value="1">Soltero(a)</option>
<option value="2">Casado(a)</option>
<option value="3">Comprometido(a)</option>
<option value="4">Union Libre</option>
<option value="5">Viudo(a)</option>
<option value="6">Divorciado(a)</option>
<option value="7">Separado(a)</option>
</select>
</div>
<br/>
<!--
<div class="grid-item">
    
<select name="Clasificacion social">
<option selected value="0">Clasificacion social</option>
<option value="1">Adultos mayores</option>
<option value="2">Bebes</option>
<option value="3">Hombres</option>
<option value="4">Iglesia de ni?os</option>
<option value="5">Mujeres</option>
<option value="6">Jovenes 12-14</option>
<option value="7">Jovenes 18-25</option>
<option value="8">Sociedad de Jovenes</option>
</select>
</div>
<br/>
-->
<div class="grid-item">
<input type="checkbox" name="BAUTIZADO" value="true"> Bautizado<br>

</div>

	</div>
			<div class="btn__form">
				<input class="btn__submit" type="submit" name="Boton" value="Agregar">
				<input class="btn__reset" type="reset" value="LIMPIAR">
			</div>
		</form>
	</div>

</body>

</html>