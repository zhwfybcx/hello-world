/**
 * Created by user on 2017/5/10.
 */

$(function(){
    var myList=new Array("article","folder","headline","comment","user","admin")
    $("#nav_active li a").each(function(index,domEle){
        if($(domEle).attr('href') == window.location.pathname){
            $(domEle).parents("li").addClass("active").siblings().removeClass("active");;
            return;
        }else {
            for(var i=index; i <= myList.length-1;i++){
                if(new RegExp(myList[i]).test(window.location.pathname)){
                    $(domEle).parents("li").addClass("active").siblings().removeClass("active");
                    return;
                }
            }
        }
    });
});
