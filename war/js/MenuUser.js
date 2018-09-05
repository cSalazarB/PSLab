/**
 * 
 */

function cargar(val){
	var catVar = val;
	$.get('listaplatomenuuser', {
			categoria : catVar
			}, function(responseText) {
				$('#cuadros').html(responseText);
			});
}

function cargarBebida(val){
	var catVar = val;
	$.get('listabebidamenuuser', {
			categoria : catVar
			}, function(responseText) {
				$('#cuadros').html(responseText);
			});
}

$("#EntradaBtn").click(function(){
	cargar("Entrada");
	$('#categorias').html("<input type='button' class='list-group-item active' value='Entrada' id='EntradaBtn'/>"
			+"<input type='button' class='list-group-item' value='Platos de fondos' id ='FondoBtn'/>"
			+"<input type='button' class='list-group-item' value='Postres' id ='PostreBtn'/>"
			+"<input type='button' class='list-group-item' value='Gaseosas' id ='GaseosaBtn'/>"
			+"<input type='button' class='list-group-item' value='Refrescos' id ='RefrescoBtn'/>"
			+"<input type='button' class='list-group-item' value='Cervezas' id ='CervezaBtn'/>" +
					"<script type='text/javascript' src='js/MenuUser.js'></script>");
	
});
$("#FondoBtn").click(function(){
	cargar("Fondo");
	$('#categorias').html("<input type='button' class='list-group-item ' value='Entrada' id='EntradaBtn'/>"
					+"<input type='button' class='list-group-item active' value='Platos de fondos' id ='FondoBtn'/>"
					+"<input type='button' class='list-group-item' value='Postres' id ='PostreBtn'/>"
					+"<input type='button' class='list-group-item' value='Gaseosas' id ='GaseosaBtn'/>"
					+"<input type='button' class='list-group-item' value='Refrescos' id ='RefrescoBtn'/>"
					+"<input type='button' class='list-group-item' value='Cervezas' id ='CervezaBtn'/>" +
							"<script type='text/javascript' src='js/MenuUser.js'></script>");
});
$("#PostreBtn").click(function(){
	cargar("Postre");
	$('#categorias').html("<input type='button' class='list-group-item ' value='Entrada' id='EntradaBtn'/>"
			+"<input type='button' class='list-group-item ' value='Platos de fondos' id ='FondoBtn'/>"
			+"<input type='button' class='list-group-item active' value='Postres' id ='PostreBtn'/>"
			+"<input type='button' class='list-group-item' value='Gaseosas' id ='GaseosaBtn'/>"
			+"<input type='button' class='list-group-item' value='Refrescos' id ='RefrescoBtn'/>"
			+"<input type='button' class='list-group-item' value='Cervezas' id ='CervezaBtn'/>" +
					"<script type='text/javascript' src='js/MenuUser.js'></script>");
});
$("#GaseosaBtn").click(function(){
	cargarBebida("Gaseosa");
	$('#categorias').html("<input type='button' class='list-group-item ' value='Entrada' id='EntradaBtn'/>"
			+"<input type='button' class='list-group-item ' value='Platos de fondos' id ='FondoBtn'/>"
			+"<input type='button' class='list-group-item' value='Postres' id ='PostreBtn'/>"
			+"<input type='button' class='list-group-item active' value='Gaseosas' id ='GaseosaBtn'/>"
			+"<input type='button' class='list-group-item' value='Refrescos' id ='RefrescoBtn'/>"
			+"<input type='button' class='list-group-item' value='Cervezas' id ='CervezaBtn'/>" +
					"<script type='text/javascript' src='js/MenuUser.js'></script>");
});
$("#RefrescoBtn").click(function(){
	cargarBebida("Refresco");
	$('#categorias').html("<input type='button' class='list-group-item ' value='Entrada' id='EntradaBtn'/>"
			+"<input type='button' class='list-group-item ' value='Platos de fondos' id ='FondoBtn'/>"
			+"<input type='button' class='list-group-item' value='Postres' id ='PostreBtn'/>"
			+"<input type='button' class='list-group-item' value='Gaseosas' id ='GaseosaBtn'/>"
			+"<input type='button' class='list-group-item active' value='Refrescos' id ='RefrescoBtn'/>"
			+"<input type='button' class='list-group-item' value='Cervezas' id ='CervezaBtn'/>" +
					"<script type='text/javascript' src='js/MenuUser.js'></script>");
});
$("#CervezaBtn").click(function(){
	cargarBebida("Cerveza");
	$('#categorias').html("<input type='button' class='list-group-item ' value='Entrada' id='EntradaBtn'/>"
			+"<input type='button' class='list-group-item ' value='Platos de fondos' id ='FondoBtn'/>"
			+"<input type='button' class='list-group-item' value='Postres' id ='PostreBtn'/>"
			+"<input type='button' class='list-group-item' value='Gaseosas' id ='GaseosaBtn'/>"
			+"<input type='button' class='list-group-item' value='Refrescos' id ='RefrescoBtn'/>"
			+"<input type='button' class='list-group-item active' value='Cervezas' id ='CervezaBtn'/>" +
					"<script type='text/javascript' src='js/MenuUser.js'></script>");
});

$(document).ready(function(){
	
	
	
	
	/*$('#agregar').click(function(event){
		var lista =[];
		var tipo="";
		$('input[name="platos"]:checked').each(function() {
			//$(this).val() es el valor del checkbox correspondiente
			lista.push($(this).val());
			tipo="Platos";
		});
		
		if(lista.length>0){
			var cantidadVar=[];
			for(i=0;i<lista.length;i++){
				var idVar='#'+lista[i];
				cantidadVar.push($(idVar).val());
			}
			
			alert(lista[1]);
			alert(cantidadVar[1]);
			$.post('listaseleccionuser',{"codigo[]": lista, "cantidades[]": cantidadVar},
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
		
	});*/
	
	
});