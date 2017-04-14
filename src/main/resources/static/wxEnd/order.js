/**
 * Created by admin on 2017/4/11.
 */
$(function () {
    $("#boxType").val(sessionStorage.getItem("name"));
    $(".orderBtn").click(function () {
            var date = $("#bookDate").val();
            var telephone = $("#mobilePhone").val().trim();
            var userName = $("#userName").val().trim() || "";
            var description = $(".description").text().trim() || "";
            var pattern = /^1[34578]\d{9}$/;
            if (telephone.length < 1) {
                alert("请填写手机号");
            }
            else if(!pattern.test(telephone)){
                alert("请填写正确的手机号");
            }
            else {
                $.ajax({
                    "url": "/bookBoxFromWeixin",
                    "type": "POST",
                    "dataType": "JSON",
                    "data": {
                        "date": date,
                        "typeId": sessionStorage.getItem("typeId"),
                        "weixin": sessionStorage.getItem('openid')||"",
                        "telephone": telephone,
                        "userName": userName,
                        "description": description
                    }
                }).done(function (msg) {
                    alert("成功预定!");
                    $("#mobilePhone").val('');
                    $("#userName").val('');
                    $(".description").text('');
                    location.href="history.html";
                }).fail(function () {
                    alert("预定失败,请重试");
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