//提交个人信息表单
function toFromPerson() {

    var pwdn1 = document.getElementById("password_new").value;
    var pwdn2 = document.getElementById("password_newverify").value;


    if ((pwdn1 == null && pwdn2 == null) || (pwdn1 == "" && pwdn2 == "") || (Page.FromTool.checkPassword(pwdn1, pwdn2))) {
        var oldUser = Page.Cookie.getCookieUser();
        var person = {
            'signrole': oldUser.role,
            'signbasis': oldUser.basis,
            'signId': oldUser.id,
            'signPassword': document.getElementById("oldpassword").value,
            'id': document.getElementById("id").value,
            'name': document.getElementById("name").value,
            'phone': document.getElementById("phone").value,
            'email': document.getElementById("email").value,
            'password': pwdn1
        };

        if (pwdn1 == null) {
            person.password = person.signPassword
        }

        $.ajax({
            url: Page.Redirect.toFromPerson,
            contentType: "application/json",
            data: JSON.stringify(person),
            dataType: "TEXT",
            type: "POST",
            success: function (data) {
                if (data == "yes") {
                    var user = Page.Cookie.getCookieUser();
                    user.id = person.id;
                    user.name = person.name;
                    user.phone = person.phone;
                    user.email = person.email;
                    Page.Cookie.setCookieUser(user);
                    alert("更新成功");
                } else {
                    alert("更新失败");
                }
            },
            error: function (XMLResponse) {
                console.log(XMLResponse.responseText);
                alert("更新失败");
            }
        });
    } else {
        alert("验证新密码失败,新密码和验证新密码不一样.");
    }

}

//获取个人信息表单
function goFromPerson() {
    $.ajax({
        url: Page.Redirect.goFromPerson,
        dataType: "html",
        type: "post",
        success: function (data) {
            console.log("与服务器连接成功，获取菜单Html成功。");

            var Html = document.getElementById("mainblock");
            Html.innerHTML = data;
            var user = Page.Cookie.getCookieUser();
            document.getElementById("id").value = user.id;
            document.getElementById("name").value = user.name;
            document.getElementById("email").value = user.email;
            document.getElementById("phone").value = user.phone;

        },
        error: function (XMLResponse) {
            console.log(XMLResponse.responseText);
            alert("与服务器连接失败");
        }
    });
}
