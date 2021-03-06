//将yoghurt信息载入界面
function loadCookieUser() {
	var user = Page.Cookie.getCookieUser();

	//修改页面的用户名
	var UserName = document.getElementById("pageUser");


	userNameText = user.basis + "  :  " + getValue(user, user.basis);


	UserName.innerHTML = userNameText
	var UserPhoto = document.getElementById("PageUserPhoto");

	//修改页面的头像
	var UserPhotoimgpath = "<img alt=\"avatar\" src=\"Img/User/IconUser" + user.role + ".png\">";
	UserPhoto.innerHTML = UserPhotoimgpath;
}

//载入左侧工具栏
function loadToolMenu(role) {
	var urlPath = Page.Value.urlRoot + "GetHtmlPageMain/getHtmlPageMainMenu.action";
	$.ajax({
		url: urlPath,
		contentType: "application/json",
		data: JSON.stringify({
			'role': role
		}),
		dataType: "html",
		type: "post",
		success: function(data) {
			console.log("与服务器连接成功，获取菜单Html成功。");
			var menuHtml = document.getElementById("nav-accordion");
			menuHtml.innerHTML = menuHtml.innerHTML + data;
		},
		error: function(XMLResponse) {
			console.log(XMLResponse.responseText);
			alert("与服务器连接失败");
		}
	});
}

//刷新一次
function loadingRefresh() {

	var lastrefreshtime = Page.Cookie.getCookiePageTime().lastrefreshtime;
		
	if (Page.Value.nowTime() - lastrefreshtime > 1 && Page.Value.nowTime() - lastrefreshtime < 5) {
		Page.Cookie.setCookiePageTime();
		location.reload();
	}
	
}

//根据jsn的key获取value
function getValue(jsonObj, key) {
	for (var item in jsonObj) {
		if (item == key) {
			return jsonObj[item];
		}
	}

}

//载入“注册管理员”界面模块
function loadRegAdmin(){
	$.ajax({
		url: Page.Redirect.getHtmlAddAdmin,
		dataType: "html",
		type: "post",
		success: function (data) {
			var Html = document.getElementById("mainblock");
			Html.innerHTML = data;
		},
		error: function (XMLResponse) {
			console.log(XMLResponse.responseText);
			alert("与服务器连接失败");
		}
	});
}

//提交注册管理员
function toAddAmin(){
	var role="Administrator";
	var newID = document.getElementById("addId").value;
	var addPwd = document.getElementById("addPassword").value;
	var addCheckPwd = document.getElementById("addCheckpassword").value;
	var type=Page.FromTool.checkId(newID);

	var sign={
		"role":role,
		"basis":type,
		"id":newID,
		"password":addPwd
	}

	if(newID=="" || newID==null){
		alert("ID不可为空");

	}else if(Page.FromTool.checkPassword(addPwd,addCheckPwd)){
		$.ajax({
			url:Page.Redirect.signUpAdministrator,
			contentType: "application/json",
			data: JSON.stringify(sign),
			dataType: "text",
			type: "POST",
			success: function(data) {
				if(data=="yes"){
					alert("注册成功，将跳转到登陆页面");
				}else{
					alert("注册失败，请检查注册信息，有可能是ID/手机号/邮箱重复注册等原因");
				}
			},
			error: function(XMLResponse) {
				console.log(XMLResponse.responseText);
			}
		});
	}else{
		alert("密码不合规");
	}

}