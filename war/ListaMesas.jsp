<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="modelo.*" %>
<%@ page import="java.util.List" %>

<% List<Mesa> mesas = (List<Mesa>) request.getAttribute("listaMesas"); %>

<table class="table table-striped">
<% for(Mesa v:mesas){ %>
	<tr>
		<td><label ><input type="checkbox" name="eliminar" id="eliminarm" value="<%=v.getIdMesa() %>"/></label></td>
		<td><div><label><%= v.getNombre() %></label></div></td>
	</tr>
<% } %>
</table>