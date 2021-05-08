//提交个人信息表单
function toFromPerson(){

    var oldUser=getCookieUser();

    var person={
        'role':oldUser.role,
        'basis':oldUser.basis,
        "attachment":getValue(oldUser,oldUser.basis),
        'password':oldUser.password,
        'id':document.getElementById("id").value,
        'name':document.getElementById("name").value,
        'phone':document.getElementById("phone").value,
        'email':document.getElementById("email").value,
    };

    var urlPath=urlRoot+"Major/toFromPerson.action";
    $.ajax({
        url: urlPath,
        contentType: "application/json",
        data: JSON.stringify(person),
        dataType: "TEXT",
        type: "POST",
        success: function(data) {
            if(data=="yes"){
                var user =getCookieUser();
                user.id=person.id;
                user.name=person.name;
                user.phone=person.phone;
                user.email=person.email;
                setCookieUser(user);
                alert("更新成功");
            }else{
                alert("更新失败");
            }
        },
        error: function(XMLResponse) {
            console.log(XMLResponse.responseText);
            alert("更新失败");
        }
    });

}

//获取个人信息表单
function goFromPerson(){
    var urlPath=urlRoot+"GetHtmlPageMain/getHtmlPageFormPerson.action";
    $.ajax({
        url: urlPath,
        dataType: "html",
        type: "post",
        success: function(data) {
            console.log("与服务器连接成功，获取菜单Html成功。");

            var Html = document.getElementById("mainblock");
            Html.innerHTML = data;
            var user =getCookieUser();
            document.getElementById("id").value=user.id;
            document.getElementById("name").value=user.name;
            document.getElementById("email").value=user.email;
            document.getElementById("phone").value=user.phone;

        },
        error: function(XMLResponse) {
            console.log(XMLResponse.responseText);
            alert("与服务器连接失败");
        }
    });
}
