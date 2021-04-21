//验证码的值
var VerificationCode;


//登录提交
function toLogin(){
	//先检查验证码
	if(checkVerificationCode()){
		//获取文本信息并制作出Json
		function getLoginSign() {
			var idText = document.getElementById("id").value;
			var pwdText = document.getElementById("pwd").value;
			var idType = "id";
			if (checkEmail(idText)) {
				idType = "Email";
			} else if (checkMobile(idText)) {
				idType = "phone";
			}
			var ret = new Object();
			ret.basis = idType;
			ret.value = idText;
			ret.password = pwdText;
			return JSON.stringify(ret);
		}
		$.ajax({
			url: "http://localhost:8080/Aplp_war/Login/test_01.action",
			contentType: "application/json",
			data: getText(),
			//dataType: "text",
			dataType: "json",
			type: "POST",
			success: function(a) {
				console.log(a.password);
			},
			error: function(XMLResponse) {
				console.log(XMLResponse.responseText);
			}
		});
	}
}

//注册提交
function toRegister(){
	//先检查确认密码
	if(checkPassword()){
		
	}
}

//跳转到登录界面
function goLogin() {
	$.ajax({
		url: "http://localhost:8080/Aplp_war/Sign/goLogin.action",
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

//跳转到注册页面
function goRegister() {
	$.ajax({
		url: "http://localhost:8080/Aplp_war/Sign/goRegister.action",
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
	if (pwdText == checkpwdText) {
		alert("sssssssssss");
		return true;
	} else {
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
		verificationCodeChange()
		alert("验证码输入正确");
		return true;
	} else {
		vCInput.value = "";
		change();
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
