<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 4/24/14
  Time: 9:55
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
            <a class="navbar-brand" href="#">Restaurant</a>
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
                <li><a href="findAllUsers.action">Show Users</a></li>
                <li><a href="findAllUsersForDelete.action">Delete User</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li class="active"><a href="managerCheckMessagesForUpdate.action">Check Messages</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="managerShowDeliveries.action">Check Delivery</a></li>
                <li><a href="<%=basePath%>ManagerPages/ManagerAddReservationDate.jsp">Add ReservationDate</a></li>
                <li><a href="showAllReservationDate.action">Check ReservationDate</a></li>
                <li><a href="showAllReservationForUpdateAndDelete.action">Check Reservations</a></li>

            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">All Messages</h1>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr align="center">
                        <td align="center">id</td>
                        <td align="center">username</td>
                        <td align="center">title</td>
                        <td align="center">content</td>
                        <td align="center">date</td>
                        <td align="center">status</td>
                        <td align="center">newStatus</td>
                        <td align="center">update</td>
                    </tr>
                    <s:iterator value="messages" status="status">
                    <tr>
                        <td align="center"><s:property value="id"/></td>
                        <td align="center"><s:property value="%{users[#status.index].username}"/></td>
                        <td align="center"><s:property value="title"/></td>
                        <td align="center"><s:property value="message"/> </td>
                        <td align="center"><s:date name="dateOfCreated" format="yyyy-MM-dd" nice="false"></s:date> </td>
                        <td align="center"><s:property value="status"/> </td>
                        <td align="center">
                            <select form="<s:property value="id"/> " name="status">
                                <option value="Unread">Unread</option>
                                <option value="Read">Read</option>
                            </select>
                        </td>
                        <form action="managerUpdateMessage.action" method="post" id="<s:property value="id"/> ">
                            <td align="center"><input type="submit" value="update"></td>
                            <input type="hidden" name="id" value="<s:property value="id"/>">
                        </form>
                    </tr>
                    </s:iterator>
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


<iframe frameborder="0" scrolling="no" style="background-color: transparent; border: 0px; display: none;"></iframe>
<div id="GOOGLE_INPUT_CHEXT_FLAG" input="null" input_stat="{&quot;tlang&quot;:null,&quot;tsbc&quot;:null,&quot;pun&quot;:null,&quot;mk&quot;:false,&quot;ss&quot;:true}" style="display: none;"></div></body></html>
