<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 4/17/14
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="../basePath.jsp"%>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <%--<link rel="shortcut icon" href="../../assets/ico/favicon.ico">--%>

    <!-- Bootstrap core CSS -->
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../bootstraps/css/starter-template.css" rel="stylesheet">

    <title>Menu</title>
    <meta charset="utf-8">
    <link rel="icon" href="../images/favicon.ico">
    <link rel="shortcut icon" href="../images/favicon.ico" />
    <link rel="stylesheet" href="../bootstraps/css/touchTouch.css">
    <link rel="stylesheet" href="../bootstraps/css/style.css">
    <link rel="stylesheet" href="../bootstraps/css/self.css">
    <script src="../bootstraps/js/Jquery.min.js"></script>
    <script src="../bootstraps/js/bootstrap.min.js"></script>
    <script src="../bootstraps/js/jquery.js"></script>
    <script src="../bootstraps/js/jquery.js"></script>
    <script src="../bootstraps/js/jquery-migrate-1.1.1.js"></script>
    <script src="../bootstraps/js/jquery.equalheights.js"></script>
    <script src="../bootstraps/js/jquery.ui.totop.js"></script>
    <script src="../bootstraps/js/jquery.tabs.min.js"></script>
    <script src="../bootstraps/js/touchTouch.jquery.js"></script>
    <script src="../bootstraps/js/jquery.easing.1.3.js"></script>
    <script>
        $(document).ready(function(){

            $().UItoTop({ easingType: 'easeOutQuart' });
            $('.gallery a.gal').touchTouch();

        })
    </script>

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
            <a class="navbar-brand" style="font-size: 18px; margin-bottom: 0px;" href="#">Restaurant</a>

        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav" style="font-size: 14px; margin-bottom: 0px;">
                <li><a href="<%=basePath%>redirect2Index.jsp">Home</a></li>
                <li class="active" style="font-size: 14px"><a href="showMenuByGenres.action">Menu</a></li>
                <li style="font-size: 15px"><a href="<%=basePath%>contact.jsp">Contact</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right" style="font-size: 14px; margin-bottom: 0px;">
                <%
                    Map map = ActionContext.getContext().getSession();
                    if(map.containsKey("userId")){
                        String userName = (String) map.get("username");
                %>
                <li class="dropdown" style="font-size: 14px">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Welcome: <%=userName%><b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <%
                            if(map.containsKey("orderId")){
                        %>
                        <li><a href="showShoppingCar.6.action">Unfinished Car</a> </li>
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


<!--==============================Content=================================-->

<div class="content"><div class="ic"></div>
    <div class="container_12">
        <div class="grid_12">
            <h3 class="head2">Our Menu</h3>
        </div>

        <div class="tabs tb gallery">
            <div class="div-nav  ">
                <div class="grid_12">
                    <ul class="nav">
                        <%
                            Map map_menu = ActionContext.getContext().getSession();
                            String genreName = (String) map_menu.get("genreName");
                            map_menu.remove("genreName");

                            int genre_size = Integer.parseInt((String)map_menu.get("genre_size"));
                            List<String> genre_Name = new ArrayList<String>();
                            List<Integer> genre_Id = new ArrayList<Integer>();
                            String s = null;
                            String genreName_t = null;
                            int genreId_t = 0;

                            for(int i = 0; i < genre_size; i++) {
                                s = String.valueOf(i);
                                try {
                                    genreName_t = (String) map_menu.get("genreName_" + s);
                                    genre_Name.add(genreName_t);
                                    map_menu.remove("genreName_" + s);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                try {
                                    genreId_t = Integer.parseInt((String) map_menu.get("genreId_" + s));
                                    genre_Id.add(genreId_t);
                                    map_menu.remove("genreId_" + s);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            for(int i = 0; i < genre_size; i++)
                                if(genreName.equals(genre_Name != null ? genre_Name.get(i) : "Error")){
                        %>
                        <li style="margin: 0 11px; display: inline-block; font: 18px/20px 'Open Sans', sans-serif;">
                            <input type="submit" value="<%=genre_Name.get(i)%>" class="button_sel"/>
                        </li>
                        <%} else {%>
                        <li style="margin: 0 11px; display: inline-block; font: 18px/20px 'Open Sans', sans-serif;">
                            <form action="showMenuByGenres.action" method="post">
                                <input type="hidden" name="genreId" value="<%=genre_Id != null ? genre_Id.get(i) : 0%>"/>
                                <input type="submit" value="<%=genre_Name.get(i)%>" class="button"/>
                            </form> </li>
                        <%}
                            map_menu.remove("genre_size");
                        %>
                        <li class="selected" style="margin: 0 11px; display: inline-block; font: 18px/20px 'Open Sans', sans-serif;">
                            <a href="#tab-1" class=""></a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="div-tabs">
                <div id="tab-1" class="tab-content gallery1">
                    <s:iterator value="listOfMenu">
                        <div class="grid_3">
                            <a href="<%=basePath%>menuImages/<s:property value="imageURL"/>" class="gal"><img src="<%=basePath%>menuImages/<s:property value="imageURL"/>" alt=""><span></span></a>
                            <div class="col2"><span class="col3">
                                <form action="findFood.action" method="post">
                                    <input type="hidden" name="id" value="<s:property value="id"/>"/>
                                    <input type="submit" value="<s:property value="name"/>" class="button"/>
                                </form>
                                    </span>$<s:property value="price"/></div>
                            <div>
                            </div>
                        </div>
                    </s:iterator>
                </div>
            </div>
        </div>
    </div>
    <footer>
        <hr class="featurette-divider">
        <p style="float: right"><a href="#">Back to top</a></p>
        <p>© 2014 Company, Inc. · <a href="#">Privacy</a> · <a href="#">Terms</a></p>
    </footer>
</div>
</body>
</html>
