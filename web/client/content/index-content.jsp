

<!--<div class="border-bottom-2 py-32pt position-relative z-1">
    <div class="container-fluid page__container d-flex flex-column flex-md-row align-items-center text-center text-sm-left">
        <div class="flex d-flex flex-column flex-sm-row align-items-center mb-24pt mb-md-0">

            <div class="mb-24pt mb-sm-0 mr-sm-24pt">
                <h2 class="mb-0">Welcome to GRMS - Grievance Redressal Management System</h2>

            </div>
        </div>
    </div>
</div>-->

<div class="container-fluid page__container">
    <div class="page-section">

        <div class="row card-group-row mb-lg-8pt">
            <div class="col-xl-12 col-md-6 card-group-row__col">
                <div class="card card-group-row__card">
                    <div class="card-body d-flex flex-column align-items-center">
                        <div class="p-3">
                             <img src="${pageContext.request.contextPath}/client/assets/images/stories/student-workspace.jpg" class="img-fluid" alt="Responsive image">
                            <div class="alert alert-dark mb-lg-32pt">
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
        

        

    </div>
</div>

<!-- footer -->
    <%@include  file="../includes/footer.jsp" %>
<!-- // END footer -->