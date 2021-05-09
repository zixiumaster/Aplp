<%--
  Created by IntelliJ IDEA.
  User: zixiu
  Date: 2021/4/27
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- saved from url=(0072)http://demo.kangjingept.com:8020/cssthemes4/bkt_1_dashgumfree/index.html -->
<html lang="en" style="overflow: hidden;">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="Dashboard">
		<meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
		<title>Aplp</title>
		<base
			href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
		<script src="https://cdn.staticfile.org/jquery/3.4.0/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.min.js"></script>
		<script class="include" type="text/javascript" src="Js/Main/jquery.nicescroll.js"></script>
		<script class="include" type="text/javascript" src="Js/Main/jquery.sparkline.js"></script>
		<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" />

		<script class="include" type="text/javascript" src="Js/Main/Main_01.js"></script>
		<link rel="stylesheet" type="text/css" href="Css/Main/Main_01.css" />
		<link rel="stylesheet" type="text/css" href="Css/Main/Main_02.css" />

		<script type="text/javascript" src="Js/Page/PageObject.js"></script>
		<script type="text/javascript" src="Js/Page/PageValue.js"></script>
		<script type="text/javascript" src="Js/Page/PageFromTool.js"></script>
		<script type="text/javascript" src="Js/Page/PageRedirect.js"></script>
		<script type="text/javascript" src="Js/Page/PageCookie.js"></script>

		<script class="include" type="text/javascript" src="Js/Main/MainFun/MainFunAjax.js"></script>
		<script class="include" type="text/javascript" src="Js/Main/MainFun/MainFunAjaxFrom.js"></script>
	</head>
	<body>

		<!-- 页面 -->
		<section id="container" class="">

			<!-- 导航栏 -->
			<header class="header black-bg">

				<!-- 菜单栏开关 -->
				<div class="sidebar-toggle-box">
					<div class=" fa fa-bars tooltips">
						<div
							style="width:2.4em;height: 2.3em;background: url(Img/Page/Icon_01.png) -330px -95px ;zoom: 0.8;">
						</div>
					</div>
				</div>
				<!-- 菜单栏开关 -->

				<!-- LOGO -->
				<a class="logo">
					<b class="fa fa-bars tooltips">
						<img src="Img/Page/logo.png" id="PageLogo" style="width: 2em;margin-top: 0.1em;" />
					</b>
				</a>
				<!-- LOGO -->

				<!-- 导航栏菜单 -->
				<div class="nav notify-row" id="top_menu">
					<ul class="nav top-menu">

						<!-- 进度框 -->
						<li class="dropdown">

							<!-- Icon和上角标 -->
							<a data-toggle="dropdown" class="dropdown-toggle">
								<i class="fa fa-tasks">
									<div
										style="width:2.4em;height: 2.3em;background: url(Img/Page/Icon_01.png) -170px -310px ;-webkit-transform:rotate(90deg);zoom: 0.7;">
									</div>
								</i>
								<span class="badge bg-theme">
									1
								</span>
							</a>
							<!-- Icon和上角标 -->

							<!-- 进度条主栏目 -->
							<ul class="dropdown-menu extended tasks-bar">
								<!-- 栏目标题 -->
								<li>
									<p class="green">
										你有 1 条任务进度
									</p>
								</li>
								<!-- 栏目标题 -->

								<!-- 进度条信息框 -->
								<li>
									<a>
										<!-- 文字说明 -->
										<div class="task-info">
											<div class="desc">title</div>
											<div class="percent">50%</div>
										</div>
										<!-- 文字说明 -->

										<!-- 进度条图样 -->
										<div class="progress progress-striped">
											<div class="progress-bar progress-bar-success" style="width: 50%"></div>
										</div>
										<!-- 进度条图样 -->

									</a>
								</li>
								<!-- 进度条信息框 -->

							</ul>
							<!-- 进度条主栏目 -->

						</li>
						<!-- 进度框 -->

						<!-- 消息框 -->
						<li id="header_inbox_bar" class="dropdown">

							<!-- Icon和上角标 -->
							<a data-toggle="dropdown" class="dropdown-toggle">
								<i class="fa fa-envelope-o">
									<div
										style="width:2.4em;height: 2.3em;background: url(Img/Page/Icon_01.png) -22px -435px ;zoom: 0.7;">

									</div>
								</i>
								<span class="badge bg-theme">
									1
								</span>
							</a>
							<!-- Icon和上角标 -->

							<!-- 栏目主体 -->
							<ul class="dropdown-menu extended inbox">
								<!-- 栏目标题 -->
								<div class="notify-arrow notify-arrow-green"></div>
								<li>
									<p class="green">你有一条新消息</p>
								</li>
								<!-- 栏目标题 -->

								<!-- 消息框 -->
								<li>
									<a>

										<!-- 发消息人头像 -->
										<span class="photo">
											<img alt="avatar" src="Img/User/IconUserDefault.png">
										</span>
										<!-- 发消息人头像 -->

										<!-- 发消息人和时间 -->
										<span class="subject">
											<span class="from">UserName</span>
											<span class="time">2021.01.01</span>
										</span>
										<!-- 发消息人和时间 -->

										<!-- 消息内容 -->
										<span class="message">
											TestText TestText TestText TestText
										</span>
										<!-- 消息内容 -->
									</a>
								</li>
								<!-- 消息框 -->

								<!-- 底部按钮 -->
								<li>
									<a href="#">查看全部消息</a>
								</li>
								<!-- 底部按钮 -->

							</ul>
							<!-- 栏目主体 -->

						</li>
						<!-- 消息框 -->

					</ul>
				</div>
				<!-- 导航栏菜单 -->

				<!-- 登出键 -->
				<div class="top-menu">
					<ul class="nav pull-right top-menu">
						<li>
							<a class="logout" href="" onclick="Page.Redirect.goWelcome();">
								Logout
							</a>
						</li>
					</ul>
				</div>
				<!-- 登出键 -->

			</header>
			<!-- 导航栏 -->


			<!-- 菜单栏 -->
			<aside>
				<div id="sidebar" class="nav-collapse " tabindex="5000" style="overflow: hidden; outline: none;">
					<ul class="sidebar-menu" id="nav-accordion" style="display: block;">

						<!-- 登录人头像 -->
						<p class="centered">
							<a id="PageUserPhoto">
								<img alt="avatar" src="Img/User/IconUserDefault.png">
							</a>
						</p>
						<!-- 登录人头像 -->

						<!-- 登录人用户名 -->
						<h5 class="centered" id="pageUser">
							UserName
						</h5>
						<!-- 登录人用户名 -->

						<!-- 首页按钮 -->
						<li class="mt">

							<!-- 按钮标题 -->
							<a class="active" href="" onclick="Page.Redirect.goMajor();" style="font-size:1.5em;">
								<span>首页</span>
							</a>
							<!-- 按钮标题 -->

						</li>
						<!-- 首页按钮 -->





					</ul>
				</div>
			</aside>
			<!-- 菜单栏 -->

			<section id="main-content">
				<section class="wrapper" id="mainblock">

				</section>
			</section>


		</section>
		<!-- 页面 -->

		<%--加载页面，注入信息--%>
		<script>
			loadCookieUser();
			loadToolMenu(Page.Cookie.getCookieUser().role);
			loadingRefresh();
		</script>
		<%--加载页面，注入信息--%>


		<!-- 加载滚动条 and 菜单展开功能 -->
		<script class="include" type="text/javascript" src="Js/Main/Main_02.js"></script>
		<!-- 加载滚动条 -->
	</body>
</html>
