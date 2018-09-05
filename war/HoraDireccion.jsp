<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Pago</title>
	<link href="css/bootstrapu.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/styleu.css" rel="stylesheet" type="text/css" media="all"/>
	<link rel="stylesheet" type="text/css" href="css/style2u.css" />
	
	<!-- Custom Theme files -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!--fonts start-->
	<link href='//fonts.googleapis.com/css?family=Ruluko' rel='stylesheet' type='text/css'>
	<link href='//fonts.googleapis.com/css?family=Work+Sans:400,600,500,700,800,900,200,300' rel='stylesheet' type='text/css'>
	<!--//fonts-->
	<script type="text/javascript" src="js/jqueryu.js"></script>
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	
</head>
<body>

	<!--horizan start here-->
	<div class="top-navg ">
		<div class="container">
			<div class=" logo wow tada" data-wow-delay="0.3s">
				<a href="index.html"><img src="imagesu/logo.png" alt=""></a>
			</div>
			<div class="navigation">	
				<span class="menu-ic"><img src="imagesu/menu2.png" alt=""></span>
				<div class="menu menu-li">
						<ul class="menu-list">
						<li class="menu-item "><a href="index.html" class="menu-link">Inicio</a></li>
						<li class="menu-item"><a href="about.html" class="menu-link">Acerca de</a></li>
						<li class="menu-item"><a href="services.html" class="menu-link">Reservas</a></li>
						<li class="menu-item menu-item-current"><a href="menu.html" class="menu-link">Menu</a></li>
						<li class="menu-item"><a href="reclamos.html" class="menu-link">Reclamaciones</a></li>
						<li class="menu-item"><a href="contact.html" class="menu-link">Contacto</a></li>
					</ul>
				</div>
	
				 <script>
					   $( "span.menu-ic" ).click(function() {
						 $( ".navigation ul" ).slideToggle( 300, function() {
						 // Animation complete.
						  });
						 });
				</script>
			</div>
			<ul class=" head-icons wow bounceInRight" data-wow-delay="0.3s">
						 		<li><a href="#"><span class="fa"> </span></a></li>
						 		<li><a href="#"><span class="tw"> </span></a></li>
			</ul>
			<div class="clearfix"></div>
		</div>
	</div>
	
	<!--portfolio-->
	<div class="container">
		<div class="menu-grid-main">
			<div  id="five">
			
				<div id="formulario">
					<div class="temp-heading">
					    <h3 class="main-head"><img src="imagesu/logo.png" alt=""></h3>
					</div>
					
					<div>
						<div><label>Hora de entrega</label></div>
			    		<div><input type="time" class="form-control" value="09:30" id="hora"></div>
					</div>
						
					<div>
						<div><label>Direccion</label></div>
			    		<div><input type="text" placeholder="Direccion" class="form-control" id="direccion"></div>
					</div>
					<br>
					
					<div id="map" style="width: 50%; height: 400px; background-color: grey" class="form-control"></div>
			      	<script>
			      		function initMap() {
			      			var mapDiv = document.getElementById('map');
			      			var map = new google.maps.Map(mapDiv, {
			      				center: {lat: -16.4090474, lng: -71.53745099999998},
			      				zoom: 15
			      			});
			      		}
			    	</script>
			    	<script async defer
			        	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC1XVg_A7USRBvtAfbFKQu9XWWKw-Ok5Bk&callback=initMap">
			    	</script>
			    	
			    	<input type="button" class="btn btn-info" value="siguiente" id="AceptarCompra"/>
			    	<div id ="pago"></div>
			    	
			    	
				</div>   
			</div>
	
		</div>
	</div>
	
	<!--footer-->
	<!--footer end here-->
	    <div class="footer">
			<div class="container">
				<div class="footer-main">
				<div class="col-md-4 amet-sed wow bounceInDown" data-wow-delay="0.3s">
					<h4>Informacion</h4>
					<ul class="social">
						<li><span> </span>PJ. Tarapacá 103 Huaranguillo</li>
						<li class="phone"><span> </span> +054 667865</li>
						<li class="mail"><a href="mailto:restaurantescondida@gmail.com"><span> </span> restaurantescondida@gmail.com</a></li>
					</ul>
				</div>
					 
				<div class="col-md-5 ftr-grid wow bounceInUp" data-wow-delay="0.3s">
					<h4>Boletin Informativo</h4>
					<form>
						<input type="text"  placeholder="Email Address" required="">
					 	<input type="submit" value="subscribe">
				 	</form>
				</div>
				
				<div class="col-md-3 ftr-grid wow bounceInLeft" data-wow-delay="0.3s">
					<ul class="ftr-nav">
						<li><a href="index.html">Inicio</a></li>
						<li><a href="about.html">Acerca de</a></li>
						<li><a href="services.html">Reservas</a></li>
						<li><a href="menu.html">Menu</a></li>
						<li><a href="reclamos.html">Reclamaciones</a></li>
						<li><a href="contact.html">Contacto</a></li>
					 </ul>
				</div>
				
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>  
	
	<div class="copy-right wow shake" data-wow-delay="0.3s">
	    <p>© 2016 La Escondida SRL. Todos los derechos reservados</p>
	</div>
	<script type="text/javascript" src="js/pago.js"></script>
	<!-- animated-css -->
	<link href="css/animate.css" rel="stylesheet" type="text/css" media="all" />
	<script src="js/wow.min.js"></script>
	<script>
		new WOW().init();
	</script>
	<!-- animated-css -->
</body>
</html>