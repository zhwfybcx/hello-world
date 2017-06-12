$(function() {

	var currentdate = getNowFormatDate();
	$("#todayTime").html(currentdate[0]);
	$("#WhatDay").html(currentdate[1]);
	getEventByDay(currentdate[0]);

	//切换日期
	$(".dayNext").on("click", function() {
		var tomorrow = addAndReduce(true, false, "todayTime");
		$("#todayTime").html(tomorrow[0]);
		$("#WhatDay").html(tomorrow[1]);
		var time = $("#todayTime").html();
		getEventByDay(time);
	})
	$(".dayPrev").on("click", function() {
		var yesterday = addAndReduce(false, true, "todayTime");
		$("#todayTime").html(yesterday[0]);
		$("#WhatDay").html(yesterday[1]);
		var time = $("#todayTime").html();
		getEventByDay(time);
	})
	
	//获取当天事件
	function getEventByDay(curDayStr) {
		/*$.ajax({
			"type" : "get",
			"dataType" : "json",
			"url" : config.server + "/calendar/calendarInfo?nowDay=" + curDayStr,
			"success" : function(rep, status, xhr) {

				if (xhr.status == 200) {
					var oData = rep;
					var isBussinessDay = oData.businessDay;
					if (isBussinessDay) {
						$(".tradingDay").show();
					} else {
						$(".tradingDay").hide();
					}
					data = oData.event;
					var result = "";
					if (data) {
						for (var i = 0; i < data.length; i++) {
							result += "<li>" + "<h4><span class=\"titleSpan\">"
									+ data[i].calendarContent + "</span><a>"
									+ data[i].typeName + "</a>" + "</h4>";
							if (data[i].calendarRemark != '') {
								result += "<p class='abstract'>" + "市场预期："
										+ data[i].calendarRemark + "</p>";
							}
							if (data[i].url != '') {
								result += "<p class='seeD'>" + "<a href='"
										+ data[i].url + "' target='_blank'>"
										+ "查看报告详情" + "</a>" + "</p>";
							}
							result += "</li>"
						}
						$("#message-ul").html(result);
						$("#onResult").empty().hide();
					} else {
						$("#message-ul").empty();
						$("#onResult").html("当日暂无事件").show();
					}

				} else {
					alert("请求错误");
				}
			}
		});*/
		
		$.getJSON(config.server + "/calendar/calendarInfo?nowDay=" + curDayStr, function(json){
			var isBussinessDay = json.businessDay;
			if (isBussinessDay) {
				$(".tradingDay").show();
			} else {
				$(".tradingDay").hide();
			}
			var eventList = json.event;
			var resultStr = "";
			if (eventList) {
				for (var i = 0; i < eventList.length; i++) {
					resultStr += "<li>" + "<h4><span class=\"titleSpan\">"+ eventList[i].calendarContent + "</span><a>"	+ eventList[i].typeName + "</a>" + "</h4>";
					if (eventList[i].calendarRemark != '') {
						resultStr += "<p class='abstract'>" + eventList[i].calendarRemark + "</p>";
					}
					if (eventList[i].url != '') {
						resultStr += "<p class='seeD'>" + "<a href='"+ eventList[i].url + "' target='_blank'>"+ "查看报告详情" + "</a>" + "</p>";
					}
					resultStr += "</li>"
				}
				$("#message-ul").html(resultStr);
				$("#onResult").hide();
			} else {
				$("#message-ul").empty();
				$("#onResult").html("当日暂无事件").show();
			}
		});
	}

});