<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<title>Detail Admin - Form Showcase</title>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
    <!-- bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- libraries -->
    <link href="${pageContext.request.contextPath}/css/lib/bootstrap-wysihtml5.css" type="text/css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/lib/uniform.default.css" type="text/css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/lib/select2.css" type="text/css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/lib/bootstrap.datepicker.css" type="text/css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/lib/font-awesome.css" type="text/css" rel="stylesheet" />

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layout.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/elements.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icons.css" />
    
    <!-- this page specific styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/compiled/form-showcase.css" type="text/css" media="screen" />

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
	


	<!-- main container -->
	<div class="content">
        
        <div class="container-fluid">
            <div id="pad-wrapper" class="form-page">
                <div class="row-fluid form-wrapper">
                    <!-- left column -->
                    <div class="span8 column">
                        <form>
                            <div class="field-box">
                                <label>标题:</label>
                                <input value="<s:property value="model.title"/>" class="span8 inline-input" type="text" readonly="readonly" maxlength="20" />
                            </div>

                            <div class="field-box">
                                <label>日期:</label>
                                <input value="<s:property value="model.time"/>" class="span8 inline-input" type="text" readonly="readonly" />
                            </div>

                            <div class="field-box">
                                <label>内容:</label>
                                <textarea class="span8" readonly="readonly" rows="20" col="10"><s:property value="model.content"/></textarea>
                            </div>

                        </form>
                    </div>
                    
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- end main container -->

	<!-- scripts for this page -->
    <script src="js/wysihtml5-0.3.0.js"></script>
    <script src="js/jquery-latest.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-wysihtml5-0.0.2.js"></script>
    <script src="js/bootstrap.datepicker.js"></script>
    <script src="js/jquery.uniform.min.js"></script>
    <script src="js/select2.min.js"></script>
    <script src="js/theme.js"></script>
<%-- <script>
    window.onload = function(){
        showTime();
    }

    function showTime()
    {
        var now=new Date();
        var year=now.getFullYear();
        var month=now.getMonth()+1;
        var day=now.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (day >= 0 && day <= 9) {
            day = "0" + day;
        }
        document.getElementById("iTime").value = year + "-" + month + "-" + day;

    }

    function clearSth()
    {
        document.getElementById("iTitle").value = "";
        document.getElementById("iTxt").value = "";

    }
</script> --%>

</body>
</html>