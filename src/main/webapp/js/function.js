//改变验证码事件
function changeImg(){
    var img = document.getElementById('codeimg');
    img.src = "createcode?x=" + Math.floor(Math.random()*100)
}

//提交验证并验证验证码
function submit(){
    var input = document.getElementsByTagName('input')[0];
    //ajax提交
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200) {
            alert(xhr.responseText);
        }
    }
    xhr.open('get','verifycode?code=' + input.value);
    xhr.send(null);
}

function FocusItem(obj) {
    if ($(obj).attr('name') == 'veryCode') {
        $(obj).next().next('span').html('').removeClass('error');
    } else {
        $(obj).next('span').html('').removeClass('error');

    }
}

function CheckItem(obj) {
    var msgBox = $(obj).next('span');
    switch($(obj).attr('name')) {
        case "username":
            if (obj.value == "") {
                msgBox.html('用户名不能为空');
                msgBox.addClass('error');
            }
            break;
        case "veryCode":
            var numshow = $(obj).next().next();

            if (obj.value == "") {
                numshow.html('验证码不能为空');
                numshow.addClass('error');
            } else {
                var url = "verifycode?code=" +encodeURI($(obj).val()) + "&random=" + Math.floor(Math.random()*100);

                $.get(url, function(data) {
                    if (data == "false") {
                        numshow.html('验证码输入有误');
                        numshow.addClass('error');
                    } else {
                        $(obj).next().next('span').html('').removeClass('error');
                    }
                });
            }
            break;
    }
}