<script>
$(document).ready(function () {

    $('#mobile_main_menu .children').each(function () {

        var href = $(this).children('a').first().attr('href');
        var linkName = $(this).children('a').text();
        var html = '<li><a href="' + href + '">' + linkName + '</a></li>';

        $(this).find('ul').first().append(html);
    });


    $('#mobile_menu_toggle').click(function() {
        $('#mobile_main_menu').slideToggle('fast');
    });

    $('#mobile_main_menu ul > li a').on('click', function (event) {

        var $this = $(this);
        var submenu = $this.next("ul");

        if ($this.closest('li').hasClass('children')) {
            event.preventDefault();
        } else {
            return;
        }

        if (submenu.is(":visible")) {
            submenu.hide();
        } else {
            submenu.show();
        }

    });

    $(window).resize(function () {
        if ($(this).width() > 1024) {
            $('#mobile_main_menu').hide();
        }
    });


});
</script>