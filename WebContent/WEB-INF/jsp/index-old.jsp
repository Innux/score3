<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Detail Admin - Home</title>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
    <!-- bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- libraries -->
    <link href="${pageContext.request.contextPath}/css/lib/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/lib/font-awesome.css" type="text/css" rel="stylesheet" />

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layout.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/elements.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icons.css" />

    <!-- this page specific styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/compiled/user-profile.css" type="text/css" media="screen" />

    <!-- open sans font -->
    <link href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css' />

    <!-- lato font -->
    <link href='http://fonts.useso.com/css?family=Lato:300,400,700,900,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css' />

    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>

    <!-- navbar -->
   <%@ include file="navbar.jsp" %>
    <!-- sidebar -->
   <%@ include file="slidebar.jsp" %>
 

    <!-- main container -->
    <div class="content">

        <div class="container-fluid">
            <div id="pad-wrapper" class="user-profile">
                <!-- header -->
                <div class="row-fluid header">
                    <div class="span8">
                        <img src="img/contact-profile.png" class="avatar img-circle" />
                        <h3 class="name">张同学</h3>
                        <span class="area">软件工程(2)</span>
                    </div>

                    <a class="btn-flat icon large pull-right edit" href="#">
                        编辑信息
                    </a>
                </div>

                <div class="row-fluid profile">
                    <!-- bio, new note & orders column -->
                    <div class="span9 bio">
                        <div class="profile-box">
                            <!-- 个人简介 -->
                            <div class="span12 section">
                            <!--<div class="span12 personal-info">-->
                                <h6>基本信息</h6>
                                <ul>
                                    <li>学号:<span>1416270237</span></li>
                                    <li>性别:<span>男</span></li>
                                    <li>年龄:<span>22</span></li>
                                    <li>学院:<span>计算机与通信学院</span></li>
                                    <li>专业:<span>软件工程</span></li>

                                </ul>
                                <h6>获奖情况</h6>
                                <ul>
                                    <li>2015 院三好</li>
                                    <li>2015 校三号</li>
                                    <li>2014 校级奖学金</li>
                                </ul>
                            </div>

                            <h6>成绩总览</h6>
                            <br />
                            <!-- recent orders table -->
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th class="span2">
                                        学期
                                    </th>
                                    <th class="span3">
                                        <span class="line"></span>
                                        平均成绩
                                    </th>
                                    <th class="span3">
                                        <span class="line"></span>
                                        总学分
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <!-- row -->
                                <tr class="first">
                                    <td>
                                       2014上半学期
                                    </td>
                                    <td>
                                        88.4
                                    </td>
                                    <td>
                                        23
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        2014下半学期
                                    </td>
                                    <td>
                                        88.4
                                    </td>
                                    <td>
                                        23
                                    </td>
                                </tr>

                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class="span3 address pull-right">


                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- end main container -->
    <script src="js/jquery-latest.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/theme.js"></script>

</body>
</html>