<!DOCTYPE html>
<html>
<head>
<%@ include file="/includes/head.jspf" %>
<title>Done</title>
</head>
<body>
    <logic:notPresent name="org.apache.struts.action.MESSAGE"
        scope="application">
        <section id="container"> <font color="red">
            ERROR: Application resources not loaded -- check servlet
            container logs for error messages. </font> </section>
    </logic:notPresent>

    <h1>Done</h1>
    <ul>
    	<li>${fileForm.file.contentType }</li>
    	<li>${fileForm.file.fileSize }</li>
    	<li>${fileForm.file.fileName }</li>
    </ul>
    <html:link action="/simple/load.do">Load Form</html:link>
</body>
</html>