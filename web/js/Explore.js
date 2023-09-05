var p1_s = document.getElementsByClassName('passage1');
for (let i = 0; i < p1_s.length; i++) {
    const p1_ = p1_s[i];
    //将文章1的图片、标题设置为鼠标经过时指针形状改为hand
    p1_.onmouseover = function(){
        p1_.style.cursor = 'pointer';
    }
    //将文章1的图片、标题设置为点击时将当前页面url设置为指定文章位置
    p1_.onclick = function () {
        location.href = "文章1.html";
    }
}

var p2_s = document.getElementsByClassName('passage2');
for (let i = 0; i < p2_s.length; i++) {
    const p2_ = p2_s[i];
    p2_.onmouseover = function(){
        p2_.style.cursor = 'pointer';
    }
    p2_.onclick = function () {
        location.href = "文章2.html";
    }
}

var p3_s = document.getElementsByClassName('passage3');
for (let i = 0; i < p3_s.length; i++) {
    const p3_ = p3_s[i];
    p3_.onmouseover = function(){
        p3_.style.cursor = 'pointer';
    }
    p3_.onclick = function () {
        location.href = "文章3.html";
    }
}

var p4_s = document.getElementsByClassName('passage4');
for (let i = 0; i < p4_s.length; i++) {
    const p4_ = p4_s[i];
    p4_.onmouseover = function(){
        p4_.style.cursor = 'pointer';
    }
    p4_.onclick = function () {
        location.href = "文章4.html";
    }
}