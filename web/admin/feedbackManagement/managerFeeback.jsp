

<%@page import="com.grms.data.model.Feedback"%>
<%@page import="com.grms.logic.utility.UtilityMethod"%>
<%@page import="com.grms.data.model.Grievance"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en"
      dir="ltr">
    <head>
        <title>Grievance Feedbacks</title>
        <%@include file="../includes/head.jsp"%>

    </head>

    <body class="layout-app layout-sticky-subnav sub-layout">
        <div class="mdk-drawer-layout js-mdk-drawer-layout"
             data-push
             data-responsive-width="992px" style="background-image: url('admin/assets/images/covers/chat-cover-dark.jpg'); background-color: #002752;">
            <div class="mdk-drawer-layout__content page-content">

                <!-- Header -->
                <%@include file="../includes/header.jsp"%>
                <!-- // END Header -->

                <div class="sidebar sidebar-left sidebar-light bg-transparent  o-hidden"
                     data-perfect-scrollbar>

                    <div class="border-bottom-2 py-32pt position-relative z-1 bg-white">
                        <div class="page__container d-flex flex-column flex-md-row align-items-center text-center text-sm-left">
                            <div class="flex d-flex flex-column flex-sm-row align-items-center mb-24pt mb-md-0">

                                <div class="mb-24pt mb-sm-0 mr-sm-24pt">
                                    <h2 class="mb-0">GRIEVANCE FEEDBACKS</h2>

                                    <ol class="breadcrumb p-0 m-0">
                                        <li class="breadcrumb-item">Feedback Management</li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="list-group list-group-flush flex-shrink-0  bg-transparent"
                          style="position: relative; z-index: 0; margin: 10px; border-radius:25px">
                        <%
                            ArrayList<Feedback> feedbackList = (ArrayList<Feedback>) request.getAttribute("feedbackList");
                            for (Feedback feedback : feedbackList) {
                        %>                        
                        
                        <div class="p-3 bg-white" style=" margin-bottom:10px; border-radius:25px">
                            <div class="card border-primary mb-3 p-3 " >
                                <div class="card-header  ">
                                    <h4 class="text-body"><b><%=feedback.getfTitle()%> for <%=feedback.getfGrievance().getgTitle()%> (TICKET ID : <%=feedback.getfGID()%>)</b></h4>
                                </div>
                                <div class="card-body bg-light">
                                    <h5 class="card-title "><%=feedback.getfTitle()%></h5>
                                    <p class="card-text"><%=UtilityMethod.getTrimmedString(feedback.getfNote(), 400)%>.
                                        <span class="d-flex align-items-center mb-1">


                                            <small class="ml-auto text-muted"><b><%= feedback.getfDate()%> at <%= feedback.getfTime()%></b></small>
                                        </span>
                                        <span class="d-flex align-items-end">
                                            <span class="flex mr-3">
                                                <small class="text-muted"
                                                       style="max-height: 2rem; overflow: hidden; position: relative; display: inline-block;">
                                                    <b> </b></small>
                                            </span>
                                            <% String actionStatus = (String) request.getSession().getAttribute("actionStatus");%>
                                            <input type="hidden" id="actionStatus" value="<%= actionStatus%>" />

                                            <%if (feedback.getfTitle().equals("Service Appreciation Feedback")) {%>
                                            <button class="btn btn-success" ><a style="color:white;" href="<%=request.getContextPath()%>/GrievanceChat?gID=<%=feedback.getfGID()%>&gStatus=Finished"><b>VIEW THIS GRIEVANCE</b></a></button>
                                            <% }%>
                                            <%if (feedback.getfTitle().equals("Service Complain Feedback")) {%>
                                            <button class="btn btn-danger" ><a style="color:white;" href="<%=request.getContextPath()%>/GrievanceChat?gID=<%=feedback.getfGID()%>&gStatus=Finished"><b>VIEW THIS GRIEVANCE</b></a></button>
                                            <% }%>
                                            <%if (feedback.getfTitle().equals("Service Request to Re Open Grievance")) {%>
                                            <button class="btn btn-warning" ><a style="color:white;" href="<%=request.getContextPath()%>/GrievanceChat?gID=<%=feedback.getfGID()%>&gStatus=Finished"><b>VIEW THIS GRIEVANCE</b></a></button>
                                            <% }%>
                                        </span>
                                    </p>
                                    <div class="progress mt-2" style="height:30px">

                                        <%if (feedback.getfTitle().equals("Service Appreciation Feedback")) {%>
                                        <div class="progress-bar bg-success" style="width: 100% " role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"><h5 class="mt-2 mb-2">Grievance Status :  <%=feedback.getfGrievance().getgStatus()%></h5></div>
                                        <% }%>  
                                        <%if (feedback.getfTitle().equals("Service Complain Feedback")) {%>
                                        <div class="progress-bar bg-danger" style="width: 100% " role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"><h5 class="mt-2 mb-2">Grievance Status :  <%=feedback.getfGrievance().getgStatus()%></h5></div>
                                        <% }%>  
                                        <%if (feedback.getfTitle().equals("Service Request to Re Open Grievance")) {%>
                                        <div class="progress-bar bg-warning" style="width: 100% " role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"><h5 class="mt-2 mb-2">Grievance Status :  <%=feedback.getfGrievance().getgStatus()%></h5></div>
                                        <% }%>  
                                    </div>
                                </div>
                            </div>  
                        </div>


                        <%}%>
                    </div>

                </div>

            </div>
            <!-- // END drawer-layout__content -->

            <!-- drawer -->
            <%@include  file="../includes/drawer.jsp" %>
            <!-- // END drawer -->
        </div>
        <!-- // END drawer-layout -->
        <!-- jQuery -->
        <%@include file="../content/popupModel.jsp" %>
        <%@include file="../includes/script.jsp" %>
    </body>


</html>