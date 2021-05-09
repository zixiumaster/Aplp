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

		//写入"pagetime"对象
		setCookiePageTime: function() {
			var pagetime = {
				'lastrefreshtime': Page.Value.nowTime()
			}
			Page.Cookie.setCookie('pagetime', pagetime);
		},

		//读取"pagetime"对象
		getCookiePageTime: function() {
			return Page.Cookie.getCookie("pagetime");
		},

		//写入"user"对象
		setCookieUser: function(data) {
			Page.Cookie.setCookie('user', data);
		},

		//获取"user"对象
		getCookieUser: function() {
			return Page.Cookie.getCookie('user');
		},

		//读cookie
		getCookie: function(k) {
			return JSON.parse($.cookie(k));
		},

		//写cookie
		setCookie: function(k, v) {
			$.cookie(k, JSON.stringify(v));
		}

		//方法 ---------------------------------------------------------------------------
	};

})();
