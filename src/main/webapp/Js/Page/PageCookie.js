Page.Cookie = (function() {
	var objectifier = function(splits, create, context) {
		var result = context || window;
		for (var i = 0, s; result && (s = splits[i]); i++) {
			result = (s in result ? result[s] : (create ? result[s] = {} : undefined));
		}
		return result;
	};
	return {
		//属性 ---------------------------------------------------------------------------
		//属性 ---------------------------------------------------------------------------
		//方法 ---------------------------------------------------------------------------

		//清空Cookie
		claerCookie:function (){
			Page.Cookie.setCookieMyCurriculumList(null);
			Page.Cookie.setCookieSchool(null);
			Page.Cookie.setCookieUser(null);
		},

		//写入"myCurriculumList"对象
		setCookieMyCurriculumList: function(myCurriculumList) {
			Page.Cookie.setCookie("AplpMyCurriculumList", myCurriculumList);
			console.log("myCurriculumList对象成功写入Cookie");
		},

		//读取"myCurriculumList"对象
		getCookieMyCurriculumList: function() {
			return Page.Cookie.getCookie("AplpMyCurriculumList");
		},

		//写入"pagetime"对象
		setCookiePageTime: function() {
			var pagetime = {
				'lastrefreshtime': Page.Value.nowTime()
			};
			Page.Cookie.setCookie("AplpPagetime", pagetime);
		},

		//读取"pagetime"对象
		getCookiePageTime: function() {
			return Page.Cookie.getCookie("AplpPagetime");
		},

		//写入'school'对象
		setCookieSchool: function(data) {
			Page.Cookie.setCookie("AplpSchool", data);
			console.log("schoolJson对象成功写入Cookie");
		},

		//获取'school'对象
		getCookieSchool: function() {
			return Page.Cookie.getCookie("AplpSchool");
		},

		//写入"user"对象
		setCookieUser: function(data) {
		//	$.cookie("AplpUser",data)
			Page.Cookie.setCookie("AplpUser", data);
		},

		//获取"user"对象
		getCookieUser: function() {
			return Page.Cookie.getCookie("AplpUser");
		},

		//读cookie
		getCookie: function(k) {
			return JSON.parse($.cookie(k));
		},

		//写cookie
		setCookie: function(k, v) {
			console.log(v)
			$.cookie(k, JSON.stringify(v), { expires: 7, path: '/Aplp/' });
		}

		//方法 ---------------------------------------------------------------------------
	};

})();