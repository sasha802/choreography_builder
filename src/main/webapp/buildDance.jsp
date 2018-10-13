<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body>
        <jsp:include page="internalMenuPanel.jsp"/>
        <h2>Lets Build Your Dance ${userFirstName}!</h2>

        <div class="container">

            <div id="buildDance">
                <form action="/choreographybuilder/searchStep" method="post" id="buildDanceForm">
                    <div class="form-group">
                        <label for="beatsNumber">Enter beats per minute</label>
                        <input type="text" class="form-control" id="beatsNumber" name="beatsNumber" placeholder="beats/minute"
                               value="${beats}">
                    </div>

                    <div>
                        <label>Choreography Type:&nbsp;</label>
                        <input type="radio" id="basic" checked
                               name="level" <c:if test="${level == 'basic'}">checked</c:if> value="basic">
                        <label for="basic">Basic</label>

                        <input type="radio" id="intermediate"
                               name="level" <c:if test="${level == 'intermidiate'}">checked</c:if> value="intermidiate">
                        <label for="intermediate">Intermediate</label>

                        <input type="radio" id="advanced"
                               name="level" <c:if test="${level == 'advanced'}">checked</c:if> value="advanced">
                        <label for="advanced">advanced</label>
                    </div>

                    <br />

                    <div class="form-row align-items-center" style="padding-bottom: 20px">
                        <label for="numberOfSteps">Number Of Steps:&nbsp;</label>
                        <select class="custom-select" id="numberOfSteps" name="numberOfSteps">
                            <option name="numberOfSteps" <c:if test="${numberOfSteps == 1}">selected</c:if> value="1">One</option>
                            <option name="numberOfSteps" <c:if test="${numberOfSteps == 2}">selected</c:if> value="2">Two</option>
                            <option name="numberOfSteps" <c:if test="${numberOfSteps == 3}">selected</c:if> value="3">Three</option>
                            <option name="numberOfSteps" <c:if test="${numberOfSteps == 4}">selected</c:if> value="4">Four</option>
                            <option name="numberOfSteps" <c:if test="${numberOfSteps == 5}">selected</c:if> value="5">Five</option>
                        </select>
                    </div>

                    <c:if test="${saved == 'saved'}">
                        <div>
                            <h5>Yor step was successful saved. <a href="/choreographybuilder/displayCustomSteps">View My Steps</a></h5>

                        </div>
                    </c:if>

                    <button id="buildDanceBtn" type="submit" name="submit" value="submit" class="btn btn-success">Build Dance</button>

                </form>


            </div>

            <div style="text-align: center">
                <c:forEach var="dance" items="${dance}">
                    Your ${dance.danceName} Dance Choreography
                </c:forEach>
            </div>

            <div>
                <table class="table" id="stepsTable">

                    <tbody id="stepData">
                    <c:forEach var="steps" items="${step}">
                        <tr>
                            <td>${steps.stepName}</td>
                            <td><img class="descriptionImg" src="images/${steps.leadDescription}"/></td>
                            <td><img class="descriptionImg" src="images/${steps.followerDescription}"/></td>
                            <td>${steps.level}</td>
                            <c:forEach var="dance" items="${dance}">
                                <td><a href="/choreographybuilder/saveStep?stepName=${steps.stepName}&danceName=${dance.danceName}&leadDescription=${steps.leadDescription}
                            &followerDescription=${steps.followerDescription}&level=${steps.level}&beats=${beats}&numberOfSteps=${numberOfSteps}&user=${userId}">Save Step</a></td>
                            </c:forEach>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>

        </div>


        <jsp:include page="internalFooter.jsp"/>
        <jsp:include page="head.jsp"/>
    </body>
</html>

<style>
    .descriptionImg {
        width: 200px;
        height: 100px;
    }
</style>


