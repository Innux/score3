<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="sidebar-nav">
        <ul id="dashboard-menu">

             <li >
                <a class="dropdown-toggle" href="#">
                    <i class="icon-user"></i>
                    <span>个人中心</span>
                    <i class="icon-chevron-down"></i>
                </a>
                <ul class="submenu ">
                    <li><a href="${pageContext.request.contextPath }/stu_stuIndex.action">个人信息</a></li>
                    <li><a href="${pageContext.request.contextPath }/score_stuFindBySearchModel.action?page=1">成绩查询</a></li>
                    <li><a href="${pageContext.request.contextPath }/tch_tchIndex.action">教师评分</a></li>
                </ul>
            </li>
            
            <li>
                <a class="dropdown-toggle" href="#">
                    <i class="icon-bullhorn"></i>
                    <span>留言板/公告</span>
                    <i class="icon-chevron-down"></i>
                </a>
                <ul class="submenu">
                   <li><a href="${pageContext.request.contextPath }/notice_findByPage2.action?page=1">公告栏</a></li>
                   <li><a href="${pageContext.request.contextPath }/ly_findByPage.action?page=1">留言板</a></li>    
                </ul>
            </li>
        </ul>
    </div>