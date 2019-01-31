/*懒加载*/
$(function () {
    $('img').lazyload({
        placeholder: './img/loading/loading.gif',
        // effect:"fadeIn",
        threshold : 0,
        data_attribute:"src"
    });
});

/*热门书籍切换*/
$(function () {
    $('.hot_content .left_info p').each(function (index,item) {
        $(item).mouseenter(function () {
            $('.hot_content .left_info p').removeClass('select');
            $(this).addClass('select');
            $('.hot_content .middle_list ul').css({display:'none'}).eq(index).css({display:'flex'});
        })
    });
});

/*排行榜*/
$(function () {
    $('.hot_content .right_info ul li').each(function (index,item) {
        $(item).mouseenter(function () {
            $('.hot_content .right_info ul li').removeClass('show');
            $(this).addClass('show');
        })
    });
    $('.hot_content .right_info').eq(0).mouseleave(function () {
        $('.hot_content .right_info ul li').removeClass('show').eq(0).addClass('show');
    });
});