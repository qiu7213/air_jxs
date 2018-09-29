var app = {};
app.server = "https://m2.jft365.cn/index.php/";

app.photourl = "https://m2.jft365.cn";
app.urL = "localhost:8080";
app.url2 = "http://a.jft365.cn";


app.post2= function(url, data,type, fun, err) {

    $.ajax({
        url: url,
        data: data,
        type: type,
        timeout: 5000,
        success: function(json, s, xhr) {
            app.wait.close();
            if(json == null) {
                console.log("json转换错误");
                return  console.log(xhr.responseText);
            }else{
                fun(json || null, json);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            app.wait.close();
            switch(textStatus) {
                case "abort":
                    return;
                case "error":
                    mui.toast('网络错误,请稍后重试!');
                    console.error("服务器错误:" + errorThrown);
                    break;
                case "timeout":
                    mui.toast('服务器连接超时,请重试!');
                    break;
                case "parsererror":
                    mui.toast('返回数据格式不规范!');
                    console.log("ajax返回格式错误:");
                    console.log(xhr.responseText);
                    break;
            }
        }
    });
};



app.wait = {
    show: function(msg) {
        plus.nativeUI.showWaiting(msg);
    },
    close: function() {
        if(window.plus) plus.nativeUI.closeWaiting();
    }
};





app.post= function(url, data, fun, err) {

    mui.ajax({
        url:app.urL + url,
        data: data,
        dataType: 'json',
        type: 'post',
        timeout: 5000,
        success: function(json, s, xhr) {
            app.wait.close();
            if(json == null) {
                console.log("json转换错误");
                return  console.log(xhr.responseText);
            }
            if(json.status==1) {     //状态为1代表正确
                fun(json || null, json);
            }else {
                console.log("ajax未处理的错误:" + json.msg);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            app.wait.close();
            switch(textStatus) {
                case "abort":
                    return;
                case "error":
                    mui.toast('网络错误,请稍后重试!');
                    console.error("服务器错误:" + errorThrown);
                    break;
                case "timeout":
                    mui.toast('服务器连接超时,请重试!');
                    break;
                case "parsererror":
                    mui.toast('返回数据格式不规范!');
                    console.log("ajax返回格式错误:");
                    console.log(xhr.responseText);
                    break;
            }
        }
    });
};
