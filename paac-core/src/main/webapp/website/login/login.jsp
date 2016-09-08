<%--
  Created by IntelliJ IDEA.
  User: sy.he
  Date: 2016/9/8
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //paac-core
    String routePath = request.getContentPath() ;
    //http://localhost:8080/paac-core/
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + routePath + "/" ;
%>

<html>
<head>
    <title>平台云 | 平台服务 | 平台登录</title>
</head>
<body>
<div class="Login-wrapper">
    <div class="Login_bg">
        <img src="/website/skin/default/images/login/Index_bg2.jpg">
    </div>
    <div class="Login-wrap">
        <div class="Login-Info">
            <h3><a href="<%=rootPath%>/index.jsp"><img src="/website/skin/default/images/login/Login_logo.png"></a></h3>
            <div class="Login-tab-wrap">
                <div class="Login-tab">
                    <ul class="Login-tab-list clear">
                        <li>
                            <a href="javascript:void(0);" class="active-off active" type="User">个人用户</a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="active-off" type="Doctor">专业人员</a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="active-off" type="Ea">签约机构</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="Login-User-wrap " id="loginDiv">
                <div class="Login-User">
                    <ul class="Login-User-list clear">
                        <li class="">
                            <div class="Login-Int-Us" id="zfocus">
                                <em style="display:">ID号/昵称/E-mail/手机号</em>
                                <input type="text" id="username" name="username" class="input-txt" >
                                <span>请输入帐号</span>
                            </div>
                        </li>
                        <li class=""><!-- 错误样式.err -->
                            <div class="Login-Int-Ps" id="zfocus">
                                <em style="display:">密码</em>
                                <input type="password" id="password" name="password" class="input-txt" >
                                <span>请输入密码</span>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="Login-But clear">
                    <a href="javascript:void(0);" onclick="javascript:login();" >登录</a>
                </div>
                <div class="Login-Txt clear">
                    <strong>还没有帐号<a href="<%=rootPath%><%=response.encodeUrl("/website/login/Reg_User.jsp")%>" target="_blank">立即注册</a></strong>
                    <em><a href="<%=rootPath%><%=response.encodeUrl("/website/login/Reg_Password.jsp")%>">忘记密码</a></em>
                </div>
            </div>
        </div>
        <div class="Login-Boot">Copyright © 2016 中国健康云 All Rights Reserved.</div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function(){
        $(".active-off").click(function() {
            $(".active").attr("class", "active-off");
            $(this).attr("class", "active");
            if ($(this).attr("type") != "User")
                $(".Login-Txt strong").hide();
            else
                $(".Login-Txt strong").show();
        });

        $("#zfocus em").click(function() {

            $(this).hide();
            $(this).next("input").focus();
        })
        $("#zfocus span").click(function() {
            $(this).hide();
            $(this).prev("input").focus();
        })

        $("#zfocus .input-txt").each(function() {
            var thisVal = $(this).val();
            //聚焦型输入框验证
            $(this).focus(function() {
                $(this).siblings("em").hide();
                $(this).siblings("span").hide();
                $(this).parent("div").parent("li").removeClass("err");
                $(this).parent("div").parent("li").addClass("onto");
            }).blur(function() {
                var val = $(this).val();
                if (val != "") {
                    $(this).siblings("span").hide();
                    $(this).parent("div").parent("li").removeClass("onto");
                } else {
                    $(this).siblings("em").show();
                    $(this).parent("div").parent("li").removeClass("onto");
                }
            }).keyup(function(){
                $(this).triggerHandler("blur");
                $(this).siblings("em").hide();
            });

        });
    });
    $("#loginDiv").keypress(function(e) {
        if (e.which == 13) {
            login();
        }
    });
    function setErrorInfo(obj, value) {
        if (value == "") {
            obj.parent("div").parent("li").removeClass("err");
        } else {
            obj.parent("div").parent("li").addClass("err");
        }
        obj.blur();
        obj.next("span").html(value);
        obj.next("span").show();
    }
    //验证用户登录
    function validateLogin() {
        var error = 0;
        if ($("#username").val().length == 0) {
            setErrorInfo($("#username"), "请输入帐号");
            error++;
        } else {
            setErrorInfo($("#username"), "");
        }
        if ($("#password").val().length == 0) {
            setErrorInfo($("#password"), "请输入密码");
            error++;
        } else {
            setErrorInfo($("#password"), "");
        }
        return error == 0 ? true : false;
    }
    function login() {
        $("body").loadingOverlay();
        var type = $(".active").attr("type");
        if (validateLogin()) {
            var url = "<%=rootPath%>/login" + type + ".action?random=" + Math.round(Math.random() * 100);
            $.ajax({
                url : url,
                type : 'post',
                data : {
                    username : $("#username").val(),
                    password : $("#password").val(),
                    upUrl : document.referrer
                },
                dataType : "json",
                success : function(data) {
                    if (data.msg == '1') {
                        setErrorInfo($("#username"), "用户不存在");
                        $("body").loadingOverlay('remove');
                    } else if (data.msg == '2') {
                        setErrorInfo($("#password"), "密码错误");
                        $("body").loadingOverlay('remove');
                    } else if (data.msg == '3') {
                        setErrorInfo($("#password"), "您未获得医生登录资格");
                        $("body").loadingOverlay('remove');
                    } else if (data.msg == '4') {
                        setErrorInfo($("#password"), "您的医生资格被锁定");
                        $("body").loadingOverlay('remove');
                    } else if (data.msg == '5') {
                        setErrorInfo($("#password"), "您的机构未获得登录资格");
                        $("body").loadingOverlay('remove');
                    } else if (data.msg == '6') {
                        setErrorInfo($("#password"), "您的机构资格被锁定");
                        $("body").loadingOverlay('remove');
                    } else if (data.msg == '7') {
                        setErrorInfo($("#password"), "请选择签约机构登录");
                        $("body").loadingOverlay('remove');
                    } else {
                        if (data.msg == "") {
                            var exp = new Date();
                            exp.setTime(exp.getTime() + 1 * 24 * 60 * 60 * 1000);
                            document.cookie = "login=1;expires=" + exp.toGMTString() + ";path=/";
                            history.go(-1);
                        } else
                            window.location.href = data.msg;
                    }
                }
            });
        } else {
            $("body").loadingOverlay('remove');
        }
    }
    function clientUserlogin(username,password,userType) {
        $("body").loadingOverlay();
        var type = $(".active").attr("type");
        var url = "<%=rootPath%>/login" + type + ".action?random=" + Math.round(Math.random() * 100);
        $.ajax({
            url : url,
            type : 'post',
            data : {
                username : username,
                password : password,
                userType : userType
            },
            dataType : "json",
            success : function(data) {
                if (data.msg == '1') {
                    //$("body").loadingOverlay('remove');
                } else if (data.msg == '2') {
                    //$("body").loadingOverlay('remove');
                } else {
                    window.location.href = data.msg;
                    return "suc";
                }
                return "err";
            }
        });
    }
</script>
</body>
</html>
