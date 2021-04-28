//验证码的值
var VerificationCode;

//登录提交
function toLogin() {
	var idText = document.getElementById("id").value;
	var pwdText = document.getElementById("pwd").value;
	var type = document.getElementById("type").value;
	var idType = "id";
	//先检查验证码
	if (!checkVerificationCode()) {

	}else if(idText=="" || idText==null){
		alert("ID不可为空");

		//检查确认密码
	}else{
		function getSign() {

			//判断ID类型
			if (checkEmail(idText)) {
				idType = "email";
			} else if (checkMobile(idText)) {
				idType = "phone";
			}

			var ret = new Object();

			ret.role=type;
			ret.basis = idType;
			ret.id = idText;
			ret.password = pwdText;
			return JSON.stringify(ret);
		}

		var urlPath=urlRoot+"Sign/toLogin.action";
		$.ajax({
			url: urlPath,
			contentType: "application/json",
			data: getSign(),
			dataType: "JSON",
			type: "POST",
			success: function(data) {
				if(data!=null){
					alert("登录成功，正在跳转");

					//登录成功后，把用户信息写入到cookie里面
					setCookieUser(type,idType,idText);
					goMajor();
				}else{
					alert("登陆失败");
					goLogin();
				}
			},
			error: function(XMLResponse) {
				console.log(XMLResponse.responseText);
			}
		});
	}

}

//注册提交
function toRegister() {
	var idText = document.getElementById("id").value;
	var pwdText = document.getElementById("pwd").value;
	var type = document.getElementById("type").value;
	var idType = "id";

	//检查ID空值
	if(idText=="" || idText==null){
		alert("ID不可为空");

		//检查确认密码
	}else if (checkPassword()) {
		function getSign() {
			if (checkEmail(idText)) {
				idType = "email";
			} else if (checkMobile(idText)) {
				idType = "phone";
			}

			var ret = new Object();
			ret.role=type;
			ret.basis = idType;
			ret.id = idText;
			ret.password = pwdText;
			return JSON.stringify(ret);
		}
		var urlPath=urlRoot+"Sign/toRegister.action";
		$.ajax({
			url:urlPath,
			contentType: "application/json",
			data: getSign(),
			dataType: "text",
			type: "POST",
			success: function(data) {
				if(data=="yes"){
					alert("注册成功，将跳转到登陆页面");
					goLogin();
				}else{
					alert("注册失败，请检查注册信息，有可能是ID/手机号/邮箱重复注册等原因");
					goRegister();
				}
			},
			error: function(XMLResponse) {
				console.log(XMLResponse.responseText);
			}
		});
	}
}

//跳转到登录界面
function goLogin() {
	var urlPath=urlRoot+"Sign/goLogin.action";
	$.ajax({
		url: urlPath,
		contentType: "text",
		dataType: "html",
		type: "post",
		success: function(data) {
			console.log("与服务器连接成功，获取页面成功。");
			var s = document.getElementById("main");
			s.innerHTML = data;
			verificationCodeChange();
		},
		error: function(XMLResponse) {
			console.log(XMLResponse.responseText);
			alert("与服务器连接失败");
		}
	});

}

//跳转到注册页面
function goRegister() {
	var urlPath=urlRoot+"Sign/goRegister.action";
	$.ajax({
		url: urlPath,
		contentType: "text",
		dataType: "html",
		type: "post",
		success: function(data) {
			console.log("与服务器连接成功，获取页面成功。");
			var s = document.getElementById("main");
			s.innerHTML = data;
		},
		error: function(XMLResponse) {
			//console.log(XMLResponse.responseText);
			alert("与服务器连接失败");
		}
	});
}


//检查确认密码
function checkPassword() {
	var pwdText = document.getElementById("pwd").value;
	var checkpwdText = document.getElementById("checkpwd").value;

	// 校验密码：只能输入8-20个字母、数字、下划线
	function isPasswd(s) {
		var patrn = /^(\w){8,20}$/;
		if (!patrn.exec(s)) return false
		return true
	}

	if (pwdText == checkpwdText) {
		if(isPasswd(pwdText)){
			return true;
		}else{
			alert("密码不符合规范，密码只能由8-20个字母、数字、下划线组成");
			return false;
		}

	} else {
		alert("密码与确认密码不一致");
		return false;
	}

}


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

//检测验证码
function checkVerificationCode() {
	//获取验证码的值
	var vCBtnText = VerificationCode;

	//获取验证码输入框的值
	var vCInput = document.getElementById("vc");

	//判断验证码是否输入正确
	if (vCBtnText.toLowerCase() == vCInput.value.toLowerCase()) {




		//验证码输入框清空
		vCInput.value = "";
		//改变验证码
		verificationCodeChange();
		return true;
	} else {
		vCInput.value = "";
		verificationCodeChange();
		alert("验证码输入错误");
		return false;
	}
}
//验证码
function verificationCodeChange() {
	code = $("#code");
	// 验证码组成库
	var arrays = new Array(
		'1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
		'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
		'u', 'v', 'w', 'x', 'y', 'z',
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
		'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
		'U', 'V', 'W', 'X', 'Y', 'Z'
	);
	codes = ''; // 重新初始化验证码
	for (var i = 0; i < 4; i++) {
		// 随机获取一个数组的下标
		var r = parseInt(Math.random() * arrays.length);
		codes += arrays[r];
	}
	//把验证码的值赋给变量VerificationCode
	VerificationCode = codes;

	// 验证码添加到input里
	code.val(codes);
}
