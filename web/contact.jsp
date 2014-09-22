<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 4/22/14
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="basePath.jsp"%>
<!DOCTYPE html>
<html lang="en"><head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <%--<link rel="shortcut icon" href="../../assets/ico/favicon.ico">--%>

    <!-- Bootstrap core CSS -->
    <link href="bootstraps/css/bootstrap.min.css" rel="stylesheet">

    <%--<!-- Bootstrap core CSS -->--%>
    <%--<link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">--%>

    <!-- Custom styles for this template -->
    <link href="bootstraps/css/starter-template.css" rel="stylesheet">


    <title>Contacts</title>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
        html { height: 100% }
        body { height: 100%; margin: 0; padding: 0 }
        #map_canvas { height: 100% }
    </style>
    <script type="text/javascript"
            src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBTSFOY-6psHGnli8bdrcgBMvOZZ-qbAHw&sensor=true">
    </script>
    <script type="text/javascript">
        function initialize() {
            var mapOptions = {
                center: new google.maps.LatLng(42.338718, -71.092163),
                zoom: 18,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            var map = new google.maps.Map(document.getElementById("map_canvas"),
                    mapOptions);
        }
    </script>
</head>
<body onload="initialize()">

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
                <li><a href="<%=basePath%>redirect2Index.jsp">Home</a></li>
                <li><a href="showMenuByGenres.action">Menu</a></li>
                <li class="active"><a href="/contact.jsp">Contact</a></li>
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
                        <li><a href="preloadAllReservationDateForUser.action">Reservation</a></li>
                        <li class="divider"></li>
                        <li><a href="userPages/updateUserInfos.jsp">Update informations</a></li>
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
<!--==============================header=================================-->
<!--<div id="map_canvas" style="width:100%; height:325px"></div>-->
<div class="container">
    <div class="row marketing" style="margin-top: 100px"><br>
        <h1 align="left">Contact Information</h1>
        <div class="row marketing"><br>
            <div class="col-lg-6"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12 col-md-12">
            <div id="map_canvas" style="width:100%; height:325px"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-3 col-md-3 col-sm-3 col-md-offset-1">
            <h4 align="left">Address </h4>
            <p align="left">Northeastern Univ. <br>
                360 Huntington Ave,<br>
                Boston, MA, 02115. </p>

            <h4 align="left">Freephone </h4>
            <p align="left">+1 857 264 6113 </p>

            <h4 align="left">Telephone  </h4>
            <p align="left">+1 857 264 6113 </p>


            <h4 align="left">FAX: </h4>
            <p align="left">+1 857 264 6113 </p>

            <h4 align="left">E-mail </h4>
            <p align="left">
                <a href="mailto:yan.t@husky.neu.edu" class="col2">yan.t@husky.neu.edu</a>
            </p>

        </div>
        <div class="col-md-7 col-lg-7 col-sm-5 col-md-offset-1 col-sm-offset-2">
            <h4 align="left">Leave us messages!</h4>
            <form class="form-horizontal" role="form" action="createMessage.action" method="post">
                <div class="form-group">
                    <div class="col-lg-7 col-md-7 col-sm-9">
                        <input type="text" class="form-control" placeholder="Title" name="title">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-7 col-md-7 col-sm-9">
                        <textarea class="form-control" rows="8" name="message"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-7 col-md-7 col-sm-9">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!--==============================footer=================================-->




<hr class="featurette-divider">

<!-- /END THE FEATURETTES -->


<!-- FOOTER -->
<footer>
    <p class="pull-right"><a href="#">Back to top</a></p>
    <p>© 2014 Company, Inc. · <a href="#">Privacy</a> · <a href="#">Terms</a></p>
</footer>
<script src="js/map.js"></script>
<script src="bootstraps/js/Jquery.min.js"></script>
<script src="bootstraps/js/bootstrap.min.js"></script>
<script src="bootstraps/js/jquery.js"></script>


</body>
