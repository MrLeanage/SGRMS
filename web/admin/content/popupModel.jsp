<%-- 
    Document   : smallModel
    Created on : March 4, 2022, 1:45:19 AM
--%>

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
    <div class="modal-dialog modal-dialog-centered ">
        <div class="modal-content">
            <div class="modal-header modal-header-dark">
                <h5 class="modal-title">CONFIRM YOUR SELECTED ACTION</h5>
            </div>
            <div class="modal-body">
                <h6>Do You want to delete selected Record?</h6>
            </div>
            <div class="modal-footer">
                <a class="btn btn-ok">Delete</a>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="confirm-assign-level3Manager" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header modal-header-dark">
                <h5 class="modal-title">CONFIRM YOUR SELECTED ACTION</h5>
            </div>
            <div class="modal-body">
                <h5>Do You want to Assign A L3 Manager?</h5>
            </div>
            <div class="modal-footer">
                <a class="btn btn-primary">Assign</a>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="confirm-assign-level2Manager" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header modal-header-dark">
                <h5 class="modal-title">CONFIRM YOUR SELECTED ACTION</h5>
            </div>
            <div class="modal-body">
                <h5>Do You want to Assign A L2 Manager?</h5>
            </div>
            <div class="modal-footer">
                <a class="btn btn-primary">Assign</a>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="confirm-assign-level1Manager" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header modal-header-dark">
                <h5 class="modal-title">CONFIRM YOUR SELECTED ACTION</h5>
            </div>
            <div class="modal-body">
                <h5>Do You want to Assign A L1 Manager?</h5>
            </div>
            <div class="modal-footer">
                <a class="btn btn-primary">Assign</a>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="confirm-assign-director" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header modal-header-dark">
                <h5 class="modal-title">CONFIRM YOUR SELECTED ACTION</h5>
            </div>
            <div class="modal-body">
                <h5>Do You want to Assign to A Director?</h5>
            </div>
            <div class="modal-footer">
                <a class="btn btn-dark">Assign</a>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>
            <div class="modal fade" id="confirm-finish-grievance" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header modal-header-dark">
                <h5 class="modal-title">CONFIRM YOUR SELECTED ACTION</h5>
            </div>
            <div class="modal-body">
                <h5>Do You want to Finish this processing Grievance?</h5>
            </div>
            <div class="modal-footer">
                <a class="btn btn-warning">Finish</a>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>
            <div class="modal fade" id="confirm-start-grievance" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header modal-header-dark">
                <h5 class="modal-title">CONFIRM YOUR SELECTED ACTION</h5>
            </div>
            <div class="modal-body">
                <h5>Do You want to Start the Finished Grievance Again?</h5>
            </div>
            <div class="modal-footer">
                <a class="btn btn-success">Start</a>
                
                <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>