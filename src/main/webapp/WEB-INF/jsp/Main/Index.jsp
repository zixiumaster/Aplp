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

		<script class="include" type="text/javascript" src="Js/Main/MainInclude/jquery.nicescroll.js"></script>
		<script class="include" type="text/javascript" src="Js/Main/MainInclude/jquery.sparkline.js"></script>

		<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" />

		<script class="include" type="text/javascript" src="Js/Main/MainInclude/Main_01.js"></script>
		<link rel="stylesheet" type="text/css" href="Css/Main/Main_01.css" />
		<link rel="stylesheet" type="text/css" href="Css/Main/Main_02.css" />

		<script type="text/javascript" src="Js/Page/PageObject.js"></script>
		<script type="text/javascript" src="Js/Page/PageValue.js"></script>
		<script type="text/javascript" src="Js/Page/PageFromTool.js"></script>
		<script type="text/javascript" src="Js/Page/PageRedirect.js"></script>
		<script type="text/javascript" src="Js/Page/PageCookie.js"></script>
		<script class="include" type="text/javascript" src="Js/Main/MainFun/MainFunAjax.js"></script>
		<script class="include" type="text/javascript" src="Js/Main/MainFun/MainFunAjaxFrom.js"></script>
		<script class="include" type="text/javascript" src="Js/Main/MainFun/FromManageSchool.js"></script>
		<script class="include" type="text/javascript" src="Js/Main/CurriculumFun/CurriculumFun_01.js"></script>



	</head>
	<body>

		<!-- ?????? -->
		<section id="container" class="">

			<!-- ????????? -->
			<header class="header black-bg">

				<!-- ??????????????? -->
				<div class="sidebar-toggle-box">
					<div class=" fa fa-bars tooltips">
						<div
							style="width:2.4em;height: 2.3em;background: url(Img/Page/Icon_01.png) -330px -95px ;zoom: 0.8;">
						</div>
					</div>
				</div>
				<!-- ??????????????? -->

				<!-- LOGO -->
				<a class="logo">
					<b class="fa fa-bars tooltips">
						<img src="Img/Page/logo.png" id="PageLogo" style="width: 2em;margin-top: 0.1em;" />
					</b>
				</a>
				<!-- LOGO -->


<%--				<!-- ??????????????? -->--%>
<%--				<div class="nav notify-row" id="top_menu">--%>
<%--					<ul class="nav top-menu">--%>

<%--						<!-- ????????? -->--%>
<%--						<li class="dropdown">--%>

<%--							<!-- Icon???????????? -->--%>
<%--							<a data-toggle="dropdown" class="dropdown-toggle">--%>
<%--								<i class="fa fa-tasks">--%>
<%--									<div--%>
<%--										style="width:2.4em;height: 2.3em;background: url(Img/Page/Icon_01.png) -170px -310px ;-webkit-transform:rotate(90deg);zoom: 0.7;">--%>
<%--									</div>--%>
<%--								</i>--%>
<%--								<span class="badge bg-theme">--%>
<%--									1--%>
<%--								</span>--%>
<%--							</a>--%>
<%--							<!-- Icon???????????? -->--%>

<%--							<!-- ?????????????????? -->--%>
<%--							<ul class="dropdown-menu extended tasks-bar">--%>
<%--								<!-- ???????????? -->--%>
<%--								<li>--%>
<%--									<p class="green">--%>
<%--										?????? 1 ???????????????--%>
<%--									</p>--%>
<%--								</li>--%>
<%--								<!-- ???????????? -->--%>

<%--								<!-- ?????????????????? -->--%>
<%--								<li>--%>
<%--									<a>--%>
<%--										<!-- ???????????? -->--%>
<%--										<div class="task-info">--%>
<%--											<div class="desc">title</div>--%>
<%--											<div class="percent">50%</div>--%>
<%--										</div>--%>
<%--										<!-- ???????????? -->--%>

<%--										<!-- ??????????????? -->--%>
<%--										<div class="progress progress-striped">--%>
<%--											<div class="progress-bar progress-bar-success" style="width: 50%"></div>--%>
<%--										</div>--%>
<%--										<!-- ??????????????? -->--%>

<%--									</a>--%>
<%--								</li>--%>
<%--								<!-- ?????????????????? -->--%>

<%--							</ul>--%>
<%--							<!-- ?????????????????? -->--%>

<%--						</li>--%>
<%--						<!-- ????????? -->--%>

<%--						<!-- ????????? -->--%>
<%--						<li id="header_inbox_bar" class="dropdown">--%>

