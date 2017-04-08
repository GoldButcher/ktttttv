$(function(){
    $("input").keydown(function () {
        $(".login-alert").slideUp();
    })

    $("#loginBtn").click(function(){

        var username = $("#ManageAccount").val();
        var password = $("#ManagerPassword").val();
        $.ajax({
           url :"/dologin",
           type:"POST",
           dataType:"JSON",
           data:{"username":username,"password":password},
           success:function(data){
                if("error"==data.result)
                {
                    $(".login-alert").html(data.data).slideDown();
                }else{
                    $("#loginBtn").attr("disabled","disabled");
                    window.location.href="index.html";
                }
           },
           error:function(data){
               alert("网络错误,请重试");
           }

       });
   })
});