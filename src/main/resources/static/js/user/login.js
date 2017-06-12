/**
 * Created by user on 2017/3/20.
 */
$(function () {
    $("#button").click(function () {
        var username = $("#username").val();
        var userpwd = $("#userpwd").val();
        var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        if (username.length > 0 && userpwd.length > 0) {
            if(!myreg.test(username)){
                bootbox.alert("账号非法，请输入有效手机号");
                return false;
            }else{
            $.ajax({
                type: "POST",
                url: "/user/login/json",
                dataType: "json",
                data: { account: username, password: userpwd},
                success: function (data) {
                    if(data.result){
                        window.location.href='/';
                    }else {
                        bootbox.alert("账号或者密码错误!");
                    }
                }
            });
            }
        }else {
            bootbox.alert("请填写后再登录");
        }
    });


    $("#Retrievenow").click(function () {
        var email = $("#usrmail").val();
        var userpwd = $("#uPassword").val();
        var myreg = /^[-a-z0-9\._]+@([-a-z0-9\-]+\.)+[a-z0-9]{2,3}$/i;
        if (email.length > 0 && userpwd.length > 0) {
            if(!myreg.test(email)){
                bootbox.alert("邮箱非法，请输入正确邮箱");
                return false;
            }else{
                $.ajax({
                    type: "POST",
                    url: "/user/update/json",
                    dataType: "json",
                    data: { email: email, password: userpwd},
                    success: function (data) {
                        if(data.result){
                            window.location.href='/';
                        }else {
                            bootbox.alert("修改失败，请重新修改")
                            showErrors($('#forget_model'), data.errors);
                        }
                    }
                });
            }
        }else {
            bootbox.alert("请输入更改信息提交")
        }
    });



})
