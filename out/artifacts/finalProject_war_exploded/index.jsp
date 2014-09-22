
<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 4/4/14
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/basePath.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="bootstraps/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="bootstraps/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->

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
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class=""></li>
        <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="2" class=""></li>
    </ol>
    <div class="carousel-inner">
        <div class="item">
            <div align="center"><img  alt="First slide" src="<%=basePath%>menuImages/3a.jpg"></div>
            <div class="container">
                <div class="carousel-caption">
                    <h1>Work Hours</h1>
                    <p>Open every day at 10:00 am</p>
                    <p>Weekdays open to 9:00 pm</p>
                    <p>Weekends open to 10:00 pm</p>
                    <p><a class="btn btn-lg btn-primary" href="<%=basePath%>userPages/register.jsp" role="button">Sign up today</a></p>
                </div>
            </div>
        </div>
        <div class="item active">
            <div align="center"><img  alt="Second slide" src="<%=basePath%>menuImages/3b.jpg"></div>
            <div class="container">
                <div class="carousel-caption">
                    <h1>Welcome</h1>
                    <p>Welcome to our Restaurant.</p>
                    <%--<p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>--%>
                </div>
            </div>
        </div>
        <div class="item">
            <div align="center"><img alt="Third slide" src="<%=basePath%>menuImages/4b.jpg"></div>
            <div class="container">
                <div class="carousel-caption">
                    <h1>One more for good foods.</h1>
                    <p>Please feel free to browsing our website and order our dishes.</p>
                    <p><a class="btn btn-lg btn-primary" href="showMenuByGenres.action" role="button">Browse Menus</a></p>
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
</div>

<div class="container">

    <div class="starter-template">
        <h1>Welcome to our restaurant</h1>
        <p class="lead">Here is the three most popular dishes in our restaurant.<br>
            Welcome and please keep browsing our site and make an order!</p>

    </div>
    <div class="container marketing">

        <!-- Three columns of text below the carousel -->
        <div class="row">
            <s:iterator value="listOfMenu" >
                <div class="col-lg-4" align="center">
                    <img class="img-circle" data-src="holder.js/300x300" alt="300x300" src="<%=basePath%>menuImages/<s:property value="imageURL"/>" style="width: 250px; height:250px;">
                    <h2><s:property value="name"/></h2>
                    <p>$ <s:property value="price"/></p>
                        <%--<p><a class="" </p>--%>
                </div>
            </s:iterator>
        </div><!-- /.row -->
        <hr class="featurette-divider">

        <!-- /END THE FEATURETTES -->

        <!-- FOOTER -->
        <footer>
            <p class="pull-right"><a href="#">Back to top</a></p>
            <p>© 2014 Company, Inc. · <a href="#">Privacy</a> · <a href="#">Terms</a></p>
        </footer>

    </div>

</div><!-- /.container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="bootstraps/js/Jquery.min.js"></script>
<script src="bootstraps/js/bootstrap.min.js"></script>
<script src="bootstraps/js/jquery.js"></script>



<iframe frameborder="0" scrolling="no" style="background-color: transparent; border: 0px; display: none;"></iframe><div id="GOOGLE_INPUT_CHEXT_FLAG" input="null" input_stat="{&quot;tlang&quot;:null,&quot;tsbc&quot;:null,&quot;pun&quot;:null,&quot;mk&quot;:false,&quot;ss&quot;:true}" style="display: none;"></div></body></html>

