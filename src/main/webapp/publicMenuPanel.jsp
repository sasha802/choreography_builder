
<link rel="stylesheet" href="styles/mobile.css" type="text/css">

<div class="menuContainer">
    <a href="index.jsp">About First Dance</a>
    <a href="signup.jsp">Sign Up</a>
    <a href="searchStep"><span class="glyphicon glyphicon-log-in"></span></a>
</div>

<div id="menuIcon">
    <span class="glyphicon glyphicon-menu-hamburger"></span>
</div>


<div id="menuLinks">
    <ul>
        <li><a href="index.jsp">About First Dance</a></li>
        <li><a href="signup.jsp">Sign Up</a></li>
        <li><a href="searchStep"><span class="glyphicon glyphicon-log-in"></span></a></li>
    </ul>

</div>


<div id="imageContainer">
    <style>#imageContainer{background-image: url("images/danceBanner.jpg")}</style>
</div>


<script>
    $(document).ready(function () {

         $('#menuIcon').click(function () {
             $('#menuLinks').slideToggle('fast');
         });

         $(window).resize(function () {
             if ($(this).width > 720) {
                 $('#menuLinks').hide();
             }
         });
    });
</script>