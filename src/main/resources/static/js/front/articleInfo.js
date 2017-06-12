
	document.oncontextmenu=new Function('event.returnValue=false;');
    document.onselectstart=new Function('event.returnValue=false;');

    document.onkeydown = function(e){
    e = window.event || e;
    var keycode = e.keyCode || e.which;

    if(e.ctrlKey || e.altKey || e.shiftKey
    || keycode >= 83 && keycode <= 91 ){
        if(window.event){// ie

        // try{e.keyCode = 0;}catch(e){}
        e.returnValue = false;
        return false;
        }else{// ff
        e.preventDefault();
        }
        }
    }
    $(function(){
	  	//等级提示符
	    $(".iconLevelSpan").on({
	        mouseenter: function(){
	            $(this).find(".textLevel").show();
	        },
	        mouseleave: function(){
	            $(this).find(".textLevel").hide();
	        }
	    });
	  	
	  //二级目录
        $(".catalogBtn").on("click",function(event){
        	location.href = config.server + "article/"+$(this).attr("data-folder")+"/1";
        });
	  
    });