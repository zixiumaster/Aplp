//获取发布课程表单
function getFromManageCurriculum() {
    $.ajax({
        url: Page.Redirect.getFromManageCurriculum,
        dataType: "html",
        type: "post",
        success: function (data) {
            console.log("与服务器连接成功，获取菜单Html成功。");

            var Html = document.getElementById("mainblock");
            Html.innerHTML = data;
            setSelectDepartment();
        },
        error: function (XMLResponse) {
            console.log(XMLResponse.responseText);
            alert("与服务器连接失败");
        }
    });
}

//获取教师发布章节表单
function getFromManagePart() {
    $.ajax({
        url: Page.Redirect.getFromManagePart,
        dataType: "html",
        type: "post",
        success: function (data) {
            console.log("与服务器连接成功，获取菜单Html成功。");

            var Html = document.getElementById("mainblock");
            Html.innerHTML = data;
            loadCurriculumListView();
            setCurriculum();
        },
        error: function (XMLResponse) {
            console.log(XMLResponse.responseText);
            alert("与服务器连接失败");
        }
    });
}

var partMap=new Map();

var myCurriculumList;

//教师发布章节页面_添加文件控件支持方法
//function FromManagePart_addFile
function FromManagePart_addFile() {
    document.getElementById("fileText").value = document.getElementById("lefile").value;

    var tempFile = document.getElementById("fileList");
    tempFile.innerHTML = tempFile.innerHTML + " <option vlaue=\"" + document.getElementById("lefile").value + "\">" + document.getElementById("lefile").value + "</option>";

    var file = document.getElementById("lefile").files[0];
    partMap.set(document.getElementById("lefile").value,file);
}
function FromManagePart_delFile() {
    var selectObject = document.getElementById("fileList");

    partMap.delete(selectObject.options[selectObject.selectedIndex].value);
    selectObject.options.remove(selectObject.selectedIndex);
    document.getElementById("fileText").value = "";
}

//清空
function clearSelectCheckClasse() {
    document.getElementById("selectCheckClasse").innerHTML = "";
}

//写入setSelectTeacher
function setSelectTeacher() {

    //获取school结构
    var schoolstructure = Page.Cookie.getCookieSchool();

    //获取selectDepartment元素
    var htmlObject = document.getElementById("selectDepartment");

    var departmentId = htmlObject.options[htmlObject.selectedIndex].value;

    //找出selectDepartment对象对应的教师列表啊
    var teacherList;
    for (var i = 0; i < schoolstructure.school.length; i++) {
        if (schoolstructure.school[i].id == departmentId) {
            teacherList = schoolstructure.school[i].teacherList;
        }
    }

    //将找到的班级列表写入selectClasse
    var htmlText = "<option value=\"\" hidden>请选择</option><option value=\"\" style=\"display: none;\">请选择</option>";
    for (var i = 0; i < teacherList.length; i++) {
        htmlText = htmlText + "<option value=\"" + teacherList[i].split("_")[0] + "\" id=\"" + teacherList[i].split("_")[0] + "\">" + teacherList[i].split("_")[1] + "</option>";
    }

    document.getElementById("selectTeacher").innerHTML = htmlText;
}

//课程发布页面_添加班级控件支持方法
function manageCurriculum_addClasse() {

    var selectClasse = document.getElementById("selectClasse");

    if (selectClasse.options[selectClasse.selectedIndex].value != "") {
        var selectCheckClasse = document.getElementById("selectCheckClasse");
        selectCheckClasse.innerHTML = selectCheckClasse.innerHTML + "<option value=\"" + selectClasse.options[selectClasse
                .selectedIndex].value + "\" >" + selectClasse.options[selectClasse.selectedIndex].text +
            "</option>";
        selectClasse.options.remove(selectClasse.selectedIndex);
    }
}

//课程发布页面_取消班级控件支持方法
function manageCurriculum_delClasse() {
    var selectCheckClasse = document.getElementById("selectCheckClasse");
    if (selectCheckClasse.options[selectCheckClasse.selectedIndex].value != "") {
        var selectClasse = document.getElementById("selectClasse");
        selectClasse.innerHTML = selectClasse.innerHTML + "<option value=\"" + selectCheckClasse.options[selectCheckClasse
                .selectedIndex].value + "\" >" + selectCheckClasse.options[selectCheckClasse.selectedIndex].text +
            "</option>";
        selectCheckClasse.options.remove(selectCheckClasse.selectedIndex);
    }
}

