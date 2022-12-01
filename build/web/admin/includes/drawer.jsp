<%-- 
    Document   : drawer
    Created on : March 3, 2022, 4:02:11 PM
--%>
<%@page import="com.grms.data.model.User"%>
<div class="mdk-drawer js-mdk-drawer"
     id="default-drawer">
    <%User userData = (User) session.getAttribute("authUser");%>
    <div class="mdk-drawer__content">
        <div class="sidebar sidebar-dark sidebar-left"
             data-perfect-scrollbar>

            <!-- Navbar toggler -->


            <a href="<%=request.getContextPath()%>/Dashboard"
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
                       href="<%=request.getContextPath()%>/Dashboard">
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
                        Grievances
                        <span class="sidebar-menu-badge badge badge-accent badge-notifications ml-auto">2</span>
                        <span class="sidebar-menu-toggle-icon"></span>
                    </a>
                    <ul class="sidebar-submenu collapse sm-indent"
                        id="messaging_menu">
                        <%if(userData.getuType().equals("Manager - Level 3")){ %>
                        <li class="sidebar-menu-item">
                            <a class="sidebar-menu-button"
                               href="<%=request.getContextPath()%>/PendingGrievance">
                                <span class="sidebar-menu-text">New Grievance</span>
                            </a>
                        </li>
                        <%}%>
                        <li class="sidebar-menu-item">
                            <a class="sidebar-menu-button"
                               href="<%=request.getContextPath()%>/ProcessingGrievance">
                                <span class="sidebar-menu-text">Processing Grievances</span>
                            </a>
                        </li>
                        <li class="sidebar-menu-item">
                            <a class="sidebar-menu-button"
                               href="<%=request.getContextPath()%>/FinishedGrievance">
                                <span class="sidebar-menu-text">Finished Grievances</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="sidebar-menu-item">
                    <a class="sidebar-menu-button"
                       data-toggle="collapse"
                       href="#account_menu">
                        <span class="material-icons sidebar-menu-icon sidebar-menu-icon--left">account_box</span>
                        Accounts
                        <span class="ml-auto sidebar-menu-toggle-icon"></span>
                    </a>
                    <ul class="sidebar-submenu collapse sm-indent"
                        id="account_menu">
                        <%if(userData.getuType().equals("Manager - Level 3") || userData.getuType().equals("Manager - Level 2")){ %>
                        <li class="sidebar-menu-item">
                            <a class="sidebar-menu-button"
                               href="<%=request.getContextPath()%>/ManageStudent">
                                <span class="sidebar-menu-text">Student Accounts</span>
                            </a>
                        </li>
                        
                        <li class="sidebar-menu-item">
                            <a class="sidebar-menu-button"
                               href="<%=request.getContextPath()%>/ResetStudent">
                                <span class="sidebar-menu-text">Reset Student Password</span>
                            </a>
                        </li>
                        <%}%>
                        <%if(userData.getuType().equals("Manager - Level 1") || userData.getuType().equals("Administrator")){ %>
                        <li class="sidebar-menu-item">
                            <a class="sidebar-menu-button"
                               href="<%=request.getContextPath()%>/ManageManager">
                                <span class="sidebar-menu-text">Manager Accounts</span>
                            </a>
                        </li>
                        <li class="sidebar-menu-item">
                            <a class="sidebar-menu-button"
                               href="<%=request.getContextPath()%>/ResetManager">
                                <span class="sidebar-menu-text">Reset Manager Password</span>
                            </a>
                        </li>
                        <%}%>
                         <%if( userData.getuType().equals("Administrator")){ %>
                        <li class="sidebar-menu-item">
                            <a class="sidebar-menu-button"
                               href="<%=request.getContextPath()%>/ManageAdmin">
                                <span class="sidebar-menu-text">Admin Accounts</span>
                            </a>
                        </li>
                        <li class="sidebar-menu-item">
                            <a class="sidebar-menu-button"
                               href="<%=request.getContextPath()%>/ResetAdmin">
                                <span class="sidebar-menu-text">Reset Admin Password</span>
                            </a>
                        </li>
                        <%}%>
                    </ul>
                </li>
                <li class="sidebar-menu-item">
                    <a class="sidebar-menu-button"
                       data-toggle="collapse"
                       href="#components_menu">
                        <span class="material-icons sidebar-menu-icon sidebar-menu-icon--left">tune</span>
                        Grievance Guidelines
                        <span class="ml-auto sidebar-menu-toggle-icon"></span>
                    </a>
                    <ul class="sidebar-submenu collapse sm-indent"
                        id="components_menu">
                        <li class="sidebar-menu-item">
                            <a class="sidebar-menu-button"
                               href="<%=request.getContextPath()%>/CurrentGuideline">
                                <span class="sidebar-menu-text">Current Guideline</span>
                            </a>
                        </li>
                        <li class="sidebar-menu-item">
                            <a class="sidebar-menu-button"
                               href="<%=request.getContextPath()%>/AllGuidelines">
                                <span class="sidebar-menu-text">All Guideline Versions</span>
                            </a>
                        </li>
                        <%if( userData.getuType().equals("Administrator") || userData.getuType().equals("Manager - Level 1")){ %>
                        <li class="sidebar-menu-item">
                            <a class="sidebar-menu-button"
                               href="<%=request.getContextPath()%>/ManageGuidelines">
                                <span class="sidebar-menu-text">Manage Guidelines</span>
                            </a>
                        </li>
                        <%}%>
                    </ul>
                </li>
                <li class="sidebar-menu-item">
                    <a class="sidebar-menu-button"
                       data-toggle="collapse"
                       href="#community_menu">
                        <span class="material-icons sidebar-menu-icon sidebar-menu-icon--left">people_outline</span>
                        Feedbacks
                        <span class="ml-auto sidebar-menu-toggle-icon"></span>
                    </a>
                    <ul class="sidebar-submenu collapse sm-indent"
                        id="community_menu">
                        <li class="sidebar-menu-item">
                            <a class="sidebar-menu-button"
                               href="<%=request.getContextPath()%>/ViewGivenFeedback">
                                <span class="sidebar-menu-text">View Feedbacks</span>
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
                             src="${pageContext.request.contextPath}/admin/assets/images/people/50/circled-user-icon.png"
                             alt="account" />
                        <span class="material-icons sidebar-menu-icon sidebar-menu-icon--left">
                            </span>
                        
                        <%=userData.getuFName()%> <%=userData.getuLName()%>
                        <span class="ml-auto sidebar-menu-toggle-icon"></span>

                    </a>
                            
                    <ul class="sidebar-submenu collapse sm-indent"
                        id="cms_menu">
                        <li class="sidebar-menu-item">
                            <p style="padding-left: 20%"><%=userData.getuType()%> <br>(<%=userData.getuSpecialization()%>)</p>
                            
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
