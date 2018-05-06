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
                    <h3>编辑学生信息</h3>
                </div>

                <div class="row-fluid form-wrapper">
                    <!-- left column -->
                    <div class="span10 with-sidebar">
                        <div class="container">
<!-- ==========================表单========= -->
                            <form class="new_user_form" 
                            action="${pageContext.request.contextPath }/stu_update.action"
                             method="post" novalidate="novalidate">
                             
                              <input type="hidden"  name="id"
            value="<s:property value="model.id"/>" />
                                <div class="span10 field-box">
                                    <label>用户名:</label>
                                    <input id="loginName" name="loginName"
                                    class="span7" data-toggle="tooltip"
                                          type="text" onblur="checkStuLoginName()"
                                          value="<s:property value="model.loginName"/>"/>
                                           <span id="span1"></span>
                                </div>
                                <div class="span10 field-box">
                                    <label>密码:</label>
                                    <input id="loginPwd" name="loginPwd" 
                                    class="span7 " data-toggle="tooltip"
                                            type="text" value="<s:property value="model.loginPwd"/>"/>
                                </div>
                                    <div class="span10 field-box">
                                        <label>姓名:</label>
                                        <input id="name" name="name" class="span7" type="text" 
                                        value="<s:property value="model.name"/>"/>
                                    </div>
                                     <div class="span10 field-box">
                                        <label>学号:</label>
                                        <input id="number" name="number" class="span7" type="text" 
                                        value="<s:property value="model.number"/>"/>
                                    </div>
                                    <div class="span10 field-box">
                                        <label>年龄:</label>
                                        <input name="age" class="span7" type="text" 
                                        value="<s:property value="model.age"/>"/>
                                    </div>

                                  <div class="span10 field-box">
                                        <label>性别:</label>
                                        <div class="span7">
                                            <label class="radio">
                                                <input type="radio" name="sex" id="optionsRadios1" value="1" checked="" />
                                                男
                                            </label>
                                            <label class="radio">
                                                <input type="radio" name="sex" id="optionsRadios2" value="2" />
                                                女
                                            </label>
                                        </div>
                                    </div>
                                    
<input type="hidden" name="type" value="1"/>
                                    <div class="span10 field-box">
                                        <label>学院:</label>
                                        <div class="ui-select span5">
  <!--====================== 学院选择====================== --> 
                                            <select id="academyId" name="academy.a_id" onchange="findMajorByAcademyId()" >
                                            	<option value="<s:property value="model.academy.a_id"/>"><s:property value="model.academy.a_name"/></option>                                            	 
                                          	 	<s:iterator value="academyList" var="aca">
													<option value="<s:property value="#aca.a_id"/>">
														<s:property value="#aca.a_name"/>
													</option>
												</s:iterator>   		
                                            </select>
                                        </div>
                                    </div>

                                    <div class="span10 field-box">
                                        <label>专业:</label>
                                        <div class="ui-select span5">
<!-- ====================专业选择============= -->
                                            <select id="majorId" name="major.m_id" onchange="findClassByMajorId()" >
                                              <option value="<s:property value="model.major.m_id"/>"><s:property value="model.major.m_name"/></option>                                            	         
                                            </select>
                                        </div>
                                    </div>
                                    <div class="span10 field-box">
                                        <label>班级:</label>
                                        <div class="ui-select span5">
<!-- ====================班级选择============= -->                                        
                                            <select id="clazzId" name="clazz.class_id">
                                                 <option value="<s:property value="model.clazz.class_id"/>"><s:property value="model.clazz.class_name"/></option>                                            	 
                                            </select>
                                        </div>
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
 
    function findClassByMajorId() {  
        $("#clazzId").empty();//清空  
        var mid = document.getElementById("majorId").value;  
        var url = "stu_findClazzByMajorId.action?mid=" + mid;  
        $.ajax( {  
            type : "POST",  
            url : url,  
            data : {},  
            dataType : "JSON",  
            success : function(data) {  
            	$("#clazzId").append("<option value='0'>请选择</option>");
                //data为后台返回的Json信息  
                for(var n=0;n<data.length;n++){  
                 	var ids=data[n].class_id;  
                    var names=data[n].class_name;  
                    $("#clazzId").append("<option value='"+ids+"'>"+names+"</option>");  
                    }  
            }  
        })  
    } 
    
    
    
    function findMajorByAcademyId() {  
        $("#majorId").empty();//清空  
        var aid = document.getElementById("academyId").value;  
        var url = "stu_findMajorByAcademyId.action?aid=" + aid;  
        $.ajax( {  
            type : "POST",  
            url : url,  
            data : {},  
            dataType : "JSON",  
            success : function(data) {  
            	 $("#majorId").append("<option value='0'>请选择</option>");
                //data为后台返回的Json信息  
                for(var n=0;n<data.length;n++){  
                 	var ids=data[n].m_id;  
                    var names=data[n].m_name;  
                    $("#majorId").append("<option value='"+ids+"'>"+names+"</option>");  
                    }  
            }  
        })  
    } 
    
    

    
    
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