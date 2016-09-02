<%@include file="includes.jsp" %>
<%@include file="header.jsp" %>


<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form:form name="orderForm" modelAttribute="orderForm">







                <div class="row">
                    <div class="col-md-6">
                        <h3 class="page-header">Customer
                            <small>Add your info here</small>
                        </h3>
                        <div class="form-group">
                            <label class="control-label">
                                First Name
                            </label>
                            <form:input cssClass="form-control" path="order.customer.firstName"/>
                        </div>

                        <div class="form-group">
                            <label class="control-label">
                                Last Name
                            </label>
                            <form:input cssClass="form-control" path="order.customer.lastName"/>
                        </div>

                        <div class="form-group">
                            <label class="control-label">
                                Email
                            </label>
                            <form:input cssClass="form-control" path="order.customer.email"/>
                        </div>



                    </div>
                    <div class="col-md-6">
                        <h3 class="page-header"> Items</h3>
                    </div>

                   <div class="row">
                       <div class="col-md-4">
                           <div class="form-group">
                               <label class="control-label">
                                   Item Name
                               </label>
                               <form:input cssClass="form-control" path="items[0].itemName"/>
                           </div>

                       </div>
                       <div class="col-md-4">

                           <div class="form-group">
                               <label class="control-label">
                                   Quantity
                               </label>
                               <form:input cssClass="form-control" path="items[0].quantity"/>
                           </div>

                       </div>
                       <div class="col-md-4">

                           <div class="form-group">
                               <label class="control-label">
                                   Wrap?
                               </label>
                               <form:checkbox cssClass="form-control" path="items[0].giftWrap"/>
                           </div>

                       </div>
                   </div>


                </div>


                <hr/>
                <div class="row" style="margin-top:20px;">
                    <div class="col-md-12 text-center">
                        <input type="submit" value="Save and Preview Order" class="btn btn-success btn-large"/>
                    </div>
                </div>



            </form:form>

        </div>
    </div>
</div>


<%@include file="footer.jsp" %>