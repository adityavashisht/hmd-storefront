<%@ include file="includes.jsp" %>


<h3 class="page-header">Register
    <small>New Customer</small>
</h3>
<form:form modelAttribute="registerForm" method="post" cssClass="form-horizontal">
    <div class="row">
        <div class="col-md-6 col-md-offset-2 col-sm-12">


            <div class="form-group">
                <label for="firstName">First Name</label>
                <form:input id="firstName" path="customer.firstName" cssClass="form-control"/>
                <form:errors path="customer.firstName" cssClass="error"/>
            </div>

            <div class="form-group">
                <label for="lastName">Last Name</label>
                <form:input id="lastName" path="customer.lastName" cssClass="form-control"/>
                <form:errors path="customer.lastName" cssClass="error"/>
            </div>


            <div class="form-group">
                <label for="email">Email</label>
                <form:input id="email" path="customer.email" cssClass="form-control"/>
                <form:errors path="customer.email" cssClass="error"/>
            </div>

            <div class="form-group">
                <label for="birthDate">

                    Date of birth
                </label>
                <form:input id="birthDate" path="customer.birthDate" cssClass="form-control"/>
                <span id="birthDate-error" class="hidden ajaxError"></span>
            </div>


        </div>
    </div>

    <div class="row">
        <div class="col-md-offset-2">
            <button id="register" type="button" class="btn btn-success">Register</button>
        </div>
    </div>

</form:form>


<script type="text/javascript">

    // When page loads call this code
    $(function () {

        $("#register").on("click", function () {

            console.log("I Clicked the button");
            var formData = $("#registerForm").serialize();

            $.ajax({
                url: "<spring:url value="/register/ajax"/>",
                type: "POST",
                data: formData,
                success: function (result) {
                    var errorMessages = result.errorMessages;
                    if (errorMessages != undefined && errorMessages.length > 0) {
                        $.each(errorMessages, function (key, value) {
                            var obj = value;
                            var id = "#" + obj.field;
                            var error = id + "-error";

                            $(id).parent().addClass("has-error");

                            $(error).empty();
                            $(error).removeClass("hidden").addClass("visible");
                            $(error).html(obj.message);
                        });
                    }
                }});
        });


    });

</script>


