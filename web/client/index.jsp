<%-- 
    Document   : index
    Created on : March 16, 2022, 9:31:27 PM
--%>

<%@page import="com.grms.data.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"
      dir="ltr">


    <head>
        <title>Welcome To GRMS</title>
        <%@include file="../client/includes/head.jsp"%>

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
                <%@include file="../client/includes/header.jsp"%>
                <!-- // END Header -->
                <%@include file="../client/content/index-content.jsp" %>


            </div>

            <!-- // END drawer-layout__content -->

            <!-- drawer -->
            <%@include  file="../client/includes/drawer.jsp" %>
            <!-- // END drawer -->
        </div>
        <!-- // END drawer-layout -->
        
        <%@include file="../client/includes/script.jsp" %>
    </body>
</html>