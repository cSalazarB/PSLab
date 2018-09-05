<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modelo.*"%>
<%@ page import="java.util.List"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
<title>Programación Web con Google App Engine</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="description" content="Ejemplos de proyectos de aplicaciones Web con Google App Engine.">
<meta name="keywords" content="Google app engine,Servlets,Java,GAE,HTML,CSS,JSP,Eclipse">
<link rel="icon" type="image/png" href="http://indice-ejemplos.appspot.com/Java-icon.png"> 
<link rel="stylesheet" type="text/css" href="http://indice-ejemplos.appspot.com/miestilo.css">
</head>
<body>
<!-- Menú de navegación del sitio -->
<div>

<%
List<Tipo> tipos = (List<Tipo>)request.getAttribute("tipos");
String email = (String) request.getAttribute("email");
%>

<h1> Agregar Usuario</h1> <hr>
<fieldset>
<form action="saveUsuario" method="get">
<table>

<tr>
<td><label> Nombre: </label> </td>
<td><input type="text" name="nombre" /> <input type="hidden" name="email" value='<%= email %>'/> </td>
</tr>



<tr>
<td><label> Tipo: </label> </td>
<td> 
<select name="tipo">
<%for(Tipo tip : tipos){ %>
<option value=<%=tip.getId()%> ><%= tip.getNombre() %> </option>
<% }%>
</select>
</td>
</tr>

<tr>
<td></td>
<td><fieldset><legend>Sexo:</legend><label> Hombre: </label><input type="radio" name="sexo" value="0"/>
 <label> Mujer: </label> <input type="radio" name="sexo" value="1" /></td></fieldset>
</tr>

<tr>
<td></td>
<td><input type="submit" value="Registrar" /></td>
</tr>

</table>
</fieldset>
</form>

</div>
</body>
</html>