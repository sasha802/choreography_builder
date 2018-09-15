<!DOCTYPE html>
<html>
<jsp:include page="head.jsp"/>
    <body>
    <jsp:include page="publicMenuPanel.jsp" />
        <div class="container">

            <div id="signupContainer">
                <form action="#" method="post">
                    <div class="form-group">
                        <label for="firstName">First Name:</label>
                        <input type="text" class="form-control" id="firstName" placeholder="first name">
                    </div>
                    <div class="form-group">
                        <label for="lastName">Last Name:</label>
                        <input type="text" class="form-control" id="lastName" placeholder="last name">
                    </div>
                    <div class="form-group">
                        <label for="userEmail">First Name:</label>
                        <input type="text" class="form-control" id="userEmail" placeholder="email">
                    </div>
                    <div class="form-group">
                        <label for="userPassword">Password</label>
                        <input type="password" class="form-control" id="userPassword" placeholder="password">
                    </div>
                    <button type="submit" class="btn btn-success">Submit</button>
                </form>
            </div>

        </div>

    <jsp:include page="footer.jsp"/>

    </body>
</html>
