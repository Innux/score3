<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>Score List</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap-overrides.css" type="text/css"
	rel="stylesheet" />

<!-- global styles -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layout.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/elements.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icons.css" />

<!-- libraries -->
<link href="${pageContext.request.contextPath}/css/lib/font-awesome.css" type="text/css" rel="stylesheet" />

<!-- this page specific styles -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/compiled/user-list.css" type="text/css"
	media="screen" />

<!-- open sans font -->
<link
	href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css' />

<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>

	<!-- navbar -->
	<%@ include file="navbar.jsp"%>
	<!-- sidebar -->
	<%@ include file="slidebar.jsp"%>


	<!-- main container -->
	<div class="content">


		<div class="container-fluid">
			<div id="pad-wrapper" class="users-list">
				<div class="row-fluid header">
					<h3>成绩列表</h3>
					<div class="span10 pull-right">
						<div class="ui-select span1">
							<select>
								<option value="0">学年</option>
								<option value="1">2014</option>
								<option value="2">2015</option>

							</select>
						</div>
						<div class="ui-select span1">
							<select onchange="findAllJson()" id="halfId" name="halfId">
								<option value="0">学期</option>
								<option value="1">上学期</option>
								<option value="2">下学期</option>
							</select>
						</div>
						<div class="ui-select span1">
							<select>
								<option value="0">专业</option>
								<option value="1">软件工程</option>
								<option value="2">物联网</option>
							</select>
						</div>
						<div class="ui-select span1">
							<select>
								<option value="0">班级</option>
								<option value="1">1</option>
								<option value="2">2</option>
							</select>
						</div>
						<div class="ui-select span1">
							<select>
								<option value="0">科目</option>
								<option value="1">Java</option>
								<option value="2">编译原理</option>
							</select>
						</div>

					</div>

				</div>

				<!-- Users table -->
				<div class="row-fluid table">
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="span3 sortable">学年</th>
								<th class="span3 sortable"><span class="line"></span>学期</th>
								<th class="span3 sortable"><span class="line"></span>姓名</th>
								<th class="span3 sortable"><span class="line"></span>专业</th>
								<th class="span3 sortable"><span class="line"></span>班级</th>
								<th class="span3 sortable"><span class="line"></span>科目</th>
								<th class="span3 sortable"><span class="line"></span>成绩</th>
								<th class="span3 sortable"><span class="line"></span>操作</th>
							</tr>
						</thead>
						<tbody id="tBody">
							<!-- row -->
							<s:iterator var="sco" value="pageBean.list" status="status">
								<tr>
									<td>
										<s:property value="#sco.s_year"/>
									</td>
									<td>
										<s:if test="#sco.s_half == 1">
											上学期
										</s:if>
										<s:else>
											下学期
										</s:else>
									</td>
									<td>
										<s:property value="#sco.student.name"/>
									</td>
									<td>
										<s:property value="#sco.student.major.m_name"/>
									</td>
									<td>
										<s:property value="#sco.student.clazz.class_name"/>
									</td>
									<td>
										<s:property value="#sco.course.c_name"/>
									</td>
									<td>
										<s:property value="#sco.s_score"/>
									</td>
									<td>
										<a href="#">编辑</a>
<a href="${ pageContext.request.contextPath }/score_delete.action?s_id=<s:property value="#sco.s_id"/>">删除</a>
									</td>
								</tr>
							</s:iterator>
							<!-- row -->
							
						</tbody>
					</table>
				</div>
				<!--================= 分页======================== -->
第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页 

				<div class="pagination pull-right">
					<ul>
					<!--  上一页-->
					<li>
						<s:if test="pageBean.page != 1">
<a href="${ pageContext.request.contextPath }/score_findAll.action?page=<s:property value="pageBean.page-1"/>">&#8249;</a>
						</s:if>
						<s:else>
						<a href="#">&#8249;</a>
						</s:else>
					</li>
					<!-- 选页 -->
						<s:bean name="org.apache.struts2.util.Counter" id="counter">
						    <s:param name="first" value="1" />
						    <s:param name="last" value="pageBean.totalPage" />
						    <s:iterator>
						        <li><a href="${ pageContext.request.contextPath }/score_findAll.action?page=<s:property/>"><s:property/></a></li>
						    </s:iterator>
						</s:bean>
					<!-- 选页end -->
					<!-- 下一页 -->
						<!-- <li><a href="#">&#8250;</a></li> -->
						<li>
						<s:if test="pageBean.page != pageBean.totalPage">
<a href="${ pageContext.request.contextPath }/score_findAll.action?page=<s:property value="pageBean.page+1"/>">&#8250;</a>
						</s:if>
						<s:else>
						<a href="#">&#8250;</a>
						</s:else>
						</li>
					</ul>
				</div>
				<!-- end users table -->
				<!-- end users table -->
			</div>
		</div>
	</div>
	<!-- end main container -->


	<!-- scripts -->
	<script src="js/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/theme.js"></script>
	<script type="text/javascript">
	function findAllJson() {  
		var sYear = document.getElementById("yearId").value;
        var sHalf = document.getElementById("halfId").value;        
        var url = "score_findAllJson.action?sHalf=" + sHalf;  
        $.ajax( {  
            type : "POST",  
            url : url,  
            data : {},  
            dataType : "JSON",  
            success : function(data) {  
            	$("#tBody").append("<option value='0'>请选择</option>");
                //data为后台返回的Json信息  
                for(var n=0;n<data.length;n++){  
                 	var ids=data[n].class_id;  
                    var names=data[n].class_name;  
                    $("#clazzId").append("<tr><td>"+names+"</td></tr>");  
                    }  
            }  
        })  
    } 
     
	</script>

</body>
</html>