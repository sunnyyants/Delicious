<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 4/18/14
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="../basePath.jsp"%>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="../bootstraps/js/bootstrap.min.js"></script>
    <link href="../bootstraps/css/jumbotron-narrow.css" rel="stylesheet">
    <title></title>
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
        <div class="collapse navbar-collapse" >
            <ul class="nav navbar-nav">
                <li><a href="<%=basePath%>/redirect2Index.jsp">Home</a></li>
                <li class="active"><a href="showMenuByGenres.action">Menu</a></li>
                <li><a href="<%=basePath%>contact.jsp">Contact</a></li>
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
<div class="container" style="margin-top: 100px">
    <div class="jumbotron" >
        <img src="<%=basePath%>menuImages/<s:property value="imageURL"/> "/>
    </div>
    <div class="row marketing">
        <div class="col-lg-6">
            <h4>Food's Name: <s:property value="name"/></h4>
            <p> </p>

            <h4>Food's Id: <s:property value="id"/></h4>
            <p> </p>

            <h4>Sell Price: $<s:property value="price"/> </h4>
            <p> </p>


            <h4>Average Popularities: <s:property value="average"/>/5</h4>
            <p> </p>

            <h4>Please Grade Me...</h4>
            <p>
                <select name="score" form="grade" class="form-control">
                    <option value="5">5</option>
                    <option value="4">4</option>
                    <option value="3">3</option>
                    <option value="2">2</option>
                    <option value="1">1</option>
                </select>
            <form action="createLike.action" method="post" id="grade">
                <%--<input type="submit" value="grade">--%>
                <button type="submit" class="btn btn-primary">Grade</button>
                <input type="hidden" name="menuId" value="<s:property value="id"/>"/>
            </form>
            </p>

        </div>
        <div class="col-lg-6">
            <h4>Description</h4>
            <p><s:property value="description"/> </p>
            </p>

            <h4>Order me Now!</h4>
            <p>
            <form action="createOrder.action" method="post">
                <input type="hidden" name="menuId" value="<s:property value="id"/>"/>
                <button type="submit" class="btn btn-primary">Order</button>
            </form>
            </p>
        </div>
    </div>
</div>
</body>
</html>
