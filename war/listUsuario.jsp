<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modelo.*"%>
<%@ page import="java.util.List"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
<title>Usuarios</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="description" content="Ejemplos de proyectos de aplicaciones Web con Google App Engine.">
<meta name="keywords" content="Google app engine,Servlets,Java,GAE,HTML,CSS,JSP,Eclipse">
<meta name="author" content="Richart Escobedo (rescobedo)">
<link rel="icon" type="image/png" href="http://indice-ejemplos.appspot.com/Java-icon.png"> 
<link rel="stylesheet" type="text/css" href="http://indice-ejemplos.appspot.com/miestilo.css">
</head>
<body>
<!-- Menú de navegación del sitio -->

<%
List<Usuario> usuarios = (List<Usuario>)request.getAttribute("usuarios");
%>
<h3> Lista de Usuarios</h3> <hr>

<table border="1" style="text-align:center"> 
<tr>
<th> Nro </th>
<th> Nombre </th>
<th> Email </th>
<th> Tipo </th>
</tr>	

<% int i=1;for( Usuario p : usuarios) { %>	
	<tr>
		<td><p><%= i %></p></td>
		<td><p><%= p.getNomber() %></p></td>
		<td><p><%= p.getEmail() %></p></td>		
		<td><p><%= p.getTipoNombre() %></p></td>
	</tr>
<% i++;} %>
</table>
</body>
</html>