<%--							<!-- Icon???????????? -->--%>
<%--							<a data-toggle="dropdown" class="dropdown-toggle">--%>
<%--								<i class="fa fa-envelope-o">--%>
<%--									<div--%>
<%--										style="width:2.4em;height: 2.3em;background: url(Img/Page/Icon_01.png) -22px -435px ;zoom: 0.7;">--%>

<%--									</div>--%>
<%--								</i>--%>
<%--								<span class="badge bg-theme">--%>
<%--									1--%>
<%--								</span>--%>
<%--							</a>--%>
<%--							<!-- Icon???????????? -->--%>

<%--							<!-- ???????????? -->--%>
<%--							<ul class="dropdown-menu extended inbox">--%>
<%--								<!-- ???????????? -->--%>
<%--								<div class="notify-arrow notify-arrow-green"></div>--%>
<%--								<li>--%>
<%--									<p class="green">?????????????????????</p>--%>
<%--								</li>--%>
<%--								<!-- ???????????? -->--%>

<%--								<!-- ????????? -->--%>
<%--								<li>--%>
<%--									<a>--%>

<%--										<!-- ?????????????????? -->--%>
<%--										<span class="photo">--%>
<%--											<img alt="avatar" src="Img/User/IconUserDefault.png">--%>
<%--										</span>--%>
<%--										<!-- ?????????????????? -->--%>

<%--										<!-- ????????????????????? -->--%>
<%--										<span class="subject">--%>
<%--											<span class="from">UserName</span>--%>
<%--											<span class="time">2021.01.01</span>--%>
<%--										</span>--%>
<%--										<!-- ????????????????????? -->--%>

<%--										<!-- ???????????? -->--%>
<%--										<span class="message">--%>
<%--											TestText TestText TestText TestText--%>
<%--										</span>--%>
<%--										<!-- ???????????? -->--%>
<%--									</a>--%>
<%--								</li>--%>
<%--								<!-- ????????? -->--%>

<%--								<!-- ???????????? -->--%>
<%--								<li>--%>
<%--									<a href="#">??????????????????</a>--%>
<%--								</li>--%>
<%--								<!-- ???????????? -->--%>

<%--							</ul>--%>
<%--							<!-- ???????????? -->--%>

<%--						</li>--%>
<%--						<!-- ????????? -->--%>

<%--					</ul>--%>
<%--				</div>--%>
<%--				<!-- ??????????????? -->--%>

				<!-- ????????? -->
				<div class="top-menu">
					<ul class="nav pull-right top-menu">
						<li>
							<a class="logout" href="" onclick="Page.Cookie.claerCookie();Page.Redirect.goWelcome();">
								Logout
							</a>
						</li>
					</ul>
				</div>
				<!-- ????????? -->

			</header>
			<!-- ????????? -->

			<!-- ????????? -->
			<aside>
				<div id="sidebar" class="nav-collapse " tabindex="5000" style="overflow: hidden; outline: none;">
					<ul class="sidebar-menu" id="nav-accordion" style="display: block;">

						<!-- ??????????????? -->
						<p class="centered">
							<a id="PageUserPhoto">
								<img alt="avatar" src="Img/User/IconUserDefault.png">
							</a>
						</p>
						<!-- ??????????????? -->

						<!-- ?????????????????? -->
						<h5 class="centered" id="pageUser">
							UserName
						</h5>
						<!-- ?????????????????? -->

						<!-- ???????????? -->
						<li class="mt">

							<!-- ???????????? -->
							<a class="active" href="" onclick="Page.Redirect.goMajor();" style="font-size:1.5em;">
								<span>??????</span>
							</a>
							<!-- ???????????? -->

						</li>
						<!-- ???????????? -->
					</ul>
				</div>
			</aside>
			<!-- ????????? -->

			<section id="main-content">
				<section class="wrapper" id="mainblock">
					<center>
						<h1 style="margin-top: 10em;">????????????????????????????????????????????????</h1>
					</center>
					<center>
						<h2>Welcome to the learning platform of assembly language programming</h2>
					</center>
				</section>
			</section>


		</section>
		<!-- ?????? -->

		<%--???????????????????????????--%>
		<script>
			getSchoolStructure();
			loadCurriculumListView();
			loadCookieUser();
			loadToolMenu(Page.Cookie.getCookieUser().role);
			loadingRefresh();
			getSchoolStructure();
		</script>
		<%--???????????????????????????--%>


		<!-- ??????????????? and ?????????????????? -->
		<script class="include" type="text/javascript" src="Js/Main/MainInclude/Main_02.js"></script>
		<!-- ??????????????? -->
	</body>
</html>
