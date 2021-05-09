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
		
	if (Page.Value.nowTime() - lastrefreshtime > 1) {
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
