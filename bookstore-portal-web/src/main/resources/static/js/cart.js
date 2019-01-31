/**
 * 图片
 * 名称
 * 单价
 * 数量
 */
class BookInfo {
    constructor(info){
        this.state = false;
        this.src = info.src;
        this.name = info.name;
        this.price = info.price;
        this.num = info.num;
        this.li = document.createElement('li');
        this.input = document.createElement('input');
        this.click();
    }
    created(){
        const _this = this;
        const oDiv = document.createElement('div');
        const oDiv1 = document.createElement('div');
        const oDel = document.createElement('span');
        oDiv.className = 'checkBox';
        oDiv1.className = 'del';
        this.input.type = 'checkbox';
        oDel.innerHTML = '删除';
        oDiv.appendChild(this.input);
        oDiv1.appendChild(oDel);
        this.li.appendChild(oDiv);
        this.li.innerHTML += `
                        <div class="book">
                            <div class="img"><img src=${this.src} alt=""></div>
                            <div class="name">${this.name}</div>
                        </div>
                        <div class="book_price">${this.price}</div>
                        <div class="book_quantity">${this.num}</div>`;
        this.li.appendChild(oDiv1);
        $(oDiv1).on('click',function () {
            _this.li.parentNode.removeChild(_this.li);
        });
        return this.li;
    }
    click(){
        const _this = this;
        console.log($(this.input));
        $(this.input).on('click',function () {
            _this.state = !_this.state;
        });
    }
}