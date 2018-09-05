<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<%  BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();%>

<ul class="nav nav-tabs">
  <li><a href="Bebida.jsp">Bienvenido</a></li>
  <li class="active"><a href="" onclick="return RegistrarProducto();">Añadir Nuevo</a></li>
  <li><a href="" onclick="">Registro de platos</a></li>
</ul>
<div class="panel panel-info">	
		<div class="container">
			
			<div class="col-md-8 col-md-offset-2">
			<br>
			<strong>Añadir nueva bebida</strong>
			<br><br>
				<div class="panel panel-primary">
					<div class="panel-body">
						<form class="form-horizontal" id="image" onsubmit="return validarFormulario()" action="<%= blobstoreService.createUploadUrl("/guardarbebida") %>" method="post" enctype="multipart/form-data" >
							<div id="formulario">
								<input type="hidden" id="idBebida" name="idBebida" value="" />																
								<div class="form-group">
									<label for="ejemplo_password_3" class="col-lg-2 control-label" for="nombre">Nombre</label>
									<div class="col-lg-10">
										<input type="text" class="form-control" placeholder="Nombre" id="nombre" name="nombre" value=""/>
									</div>
								</div>
								
								<div class="form-group">
									<label for="ejemplo_password_3" class="col-lg-2 control-label" for="precio">Precio</label>
									<div class="col-lg-10">
										<input type="text" class="form-control" placeholder="Precio" id="precio" name="precio" value="" pattern="[0-9]{1,6}[.]{0,1}[0-9]{0,}" title="Ingrese un numero"/>
									</div>
								</div>
								
								<div class="form-group">
									<label for="ejemplo_password_3" class="col-lg-2 control-label" for="Categoria">Categoria</label>
									<div class="radio col-lg-10">
										<label class="radio"><input type="radio" id="categoria" name="categoria" value="Gaseosa" checked>Gaseosa</label>
										<label class="radio"><input type="radio" id="categoria" name="categoria" value="Refresco">Refresco</label>
										<label class="radio"><input type="radio" id="categoria" name="categoria" value="Cerveza">Cerveza</label>
									</div>
								</div>
								
								<div class="form-group">
									<label for="ejemplo_password_3" class="col-lg-2 control-label" for="imagen">Imagen</label>
									<div class="col-lg-10">
										<input type="file" class="btn btn-default" id="imagen" name="imagen" accept="image/*">
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-lg-12 enviar">
										<input type="reset" value="Limpiar" class="btn btn-default" id="Limpiar"/>
										<input type="submit" class="btn btn-default" id="" value="Añadir"/>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
				<br>
			</div>
		</div>
</div>