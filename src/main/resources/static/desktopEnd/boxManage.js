$(function () {
    var leftnumberspan = $(".leftnumber");
    var totalnumberspan = $(".totalnumber");
    $.ajax({
        url: "/getAllBoxTypeInfo",
        type: "GET",
        dataType: "JSON",
        success: function (data) {
            if (data.result === "success") {
                $(data.data).each(function (index) {
                    leftnumberspan.get(index).innerHTML = this.boxNum;
                    totalnumberspan.get(index).innerHTML = this.leftBoxNum;
                });
                $(".boxType").show();
            }
        }
    })

});