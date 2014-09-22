<%--
  Created by IntelliJ IDEA.
  User: lanshan
  Date: 4/24/14
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*, java.text.*" %>
<%@include file="/basePath.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="bootstraps/js/bootstrap.min.js"></script>

<html lang="en"><head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <%--<link rel="shortcut icon" href="../../assets/ico/favicon.ico">--%>

    <title>Starter Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="bootstraps/css/starter-template.css" rel="stylesheet">
    <link href="../bootstraps/css/signin.css" rel="stylesheet">


</head>

<body>
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Restaurant</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<%=basePath%>redirect2Index.jsp">Home</a></li>
                <li><a href="showMenuByGenres.action">Menu</a></li>
                <li><a href="contact.jsp">Contact</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <%
                    Map map = ActionContext.getContext().getSession();
                    if(map.containsKey("userId")){
                        String userName = (String) map.get("username");
                %>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Welcome: <%=userName%><b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <%
                            if(map.containsKey("orderId")){
                        %>
                        <li><a href="showShoppingCar.action">Unfinished Car</a> </li>
                        <li class="divider"></li>
                        <%
                            }
                        %>
                        <li><a href="userCheckOrders.action">My Orders</a></li>
                        <li class="divider"></li>
                        <li><a href="userPages/updateUserInfos.jsp">Update informations</a></li>
                        <li><a href="userPages/reservation.jsp">Reservation</a></li>
                        <li><a href="deleteUser.action">Unregistered</a></li>
                    </ul>
                </li>
                <li><a href="userLogout.action">Sign out</a></li>
                <%}else{%>
                <li><a href="<%=basePath%>userPages/login.jsp">Sign in</a></li>
                <li><a href="<%=basePath%>userPages/register.jsp">Sign up</a></li>
                <li><a href="<%=basePath%>ManagerPages/ManagerLogin.jsp">Admin</a></li>
                <%
                    }
                %>

            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>


<form action="createReservation.action" method="post" id="sel_date" role="form" class="form-group">
    <s:if test="reservationDates.size() > 0">
        <h2>Reservation</h2>
        <h3>Which day would you prefer?</h3>
        <div class="form-group">
            <select name="rdId" form="sel_date" class="form-control">
                <s:iterator value="reservationDates" status="status">
                    <option value="<s:property value="id"/>"><s:date name="reservationDate" format="yyyy-MM-dd" nice="false"/>
                        <s:property value="seatsReserved"/> seats booked / total: <s:property value="maximumReservations"/> seats
                        <%--"%{users[#status.index].username}--%>
                    </option>
                </s:iterator>
            </select>
        </div>

        <h3>How many people ?</h3>
        <div class="form-group">
            <input type="number" min="1" class="form-control" placeholder="How many people?" name="tableNumber">
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Reserve today!</button>

    </s:if>
</form>
<s:else>
    <div class="jumbotron">
        <h1 align="center">Sorry!!</h1>
        <h2 align="center">There aren't any tables available right now, check it later!</h2>
        <button class="btn btn-group-lg btn-primary" type="button"  onclick="location='<%=basePath%>redirect2Index.jsp'">Back</button>
    </div>
</s:else>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="bootstraps/js/Jquery.min.js"></script>
<script src="bootstraps/js/bootstrap.min.js"></script>
<script src="bootstraps/js/jquery.js"></script>


<iframe frameborder="0" scrolling="no" style="background-color: transparent; border: 0px; display: none;"></iframe><div id="GOOGLE_INPUT_CHEXT_FLAG" input="null" input_stat="{&quot;tlang&quot;:null,&quot;tsbc&quot;:null,&quot;pun&quot;:null,&quot;mk&quot;:false,&quot;ss&quot;:true}" style="display: none;"></div></body></html>
</body>
</html>
