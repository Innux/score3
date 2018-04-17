<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Detail Admin - User list</title>

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
							<select>
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
						<tbody>
							<!-- row -->
							<tr class="">
								<td>2017</td>
								<td>上学期</td>
								<td>张三</td>
								<td>软件工程</td>
								<td>2</td>
								<td>编译原理</td>
								<td>88</td>
								<td><a href="#">编辑</a> <a href="#">删除</a></td>
							</tr>
							<!-- row -->
							<tr class="">
								<td>2017</td>
								<td>上学期</td>
								<td>张三</td>
								<td>软件工程</td>
								<td>2</td>
								<td>Java</td>
								<td>88</td>
								<td><a href="#">编辑</a> <a href="#">删除</a></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="pagination pull-right">
					<ul>
						<li><a href="#">&#8249;</a></li>
						<li><a class="active" href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">&#8250;</a></li>
					</ul>
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