<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 4/19/14
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link href="../bootstraps/css/bootstrap.min_cp.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../bootstraps/css/dashboard.css" rel="stylesheet">

    <style id="holderjs-style" type="text/css"></style></head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Restaurant</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <%
                    Map map = ActionContext.getContext().getSession();
                    String managerName = (String) map.get("managerName");
                    Long newOrder = (Long) map.get("numberOfTodayOrder");
                    Long pending = (Long) map.get("numberOfPending");
                    Long rfp = (Long) map.get("numberOfRFP");
                    Double totals = (Double) map.get("totalIncome");
                    Long unread = (Long)map.get("numberOfUnreadMessages");
                    Long reservations = (Long)map.get("numberOfTotalReservations");
                    Long deliveries = (Long)map.get("numberOfDeliveries");
                %>
                <li><a href="#">Hello Administrator: </a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=managerName%><b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="<%=basePath%>ManagerPages/updateManagerInfos.jsp">Update informations</a></li>
                    </ul>
                </li>
                <li><a href="managerLogout.action">Sign out</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href=controlPannelPreload.action>Overview</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="managerCheckOrders.action">Show All orders</a></li>
                <li><a href="managerUpdateOrders.action">Update orders' status</a></li>
                <li><a href="managerCheckOrderForDelete.action">Delete orders</a></li>
            </ul>

            <ul class="nav nav-sidebar">
                <li><a href="findAllMenus.action">Show Menus</a></li>
                <li><a href="preLoadAllGenres.action">Create Menu</a></li>
                <li><a href="findAllMenuForDelete.action">Delete Menu</a></li>
                <li><a href="findAllMenuForUpdate.action">Update Menu</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="findAllGenre.action">Show Genres</a></li>
                <li><a href="<%=basePath%>ManagerPages/ManagerCreateGenre.jsp">Create Genre</a></li>
                <li><a href="findAllGenreForDelete.action">Delete Genre</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="findAllUsers.action">Show Users</a></li>
                <li><a href="findAllUsersForDelete.action">Delete User</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="managerCheckMessagesForUpdate.action">Check Messages</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="managerShowDeliveries.action">Check Delivery</a></li>
                <li><a href="<%=basePath%>ManagerPages/ManagerAddReservationDate.jsp">Add ReservationDate</a></li>
                <li><a href="showAllReservationDate.action">Check ReservationDate</a></li>
                <li><a href="showAllReservationForUpdateAndDelete.action">Check Reservations</a></li>

            </ul>

        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Dashboard</h1>

            <div class="row placeholders">
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img data-src="holder.js/200x200/auto/sky" class="img-responsive" alt="" src="<%=basePath%>menuImages/blue.jpg">
                    <h1 style="margin-top:-115px; margin-bottom: 115px; color: snow"><%=newOrder%></h1>
                    <h2>New orders</h2>
                    <span class="text-muted">Today's new orders</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="" src="<%=basePath%>menuImages/orange.jpg">
                    <h1  style="margin-top:-115px; margin-bottom: 115px; color: snow"><%=pending%></h1>
                    <h2>Pending</h2>
                    <span class="text-muted">Total Pending orders</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img data-src="holder.js/200x200/auto/sky" class="img-responsive" alt="" src="<%=basePath%>menuImages/green.jpg">
                    <h1 style="margin-top:-115px; margin-bottom: 115px; color: snow"><%=rfp%></h1>
                    <h2>Ready for pick up</h2>
                    <span class="text-muted">Total orders which is ready for pick up</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="" src="<%=basePath%>menuImages/red.jpg">
                    <h1 style="margin-top:-115px; margin-bottom: 115px; color: snow">$<%=totals%></h1>
                    <h2>Incomes</h2>
                    <span class="text-muted">Total in which count from completed orders</span>
                </div><br>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="" src="<%=basePath%>menuImages/red.jpg">
                    <h1 style="margin-top:-115px; margin-bottom: 115px; color: snow"><%=unread%></h1>
                    <h2>Unread Messages</h2>
                    <span class="text-muted">Total number of unread messages</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="" src="<%=basePath%>menuImages/green.jpg">
                    <h1 style="margin-top:-115px; margin-bottom: 115px; color: snow"><%=reservations%></h1>
                    <h2>Total Reservations</h2>
                    <span class="text-muted">Total number of reservation</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="" src="<%=basePath%>menuImages/orange.jpg">
                    <h1 style="margin-top:-115px; margin-bottom: 115px; color: snow"><%=deliveries%></h1>
                    <h2>Deliveries Orders</h2>
                    <span class="text-muted">Total number of order which need to be delivered</span>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="../bootstraps/js/bootstrap.min.js"></script>
<script src="../../assets/js/docs.min.js"></script>


<iframe frameborder="0" scrolling="no" style="background-color: transparent; border: 0px; display: none;"></iframe><div id="GOOGLE_INPUT_CHEXT_FLAG" input="null" input_stat="{&quot;tlang&quot;:null,&quot;tsbc&quot;:null,&quot;pun&quot;:null,&quot;mk&quot;:false,&quot;ss&quot;:true}" style="display: none;"></div></body></html>