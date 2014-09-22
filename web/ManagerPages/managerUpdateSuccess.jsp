<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 4/4/14
  Time: 17:29
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
    <title></title>
</head>
<body>

<%
    Map map = ActionContext.getContext().getSession();
    String userName = (String) map.get("username");
%>
<div class="jumbotron">
    <h1 align="center">Change Successfully!</h1>
    <p align="center">Auto-directing to the index page...</p>
</div>
<meta http-equiv="refresh" content="2; url=<%=basePath%>ManagerPages/ControlPannel.jsp">
</body>
</html>
