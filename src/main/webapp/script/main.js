$(document).ready(function () {

    $('.step').click(function () {
      $(this).closest('tr').remove();

        location.reload();
    });

});
