<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp"/>
    <body>
        <jsp:include page="internalMenuPanel.jsp"/>
        <h2>Lets Build Your Dance ${userFirstName}!</h2>

        <c:if test="${saved == 'saved'}">
            <div>
                <h5>Your step was successful saved. <a style="color: #c12121;" href="/choreographybuilder/displayCustomSteps">View My Steps</a></h5>
            </div>
        </c:if>

        <div class="container">

            <div id="buildDance">
                <div id="validationMsg"></div>
                <form action="/choreographybuilder/searchStep" method="post" id="buildDanceForm">
                    <div class="form-group">
                        <label for="beatsNumber">Enter beats per minute:</label>
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
                            <option <c:if test="${numberOfSteps == 1}">selected</c:if> value="1">One</option>
                            <option <c:if test="${numberOfSteps == 2}">selected</c:if> value="2">Two</option>
                            <option <c:if test="${numberOfSteps == 3}">selected</c:if> value="3">Three</option>
                            <option <c:if test="${numberOfSteps == 4}">selected</c:if> value="4">Four</option>
                            <option <c:if test="${numberOfSteps == 5}">selected</c:if> value="5">Five</option>
                        </select>
                    </div>

                    <button id="buildDanceBtn" type="submit" name="submit" value="submit" class="btn">Build Dance</button>
                    <button id="addPersonalStepBtn" data-toggle="modal" data-target="#personalStepModal" type="button" class="btn">Add Personal Step</button>

                </form>


            </div>

            <div id="choreographyDanceName">
                <c:forEach var="dance" items="${dance}">
                    Your ${level} level ${dance.danceName} dance choreography
                </c:forEach>
            </div>


            <table class="table" id="stepsTable">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Lead Description</th>
                    <th>Follower Description</th>
                    <th>Level</th>
                    <th></th>
                </tr>
                </thead>

                <tbody id="stepData">
                <c:forEach var="steps" items="${step}">
                    <tr>
                        <td>${steps.stepName}</td>
                        <td>${steps.leadDescription}</td>
                        <td>${steps.followerDescription}</td>
                        <td>${steps.level}</td>
                        <c:forEach var="dance" items="${dance}">
                            <td><a href="/choreographybuilder/saveStep?stepName=${steps.stepName}&danceName=${dance.danceName}&leadDescription=${steps.leadDescription}
                        &followerDescription=${steps.followerDescription}&level=${steps.level}&beats=${beats}&numberOfSteps=${numberOfSteps}">
                                <span class="glyphicon glyphicon-save"></span></a></td>
                        </c:forEach>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>


        <!-- User defined steps Modal -->
        <div class="modal fade" id="personalStepModal" tabindex="-1" role="dialog" aria-label="personalStepModal" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Personal Step</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="/choreographybuilder/saveStep" method="POST">
                        <div class="modal-body">

                            <div class="form-group">
                                <label for="stepName">Step Name:</label>
                                <input type="text" class="form-control" placeholder="step name" name="stepName" />
                            </div>
                            <div class="form-group">
                                <label for="danceName">Dance Name:</label>
                                <input type="text" class="form-control" placeholder="dance name" name="danceName" />
                            </div>
                            <div class="form-group">
                                <label for="leadDescription">Lead Description:</label>
                                <input type="text" class="form-control" placeholder="lead description" name="lDescription" />
                            </div>
                            <div class="form-group">
                                <label for="followerDescription">Follower Description:</label>
                                <input type="text" class="form-control" placeholder="follower description" name="fDescription" />
                            </div>
                            <div class="form-group">
                                <label for="levelType">Level Type:</label>
                                <input type="text" class="form-control" placeholder="level" name="level" />
                            </div>

                        </div>

                        <div class="modal-footer" style="text-align: center">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-success">Save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="internalFooter.jsp"/>
    </body>
</html>

<script>
    $(document).ready(function () {
        <c:if test="${formValidation == 'false'}">
            var validationMsg = 'Please enter beats per minute.';
            var messageId = 'validationMsg';
            validateForm(validationMsg, messageId);
        </c:if>
    });
</script>


