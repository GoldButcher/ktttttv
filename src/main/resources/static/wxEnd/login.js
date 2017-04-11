var InterValObj; //timer变量，控制时间
var count = 60; //间隔函数，1秒执行
var curCount;//当前剩余秒数

function SetRemainTime() {
    if (curCount === 0) {
        window.clearInterval(InterValObj);// 停止计时器
        $("#getCheck").removeAttr("disabled");// 启用按钮
        $("#getCheck").html("获取验证码");
    }else {
        curCount--;
        $("#getCheck").html("在"+curCount + "秒内输入");
    }
}

$("#getCheck").click(function () {
    curCount = count;
    var mobile = $(".mobile").val();
    $("#getCheck").attr("disabled", "true");
    $("#getCheck").html("在"+curCount + "秒内输入");
    InterValObj = window.setInterval(SetRemainTime, 1000); // 启动计时器，1秒执行一次
    // $.ajax({
    //     url:"/getCheck",
    //     type:"GET",
    //     dataType:"JSON",
    //     data :{"mobile":mobile},
    //     success:function(data){
    //         //alert("成功发送");
    //     },
    //     error : function(data){
    //     }
    // });
})

$(".checkCode").keydown(function () {
    var val= $(this).val();
    if(val.trim().length>=5){
        $("#logBtn").prop("disabled",false);
    }else {
        $("#logBtn").prop("disabled", true)
    }
})

$("#logBtn").click(function () {
    var checkCode = $(".checkCode").val();
    $.ajax({
        url:"/check",
        type:"GET",
        dataType:"JSON",
        data:{"checkCode":checkCode},
        success:function (msg) {
            if(msg.result==="error"){
                alert(msg.data);
            }else{
                sessionStorage.mobile = $(".mobile").val();
                window.location.href="index.html";
            }
        }
    })
})
