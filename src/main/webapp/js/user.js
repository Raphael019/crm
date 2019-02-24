function queryUsersByParams() {
    $('#dg').datagrid('load',{
        userName: $("#userName").val(),
        email: $("#email").val(),
        phone: $("#phone").val()
    });
}

function openAddUserDailog() {
    $("#dlg").window("open");
}