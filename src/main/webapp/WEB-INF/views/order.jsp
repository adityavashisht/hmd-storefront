<%@include file="includes.jsp"%>
<%@include file="header.jsp"%>


<form:form  name="orderForm" modelAttribute="orderForm">

    <h2>Customer</h2>
    <form:input path="order.customer.firstName"/>
    <form:input path="order.customer.lastName"/>
    <form:input path="order.customer.email"/>

    <input type="submit" value="Save"/>

</form:form>


<%@include file="footer.jsp"%>