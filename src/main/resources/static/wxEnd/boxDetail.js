$(function () {
    $(".price").text("￥" + sessionStorage.getItem("price"));
    $(".bookNow").on('click', function () {
        location.href = 'order.html';
    });
    $(".btn-back").on('click', function () {
        location.href = 'index.html';
    });

});
/**
 * Created by admin on 2017/4/11.
 */
