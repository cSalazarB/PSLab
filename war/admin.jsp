<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modelo.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%UserService us = (UserService) this.getServletContext().getAttribute("usuario");%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>cuision Website Template | Home :: W3layouts</title>
		<meta charset="UTF-8" name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />

		<script type="text/javascript" src="js/move-top.js"></script>
		<link href="css/slider.css" rel="stylesheet" type="text/css"  media="all" />
		<link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.easing.1.3.js"></script> 

	    <script type="text/javascript" src="js/camera.min.js"></script>
			<script type="text/javascript">
		   jQuery(function(){
				jQuery('#camera_wrap_1').camera({
					height: '300px',
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
		<!---start-wrap---->
			<!---start-header---->
			<!----start--imageslider----->
		       <!--start-image-slider---->
								<div class="slider"  id="top">					     
										<div class="camera_wrap camera_azure_skin" id="camera_wrap_1">									           
											      <div data-src="images/slider1.jpg">  </div> 
											      <div data-src="images/slider2.jpg">  </div>
											      <div data-src="images/slider3.jpg">  </div>
											      <div data-src="images/slider4.jpg">  </div>
										</div>	
										<div class="clear"> </div>				       
							 	</div>
		      			<!--End-image-slider---->
		      			<div class="clear"> </div>
		      			
		      		<div class="top-grids">
						<!-- relleno2 -->
					</div>
					<div class="contenedor">
			     		 <div class="top-header">
			     		 			<div class="container"><img src="images/logo.png" title="logo" /><img src="images/logo_b.png" title="logo2" /></div>
			     		 	<div class="clear"> </div>
			     		 	
			     		 </div>
			     		
					</div>
					<!---End-content---->
						<div class="top-grids">
							<!-- relleno -->
						</div>
						
						<div class="mid-grids">

							<div class="top-grid">
								<h3>USUARIOS</h3>
								<img src="images/usuarios.jpg" title="image-name" />
								<a href="#">Ir a</a>
							</div>
							<div class="top-grid">
								<h3>BEBIDAS</h3>
								<img src="images/bebidas.jpg" title="image-name" />
								<a href="/Bebida.jsp">Ir a</a>
							</div>
							<div class="top-grid" id="last-grid">
								<h3>PLATOS</h3>
								<img src="images/platos.jpg" title="image-name" />
								<a href="/Plato.jsp">Ir a</a>
							</div>
							<div class="clear"> </div>

							<div class="top-grid">
								<h3>MESAS</h3>
								<img src="images/mesas.png" title="image-name" />
								<a href="/Mesa.jsp">Ir a</a>
							</div>
							<div class="top-grid">
								<h3>MENU DEL DIA</h3>
								<img src="images/menu_dia.jpg" title="image-name" />
								<a href="/Menu.jsp">Ir a</a>
							</div>
							<div class="top-grid" id="last-grid">
								<h3>Cerrar sesion</h3>
								<img src="images/volver_usuario.png" title="image-name" />
								<a href="<%= us.createLogoutURL("/gmailServlet") %>">Ir a</a>
							</div>
							<div class="clear"> </div>
							<br><br>
							<ul class="nav nav-pills">
								<li><a href="tipos.jsp">Agregar Tipo</a></li>
								<li><a href="recursos.jsp">Agregar Recurso</a></li>
								<li><a href="listPermisos">Lista Permisos</a></li>
								<li><a href="listUsuario">Lista Usuario</a></li>
							</ul>
						</div>

						<div class="footer">
							<div class="top-to-page">
									<a href="#top" class="scroll"> </a>
									<div class="clear"> </div>
								</div>
								<p>2016 La Escondida SRL. Todos los derechos reservados</a></p>
						</div>
					
			<script src="js/bootstrap.min.js"></script>
	</body>
</html>

