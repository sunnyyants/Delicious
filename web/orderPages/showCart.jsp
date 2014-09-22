<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 4/18/14
  Time: 16:57
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
            <td align="center">ID</td>
            <td align="center">name</td>
            <td align="center">description</td>
            <td align="center">image</td>
            <td align="center">price</td>
            <td align="center">genre</td>
            <td align="center">quantities</td>
            <td align="center">new quantities</td>
            <td align="center">update</td>
            <td align="center">delete</td>
            <%--<td width="100">average</td>--%>
            <%--<td width="100">update</td>--%>
            <%--<td width="100">delete</td>--%>
        </tr>
        <s:iterator value="listOfMenus" status="status">
            <tr>
                <td align="center"><s:property value="id"/></td>
                <td align="center"><s:property value="name"/></td>
                <td align="center"><s:property value="description"/></td>
                <td align="center">
                    <img src="<%=basePath%>menuImages/<s:property value="imageURL"/>" width="100" height="100">
                </td>
                <td align="center"><s:property value="price"/> </td>
                <td align="center"><s:property value="genreId"/> </td>
                <td align="center"><s:property value="%{quantities[#status.index]}"/> </td>
                <form action="updateItemQuantity.action" method="post">
                    <input type="hidden" name="id" value="<s:property value="%{itemIds[#status.index]}"/>"/>
                    <td align="center"><input type="number" name="quantity" min="1" value="<s:property value="%{quantities[#status.index]}"/>"/></td>
                    <td align="center"><input type="submit" value="update"/></td>
                </form>
                <form action="deleteItem.action" method="post">
                    <input type="hidden" name="id" value="<s:property value="%{itemIds[#status.index]}"/>"/>
                    <td align="center"><input type="submit" value="delete"></td>
                </form>
            </tr>
        </s:iterator>
        <tr>
            <td>
                <form action="orderCheckout.action" method="post">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="deliver" value="true">Delivery?
                        </label>
                    </div>
                    <input type="submit" value="Check out.." class="btn btn-lg btn-primary"/>
                </form>
            </td>
            <td>
                <p><a class="btn btn-lg btn-primary" href="showMenuByGenres.action" role="button" style="margin-top: 42px">Continue shopping..</a></p>
            </td>
            <td>
                <p><a class="btn btn-lg btn-primary" href="deleteOrder.action" role="button" style="margin-top: 42px">Cancel Order..</a></p>
            </td>
            <%--<a href="showMenuByGenres.action"><input type="button" value="continue shopping"></a></td>--%>
            <%--<td><a href="orderCheckout.action"><input type="button" value="check out"/> </a> </td>--%>
            <%--<td><a href="deleteOrder.action"><input type="button" value="cancel"></a></td>--%>
        </tr>
        </thead>
    </table>
    <%--<p>--%>
    <%--<a class="btn btn-lg btn-primary" href="<%=basePath%>redirect2Index.jsp" role="button">Back to Home »</a>--%>
    <%--</p>--%>
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
  <%--Time: 16:57--%>
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
        <%--<td align="center">ID</td>--%>
            <%--<td align="center">name</td>--%>
            <%--<td align="center">description</td>--%>
            <%--<td align="center">image</td>--%>
            <%--<td align="center">price</td>--%>
            <%--<td align="center">genre</td>--%>
            <%--<td align="center">quantities</td>--%>
            <%--<td align="center">new quantities</td>--%>
            <%--<td align="center">update</td>--%>
            <%--<td align="center">delete</td>--%>
            <%--&lt;%&ndash;<td width="100">average</td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<td width="100">update</td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<td width="100">delete</td>&ndash;%&gt;--%>
        <%--</tr>--%>
        <%--<s:iterator value="listOfMenus" status="status">--%>
            <%--<tr>--%>
                <%--<td align="center"><s:property value="id"/></td>--%>
                <%--<td align="center"><s:property value="name"/></td>--%>
                <%--<td align="center"><s:property value="description"/></td>--%>
                <%--<td align="center">--%>
                    <%--<img src="<%=basePath%>menuImages/<s:property value="imageURL"/>" width="100" height="100">--%>
                <%--</td>--%>
                <%--<td align="center"><s:property value="price"/> </td>--%>
                <%--<td align="center"><s:property value="genreId"/> </td>--%>
                <%--<td align="center"><s:property value="%{quantities[#status.index]}"/> </td>--%>
                <%--<form action="updateItemQuantity.action" method="post">--%>
                    <%--<input type="hidden" name="id" value="<s:property value="%{itemIds[#status.index]}"/>"/>--%>
                    <%--<td align="center"><input type="number" name="quantity" min="1" value="<s:property value="%{quantities[#status.index]}"/>"/></td>--%>
                    <%--<td align="center"><input type="submit" value="update"/></td>--%>
                <%--</form>--%>
                <%--<form action="deleteItem.action" method="post">--%>
                    <%--<input type="hidden" name="id" value="<s:property value="%{itemIds[#status.index]}"/>"/>--%>
                    <%--<td align="center"><input type="submit" value="delete"></td>--%>
                <%--</form>--%>
            <%--</tr>--%>
        <%--</s:iterator>--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<p><a class="btn btn-lg btn-primary" href="showMenuByGenres.action" role="button">Continue shopping..</a></p>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<p><a class="btn btn-lg btn-primary" href="orderCheckout.action" role="button">Check out..</a></p>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<p><a class="btn btn-lg btn-primary" href="deleteOrder.action" role="button">Cancel Order..</a></p>--%>
            <%--</td>--%>
                <%--&lt;%&ndash;<a href="showMenuByGenres.action"><input type="button" value="continue shopping"></a></td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<td><a href="orderCheckout.action"><input type="button" value="check out"/> </a> </td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<td><a href="deleteOrder.action"><input type="button" value="cancel"></a></td>&ndash;%&gt;--%>
        <%--</tr>--%>
        <%--</thead>--%>
    <%--</table>--%>
    <%--&lt;%&ndash;<p>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<a class="btn btn-lg btn-primary" href="<%=basePath%>redirect2Index.jsp" role="button">Back to Home »</a>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</p>&ndash;%&gt;--%>
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
