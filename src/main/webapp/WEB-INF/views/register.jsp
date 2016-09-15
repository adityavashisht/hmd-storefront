<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form modelAttribute="registerForm"  method="post">

    <form:input path="customer.firstName"/>
    <br/>
    <form:input path="customer.lastName"/>
    <br/>
    <form:input path="customer.email"/>


    <br/>
    <input type="submit" value="Register">
</form:form>


</body>
</html>