

<%@page import="com.grms.logic.utility.UtilityMethod"%>
<%@page import="com.grms.data.model.Grievance"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en"
      dir="ltr">
    <head>
        <title>My Grievances</title>
        <%@include file="../includes/head.jsp"%>

    </head>

    <body class="layout-app layout-sticky-subnav sub-layout">
        <div class="mdk-drawer-layout js-mdk-drawer-layout"
             data-push
             data-responsive-width="992px" style="background-image: url('client/assets/images/covers/chat-cover-dark.jpg'); background-color: #002752">
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
                                    <h2 class="mb-0">MY GRIEVANCES</h2>

                                    <ol class="breadcrumb p-0 m-0">
                                        <li class="breadcrumb-item">Grievance Management</li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="list-group list-group-flush flex-shrink-0 bg-transparent"
                         style="position: relative; z-index: 0; margin: 10px; border-radius:25px">
                        <%
                            ArrayList<Grievance> grievanceList = (ArrayList<Grievance>) request.getAttribute("grievanceList");
                            for (Grievance grievance : grievanceList) {
                        %>                        
                        <div class="list-group-item d-flex align-items-start bg-white" style="padding:10px; margin-bottom:10px; border-radius:25px">
                            <div class="mr-3 d-flex flex-column align-items-center">

                                <a href="#"
                                   class="text-muted"><i class="material-icons icon-16pt">star_border</i></a>
                            </div>
                            <div class="flex">
                                <h5 class="text-body"><%=grievance.getgTitle()%> (TICKET ID : <%=grievance.getgID()%>)</h5>
                                <p class="m-0">
                                    <span class="d-flex align-items-center mb-1">
                                        <small class="ml-auto text-muted"><b>POSTED ON : <%= grievance.getgStartDate()%></b></small>
                                    </span>
                                    <span class="d-flex align-items-end">
                                        <span class="flex mr-3">
                                            <small class="text-muted"
                                                   style="max-height: 5rem; overflow: hidden; position: relative; display: inline-block;">
                                                <%=UtilityMethod.getTrimmedString(grievance.getgDescription(), 150)%>...</small>
                                        </span>
                                        <%if (grievance.getgStatus().equals("Processing")) {%>
                                        <button class="btn-success" ><a style="color:white;" href="<%=request.getContextPath()%>/GrievanceChat?gID=<%=grievance.getgID()%>"><b>VIEW GRIEVANCE</b></a></button>
                                        <% }%>
                                        <%if (grievance.getgStatus().equals("Finished")) {%>
                                        <button class="btn-warning" ><a style="color:white;" href="<%=request.getContextPath()%>/GrievanceChat?gID=<%=grievance.getgID()%>"><b>VIEW GRIEVANCE</b></a></button>
                                        <% }%>
                                    </span>
                                </p>
                                <div class="progress mt-2" style="height:30px">
                                    <%if (grievance.getgStatus().equals("Pending")) {%>
                                    <div class="progress-bar bg-primary " style="width: 100%" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"><h5 class="mt-2 mb-2">Grievance Status :  <%=grievance.getgStatus()%></h5></div>
                                    <% }%>  
                                    <%if (grievance.getgStatus().equals("Processing")) {%>
                                    <div class="progress-bar bg-success" style="width: 100% " role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"><h5 class="mt-2 mb-2">Grievance Status :  <%=grievance.getgStatus()%></h5></div>
                                    <% }%> 
                                    <%if (grievance.getgStatus().equals("Finished")) {%>
                                    <div class="progress-bar bg-warning" style="width: 100% " role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"><h5 class="mt-2 mb-2">Grievance Status :  <%=grievance.getgStatus()%></h5></div>
                                    <% }%>  


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

        <!-- App Settings FAB -->
        <div id="app-settings">
            <!--            <app-settings 
                            layout-active="app"
                                      :layout-location="{
                  'compact': 'compact-email.html',
                  'mini': 'mini-email.html',
                  'app': 'email.html',
                  'boxed': 'boxed-email.html',
                  'sticky': 'sticky-email.html',
                  'default': 'fixed-email.html'
                }"
                                      sidebar-type="light"
                                      sidebar-variant="bg-body">
                                          
                        </app-settings>-->
        </div>
        <!-- jQuery -->
        <%@include file="../includes/script.jsp" %>
    </body>


</html>