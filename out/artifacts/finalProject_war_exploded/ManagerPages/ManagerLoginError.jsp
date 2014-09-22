<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 4/19/14
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/basePath.jsp"%>
<%@taglib prefix="s" uri="/struts-tags" %>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="../bootstraps/css/bootstrap.min_cp.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<html>
<head>
    <title>Log in Error</title>
</head>
<body>
<div class="jumbotron">
    <h1 align="center">Opps...</h1>
    <s:if test="hasFieldErrors()">
        <p align="center">
        <s:iterator value="fieldErrors">
            <h2 align="center"><s:property value="value[0]"/></h2>
        </s:iterator>
        </p>
    </s:if>
    </h2>
    <p align="center">please retry it! The page will auto-direct to previous page...</p>
</div>
<meta http-equiv="refresh" content="2; url=<%=basePath%>ManagerPages/ManagerLogin.jsp">
</body>
</html>
