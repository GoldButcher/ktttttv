/**
 * Created by admin on 2017/4/12.
 */
$(function () {
    $.ajax({
        "url":"/getSingleBookBoxInfo",
        "type":"GET",
        "data":{"id":sessionStorage.getItem("curBox")},
        "success":function (msg) {
            if(msg.result=="success"){
                $("#orderDate").html(msg.data.dat);
                $("#boxName").html(msg.data.boxName);
                $("#boxPrice").html("￥"+msg.data.price);
                $("#boxNumber").html(msg.data.boxNo);
                $("#phone").html(msg.data.tel);
            }else{
                alert("网络错误,请重新登陆");
            }
        }
    })

    var getDate = function () {
        var d = new Date();
        var Month = (d.getMonth()+1);
        if(Month<10)
            Month = "0"+Month;
        var str = d.getFullYear()+"-"+Month+"-"+d.getDate();
        return str;
    }

    $("#delete").click(function () {
        var curBox = sessionStorage.getItem("curBox");
        var orderDate = $("#orderDate").html();
        var boxNo = $("#boxNumber").html();
        var telephone = $("#phone").html();
        var nowDate = getDate();
        if(curBox==null){
            alert("取消失败")
            return ;
        }
        if(orderDate.trim() <= nowDate.trim()){
            alert("无法取消当日或者更早的订单!");
            return false;
        }
        $.ajax({
            "url":"/bookBoxCancel",
            "type":"POST",
            "data":{"date":orderDate,"boxNo":boxNo,"telephone":telephone},
            "success":function (data) {
                if(data.result=="success"){
                    alert("取消成功!");
                    location.href="history.html";
                }else {
                    alert("取消失败,请重试");
                }
            }
        })

    })

})