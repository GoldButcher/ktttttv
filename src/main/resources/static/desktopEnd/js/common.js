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
            sessionStorage.setItem('vt', 1);
            $.nav('viewBoxList');
            break;
        case 'vsmlBox':
            $.nav('viewBoxList');
            sessionStorage.setItem('vt', 4);
            break;
        case 'vmidBox':
            $.nav('viewBoxList');
            sessionStorage.setItem('vt', 3);
            break;
        case 'vbigBox':
            sessionStorage.setItem('vt', 2);
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


