<!DOCTYPE html>
<html>

    <body>
        <jsp:include page="internalMenuPanel.jsp"/>
        <h2></h2>

        <div class="container">
            <div>
                <a href="/customSteps"><button type="button" class="btn btn-info">Display My Steps</button></a>
            </div>
            <div id="danceDetails">
            </div>
            <div class="scrollbar" id="style-1">
                <div class="force-overflow">
                    <table class="table">
                        <thead>
                        <th>Order Number</th>
                        <th>Step Name</th>
                        <th>Lead Description</th>
                        <th>Follower Description</th>
                        <ht></ht>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td>Box Step</td>
                            <td>Fwd with left foot
                                Side with right foot
                                Close left foot to right foot
                                Back with right foot
                                Side with left foot
                                Close right foot to left foot
                            </td>
                            <td>
                                Back with right foot
                                Side with left foot
                                Close right foot to left foot
                                Fwd with left foot
                                Side with right foot
                                Close left foot to right foot
                            </td>
                            <td>
                                <a class="step" href="#deleteStepServlet&step=..."><span style="font-size:20px" class="glyphicon glyphicon-trash"></span></a>
                            </td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>Box Step</td>
                            <td>Fwd with left foot
                                Side with right foot
                                Close left foot to right foot
                                Back with right foot
                                Side with left foot
                                Close right foot to left foot
                            </td>
                            <td>
                                Back with right foot
                                Side with left foot
                                Close right foot to left foot
                                Fwd with left foot
                                Side with right foot
                                Close left foot to right foot
                            </td>
                            <td>
                                <a class="step" href="#deleteStepServlet&step=..."><span style="font-size:20px" class="glyphicon glyphicon-trash"></span></a>
                            </td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>Box Step</td>
                            <td>Fwd with left foot
                                Side with right foot
                                Close left foot to right foot
                                Back with right foot
                                Side with left foot
                                Close right foot to left foot
                            </td>
                            <td>
                                Back with right foot
                                Side with left foot
                                Close right foot to left foot
                                Fwd with left foot
                                Side with right foot
                                Close left foot to right foot
                            </td>
                            <td>
                                <a class="step" href="#deleteStepServlet&step=..."><span style="font-size:20px" class="glyphicon glyphicon-trash"></span></a>
                            </td>
                        </tr>
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





