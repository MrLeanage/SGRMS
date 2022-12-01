<%-- 
    Document   : index-content
    Created on : March 3, 2022, 4:06:11 PM
--%>



<%@page import="com.grms.data.model.FeedbackPerformance"%>
<%@page import="com.grms.data.model.User"%>
<%@page import="com.grms.data.model.Guideline"%>

<%@page import="java.util.ArrayList"%>
<div class="border-bottom-2 py-32pt position-relative z-1">
    <div class="container-fluid page__container d-flex flex-column flex-md-row align-items-center text-center text-sm-left">
        <div class="flex d-flex flex-column flex-sm-row align-items-center mb-24pt mb-md-0">
            <%Integer pendingCount = (Integer) request.getAttribute("pendingCount");%>
            <%Integer processingCount = (Integer) request.getAttribute("processingCount");%>
            <%Integer finishedCount = (Integer) request.getAttribute("FinishedCount");%>
            <div class="mb-24pt mb-sm-0 mr-sm-24pt">
                <h2 class="mb-0">GRIEVANCE REDRESSEL MANAGEMENT SYSTEM</h2>

                <ol class="breadcrumb p-0 m-0">
                    <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/Dashboard">Home</a></li>

                    <li class="breadcrumb-item active">

                        Dashboard

                    </li>

                </ol>

            </div>



        </div>
    </div>
</div>

<div class="container-fluid page__container">
    <div class="page-section">





        <div class="row card-group-row mb-lg-8pt">
            <div class="col-xl-12 col-md-6 card-group-row__col">
                <div class="card card-group-row__card">
                    <div class="card-body d-flex flex-column align-items-center">
                        <div class="p-3">
                            <div class="alert alert-primary mb-lg-32pt">
                                <div class="d-flex flex-wrap align-items-start">
                                    <div class="mr-8pt">
                                        <i class="material-icons">access_time</i>
                                    </div>
                                    <div class="flex"
                                         style="min-width: 180px">
                                        <h4>WELCOME BACK <%=user.getuFName().toUpperCase()%>, HOW IS YOUR DAY?</h4>

                                    </div>
                                </div>
                            </div>
                            <img src="${pageContext.request.contextPath}/admin/assets/images/stories/workplace.jpg" class="img-fluid" alt="Responsive image">
                            <div class="alert alert-soft-success mb-lg-32pt">
                                <div class="d-flex flex-wrap align-items-start">
                                    <div class="mr-8pt">
                                        <i class="fa fa-medal"></i>
                                    </div>
                                    <div class="flex"
                                         style="min-width: 180px">

                                        <small class="text-100">

                                            <span>You may experience some issues with the Analytics API. Stay up to date by following our status page.</span>
                                        </small>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
