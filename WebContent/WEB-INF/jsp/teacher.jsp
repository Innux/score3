<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
    <!DOCTYPE html>
<html>
<head>
	<title>教师评分</title>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
    <!-- bootstrap -->
    <link href="css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
    <link href="css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="css/layout.css" />
    <link rel="stylesheet" type="text/css" href="css/elements.css" />
    <link rel="stylesheet" type="text/css" href="css/icons.css" />

    <!-- libraries -->
    <link href="css/lib/font-awesome.css" type="text/css" rel="stylesheet" />
    
    <!-- this page specific styles -->
    <link rel="stylesheet" href="css/compiled/user-list.css" type="text/css" media="screen" />

    <!-- open sans font -->
    <link href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css' />

    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>

	<!-- navbar -->
	<%@ include file="navbar.jsp"%>
	<!-- sidebar -->
	<%@ include file="slidebar2.jsp"%>


	<!-- main container -->
    <div class="content">
        <div class="container-fluid">
            <div id="pad-wrapper" class="users-list">
                <div class="row-fluid header">
                    <h3>教师评分</h3>
                </div>
                <!-- Users table -->
                <div class="row-fluid table">
                <form action="${pageContext.request.contextPath }/tch_save.action"
                       method="post" novalidate="novalidate">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th class="span3 sortable">
                                    学院
                                </th>
                                <th class="span3 sortable">
                                    <span class="line"></span>教师
                                </th>

                                <th class="span3 sortable">
                                    <span class="line"></span>评分
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                        <tbody>
<s:iterator var="t" value="tList" status="status">                        
                        <!-- row -->
                        <tr class="">
                            <td>计算机与通信学院</td>
                            <td><s:property value="#t.name"/></td>
                            <td>
                                <div class="ui-select">
                                   <select id="levelId" 
                                   name="tsList[<s:property value='#status.index'/>].score" >
	                                    <option value="5">5</option>                                            	 
										<option value="4">4</option> 
										<option value="3">3</option> 
										<option value="2">2</option> 
										<option value="1">1</option> 
                                   </select>
                                </div>
                            </td>
                        </tr>
                        <input name="tsList[<s:property value='#status.index'/>].teacher.id" 
                        	value="<s:property value='#t.id'/>" class="span7" type="hidden"/>
                        <input name="tsList[<s:property value='#status.index'/>].student.id" 
                           type="hidden" value="<s:property value="#session.user.id"/>" />
</s:iterator>                        
                        </tbody>
                    </table>
                      <div class="span2 field-box pull-right">
                        <input type="submit" class="btn-flat primary" value="提交" />
                        <input type="reset" class="btn-flat danger" value="取消" class="reset" />
                    </div>
            </form>
                    
                </div>
                <!-- end users table -->
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