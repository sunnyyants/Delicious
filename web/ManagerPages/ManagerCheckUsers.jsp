<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 4/20/14
  Time: 18:27
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
            <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <%
                    Map map = ActionContext.getContext().getSession();
                    String managerName = (String) map.get("managerName");
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
                <li><a href="controlPannelPreload.action">Overview</a></li>
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
                <li class="active"><a href="findAllUsers.action">Show Users</a></li>
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
            <h1 class="page-header">All orders</h1>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
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
                        <%--<td width="100">deletion</td>--%>
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
                            <%--<form action="deleteSelectUser.action" method="post">--%>
                                <%--<input type="hidden" name="id" value="<s:property value="id"/>"/>--%>
                                <%--<td width="100"><input type="submit" value="delete"/></td>--%>
                            <%--</form>--%>
                        </tr>
                    </s:iterator>
                    </thead>
                </table>
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