function setCookieUser(role,idtype,id){
    var user={
        'role' : role,
        'idtype': idtype,
        'id': id
    };
    setCookie('user',user);
}

function getCookieUser(){
    return getCookie('user');
}

function setCookie(k,v){
    $.cookie(k, JSON.stringify(v));
}

function getCookie(k){
    return  JSON.parse($.cookie(k));
}