<%if (user.getuType().equals("Administrator")) {%>                    
        <div class="row mb-lg-8pt">
            <div class="col-lg-4">
                <div class="card">
                    <div class="card-body d-flex align-items-center">
                        <div class="h2 mb-0 mr-3"><%=pendingCount%></div>
                        <div class="flex">
                            <p class="mb-0"><strong>TOTAL PENDING</strong></p>
                            <p class="text-50 mb-0 mt-n1 d-flex align-items-center">
                                TICKETS
                            </p>
                        </div>
                        <i class="material-icons icon-48pt text-20 ml-2">access_time</i>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="card">
                    <div class="card-body d-flex align-items-center">
                        <div class="h2 mb-0 mr-3"><%=processingCount%></div>
                        <div class="flex">
                            <p class="mb-0"><strong>TOTAL PROCESSING</strong></p>
                            <p class="text-50 mb-0 mt-n1 d-flex align-items-center">
                                TICKETS
                            </p>
                        </div>
                        <i class="fa fa-hand-holding-medical icon-48pt text-20 ml-2"></i>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="card">
                    <div class="card-body d-flex align-items-center">
                        <div class="h2 mb-0 mr-3"><%=finishedCount%></div>
                        <div class="flex">
                            <p class="mb-0"><strong>TOTAL FINISHED</strong></p>
                            <p class="text-50 mb-0 mt-n1 d-flex align-items-center">
                                TICKETS
                            </p>
                        </div>
                        <i class="fa fa-check icon-48pt text-20 ml-2"></i>
                    </div>
                </div>
            </div>

        </div>
        <%}%>
      
        <div class="page-separator">
            <div class="page-separator__text">QUICK LINKS</div>
        </div>
        <div class="row card-group-row mb-lg-8pt">

            <div class="col-xl-6 col-md-6 card-group-row__col">
                <div class="card card-group-row__card">
                    <div class="card-body d-flex flex-column align-items-center">

                        <div class="d-flex align-items-center">
                            <div class="h4 mb-0 mr-3">PENDING GRIEVANCES</div>
                            <div class="flex">

                                <div class="col-auto border-left">
                                    <a href="<%=request.getContextPath()%>/PendingGrievance"
                                       class="btn btn-primary">CHECK NOW</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-6 col-md-6 card-group-row__col">
                <div class="card card-group-row__card">
                    <div class="card-body d-flex flex-column align-items-center">

                        <div class="d-flex align-items-center">
                            <div class="h4 mb-0 mr-3">ONGOING GRIEVANCES</div>
                            <div class="flex">
                                <div class="col-auto border-left">
                                    <a href="<%=request.getContextPath()%>/ProcessingGrievance"
                                       class="btn btn-success">CHECK NOW</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-6 col-md-6 card-group-row__col">
                <div class="card card-group-row__card">
                    <div class="card-body d-flex flex-column align-items-center">


                        <div class="d-flex align-items-center">
                            <div class="h4 mb-0 mr-3">FINISHED GRIEVANCES</div>
                            <div class="flex">
                                <div class="col-auto border-left">
                                    <a href="<%=request.getContextPath()%>/FinishedGrievance"
                                       class="btn btn-warning">CHECK NOW</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        
        <%if (user.getuType().equals("Manager - Level 3") || user.getuType().equals("Manager - Level 2")) { %>
        <div class="page-separator">
            <div class="page-separator__text">REGISTERED STUDENTS</div>
        </div>
        <div class="row mb-32pt">

            <div class="col-lg-12 d-flex align-items-center">
                <div class="flex"
                     style="max-width: 100%">
                    <input class="form-control" id="myInput" type="text" placeholder="Search..">
                    <br>

                    <div class="table-wrapper-scroll-y my-custom-scrollbar">
                        <table class="table table-bordered table-striped mb-0 data-table sortable" id="usersTable">
                            <thead class="thead-dark">
                            <th>Student ID</th>
                            <th>FIRST NAME</th>
                            <th>LAST NAME</th>
                            <th>ACCOUNT TYPE</th>
                            <th>ACCOUNT STATUS</th>
                            <th>ACTION</th>

                            </thead>

                            <tbody  id="myTable">
                                <%
                                    ArrayList<User> userList = (ArrayList<User>) request.getAttribute("userList");
                                    for (User userInfo : userList) {
                                %>
                                <tr>
                                    <td><%=userInfo.getuID()%></td>
                                    <td><%=userInfo.getuFName()%></td>
                                    <td><%=userInfo.getuLName()%></td>
                                    <td><%=userInfo.getuType()%></td>
                                    <td><%=userInfo.getuStatus()%></td>
                                    <td><a href="<%=request.getContextPath()%>/ManageStudent" class="btn btn-primary">MANAGE STUDENTS</a></td>

                                </tr>
                                <% }%>
                            </tbody>
                        </table>
                    </div>


                </div>
            </div>
        </div>  
        <%}%>
