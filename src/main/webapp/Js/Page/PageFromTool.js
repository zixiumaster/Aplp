Page.FromTool = (function() {
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

		//检测邮箱格式
		checkEmail: function(str) {
			var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
			if (re.test(str)) {
				return true;
			} else {
				return false;
			}
		},

		//检测手机号码格式
		checkMobile: function(str) {
			var re = /^1\d{10}$/
			if (re.test(str)) {
				return true;
			} else {
				return false;
			}
		},

		//检测id类型
		checkId:function(str){
			if (Page.FromTool.checkEmail(str)) {
				return "email"
			} else if (Page.FromTool.checkMobile(str)) {
				return "phone";
			}else{
				return "id";
			}
		},

		//检查确认密码
		checkPassword: function(pwd, checkPwd) {
			// 校验密码：只能输入8-20个字母、数字、下划线
			function isPasswd(pwd) {
				var patrn = /^(\w){8,20}$/;
				if (!patrn.exec(pwd)) return false
				return true
			}

			if (pwd == checkPwd) {
				if (isPasswd(pwd)) {
					return true;
				} else {
					return false;
				}

			} else {
				return false;
			}

		}

		//方法 ---------------------------------------------------------------------------
	};

})();
