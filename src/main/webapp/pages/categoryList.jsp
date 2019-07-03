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
    <title>分类列表</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>ui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>ui/themes/icon.css">
    <script type="text/javascript" src="<%=basePath%>ui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>ui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>ui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<table id="dg" class="easyui-datagrid" title="" style="width:700px;height:auto"
       data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb',
				url: 'category/categoryList.action',
				method: 'get',
				onClickRow: onClickRow
			">
    <thead>
    <tr>
        <th data-options="field:'rownum',width:80">序号</th>
        <th data-options="field:'chiName',width:100,editor:'textbox'">名称
        </th>
        <th data-options="field:'status',width:60,align:'center',editor:{type:'checkbox',options:{on:'1',off:'0'}}">Status</th>
    </tr>
    </thead>
</table>

<div id="tb" style="height:auto">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"
       onclick="append()">添加</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"
       onclick="removeit()">删除</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true"
       onclick="accept()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true"
       onclick="reject()">撤销</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"
       onclick="getChanges()">是否已编辑</a>
</div>

<script type="text/javascript">
    var editIndex = undefined;
    function endEditing() {
        if (editIndex == undefined) {
            return true
        }
        if ($('#dg').datagrid('validateRow', editIndex)) {
            var ed = $('#dg').datagrid('getEditor', {index: editIndex, field: 'chiName'});
            var productname = $(ed.target).combobox('getText');
            $('#dg').datagrid('getRows')[editIndex]['chiName'] = productname;
            $('#dg').datagrid('endEdit', editIndex);
            editIndex = undefined;
            return true;
        } else {
            return false;
        }
    }
    function onClickRow(index) {
        if (editIndex != index) {
            if (endEditing()) {
                $('#dg').datagrid('selectRow', index)
                    .datagrid('beginEdit', index);
                editIndex = index;
            } else {
                $('#dg').datagrid('selectRow', editIndex);
            }
        }
    }
    function append() {
        if (endEditing()) {
            $('#dg').datagrid('appendRow', {status: 'P'});
            editIndex = $('#dg').datagrid('getRows').length - 1;
            $('#dg').datagrid('selectRow', editIndex)
                .datagrid('beginEdit', editIndex);
        }
    }
    function removeit() {
        if (editIndex == undefined) {
            return
        }
        $('#dg').datagrid('cancelEdit', editIndex)
            .datagrid('deleteRow', editIndex);
        editIndex = undefined;
    }
    function accept() {
        if (endEditing()) {
            var $dg = $('#dg');
            var rows = $dg.datagrid('getChanges');
            if (rows.length) {
                var inserted = $dg.datagrid('getChanges', "inserted");
                var deleted = $dg.datagrid('getChanges', "deleted");
                var updated = $dg.datagrid('getChanges', "updated");
                var effectRow = new Object();
                if (inserted.length) {
                    effectRow["inserted"] = JSON.stringify(inserted);
                }
                if (deleted.length) {
                    effectRow["deleted"] = JSON.stringify(deleted);
                }
                if (updated.length) {
                    effectRow["updated"] = JSON.stringify(updated);
                }

                $.post("category/commit", effectRow, function (rsp) {
                    if (rsp == 0) {
                        $dg.datagrid('acceptChanges');
                        $('#dg').datagrid('reload');
                        $.messager.alert("提示", "提交成功！");
                    }
                }, "JSON").error(function () {
                    $.messager.alert("提示", "提交失败！");
                });
            }
        }

    }
    function reject() {
        $('#dg').datagrid('rejectChanges');
        editIndex = undefined;
    }
    function getChanges() {
        var rows = $('#dg').datagrid('getChanges');
        alert(rows.length + '行被编辑');
    }
</script>
</body>
</html>