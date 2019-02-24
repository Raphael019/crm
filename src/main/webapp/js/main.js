function openTab(text, url, iconCls) {
    if ($("#tabs").tabs("exists", text)) {
        $("#tabs").tabs("select", text);
    } else {
        var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='" + url + "'></iframe>";
        $("#tabs").tabs("add", {
            title: text,
            iconCls: iconCls,
            closable: true,
            content: content
        });
    }
}


/**
 * 退出操作
 */
function logout() {
    $.messager.confirm('来自Crm的提示信息','您确认想退出系统吗吗？',function(r){
        if (r){
            /*确认退出 清楚cookie*/
           $.removeCookie("userIdStr");
           $.removeCookie("userName");
           $.removeCookie("realName");

           /*页面跳转*/
            window.location.href=ctx+"/index";
        }
    });
}

/**
 * 打开修改密码对话框操作
 */
function openPasswordModifyDialog() {
    $('#dlg').dialog('open');  // open a window

    var arrCook = document.cookie.split(';');
    for(var i=0;i<arrCook.length;i++){
        if ((arrCook[i].indexOf('userName'))==0){
            var arrstr = arrCook[i].split("=");
            $("#userName").val(arrstr[1])
        }
    }

}

/**
 * 修改密码操作,
 *  修改成功,并跳转到登录页面
 */
function modifyPassword() {
    $('#fm').form('submit', {
        url:ctx+"/user/updateUserPwd",
        onSubmit: function(){
            return $(this).form('validate'); /* 输入框参数非空校验*  , validate 是一个方法名 */
        },
        success:function(data){
            var datajson = JSON.parse(data);
            alert(datajson.msg)
            if(datajson.code==200){
                window.location.href=ctx+"/index";
            }

        }
    });
}

function closePasswordModifyDialog() {
    $('#dlg').dialog("close");
    $('#fm').form('clear');
}