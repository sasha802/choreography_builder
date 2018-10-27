<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp"/>
    <body>
        <jsp:include page="publicMenuPanel.jsp"/>
        <div class="container">
            <div id="loginContainer">
                <FORM ACTION="j_security_check" METHOD="POST">
                    <div class="form-group">
                        <label>Email:</label>
                        <INPUT class="form-control" TYPE="TEXT" NAME="j_username">
                        <label>Password:</label>
                        <INPUT class="form-control" TYPE="PASSWORD" NAME="j_password">
                    </div>
                    <button type="SUBMIT" class="btn btn-primary">Log In</button>
                </FORM>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
