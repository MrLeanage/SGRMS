

<%@page import="com.grms.data.model.User"%>
<%@page import="com.grms.data.constant.Constant"%>
<%@page import="com.grms.data.model.Grievance"%>
<%@page import="com.grms.data.model.ChatMessage"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!DOCTYPE html>
<html lang="en"
      dir="ltr">

    <head>
        <%@include file="../includes/head.jsp"%>

    </head>

    <body class="layout-app layout-sticky-subnav app-messages">


        <div class="mdk-drawer-layout js-mdk-drawer-layout "
             data-push
             data-responsive-width="992px">
            <div class="mdk-drawer-layout__content page-content">

                <!-- Header -->
                <!-- // END Header -->

                <div data-push
                     data-responsive-width="768px"
                     data-has-scrollable-region
                     data-fullbleed
                     class="mdk-drawer-layout js-mdk-drawer-layout">
                    <div class="mdk-drawer-layout__content" >
                        <%
                            User authUser = (User) session.getAttribute("authUser");
                            String chatTokenID = (String) session.getAttribute("chatTokenID");
                            Grievance specificGrievanceData = (Grievance) request.getAttribute("specificGrievanceData");
                        %>

                        <div class="app-messages__container d-flex flex-column h-100 pb-4">

                            <div class="flex pt-4"
                                 style="position: relative; background-image: url('admin/assets/images/covers/chat-cover-dark.jpg'); background-color: blue; margin-top: 50px"
                                 data-perfect-scrollbar>
                                <div class="container-fluid page__container page__container" style="margin-top:30px">
                                    <div class="card fixed-top" style="background-color: #04061e; ">
                                        <div class="card-body d-flex align-items-center ">
                                            <div class="mr-3">
                                                <div class="avatar avatar-xl">
                                                    <span class="avatar-title rounded-circle"><%= specificGrievanceData.getgID()%></span>
                                                </div>
                                            </div>
                                            <div class="flex">
                                                <h4 class="mb-0" style="color: white"><%= specificGrievanceData.getgTitle().toUpperCase()%></h4>
                                                <p class=" mb-0" style="color: white"><%= specificGrievanceData.getgDescription()%></p>
                                            </div>
                                            <div class=" d-flex justify-content-end" >
                                                <!--<small class='text-50'><%=specificGrievanceData.getgStatus()%></small>-->
                                            </div>
                                            <button data-target="#messages-drawer"
                                                    class="navbar-toggler d-block d-md-none ml-3 p-0 "
                                                    data-toggle="sidebar"
                                                    type="button">
                                                <i class="material-icons icon-blue" style="color:white">people</i>
                                            </button>
                                        </div>
                                           
                                        <div class="progress" style="height:30px">
                                            <%if (specificGrievanceData.getgStatus().equals("Processing")) {%>
                                            <div class="progress-bar bg-success w-100" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"><h5 class="mt-2 mb-2">Grievance Status :  <%=specificGrievanceData.getgStatus()%></h5></div>
                                            <% }%>  
                                            <%if (specificGrievanceData.getgStatus().equals("Finished")) {%>
                                            <div class="progress-bar bg-warning w-100" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"><h5 class="mt-2 mb-2">Grievance Status :  <%=specificGrievanceData.getgStatus()%></h5></div>
                                            <% }%>  
                                        </div>
                                    </div>
                                    <ul class="d-flex flex-column list-unstyled pt-5 mt-5  pb-4 mb-5"
                                        
                                        id="chatRoom">

                                        <%
                                            ArrayList<ChatMessage> chatData = (ArrayList<ChatMessage>) request.getAttribute("chatData");
                                            for (ChatMessage message : chatData) {
                                        %>
                                        <li class="message d-inline-flex">
                                            <%if (authUser.getuID().equals(message.getcMsgSenderID())) { %>
                                            <div class='message__body__ltr card'> 
                                                <%} else {%>
                                                <div class='message__body__rtl card'>   
                                                    <% }%>

                                                    <div class='card-body'>
                                                        <div class='d-flex align-items-center'>
                                                            <div class='flex mr-3'>
                                                                <a href='#' class='text-body'>
                                                                    <strong><%=message.getcMsgSenderName() + " (" + message.getcMsgSenderID() + ")"%></strong>
                                                                </a>
                                                            </div>
                                                            <div>
                                                                <small class='text-50'><%=message.getcMsgDate()%></small>
                                                            </div>
                                                        </div>
                                                        <span class='text-70'><%=message.getcMsg()%></span>
                                                        <div class="d-flex justify-content-end" >
                                                            <small class='text-50'><%=message.getcMsgTime()%></small>
                                                        </div>
                                                    </div>
                                                </div>
                                        </li>
                                        <% }%>

                                    </ul>
                                </div>
                            </div>
                            <%if (specificGrievanceData.getgStatus().equals("Processing")) {%>
                                          
                            <div class="container-fluid fixed-bottom">
                                <form
                                    id="messageText-reply">
                                    <div class="input-group input-group-merge" style="margin-bottom:5%; background-color:white">
                                        <input type="text"
                                               class="form-control form-control-appended"
                                               id="messageText"
                                               placeholder="Type message">

                                        <input type="text"
                                               id="currentUser"
                                               class="form-control form-control-appended"
                                               value="<%=authUser.getuID()%>"
                                               hidden>
                                        <input type="text"
                                               id="chatTokenID"
                                               class="form-control form-control-appended"
                                               value="<%=chatTokenID%>"
                                               hidden>
                                        <div class="input-group-append">
                                            <div class="input-group-text pr-2">
                                                <!--<input type ="button" value ="Send" onClick="sendMessage();"/>-->
                                                <button class=""
                                                        type="button" onClick="sendMessage()" ><i class="fas fa-paper-plane" style="color: #00b0ff"></i>
                                                </button>
                                            </div>

                                        </div>
                                    </div>
                                </form>
                            </div>
                            <% }%>
                        </div>
                    </div>
                    <div class="mdk-drawer js-mdk-drawer "
                         data-align="end"
                         id="messages-drawer">
                        <div class="mdk-drawer__content top-0">
                            <div class="sidebar sidebar-right sidebar-light bg-white  o-hidden">
                                <div class="d-flex flex-column ">
                                    <div class="d-flex flex-column justify-content-end navbar-height">
                                        <a href="#"
                                           class="nav-link d-flex justify-content-end align-items-center dropdown-toggle"
                                           data-toggle="dropdown">
                                            <img width="32"
                                                 height="32"
                                                 class="rounded-circle mr-8pt"
                                                 src="${pageContext.request.contextPath}/client/assets/images/people/50/circled-user-icon.png"
                                                 alt="account" />
                                            <span class="flex d-flex flex-column mr-8pt">
                                                <%=authUser.getuFName() + " "+ authUser.getuLName()%></span>
                                            <small class="navbar-text-50" ></small>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <div class="dropdown-header"><strong>Account</strong></div>
                                            <a class="dropdown-item"
                                               href="edit-account.html">My Account</a>
                                            <a class="dropdown-item pointer-cursor"
                                               data-href="<%=request.getContextPath()%>/Login" data-toggle="modal" data-target="#confirm-logout">Logout</a>
                                        </div>


                                    </div>

                                    <div class="flex"
                                         data-perfect-scrollbar>
                                        <%ArrayList<User> chatParticipants = (ArrayList<User>) request.getAttribute("chatParticipants");%>

                                        <div class="sidebar-heading">EMPLOYEE</div>
                                        <ul class="list-group list-group-flush mb-3">
                                            <%
                                                for (User chatUser : chatParticipants) {
                                                    if (chatUser.getuType().equals("Employee")) {
                                            %>
                                            <li class="list-group-item px-3 py-12pt">
                                                <a href="#"
                                                   class="d-flex align-items-center position-relative">
                                                    <span class="avatar avatar-xs avatar-online mr-3 flex-shrink-0">

                                                        <span class="avatar-title rounded-circle">E</span>

                                                    </span>
                                                    <span class="flex d-flex flex-column"
                                                          style="max-width: 175px;">
                                                        <strong class="text-body"><%=chatUser.getuFName() + " " + chatUser.getuLName()%></strong>
                                                        <span class="text-muted text-ellipsis"><%=chatUser.getuID()%></span>
                                                    </span>
                                                </a>
                                            </li>
                                            <%
                                                    }
                                                }
                                            %>
                                        </ul>
                                        <div class="sidebar-heading d-flex">
                                            <div class="flex text-muted">GRIEVANCE MANAGERS</div>
                                        </div>
                                        <% String actionStatus = (String) request.getSession().getAttribute("actionStatus");%>
                                        <input type="hidden" id="actionStatus" value="<%= actionStatus%>" />
                                        <ul class="list-group list-group-flush mb-3">
                                            <%
                                                for (User chatUser : chatParticipants) {
                                                    if (!chatUser.getuType().equals("Employee")) {
                                            %>
                                            <li class="list-group-item px-3 py-12pt">
                                                <a href="#"
                                                   class="d-flex align-items-center position-relative">
                                                    <span class="avatar avatar-xs avatar-offline mr-3 flex-shrink-0">

                                                        <span class="avatar-title rounded-circle">M</span>

                                                    </span>
                                                    <span class="flex d-flex flex-column"
                                                          style="max-width: 175px;">
                                                        <strong class="text-body"><%=chatUser.getuFName() + " " + chatUser.getuLName()%></strong>
                                                        <%if(specificGrievanceData.getgL3Manager().equals(chatUser.getuID())){ %>
                                                        <span class="text-muted text-ellipsis">(ASSIGNED MANAGER)</span>
                                                        <%}%>
                                                        <span class="text-muted text-ellipsis"><%=chatUser.getuID()%></span>
                                                        <span class="text-muted text-ellipsis"><%=chatUser.getuType()%></span>
                                                    </span>
                                                </a>
                                            </li>
                                            <%
                                                    }
                                                }
                                            %>
                                            <%if (specificGrievanceData.getgStatus().equals("Processing")) {%>
                                            <%if (authUser.getuType().equals("Administrator") || authUser.getuType().equals("Manager - Level 1")) {%>
                                            <li class="list-group-item px-3 py-12pt ">
                                                <button class="btn btn-dark " data-href="<%=request.getContextPath()%>/AssignChatMember?type=director&grievanceID=<%= specificGrievanceData.getgID()%>&gStatus=<%= specificGrievanceData.getgStatus()%>" data-toggle="modal" data-target="#confirm-assign-director">  + Assign to a Director  </button>
                                            </li>
                                            <% }%>
                                            <%if (authUser.getuType().equals("Manager - Level 1") || authUser.getuType().equals("Manager - Level 2")) {%>
                                            <li class="list-group-item px-3 py-12pt ">
                                                <button class="btn btn-primary" data-href="<%=request.getContextPath()%>/AssignChatMember?type=l1Manager&grievanceID=<%= specificGrievanceData.getgID()%>&gStatus=<%= specificGrievanceData.getgStatus()%>" data-toggle="modal" data-target="#confirm-assign-level1Manager">+ Assign A L1 Manager</button>
                                            </li>
                                            <% }%>
                                            <%if (authUser.getuType().equals("Manager - Level 2") || authUser.getuType().equals("Manager - Level 3")) {%>
                                            <li class="list-group-item px-3 py-12pt ">
                                                <button class="btn btn-primary" data-href="<%=request.getContextPath()%>/AssignChatMember?type=l2Manager&grievanceID=<%= specificGrievanceData.getgID()%>&gStatus=<%= specificGrievanceData.getgStatus()%>" data-toggle="modal" data-target="#confirm-assign-level2Manager">+ Assign A L2 Manager</button>
                                            </li>
                                            <li class="list-group-item px-3 py-12pt ">
                                                <button class="btn btn-primary" data-href="<%=request.getContextPath()%>/AssignChatMember?type=l3Manager&grievanceID=<%= specificGrievanceData.getgID()%>&gStatus=<%= specificGrievanceData.getgStatus()%>" data-toggle="modal" data-target="#confirm-assign-level3Manager">+ Assign A L3 Manager</button>
                                            </li>
                                            <% }%>
                                            <% }%>

                                            <%if (specificGrievanceData.getgStatus().equals("Finished")) {%>
                                            <li class="list-group-item px-3 py-12pt ">
                                                <button class="btn btn-success" data-href="<%=request.getContextPath()%>/GrievanceChatAction?action=start&grievanceID=<%= specificGrievanceData.getgID()%>&gStatus=<%= specificGrievanceData.getgStatus()%>" data-toggle="modal" data-target="#confirm-start-grievance">Start This Grievance</button>
                                            </li>
                                            <% }%>
                                            <%if (specificGrievanceData.getgStatus().equals("Processing")) {%>
                                            <li class="list-group-item px-3 py-12pt ">
                                                <button class="btn btn-warning" data-href="<%=request.getContextPath()%>/GrievanceChatAction?action=finish&grievanceID=<%= specificGrievanceData.getgID()%>&gStatus=<%= specificGrievanceData.getgStatus()%>" data-toggle="modal" data-target="#confirm-finish-grievance">Finish This Grievance</button>
                                            </li>
                                            <% }%>
                                            

                                        </ul>
                                    </div>
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

        <!-- App Settings FAB -->

        <!-- jQuery -->
        <%@include file="../content/popupModel.jsp" %>
        <%@include file="../includes/script.jsp" %>
        <!-- Messages App -->

        <script>
            function addMyMessageToRoom(userID, userName, message, date, time) {
                const para = document.createElement("li");
                para.classList.add("message");
                para.classList.add("d-inline-flex");
                const subElOne = "<div class='message__aside'><a href='profile.html' class='avatar avatar-sm'><img src='assets/images/people/110/guy-6.jpg'class='avatar-img rounded-circle'></a></div>"
                const subElTwo = "<div class='message__body__ltr card'><div class='card-body'><div class='d-flex align-items-center'><div class='flex mr-3'><a href='profile.html' class='text-body'><strong>" + userName + " (" + userID + ")" + "</strong></a></div><div><small class='text-50'>" + date + "</small></div></div><span class='text-70'>" + message + "</span><div class='d-flex justify-content-end'><small class='text-50'>" + time + "</small></div></div></div>"
                para.innerHTML = subElTwo;
                const element = document.getElementById("chatRoom");
                element.appendChild(para);
            }
            ;

            function addIncomingMessageToRoom(userID, userName, message, date, time) {
                const para = document.createElement("li");
                para.classList.add("message");
                para.classList.add("d-inline-flex");
                const subElOne = "<div class='message__aside'><a href='profile.html' class='avatar avatar-sm'><img src='assets/images/people/110/guy-6.jpg'class='avatar-img rounded-circle'></a></div>"
                const subElTwo = "<div class='message__body__rtl card'><div class='card-body'><div class='d-flex align-items-center'><div class='flex mr-3'><a href='profile.html' class='text-body'><strong>" + userName + " (" + userID + ")" + "</strong></a></div><div><small class='text-50'>" + date + "</small></div></div><span class='text-70'>" + message + "</span><div class='d-flex justify-content-end'><small class='text-50'>" + time + "</small></div></div></div>"
                para.innerHTML = subElTwo;
                const element = document.getElementById("chatRoom");
                element.appendChild(para);
            }
            ;


            var websocket = new WebSocket("<%=Constant.WEB_SOCKET_ADDRESS%>");
            websocket.onmessage = function processMessage(message) {
                console.log("message executed");
                var jsonData = JSON.parse(message.data);
                console.log("message start");
                console.log("chatTokenID from session" + chatTokenID.value);
                console.log("chatTokenID from msg" + jsonData.chatTokenID);
                if (jsonData.message !== null && jsonData.chatTokenID === chatTokenID.value) {
                    if (jsonData.userID === currentUser.value) {
                        console.log("my message");
                        console.log("json user :" + jsonData.userName);
                        console.log("logged user :" + currentUser.value);
                        addMyMessageToRoom(jsonData.userID, jsonData.userName, jsonData.message, jsonData.date_stamp, jsonData.time_stamp);
                    } else {
                        console.log("other message");
                        console.log("json user :" + jsonData.userName);
                        console.log("logged user :" + currentUser.value);
                        addIncomingMessageToRoom(jsonData.userID, jsonData.userName, jsonData.message, jsonData.date_stamp, jsonData.time_stamp);
                    }
                    console.log("Out json user :" + jsonData.userName);
                    console.log("Out logged user :" + currentUser.value);
                    messageText.value = "";
                }

                document.getElementById("chatRoom").scrollIntoView(false);

                console.log(jsonData.message + "\n");
            }
            function sendMessage() {
                websocket.send(messageText.value);
                console.log("message sent");

            }
            ;

        </script>

        <script src="${pageContext.request.contextPath}/admin/assets/js/messages.js"></script> 
    </body>


</html>