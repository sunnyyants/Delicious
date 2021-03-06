
<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 4/12/14
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="../basePath.jsp"%>
<html lang="en"><head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../bootstraps/css/signup.css" rel="stylesheet">
</head>

<%
    Integer userId = (Integer) ActionContext.getContext().getSession().get("userId");
    String userName = (String) ActionContext.getContext().getSession().get("username");
%>
<body style="">
<div class="container">
    <form class="form-signin" role="form" action="updateUserPassWord.action" method="post">
        <h1 class="form-signin-heading">User update informations</h1>
        <h4>user: <%=userName%></h4><h4>userId: <%=userId%></h4><br>
        <h4>Change password</h4>
        <input type="password" class="form-control" placeholder="Password" required="" name="password">
        <input type="password" class="form-control" placeholder="Re-enter Password" required="" name="rePassword">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
    </form>
    <p align="center"><font color="red"><s:actionerror escape="false"/></font></p>
    <s:if test="hasFieldErrors()">
        <p align="center">
            <s:iterator value="fieldErrors">
                <tr>
                    <td style="">
                        <font color="red"><s:property value="value[0]"/></font>
                    </td>
                </tr>
            </s:iterator>
        </p>
    </s:if>
    <form class="form-signin" role="form" action="updateUserInfo.action" method="post">
        <h4>Update user Information</h4>
        <input type="text" class="form-control" placeholder="firstname" required=""  name="firstname">
        <input type="text" class="form-control" placeholder="lastname" required="" name="lastname">
        <input type="text" class="form-control" placeholder="address" required=""  name="address">
        <input type="text" class="form-control" placeholder="zipcode" required="" name="zipcode">
        <input type="text" class="form-control" placeholder="phone" required=""  name="phone">
        <input type="text" class="form-control" placeholder="email" required="" name="email">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
        <button onclick="location='<%=basePath%>redirect2Index.jsp'" class="btn btn-lg btn-primary btn-block" type="button">Cancel</button>
    </form>
</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

<iframe frameborder="0" scrolling="no" style="background-color: transparent; border: 0px; display: none;">
</iframe><div id="GOOGLE_INPUT_CHEXT_FLAG" input="null" input_stat="{&quot;tlang&quot;:null,&quot;tsbc&quot;:null,&quot;pun&quot;:null,&quot;mk&quot;:false,&quot;ss&quot;:true}" style="display: none;"></div></body></html>
</html>
