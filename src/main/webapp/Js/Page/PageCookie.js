function getCookiePage(){
   return  getCookie("page");
}

function setCookiePage(){
    var Page={
        'lastrefreshtime':nowTime()
    }
    setCookie('page',Page);
}


function setCookieUser(data){
    console.log("获取到json，开始写入，$setCookieUser()");
    setCookie('user',data);

}


function getCookieUser(){
    return getCookie('user');
}

//写cookie
function setCookie(k,v){
    $.cookie(k, JSON.stringify(v));
}

//读cookie
function getCookie(k){
    return  JSON.parse($.cookie(k));
}
