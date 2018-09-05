/**
 * 
 */

$(document).ready(function(){
	$('#list').hide();
	$("#list").on("click",function(event){
		$.get('listaplato', function(responseText) {$("#tabla").html(responseText);});
	});
	$("#list").trigger( "click" );
	
	/*
	$('#submit').click(function(event) {
		var nombreVar = $('#nombre').val();
		var precioVar = $('#precio').val();
		var categoriaVar = $('#categoria:checked').val();
		var imagenVar = $('#imagen').val();
		var descripcionVar = $('#descripcion').val();
		
		if(nombreVar=="" || precioVar=="" || isNaN(precioVar) ||categoriaVar==""||imagenVar=="" || descripcionVar==""){
			alert("ingrese los datos completos y correctos");
		}
		else{
			
		// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
		$.post('guardarplato', {
			nombre : nombreVar,
			precio: precioVar,
			categoria: categoriaVar,
			imagen: imagenVar,
			descripcion: descripcionVar
			}, function(responseText) {
				$('#tabla').html(responseText);
				});
		}
	});

	
	$("#eliminar").click(function(event){
		var listBebidas =[];
		$('input[name="eliminar"]:checked').each(function() {
			//$(this).val() es el valor del checkbox correspondiente
			listBebidas.push($(this).val());
		});
		if(listBebidas.length>0){
			$.get('eliminarplato',{eliminar: listBebidas},
					function(responseText) {
						$('#tabla').html(responseText);
			});
		}
		else{
			alert("escoge por lo menos un elemento");
		}
		
	});
	
	/*BOTON MODIFICAR 
	$("#modificar").click(function(event){
		var listPlatos =[];
		$('input[name="eliminar"]:checked').each(function() {
			//$(this).val() es el valor del checkbox correspondiente
			listPlatos.push($(this).val());
		});
		if(listPlatos.length==1){
			$.get('modificarplato',{modificar: listPlatos[0]},
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
		var precioVar = $('#precio').val();
		var categoriaVar = $('#categoria:checked').val();
		var imagenVar = $('#imagen').val();
		var descripcionVar = $('#descripcion').val();
		var idVar = $('#idPlato').val();
		
		// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
		$.post('guardarplato', {
			nombre : nombreVar,
			precio: precioVar,
			categoria: categoriaVar,
			imagen: imagenVar,
			idPlato:idVar,
			descripcion: descripcionVar
			}, function(responseText) {
				$('#tabla').html(responseText);
				});
	});
	*/
	$('#buscarplato').change( function() {
	    var catVar = $(this).find('option:selected').val();
	    if(catVar != "selecciona" ){	
		    $.get('buscarplato', {
				categoria : catVar,
				}, function(responseText) {
					$('#registro_platos').html(responseText);
					});
	    }
	});
	
	
	
});