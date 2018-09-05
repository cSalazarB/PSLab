<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modelo.*"%>
<%@ page import="java.util.List"%>

<!DOCTYPE HTML>
<html lang="es">
<head>
<title>tabla</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="description" content="Ejemplos de proyectos de aplicaciones Web con Google App Engine.">
<meta name="keywords" content="Google app engine,Servlets,Java,GAE,HTML,CSS,JSP,Eclipse">
<link rel="icon" type="image/png" href="http://indice-ejemplos.appspot.com/Java-icon.png"> 
<link rel="stylesheet" type="text/css" href="http://indice-ejemplos.appspot.com/miestilo.css">
<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>-->
<script src="js/jquery.a.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#change').click(function(event){
		var varPer="";
		 
	    $("input[name='enable']").each(function() { 
	    	if(this.checked){
	    	varPer += "1";
	    	}
	    	else {
	    	varPer += "0";
	    	}
	    	
	    });	    
	    $.get('cambiarPermisos',{
			permisos:varPer
		}, function(responseText){			
			$('#resultado').html(responseText);
		});
	    	
	    	
	});	
	
});

</script>
</head>
<body>
<div>

<%
List<Tipo> tipos = (List<Tipo>)request.getAttribute("tipos");
List<Recurso> recursos = (List<Recurso>)request.getAttribute("recursos");
List<Permiso> permisos = (List<Permiso>)request.getAttribute("permisos");
System.out.println("rec: "+recursos.size());
System.out.println("tip: "+tipos.size());
System.out.println("per: "+permisos.size());
int size = recursos.size();
int pos;
%>

<table border="1" style="text-align:center">
<tr>
<th></th>
<%
for(Recurso rec: recursos){
%>
<th> <%= rec.getNombre() %> </th>
<%} %>
</tr>

<% //p = permiso; i = recursos
	int p = 0; 
	for(Tipo tip: tipos) { %>
  <tr>	
	<td> <%= tip.getNombre() %> </td>
	<% String sal="";
	for(int i = 0; i < size; i++, p++){ //size+pos
		boolean v = permisos.get(i).getEnable();
		if(v)sal+="1";
		else sal+="0";
		if(permisos.get(p).getEnable()){ %>
		<td> <input type="checkbox" name="enable"  checked /> </td>
		<%} else{ %>
		<td> <input type="checkbox" name="enable" /> </td>
		<% } %>
	<%} System.out.println("impr: "+sal); %>	
  </tr>
<% } %>

</table><br>
<button  type="button" id="change" > Cambiar</button>
</div>
<div id="resultado"></div>
</body>
</html>