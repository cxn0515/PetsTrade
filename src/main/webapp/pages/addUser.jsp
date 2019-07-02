<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加用户</title>
    <link rel="stylesheet" type="text/css" href="../../ui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../../ui/themes/icon.css">
    <script type="text/javascript" src="../../ui/jquery.min.js"></script>
    <script type="text/javascript" src="../../ui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../../ui/locale/easyui-lang-zh_CN.js"></script>
</head>
<style type="text/css">
    .divForm {
        text-align: center
    }
    table{
        margin: 0px auto;
    }
    form{
        margin: 0px auto;
    }
</style>
<body>
<div style="text-align: center;">
    <div style="padding:13px 12px;border-bottom:5px solid #fff">添加用户</div>
    <div class="divForm">
        <form id="upUserForm" method="post" enctype="multipart/form-data">
            <table>
                <tr style="margin-top: 20px">
                    <td>用户名:</td>
                    <td><input id="userName" name="userName" type="text"></input></td>
                </tr>
                <tr style="margin-top: 20px">
                    <td>密码:</td>
                    <td><input id="password" name="password" type="text"></input></td>
                </tr>
                <tr style="margin-top: 20px">
                    <td>角色:</td>
                    <td><select id="roleName" name="roleName" class="comboxCls">
                        <option value="" selected="selected">请选择角色</option>
                        <option value="user">普通用户</option>
                        <option value="admin">管理员</option>
                    </select></td>
                </tr>
                <tr style="margin-top: 20px">
                    <td></td>
                    <td><input type="button" class="btnCls" value="提交" onclick="submitUser()"></input></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<script>
    function submitUser() {
        var userName = $("#userName").val();
        var password = $("#password").val();
        var roleName = $("#roleName").val();
        if (userName == null || userName == "") {
            alert("用户名不能为空！");
            return;
        }
        if (password == null || password == "") {
            alert("密码不能为空！");
            return;
        }
        var params = $("#upUserForm").serialize();
        $.ajax({
            type: "POST",
            url: "<%=basePath%>user/add",
            data: params,
            dataType: "json",
            success: function (result) {
                if (result == 'success') {
                    alert("保存成功");
                    location.reload();//同步刷新当前页面的数据
                }
            },
            error: function () {
                alert("系统异常，请联系管理员！");
            }
        });
    }
</script>
</body>
</html>