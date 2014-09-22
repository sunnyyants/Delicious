<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 4/5/14
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="../basePath.jsp"%>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h1>User List</h1>
<table text-align:left>
    <tr>
        <td width="100">ID</td>
        <td width="100">Username</td>
        <td width="100">Firstname</td>
        <td width="100">Lastname</td>
        <td width="100">Address</td>
        <td width="100">Zipcode</td>
        <td width="100">Phone</td>
        <td width="100">Email</td>
        <td width="100">RegisterDate</td>
        <td width="100">deletion</td>
    </tr>
    <s:iterator value="listOfUsers">
        <tr>
            <td width="100"><s:property value="id"/></td>
            <td width="100"><s:property value="username"/></td>
            <td width="100"><s:property value="firstname"/></td>
            <td width="100"><s:property value="lastname"/></td>
            <td width="200"><s:property value="address"/> </td>
            <td width="100"><s:property value="zipcode"/> </td>
            <td width="100"><s:property value="phone"/></td>
            <td width="200"><s:property value="email"/> </td>
            <td width="100"><s:date name="registerDate" format="yyyy-MM-dd" nice="false"/></td>
            <form action="deleteSelectUser.action" method="post">
                <input type="hidden" name="id" value="<s:property value="id"/>"/>
                <td width="100"><input type="submit" value="delete"/></td>
            </form>
        </tr>
    </s:iterator>
    <td><a href="<%=basePath%>index.jsp"><input type="button" value="back" style="font-size: 30px"/></a></td>
</table>
</body>
</html>
