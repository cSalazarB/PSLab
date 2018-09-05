<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container">
	<div class="menu-grid-main">
		<div>
			<div>
				<div><label>numero de tarjeta</label></div>
				<div><input type="text" class="form-control" id="numTarjeta"></div>
			</div>
			<div>
				<div><label>CVR</label></div>
				<div><input type="text" class="form-control" id="numCVR"></div>
			</div>
			<div>
				<div><label>fecha de vencimiento</label></div>
				<div><input type="date" class="form-control" id="fecha"></div>
			</div>
			<div>
				<div><input type="button" class="btn btn-warning" value="finalizar" id="finCompra"/></div>
			</div>
			
			<script type="text/javascript" src="js/pago.js"></script>
		</div>
	</div>
</div>