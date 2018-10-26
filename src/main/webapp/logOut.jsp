<!DOCTYPE html>
<html>
    <body>
        <jsp:include page="publicMenuPanel.jsp"/>
        <div class="container">

            <%@ page session="true" %>
            <div class="alert alert-success">
                <h3>Thank you for visiting.</h3>
            </div>

            <% session.invalidate(); %>

        </div>

        <jsp:include page="footer.jsp"/>
        <jsp:include page="head.jsp"/>
    </body>
</html>
