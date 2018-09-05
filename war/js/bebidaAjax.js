/**
 * 
 */
$(document).ready(function(){
	$('#list').hide();
	$("#list").on("click",function(event){
		$.get('listabebida', function(responseText) {$("#tabla").html(responseText);});
	});
	
		$("#list").trigger( "click" );
	/*
	//BOTON AÑADIR
	$('#submit').click(function(event) {
		var nombreVar = $('#nombre').val();
		var precioVar = $('#precio').val();
		var categoriaVar = $('#categoria:checked').val();
		var imagenVar = $('#imagen').val();
		
		if(nombreVar=="" || precioVar=="" || isNaN(precioVar) ||categoriaVar==""||imagenVar==""){
			alert("ingrese los datos completos y correctos");
		}
		else{
			//CARGAMOS LA IMAGEN
			//$('#image').submit();
		// Invocamos al servlet para guardar la bebida
		$.post('guardarbebida', {
			nombre : nombreVar,
			precio: precioVar,
			categoria: categoriaVar
			}, function(responseText) {
				$('#tabla').html(responseText);
				});
		
		}
		
	});

	/*
	$("#eliminar").click(function(event){
		var listBebidas =[];
		$('input[name="eliminar"]:checked').each(function() {
			//$(this).val() es el valor del checkbox correspondiente
			listBebidas.push($(this).val());
		});
		if(listBebidas.length<=0){
			alert("escoge por lo menos un elemento");
			
		}
		else{
			$.get('eliminarbebida',{eliminar: listBebidas},
					function(responseText) {
						$('#tabla').html(responseText);
			});
		}
		
	});
	
	/*BOTON MODIFICAR 
	 $("#modificar").click(function(event){
		var listBebidas =[];
		$('input[name="eliminar"]:checked').each(function() {
			//$(this).val() es el valor del checkbox correspondiente
			listBebidas.push($(this).val());
		});
		if(listBebidas.length==1){
			$.get('modificarbebida',{modificar: listBebidas[0]},
					function(responseText) {
						$('#formulario').html(responseText);
					});
		}
		else{
			alert("escoge un elemento");
		}
		
	});
	*/
	
	
	$('#guardar').click(function(event) {
		var nombreVar = $('#nombre').val();
		var precioVar = $('#precio').val();
		var categoriaVar = $('#categoria:checked').val();
		var imagenVar = $('#imagen').val();
		var idVar = $('#idBebida').val();
		
		// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
		$.post('guardarbebida', {
			nombre : nombreVar,
			precio: precioVar,
			categoria: categoriaVar,
			imagen: imagenVar,
			idBebida:idVar
			}, function(responseText) {
				$('#tabla').html(responseText);
				});
	});
	
	$('#buscarbebida').change( function() {
	    var catVar = $(this).find('option:selected').val();
	    if(catVar != "selecciona" ){
		    $.get('buscarbebida', {
				categoria : catVar,
				}, function(responseText) {
					$('#registro_bebidas').html(responseText);
					});
	    }
	});
	
	
	
}); 