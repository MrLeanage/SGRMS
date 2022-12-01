<%-- 
    Document   : index
    Created on : March 16, 2022, 9:31:27 PM
--%>
<%@page import="com.grms.data.model.User"%>
<%@page import="com.grms.data.model.UserValidation"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"
      dir="ltr">


    <head>
        <title>Welcome To GRMS</title>
        <%@include file="../includes/head.jsp"%>
  
    </head>

    <body class="layout-app layout-sticky-subnav ">
        
        <div class="mdk-drawer-layout js-mdk-drawer-layout"
             data-push
             data-responsive-width="992px">
            <!-- // START drawer-layout_content-->
            <div class="mdk-drawer-layout__content page-content">

                <!-- Header -->
                <%@include file="../includes/header.jsp"%>
                <!-- // END Header -->
                <div class="border-bottom-2 py-32pt position-relative z-1">
                    <div class="container-fluid page__container d-flex flex-column flex-md-row align-items-center text-center text-sm-left">
                        <div class="flex d-flex flex-column flex-sm-row align-items-center mb-24pt mb-md-0">

                            <div class="mb-24pt mb-sm-0 mr-sm-24pt">
                                <h2 class="mb-0">ADMINISTRATOR ACCOUNTS</h2>

                                <ol class="breadcrumb p-0 m-0">
                                    <li class="breadcrumb-item">User Management - Reset Administrator Password</li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="container-fluid page__container">
                    <div class="page-section">

                        <div class="alert alert-soft-warning mb-lg-32pt">
                            <div class="d-flex flex-wrap align-items-start">
                                <div class="mr-8pt">
                                    <i class="material-icons">access_time</i>
                                </div>
                                <div class="flex"
                                     style="min-width: 180px">
                                    <small class="text-100">
                                        <strong>Analytics Service Issues.</strong><br>
                                        <span>You may experience some issues with the Analytics API. Stay up to date by following our status page.</span>
                                    </small>
                                </div>
                            </div>
                        </div>

                        <div class="page-separator">
                            <div class="page-separator__text">RESET ADMIN PASSWORDS</div>
                        </div>


                        <div class="row mb-32pt">

                            <div class="col-lg-12 d-flex align-items-center">
                                <div class="flex"
                                     style="max-width: 100%">
                                    <form action="<%=request.getContextPath()%>/ResetAdminInfo" >
                                        <div class="was-validated">
                                            <div class="form-row">
                                                <div class="col-12 col-md-6 mb-3">
                                                    <% 
                                                        String actionStatus = request.getSession().getAttribute("actionStatus").toString();
                                                        UserValidation msg = (UserValidation) request.getAttribute("validationMsg");
                                                        User userData = (User) request.getAttribute("userData");
                                                    %>
                                                    <input type="hidden" id="actionStatus" value="<%= actionStatus%>" />
                                                    <label class="form-label"
                                                           >First name</label>
                                                    <input type="text"
                                                           class="form-control"
                                                           placeholder="First name"
                                                           required
                                                           name="fName"
                                                           value ="<%=userData.getuFName()%>">
                                                    <div class="validation-msg"><label><%=msg.getuFNameVMsg() %></label></div>
                                                </div>
                                                <div class="col-12 col-md-6 mb-3">
                                                    <label class="form-label"
                                                           >Last name</label>
                                                    <input type="text"
                                                           class="form-control"
                                                           placeholder="Last name"
                                                           required=""
                                                           name="lName"
                                                           value ="<%=userData.getuLName()%>">
                                                    <div class="validation-msg"><label><%=msg.getuLNameVMsg() %></label></div>
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="col-12 col-md-6 mb-3">
                                                    <label class="form-label"
                                                           >Manager ID</label>
                                                    <input type="text"
                                                           class="form-control"
                                                           placeholder="Manager ID"
                                                           required=""
                                                           name="eID"
                                                           value ="<%=userData.getuID()%>">
                                                    <div class="validation-msg"><label><%=msg.getuEmpIDVMsg() %></label></div>
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="col-12 col-md-6 mb-3">
                                                    <label class="form-label"
                                                           >ACCOUNT TYPE</label>
                                                    <select class=" select form-control" name="accType">
                                                        <option >Manager - Level 1</option>
                                                        <option >Administrator</option>
                                                    </select>
                                                    <div class="validation-msg"><label><%=msg.getuTypeVMsg()%></label></div>
                                                </div>
                                                <div class="col-12 col-md-6 mb-3">
                                                    <label class="form-label"
                                                           >ACCOUNT STATUS</label>
                                                    <select class="select form-control" name="accStatus">
                                                        <option id="Active">Active</option>
                                                        <option id="Disabled">Disabled</option>
                                                    </select>
                                                    <div class="validation-msg"><label><%=msg.getuStatusVMsg()%></label></div>
                                                </div>
                                            </div>
                                        </div>
                                        <button class="btn btn-primary"
                                                type="submit">RESET PASSWORD</button>
                                        <button class="btn btn-dark"
                                                type="reset">CLEAR FIELDS</button>
                                    </form>


                                </div>
                            </div>
                        </div>                                        

                    </div>
                </div>
                                              

                <!-- footer -->
                <%@include  file="../includes/footer.jsp" %>
                <!-- // END footer -->

            </div>

            <!-- // END drawer-layout__content -->

            <!-- drawer -->
            <%@include  file="../includes/drawer.jsp" %>
            <!-- // END drawer -->
        </div>
        <!-- // END drawer-layout -->
        <!-- Modal -->
        <%@include file="../content/popupModel.jsp" %>
        <%@include file="../includes/script.jsp" %>
        
        
    </body>
</html>