//管理员发布课程界面上传文件控件支持方法
function FromCurriculum_FileBtnclick() {
    $('input[id=lefile]').click();
}
function FromCurriculum_FileTextInput() {
    $('#FileList').val($('#lefile').val());

    var tempImgHtml = " <div class=\"white-panel pn donut-chart\" style=\"width: 20em;\">\n" +
        "                                        <div class=\"white-header\">\n" +
        "                                            <h5>封面预览</h5>\n" +
        "                                        </div>\n" +
        "                                        <div class=\"row\" style=\"margin:1em;\" >\n" +
        "                                            <img id=\"tempImg\" src=\"\"  width=\"150em\" height=\"150em\" style=\"margin: 0 auto\" />\n" +
        "                                        </div>\n" +
        "                                    </div>";


    var tempImgDiv = document.getElementById('tempImgDiv');
    tempImgDiv.innerHTML = tempImgHtml;


    var file = document.getElementById('lefile');
    var imgUrl = window.URL.createObjectURL(file.files[0]);
    var img = document.getElementById('tempImg');
    img.setAttribute('src', imgUrl); // 修改img标签src属性值
}

//提交创建课程表单
function toNewFromCurriculum() {
    var departmentId;               //院系Id
    var teacherId;                  //教师Id
    var classeIdList = new Array(); //班级Id列表
    var curriculumId;               //课程Id
    var curriculumName;             //课程名字
    var describeText;               //描述文字
    var file;                       //文件
    var fileName;                   //文件名

    var htmlObject = document.getElementById("selectDepartment");
    departmentId = htmlObject.options[htmlObject.selectedIndex].value;

    htmlObject = document.getElementById("selectTeacher");
    teacherId = htmlObject.options[htmlObject.selectedIndex].value;

    $("#selectCheckClasse option").each(function () {  //遍历全部option
        var txt = $(this).val();   //获取option值
        if (txt != '') {
            classeIdList.push(txt);  //加入到数组中
        }
    })

    curriculumId = document.getElementById("curriculumId").value;
    curriculumName = document.getElementById("curriculumName").value;
    describeText = document.getElementById("describeText").value;

    file = document.getElementById("lefile").files[0];
    fileName = file.name;


    var formdata = new FormData();

    formdata.append("file", file);
    formdata.append("fileName", fileName);
    formdata.append("curriculumId", curriculumId);
    formdata.append("curriculumName", curriculumName);
    formdata.append("describeText", describeText);
    formdata.append("departmentId", departmentId);
    formdata.append("teacherId", teacherId);
    formdata.append("classeList", classeIdList);

    $.ajax({
        url: Page.Redirect.addCurriculum,
        type: 'POST',
        data: formdata,
        // 告诉jQuery不要去处理发送的数据
        processData: false,
        // 告诉jQuery不要去设置Content-Type请求头
        contentType: false,
        async: false,
        success: function (data) {
            if (data=="yes") {
                console.log(data);
                alert("课程发布成功");
            }else{
                alert("课程发布失败");
            }
        }
    });

}

//加载课程预览模块
function goCurriculum(){
    UpdateCookieUser();
    $.ajax({
        url: Page.Redirect.getCurriculumListView,
        dataType: "html",
        type: "post",
        async: false,
        success: function (data) {
            console.log("与服务器连接成功，获取菜单Html成功。");

            var Html = document.getElementById("mainblock");
            Html.innerHTML = data;
            loadCurriculumListView();
            setCurriculumList();
        },
        error: function (XMLResponse) {
            console.log(XMLResponse.responseText);
            alert("与服务器连接失败");
        }
    });
}

//获取课程预览信息
function loadCurriculumListView(){
    var sign;
    if(Page.Cookie.getCookieUser().role=="Student"){
        sign = Page.Cookie.getCookieUser().role+"_"+Page.Cookie.getCookieUser().department+"_"+Page.Cookie.getCookieUser().classe;
    }else if(Page.Cookie.getCookieUser().role=="Teacher"){
        sign = Page.Cookie.getCookieUser().role+"_"+Page.Cookie.getCookieUser().department+"_"+Page.Cookie.getCookieUser().id;
    }else{
        return ;
    }
     $.ajax({
        url: Page.Redirect.getCurriculumList,
        contentType: "application/text",
        data: sign,
        dataType: "JSON",
        type: "POST",
        async: false,
        success: function (data) {
            console.log("获取到json，开始检查");
            if (data != null) {
                console.log(data);
                console.log(data.curriculumList);
                myCurriculumList=data.curriculumList;
                Page.Cookie.setCookieMyCurriculumList(data.curriculumList);

            } else {
                alert("获取课程列表结构信息失败");
            }
        },
        error: function (XMLResponse) {
            console.log(XMLResponse.responseText);
        }
    });
}

