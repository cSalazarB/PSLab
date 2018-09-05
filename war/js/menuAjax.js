/**
 * 
 */

$(document).ready(function(){
	$('#list').hide();
	$('#list').on('click',function(event){
		 var catVar = "Entrada";
		 $.get('listaplatomenu', {
				categoria : catVar
				}, function(responseText) {
					$('#cuadros').html(responseText);
				});
	});
	$('#list').trigger( 'click' );
	

	$('#seleccionMenu').change( function() {
	    var catVar = $(this).find('option:selected').val();
	    $.get('listaplatomenu', {
			categoria : catVar
			}, function(responseText) {
				$('#cuadros').html(responseText);
				});
	});	
	
});