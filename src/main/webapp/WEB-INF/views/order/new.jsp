<%@ include file="../includes.jsp" %>

<div class="container">

    <div class="starter-template">
        <h3>Hello Order New Page</h3>
        <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a mostly barebones HTML document.</p>
    </div>

    <div class="row">
        <div class="col-md-12">
            <security:authorize access="hasAnyRole('ROLE_USER')">
                <h3>For USERS only</h3>
            </security:authorize>

            <security:authorize access="hasAnyRole('ROLE_ADMIN')">
                <h2>For ADMIN only</h2>
            </security:authorize>
        </div>
    </div>
</div>







