$(function(){
	$('.search_option a').click(function(){
		$('.search_option a').removeClass('selected');
		$(this).addClass('selected');
	});
	$('.search_option a').eq(0).click(function(){
		$('.search input').attr('placeholder','请输入您想找的产品')
	})
	$('.search_option a').eq(1).click(function(){
		$('.search input').attr('placeholder','请输入您想找的企业')
	});
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
})