var content = "#mainContent";

$.nav = function (url) {
    switch (url) {
        case 'bigBox':
            sessionStorage.setItem('bt', 2);
            $.nav("navBoxType");
            break;
        case 'midBox':
            sessionStorage.setItem('bt', 3);
            $.nav("navBoxType");
            break;
        case 'smlBox':
            sessionStorage.setItem('bt', 4);
            $.nav("navBoxType");
            break;
        case 'vluxBox':
            $.nav('viewBoxList');
            break;
        case 'vsmlBox':
            $.nav('viewBoxList');
            break;
        case 'vmidBox':
            $.nav('viewBoxList');
            break;
        case 'vbigBox':
            $.nav('viewBoxList');
            break;
        case 'luxBox':
            sessionStorage.setItem('bt', 1);
            $.nav("navBoxType");
            break;
        case 'about':
            sessionStorage.setItem('info', 2);
            $.nav("aboutUs");
            break;
        case 'shoptDescription':
            sessionStorage.setItem('info', 1);
            $.nav("editShopInfo");
            break;
        default:
            $.get(url + '.html').success(function (data) {
                $("#mainContent").html(data)
            });
            break;
    }
};
$(".sidebarMenu ul li").click(function () {
    $(this).addClass("active");
    $(this).siblings().removeClass("active");
});


