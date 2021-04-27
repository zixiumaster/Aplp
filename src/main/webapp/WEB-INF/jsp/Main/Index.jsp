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
    <title>dome</title>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>


    <script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.min.js"></script>
    <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" />


    <link rel="stylesheet" type="text/css" href="Css/Main/Main_01.css"/>

    <script class="include" type="text/javascript" src="Js/Main/Main_01.js"></script>
    <script class="include" type="text/javascript" src="Js/Main/Main_01.js"></script>

    <script class="include" type="text/javascript" src="Js/Main/jquery.nicescroll.js"></script>

    <script class="include" type="text/javascript" src="Js/Main/jquery.sparkline.js"></script>


</head>
<body>

<!-- 页面 -->
<section id="container" class="">

    <!-- 导航栏 -->
    <header class="header black-bg">

        <!-- 菜单栏开关 -->
        <div class="sidebar-toggle-box">
            <div class=" fa fa-bars tooltips">
                我是Icon
            </div>
        </div>
        <!-- 菜单栏开关 -->

        <!-- LOGO -->
        <a href="#" class="logo">
            <b class="fa fa-bars tooltips">
                APLP
            </b>
        </a>
        <!-- LOGO -->

        <!-- 导航栏菜单 -->
        <div class="nav notify-row" id="top_menu">
            <ul class="nav top-menu">

                <!-- 进度框 -->
                <li class="dropdown">

                    <!-- Icon和上角标 -->
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <i class="fa fa-tasks">
                            此处是进度条Icon
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
                            <a href="#">
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
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <i class="fa fa-envelope-o">
                            此处是邮件Icon
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
                            <a href="#">

                                <!-- 发消息人头像 -->
                                <span class="photo">
											<span>我是logo</span>
                                    <!-- <img alt="avatar" src="../../Img/agentLogo.png"> -->
										</span>
                                <!-- 发消息人头像 -->

                                <!-- 发消息人和时间 -->
                                <span class="subject">
											<span class="from">我是用户名</span>
											<span class="time">我是时间</span>
										</span>
                                <!-- 发消息人和时间 -->

                                <!-- 消息内容 -->
                                <span class="message">
											Test
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
                    <a class="logout" href="#">
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
                    <a href="#">
                        <span>我是logo</span>
                        <!-- <img src="../../Img/agentLogo.png" class="img-circle" width="60"> -->
                    </a>
                </p>
                <!-- 登录人头像 -->

                <!-- 登录人用户名 -->
                <h5 class="centered">
                    我是用户名
                </h5>
                <!-- 登录人用户名 -->

                <!-- 首页按钮 -->
                <li class="mt">

                    <!-- 按钮标题 -->
                    <a class="active" href="#" style="font-size:1.5em;">
                        <span>首页</span>
                    </a>
                    <!-- 按钮标题 -->

                </li>
                <!-- 首页按钮 -->

                <!-- 个人资料子菜单 -->
                <li class="sub-menu dcjq-parent-li">
                    <!-- 按钮标题 -->
                    <a href="javascript:;" class="dcjq-parent" style="font-size:1.5em;">
								<span>
									个人资料
								</span>
                    </a>
                    <!-- 按钮标题 -->

                    <!-- 菜单子项 -->
                    <ul class="sub" style="display: none;">
                        <li>
                            <a href="#" style="font-size:1.2em;">基本信息</a>
                        </li>
                        <li>
                            <a href="#" style="font-size:1.2em;">班级信息</a>
                        </li>
                        <li>
                            <a href="#" style="font-size:1.2em;">任课信息</a>
                        </li>
                    </ul>
                    <!-- 菜单子项 -->

                </li>
                <!-- 个人资料子菜单 -->


            </ul>
        </div>
    </aside>
    <!-- 菜单栏 -->



</section>
<!-- 页面 -->

<!-- 加载滚动条 -->
<script class="include" type="text/javascript" src="Js/Main/Main_02.js"></script>
<!-- 加载滚动条 -->

</body>
</html>