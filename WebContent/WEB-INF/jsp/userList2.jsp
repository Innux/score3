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
		<form action="${pageContext.request.contextPath }/student_findAll.action" id="proForm" method="post">
				<input type="text" name="name" id="name" class="span5 search" placeholder="输入姓名..." /> &nbsp; 
				<input type="submit" class="btn-flat" value="查询">
		</form>
						
						<!-- <a class="btn-flat ">搜索</a> -->
						<!--===================测试功能  -->
						<form>
							<div class="ui-select span1">
								<select id="majorId" name="major.m_id"
									onchange="findByMajorIdAjax()">
									<option value="0">专业</option>
									<s:iterator var="maj" value="majorList">
										<option value="<s:property value="#maj.m_id"/>">
											<s:property value="#maj.m_name" />
										</option>
									</s:iterator>
								</select>
							</div>
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
							<s:iterator var="stu" value="pager.dataList" status="status">
								<tr>
									<td><s:property value="#stu.loginName" /></td>
									<td><s:property value="#stu.name" /></td>
									<td><s:property value="#stu.number" /></td>

									<td><s:if test="#stu.sex == 1">
											男
										</s:if> <s:else>
											女
										</s:else></td>
									<td><s:property value="#stu.major.m_name" /></td>

									<td><a href="#">编辑</a> <a
										href="${ pageContext.request.contextPath }/stu_delete.action?id=<s:property value="#stu.id"/>">删除</a>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
				<!--================= 分页======================== -->
				第
				<s:property value="pageBean.page" />
				/
				<s:property value="pageBean.totalPage" />
				页

				<div class="pagination pull-right">
					<ul>
						<!--  上一页-->
						<li><s:if test="pageBean.page != 1">
								<a
									href="${ pageContext.request.contextPath }/stu_findAll.action?page=<s:property value="pageBean.page-1"/>">&#8249;</a>
							</s:if> <s:else>
								<a href="#">&#8249;</a>
							</s:else></li>
						<!-- 选页 -->
						<!-- <li><a class="active" href="#">1</a></li>
						<li><a href="#">2</a></li> -->
						<s:bean name="org.apache.struts2.util.Counter" id="counter">
							<s:param name="first" value="1" />
							<s:param name="last" value="pageBean.totalPage" />
							<s:iterator>
								<li><a
									href="${ pageContext.request.contextPath }/stu_findAll.action?page=<s:property/>"><s:property /></a></li>
							</s:iterator>
						</s:bean>
						<!-- 选页end -->
						<!-- 下一页 -->
						<!-- <li><a href="#">&#8250;</a></li> -->
						<li><s:if test="pageBean.page != pageBean.totalPage">
								<a
									href="${ pageContext.request.contextPath }/stu_findAll.action?page=<s:property value="pageBean.page+1"/>">&#8250;</a>
							</s:if> <s:else>
								<a href="#">&#8250;</a>
							</s:else></li>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.pagination.js"></script>
	<script type="text/javascript">
		// 点击分页按钮以后触发的动作
		function handlePaginationClick(new_page_index, pagination_container) {
			$("#proForm").attr("action", "product_findAll2.action?pageNum=" + (new_page_index +1));
			$("#proForm").submit();
			return false;
		}
		
		//初始化函数
		$(function(){
			$("#News-Pagination").pagination(${totalRecord}, {
		        items_per_page:${pageSize}, // 每页显示多少条记录
		        current_page:${currentPage} - 1, // 当前显示第几页数据
		        num_display_entries:2, // 连续分页主体显示的条目数
		        next_text:"下一页",
		        prev_text:"上一页",
		        num_edge_entries:2, // 连接分页主体，显示的条目数
		        callback:handlePaginationClick, //执行的回调函数，也就是去获取新的分页数据
		        load_first_page:false //防止页面一直刷新( 这条非常重要！)        
			});
			// 初始化时就获得后台发过来的前一次的查询参数
			$("#pro_name").val("${pname}");
			$("#pro_price").val("${price}");
			
		});
</script>
	

</body>
</html>