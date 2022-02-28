//提交个人信息表单
function toFromPerson() {
    UpdateCookieUser();
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

        if (pwdn1 == null || pwdn1 == "") {
            person.password = person.signPassword;
        }

        if(oldUser.basis=="email"){
            person.signId=oldUser.email;
        }else if(oldUser.basis=="phone"){
            person.signId=oldUser.phone;
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
                UpdateCookieUser();
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
    UpdateCookieUser();
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

//更新本地Cookie用户信息
function UpdateCookieUser() {
        console.log("更新个人信息");
        function getSign() {

            var user=Page.Cookie.getCookieUser();

            var ret = new Object();

            ret.role=user.role;
            ret.basis = user.basis;
            ret.id = user.id;
            ret.password = user.password;
            return JSON.stringify(ret);
        }

        $.ajax({
            url: Page.Redirect.toLogin,
            contentType: "application/json",
            data: getSign(),
            dataType: "JSON",
            type: "POST",
            success: function(data) {
                console.log("获取到json，开始检查");
                if(data!=null){
                    //登录成功后，把用户信息写入到cookie里面
                    console.log("获取到json，非空");
                    Page.Cookie.setCookieUser(data);
                    console.log("写入cookie");
                    console.log("更新时间戳");
                    Page.Cookie.setCookiePageTime();
                }else{
                    console.log("更新失败");
                }
            },
            error: function(XMLResponse) {
                console.log(XMLResponse.responseText);
            }
        });

}

//用于获取所有院系内的教师和班级的结构
function getSchoolStructure() {
    $.ajax({
        url: Page.Redirect.getSchoolStructure,
        contentType: "application/json",
        dataType: "JSON",
        type: "POST",
        async: false,
        success: function (data) {
            console.log("获取到json，开始检查");
            if (data != null) {
                console.log(data);
                Page.Cookie.setCookieSchool(data);
            } else {
                alert("获取学校结构信息失败");
            }
        },
        error: function (XMLResponse) {
            console.log(XMLResponse.responseText);
        }
    });
}

//获取管理院系信息表单
function goManageDepartment() {
    getSchoolStructure();
    var urlPath = Page.Value.urlRoot + "GetHtmlPageMain/getFromManageDepartment.action";
    $.ajax({
        url: urlPath,
        contentType: "text",
        dataType: "html",
        type: "post",
        success: function (data) {
            console.log("与服务器连接成功，获取页面成功。");
            var fromHtml = document.getElementById("mainblock");
            fromHtml.innerHTML = data;
            setSelectDepartment();
        },
        error: function (XMLResponse) {
            console.log(XMLResponse.responseText);
            alert("与服务器连接失败");
        }
    });
}

//获取管理班级信息表单
function goManageClasse() {
    getSchoolStructure();
    var urlPath = Page.Value.urlRoot + "GetHtmlPageMain/getFromManageClasse.action";
    $.ajax({
        url: urlPath,
        contentType: "text",
        dataType: "html",
        type: "post",
        success: function (data) {
            console.log("与服务器连接成功，获取页面成功。");
            var fromHtml = document.getElementById("mainblock");
            fromHtml.innerHTML = data;

            setSelectDepartment();
        },
        error: function (XMLResponse) {
            console.log(XMLResponse.responseText);
            alert("与服务器连接失败");
        }
    });
}

//获取学生更新班级信息表单
function goUpdateClasse() {
    UpdateCookieUser();
    getSchoolStructure();
    var urlPath = Page.Value.urlRoot + "GetHtmlPageMain/getFromUpdateClasse.action";
    $.ajax({
        url: urlPath,
        contentType: "text",
        dataType: "html",
        type: "post",
        success: function (data) {
            console.log("与服务器连接成功，获取功能模块成功");
            var fromHtml = document.getElementById("mainblock");
            fromHtml.innerHTML = data;

            setSelectDepartment();
        },
        error: function (XMLResponse) {
            console.log(XMLResponse.responseText);
            alert("与服务器连接失败");
        }
    });
}

//获取教师更新院系信息表单
function goUpdeteDepartment() {
    UpdateCookieUser();
    getSchoolStructure();
    var urlPath = Page.Value.urlRoot + "GetHtmlPageMain/getFromUpdeteDepartment.action";
    $.ajax({
        url: urlPath,
        contentType: "text",
        dataType: "html",
        type: "post",
        success: function (data) {
            console.log("与服务器连接成功，获取页面成功。");
            var fromHtml = document.getElementById("mainblock");
            fromHtml.innerHTML = data;

            setSelectDepartment();
        },
        error: function (XMLResponse) {
            console.log(XMLResponse.responseText);
            alert("与服务器连接失败");
        }
    });
}

//写入SelectDepartment
function setSelectDepartment() {
    var schoolstructure=Page.Cookie.getCookieSchool();
    var user = Page.Cookie.getCookieUser();

    var htmlObject = document.getElementById("selectDepartment");

    var htmlText = "<option value=\"\" hidden>请选择</option><option value=\"\" style=\"display: none;\">请选择</option>";

    for (var i = 0; i < schoolstructure.school.length; i++) {


        if(user.role=="Student" || user.role=="Teacher"){
            if(user.department==schoolstructure.school[i].id){
                htmlText = htmlText + "<option value=\"" + schoolstructure.school[i].id + "\" selected=\"selected\" >" + schoolstructure.school[i].name + "</option>";

                if(user.role=="Student" ){
                    if(schoolstructure.school[i].classeList != null){
                        var classeList=schoolstructure.school[i].classeList ;
                        var classeOptionHtml="";
                        for (var j = 0; j < classeList.length ; j++) {
                            if( classeList[j].split("_")[0] == user.classe){
                                classeOptionHtml=classeOptionHtml+"<option value=\"" + classeList[j].split("_")[0] + "\" id=\"" + classeList[j].split("_")[0] + "\"  selected=\"selected\"  >" + classeList[j].split("_")[1] + "</option>";
                            }else{
                                classeOptionHtml=classeOptionHtml+"<option value=\"" + classeList[j].split("_")[0] + "\" id=\"" + classeList[j].split("_")[0] + "\" >" + classeList[j].split("_")[1] + "</option>";
                            }
                        }
                        document.getElementById("selectClasse").innerHTML=classeOptionHtml;
                    }
                }

            }else{
                htmlText = htmlText + "<option value=\"" + schoolstructure.school[i].id + "\" >" + schoolstructure.school[i].name + "</option>";
            }
        }else{
            htmlText = htmlText + "<option value=\"" + schoolstructure.school[i].id + "\" >" + schoolstructure.school[i].name + "</option>";
        }

    }
    htmlObject.innerHTML = htmlText;

}

//写入goManageDepartment的输入框
function setSelectDepartmentText(){
    var idText="";
    var nameText="";

    var htmlObject = document.getElementById("selectDepartment");
    idText = htmlObject.options[htmlObject.selectedIndex].value;
    nameText=htmlObject.options[htmlObject.selectedIndex].text;

    document.getElementById("ctrlId").value=idText;
    document.getElementById("ctrlName").value=nameText;

}

//写入setSelectClasse
function setSelectClasse() {

    //获取school结构
    var schoolstructure = Page.Cookie.getCookieSchool();

    //获取selectClasse元素
    var htmlObject = document.getElementById("selectDepartment");

    var departmentId = htmlObject.options[htmlObject.selectedIndex].value;

    //找出selectDepartment对象对应的班级列表啊
    var classeList;
    for (var i = 0; i < schoolstructure.school.length; i++) {
        if (schoolstructure.school[i].id == departmentId) {
            classeList = schoolstructure.school[i].classeList;
        }
    }

    //将找到的班级列表写入selectClasse
    var htmlText = "<option value=\"\" hidden>请选择</option><option value=\"\" style=\"display: none;\">请选择</option>";
    for (var i = 0; i < classeList.length; i++) {
        htmlText = htmlText + "<option value=\"" + classeList[i].split("_")[0] + "\" id=\"" + classeList[i].split("_")[0] + "\">" + classeList[i].split("_")[1] + "</option>";
    }

    document.getElementById("selectClasse").innerHTML = htmlText;
}

//写入goManageClasse的输入框
function setSelectClasseText(){
    var idText="";
    var nameText="";

    var htmlObject = document.getElementById("selectClasse");
    idText = htmlObject.options[htmlObject.selectedIndex].value;
    nameText=htmlObject.options[htmlObject.selectedIndex].text;

    document.getElementById("ctrlId").value=idText;
    document.getElementById("ctrlName").value=nameText;

}

//学生修改班级信息
function toFromSchoolStudent(){
    UpdateCookieUser();
    getSchoolStructure();
    var departmentId;
    var classeId;

    var signPassword=document.getElementById("password").value;

    var htmlObject = document.getElementById("selectDepartment");

    departmentId = htmlObject.options[htmlObject.selectedIndex].value;

    htmlObject = document.getElementById("selectClasse");
    classeId = htmlObject.options[htmlObject.selectedIndex].value;



    if (departmentId == null || classeId == null || departmentId == "" || classeId == "") {

    } else {
        var oldUser = Page.Cookie.getCookieUser();
        var fromSchoolBean = {
            'signrole': oldUser.role,
            'signbasis': oldUser.basis,
            'signId': oldUser.id,
            'signPassword': signPassword,
            'department':departmentId,
            'classe':classeId
        };

        if(oldUser.basis=="email"){
            fromSchoolBean.signId=oldUser.email;
        }else if(oldUser.basis=="phone"){
            fromSchoolBean.signId=oldUser.phone;
        }

        $.ajax({
            url: Page.Redirect.toFromSchool,
            contentType: "application/json",
            data: JSON.stringify(fromSchoolBean),
            dataType: "JSON",
            type: "POST",
            success: function (data) {
                if (data) {
                    alert("更新成功");
                    goUpdateClasse();
                } else {
                    alert("更新失败");
                }
            },
            error: function (XMLResponse) {
                console.log(XMLResponse.responseText);
                alert("更新失败");
            }
        });
    }

}

//教师修改院系信息
function toFromSchoolTeacher(){

    UpdateCookieUser();
    getSchoolStructure();
    var departmentId;

    var signPassword=document.getElementById("password").value;

    var htmlObject = document.getElementById("selectDepartment");

    departmentId = htmlObject.options[htmlObject.selectedIndex].value;




    if (departmentId == null  || departmentId == "") {

    } else {
        var oldUser = Page.Cookie.getCookieUser();
        var fromSchoolBean = {
            'signrole': oldUser.role,
            'signbasis': oldUser.basis,
            'signId': oldUser.id,
            'signPassword': signPassword,
            'department':departmentId,
            'classe':"null"
        };

        // if(oldUser.basis=="email"){
        //     fromSchoolBean.signId=oldUser.email;
        // }else if(oldUser.basis=="phone"){
        //     fromSchoolBean.signId=oldUser.phone;
        // }

        $.ajax({
            url: Page.Redirect.toFromSchool,
            contentType: "application/json",
            data: JSON.stringify(fromSchoolBean),
            dataType: "JSON",
            type: "POST",
            success: function (data) {
                if (data) {
                    alert("更新成功");
                    goUpdeteDepartment();
                } else {
                    alert("更新失败");
                }
            },
            error: function (XMLResponse) {
                console.log(XMLResponse.responseText);
                alert("更新失败,请先更新工号信息");
            }
        });
    }

}