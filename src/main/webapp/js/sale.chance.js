function formatState(value, row, index) {
    if (value == 1) {
        return "已分配";
    }

    if (value == 0) {
        return "未分配";
    }

}

function formatDevResult(value, row, index) {
    if (value == 0) {
        return "未开发";
    }
    if (value == 1) {
        return "开发中";
    }
    if (value == 2) {
        return "开发成功";
    }
    if (value == 3) {
        return "开发失败";
    }

}

/*点击搜索
*    获取相关参数 发送后台做查询
* */
function querySaleChancesByParams() {
    $('#dg').datagrid('load', {
        customerName: $("#customerName").val(),
        state: $("#state").combobox('getValue'),
        devResult: $("#devResult").combobox('getValue'),
        createDate: $("#time").datebox('getValue')
    });

}

function openAddSaleChacneDialog() {
    $('#dlg').dialog('open');
}

function InsertOrUpdateSaleChance() {
    $('#fm').form('submit', {
            url:ctx+"/saleChance/InsertOrUpdateSaleChance",
            onSubmit: function(){
                    return $(this).form('validate');
    },
    success:function(data){
            var str = JSON.parse(data);
            if(str.code == 200){
                alert(str.msg);
                $('#dlg').dialog('close');
                $('#dg').datagrid('reload');
            }

    }
});

}
function closeDlg() {
    $('#dlg').dialog('close');
}

function openModifySaleChanceDialog() {
    $('#dlg').dialog('open');
}