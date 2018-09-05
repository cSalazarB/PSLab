<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="modelo.*" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<% Plato myPlato = (Plato) request.getAttribute("Plato");%>
<% BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bebida</title>
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
		
		<script type="text/javascript">	
			function validarFormulario(formulario) 
			{
				if( formulario.nombre.value == 0 || /^\s*$/.test(formulario.nombre.value) ){
					 alert ('Nombre no puede estar vacío o contener sólo espacios en blanco.');
					 return false;
				}
				if( formulario.precio.value == 0 || /^\s*$/.test(formulario.precio.value) ){
					 alert ('Precio no puede estar vacío o contener sólo espacios en blanco.');
					 return false;
				}		
				if( formulario.categoria.checked == 0 ){
					 alert ('Tiene que marcar una categoria.');
					 return false;
				}
				if( formulario.descripcion.value == 0 || /^\s*$/.test(formulario.descripcion.value) ){
					 alert ('Descripcion no puede estar vacío o contener sólo espacios en blanco.');
					 return false;
				}
				return true; // Si se verifican las condiciones enviar formulario	
			}
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
	
	<div class="clear"></div>
	
	<div class="mid-grids">
		
		<div class="panel panel-info">	
			<div class="container">
				<div class="row">
					<div class="col-md-4">
						<div class="jumbotron">
							<div class="container">
								<strong>Bienvenido al CRUD de platos.</strong><br>
								<em>Esta es la seccion para administrar los platos de resturante.</em>
							</div>
						</div>
					</div>
					<div class="col-md-7">
						<br>
						<div id="formulario">
							<strong>Modificar Plato</strong>
							<br><br>
							<div class="panel panel-primary">
								<div class="panel-body">
									<form class="form-horizontal" onsubmit="return validarFormulario(this)" action="<%= blobstoreService.createUploadUrl("/guardarplato") %>" method="post" enctype="multipart/form-data" >
										<input type="hidden" id="idPlato" name="idPlato" value="<%= myPlato.getIdPlato() %>" />
																									
										<div class="form-group">
											<label for="ejemplo_password_3" class="col-lg-2 control-label" for="nombre">Nombre</label>
											<div class="col-lg-10">
												<input type="text" class="form-control" placeholder="Nombre" id="nombre" name="nombre" value="<%= myPlato.getNombre() %>"/>
											</div>
										</div>
																		
										<div class="form-group">
											<label for="ejemplo_password_3" class="col-lg-2 control-label" for="precio">Precio</label>
											<div class="col-lg-10">
												<input type="text" class="form-control" placeholder="Precio" id="precio" name="precio" value="<%= myPlato.getPrecio() %>"/>
											</div>
										</div>
																		
										<div class="form-group">
											<label for="ejemplo_password_3" class="col-lg-2 control-label" for="Categoria">Categoria</label>
											<div class="radio col-lg-10">
											<% if(myPlato.getCategoria().equals("Entrada")){ %>
												<label class="radio"><input type="radio" id="categoria" name="categoria" value="Entrada" checked>Entrada</label>
												<label class="radio"><input type="radio" id="categoria" name="categoria" value="Plato de Fondo">Plato de Fondo</label>
												<label class="radio"><input type="radio" id="categoria" name="categoria" value="Postre">Postre</label>
											<%} %>
										  	<% if(myPlato.getCategoria().equals("Plato de Fondo")){ %>
										  		<label class="radio"><input type="radio" id="categoria" name="categoria" value="Entrada" >Entrada</label>
												<label class="radio"><input type="radio" id="categoria" name="categoria" value="Plato de Fondo" checked>Plato de Fondo</label>
												<label class="radio"><input type="radio" id="categoria" name="categoria" value="Postre">Postre</label>
											<%} %>
										  	<% if(myPlato.getCategoria().equals("Postre")){ %>
										  		<label class="radio"><input type="radio" id="categoria" name="categoria" value="Entrada" >Entrada</label>
												<label class="radio"><input type="radio" id="categoria" name="categoria" value="Plato de Fondo">Plato de Fondo</label>
												<label class="radio"><input type="radio" id="categoria" name="categoria" value="Postre" checked>Postre</label>
											<%} %>
											</div>
										</div>
										<div class="form-group">
											<label for="ejemplo_password_3" class="col-lg-2 control-label">Imagen actual</label>
											<div class="col-lg-4">
												<img src="/serve?blob-key=<%=myPlato.getKeyoutsideImage() %>" width="200px">
											</div>
										</div>								
										<div class="form-group">
											<label for="ejemplo_password_3" class="col-lg-2 control-label" for="imagen">Imagen</label>
											<div class="col-lg-10">
												<input type="file" class="btn btn-default" id="imagen_modi" name="imagen_modi" >
											</div>
										</div>
										
										<div class="form-group">
											<label for="ejemplo_password_3" class="col-lg-2 control-label" for="descripcion">Descripcion</label>
											<div class="col-lg-10">
												<input type="text" class="form-control" placeholder="Descripcion" id="descripcion" name="descripcion" value="<%=myPlato.getDescripcion()%>"/>
											</div>
										</div>
																		
										<div class="form-group">
											<div class="col-lg-12 enviar">
													<input type="reset" value="Limpiar" class="btn btn-default"/>
													<input type="submit" class="btn btn-default" value="Guardar cambios"/>
											</div>
										</div>
							
									</form>
								</div>
							</div>
							<br>
						</div>
					</div>
				</div>	
				
			</div>
		</div>
		<!-- FIN DE FORMULARIO-->
		
	</div>
	<!-- PIE DE PAGINA -->
	<div class="footer">
		<div class="top-to-page">
				<a href="#top" class="scroll"> </a>
				<div class="clear"> </div>
			</div>
			<p>2016 La Escondida SRL. Todos los derechos reservados</a></p>
	</div>

<!-- <input type="hidden" id="" value="lista" /> -->


<script src="js/bootstrap.min.js"></script>
<script src="js/bebidaAjax.js"></script>
</body>
</html>

