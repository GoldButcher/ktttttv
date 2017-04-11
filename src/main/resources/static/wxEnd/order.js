/**
 * Created by admin on 2017/4/11.
 */
$(function () {
    $("#boxType").val(sessionStorage.getItem("name"));
    $(".orderBtn").click(function () {
            var date = $("#bookDate").val();
            var telephone = $("#mobilePhone").val();
            var userName = $("#userName").val().trim() || "";
            var description = $(".description").text().trim() || "";
            if (telephone.length < 1)
                alert("请填写手机号");
            else {
                $.ajax({
                    "url": "/bookBoxFromWeixin",
                    "type": "POST",
                    "dataType": "JSON",
                    "data": {
                        "date": date,
                        "typeId": sessionStorage.getItem("typeId"),
                        "weixin": "",
                        "telephone": telephone,
                        "userName": userName,
                        "description": description
                    }
                }).done(function (msg) {
                    alert("下单成功! 您的房间号为" + msg);
                    $("#mobilePhone").val('');
                    $("#userName").val('');
                    $(".description").text('');
                }).fail(function () {
                    alert("server fail");
                })
            }
        }
    );

    $(".history").on('click', function () {
        location.href = 'history.html';
    });
    $(".btn-back").on('click', function () {
        sessionStorage.removeItem("typeId");
        sessionStorage.removeItem("price");
        sessionStorage.removeItem("name");
        location.href = 'index.html';
    })
});