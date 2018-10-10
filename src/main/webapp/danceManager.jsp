<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <body>
        <jsp:include page="internalMenuPanel.jsp"/>
        <h2></h2>

        <div class="container">
            <div class="scrollbar" id="style-1">
                <div class="force-overflow">
                    <table class="table" id="customStepTable">
                        <thead>
                        <th>Step Name</th>
                        <th>Lead Description</th>
                        <th>Follower Description</th>
                        <th>Level</th>
                        <th>Dance Type</th>
                        <ht></ht>
                        </thead>
                        <tbody id="customStepsTbody">
                        <c:forEach var="customStep" items="${customSteps}">
                            <tr>
                                <td>${customStep.stepName}</td>
                                <td>${customStep.leadDescription}</td>
                                <td>${customStep.followerDescription}</td>
                                <td>${customStep.level}</td>
                                <td>${customStep.danceName}</td>
                                <td>
                                    <a class="step" href="/choreographybuilder/removeCustomStep?step=${customStep.id}">
                                    <span style="font-size:20px" class="glyphicon glyphicon-trash"></span>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <div style="text-align: center" id="buildDanceBtnContainer">
                <a href="buildDance.jsp"><button type="button" class="btn btn-success">Build New Dance</button></a>
            </div>

        </div>

        <jsp:include page="internalFooter.jsp"/>
        <jsp:include page="head.jsp"/>
    </body>
</html>








