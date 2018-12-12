<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp"/>
    <body>
        <jsp:include page="internalMenuPanel.jsp"/>
        <div class="container">
            <div id="aboutDanceMovement" class="col-md-12">
                <h3>Why do we like to move to the beat?</h3>
                <p>
                    Many things stimulate our brains' reward centers, among them, coordinated movements. Consider the
                    thrill some get from watching choreographed fight or car chase scenes in action movies. What about
                    the enjoyment spectators get when watching sports or actually riding on a roller coaster or in a fast car?

                    Scientists aren't sure why we like movement so much, but there's certainly a lot of anecdotal
                    evidence to suggest we get a pretty big kick out of it. Maybe synchronizing music, which many
                    studies have shown is pleasing to both the ear and brain, and movement-in essence, dance-may
                    constitute a pleasure double play.
                </p>
            </div>
            <hr style="border: solid 1px #7f8cba1c" />

            <h3 style="padding-top: 20px">Please select the dance to learn about the movement.</h3>

            <div id="danceSelection">
                <form action="/choreographybuilder/danceMovement" method="POST">

                    <div class="form-group">
                        <select name="danceName" class="form-control">
                            <option value="Waltz">Waltz</option>
                            <option value="Rumba">Rumba</option>
                            <option value="Swing">Swing</option>
                        </select>
                    </div>

                    <div class="form-group" style="text-align: center">
                        <button type="submit" name="submit" class="btn btn-warning">Get Movement</button>
                    </div>
                </form>
            </div>

            <h4>${danceName} technique</h4>
            <div class="col-sm-12" id="danceMovementContainer">

                <div id="danceMovementResult" class="col-sm-6">
                    <h5>Dance Movement</h5>
                    <p id="movementDesc" style="font-weight:400;text-align:left">${danceMovement}</p>
                </div>

                <div id="dancePositionResult" class="col-sm-6">
                    <h5>Dance Position</h5>
                    <p id="positionDesc" style="font-weight:400;text-align:left">${dancePosition}</p>
                </div>
                <div class="clearfix"></div>

            </div>

        </div>
        <jsp:include page="internalFooter.jsp"/>
    </body>
</html>