<div class="row card-group-row mb-lg-8pt">

            <div class="col-lg card-group-row__col">
                <div class="card card-group-row__card">
                    <div class="card-header d-flex align-items-center">
                        <strong class="flex">FEEDBACK SUMMARY</strong>
                        <a href="#"><i class="material-icons text-50">more_horiz</i></a>
                    </div>
                    <% ArrayList<FeedbackPerformance> feedbackPerformanceList = (ArrayList<FeedbackPerformance>) request.getAttribute("feedbackPerformanceList"); %>
                    <div class="card-body d-flex flex-column align-items-center justify-content-center">
                        <ul class="list-unstyled list-skills w-100">
                            <% for (FeedbackPerformance feedbackPerformance : feedbackPerformanceList) {%>
                            <li class="mb-8pt">
                                <div class="text-100 border-right"><small><%=feedbackPerformance.getCategory()%></small></div>
                                <div class="flex">
                                    <div class="progress"
                                         style="height: 10px;">
                                        <% if (feedbackPerformance.getCategory().equals("Service Appreciation Feedback")) {%>
                                        <div class="progress-bar bg-success"
                                             role="progressbar"
                                             style="width: <%=feedbackPerformance.getPercentage()%>%"
                                             aria-valuenow="61"
                                             aria-valuemin="0"
                                             aria-valuemax="100"></div>
                                        <% }%>
                                        <% if (feedbackPerformance.getCategory().equals("Service Complain Feedback")) {%>
                                        <div class="progress-bar bg-danger"
                                             role="progressbar"
                                             style="width: <%=feedbackPerformance.getPercentage()%>%"
                                             aria-valuenow="61"
                                             aria-valuemin="0"
                                             aria-valuemax="100"></div>
                                        <% }%>
                                        <% if (feedbackPerformance.getCategory().equals("Service Request to Re Open Grievance")) {%>
                                        <div class="progress-bar bg-warning"
                                             role="progressbar"
                                             style="width: <%=feedbackPerformance.getPercentage()%>%"
                                             aria-valuenow="61"
                                             aria-valuemin="0"
                                             aria-valuemax="100"></div>
                                        <% }%>
                                    </div>



                                </div>
                                <div class="text-70"><small><%=feedbackPerformance.getPercentage()%>%</small></div>
                            </li>
                            <%}%>

                        </ul>
                    </div>
                    <div class="card-footer p-8pt">

                        <ul class="pagination justify-content-start pagination-xsm m-0">
                            <li class="page-item disabled">
                                <a class="page-link"
                                   href="#"
                                   aria-label="Previous">
                                    <span aria-hidden="true"
                                          class="material-icons">chevron_left</span>
                                    <span>Prev</span>
                                </a>
                            </li>
                            <li class="page-item dropdown">
                                <a class="page-link dropdown-toggle"
                                   data-toggle="dropdown"
                                   href="#"
                                   aria-label="Page">
                                    <span>1</span>
                                </a>
                                <div class="dropdown-menu">
                                    <a href="#"
                                       class="dropdown-item active">1</a>
                                    <a href="#"
                                       class="dropdown-item">2</a>
                                    <a href="#"
                                       class="dropdown-item">3</a>
                                    <a href="#"
                                       class="dropdown-item">4</a>
                                    <a href="#"
                                       class="dropdown-item">5</a>
                                </div>
                            </li>
                            <li class="page-item">
                                <a class="page-link"
                                   href="#"
                                   aria-label="Next">
                                    <span>Next</span>
                                    <span aria-hidden="true"
                                          class="material-icons">chevron_right</span>
                                </a>
                            </li>
                        </ul>

                    </div>
                </div>
            </div>
        </div>
        <div class="page-separator">
            <div class="page-separator__text">Discussions</div>
        </div>

        <div class="container-fluid page__container">
            <div class="page-section">




                <div class="container p-1">
                    <p>Add Your Grievance Guideline description here</p>
                </div>

                <div class="row mb-32pt">

                    <div class="col-lg-12 d-flex align-items-center">
                        <div class="flex"
                             style="max-width: 100%">
                            <input class="form-control" id="myInput" type="text" placeholder="Search..">
                            <br>

                            <div class="table-wrapper-scroll-y my-custom-scrollbar">
                                <table class="table table-bordered table-striped mb-0 data-table sortable" id="usersTable">
                                    <thead class="thead-dark">
                                    <th>VERSION</th>
                                    <th>TITLE</th>
                                    <th>DESCRIPTION</th>
                                    <th>UPLOADED DATE</th>
                                    <th>LAST MODIFY DATE</th>
                                    <th>ACTION</th>


                                    </thead>

                                    <tbody  id="myTable">
                                        <%
                                            ArrayList<Guideline> guidelineList = (ArrayList<Guideline>) request.getAttribute("guidelineList");
                                            for (Guideline guideline : guidelineList) {
                                        %>
                                        <tr>
                                            <td><%=guideline.getgLVersionID()%></td>
                                            <td><%=guideline.getgLTitle()%></td>
                                            <td><%=guideline.getgLDescription()%></td>
                                            <td><%=guideline.getgLUploadDate()%></td>
                                            <td><%=guideline.getgLModifyDate()%></td>
                                            <td><button class="btn btn-success" ><a style="color:white;" href="<%=request.getContextPath()%>/DownloadGuideline?gLVersionID=<%=guideline.getIntegergLVersionID()%>"><b>DOWNLOAD</b></a></button></td>

                                        </tr>
                                        <% }%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>                                                  

            </div>
        </div>
        <script>
            var table = document.getElementById("usersTable"), rIndex;
            for (var i = 0; i < table.rows.length; i++) {
                table.rows[i].onclick = function ()
                {
                    $("#gLVersion").show();
                    $("#gLVersionUDate").show();
                    $("#gLVersionMDate").show();
                    rIndex = this.rowIndex;
                    document.getElementById("gLVersionID").value = this.cells[0].innerHTML;
                    document.getElementById("gLTitle").value = this.cells[1].innerHTML;
                    document.getElementById("gLDescription").value = this.cells[2].innerHTML
                    document.getElementById("gLUDate").value = this.cells[3].innerHTML
                    document.getElementById("gLMDate").value = this.cells[4].innerHTML
                    $("#gLFileDiv").hide();
                    $("#add").hide();
                    $("#update").show();
                }
            }
            function showDiv() {
                $("#gLVersion").hide();
                $("#gLFileDiv").show();
                $("#gLVersionUDate").hide();
                $("#gLVersionMDate").hide();
            }
        </script>
        <%@include file="../content/popupModel.jsp" %>

    </div>
</div>

<!-- footer -->
<%@include  file="../includes/footer.jsp" %>
<!-- // END footer -->