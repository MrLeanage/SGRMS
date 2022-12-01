/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(window).load(function () {
    var value = $('input[type=hidden]').val();
    if(value === "success"){
        $('#successPopupModal').modal('show');
    }else if(value === "failed"){
        $('#failedPopupModal').modal('show');
    }else if(value === "error"){
        $('#errorPopupModal').modal('show');
    }
    $("#update").hide();
});

$(document).ready(function(){
    $('#clearButton').click(function() {
        $("#passwordDiv").show();
        $("#add").show();
        $("#update").hide();
        
    });
});

$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});

$('#confirm-delete').on('show.bs.modal', function(e) {
    $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
});

$('#confirm-logout').on('show.bs.modal', function(e) {
    $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
});

$(document).ready(function() {
    var table = $('#example').DataTable( {
        lengthChange: false,
        buttons: [ 'copy', 'excel', 'pdf', 'colvis' ]
    } );
 
    table.buttons().container()
        .appendTo( '#example_wrapper .col-md-6:eq(0)' );
} );
$('#confirm-assign-level3Manager').on('show.bs.modal', function(e) {
    $(this).find('.btn-primary').attr('href', $(e.relatedTarget).data('href'));
});
$('#confirm-assign-level2Manager').on('show.bs.modal', function(e) {
    $(this).find('.btn-primary').attr('href', $(e.relatedTarget).data('href'));
});
$('#confirm-assign-level1Manager').on('show.bs.modal', function(e) {
    $(this).find('.btn-primary').attr('href', $(e.relatedTarget).data('href'));
});
$('#confirm-assign-director').on('show.bs.modal', function(e) {
    $(this).find('.btn-dark').attr('href', $(e.relatedTarget).data('href'));
});
$('#confirm-finish-grievance').on('show.bs.modal', function(e) {
    $(this).find('.btn-warning').attr('href', $(e.relatedTarget).data('href'));
});
$('#confirm-start-grievance').on('show.bs.modal', function(e) {
    $(this).find('.btn-success').attr('href', $(e.relatedTarget).data('href'));
});



