<%--
  Created by IntelliJ IDEA.
  User: Sunny
  Date: 4/14/14
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="../basePath.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Menu List</h1>
<table text-align:left>
    <tr><td width="100">ID</td>
        <td width="100">name</td>
        <td width="100">description</td>
        <td width="100">image</td>
        <td width="100">price</td>

    </tr>
    <%--<form action="insertLineItems.action" method="POST">--%>
    <s:iterator value="listOfMenu" status="stat">
        <tr>
            <td width="100"><s:property value="id"/></td>
            <form action="findFood.action" method="post" name="<s:property value="id"/>">
                <input type="hidden" name="id" value="<s:property value="id"/>"/>
                <td><input type="submit" value="<s:property value="name"/>"></td>
            </form>
            <%--<td width="100"><s:property value="name"/></td>--%>
            <td width="100"><s:property value="description"/></td>
            <td width="100">
                <img src="<%=basePath%>menuImages/<s:property value="imageURL"/>" width="100" height="100">
            </td>
            <td width="100"><s:property value="price"/> </td>

        </tr>
    </s:iterator>
    </form>
</table>
<%
    Map map = ActionContext.getContext().getSession();
    if(map.containsKey("orderId")){
        %>
    <a href="deleteOrder.action"><input type="button" value="cancel"/></a>
        <%
    }else{
        %>

    <a href="<%=basePath%>index.jsp"><input type="button" value="back"></a>
<%
    }
%>
</body>
</html>
