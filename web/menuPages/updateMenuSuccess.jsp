<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 4/12/14
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="../basePath.jsp"%>
<html lang="en"><head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.ico">

    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="../bootstraps/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../bootstraps/css/dashboard.css" rel="stylesheet">
<body>
<div class="jumbotron">
    <h1 align="center">Order Created!</h1>
    <h2 align="center">Name: <s:property value="name"/></h2>
    <h3 align="center">Price: <s:property value="price"/></h3>
    <p align="center"><s:property value="description"/> </p>
    <div align="center">
        <img src="<%=basePath%>menuImages/<s:property value="imageURL"/>"/>
    </div>
</div>

<meta http-equiv="refresh" content="3; url=<%=basePath%>ManagerPages/ControlPannel.jsp">
</body>
</html>
