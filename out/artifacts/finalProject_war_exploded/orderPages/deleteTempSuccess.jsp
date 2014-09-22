<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 4/17/14
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file="/basePath.jsp"%>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<html>
<head>
    <title>Order Deleted</title>
</head>
<body>

<div class="jumbotron" style="margin-top: -50px">
    <h1 align="center">Bingo..!</h1>
    <h2 align="center">Order canceled...</h2>
    <p align="center">Please feel free to reorder them! The page will auto-direct to Home page...</p>
</div>
<meta http-equiv="refresh" content="2; url=<%=basePath%>redirect2Index.jsp">
</body>
</html>



