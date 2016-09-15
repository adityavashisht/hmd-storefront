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
    <form:errors path="customer.firstName" cssClass="error" />
    <br/>
    <br/>
    <form:input path="customer.lastName"/>
    <form:errors path="customer.lastName" cssClass="error" />
    <br/>
    <br/>
    <form:input path="customer.email"/>
    <form:errors path="customer.email" cssClass="error" />
    <br/>
    <br/>
    <form:input path="customer.birthDate"/>
    <form:errors path="customer.birthDate" cssClass="error" />


    <br/>
    <input type="submit" value="Register">
</form:form>


</body>
</html>
