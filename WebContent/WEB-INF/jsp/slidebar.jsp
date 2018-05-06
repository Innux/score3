<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="sidebar-nav">
    <ul id="dashboard-menu">
        <li class="active">
            <!-- <div class="pointer">
                <div class="arrow"></div>
                <div class="arrow_border"></div>
            </div> -->
            <a href="#">
                <i class="icon-home"></i>
                <span>主页</span>
            </a>
        </li>
        <li>
            <a class="dropdown-toggle" href="#">
                <i class="icon-group"></i>
                <span>学生管理</span>
                <i class="icon-chevron-down"></i>
            </a>
            <ul class="submenu">
                <li><a href="${pageContext.request.contextPath }/stu_findAll.action?page=1">学生查询</a></li>
                <li><a href="${pageContext.request.contextPath }/stu_addPage.action">新增学生</a></li>
            </ul>
        </li>
        <li>
            <a class="dropdown-toggle" href="#">
                <i class="icon-signal"></i>
                <span>成绩管理</span>
                <i class="icon-chevron-down"></i>
            </a>
            <ul class="submenu">
                <li><a href="${pageContext.request.contextPath }/score_findAll.action?page=1">学科成绩查询</a></li>
                <li><a href="${pageContext.request.contextPath }/dzt_findBySearchModel.action?page=1">德智体成绩查询</a></li>
                <li><a href="${pageContext.request.contextPath }/dzt_findBySearchModelOrder.action?page=1">德智体综合排名</a></li>
            </ul>
        </li>
        <li>
            <a class="dropdown-toggle" href="#">
                <i class="icon-trophy"></i>
                <span>评奖评优</span>
                <i class="icon-chevron-down"></i>
            </a>
            <ul class="submenu">
                <li><a href="${pageContext.request.contextPath }/rule_findAll.action?page=1">奖学金设定</a></li>
                <li><a href="${pageContext.request.contextPath }/prize_findBySearchModel.action?page=1">获奖学生列表</a></li>
            </ul>
        </li>

        <li>
            <a class="dropdown-toggle" href="#">
                <i class="icon-bullhorn"></i>
                <span>留言板/公告</span>
                <i class="icon-chevron-down"></i>
            </a>
            <ul class="submenu">
                <li><a href="#">留言板</a></li>
                <li><a href="#">发布公告</a></li>
            </ul>
        </li>
    </ul>
</div>