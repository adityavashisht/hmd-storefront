<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>Hello Order New Page</h3>


<security:authorize access="hasAnyRole('ROLE_USER')">
    <h3>For USERS only</h3>
</security:authorize>

<security:authorize access="hasAnyRole('ROLE_ADMIN')">
<h2>For ADMIN only</h2>
</security:authorize>


</body>
</html>
