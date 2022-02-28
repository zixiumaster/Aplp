//获取管理院系信息表单
function goManageDepartmentAdd() {
    getSchoolStructure();
    var urlPath = Page.Value.urlRoot + "GetHtmlPageMain/getFromManageDepartmentAdd.action";
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
function goManageDepartmentUpd() {
    getSchoolStructure();
    var urlPath = Page.Value.urlRoot + "GetHtmlPageMain/getFromManageDepartmentUpd.action";
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
function goManageDepartmentDel() {
    getSchoolStructure();
    var urlPath = Page.Value.urlRoot + "GetHtmlPageMain/getFromManageDepartmentDel.action";
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

//添加院系
function toAddDepartment() {
    getSchoolStructure();
    var newId = document.getElementById("ctrlId").value;
    var newName = document.getElementById("ctrlName").value;

    if (newId == null || newName == null  || newId == "" || newName == "") {

    } else {
        var unit = {
            'role': "Department",
            'parent': "null",
            'id': newId,
            'name': newName
        };

        $.ajax({
            url: Page.Redirect.toAddUnit,
            contentType: "application/json",
            data: JSON.stringify(unit),
            dataType: "JSON",
            type: "POST",
            success: function (data) {
                if (data) {
                    alert("添加成功");
                    goManageDepartmentAdd();
                } else {
                    alert("添加失败");
                }
            },
            error: function (XMLResponse) {
                console.log(XMLResponse.responseText);
                alert("添加失败");
            }
        });
    }

}

//更新院系
function toUpdDepartment() {
    getSchoolStructure();
    htmlObject = document.getElementById("selectDepartment");
    var oldId = htmlObject.options[htmlObject.selectedIndex].value;
    var newId = document.getElementById("ctrlId").value;
    var newName = document.getElementById("ctrlName").value;


    if ( newId == null || newName == null || oldId == null  || newId == "" || newName == "" || oldId == "") {

    } else {
        var unit = {
            'role': "Department",
            'parent': "null",
            'oldId': oldId,
            'newId': newId,
            'newName': newName
        };

        $.ajax({
            url: Page.Redirect.toUpdUnit,
            contentType: "application/json",
            data: JSON.stringify(unit),
            dataType: "JSON",
            type: "POST",
            success: function (data) {
                if (data) {
                    alert("更新成功");
                    goManageDepartmentUpd();
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

//删除院系
function toDelDepartment() {
    getSchoolStructure();
    var htmlObject = document.getElementById("selectDepartment");
    var departmentId = htmlObject.options[htmlObject.selectedIndex].value;

    if (departmentId == null || departmentId == "") {

    } else {
        var unit = {
            'role': "Department",
            'parent': "null",
            'id': departmentId,
            'name': "null"
        };
        $.ajax({
            url: Page.Redirect.toDelUnit,
            contentType: "application/json",
            data: JSON.stringify(unit),
            dataType: "JSON",
            type: "POST",
            success: function (data) {
                if (data) {
                    alert("删除成功");
                    goManageDepartmentDel();
                } else {
                    alert("删除失败");
                }
            },
            error: function (XMLResponse) {
                console.log(XMLResponse.responseText);
                alert("删除失败");
            }
        });

    }


}

//获取管理班级信息表单
function goManageClasseAdd() {
    getSchoolStructure();
    var urlPath = Page.Value.urlRoot + "GetHtmlPageMain/getFromManageClasseAdd.action";
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
function goManageClasseUpd() {
    getSchoolStructure();
    var urlPath = Page.Value.urlRoot + "GetHtmlPageMain/getFromManageClasseUpd.action";
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
function goManageClasseDel() {
    getSchoolStructure();
    var urlPath = Page.Value.urlRoot + "GetHtmlPageMain/getFromManageClasseDel.action";
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

//添加班级
function toAddClasse() {
    getSchoolStructure();
    var htmlObject = document.getElementById("selectDepartment");
    var departmentId = htmlObject.options[htmlObject.selectedIndex].value;

    var newId = document.getElementById("ctrlId").value;
    var newName = document.getElementById("ctrlName").value;


    if (departmentId == null || newId == null || newName == null || departmentId == "" || newId == "" || newName == "") {

    } else {
        var unit = {
            'role': "Classe",
            'parent': departmentId,
            'id': newId,
            'name': newName
        };

        $.ajax({
            url: Page.Redirect.toAddUnit,
            contentType: "application/json",
            data: JSON.stringify(unit),
            dataType: "JSON",
            type: "POST",
            success: function (data) {
                if (data) {
                    alert("添加成功");
                    goManageClasseAdd();
                } else {
                    alert("添加失败");
                }
            },
            error: function (XMLResponse) {
                console.log(XMLResponse.responseText);
                alert("添加失败");
            }
        });
    }
}

//更新班级
function toUpdClasse() {
    getSchoolStructure();
    var htmlObject = document.getElementById("selectDepartment");
    var departmentId = htmlObject.options[htmlObject.selectedIndex].value;

    htmlObject = document.getElementById("selectClasse");
    var oldId = htmlObject.options[htmlObject.selectedIndex].value;

    var newId = document.getElementById("ctrlId").value;
    var newName = document.getElementById("ctrlName").value;


    if (departmentId == null || newId == null || newName == null || oldId == null || departmentId == "" || newId == "" || newName == "" || oldId == "") {

    } else {
        var unit = {
            'role': "Classe",
            'parent': departmentId,
            'oldId': oldId,
            'newId': newId,
            'newName': newName
        };

        $.ajax({
            url: Page.Redirect.toUpdUnit,
            contentType: "application/json",
            data: JSON.stringify(unit),
            dataType: "JSON",
            type: "POST",
            success: function (data) {
                if (data) {
                    alert("更新成功");
                    goManageClasseUpd();
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

//删除班级
function toDelClasse() {
    getSchoolStructure();
    var htmlObject = document.getElementById("selectDepartment");
    var departmentId = htmlObject.options[htmlObject.selectedIndex].value;
    htmlObject = document.getElementById("selectClasse");
    var classeId = htmlObject.options[htmlObject.selectedIndex].value;

    if (departmentId == null || classeId == null || departmentId == "" || classeId == "") {

    } else {
        var unit = {
            'role': "Classe",
            'parent': departmentId,
            'id': classeId,
            'name': "null"
        };

        $.ajax({
            url: Page.Redirect.toDelUnit,
            contentType: "application/json",
            data: JSON.stringify(unit),
            dataType: "JSON",
            type: "POST",
            success: function (data) {
                if (data) {
                    alert("删除成功");
                    goManageClasseDel();
                } else {
                    alert("删除失败");
                }
            },
            error: function (XMLResponse) {
                console.log(XMLResponse.responseText);
                alert("删除失败");
            }
        });
    }

}