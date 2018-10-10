
$(document).ready(function () {

    var tbody = $('#customStepTable tbody');

    if ( tbody.children().length == 0 ) {

        $('#style-1').css('display', 'none');

        $('<div><h4>You have no custom steps available</h4></div>').insertBefore('#buildDanceBtnContainer a');
    }


    $('.step').click(function () {

      $(this).closest('tr').remove();
        location.reload();
    });

});
