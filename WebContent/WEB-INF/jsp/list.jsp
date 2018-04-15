<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
 
<%@page isELIgnored="false"%>
 
<table>
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
                 
<s:iterator value="students" var="stu">
    <tr>
        <td><s:property value="#stu.id"/></td>
        <td><s:property value="#stu.name"/></td>
    </tr>
</s:iterator>
 
</table>