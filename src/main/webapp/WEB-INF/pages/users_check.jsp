<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Timur Babich
  Date: 25.10.2017
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <spring:form modelAttribute="userfromserver" method="post" action="/ucs/users/check">
        <spring:input path="login" />
        <spring:input path="password"/>
        <spring:button>Check</spring:button>
    </spring:form>

</body>
</html>
