<!DOCTYPE html>
<html>
    <body>
        <jsp:include page="publicMenuPanel.jsp"/>
        <div class="container">

            <%@ page session="true" %>
            <h2>Thank you for visiting.</h2>
            <% session.invalidate(); %>

        </div>

        <jsp:include page="footer.jsp"/>
        <jsp:include page="head.jsp"/>
    </body>
</html>
