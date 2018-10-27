<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp"/>
    <body>
    <jsp:include page="internalMenuPanel.jsp"/>

    <h2>Welcome Back <c:if test="${formValidation == 'false'}">${firstName}</c:if>${user.firstName}</h2>

    <div class="container">
        <div id="editProfileContainer">
            <div id="validationMsg"></div>

            <form action="/choreographybuilder/editUserProfile" method="post" id="editProfileForm">
                <div class="form-group">
                    <label for="editFirstName">First Name:</label>
                    <input type="text" class="form-control" id="editFirstName" placeholder="first name" name="firstName"
                           value="<c:if test="${formValidation == 'false'}">${firstName}</c:if>${user.firstName}">
                </div>
                <div class="form-group">
                    <label for="editLastName">Last Name:</label>
                    <input type="text" class="form-control" id="editLastName" placeholder="last name" name="lastName"
                           value="<c:if test="${formValidation == 'false'}">${lastName}</c:if>${user.lastName}">
                </div>
                <div class="form-group">
                    <label for="editUserEmail">Email:</label>
                    <input type="text" class="form-control" id="editUserEmail" placeholder="email" name="email"
                           value="<c:if test="${formValidation == 'false'}">${email}</c:if>${user.email}">
                </div>
                <div class="form-group">
                    <label for="editUserPassword">Password</label>
                    <input type="password" class="form-control" id="editUserPassword" name="password" placeholder="password">
                </div>
                <button type="submit" class="btn btn-success" id="editProfileBtn" name="submit">Submit</button>
            </form>

        </div>

    </div>
    <jsp:include page="internalFooter.jsp"/>
    </body>
</html>

<script>
    $(document).ready(function () {
        <c:if test="${formValidation == 'false'}">
            var validationMsg = 'Please enter all the values including password.';
            var messageId = 'validationMsg';
            validateForm(validationMsg, messageId);
        </c:if>
    });

</script>
