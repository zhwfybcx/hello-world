$(function(){
	
	//先填充一下轮播地址
	$("li[class^='banLi']").each(function(){
		
    	$(this).css("backgroundImage","url("+$(this).attr("data-img")+")");	
    	$(this).css("filter","progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+$(this).attr("data-img")+"', sizingMethod='scale')");	
    	
    });
	//轮播初始化
    var bannerSlider = new Slider($('#cbannerBox'), {
        time: 8000,
        delay: 1000,
        event: 'hover',
        auto: true,
        mode: 'fade',
        controller: $('#bannerCtrl'),
        activeControllerCls: 'active'
    });
    $('.consultBanner .arrowL').click(function() {
        bannerSlider.prev()
    });
    $('.consultBanner .arrowR').click(function() {
        bannerSlider.next()
    });
    
    //文章详情
    $(".cList").on("click","li",function(){
        location.href = config.server + "article/"+$(this).attr("data-article")+".htm";
    });
    //二级目录
    $(".cList li").on("click",".catalogBtn",function(event){
        event.stopPropagation();
        location.href = config.server + "article/"+$(this).attr("data-folder")+"/1";
    });
    //等级提示符
    $(".iconLevelSpan").on({
        mouseenter: function(){
            $(this).find(".textLevel").show();
        },
        mouseleave: function(){
            $(this).find(".textLevel").hide();
        }
    });
	
});