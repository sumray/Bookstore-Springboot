/*懒加载*/
$(function () {
    $('img').lazyload({
        placeholder: '../img/loading/loading.gif',
        // effect:"fadeIn",
        threshold : 0,
        data_attribute:"src"
    });
});

/*放大镜*/
$('#preview').preview();

/*数量加减*/
$(function () {
    const $numInp = $('#num').find('input');
    const num = {
        max:  $numInp.data('max'),
        init: 1,
        cur:1
    };
    $numInp.val(num.init);
    $numInp[0].oninput = function(){
        if(isNaN(Number(this.value)) || this.value === ''){
            num.cur = num.init;
            return this.value = num.cur;
        }
        if(this.value > num.max){
            num.cur = num.max;
            return this.value = num.cur;
        }
    };
    $numInp.on('blur',function () {
        if(this.value !== ''){
            num.cur = parseInt(this.value);
            this.value = num.cur;
        }
    });
    $numInp.on('keydown',function (e) {
        if(!((e.keyCode >= 48 && e.keyCode <= 57)||(e.keyCode >= 96 && e.keyCode <= 105) || e.keyCode === 8)){
            return false;
        }
    });
    $('#plus').on('click',function () {
        $numInp.val(`${num.cur >= num.max?num.max : ++num.cur}`);
    });
    $('#reduce').on('click',function () {
        $numInp.val(`${num.cur <= num.init?num.init : --num.cur}`);
    })
});

/*页面滚动*/
const Comment = class {
    constructor(ajax){
        this.ajax = ajax;
        this.maxNum = $('.comment').eq(0).data('num');
        this.initNum = $('.comment .comment_list').find('li').length;
        this.pageMax = 10;
        this.isEnough();
    }
    isEnough(){
        if(this.maxNum <= this.pageMax){
            $('.comment .more').hide();
        }
        else{
            this.scroll()
        }
    }
    scroll(){
        const _this = this;
        $(window).scroll(function () {
            const h = $(document).height() - $(window).height();
            if($(document).scrollTop() >= h){
                if(_this.initNum >= _this.maxNum){
                    $('.comment .more').hide();
                    return;
                }
                const [data,length] = [_this.ajax(),_this.ajax().length];
                _this.append(data,length);
            }
        })
    }
    append(data,length){
        for(let i = 0; i < length; i++){
            $('.comment_list ul').append(`<li>
                <div class="username">用户昵称</div>
                <div class="content">
                    <p>${data[i]}</p>
                </div>
                <div class="time">2019-1-21 23:37</div>
            </li>`);
        }
        this.initNum += length;
    }
};
