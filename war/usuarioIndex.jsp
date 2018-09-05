<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modelo.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%
UserService us = (UserService) this.getServletContext().getAttribute("usuario");
List<Permiso> permisos = (List<Permiso>) request.getAttribute("permisos");
Usuario user = (Usuario) request.getAttribute("usuario");
List<Recurso> recursos = (List<Recurso>) request.getAttribute("recursos");

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Inicio Usuario</title>
  </head>

  <body>
    <h1>Hello , <%= user.getNomber() %></h1>
	
    <table> 
   	 <tr>
        <td> <h4> Tipo: <%=user.getTipoNombre() %></h4></td>
      </tr>   
      <tr>
        <td> <h4> Email: <%=user.getEmail() %></h4></td>
      </tr> 
      
       <tr>
        <td><a href='<%= us.createLogoutURL("/gmailServlet") %>'> Cerrar sesión </a></td>
      </tr>
    </table>
    
    <h3> Lista de Recursos </h3><hr>
    <table border ="0" style="text-align:center">
    
		<ol>
		<%
    	if(permisos.get(0).getEnable()){
    	%>
			<li><a href="/Bebida.jsp">BEBIDA</a>
		<% } %>
		<%
    	if(permisos.get(1).getEnable()){
    	%>
			<li><a href="/Plato.jsp">PLATO</a>
		<% } %>
		<%
    	if(permisos.get(2).getEnable()){
    	%>
			<li><a href="/Mesa.jsp">Mesa</a>
		<% } %>
		<%
    	if(permisos.get(3).getEnable()){
    	%>
			<li><a href="/Menu.jsp">Menu</a>
		<% } %>
			<li><a href='<%= us.createLogoutURL("/gmailServlet") %>'> Cerrar sesión </a>
		</ol>
    </table>
 
  </body>
</html>
