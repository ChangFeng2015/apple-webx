$(function(){
	
	$('.dropdown-menu li a').click(function(){
		var html=$(this).text();
		var searchType = $(this).attr('value');
		$('.search_cate').html(html);
		$('#search').val(searchType);
	})
	
	$('.com_bottom_btn_01,.com_bottom_btn_02').click(function(){
		$('.com_bottom_btn_01,.com_bottom_btn_02').removeClass('com_bottom_selected');
		$(this).addClass('com_bottom_selected');
	});
	$('.com_bottom_btn_01').click(function(){
		$('.com_bottom_content_02').hide();
		$('.com_bottom_content_01').show();
	})
	$('.com_bottom_btn_02').click(function(){
		$('.com_bottom_content_01').hide();
		$('.com_bottom_content_02').show();
	})
	
	//翻页符加title
	$('.page_fpage a').attr('title','首页');
	$('.page_lpage a').attr('title','尾页');
	$('.page_prev_seller a').attr('title','上一页');
	$('.page_next_seller a').attr('title','下一页');
	var active=$('.pagination a.active').text();
	var lastpage=$('.pagination a.active').parent('li').next('li').attr('class');
	if(active == '1'){
		$('.pagination .page_fpage').hide();
		$('.pagination .page_prev_seller').hide();
	}else{
		$('.pagination .page_fpage').show();
		$('.pagination .page_prev_seller').show();
	};
	if(lastpage == 'page_next_seller'){
		$('.pagination .page_lpage').hide();
		$('.pagination .page_next_seller').hide();
	}else{
		$('.pagination .page_lpage').show();
		$('.pagination .page_next_seller').show();
	};
	
		$('.ds-powered-by').text('');
});


