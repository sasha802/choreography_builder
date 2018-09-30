<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <table>
        <tbody>
        <c:forEach var="customStep" items="${customSteps}">
                <tr>
                    <td>${customStep.danceName}</td>
                    <td>${customStep.leadDescription}</td>
                    <td>${customStep.followerDescription}</td>
                    <td>${customStep.followerDescription}</td>
                    <td>${customStep.level}</td>
                    <td><a class="step" href="#deleteStepServlet&step=..."><span style="font-size:20px" class="glyphicon glyphicon-trash"></span></a></td>
                </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>
