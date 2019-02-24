function login() {
   var userName = $("#username").val() ;
   var userPwd = $("#password").val();

   if(isEmpty(userName)){
        alert("用户名不能为空");
       return;
   }

   if(isEmpty(userPwd)){
       alert("密码不能为空");
       return;
   }

   $.ajax({
       url:ctx+"/user/login",
       type:"POST",
       data:{
           userName:userName,
           userPwd:userPwd
       },

       success:function(data){
          if (data.code == 200){
              alert("登录成功")
              /*存储cookie 信息*/
              $.cookie("userIdStr",data.result.userIdStr);
              $.cookie("userName",data.result.userName);
              $.cookie("realName",data.result.realName);

              /*页面跳转*/
              window.location.href=ctx+"/main";
          } else{
             //console.log(data);
              alert(data.msg);
          }
        }
   })
}