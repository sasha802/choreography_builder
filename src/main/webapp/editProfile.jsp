<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp"/>
    <body>
    <jsp:include page="internalMenuPanel.jsp"/>

    <h2>Welcome Back</h2>

    <div class="container">
        <div id="editProfileContainer">

            <form action="/updateUser" method="post">
                <div class="form-group">
                    <label for="editFirstName">First Name:</label>
                    <input type="text" class="form-control" id="editFirstName" placeholder="first name">
                </div>
                <div class="form-group">
                    <label for="editLastName">Last Name:</label>
                    <input type="text" class="form-control" id="editLastName" placeholder="last name">
                </div>
                <div class="form-group">
                    <label for="editUserEmail">First Name:</label>
                    <input type="text" class="form-control" id="editUserEmail" placeholder="email">
                </div>
                <div class="form-group">
                    <label for="editUserPassword">Password</label>
                    <input type="password" class="form-control" id="editUserPassword" placeholder="password">
                </div>
                <button type="submit" class="btn btn-success">Submit</button>
            </form>

        </div>

        <%--<div>
            <c:forEach var="users" items="${user}">

                <p>${users.firstName}</p>
                <p>${users.lastName}</p>
                <p>${users.id}</p>

            </c:forEach>
        </div>--%>
    </div>
    <jsp:include page="internalFooter.jsp"/>
    </body>
</html>
