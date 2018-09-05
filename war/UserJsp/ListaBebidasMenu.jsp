<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="modelo.*" %>
<%@ page import="java.util.List" %>

<% List<Bebida> bebidas = (List<Bebida>) request.getAttribute("listBebidas"); %>
<% List<BebidaMenu> bebidaCan = (List<BebidaMenu>) request.getAttribute("listCantidades"); %>


<div class="container">
	<div class="menu-grid-main">
		<%for(Bebida a:bebidas){ %>
			<div class="col-md-4 menu-grid wow bounceInDown" data-wow-delay="0.3s">
				<div class="img-thumbnail img-responsive">
					<ul class="portfolio-grid">
						<li>
							<h5><%=a.getNombre() %></h5>
						
						</li>
						<li><img class="top-grid" src="/serve?blob-key=<%=a.getKeyoutsideImage() %>" alt=""/></li>
					</ul>
				</div>
				
				<!--img src="imagesu/r1.jpg" alt="" class="img-thumbnail img-responsive"-->
				<h4><input type="checkbox" name="<%=a.getCategoria() %>" id="grupo" value="<%=a.getIdBebida()%>"><%=a.getNombre() %> (s/<%=a.getPrecio() %>)</h4>
				<input type="number" id="<%=a.getIdBebida()%>" class="form-control" placeholder="Cantidad" value="0">					
			</div>
		<%} %>
						
						<!--div class="col-md-4 menu-grid wow bounceInLeft" data-wow-delay="0.3s">
							<a href="single.html"><img src="imagesu/p7.jpg" alt="" class="img-responsive"></a>
							<h4>Spaguetti a la jardinera (s/20.00)</h4>
							<input type="number" id="" class="form-control" placeholder="Cantidad" value="0">					
							<p>Fideos de la mas alta consistencia...</p>
						</div-->
					
		<div class="clearfix"> </div>
	</div>
	<%if(bebidas!=null){ %>
	<div class="panel-footer enviar">
		<div class="form-group">
			<input type="button" class="btn btn-primary btnop" id="agregar" value="AGREGAR">
		</div>
	</div>
	<%} %>						
</div>

<script type="text/javascript" src="js/MenuUser2.js"></script>