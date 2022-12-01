<%-- 
    Document   : index
    Created on : Apr 16, 2021, 9:31:27 PM
--%>

<%@page import="com.grms.data.model.User"%>
<%@page import="com.grms.data.constant.Constant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"
      dir="ltr">


    <head>
        <title>Welcome To GRMS</title>
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
                                <h2 class="mb-0">SUBMIT YOUR GRIEVANCE</h2>

                                <ol class="breadcrumb p-0 m-0">
                                    <li class="breadcrumb-item">You can get assistance for a real or imagined cause for complaint, especially unfair treatment.</li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container-fluid page__container">
                    <div class="page-section">




                        <div class="container p-1">
                            <p>An individual grievance is a complaint that an action by management has violated the rights of an individual as set out in the collective agreement or law, or by some unfair practice. Examples of this type of grievance include: discipline, demotion, classification disputes, denial of benefits. This System is available for you to take assistance of our team for all your unfair treatments</p>
                        </div>

                        <div class="mb-24pt mb-sm-0 mr-sm-24pt">
                            <h4 class="mb-0">SUBMIT YOUR GRIEVANCE</h4><br>
                            <p>You can use this Portal to Solve out Following type of Issues</p>
                            <ol>
                                <li><%=Constant.GRIEVANCE_TYPE_ACADEMIC%></li>
                                <li><%=Constant.GRIEVANCE_TYPE_NON_ACADEMIC%></li>
                                <li><%=Constant.GRIEVANCE_TYPE_COUNSELING%></li>
                                <li><%=Constant.GRIEVANCE_TYPE_STUDENT%></li>
                            </ol>
                            <ol class="breadcrumb p-0 m-0">
                                <li class="breadcrumb-item">In order to get assistance, please submit following details</li>
                            </ol><br>
                        </div>        
                        <div class="row mb-32pt">

                            <div class="col-lg-12 d-flex align-items-center">
                                <div class="flex"
                                     style="max-width: 100%">
                                    <form action="<%=request.getContextPath()%>/PostNewGrievance" method="POST">
                                        <div class="was-validated mb-32pt pb-24pt">
                                            <div class="form-row">
                                                <div class="col-12 col-md-12 mb-3">
                                                    
                                                    
                                                    <label class="form-label"
                                                           >Your Grievance Type</label>
                                                    <select class="form-control" name="gType" id="gType">
                                                        <option><%=Constant.GRIEVANCE_TYPE_ACADEMIC%></option>
                                                        <option><%=Constant.GRIEVANCE_TYPE_NON_ACADEMIC%></option>
                                                        <option><%=Constant.GRIEVANCE_TYPE_COUNSELING%></option>
                                                        <option><%=Constant.GRIEVANCE_TYPE_STUDENT%></option>
                                                    </select>
                                                </div>
                                                
                                            </div>
                                            <div class="form-row">
                                                <div class="col-12 col-md-12 mb-3">
                                                    
                                                    
                                                    <label class="form-label"
                                                           >Grievance Title</label>
                                                    <input type="text"
                                                           class="form-control"
                                                           placeholder="Give a title to your new Grievance"
                                                           required
                                                           name="gTitle"
                                                           id="gTitle"
                                                           value="">

                                                    <div class="invalid-feedback">Please provide Title for your new Grievance</div>
                                                    <div class="valid-feedback">Looks good!</div>
                                                </div>
                                                
                                            </div>
                                            <div class="form-row ">
                                                <div class=" col-lg-12  col-lg-12 mb-8pt ">
                                                    <label class="form-label"
                                                           >Grievance Issue in Detail</label>
                                                    <textarea class="form-control h-100"
                                                           placeholder="Explain your Issue in detail here"
                                                           required
                                                           name="gDescription"
                                                           id="gDescription" 
                                                           ></textarea>
                                                    <div class="invalid-feedback">Please Specify your Issue in detail!</div>
                                                    <div class="valid-feedback">Looks good!</div>
                                                </div>
                                                
                                            </div>
                                        </div>
                                        <button class="btn btn-primary"
                                                type="submit" id ="add" name="formAction" value="POST GRIEVANCE">POST GRIEVANCE</button>
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