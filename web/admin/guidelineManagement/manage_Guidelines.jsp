<%-- 
    Document   : index
    Created on : March 16, 2022, 9:31:27 PM
--%>

<%@page import="com.grms.data.model.User"%>
<%@page import="com.grms.data.model.Guideline"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"
      dir="ltr">


    <head>
        <title>Grievance Guidelines</title>
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
                <div class="border-bottom-2 py-32pt position-relative z-1">
                    <div class="container-fluid page__container d-flex flex-column flex-md-row align-items-center text-center text-sm-left">
                        <div class="flex d-flex flex-column flex-sm-row align-items-center mb-24pt mb-md-0">

                            <div class="mb-24pt mb-sm-0 mr-sm-24pt">
                                <h2 class="mb-0">GRIEVANCE GUIDELINES</h2>

                                <ol class="breadcrumb p-0 m-0">
                                    <li class="breadcrumb-item">Grievance Guidelines - Manage Guidelines</li>

                                </ol>
                            </div>
                        </div>
                    </div>
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
                        <div class="row mb-32pt">

                            <div class="col-lg-12 d-flex align-items-center">
                                <div class="flex"
                                     style="max-width: 100%">
                                    <form action="<%=request.getContextPath()%>/AddGuideline" method="POST" enctype="multipart/form-data">
                                        <div class="was-validated">
                                            <div class="form-row ">
                                                <div class="col-12 col-md-6 mb-3 " style="display:none;" id="gLVersion">
                                                    <% String actionStatus = request.getSession().getAttribute("actionStatus").toString();%>
                                                    <input type="hidden" id="actionStatus" value="<%= actionStatus%>" />
                                                    <label class="form-label"
                                                           
                                                           >GUIDELINE VERSION</label>
                                                    <input type="text"
                                                           class="form-control"
                                                           placeholder="Guideline Version here"
                                                           required
                                                           readonly
                                                           id="gLVersionID"
                                                           value="">

                                                    <div class="invalid-feedback">Please provide Guideline Title.</div>
                                                    <div class="valid-feedback">Looks good!</div>
                                                </div>
                                            </div>
                                            <div class="form-row ">
                                                <div class="col-12 col-md-6 mb-3 " style="display:none;" id="gLVersionUDate">
                                                   <label class="form-label"
                                                        >GUIDELINE UPLOADED DATE</label>
                                                    <input type="text"
                                                           class="form-control"
                                                           placeholder="Guideline Uploaded Date here"
                                                           required
                                                           id="gLUDate"
                                                           readonly
                                                           value="">
                                                </div>
                                                <div class="col-12 col-md-6 mb-3 " style="display:none;" id="gLVersionMDate">
                                                   <label class="form-label"
                                                        >GUIDELINE MODIFIED DATE</label>
                                                    <input type="text"
                                                           class="form-control"
                                                           placeholder="Guideline Modified Date here"
                                                           required
                                                           id="gLMDate"
                                                           readonly
                                                           value="">
                                                </div>
                                            </div>
                                            <div class="form-row ">
                                                <div class="col-12 col-md-6 mb-3">
                                                    <label class="form-label"
                                                           >GUIDELINE TITLE</label>
                                                    <input type="text"
                                                           class="form-control"
                                                           placeholder="Guideline Title here"
                                                           required
                                                           name="gLTitle"
                                                           id="gLTitle"
                                                           value="">

                                                    <div class="invalid-feedback">Please provide Guideline Title.</div>
                                                    <div class="valid-feedback">Looks good!</div>
                                                </div>
                                                <div class="col-12 col-md-6 " id="gLFileDiv">
                                                    <label class="form-label"
                                                           >BROWSE GUIDELINE (PDF Files ONLY)</label>
                                                    <input type="file"
                                                           accept="application/pdf"
                                                           required=""
                                                           name="gLFile"
                                                           id="gLFile">
                                                    <div class="invalid-feedback">Please select a Guidance PDF</div>
                                                    <div class="valid-feedback">Looks good!</div>
                                                </div>
                                                
                                            </div>
                                            <div class="form-row mb-3">
                                                
                                                <div class="col-12 col-md-12 mb-5">
                                                    <label class="form-label"
                                                           >GUIDELINE DESCRIPTION</label>
                                                    <textarea class="form-control h-100"
                                                           placeholder="Guideline Description here"
                                                           required
                                                           name="gLDescription"
                                                           id="gLDescription" 
                                                           ></textarea>
                                                    <div class="invalid-feedback">Please provide a description for Guideline.</div>
                                                    <div class="valid-feedback">Looks good!</div>
                                                </div>
                                            </div>
                                        </div>
                                        <button class="btn btn-primary"
                                                type="submit" id ="add" name="formAction" value="ADD USER">ADD GUIDELINE</button>        
                                        <button class="btn btn-success"
                                                type="submit" id ="update" name="formAction" value="UPDATE USER">UPDATE GUIDELINE</button>
                                        <button class="btn btn-dark"
                                                type="reset" id="clearButton" onclick="showDiv()">CLEAR FIELDS</button>
                                    </form>
                                </div>
                            </div>
                        </div>                                       

                    </div>
                </div>


                <!-- footer -->
                <%@include  file="../includes/footer.jsp" %>
                <!-- // END footer -->

            </div>

            <!-- // END drawer-layout__content -->

            <!-- drawer -->
            <%@include  file="../includes/drawer.jsp" %>
            <!-- // END drawer -->
        </div>
        <!-- // END drawer-layout -->


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
        <%@include file="../includes/script.jsp" %>

    </body>
</html>