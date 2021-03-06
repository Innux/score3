<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>Student list</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- bootstrap -->
<link href="css/bootstrap/bootstrap.css" rel="stylesheet" />
<link href="css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
<link href="css/bootstrap/bootstrap-overrides.css" type="text/css"
	rel="stylesheet" />

<!-- global styles -->
<link rel="stylesheet" type="text/css" href="css/layout.css" />
<link rel="stylesheet" type="text/css" href="css/elements.css" />
<link rel="stylesheet" type="text/css" href="css/icons.css" />

<!-- libraries -->
<link href="css/lib/font-awesome.css" type="text/css" rel="stylesheet" />

<!-- this page specific styles -->
<link rel="stylesheet" href="css/compiled/user-list.css" type="text/css"
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
					<h3>学生列表</h3>
					<div class="span10 pull-right">
						<!-- <input type="text" class="span5 search" placeholder="输入姓名..." /> -->
		<form action="${pageContext.request.contextPath }/stu_findByStuName.action?page=1" id="proForm" method="post">
				<input type="text" name="name" id="name" class="span5 search" placeholder="输入姓名..." /> &nbsp; 
				<input type="submit" class="btn-flat" value="查询">
		</form>
						
						<a href="${pageContext.request.contextPath }/stu_addPage.action"
							class="btn-flat success pull-right"> <span>&#43;</span> 添加学生
						</a>
					</div>
				</div>

				<!-- Users table -->
				<div class="row-fluid table">
					<table class="table table-hover" id="table1">
						<thead>
							<tr>
								<th class="span3 sortable">用户名</th>
								<th class="span3 sortable"><span class="line"></span>姓名</th>
								<th class="span3 sortable"><span class="line"></span>学号</th>
								<th class="span3 sortable"><span class="line"></span>性别</th>
								<th class="span3 sortable"><span class="line"></span>专业</th>
								<th class="span3 sortable"><span class="line"></span>操作</th>
							</tr>
						</thead>
						<tbody id="tbody1">
							<!-- row -->
							<s:iterator var="stu" value="pageBean.list" status="status">
								<tr>
									<td>
										<s:property value="#stu.loginName"/>
									</td>
									<td>
										<s:property value="#stu.name"/>
									</td>
									<td>
										<s:property value="#stu.number"/>
									</td>
									
									<td>
										<s:if test="#stu.sex == 1">
											男
										</s:if>
										<s:else>
											女
										</s:else>
									</td>
									<td>
										<s:property value="#stu.major.m_name"/>
									</td>
									
									<td>
<a href="${ pageContext.request.contextPath }/stu_edit.action?id=<s:property value="#stu.id"/>">编辑</a>
<a href="${ pageContext.request.contextPath }/stu_delete.action?id=<s:property value="#stu.id"/>">删除</a>
									</td>
								</tr>
							</s:iterator>		
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
<a href="${ pageContext.request.contextPath }/stu_findAll.action?page=<s:property value="pageBean.page-1"/>">&#8249;</a>
						</s:if>
						<s:else>
						<a href="#">&#8249;</a>
						</s:else>
					</li>
					<!-- 选页 -->
						<!-- <li><a class="active" href="#">1</a></li>
						<li><a href="#">2</a></li> -->
						<s:bean name="org.apache.struts2.util.Counter" id="counter">
						    <s:param name="first" value="1" />
						    <s:param name="last" value="pageBean.totalPage" />
						    <s:iterator>
						        <li><a href="${ pageContext.request.contextPath }/stu_findAll.action?page=<s:property/>"><s:property/></a></li>
						    </s:iterator>
						</s:bean>
					<!-- 选页end -->
					<!-- 下一页 -->
						
						<li>
						<s:if test="pageBean.page != pageBean.totalPage">
<a href="${ pageContext.request.contextPath }/stu_findAll.action?page=<s:property value="pageBean.page+1"/>">&#8250;</a>
						</s:if>
						<s:else>
						<a href="#">&#8250;</a>
						</s:else>
						</li>
					</ul>
				</div>
				<!-- end users table -->
			</div>
		</div>
	</div>
	<!-- end main container -->


	<!-- scripts -->
	<script src="${pageContext.request.contextPath}/js/jquery-latest.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/theme.js"></script>
	<script type="text/javascript">
 
    function findByMajorIdAjax() {  
       /*  $("#tbody1").remove(); */
     /*    var tbody1 = document.getElementBYId("tbody1");
        var table1 = document.getElementById("table1");
        table1.removeChild(tbody1);
        var tbody2 = document.createElement("tbody");
        table1.appendChild(tbody2); */
       
        var mid = document.getElementById("majorId").value;  
        var url = "stu_findByMajorIdAjax.action?page=1&mid=" + mid;  
        $.ajax( {  
            type : "POST",  
            url : url,  
            data : {},  
            dataType : "JSON",  
            success : function(data) {  
            	tbody2.append("<tr><td>zhangsan</td></tr>");
                //data为后台返回的Json信息  
           /*      for(var n=0;n<data.length;n++){  
                 	var ids=data[n].class_id;  
                    var names=data[n].class_name;  
                    $("#clazzId").append("<option value='"+ids+"'>"+names+"</option>");  
                    }  */ 
            }  
        })  
    } 
    </script>

</body>
</html>