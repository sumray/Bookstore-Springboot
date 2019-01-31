/*头部导航效果*/
$(function () {
    var length = $(".sui-nav li").length;//获取栏目个数
    var $line = $('.move_line').eq(0);//获取线
    var a_padding = parseInt($(".sui-nav li a").css('paddingLeft'));//导航文字padding值
    var initWidth = $('.sui-nav li').eq(0).width();
    $line.css({
        left: a_padding,
        width: initWidth - a_padding*2,
    });//线的初始样式

    /*鼠标进入每个li*/
    $(".sui-nav li").each(function (index,item){
        $(item).on('click',function () {
            $('.sui-nav').find('li').removeClass('selection');
            $(item).addClass('selection');
        });
        $(item).mouseenter(function (e) {
            $line.css({
                left: $(this).position().left + a_padding,
                width: $(this).width() - a_padding*2,
            });
        })
    });

    /*鼠标进入和离开nav*/
    $(".top_nav").eq(0).mouseenter(function () {
        $line.css({display: 'block'});
    });
    $(".top_nav").eq(0).mouseleave(function () {
        $line.css({
            display: 'none',
            left: 15,
            width: $(".sui-nav li").eq(0).width() - 30,
        });
    });
});
