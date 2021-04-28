function loadCookieUser(){
    var user=getCookieUser();
    var UserName= document.getElementById("pageUser");
    userNameText=user.role+":"+user.idtype+":"+user.id;
    UserName.innerHTML=userNameText
}