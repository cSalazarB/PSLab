<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Mesa</title>
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	
	<meta charset="UTF-8" name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />

		<script type="text/javascript" src="js/move-top.js"></script>
		<link href="css/slider.css" rel="stylesheet" type="text/css"  media="all" />
		<link href="css/roboto.css" rel='stylesheet' type='text/css'>
		<script src="js/jquery.min.js"></script>

		<script type="text/javascript" src="js/jquery.easing.1.3.js"></script> 

	    <script type="text/javascript" src="js/camera.min.js"></script>
			<script type="text/javascript">
		   jQuery(function(){
				jQuery('#camera_wrap_1').camera({
					height: '250px',
					pagination: false,
				});
			});
	  	</script>
		<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
				});
			});
		</script>
	
	
</head>
<body>


<div class="slider"  id="top">					     
	<div class="camera_wrap camera_azure_skin" id="camera_wrap_1">									           
	      <div data-src="images/slider1.jpg">  </div> 
	      <div data-src="images/slider2.jpg">  </div>
	      <div data-src="images/slider3.jpg">  </div>
	      <div data-src="images/slider4.jpg">  </div>
	</div>	
	<div class="clear"> </div>				       
</div>

<div class="clear"> </div>

	<div class="contenedor">
		<div class="top-header top-head">
			<div class="container">
				<img src="images/logo.png" title="logo" />
				<strong>Tradicion Arequipeña</strong>
			</div> 	
			<div class="clear"> </div>
		</div>
	</div>
	
	<div class="content">
		<div class="top-grids">
			<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
				<div class="container">
					<div class="navbar-header"><a class="navbar-brand" href="#">Usuarios</a></div>
					<ul class="nav navbar-nav">
						<li><a href="admin.jsp">Inicio</a></li>
						<li><a href="Bebida.jsp">Bebidas</a></li>
						<li><a href="Plato.jsp">Platos</a></li>
						<li class="active"><a href="#">Mesas</a></li> 
						<li><a href="Menu.jsp">Menu del dia</a></li> 
					</ul>
					
					<form class="navbar-form navbar-right" role="search">
						<div class="form-group"><input type="text" class="form-control" placeholder="Buscar"></div>
						<button type="submit" class="btn btn-default">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</form>
				</div>
			</nav>
		</div>
	</div>
	
	<div class="clear"></div>
	
	<div class="mid-grids">
		<div class="row">
			<!-- INICIO FILTRO -->
			<div class="col-md-4">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">Categoria</h3>
					</div>
					
					<!-- INICIO DE FILTRO DE BEBIDAS -->
					<!--div class="panel-body" id="filtro">
						<select class="form-control" id="buscarplato">
							<option value="Entreda">ENTRADAS</option>
							<option value="Plato de Fondo">PLATOS DE FONDO</option>
							<option value="Postre">POSTRES</option>
						</select>
					</div>
					<!-- FIN DE FILTRO DE BEBIDAS -->
				</div>
			</div>
			<!-- FIN FILTRO -->
			
			<!-- INICIO DE OPERACIONES -->
			<div class="col-md-8">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">OPERACIONES</h3>
					</div>
					<div class="panel-body operaciones">
					<!-- Indica una acción exitosa o positiva -->
						<a href="Mesa.jsp"><button type="button" class="btn btn-primary btnop" value="Nuevo">NUEVO</button></a>
					<!-- Indica una acción exitosa o positiva -->
						<button type="button" class="btn btn-primary btnop" id="modificar" value="Modificar">MODIFICAR</button>
					<!-- Indica una acción exitosa o positiva -->
						<button type="button" class="btn btn-primary btnop" id="eliminar" value="Eliminar">ELIMINAR</button>
					</div>
				</div>
			</div>
			<!-- FIN DE OPERACIONES -->
		</div>
		
		<div class="row">
			<!-- INICIO DE TABLA -->
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-body" id="tabla"></div>
				</div>
			</div>
			<!-- FIN TABLA -->
			
			<!-- INICIO FORMULARIO -->
			<div class="col-md-8">
				<div class="panel panel-primary">
					<div class="panel-body">
						<form class="form-horizontal" role="form">
							<div id="formulario">
								<input type="hidden" id="idMesa" name="idMesa" value="" />
								<!--div class="form-group">
									<label for="ejemplo_email_3" class="col-lg-2 control-label">ID</label>
									<div class="col-lg-10">
										<input type="text" class="form-control" placeholder="ID" disabled>
									</div>
								</div-->
																
								<div class="form-group">
									<label for="ejemplo_password_3" class="col-lg-2 control-label" for="nombre">Nombre</label>
									<div class="col-lg-10">
										<input type="text" class="form-control" placeholder="Nombre" id="nombre" name="nombre" value=""/>
									</div>
								</div>
								
								<div class="form-group">
									<label for="ejemplo_password_3" class="col-lg-2 control-label" for="sillas">Num. Sillas</label>
									<div class="col-lg-10">
										<input type="text" class="form-control" placeholder="Sillas" id="sillas" name="sillas" value=""/>
									</div>
								</div>
								
								<div class="form-group">
									<label for="ejemplo_password_3" class="col-lg-2 control-label" for="imagen">Imagen</label>
									<div class="col-lg-10">
										<input type="file" class="btn btn-default" id="imagen" name="imagen" accept="image/*">
									</div>
								</div>
								
								<div class="form-group">
									<label for="ejemplo_password_3" class="col-lg-2 control-label" for="disponible">Disponible</label>
									<div class="col-lg-10">
										<input type="checkbox" class="form-control" placeholder="Disponible" id="disponible" name="disponible" value="true"/>
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-lg-12 enviar">
										<input type="reset" value="Limpiar" class="btn btn-default"/>
										<input type="button" class="btn btn-default" id="submit" value="Añadir"/>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- FIN DE FORMULARIO -->
		</div>
	</div>

<input type="hidden" id="list" value="lista" />

<script type="text/javascript" src="js/mesaAjax.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>