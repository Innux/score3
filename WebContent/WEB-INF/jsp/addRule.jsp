<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<title>Detail Admin - New User Form</title>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
    <!-- bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layout.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/elements.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icons.css" />

    <!-- libraries -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/lib/font-awesome.css" />
    
    <!-- this page specific styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/compiled/new-user.css" type="text/css" media="screen" />
    <!--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/compiled/form-wizard.css" type="text/css" media="screen" />-->

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
   <%@ include file="slidebar.jsp" %>


	<!-- main container -->
    <div class="content">
        
        <div class="container-fluid">
            <div id="pad-wrapper" class="new-user">
                <div class="row-fluid header">
                    <h3>添加规则</h3>
                </div>

                <div class="row-fluid form-wrapper">
                    <!-- left column -->
                    <div class="span10 with-sidebar">
                        <div class="container">
<!-- ==========================表单========= -->
                            <form class="new_user_form" 
                            action="${pageContext.request.contextPath }/rule_save.action"
                             method="post" novalidate="novalidate">
			                       
                                    <div class="span10 field-box">
                                        <label>学年:</label>
                                        <input name="year" class="span7" type="text" />
                                    </div>
                                <!--     <div class="span10 field-box">
                                        <label>奖学金等级:</label>
                                        <input name="level" class="span7" type="text"/>
                                    </div> -->
                                    <div class="span10 field-box">
                                        <label>奖学金等级:</label>
                                        <div class="ui-select span5">
                                            <select id="levelId" name="level" >
                                            	<option value="0">请选择</option>                                            	 
													<option value="一等奖">一等奖</option>
												  	<option value="二等奖">二等奖</option>
												  	<option value="三等奖">三等奖</option>	
                                            </select>
                                        </div>
                                    </div>
                                    
                                     <div class="span10 field-box">
                                        <label>奖学金人数:</label>
                                        <input name="stunum" class="span7" type="text"/>
                                    </div>

          
                                    <div class="span2 field-box">
 <!--=========表单提交============  -->
                                        <input type="submit" class="btn-flat primary" value="确认" />
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="reset" class="btn-flat danger" value="取消" class="reset" />
                                    </div>
                            </form>
                        </div>
                    </div>

                 <!--    <div class="span3 form-sidebar pull-right">

                        <div class="alert alert-info hidden-tablet">
                            <i class="icon-lightbulb pull-left"></i>
                            提示：
                            有问题拨打以下电话
                        </div>
                        <h6>联系方式</h6>
                        <p>025-4423-11332</p>
                        <p>032-123-434</p>

                    </div> -->
                </div>
            </div>
        </div>
    </div>
    <!-- end main container -->


	<!-- scripts -->
    <script src="${pageContext.request.contextPath}/js/jquery-latest.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/theme.js"></script>
    <script type="text/javascript">
    
    function checkStuLoginName() {
    	var loginName = document.getElementById("loginName").value;
    	var xhr = createXmlHttp();
    	xhr.onreadystatechange = function(){
    		if(xhr.readyState == 4) {
    			if(xhr.status == 200) {
    				document.getElementById("span2").innerHTML = xhr.responseText;
    			}
    		}
    	}
    	xhr.open("GET",
    			"${pageContext.request.contextPath}/stu_findByStuLoginName.action?time="
    					+new Date().getTime()+"&loginName="+loginName,true);
    	xhr.send(null);
    }
    
    function createXmlHttp() {
    	
    	var xmlHttp;
    	try {
    		xmlHttp = new XMLHttpRequest();
    	} catch(e) {
    		try {
    			xmlHttp = new ActiveXObject("Msxm12.XMLHTTP");
    		} catch(e) {
    			try{
    				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    			} catch(e){}
    		}
    	}
    	return xmlHttp;
    }
    </script>


</body>
</html>