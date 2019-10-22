<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mbeta
  Date: 18.10.2019
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring REST File Upload</title>
</head>
<body>
<form:form method="POST" action="/spring-mvc-basics/addEmployee"
           modelAttribute="employee">
    <form:label path="name">Name</form:label>
    <form:input path="name" />

    <form:label path="id">Id</form:label>
    <form:input path="id" />

    <input type="submit" value="Submit" />
</form:form>
</body>
</html>
