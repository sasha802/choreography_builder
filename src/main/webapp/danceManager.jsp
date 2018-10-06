<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <body>
        <jsp:include page="internalMenuPanel.jsp"/>
        <h2></h2>

        <div class="container">
            <div id="danceDetails">
            </div>
            <div class="scrollbar" id="style-1">
                <div class="force-overflow">
                    <table class="table" id="customStepTable">
                        <thead>
                        <th>Step Name</th>
                        <th>Lead Description</th>
                        <th>Follower Description</th>
                        <th>Dance Type</th>
                        <ht></ht>
                        </thead>
                        <tbody id="customStepsTbody">
                        <c:forEach var="customStep" items="${customSteps}">
                            <tr>
                                <td>${customStep.id}</td>
                                <td>${customStep.stepName}</td>
                                <td>${customStep.leadDescription}</td>
                                <td>${customStep.followerDescription}</td>
                                <td>${customStep.followerDescription}</td>
                                <td>${customStep.level}</td>
                                <td>${customStep.danceName}</td>
                                <td><a class="step" href="/choreographybuilder/removeCustomStep?step=${customStep.id}"><span style="font-size:20px" class="glyphicon glyphicon-trash"></span></a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>


            </div>

            <div style="text-align: center">
                <a href="buildDance.jsp"><button type="button" class="btn btn-success">Build New Dance</button></a>
            </div>

        </div>

        <jsp:include page="internalFooter.jsp"/>
        <jsp:include page="head.jsp"/>
    </body>
</html>

<%--<script>
    $(document).ready(function () {

        var customStepsTbody = $('#customStepsTbody tbody');

        if (customStepsTbody.length == 0) {

            console.log('empty');

            $('#customStepTable').css('display', 'none');
            $('#style-1').css('display', 'none');
            $('#danceDetails').html('<h2>You have no steps in your selection.<br/>Please build your dance to select steps.</h2>');
        }
    });
</script>--%>





