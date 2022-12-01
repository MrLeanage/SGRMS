

<!-- Modal -->

<div class="modal fade" id="successPopupModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered " role="document">
        <div class="modal-content">
            <div class="modal-header modal-header-dark">
                <h5 class="modal-title" id="exampleModalLongTitle">ACTION SUCCESS</h5>
                <button type="button" class="close model-btn-close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <center><h6><%=request.getSession().getAttribute("actionMsg").toString()%></h6></center>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-dark" data-dismiss="modal">Close</button>
            </div>
        </div>  
    </div>
</div>

<!-- Failed Modal -->
<div class="modal fade" id="failedPopupModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered " role="document">
        <div class="modal-content">
            <div class="modal-header modal-header-dark">
                <h5 class="modal-title" id="exampleModalLongTitle">ACTION FAILED</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <center><h6 style="color: red"><%=request.getSession().getAttribute("actionMsg").toString()%></h6></center>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-dark" data-dismiss="modal">Close</button>
            </div>
        </div>  
    </div>
</div>

<!-- Failed Modal -->
<div class="modal fade" id="errorPopupModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered " role="document">
        <div class="modal-content">
            <div class="modal-header modal-header-dark">
                <h5 class="modal-title" id="exampleModalLongTitle">ERROR OCCURRED</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <center><h6 style="color: red"><%=request.getSession().getAttribute("actionMsg").toString()%></h6></center>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-dark" data-dismiss="modal">Close</button>
            </div>
        </div>  
    </div>
</div>

<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header modal-header-dark">
                <h5 class="modal-title">CONFIRM YOUR SELECTED ACTION</h5>
            </div>
            <div class="modal-body">
                <h5>Do You want to delete selected Record?</h5>
            </div>
            <div class="modal-footer">
                <a class="btn btn-danger btn-ok">Delete</a>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>

