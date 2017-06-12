$(function () {
    var maxPage = $("#pageCount").val();
    $("#goPageIpt").keyup(function () {
        var page = $("#goPageIpt").val().replace(/[^\d]/g, '');
        if (page > maxPage || page < 1) {
            $("#goPageIpt").val("");
        }
    });

    $("#goBtn").click(function () {
        var page = $("#goPageIpt").val().replace(/[^\d]/g, '');
        page = parseInt(page);
        if (isNaN(page) || page > maxPage || page < 1) {
            $("#goPageIpt").val("");
            alert("请输入正确的页数")
            return false;
        }
        window.location.href = page;
    });
    //文章详情
    $(".alists").on("click", "li", function () {
        location.href = "/article/" + $(this).attr("data-article") + ".htm";
    });
    //二级目录
    $(".alists li").on("click", ".catalogBtn", function (event) {
        event.stopPropagation();
        location.href = "/article/" + $(this).attr("data-folder") + "/1";
    });
    //等级提示符
    $(".iconLevelSpan").on({
        mouseenter: function () {
            $(this).find(".textLevel").show();
        },
        mouseleave: function () {
            $(this).find(".textLevel").hide();
        }
    });
    var folderId = $("#folderId").val();
    var fatherFolderId = $("#fatherFolderId").val();
    if (folderId == fatherFolderId) {
        $("#folder_0").addClass("selected");
    } else {
        $("#folder_" + folderId).addClass("selected");
    }
    $(".subFolder ul li").on("click", function () {
        location.href = "/article/" + $(this).attr("data-folder") + "/1";
    });

    // 设置页面seo信息
    setSeoInfo();
});

// 设置页面seo信息
function setSeoInfo() {
    var title = $(".active a").text();
    var subtitle = $(".selected").text();
    if (subtitle == "全部" || subtitle == "") {
        subtitle = ""
        $(document).attr("title", subtitle + title + "_资讯频道_买豆粕网")
    } else {
        $(document).attr("title", subtitle + "_" + title + "_资讯频道_买豆粕网")
    }

    $("meta[name='description']").attr("content", "买豆粕网" + title + subtitle + "提供第一时间行业资讯信息，和专业人士独家分析观点")
    $("meta[name='keywords']").attr("content", title + "，" + subtitle + "大宗商品资讯分析，买豆粕网	")
}