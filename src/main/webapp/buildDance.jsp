<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body>
        <jsp:include page="internalMenuPanel.jsp"/>
        <h2>Lets Build Your Dance ${user}!</h2>

        <div class="container">

            <div id="buildDance">
                <form action="/searchStep" method="post">
                    <div class="form-group">
                        <label for="beatsNumber">Enter beats per minute</label>
                        <input type="text" class="form-control" id="beatsNumber" name="beatsNumber" placeholder="beats/minute">
                    </div>

                    <div>
                        <label>Choreography Type:&nbsp;</label>
                        <input type="radio" id="basic" checked
                               name="level" value="basic">
                        <label for="basic">Basic</label>

                        <input type="radio" id="intermediate"
                               name="level" value="intermidiate">
                        <label for="intermediate">Intermediate</label>

                        <input type="radio" id="advanced"
                               name="level" value="advanced">
                        <label for="advanced">Advanced</label>
                    </div>

                    <br />
                    <div class="form-row align-items-center">
                        <label for="numberOfSteps">Number Of Steps:&nbsp;</label>
                        <select class="custom-select" id="numberOfSteps">
                            <option selected>Choose...</option>
                            <option name="1" value="1">One</option>
                            <option name="2" value="2">Two</option>
                            <option name="3" value="3">Three</option>
                            <option name="4" value="3">Four</option>
                            <option name="5" value="3">Five</option>
                        </select>
                    </div>
                    <br />
                    <button id="buildDanceBtn" type="submit" name="submit" value="submit" class="btn btn-success">Build Dance</button>

                </form>
            </div>

        </div>

        <div>
            <table class="table" id="stepsTable">

                <tbody id="stepData">
                <c:forEach var="steps" items="${steps}">
                    <tr>
                        <td>${steps.stepName}</td>
                        <td><img src="images/${steps.leadDescription}"/></td>
                        <td>${steps.level}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>

        <jsp:include page="internalFooter.jsp"/>
        <jsp:include page="head.jsp"/>
    </body>
</html>



