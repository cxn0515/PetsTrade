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
    <title>用户列表</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>ui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>ui/themes/icon.css">
    <script type="text/javascript" src="<%=basePath%>ui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>ui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>ui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<div style="text-align: center;">
    <table class="easyui-datagrid" style="width:auto;  height: 450px; padding: 5px"
           data-options="url:'user/userList.action',fitColumns:true,singleSelect:true">
        <thead>
        <tr>
            <th data-options="field:'userName',width:80">名称</th>
            <th data-options="field:'roleName',width:80">角色</th>
        </tr>
        </thead>
    </table>
</div>
</body>
<script>
    $(document).ready(function () {
        page_init();
    });
    function page_init() {
        $("#dataTable").datagrid({
            url: "userList",
            pagination: true//分页控件
        });
    }
</script>
</html>