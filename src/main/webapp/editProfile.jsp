<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp"/>
    <body>
    <jsp:include page="internalMenuPanel.jsp"/>

    <h2>Welcome Back</h2>

    <div class="container">
        <div id="editProfileContainer">

            <form action="/choreographybuilder/editUserProfile" method="post" id="editProfileForm">
                <div class="form-group">
                    <label for="editFirstName">First Name:</label>
                    <input type="text" class="form-control" id="editFirstName" placeholder="first name" name="firstName" value="${user.firstName}">
                </div>
                <div class="form-group">
                    <label for="editLastName">Last Name:</label>
                    <input type="text" class="form-control" id="editLastName" placeholder="last name" name="lastName" value="${user.lastName}">
                </div>
                <div class="form-group">
                    <label for="editUserEmail">Email:</label>
                    <input type="text" class="form-control" id="editUserEmail" placeholder="email" name="email" value="${user.email}">
                </div>
                <div class="form-group">
                    <label for="editUserPassword">Password</label>
                    <input type="password" class="form-control" id="editUserPassword" name="password" placeholder="password">
                </div>
                <%--<button type="submit" class="btn btn-success" id="editProfileBtn" name="submit">Submit</button>--%>
                <button type="submit" class="btn btn-success" id="editProfileBtn" name="submit">Submit</button>
            </form>

        </div>

    </div>
    <jsp:include page="internalFooter.jsp"/>
    </body>
</html>

<script>
    $(document).ready(function () {


        /*$('#editProfileBtn').click(function () {

            if ( $('#validationMsg').length > 0 ) {
                $('#validationMsg').remove();

            }

            var firstName = $('#editFirstName').val();
            var lastName = $('#editLastName').val();
            var email = $('#editUserEmail').val();
            var password = $('#editUserPassword').val();

            if ( firstName.trim().length === 0 || lastName.trim().length === 0 ||  email.trim().length === 0
                || password.trim().length === 0 ) {

                var html = '<div id="validationMsg"><h4>Please make sure the form is fully completed.</h4></div>';

                $('#editProfileContainer').append(html);
                return;

            } else {

                $('#editProfileForm').submit();

            }
        });*/

    });
</script>
