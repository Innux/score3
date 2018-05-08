<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%> 
<!DOCTYPE html>
<html>
<head>
	<title>Detail Admin - User Profile</title>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
    <!-- bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- libraries -->
    <link href="${pageContext.request.contextPath}/css/lib/font-awesome.css" type="text/css" rel="stylesheet" />

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layout.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/elements.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icons.css" />
    
    <!-- this page specific styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/compiled/user-profile.css" type="text/css" media="screen" />

    <!-- open sans font -->
    <link href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css' />

    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>

      <!-- navbar -->
   <%@ include file="navbar.jsp" %>
    <!-- sidebar -->
   <%@ include file="slidebar2.jsp" %>

	<!-- main container -->
    <div class="content">
        
        <div class="container-fluid">
            <div id="pad-wrapper" class="user-profile">
                <!-- header -->
                <div class="row-fluid header">
                    <div class="span8">
                        <img src="${pageContext.request.contextPath}/img/head.png" class="avatar img-circle" style="height: 100px; width: 100px"/>
                        <h3 class="name"><s:property value="#session.user.name"/></h3>
                        <span class="clazz"><s:property value="#session.user.clazz.class_name"/></span>
                    </div>

                  <!--    <a class="btn-flat icon large  edit">
                        编辑
                    </a> -->
                </div>

                <div class="row-fluid profile">
                    <!-- bio, new note & orders column -->
                    <div class="span9 bio">
                        <div class="profile-box">


                                <div class="container-fluid">
                                    <div class="settings-wrapper">
                                        <!-- edit form column -->
                                        <h3>基本信息</h3>
                                        <div class="span9  personal-info">
                                            <br>
                                                <div class="field-box">
                                                    学号:&nbsp;&nbsp;&nbsp;
                                                    <input class="span5 inline-input" type="text" 
                                                    value="<s:property value="#session.user.number"/>" />
                                                </div>
                                                <div class="field-box">
                                                    性别:&nbsp;&nbsp;&nbsp;
                                                    <input class="span5 inline-input" type="text" 
value="<s:if test='#session.user.sex == 1'>男</s:if><s:else>女</s:else>"/>
                                                </div>
                                                <div class="field-box">
                                                    年龄:&nbsp;&nbsp;&nbsp;
                                                    <input class="span5 inline-input" type="text" 
                                                    value="<s:property value="#session.user.age"/>" />
                                                </div>
                                                <div class="field-box">
                                                    学院:&nbsp;&nbsp;&nbsp;
                                                    <input class="span5 inline-input" type="text" 
                                                    value="<s:property value="#session.user.academy.a_name"/>" />
                                                </div>
                                                <div class="field-box">
                                                    专业:&nbsp;&nbsp;&nbsp;
                                                    <input class="span5 inline-input" type="text" 
                                                    value="<s:property value="#session.user.major.m_name"/>" />
                                                </div>

                                        </div>
                                    </div>
                                </div>
                                <br>
                            <br>
                            <div class="container-fluid">
                                <div class="settings-wrapper">
                                    <h3>获奖情况</h3>
                                    <br>
                                    <ul>
	                                  <s:iterator value="prizeList" var="prize">															
											<li style="padding: 2px">
												<s:property value="#prize.rule.year"/>
												&nbsp;
												<s:property value="#prize.rule.level"/>
											</li>
									</s:iterator> 
                                    </ul>
                                </div>
                            </div>
                            <br><br>
                            <h3>成绩总览</h3>
                            <br>
                            <!-- 成绩列表 -->
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                  	<th class="span2">
                                        学年
                                    </th>
                                    <th class="span2">
                                        学期
                                    </th>
                                    <th class="span3">
                                        <span class="line"></span>
                                        学科平均成绩
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <!-- row -->
	                                 <s:iterator value="scoreList" var="sco">	
	                                  	<tr>
		                                    <td><s:property value="#sco[0]"/></td>
		                                    <td>
											<s:if test="#sco[1] == 1">上学期</s:if><s:else>下学期</s:else>
											</td>		                                    
		                                    <td><s:property value="#sco[2]"/></td>
	                                	</tr>																								
									</s:iterator>
                            

                                </tbody>
                            </table>

                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <!-- end main container -->


	<!-- scripts -->
    <script src="js/jquery-latest.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/theme.js"></script>

</body>
</html>
   