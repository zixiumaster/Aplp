//检测邮箱格式 
//调用格式：checkEmail("contact@cnblogs.com");
function checkEmail(str) {
	var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
	if (re.test(str)) {
		return true;
	} else {
		return false;
	}
}

//检测手机号码格式 
//调用格式 checkMobile('13800138000');
function checkMobile(str) {
	var re = /^1\d{10}$/
	if (re.test(str)) {
		return true;
	} else {
		return false;
	}
}