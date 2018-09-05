<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="modelo.*" %>

<% Mesa myMesa = (Mesa) request.getAttribute("Mesa");%>
<input type="hidden" id="idMesa" name="idMesa" value="<%=myMesa.getIdMesa() %>" />
													
<div class="form-group">
	<label for="ejemplo_password_3" class="col-lg-2 control-label" for="nombre">Nombre</label>
	<div class="col-lg-10">
		<input type="text" class="form-control" placeholder="Nombre" id="nombre" name="nombre" value="<%=myMesa.getNombre()%>"/>
	</div>
</div>
								
<div class="form-group">
	<label for="ejemplo_password_3" class="col-lg-2 control-label" for="sillas">Num. Sillas</label>
	<div class="col-lg-10">
		<input type="text" class="form-control" placeholder="Sillas" id="sillas" name="sillas" value="<%=myMesa.getNumSillas()%>"/>
	</div>
</div>
								
<div class="form-group">
	<label for="ejemplo_password_3" class="col-lg-2 control-label" for="imagen">Imagen</label>
	<div class="col-lg-10">
		<input type="file" class="btn btn-default" id="imagen" name="imagen" accept="image/*" value="<%=myMesa.getImagen()%>"/ >
	</div>
</div>
								
<div class="form-group">
	<label for="ejemplo_password_3" class="col-lg-2 control-label" for="disponible">Disponible</label>
	<div class="col-lg-10">
		<input type="checkbox" class="form-control" placeholder="Disponible" id="disponible" name="disponible" value="<%=myMesa.getDisponible()%>"/>
	</div>
</div>
								
<div class="form-group">
	<div class="col-lg-12 enviar">
	<input type="reset" value="Limpiar" class="btn btn-default"/>
	<input type="button" class="btn btn-default" id="guardar" value="Guardar"/>
</div>
</div>
<script type="text/javascript" src="js/mesaAjax.js"></script>