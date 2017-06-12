//获取当天日期
function getNowFormatDate() {
    var date = new Date();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    var myWeek = date.getDay();         //获取当前星期X(0-6,0代表星期天)
    switch (myWeek){
        case 0 :{
            myWeek = "周日";
            break;
        }
        case 1 :{
            myWeek = "周一";
            break;
        }
        case 2 :{
            myWeek = "周二";
            break;
        }
        case 3 :{
            myWeek = "周三";
            break;
        }
        case 4 :{
            myWeek = "周四";
            break;
        }
        case 5 :{
            myWeek = "周五";
            break;
        }
        case 6 :{
            myWeek = "周六";
            break;
        }
    }
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + "-" + month + "-" + strDate;
        currentdate = [currentdate,myWeek]
    return currentdate;

};
//增减一天
    function addAndReduce(add,reduce,ele) {
        var d = new Date(parseIE(document.getElementById(ele).innerHTML));
        if (d == "Invalid Date") {
           // alert("非日期");
            return;
        }
        //当前日期的毫秒数 + 天数 * 一天的毫秒数
        var n;
        if(add){
            n = d.getTime() + 1 * 24 * 60 * 60 * 1000;
        }
        else if(reduce){
            n = d.getTime() - 1 * 24 * 60 * 60 * 1000;
        }

        var result = new Date(n);
        var rMonth = result.getMonth()+1;
        var rDate = result.getDate();
        var rWeek = result.getDay();
        var weekday=["周日","周一","周二","周三","周四","周五","周六"];


        if (rMonth >= 1 && rMonth <= 9) {
            rMonth = "0" + rMonth;
        }
        if (rDate >= 0 && rDate <= 9) {
            rDate = "0" + rDate;
        }
        var rDay = result.getFullYear() + "-" + rMonth + "-" + rDate;
            rDay = [rDay,weekday[rWeek]];
        return rDay;
    }
    
    //IE8 兼容时间转换
    function parseIE(dateStringInRange) {
    	   var isoExp = /^\s*(\d{4})-(\d\d)-(\d\d)\s*$/,
    	       date = new Date(NaN), month,
    	       parts = isoExp.exec(dateStringInRange);

    	   if(parts) {
    	     month = +parts[2];
    	     date.setFullYear(parts[1], month - 1, parts[3]);
    	     if(month != date.getMonth() + 1) {
    	       date.setTime(NaN);
    	     }
    	   }
    	   return date;
    	 }
    
    /*
     * 时间格式转换工具类 new Date().format("yyyy-MM-dd hh:mm:ss")
     */
    Date.prototype.format = function(format) {
        var o = {
            "M+": this.getMonth() + 1, // month
            "d+": this.getDate(), // day
            "h+": this.getHours(), // hour
            "m+": this.getMinutes(), // minute
            "s+": this.getSeconds(), // second
            "q+": Math.floor((this.getMonth() + 3) / 3), // quarter
            "S": this.getMilliseconds()
                // millisecond
        }

        if (/(y+)/.test(format)) {
            format = format.replace(RegExp.$1, (this.getFullYear() + "")
                .substr(4 - RegExp.$1.length));
        }

        for (var k in o) {
            if (new RegExp("(" + k + ")").test(format)) {
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
            }
        }
        return format;
    }