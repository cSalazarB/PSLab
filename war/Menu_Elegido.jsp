<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@page import="modelo.*"%>
<%@page import="java.util.ArrayList"%>



<%ArrayList<Plato> misEntradas=(ArrayList<Plato>)getServletContext().getAttribute("misEntradas");%>
<%ArrayList<String> misCanEntradas=(ArrayList<String>)getServletContext().getAttribute("misCanEntradas");%>

<%ArrayList<Plato> misFondos=(ArrayList<Plato>)getServletContext().getAttribute("misFondos");%>
<%ArrayList<String> misCanFondos=(ArrayList<String>)getServletContext().getAttribute("misCanFondos");%>

<%ArrayList<Plato> misPostres=(ArrayList<Plato>)getServletContext().getAttribute("misPostres");%>
<%ArrayList<String> misCanPostres=(ArrayList<String>)getServletContext().getAttribute("misCanPostres");%>


<%ArrayList<Bebida> misGaseosas=(ArrayList<Bebida>)getServletContext().getAttribute("misGaseosas");%>
<%ArrayList<String> misCanGaseosas=(ArrayList<String>)getServletContext().getAttribute("misCanGaseosas");%>

<%ArrayList<Bebida> misCervezas=(ArrayList<Bebida>)getServletContext().getAttribute("misCervezas");%>
<%ArrayList<String> misCanCervezas=(ArrayList<String>)getServletContext().getAttribute("misCanCervezas");%>

<%ArrayList<Bebida> misRefrescos=(ArrayList<Bebida>)getServletContext().getAttribute("misRefrescos");%>
<%ArrayList<String> misCanRefrescos=(ArrayList<String>)getServletContext().getAttribute("misCanRefrescos");%>

<div class="panel panel-info"> 
	<div class="panel-heading">
		<h3 class="panel-title">MENU SELECCIONADO</h3>
	</div>
	
	<div class="panel-body operaciones">
		<table class="table table-striped table-bordered">
			<col style="width:20%;" />
			<col style="width:50%;" />
			<col style="width:30%;" />
			<!-- DEFINIMOS LAS CABECERAS DE LA TABLA -->
			<tr>
				<th>CATEGORIA</th>
				<th>DESCRIPCION</th>
				<th>CANTIDAD</th>
			</tr>
			<!-- COLOCAMOS EL PRIMER ITEM SELECCIONADO -->
			<%if(getServletContext().getAttribute("misEntradas")!=null)
			for(int i=0;i<misEntradas.size();i++){ %>
			<tr>
				<td style="vertical-align:middle;"><label><%=misEntradas.get(i).getCategoria()%></label></td>
				<td>
					<img src="/serve?blob-key=<%=misEntradas.get(i).getKeyoutsideImage() %>" alt="..." class="img-thumbnail" width="100"><BR>
					<label><%=misEntradas.get(i).getNombre()%></label>  	
				</td>
				<td style="vertical-align:middle;">
					<div>
						<div class="col-md-6">
							<input type="number" class="form-control" value="<%=misCanEntradas.get(i)%>">
						</div>
						<button type="button" class="btn btn-primary" id="eliminar">Eliminar</button>
					</div>
				</td>
			</tr>
			<%} %>
			
			<%
			if(getServletContext().getAttribute("misFondos")!=null){
			for(int i=0;i<misFondos.size();i++){ %>
			<tr>
				<td style="vertical-align:middle;"><label><%=misFondos.get(i).getCategoria()%></label></td>
				<td>
					<img src="/serve?blob-key=<%=misFondos.get(i).getKeyoutsideImage() %>" alt="..." class="img-thumbnail" width="100"><BR>
					<label><%=misFondos.get(i).getNombre()%></label>  	
				</td>
				<td style="vertical-align:middle;">
					<div>
						<div class="col-md-6">
							<input type="number" class="form-control" value="<%=misCanFondos.get(i)%>">
						</div>
						<button type="button" class="btn btn-primary">Eliminar</button>
					</div>
				</td>
			</tr>
			<%} }%>
			
			<%if(getServletContext().getAttribute("misPostres")!=null){
			for(int i=0;i<misPostres.size();i++){ %>
			<tr>
				<td style="vertical-align:middle;"><label><%=misPostres.get(i).getCategoria()%></label></td>
				<td>
					<img src="/serve?blob-key=<%=misPostres.get(i).getKeyoutsideImage() %>" alt="..." class="img-thumbnail" width="100"><BR>
					<label><%=misPostres.get(i).getNombre()%></label>  	
				</td>
				<td style="vertical-align:middle;">
					<div>
						<div class="col-md-6">
							<input type="number" class="form-control" value="<%=misCanPostres.get(i)%>">
						</div>
						<button type="button" class="btn btn-primary">Eliminar</button>
					</div>
				</td>
			</tr>
			<%} }%>
			
			<%if(getServletContext().getAttribute("misGaseosas")!=null){
			for(int i=0;i<misGaseosas.size();i++){ %>
			<tr>
				<td style="vertical-align:middle;"><label><%=misGaseosas.get(i).getCategoria()%></label></td>
				<td>
					<img src="/serve?blob-key=<%=misGaseosas.get(i).getKeyoutsideImage() %>" alt="..." class="img-thumbnail" width="100"><BR>
					<label><%=misGaseosas.get(i).getNombre()%></label>  	
				</td>
				<td style="vertical-align:middle;">
					<div>
						<div class="col-md-6">
							<input type="number" class="form-control" value="<%=misCanGaseosas.get(i)%>">
						</div>
						<button type="button" class="btn btn-primary">Eliminar</button>
					</div>
				</td>
			</tr>
			<%} }%>
			
			<%if(getServletContext().getAttribute("misCervezas")!=null){
			for(int i=0;i<misCervezas.size();i++){ %>
			<tr>
				<td style="vertical-align:middle;"><label><%=misCervezas.get(i).getCategoria()%></label></td>
				<td>
					<img src="/serve?blob-key=<%=misCervezas.get(i).getKeyoutsideImage() %>" alt="..." class="img-thumbnail" width="100"><BR>
					<label><%=misCervezas.get(i).getNombre()%></label>  	
				</td>
				<td style="vertical-align:middle;">
					<div>
						<div class="col-md-6">
							<input type="number" class="form-control" value="<%=misCanCervezas.get(i)%>">
						</div>
						<button type="button" class="btn btn-primary">Eliminar</button>
					</div>
				</td>
			</tr>
			<%} }%>
			
			<%if(getServletContext().getAttribute("misRefrescos")!=null){
			for(int i=0;i<misRefrescos.size();i++){ %>
			<tr>
				<td style="vertical-align:middle;"><label><%=misRefrescos.get(i).getCategoria()%></label></td>
				<td>
					<img src="/serve?blob-key=<%=misRefrescos.get(i).getKeyoutsideImage() %>" alt="..." class="img-thumbnail" width="100"><BR>
					<label><%=misRefrescos.get(i).getNombre()%></label>  	
				</td>
				<td style="vertical-align:middle;">
					<div>
						<div class="col-md-6">
							<input type="number" class="form-control" value="<%=misCanRefrescos.get(i)%>">
						</div>
						<button type="button" class="btn btn-primary">Eliminar</button>
					</div>
				</td>
			</tr>
			<%} }%>
			
		</table>	
	</div>
	
	<div class="panel-footer enviar">
		<div class="form-group ">
			<input type="button" class="btn btn-success btnop" id="finalizar" value="FINALIZAR SELECCIÓN">
		</div>
	</div>
</div>

<script type="text/javascript" src="js/menu2Ajax.js"></script>


