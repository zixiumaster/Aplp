$.ajax({
	url: "login.action",
	type: "POST",
	/* data : "json", */
	contentType: "application/json;charset=utf-8",
	//向后端传输的数据
	data: JSON.stringify({
		username: $("#username").val(),
		password: $("#password").val(),
	}),
	//处理后端返回的数据
	
	
	
	
	success: function(result) {
		//将得到的前台数据转换为json
		/*var message = JSON.stringify(result);*/
		alert("接受到的数据是：" + result); //输出默认的json字符串
		if (result != null && result != "") {
			var message = eval("(" + result + ")"); //万能转换，拿到对象      
			//alert("接受到的数据是：" + message.username);	
			var username = message.username;
			var password = message.password;
			//在前台做验证
			if (username != null && username != "" &&
				password != null &&
				password != "") {
				alert("用户登录成功");
				window.location.href = "findUser.action";
			} else {
				alert("用户登录失败");
			}
		} else {
			alert("用户登录失败");
		}
		//alert("接受到的数据是：" + message);
	},
	//处理失败返回的数据
	error: function(result) {
		alert("用户登录失败");
	}
});
