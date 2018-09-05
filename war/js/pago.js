/**
 * 
 */
$('#AceptarCompra').click(function(event){
	$.get('Pago.jsp',function(responseText) {
				$('#pago').html(responseText);
	});
	/*$('#pago').html(pago.jsp);*/
});
$('#finCompra').click(function(event){
	
	var hora = $('#hora').val();
	var direccion = $('#direccion').val();
	var numtarjeta = $('#numTarjeta').val();
	var numcvr = $('#numCVR').val();
	var fecha = $('#fecha').val();
	
	
	$.get('guardarpedido',{
		Hora: hora,
		Direccion :direccion,
		Tarjeta :numtarjeta, 
		cvr :numcvr,
		Fecha : fecha }
	,function(responseText) {
		$('#formulario').html(responseText);
});
	/*$('#pago').html(pago.jsp);*/
});