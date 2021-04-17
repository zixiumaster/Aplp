<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>login</title>
		<meta name="viewport" content="width=device-width, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
		<script type="text/javascript" src="Js/Public/jquery.min.js"></script>
		<script type="text/javascript" src="Js/Public/three.min.js"></script>
		<script type="text/javascript" src="Js/Effect/EffectParticleJump.js"></script>
		<script type="text/javascript" src="Js/Login/Login_01.js"></script>
		<link rel="stylesheet" type="text/css" href="Css/Login/Login_01.css" />
	</head>
	<body style="">
		<div class="main">
			<div class="login">
				<div class="log-con">
					<span>Login</span>
					<input type="text" id="id" class="name"  placeholder="ID/Phone/Email">
					<input type="text" id="pwd" class="password" placeholder="PassWord">
					<input type="text" id="vc" class="code" placeholder="Verification Code">
					<input type="button" id="code" onclick="change();">
					<a onclick="loginOnclick();">Login</a>
				</div>
			</div>
		</div>
	</body>
</html>