<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basic DataGrid - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ui/themes/icon.css">
    <%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ui/demo.css">--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/ui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/ui/jquery.easyui.min.js"></script>
</head>
<body>
<h2>Basic DataGrid</h2>
<p>The DataGrid is created from markup, no JavaScript code needed.</p>
<div style="margin:20px 0;"></div>

<table class="easyui-datagrid" title="Basic DataGrid" style="width:700px;height:250px"
       data-options="singleSelect:true,collapsible:true,url:'${pageContext.request.contextPath}/user/main',method:'get'">
    <thead>
    <tr>
        <th data-options="field:'userName',width:80">Item ID</th>
        <th data-options="field:'password',width:100">Product</th>
        <th data-options="field:'roleName',width:80,align:'right'">List Price</th>
    </tr>
    </thead>
</table>

</body>
</html>