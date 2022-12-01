<%-- 
    Document   : drawer
    Created on : March 3, 2022, 4:02:11 PM
--%>
<%@page import="com.grms.data.model.User"%>
<div class="mdk-drawer js-mdk-drawer"
     id="default-drawer">
    <div class="mdk-drawer__content">
        <div class="sidebar sidebar-dark sidebar-left"
             data-perfect-scrollbar>

            <!-- Navbar toggler -->


            <a href="<%=request.getContextPath()%>/Student-Dashboard"
               class="sidebar-brand ">
                <img class="sidebar-brand-icon"
                     src="${pageContext.request.contextPath}/assets/images/logo/Logo-Without-Text.png"
                     alt="GRMS">
                <span>G R M S</span>
            </a>


            <div class="sidebar-heading">Overview</div>
            <ul class="sidebar-menu">
                <li class="sidebar-menu-item active">
                    <a class="sidebar-menu-button"
                       href="<%=request.getContextPath()%>/Student-Dashboard">
                        <span class="material-icons sidebar-menu-icon sidebar-menu-icon--left">insert_chart_outlined</span>
                        <span class="sidebar-menu-text">Dashboard</span>
                    </a>
                </li>   
            </ul>

            <div class="sidebar-heading">Applications</div>
            <ul class="sidebar-menu">
              <li class="sidebar-menu-item">
                    <a class="sidebar-menu-button"
                       data-toggle="collapse"
                       href="#messaging_menu">
                        <span class="material-icons sidebar-menu-icon sidebar-menu-icon--left">message</span>
                        My Grievances
                        <span class="sidebar-menu-badge badge badge-accent badge-notifications ml-auto">2</span>
                        <span class="sidebar-menu-toggle-icon"></span>
                    </a>
                    <ul class="sidebar-submenu collapse sm-indent"
                        id="messaging_menu">
                        <li class="sidebar-menu-item">
                            <a class="sidebar-menu-button"
                               href="<%=request.getContextPath()%>/CreateNewGrievance">
                                <span class="sidebar-menu-text">New Grievance</span>
                            </a>
                        </li>
                        <li class="sidebar-menu-item">
                            <a class="sidebar-menu-button"
                               href="<%=request.getContextPath()%>/MyGrievances">
                                <span class="sidebar-menu-text">My Grievances</span>
                            </a>
                        </li>
                        
                    </ul>
                </li>
                <li class="sidebar-menu-item">
                    
                    <a class="sidebar-menu-button"
                       data-toggle="collapse"
                       href="#cms_menu">
                        
                        <img width="20"
                             height="20"
                             class="rounded-circle mr-8pt"
                             src="${pageContext.request.contextPath}/client/assets/images/people/50/circled-user-icon.png"
                             alt="account" />
                        <span class="material-icons sidebar-menu-icon sidebar-menu-icon--left">
                            </span>
                        <%User userData = (User) session.getAttribute("authUser");%>
                        <%=userData.getuFName()%> <%=userData.getuLName()%>
                        <span class="ml-auto sidebar-menu-toggle-icon"></span>

                    </a>

                    <ul class="sidebar-submenu collapse sm-indent"
                        id="cms_menu">
                        <li class="sidebar-menu-item">
                            <a class="sidebar-menu-button"
                               href="#">
                                <span class="sidebar-menu-text">My Account</span>
                            </a>
                        </li>
                        <li class="sidebar-menu-item">
                            <a class="sidebar-menu-button" data-href="<%=request.getContextPath()%>/Login" data-toggle="modal" data-target="#confirm-logout"><span class="sidebar-menu-text">Logout</span></a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
