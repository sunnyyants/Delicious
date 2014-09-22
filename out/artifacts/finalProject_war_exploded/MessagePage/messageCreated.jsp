<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 4/24/14
  Time: 9:46
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
    <title>Thank you!</title>
</head>
<body>

<div class="jumbotron">
    <h1 align="center">Thank you!</h1>
    <h2 align="center">for leaving us a message...</h2>
    <p align="center">We will read them ASAP! The page will auto-direct to Home page...</p>
</div>
<meta http-equiv="refresh" content="2; url=<%=basePath%>redirect2Index.jsp">
</body>
</html>
