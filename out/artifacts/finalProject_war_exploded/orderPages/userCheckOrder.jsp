<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 4/18/14
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="../basePath.jsp"%>
<html>
<head>
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

    <style id="holderjs-style" type="text/css"></style></head>


<title></title>
</head>
<body>
<div class="jumbotron">
    <h1 class="page-header">My orders</h1>
    <table class="table table-striped table-hover">
        <thead>
        <tr align="center">
        <tr>
            <td width="100" class="info">orderID</td>
            <td width="100"class="warning">dateOfOrder</td>
            <td width="100"class="success">total</td>
            <td width="100" class="danger">status</td>
        </tr>
        </tr>
        <s:iterator value="orders" status="status">
            <tr>
                <td width="100" class="info"><s:property value="id"/></td>
                <td width="100" class="warning"><s:property value="dateOfOrder"/></td>
                <td width="100" class="success"><s:property value="total"/></td>
                <td width="100" class="danger"><s:property value="status"/> </td>
            </tr>
        </s:iterator>
        </thead>
    </table>
    <p>
        <a class="btn btn-lg btn-primary" href="<%=basePath%>redirect2Index.jsp" role="button">Back to Home »</a>
    </p>
</div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="../bootstraps/js/bootstrap.min.js"></script>
<script src="../../assets/js/docs.min.js"></script>


<iframe frameborder="0" scrolling="no" style="background-color: transparent; border: 0px; display: none;"></iframe>
<div id="GOOGLE_INPUT_CHEXT_FLAG" input="null" input_stat="{&quot;tlang&quot;:null,&quot;tsbc&quot;:null,&quot;pun&quot;:null,&quot;mk&quot;:false,&quot;ss&quot;:true}" style="display: none;"></div>
</body>
</html>

<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: Sunny--%>
  <%--Date: 4/18/14--%>
  <%--Time: 22:42--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="s" uri="/struts-tags" %>--%>
<%--<%@include file="../basePath.jsp"%>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<meta charset="utf-8">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<meta name="description" content="">--%>
    <%--<meta name="author" content="">--%>
    <%--<link rel="shortcut icon" href="../../assets/ico/favicon.ico">--%>

    <%--<title>Dashboard Template for Bootstrap</title>--%>

    <%--<!-- Bootstrap core CSS -->--%>
    <%--<link href="../bootstraps/css/bootstrap.min.css" rel="stylesheet">--%>

    <%--<!-- Custom styles for this template -->--%>
    <%--<link href="../bootstraps/css/dashboard.css" rel="stylesheet">--%>

    <%--<style id="holderjs-style" type="text/css"></style></head>--%>


<%--<title></title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="jumbotron">--%>
    <%--<h1 class="page-header">My orders</h1>--%>
    <%--<table class="table table-striped table-hover">--%>
        <%--<thead>--%>
        <%--<tr align="center">--%>
        <%--<tr>--%>
            <%--<td width="100" class="info">orderID</td>--%>
            <%--<td width="100"class="warning">dateOfOrder</td>--%>
            <%--<td width="100"class="success">total</td>--%>
            <%--<td width="100" class="danger">status</td>--%>
        <%--</tr>--%>
        <%--</tr>--%>
        <%--<s:iterator value="orders" status="status">--%>
            <%--<tr>--%>
                <%--<td width="100" class="info"><s:property value="id"/></td>--%>
                <%--<td width="100" class="warning"><s:property value="dateOfOrder"/></td>--%>
                <%--<td width="100" class="success"><s:property value="total"/></td>--%>
                <%--<td width="100" class="danger"><s:property value="status"/> </td>--%>
            <%--</tr>--%>
        <%--</s:iterator>--%>
        <%--</thead>--%>
    <%--</table>--%>
    <%--<p>--%>
        <%--<a class="btn btn-lg btn-primary" href="<%=basePath%>redirect2Index.jsp" role="button">Back to Home »</a>--%>
    <%--</p>--%>
<%--</div>--%>


<%--<!-- Bootstrap core JavaScript--%>
<%--================================================== -->--%>
<%--<!-- Placed at the end of the document so the pages load faster -->--%>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>--%>
<%--<script src="../bootstraps/js/bootstrap.min.js"></script>--%>
<%--<script src="../../assets/js/docs.min.js"></script>--%>


<%--<iframe frameborder="0" scrolling="no" style="background-color: transparent; border: 0px; display: none;"></iframe>--%>
<%--<div id="GOOGLE_INPUT_CHEXT_FLAG" input="null" input_stat="{&quot;tlang&quot;:null,&quot;tsbc&quot;:null,&quot;pun&quot;:null,&quot;mk&quot;:false,&quot;ss&quot;:true}" style="display: none;"></div>--%>
<%--</body>--%>
<%--</html>--%>
