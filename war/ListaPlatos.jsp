<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="modelo.*" %>
<%@ page import="java.util.List" %>

<% List<Plato> platos = (List<Plato>) request.getAttribute("listaPlatos"); %>
<!-- INICIO FILTRO -->
			
<table class="table">
  	<col style="width:20%;" />
  	<col style="width:10%;" />
  	<col style="width:15%;" />
	<col style="width:30%;" />
	<col style="width:25%;" />
  	
      <tr>
        <th>Nombre</th>
        <th>Precio</th>
        <th>Categoria</th>
        <th>Imagen</th>
        <th>Opciones</th>
      </tr>
<% for(Plato v:platos){ %>
		<tr>
			<td style="vertical-align:middle;">
				<div><label><%= v.getNombre() %></label></div>
			</td>
			<td style="vertical-align:middle;">
				<div><label><%= v.getPrecio() %></label></div>
			</td>
			<td style="vertical-align:middle;">
				<div><label><%= v.getCategoria() %></label></div>
			</td>
			<td><div><img src="/serve?blob-key=<%=v.getKeyoutsideImage() %>" width="180px"></div></td>
			<td style="vertical-align:middle;">
				<div>
				<form action="modificarplato" style="display:inline-block">
					<input type="hidden" id="modificar" name="modificar" value="<%= v.getIdPlato() %>" />
					<input type="submit" class="btn btn-primary" id="modificar" value="Editar">
				</form>
				<form action="eliminarplato" style="display:inline-block">
					<input type="hidden" id="eliminar" name="eliminar" value="<%= v.getIdPlato() %>" />
					<input type="submit" class="btn btn-primary" id="eliminar" value="Eliminar">
				</form>
				</div>
			</td>
		</tr>
	<% } %>
</table>
	

<% request.removeAttribute("listaPlatos"); %>