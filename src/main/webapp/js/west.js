// $(function() {
//     $('#tt').tree({
//         url : 'MC/findAllMenu.action',
//         lines : true,
//         onClick : function(node) {
//             addTab(node);
//         }
//     });
// });
// $(function() {
//     $('#tabs').tabs({
//         fit : true,
//         border : false
//     });
// });
// function addTab(node) {
//     if ($('#tabs').tabs('exists', node.text)) {
//         $('#tabs').tabs('select', node.text);
//     } else {
//             $('#tabs')
//                 .tabs(
//                     'add',
//                     {
//                         fit : true,
//                         border : false,
//                         title : node.text,
//                         selected : true,
//                         id : node.text,
//                         content : '<iframe scrolling="auto" frameborder="0"  src='
//                         + node.url
//                         + ' style="width:100%;height:100%;"></iframe>',
//                     });
//     }
// }

$(function () {
    $('#tree').tree({
        // url: 'MC/findAllMenu.action',
        url:"/js/province.json",
        method:"get",
        animate:true,
        checkbox:true,
        loadFilter: function(data){ //返回过滤过的数据进行展示。返回数据是标准树格式。
            if (data.data){
                return data.data;
            } else {
                return data;
            }
        },
        onClick: function (node) {
            if (node.state == 'closed' && (!$("#tree").tree('isLeaf', node.target))) {  //状态为关闭而且非叶子节点
                $(this).tree('expand', node.target);//点击文字展开菜单  
                if (node && node.url) {
                    openTab(node);
                }
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
    };
    $.getJSON("<%=basePath%>/province.json", "", function(data) {
        //each循环 使用$.each方法遍历返回的数据date
        $.each(data.first, function(i, item) {
            var str = '<div>姓名:' + item.text + '性别：' + item.text + '</div>';
            document.write(str);
        })
    });
});