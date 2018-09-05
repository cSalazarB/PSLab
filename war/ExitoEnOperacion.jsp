<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="common.*" %>
<% String clase1, clase2; %>
<% clase1 = clase2 = ""; %>
<% String tipo_producto = (String) session.getAttribute("tipo_producto");%>
<% String operacion = (String) session.getAttribute("operacion");%>
<% if( tipo_producto.equals("bebidas") ){ %>
<% 	clase1 = "class=\"active\""; %>			
<%}else{ %>
<%	clase2 =  "class=\"active\""; %>
<%}%>
<html>
	<head>
		<title>Finalizar Nuevo producto</title>
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
		      			
		      	
					<div class="contenedor">
			     		 <div class="top-header top-head">
			     		 			<div class="container"><img src="images/logo.png" title="logo" /><strong>Tradicion Arequipeña</strong></div> 	
			     		 	<div class="clear"> </div>
			     		 	
			     		 </div>
			     		
					</div>
					<!---End-content---->
					
						<div class="top-grids">

							<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
							<div class="container">
							    <div class="navbar-header">
							      	<a class="navbar-brand" href="#">Usuarios</a>
							    </div>
							    <ul class="nav navbar-nav">
							    	<li><a href="admin.jsp">Inicio</a></li>
							      	<li <%= clase1.toString() %>><a href="Bebida.jsp">Bebidas</a></li>
							      	<li <%= clase2.toString() %>><a href="Plato.jsp">Platos</a></li>
							      	<li><a href="Mesa.jsp">Mesas</a></li> 
							      	<li><a href="Menu.jsp">Menu del dia</a></li> 
							    </ul>

							    <form class="navbar-form navbar-right" role="search">
							      <div class="form-group">
							        <input type="text" class="form-control" placeholder="Buscar">
							      </div>
							      <button type="submit" class="btn btn-default">
							      	<span class="glyphicon glyphicon-search"></span>
							      </button>
							    </form>
							</div>
							  	 
							</nav>
						</div>
					
					<div class="clear"></div>
					<div class="mid-grids">
						
						<div class="panel panel-info">	
							<div class="jumbotron">
								<div class="container">
									<strong>
									¡ Exito al <%= operacion.toString() %> el producto ! 
									</strong><br>
									<em>Puede seguir utilizando las opciones para administrar los productos del resturante.</em><br><br>
									<ul class="nav nav-pills">
									  <li class="active"><a href="<%= ( tipo_producto.equals("bebidas") ) ? "Bebida.jsp" : "Plato.jsp" %>" >Volver</a></li>
									</ul>
								</div>
							</div>
						</div>
						
					</div>	
					<!-- PIE DE PAGINA -->
					<div class="footer">
						<div class="top-to-page">
								<a href="#top" class="scroll"> </a>
								<div class="clear"> </div>
							</div>
							<p>2016 La Escondida SRL. Todos los derechos reservados</a></p>
					</div>
			
			<script src="js/bootstrap.min.js"></script>
			<script src="js/bebidaAjax.js"></script>
	</body>
	<% session.removeAttribute("tipo_producto");%>
	<% session.removeAttribute("operacion");%>
</html>

