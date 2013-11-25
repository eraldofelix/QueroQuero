//<![CDATA[
	$(document).ready(function() {
		$(':text').parents('span').hide();
		$(':radio').wrap('<a href="#"></a>');
		$(':radio').parents('label').click(function(){
		$(this).siblings().fadeIn(1500); 
		$(this).parent().siblings('.mudar')
		.children('span')
		.slideUp().find(':checked').each(function(){
		$(this).removeAttr('checked');
		});
	});		
		
	});
   // ]]>