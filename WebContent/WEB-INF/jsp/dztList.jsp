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
					<h3>德智体成绩列表</h3>
					<div class="span10 pull-right">
					<form action="${pageContext.request.contextPath }/dzt_findBySearchModel.action?page=1"
                             method="post" novalidate="novalidate">
						<div class="ui-select span1">
							<select name="dYear" >
								<s:if test="searchModel.year == ''">
									<option value="">学年</option>
								</s:if>
								<s:else>
									<option value="<s:property value="searchModel.year"/>"><s:property value="searchModel.year"/></option>
								</s:else>
								<option value="2014">2014</option>
								<option value="2015">2015</option>
								<option value="2016">2016</option>
								<option value="2016">2017</option>
							</select>
						</div>
						
						<div class="ui-select span1">
							<select name="dMajor">
								<s:if test="searchModel.student == null">
									<option value="">专业</option>
								</s:if>
								<s:else>
									<option value="<s:property value="searchModel.student.major.m_id"/>">
										<s:property value="searchModel.student.major.m_name"/>
									</option>
								</s:else>
								
								 <s:iterator value="majorList" var="maj">
									<option value="<s:property value="#maj.m_id"/>">
										<s:property value="#maj.m_name"/>
									</option>
								</s:iterator> 
							</select>
						</div>
						 <input type="submit" class="btn-flat primary" value="确认" />
						</form>
					</div>
 
				</div>

				<!-- Users table -->
				<div class="row-fluid table">
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="span3 sortable">学年</th>
								<th class="span3 sortable"><span class="line"></span>专业</th>
								<th class="span3 sortable"><span class="line"></span>班级</th>
								<th class="span3 sortable"><span class="line"></span>姓名</th>
								<th class="span3 sortable"><span class="line"></span>德育</th>
								<th class="span3 sortable"><span class="line"></span>智育</th>
								<th class="span3 sortable"><span class="line"></span>体育</th>
								<th class="span3 sortable"><span class="line"></span>平均分</th>
								<th class="span3 sortable"><span class="line"></span>操作</th>
							</tr>
						</thead>
						<tbody id="tBody">
							<!-- row -->
							<s:iterator var="dzt" value="pageBean.list" status="status">
								<tr>
									<td>
										<s:property value="#dzt.year"/>
									</td>
									<td>
										<s:property value="#dzt.student.major.m_name"/>
									</td>
									<td>
										<s:property value="#dzt.student.clazz.class_name"/>
									</td>
									<td>
										<s:property value="#dzt.student.name"/>
									</td>
									<td>
										<s:property value="#dzt.de"/>
									</td>
									<td>
										<s:property value="#dzt.zhi"/>
									</td>
									<td>
										<s:property value="#dzt.ti"/>
									</td>
									<td>
										<s:property value="(#dzt.ti+#dzt.zhi+#dzt.de)/3"/>
									</td>
									<td>
										<a href="#">编辑</a>
<a href="${ pageContext.request.contextPath }/dzt_delete.action?s_id=<s:property value="#dzt.id"/>">删除</a>
									</td>
								</tr>
							</s:iterator>
							<!-- row -->
							
						</tbody>
					</table>
				</div>
				<!--================= 分页======================== -->
第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页 
				<!-- =============================== -->
				<div class="pagination pull-right">
					<ul>
					<!--  上一页-->
					<li>
						<s:if test="pageBean.page != 1">
<a href="${ pageContext.request.contextPath }/dzt_findBySearchModel.action?page=<s:property value="pageBean.page-1"/>">&#8249;</a>
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
						        <li><a href="${ pageContext.request.contextPath }/dzt_findBySearchModel.action?page=<s:property/>"><s:property/></a></li>
						    </s:iterator>
						</s:bean>
					<!-- 选页end -->
					<!-- 下一页 -->
						<!-- <li><a href="#">&#8250;</a></li> -->
						<li>
						<s:if test="pageBean.page != pageBean.totalPage">
<a href="${ pageContext.request.contextPath }/dzt_findBySearchModel.action?page=<s:property value="pageBean.page+1"/>">&#8250;</a>
						</s:if>
						<s:else>
						<a href="#">&#8250;</a>
						</s:else>
						</li>
					</ul>
				</div>
	<!--===================  -->
			
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