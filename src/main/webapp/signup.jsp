<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp"/>
    <body>
    <jsp:include page="publicMenuPanel.jsp" />
        <div class="container">

            <div id="signupContainer">
                <div id="validationMsg"></div>
                <form action="/choreographybuilder/insertUser" method="post">
                    <div class="form-group">
                        <label for="firstName">First Name:</label>
                        <input type="text" class="form-control" id="firstName" name="firstName" placeholder="first name">
                    </div>
                    <div class="form-group">
                        <label for="lastName">Last Name:</label>
                        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="last name">
                    </div>

                    <div class="form-group">
                        <label for="userEmail">Email:</label>
                        <input type="text" class="form-control" id="userEmail" name="email" placeholder="email">
                    </div>
                    <div class="form-group">
                        <label for="userPassword">Password</label>
                        <input type="password" class="form-control" id="userPassword" name="password" placeholder="password">
                    </div>
                    <button type="submit" name="submit" class="btn btn-success">Submit</button>
                </form>
                <div>
                    <c:if test="${not empty user}">
                        <h4>Welcome ${user}. You may <a style="font-weight: 400" href="searchStep">Login</a> now.</h4>
                    </c:if>
                </div>

            </div>

        </div>

    <jsp:include page="footer.jsp"/>
    </body>
</html>

<script>
    $(document).ready(function () {
        <c:if test="${formValidation == 'false'}">

        var validationMsg = 'Please enter all the values to sing up.';
        var messageId = 'validationMsg';
        validateForm(validationMsg, messageId);

        </c:if>
    });
</script>