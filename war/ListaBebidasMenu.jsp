<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="modelo.*" %>
<%@ page import="java.util.List" %>

<% List<Bebida> bebidas = (List<Bebida>) request.getAttribute("listaBebidas"); %>
<form>
<div class="panel panel-info">
	<div class="panel-heading">
		<h3 class="panel-title">CATALOGO</h3>
	</div>
	<div class="panel-body operaciones">



<% int tam=0; %>
<% for(Bebida v:bebidas){ %>

<%if(tam==0) {%>
	<div class="row">
<% }%>	
	<div class="col-md-4">
		<img src="/serve?blob-key=<%=v.getKeyoutsideImage() %>" alt="..." class="img-thumbnail">
		<div class="panel panel-default">
			<div class="panel-body eleccion_comida">
				<div class="checkbox">
					<label><input type="checkbox" name="<%=v.getCategoria() %>" id="grupo" value="<%=v.getIdBebida()%>"><%=v.getNombre()%></label>
				</div>
				<div><input type="number" id="<%=v.getIdBebida()%>" class="form-control" placeholder="Cantidad" value="0"></div>
			</div>
		</div>
	</div>
	<%tam++;%>
	<%if(tam==3){%>
	</div>
	<%tam=0;} %>

<%} %>

 </div>
							
<div class="panel-footer enviar">
<div class="form-group">
	<input type="button" class="btn btn-primary btnop" id="agregar" value="AGREGAR">
</div>
</div>
</div>
</form>
<script type="text/javascript" src="js/menu2Ajax.js"></script>

