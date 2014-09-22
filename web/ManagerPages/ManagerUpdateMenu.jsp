<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 4/20/14
  Time: 15:03
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
    <link href="../bootstraps/css/dashboard.css" rel="stylesheet" />
    <link href="../bootstraps/css/upload.css" rel="stylesheet" />

    <style id="holderjs-style" type="text/css"></style>
    <%--<script src="../bootstraps/js/Jquery.min.js"></script>--%>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>

</head>
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
                <li class="active"><a href="findAllMenuForUpdate.action">Update Menu</a></li>
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
            <h1 class="page-header">Update Menu</h1>
            <div class="table-responsive">
                <form class="form-horizontal" action="updateMenu.action" method="post" enctype="multipart/form-data" id="saveMenuForm">
                    <fieldset>
                        <%
                            map = ActionContext.getContext().getSession();
                            String manuName = (String) map.get("menuName");
                        %>
                        <legend>Menu:<%=manuName%></legend>
                        <div class="form-group">
                            <label for="inputName" class="col-lg-2 control-label">Name</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="inputName" placeholder="Name" name="name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPrice" class="col-lg-2 control-label">Price</label>
                            <div class="col-lg-10">
                                <input type="number" class="form-control" id="inputPrice" placeholder="Price" name="price" min="0">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="textArea" class="col-lg-2 control-label">Descriptions</label>
                            <div class="col-lg-10">
                                <textarea class="form-control" rows="8" id="textArea" name="description"></textarea>
                                <span class="help-block">  </span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="genre" class="col-lg-2 control-label">Genre</label>
                            <div class="col-lg-10">
                                <select name="genreId" form="saveMenuForm" multiple="" class="form-control" id="genre">
                                    <s:iterator value="genres">
                                        <option value="<s:property value="id"/>"><s:property value="name"/></option>
                                    </s:iterator>
                                </select>
                                <span class="help-block">  </span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="Image" class="col-lg-2 control-label">Image</label>
                            <div class="col-lg-10">
                                <div class="input-group">
					            <span class="input-group-btn">
						            <span class="btn btn-primary btn-file">
							            Browse… <input type="file" multiple="" name="image" id="Image">
						            </span>
					            </span>
                                    <input type="text" class="form-control" readonly>
                                </div>
                            </div>

                        </div>
                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-2">
                                <button onclick="location='updateMenu.action'" class="btn btn-default" type="reset">Cancel</button>
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
                <%----%>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

<script src="../bootstraps/js/bootstrap.min.js"></script>
<script src="../bootstraps/js/docs.min.js"></script>



