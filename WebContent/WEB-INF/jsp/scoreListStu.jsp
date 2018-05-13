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
	<%@ include file="slidebar2.jsp"%>


	<!-- main container -->
	<div class="content">


		<div class="container-fluid">
			<div id="pad-wrapper" class="users-list">
				<div class="row-fluid header">
					<h3>成绩列表</h3>
					
					<div class="span10 pull-right">
					<form action="${pageContext.request.contextPath }/score_stuFindBySearchModel.action?page=1"
                             method="post" novalidate="novalidate">
						<div class="ui-select span1">
							<select name="stuYear" >
								<s:if test="searchModel.s_year != null">
									<option value="<s:property value="searchModel.s_year"/>"><s:property value="searchModel.s_year"/></option>
									<option value="">全部</option>
								</s:if>
								<s:else>
									<option value="">学年</option>
								</s:else>		
								<option value="2014">2014</option>
								<option value="2015">2015</option>
								<option value="2016">2016</option>
								<option value="2017">2017</option>
							</select>
						</div>
						<div class="ui-select span1">
							<select name="stuHalf">
								<s:if test="searchModel.s_half != null">
									<option value="<s:property value="searchModel.s_half"/>">
										<s:if test="searchModel.s_half==1">
										上学期
										</s:if>
										<s:else>
										下学期
										</s:else> 
									</option>
									<option value="">全部</option>
								</s:if>
								<s:else>
									<option value="">学期</option>
								</s:else>			
								<option value="1">上学期</option>
								<option value="2">下学期</option>
								
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
								<th class="span3 sortable"><span class="line"></span>学期</th>			
								<th class="span3 sortable"><span class="line"></span>科目</th>
								<th class="span3 sortable"><span class="line"></span>成绩</th>
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
										<s:property value="#sco.course.c_name"/>
									</td>
									<td>
										<s:property value="#sco.s_score"/>
									</td>
								</tr>
							</s:iterator>	
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
<a href="${ pageContext.request.contextPath }/score_stuFindBySearchModel.action?page=<s:property value="pageBean.page-1"/>">&#8249;</a>
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
<li><a href="${ pageContext.request.contextPath }/score_stuFindBySearchModel.action?page=<s:property/>&sYear=<s:property value="searchModel.s_year"/>&sMajor=<s:property value="searchModel.student.major.m_id"/>"><s:property/></a></li>
						    </s:iterator>
						</s:bean>
					<!-- 选页end -->
					<!-- 下一页 -->
						<!-- <li><a href="#">&#8250;</a></li> -->
						<li>
						<s:if test="pageBean.page != pageBean.totalPage">
							<s:if test="searchModel == null">
<a href="${ pageContext.request.contextPath }/score_stuFindBySearchModel.action?page=<s:property value="pageBean.page+1"/>&sYear=<s:property value="searchModel.s_year"/>&sMajor=<s:property value="searchModel.student.major.m_id"/>">&#8250;</a>
							</s:if>
							<s:else>
<a href="${ pageContext.request.contextPath }/score_stuFindBySearchModel.action?page=<s:property value="pageBean.page+1"/>&sYear=<s:property value="searchModel.s_year"/>&sMajor=<s:property value="searchModel.student.major.m_id"/>">&#8250;</a>
							</s:else>
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