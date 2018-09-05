/**
 * 
 */

$(document).ready(function(){
	$('#list').hide();
	$("#list").on("click",function(event){
		$.get('listamesa', function(responseText) {$("#tabla").html(responseText);});
	});
	$("#list").trigger( "click" );
	

	$('#submit').click(function(event) {
		var nombreVar = $('#nombre').val();
		var sillasVar = $('#sillas').val();
		var imagenVar = $('#imagen').val();
		var disponibleVar = $('#disponible:checked').val();
		
		if(nombreVar=="" || sillasVar=="" || isNaN(sillasVar) ||imagenVar==""){
			alert("ingrese los datos completos y correctos");
		}
		else{
		
		// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
		$.post('guardarmesa', {
			nombre : nombreVar,
			sillas: sillasVar,
			imagen: imagenVar,
			disponible: disponibleVar
			}, function(responseText) {
				$('#tabla').html(responseText);
				});
		}
	});

	
	$("#eliminar").click(function(event){
		var listMesas =[];
		$('input[name="eliminar"]:checked').each(function() {
			//$(this).val() es el valor del checkbox correspondiente
			listMesas.push($(this).val());
		});
		if(listMesas.length>0){
			$.get('eliminarmesa',{eliminar: listMesas},
					function(responseText) {
						$('#tabla').html(responseText);
			});
		}
		else{
			alert("escoge por lo menos un elemento");
		}
		
	});
	
	/*BOTON MODIFICAR */
	$("#modificar").click(function(event){
		var listMesas =[];
		$('input[name="eliminar"]:checked').each(function() {
			//$(this).val() es el valor del checkbox correspondiente
			listMesas.push($(this).val());
		});
		if(listMesas.length==1){
			$.get('modificarmesa',{modificar: listMesas[0]},
					function(responseText) {
						$('#formulario').html(responseText);
					});
		}
		else{
			alert("escoge un elemento");
		}
		
	});
	
	
	
	$('#guardar').click(function(event) {
		var nombreVar = $('#nombre').val();
		var sillasVar = $('#sillas').val();
		var imagenVar = $('#imagen').val();
		var disponibleVar = $('#disponible:checked').val();
		var idMesaVar = $('#idMesa').val();
		
		// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
		$.post('guardarmesa', {
			nombre : nombreVar,
			sillas: sillasVar,
			imagen: imagenVar,
			disponible: disponibleVar,
			idMesa: idMesaVar
			}, function(responseText) {
				$('#tabla').html(responseText);
				});
	});
	
	/*$('#buscarmesa').change( function() {
	    var catVar = $(this).find('option:selected').val();
	    $.get('buscarmesa', {
			categoria : catVar,
			}, function(responseText) {
				$('#tabla').html(responseText);
				});
	});
	
	*/
	
});