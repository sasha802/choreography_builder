<!DOCTYPE html>
<html>
    <body>
        <jsp:include page="publicMenuPanel.jsp"/>
        <div class="container">

            <div id="loginContainer">

                <FORM ACTION="j_security_check" METHOD="POST">
                    <TABLE>
                        <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
                        <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
                        <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
                    </TABLE>
                </FORM>
                <%--<form action="#" method="post">
                    <div class="form-group">
                        <label for="emilField">Email address</label>
                        <input type="email" class="form-control" id="emilField" aria-describedby="emailHelp" placeholder="Enter email">
                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                    </div>
                    <div class="form-group">
                        < label for="passwordField">Password</label>
                        <input type="password" class="form-control" id="passwordField" placeholder="Password">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>--%>

            </div>

        </div>

        <a href="editProfile.jsp"><span>Test edit profile link</span></a>

        <jsp:include page="footer.jsp"/>
        <jsp:include page="head.jsp"/>
    </body>
</html>
