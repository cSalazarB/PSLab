/**
 * 
 */


$(document).ready(function(){
	
	$('#agregar').click(function(event){
		var lista =[];
		var tipo="";
		$('input[name="Entrada"]:checked').each(function() {
			//$(this).val() es el valor del checkbox correspondiente
			lista.push($(this).val());
			tipo="Entrada";
		});
		$('input[name="Plato de Fondo"]:checked').each(function() {
			//$(this).val() es el valor del checkbox correspondiente
			lista.push($(this).val());
			tipo="Plato de Fondo";
		});
		$('input[name="Postre"]:checked').each(function() {
			//$(this).val() es el valor del checkbox correspondiente
			lista.push($(this).val());
			tipo="Postre";
		});
		$('input[name="Gaseosa"]:checked').each(function() {
			//$(this).val() es el valor del checkbox correspondiente
			lista.push($(this).val());
			tipo="Gaseosa";
		});
		$('input[name="Cerveza"]:checked').each(function() {
			//$(this).val() es el valor del checkbox correspondiente
			lista.push($(this).val());
			tipo="Cerveza";
		});
		$('input[name="Refresco"]:checked').each(function() {
			//$(this).val() es el valor del checkbox correspondiente
			lista.push($(this).val());
			tipo="Refresco";
		});
		if(lista.length>0){
			var cantidadVar=[];
			for(i=0;i<lista.length;i++){
				var idVar='#'+lista[i];
				cantidadVar.push($(idVar).val());
			}
			
			/*alert(cantidadVar[1]);*/
			$.get('listaseleccion',{codigos: lista, cantidades: cantidadVar,clase: tipo},
					function(responseText) {
						$('#cuadros').html(responseText);
					});
		}
		else{
			alert("escoge un elemento");
		}
	});
	
	
	$('#finalizar').click(function(event){
		
		$.get('guardarmenu',function(responseText) {
						$('#cuerpo').html(responseText);
		});
		
	});
	$('#eliminar').click(function(event){
		alert("falta eliminar");
	});
	
	
});