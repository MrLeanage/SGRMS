<%-- 
    Document   : header
    Created on : March 19, 2022, 9:36:02 PM
--%>
<%@page import="com.grms.data.model.User"%>
<!-- Header -->

<div class="navbar navbar-expand navbar-shadow px-0  pl-lg-16pt navbar-light bg-body"
     id="default-navbar"
     data-primary>

    <!-- Navbar toggler -->
    <button class="navbar-toggler d-block d-lg-none rounded-0"
            type="button"
            data-toggle="sidebar">
        <span class="material-icons">menu</span>
    </button>

    <!-- Navbar Brand -->
    <a href="<%=request.getContextPath()%>/Dashboard"
       class="navbar-brand mr-16pt d-lg-none">
        <img class="navbar-brand-icon mr-0 mr-lg-8pt"
             src="${pageContext.request.contextPath}/client/assets/images/logo/accent-teal-100%402x.png"
             width="32"
             alt="Huma">
        <span class="d-none d-lg-block">GRMS</span>
    </a>
    <div class="flex"></div>

    <div class="nav navbar-nav flex-nowrap d-flex ml-0 mr-16pt">
        <div class="nav-item dropdown d-none d-sm-flex">

            <a href="#"
               class="nav-link d-flex align-items-center dropdown-toggle"
               data-toggle="dropdown">
                <img width="32"
                     height="32"
                     class="rounded-circle mr-8pt"
                     src="${pageContext.request.contextPath}/client/assets/images/people/50/circled-user-icon.png"
                     alt="account" />
                <span class="flex d-flex flex-column mr-8pt">
                    <%User user = (User) session.getAttribute("authUser");%>
                    <%=user.getuID()%></span>
                <small class="navbar-text-50" ></small>

            </a>
            <div class="dropdown-menu dropdown-menu-right">
                <div class="dropdown-header"><strong>Account</strong></div>
                <a class="dropdown-item"
                   href="#">My Account</a>
                <a class="dropdown-item pointer-cursor"
                   data-href="<%=request.getContextPath()%>/Login" data-toggle="modal" data-target="#confirm-logout">Logout</a>
            </div>
        </div>
    </div>
</div>
          

<!-- // END Header -->