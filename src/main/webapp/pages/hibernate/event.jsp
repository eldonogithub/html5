<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="urn:ca:blackperl:taglib:html5" prefix="html5"%>
<c:url var="baseUrl" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width">

<title>Create Event</title>
<link rel="stylesheet" href="${baseUrl }/js/jquery-ui.css">
<script src="${baseUrl }/js/jquery-1.12.1.js"></script>
<script src="${baseUrl }/js/jquery-ui.js"></script>
<link rel="stylesheet"
    href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="${baseUrl }/bootstrap/js/bootstrap.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			minDate : new Date()
		});
	});
</script>
<link rel="stylesheet" href='<c:out value="${baseUrl }/css/main.css"/>'>
</head>
<body>
    <logic:notPresent name="org.apache.struts.action.MESSAGE"
        scope="application">
        <font color="red"> ERROR: Application resources not
            loaded -- check servlet container logs for error messages. </font>
    </logic:notPresent>
    <div class="inputForm">
        <header class="header"></header>
        <nav class="nav-bar">
            <ul class="nav">
                <li><html:link page="/">Home</html:link></li>
                <li><a href="#">menu 2</a></li>
                <li><a href="#">menu 3</a></li>
            </ul>
        </nav>

        <section class="content">
            <div class="col1"></div>
            <div class="col2">
                <html:errors />
                <html:form styleClass="contact_form"
                    action="/hibernate/event.do">
                    <ul>
                        <li>
                            <h2>Create Event</h2> <span
                            class="required_notification">*
                                Denotes Required Field</span>
                        </li>
                        <li><label>Title:</label> <html:text
                                property="title"></html:text></li>
                        <li><label>Date:</label> <html:text
                                styleId="datepicker" property="date"></html:text></li>
                        <li id="button"><button type="submit"
                                class="submit" name="submit"
                                value="create">Create</button>
                            <button type="submit" class="submit"
                                name="submit" value="cancel">Cancel</button></li>
                    </ul>
                </html:form>
            </div>
            <div class="col3"></div>
        </section>
    </div>
</body>
</html>