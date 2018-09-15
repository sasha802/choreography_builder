<!DOCTYPE html>
<html>
<jsp:include page="head.jsp"/>
    <body>
    <jsp:include page="publicMenuPanel.jsp"/>
    <div class="container">

        <div id="loginContainer">
            <form action="#" method="post">
                <div class="form-group">
                    <label for="emilField">Email address</label>
                    <input type="email" class="form-control" id="emilField" aria-describedby="emailHelp" placeholder="Enter email">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label for="passwordField">Password</label>
                    <input type="password" class="form-control" id="passwordField" placeholder="Password">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

        </div>

    </div>


    <jsp:include page="footer.jsp"/>
    </body>
</html>
