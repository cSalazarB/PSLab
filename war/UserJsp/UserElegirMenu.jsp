<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Delicioso Menu</title>
	<link href="css/bootstrapu.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/styleu.css" rel="stylesheet" type="text/css" media="all"/>
	<link rel="stylesheet" type="text/css" href="css/style2u.css" />
	
	<!-- Custom Theme files -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--meta name="keywords" content="Hot Cuisine Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" /-->
	
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!--fonts start-->
	<link href='//fonts.googleapis.com/css?family=Ruluko' rel='stylesheet' type='text/css'>
	<link href='//fonts.googleapis.com/css?family=Work+Sans:400,600,500,700,800,900,200,300' rel='stylesheet' type='text/css'>
	<!--//fonts-->
	<script type="text/javascript" src="js/jqueryu.js"></script>
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	
</head>
<body onload="cargar('Entrada')">

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
	<div class="main-grid-one4" id="five">
	
		<div class="portfolio">
		    <div class="temp-heading">
			    <h3 class="main-head"><img src="imagesu/menu_de_dia.png" alt=""></h3>
			</div>
			<div class="list-group-horizontal" id="categorias">
					<input type="button" class="list-group-item active" value="Entrada" id="EntradaBtn"/>
					<input type="button" class="list-group-item" value="Platos de fondos" id ="FondoBtn"/>
					<input type="button" class="list-group-item" value="Postres" id ="PostreBtn"/>
					<input type="button" class="list-group-item" value="Gaseosas" id ="GaseosaBtn"/>
					<input type="button" class="list-group-item" value="Refrescos" id ="RefrescoBtn"/>
					<input type="button" class="list-group-item" value="Cervezas" id ="CervezaBtn"/>
			</div>
			<div class="menu-port" id="cuadros">
				<!-- AQUI SE AGREGA EL CODIGO DE LISTA DE PLATOS -->
			</div>
			
			<script type="text/javascript" src="js/MenuUser.js"></script>
	
			
	<!--enjoy-->
			<div class="enjoy-food">
				<div class="container">
					<h3>Disfrute de su almuerzo</h3>
				</div>
			</div>
	<!--portfolio-->
			<div class="portfolio-1">
			   <div class="container"> 
			   	 <div class="portfolio-1-main">
			   	 	<div class="col-md-4 port-right wow bounceInLeft" data-wow-delay="0.3s">
						<ul class="portfolio-grid">
							<li>
									<h5>Nuestro Solterito de Queso</h5>
									<p>Ligero, pero suculento. Este plato hecho con choclo, habas, cebolla, tomate, aceitunas y el maravilloso queso fresco es una tradicional ensalada andina que tranquilamente puede convertirse en un plato de fondo.</p>
							</li>
							<li><img class="top-grid" src="imagesu/p1.jpg" alt=""/></li>
						</ul>
					</div>
					
					<div class="col-md-4 port-right wow bounceInDown" data-wow-delay="0.3s">
						<ul class="portfolio-grid">
							<li>
									<h5>Un guiso típicamente peruano</h5>
									<p>El seco puede ser de cabrito, de cordero, de res, de gallina y de pescado, y por su aderezo de culantro constituye un manjar divino.</p>
							</li>
							<li><img class="top-grid" src="imagesu/p2.jpg" alt=""/></li>
						</ul>
					</div>
					
					
					<div class="col-md-4 port-right wow bounceInRight" data-wow-delay="0.3s">
						<ul class="portfolio-grid">
							<li>
									<h5>Un encurtido al plato</h5>
									<p>Es el "escabeche", nacido en la antigua cultura islámica y apreciado en nuestro suelo, como una carta de la amplia baraja de sabores y aromas de nuestra comida peruana.</p>
							</li>
							<li><img class="top-grid" src="imagesu/p3.jpg" alt=""/></li>
						</ul>
					</div>
		
					<div class="col-md-4 port-right wow bounceInUp" data-wow-delay="0.3s">
						<ul class="portfolio-grid">
							<li>
									<h5>Un rico estofado de cuy</h5>
									<p>Las propiedades nutricionales del cuy la hacen un alimento por excelencia para prevenir y combatir la anemia en niños, adultos mayores, mujeres gestantes y madres que dan de lactar.</p>
							</li>
							<li><img class="top-grid" src="imagesu/p4.jpg" alt=""/></li>
						</ul>
					</div>
					<div class="col-md-4 port-right wow bounceInUp" data-wow-delay="0.3s">
						<ul class="portfolio-grid">
							<li>
									<h5>De los platillos preferidos en la mesa</h5>
									<p>Nadie desprecia un buen trozo de milanesa, sea de carne, de pollo, de pescado o incluso de verduras es un manjar consentido en tu paladar.</p>
							</li>
							<li><img class="top-grid" src="imagesu/p5.jpg" alt=""/></li>
						</ul>
					</div>
					<div class="col-md-4 port-right wow bounceInLeft" data-wow-delay="0.3s">
						<ul class="portfolio-grid">
							<li>
									<h5>Un plato hecho a puro corazón</h5>
									<p>Antes, con carne de llama; hoy, con trozos de res. En el camino quedó la influencia española y la creatividad y sazón de los esclavos.</p>
							</li>
							<li><img class="top-grid" src="imagesu/p6.jpg" alt=""/></li>
						</ul>
					</div>
						<div class="clearfix"> </div>
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
	  
	</div>
	<script type="text/javascript" src="js/MenuUser.js"></script>
	<!-- animated-css -->
			<link href="css/animate.css" rel="stylesheet" type="text/css" media="all">
			<script src="js/wow.min.js"></script>
			<script>
			 new WOW().init();
			</script>
	<!-- animated-css -->


</body>
</html>