//写入setSelectCurriculum
function setCurriculum(){

    // curriculumList = Page.Cookie.getCookieMyCurriculumList();
    var curriculumList = myCurriculumList;
    console.log(curriculumList);
    var htmlText = "<option value=\"\" hidden>请选择</option><option value=\"\" style=\"display: none;\">请选择</option>";

    for (var i = 0; i < curriculumList.length; i++) {
        htmlText = htmlText + "<option value=\"" + curriculumList[i].curriculumId + "\" >" + curriculumList[i].curriculumName + "</option>";
    }



    document.getElementById("selectCurriculum").innerHTML = htmlText;

}

//写入学生课程预览模块
function setCurriculumList(){
    var htmltestString="";

    // var CurriculumList=Page.Cookie.getCookieMyCurriculumList();
    var CurriculumList = myCurriculumList;
    for(var i=0;i<CurriculumList.length;i++){
        var testHtml="<div class=\"col-md-4 col-sm-4 mb\" id=\""+CurriculumList[i].curriculumId+"\" onclick=\"loadPartView("+CurriculumList[i].curriculumId+");\">\n" +
            "\t\t\t\t\t\t\t\t\t<div class=\"white-panel pn donut-chart\">\n" +
            "\t\t\t\t\t\t\t\t\t\t<div class=\"white-header\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<h5>"+CurriculumList[i].curriculumName+"</h5>\n" +
            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t\t\t<div class=\"row\" style=\"margin:1em;\" >\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<img id=\"tempImg\" src=\""+ CurriculumList[i].coverPhotoUrl +"\"  width=\"150em\" height=\"150em\" style=\"margin: 0 auto\" />\n" +
            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t</div>";
        htmltestString=htmltestString+testHtml;
    }
    document.getElementById("curriculumBlock").innerHTML=htmltestString;

}

//进入章节列表
function loadPartView(curriculumId){

    //var CurriculumList=Page.Cookie.getCookieMyCurriculumList();
    var CurriculumList = myCurriculumList;
    var Curriculum;

    for(var i=0;i<CurriculumList.length;i++){
        if(CurriculumList[i].curriculumId==curriculumId){
            Curriculum=CurriculumList[i];
        }
    }
    getPartListTable();
    document.getElementById("curriculumTitle").innerHTML=Curriculum.curriculumName;
    for(var i in Curriculum.parts){
        var tempHtml=
            "<tr onclick=\"loadPartViewMain("+Curriculum.curriculumId+","+Curriculum.parts[i].partId+")\">\n" +
            "<td>"+Curriculum.parts[i].partId+"</td>\n" +
            "<td>"+Curriculum.parts[i].themeText+"</td>\n" +
            "<td>"+Curriculum.parts[i].describeText+"</td>\n" +
            "</tr>";
        var curriculumListTable=document.getElementById("curriculumListTable");
        curriculumListTable.innerHTML=curriculumListTable.innerHTML+tempHtml;
    }

}

//新建章节
function toNewFromPart(){
    var selectCurriculum=document.getElementById("selectCurriculum");

    var curriculumId = selectCurriculum.options[selectCurriculum.selectedIndex].value;
    var partId =document.getElementById("partId").value;
    var partName=document.getElementById("partName").value;
    var describeText = document.getElementById("describeText").value;

    var part={
        'curriculumId':curriculumId,
        'partId':partId,
        'partName':partName,
        'describeText':describeText
    };
    console.log(part);



    var formdata = new FormData();

    formdata.append("curriculumId", curriculumId);
    formdata.append("partId",partId );
    formdata.append("partName",partName );
    formdata.append("describeText",describeText );

    $.ajax({
        url: Page.Redirect.newPart,
        type: 'POST',
        data: formdata,
        // 告诉jQuery不要去处理发送的数据
        processData: false,
        // 告诉jQuery不要去设置Content-Type请求头
        contentType: false,
        async: false,
        success: function (data) {
            if (data=="yes") {
                console.log(data);
                addPartFile();
                alert("课件发布成功");
            }else{
                alert("课件发布失败");
            }
        }
    });

}

