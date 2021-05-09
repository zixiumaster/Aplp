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
		
		//获取个人资料表单HTML模块
		goFromPerson:Page.Value.urlRoot+"GetHtmlPageMain/getHtmlPageFormPerson.action",
		
		
		
		//属性 ---------------------------------------------------------------------------

		//方法 ---------------------------------------------------------------------------
		
		//去欢迎界面
		goWelcome: function() {
			var urlPath = Page.Value.urlRoot;
			window.open(urlRoot);
		},

		//去主界面
		goMajor: function() {
			var urlPath = Page.Value.urlRoot + "Major/goMajor.action";
			window.open(urlPath);
		}

		//方法 ---------------------------------------------------------------------------
	};
})();