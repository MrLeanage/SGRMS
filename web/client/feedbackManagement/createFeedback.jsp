

<%@page import="com.grms.data.model.Grievance"%>
<%@page import="com.grms.data.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"
      dir="ltr">


    <head>
        <title>Feedback</title>
        <%@include file="../includes/head.jsp"%>

    </head>

    <body class="layout-app layout-sticky-subnav ">

        <div class="preloader">
            <div class="sk-chase">
                <div class="sk-chase-dot"></div>
                <div class="sk-chase-dot"></div>
                <div class="sk-chase-dot"></div>
                <div class="sk-chase-dot"></div>
                <div class="sk-chase-dot"></div>
                <div class="sk-chase-dot"></div>
            </div>

        </div>

        <div class="mdk-drawer-layout js-mdk-drawer-layout"
             data-push
             data-responsive-width="992px">
            <!-- // START drawer-layout_content-->
            <div class="mdk-drawer-layout__content page-content">

                <!-- Header -->
                <%@include file="../includes/header.jsp"%>
                <!-- // END Header -->
                <%--<%@include file="../content/index-content.jsp" %>--%>
                <div class="border-bottom-2 py-32pt position-relative z-1">
                    <div class="container-fluid page__container d-flex flex-column flex-md-row align-items-center text-center text-sm-left">
                        <div class="flex d-flex flex-column flex-sm-row align-items-center mb-24pt mb-md-0">

                            <div class="mb-24pt mb-sm-0 mr-sm-24pt">
                                <h2 class="mb-0">GIVE FEEDBACK FOR GRIEVANCE</h2>

                                <ol class="breadcrumb p-0 m-0">
                                    <li class="breadcrumb-item">FEEDBACK MANAGEMENT</li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container-fluid page__container">
                    <div class="page-section">




                        <div class="container p-1">
                            <p>Add Your Feedback - Please share some words about your experience with us!</p>
                        </div>

                                      
                        <div class="row mb-32pt">

                            <div class="col-lg-12 d-flex align-items-center">
                                <div class="flex"
                                     style="max-width: 100%">
                                    <form action="<%=request.getContextPath()%>/SubmitFeedback" method="POST">
                                        <div class="was-validated mb-32pt pb-24pt">
                                            <%Grievance grievance = (Grievance) request.getAttribute("grievance"); %>
                                            <div class="form-row">
                                                <div class="col-12 col-md-12 mb-3">
                                                    <label for="form-label">GRIEVANCE ID</label>
                                                    <input type="text"
                                                           class="form-control"
                                                           placeholder="Grievance ID here"
                                                           id="gID"
                                                           name="gID"
                                                           readonly
                                                           value="<%=grievance.getgID() %>">
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="col-12 col-md-12 mb-3">
                                                    <label for="form-label">GRIEVANCE TITLE</label>
                                                    <input type="text"
                                                           class="form-control"
                                                           placeholder="Grievance TITLE here"
                                                           readonly
                                                           value="<%=grievance.getgTitle()%>">
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="col-12 col-md-12 mb-8pt">
                                                    
                                                    
                                                   
                                                    <label for="form-label">SELECT A TITLE FOR FEEDBACK TITLE</label>
                                                    <select class="form-control" id="fTitle" name="fTitle">
                                                      <option>Service Appreciation Feedback</option>
                                                      <option>Service Complain Feedback</option>
                                                      <option>Service Request to Re Open Grievance</option>
                                                    </select>
                                                </div>
                                                
                                            </div>
                                            <div class="form-row ">
                                                <div class=" col-lg-12  col-lg-12 mb-8pt ">
                                                    <label class="form-label"
                                                           >EXTRA NOTE FOR YOUR FEEDBACK</label>
                                                    <textarea class="form-control h-100"
                                                           placeholder="Explain your Issue in detail here"
                                                           required
                                                           name="fNote"
                                                           id="fNote" 
                                                           ></textarea>
                                                    <div class="invalid-feedback">Please share some words about your experience with us!</div>
                                                    <div class="valid-feedback">Looks good! We Appreciate your feedback</div>
                                                </div>
                                                
                                            </div>
                                        </div>
                                        <button class="btn btn-primary"
                                                type="submit" id ="add" name="formAction" value="POST GRIEVANCE">SUBMIT FEEDBACK</button>
                                        <button class="btn btn-dark"
                                                type="reset" id="clearButton">CLEAR FIELDS</button>
                                    </form>
                                </div>
                            </div>
                        </div>                                       

                    </div>
                </div>
                    

            </div>

            <!-- // END drawer-layout__content -->

            <!-- drawer -->
            <%@include  file="../includes/drawer.jsp" %>
            <!-- // END drawer -->
        </div>
        <!-- // END drawer-layout -->
        
        <%@include file="../includes/script.jsp" %>
    </body>
</html>