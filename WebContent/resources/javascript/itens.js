//<![CDATA[
	$(document).ready(function() {
		$(':checkbox').parents('label').hide();
		$(':radio').wrap('<a href="#"></a>');
		$(':radio').parents('label').click(function(){
			$(this).siblings().fadeIn(1500); 
			$(this).parent().siblings('.mudar')
			.children('label:not(.opcoes)')
				.slideUp().find(':checked').each(function(){
				$(this).removeAttr('checked');
				});
			});
		
		$(':text').parents('label').hide();
		$(':radio').wrap('<a href="#"></a>');
		$(':radio').parents('label').click(function(){
			$(this).siblings().fadeIn(1500); 
			$(this).parent().siblings('.mudar')
			.children('label:not(.opcoes)')
				.slideUp().find(':checked').each(function(){
				$(this).removeAttr('checked');
				});
			});
	});
   // ]]>