//新增章节课件
function addPartFile(){
    var curriculumId = selectCurriculum.options[selectCurriculum.selectedIndex].value;
    var partId =document.getElementById("partId").value;

    for (let x of partMap){
        var formdata = new FormData();
        formdata.append("curriculumId", curriculumId);
        formdata.append("partId",partId );
        formdata.append("file",x[1]);
        formdata.append("fileName",x[1].name);

        $.ajax({
            url: Page.Redirect.addPartFile,
            type: 'POST',
            data: formdata,
            // 告诉jQuery不要去处理发送的数据
            processData: false,
            // 告诉jQuery不要去设置Content-Type请求头
            contentType: false,
            async: false,
            success: function (data) {
                if (data=="yes") {
                    console.log(data);
                }else{
                }
            }
        });

    }
    partMap=new Map();
    loadingRefresh();
}

//载入章节列表模块
function getPartListTable(){
    $.ajax({
        url: Page.Redirect.getPartListTable,
        dataType: "html",
        type: "post",
        async: false,
        success: function (data) {
            console.log("与服务器连接成功，获取菜单Html成功。");

            var Html = document.getElementById("mainblock");
            Html.innerHTML = data;
            loadCurriculumListView();
        },
        error: function (XMLResponse) {
            console.log(XMLResponse.responseText);
            alert("与服务器连接失败");
        }
    });
}

//载入章节模块
function loadPartViewMain(curriculumId,PartId){
    $.ajax({
        url: Page.Redirect.getHtmlPartView,
        dataType: "html",
        type: "post",
        async: false,
        success: function (data) {
            console.log("与服务器连接成功，获取菜单Html成功。");

            var Html = document.getElementById("mainblock");
            Html.innerHTML = data;

            var CurriculumList = myCurriculumList;
            var Curriculum;
            for(var i=0;i<CurriculumList.length;i++){
                if(CurriculumList[i].curriculumId==curriculumId){
                    Curriculum=CurriculumList[i];
                }
            }
            var PartHtml="<h4 class=\"mb\"><i class=\"fa fa-angle-up\">"+Curriculum.curriculumName+"</i></h4>";
            for(var j in Curriculum.parts){
                if(Curriculum.parts[j].partId==PartId){
                    var fileUrlList=Curriculum.parts[j].fileUrlList;
                    for(var k in fileUrlList){
                        console.log(fileUrlList[k]);
                        PartHtml=PartHtml+"<iframe src=\""+fileUrlList[k]+"\"style=\"width:100%;height: 70em;\"></iframe>";
                    }
                }
            }
            document.getElementById("partPrint").innerHTML= document.getElementById("partPrint").innerHTML+PartHtml;
        },
        error: function (XMLResponse) {
            console.log(XMLResponse.responseText);
            alert("与服务器连接失败");
        }
    });
}

//获取“查看已发布章节”模块
//载入章节模块
function getHtmlManagePartList(){
    var htmlObject = document.getElementById("selectCurriculum");
    var curriculumId = htmlObject.options[htmlObject.selectedIndex].value;

    $.ajax({
        url: Page.Redirect.getHtmlManagePartList,
        dataType: "html",
        type: "post",
        async: false,
        success: function (data) {
            console.log("与服务器连接成功，获取菜单Html成功。");

            var Html = document.getElementById("mainblock");
            Html.innerHTML = data;



            loadHtmlManagePartList(curriculumId);
        },
        error: function (XMLResponse) {
            console.log(XMLResponse.responseText);
            alert("与服务器连接失败");
        }
    });
}

//载入“查看已发布章节”模块
function loadHtmlManagePartList(curriculumId){
    loadCurriculumListView();
 //   var CurriculumList=Page.Cookie.getCookieMyCurriculumList();
    var CurriculumList = myCurriculumList;
    var Curriculum;

    for(var i=0;i<CurriculumList.length;i++){
        if(CurriculumList[i].curriculumId==curriculumId){
            Curriculum=CurriculumList[i];
        }
    }
    document.getElementById("curriculumTitle").innerHTML=Curriculum.curriculumName;
    for(var i in Curriculum.parts){
        var tempHtml=
            "<tr onclick=\"loadPartViewMain("+Curriculum.curriculumId+","+Curriculum.parts[i].partId+")\">\n" +
            "<td>"+Curriculum.parts[i].partId+"</td>\n" +
            "<td>"+Curriculum.parts[i].themeText+"</td>\n" +
            "<td>"+Curriculum.parts[i].describeText+"</td>\n" +
            "</tr>";
        var curriculumListTable=document.getElementById("curriculumListTable");
        curriculumListTable.innerHTML=curriculumListTable.innerHTML+tempHtml;
    }
}