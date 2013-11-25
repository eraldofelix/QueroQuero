//<![CDATA[

$(function() {
	var opcoesDialogo = {
		modal: true, width: 700, height: 600, draggable: false, closeOnEscape: false,
		autoOpen: false,
		buttons: {
			'Fechar': function(event) { 
				$(this).dialog("close");
			}
		}
	};

	$('.dialogo').dialog(opcoesDialogo);	
	$('.dialogo').dialog('option', 'show', 'slide');
	$('.dialogo').dialog('open');
	
});
// ]]>