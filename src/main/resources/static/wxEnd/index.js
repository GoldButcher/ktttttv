/**
 * Created by admin on 2017/4/10.
 */
$(function () {
    $.ajax({
        "url": "/getOpenId",
        "type": "GET",
        "async":false,
        success: function (msg) {
            if (msg.data != null)
                sessionStorage.setItem("openid", msg.data);
        }
    });

    $.get("/getOrdersByWeixin", {wx: sessionStorage.getItem('openid')})
        .success(function (data) {
            if (data.result === 'success')
                $("#orderItems").text(data.data.length);
            else
                alert("无法获取包厢信息");
        })
        .fail(function () {
            alert("获取包厢信息失败");
        })
    $(".history").on('click', function () {

        location.href = 'history.html';
    });
    $(".boxDetail").on('click', function () {
        sessionStorage.setItem("typeId", $(this).data("typeId"));
        sessionStorage.setItem("price", $(this).data("price"));
        sessionStorage.setItem("name", $(this).data("name"));
        location.href = 'boxDetail.html';
    });
    $.ajax({
        "url": "/getAllBoxTypeInfo",
        "type": "GET",
        "success": function (data) {
            var accinfo = $(".acc-info");
            for (var i = 0; i < accinfo.length; i++) {
                var span1 = $(accinfo).eq(i).find("span").eq(0);
                var span2 = $(accinfo).eq(i).find("span").eq(1);
                $(span1).text(data.data[i].name);
                $(span2).text("￥" + data.data[i].price);
                $(".boxDetail").eq(i)
                    .data("typeId", data.data[i].boxTypeId)
                    .data("price", data.data[i].price)
                    .data("name", data.data[i].name);
            }
        }
    });
});