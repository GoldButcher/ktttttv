/**
 * Created by admin on 2017/4/10.
 */
$(function () {
    $.ajax({
        "url":"/getOpenId",
        "type":"GET",
        success:function (msg) {
            alert(msg.data);
        }
    })

})