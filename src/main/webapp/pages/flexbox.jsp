<c:url var="cssUrl" value="/css/flexbox.css"></c:url>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/includes/head.jspf" %>
<title>Flexbox</title>
</head>
<body>
    <logic:notPresent name="org.apache.struts.action.MESSAGE"
        scope="application">
        <section id="container">
            <font color="red"> ERROR: Application resources not
                loaded -- check servlet container logs for error
                messages. </font>
        </section>
    </logic:notPresent>

    <section>
        <div id="container">
            <p>justify-content: flex-start</p>
            <div id="flex-start">
                <div></div>
                <div></div>
                <div></div>
            </div>

            <p>justify-content: flex-end</p>
            <div id="flex-end">
                <div></div>
                <div></div>
                <div></div>
            </div>

            <p>justify-content: center</p>
            <div id="center">
                <div></div>
                <div></div>
                <div></div>
            </div>

            <p>justify-content: space-between</p>
            <div id="space-between">
                <div></div>
                <div></div>
                <div></div>
            </div>

            <p>justify-content: space-around</p>
            <div id="space-around">
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
    </section>

</body>
</html>