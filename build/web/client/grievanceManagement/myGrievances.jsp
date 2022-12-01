<%-- 
    Document   : index
    Created on : Apr 16, 2021, 9:31:27 PM
--%>

<%@page import="com.grms.data.model.User"%>
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
                <%--<%@include file="../content/index-content.jsp" %>--%>


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