Page.Redirect = (function() {
	var objectifier = function(splits, create, context) {
		var result = context || window;
		for (var i = 0, s; result && (s = splits[i]); i++) {
			result = (s in result ? result[s] : (create ? result[s] = {} : undefined));
		}
		return result;
	};
	return {
		//属性 ---------------------------------------------------------------------------
		
		//登陆提交
		toLogin:Page.Value.urlRoot+"Sign/toLogin.action",
		
		//注册提交
		toRegister:Page.Value.urlRoot+"Sign/toRegister.action",
		
		//用户信息更新提交
		toFromPerson:Page.Value.urlRoot+"Major/toFromPerson.action",

		//师生院系班级信息更新提交
		toFromSchool:Page.Value.urlRoot+"Major/toFromSchool.action",

		//获取个人资料表单HTML模块
		goFromPerson:Page.Value.urlRoot+"GetHtmlPageMain/getHtmlPageFormPerson.action",

		//用于获取所有院系内的教师和班级的结构
		getSchoolStructure:Page.Value.urlRoot + "School/getSchool.action",

		//删除单元
		toDelUnit:Page.Value.urlRoot+"School/delUnit.action",

		//添加单元
		toAddUnit:Page.Value.urlRoot+"School/addUnit.action",

		//更新单元
		toUpdUnit:Page.Value.urlRoot+"School/updUnit.action",

		//获取管理员发布课程表单
		getFromManageCurriculum:Page.Value.urlRoot+"GetHtmlCurriculum/getFromManageCurriculum.action",

		//获取教师发布章节表单
		getFromManagePart:Page.Value.urlRoot+"GetHtmlCurriculum/getFromManagePart.action",

		//管理员添加课程:
		addCurriculum:Page.Value.urlRoot+"Curriculum/addCurriculum.action",

		//获取课程列表:
		getCurriculumList:Page.Value.urlRoot+"Curriculum/getCurriculumList.action",

		//获取课程预览模块HTML
		getCurriculumListView:Page.Value.urlRoot+"GetHtmlCurriculum/getHtmlCurriculumList.action",

		//教师新建课程章节
		newPart:Page.Value.urlRoot+"Curriculum/newPart.action",

		//新增课件
		addPartFile:Page.Value.urlRoot+"Curriculum/updPartFile.action",

		//获取章节列表页面Html
		getPartListTable:Page.Value.urlRoot+"GetHtmlCurriculum/getHtmlPartListTable.action",

		//获取章节模块html
		getHtmlPartView:Page.Value.urlRoot+"GetHtmlCurriculum/getHtmlPartView.action",

		//获取注册管理员模块Html
		getHtmlAddAdmin:Page.Value.urlRoot+"GetHtmlPageMain/getHtmlAddAdmin.action",

		//提交注册管理员
		signUpAdministrator:Page.Value.urlRoot+"Sign/signUpAdministrator.action",

		//获取管理章节界面
		getHtmlManagePartList:Page.Value.urlRoot+"GetHtmlCurriculum/getHtmlManagePartList.action",

		//属性 ---------------------------------------------------------------------------

		//方法 ---------------------------------------------------------------------------
		
		//去欢迎界面
		goWelcome: function() {
			var urlPath = Page.Value.urlRoot;
			window.open(urlPath);
		},

		//去主界面
		goMajor: function(data) {
			Page.Cookie.setCookieUser(data);
			var urlPath = Page.Value.urlRoot + "Major/goMajor.action";
			window.open(urlPath);
		}

		//方法 ---------------------------------------------------------------------------
	};
})();