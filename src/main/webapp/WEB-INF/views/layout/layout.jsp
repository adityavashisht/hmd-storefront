<%@ include file="../includes.jsp" %>
<tiles:insertAttribute name="header"/>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand">Project name</a>
        </div>
        <div class="collapse navbar-collapse" id="navbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="<c:url value="/register"/>">Register</a></li>
                <li><a href="<c:url value="/order"/>">Order</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>


<div class="container">
    <div class="row">
        <div class="col-md-12">
            <tiles:insertAttribute name="body"/>
        </div>

        <div class="col-md-12">
            <hr/>
            <tiles:insertAttribute name="footer"/>
        </div>
    </div>
</div>



</body>


</html>

