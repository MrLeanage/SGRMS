

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
             data-responsive-width="992px">
            <div class="mdk-drawer-layout__content page-content">

                <!-- Header -->
                <%@include file="../includes/header.jsp"%>
                <!-- // END Header -->

                <div class="sidebar sidebar-left sidebar-light bg-white  o-hidden"
                     data-perfect-scrollbar>

                    <div class="border-bottom-2 py-32pt position-relative z-1">
                        <div class="container-fluid page__container d-flex flex-column flex-md-row align-items-center text-center text-sm-left">
                            <div class="flex d-flex flex-column flex-sm-row align-items-center mb-24pt mb-md-0">

                                <div class="mb-24pt mb-sm-0 mr-sm-24pt">
                                    <h2 class="mb-0">NEW PENDING GRIEVANCES</h2>

                                    <ol class="breadcrumb p-0 m-0">
                                        <li class="breadcrumb-item">Grievance Management</li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="list-group list-group-flush flex-shrink-0"
                         style="position: relative; z-index: 0;">
                        <%
                            ArrayList<Grievance> grievanceList = (ArrayList<Grievance>) request.getAttribute("grievanceList");
                            for (Grievance grievance : grievanceList) {
                        %>                        
                        <div class="list-group-item d-flex align-items-start bg-transparent">
                            <div class="mr-3 d-flex flex-column align-items-center">
                                
                                <a href="#"
                                   class="text-muted"><i class="material-icons icon-16pt">star_border</i></a>
                            </div>
                            <div class="flex">
                                <p class="m-0">
                                    <span class="d-flex align-items-center mb-1">
                                        <a href="#<%=grievance.getgID() %>"
                                           class="text-body"><strong><%=grievance.getgTitle() %></strong></a>
                                        <small class="ml-auto text-muted"><%= grievance.getgStartDate()%></small>
                                    </span>
                                    <span class="d-flex align-items-end">
                                        <span class="flex mr-3">
                                            <small class="text-muted"
                                                   style="max-height: 2rem; overflow: hidden; position: relative; display: inline-block;">
                                                <%=UtilityMethod.getTrimmedString(grievance.getgDescription(), 50) %>...</small>
                                        </span>
                                        <a href="#"
                                           class="d-flex align-items-center mb-1">
                                            <small class="text-muted mr-1">Grievance Status : <%=grievance.getgStatus() %></small>
                                            
                                        </a>
                                            <% String actionStatus = (String) request.getSession().getAttribute("actionStatus");%>
                                                    <input type="hidden" id="actionStatus" value="<%= actionStatus%>" />
                                            <button class="btn-primary"><a style="color:white;" href="<%=request.getContextPath()%>/AcceptGrievance?gID=<%=grievance.getgID()%>">Accept Grievance</a></button>
                                    </span>
                                </p>
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