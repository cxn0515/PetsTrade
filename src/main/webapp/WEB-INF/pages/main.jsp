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
    <title>Basic DataGrid - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>ui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>ui/themes/icon.css">
    <script type="text/javascript" src="<%=basePath%>ui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>ui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>ui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',collapsible:false,hideCollapsedContent:false" data-id="head"
         style="height:45px;overflow:hidden">

    </div>
    <!-- 左侧菜单 -->
    <div data-id="leftmenu" style="width:190px;overflow:auto;"
         data-options="region:'west',split:false,collapsible:false,style:{textAlign:'left'}">
        <ul id="tree" class="easyui-tree"></ul>
    </div>
    <div data-options="region:'center',split:true"><!--  -->
        <div id="tabs" class="easyui-tabs" data-options="toolPosition:'right',fit:true,border:false">
            <div title="主页">欢迎登录系统</div>
        </div>
    </div>
</div>

<script>
    $('#tree').tree({
        url: 'MC/findAllMenu.action',
//        url:"/js/province.json",
        method: "get",
        animate: true,
        checkbox: false,
        loadFilter: function (data) { //返回过滤过的数据进行展示。返回数据是标准树格式。
            if (data.data) {
                return data.data;
            } else {
                return data;
            }
        },
        onClick: function (node) {
            if (node.state == 'closed' && (!$("#tree").tree('isLeaf', node.target))) {  //状态为关闭而且非叶子节点
                $(this).tree('expand', node.target);//点击文字展开菜单  
            } else {
                if ($("#tree").tree('isLeaf', node.target)) {  //状态为打开而且为叶子节点
                    if (node && node.url) {
                        openTab(node);
                    }
                } else {
                    $(this).tree('collapse', node.target);//点击文字关闭菜单  
                }

            }
        }

    });
    function openTab(node) {
        if ($("#tabs").tabs("exists", node.text)) {
            $("#tabs").tabs("select", node.text);
        } else {
            $("#tabs").tabs("add", {
                title: node.text,
                closable: true,
                content: '<iframe scrolling="auto" frameborder="0"  src='
                + node.url
                + ' style="width:100%;height:100%;"></iframe>'
            });
        }
    }

</script>
</body>
</html>