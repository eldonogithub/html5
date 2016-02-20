<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="urn:ca:blackperl:taglib:html5" prefix="html5"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>
<link rel="stylesheet"
    href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<c:url var="cssUrl" value="/css/main.css"></c:url>
<link rel="stylesheet" href='<c:out value="${cssUrl }"/>'>
</head>
<body>
    <div class="inputForm">
        <header class="header"></header>
        <nav class="nav-bar">
            <ul class="nav">
                <li><a href="#">menu 1</a></li>
                <li><a href="#">menu 2</a></li>
                <li><a href="#">menu 3</a></li>
            </ul>
        </nav>
        <section class="content">
            <div class="col1"></div>
            <div class="col2">
                <html:errors />
                <html:form action="/form/process.do"
                    styleClass="contact_form">
                    <ul>
                        <li>
                            <h2>Contact Us</h2> <span
                            class="required_notification">*
                                Denotes Required Field</span>
                        </li>
                        <li><label for="inputText">Name:</label> <html5:input
                                type="text" property="inputText"
                                placeholder="John Doe"></html5:input></li>
                        <li><label for="emailAddress">Email
                                Address:</label> <html5:input type="email"
                                property="emailAddress"
                                placeholder="john_doe@example.com" /> <span
                            class="form_hint">Proper format
                                "name@something.com"</span></li>
                        <li><label for="date">Date:</label> <html:text
                                styleId="datepicker" property="date" /></li>
                        <li><label for="website">Website:</label> <html5:input
                                type="text" property="website"
                                placeholder="http://johndoe.com/" /> <span
                            class="form_hint">Proper format
                                "http://someaddress.com"</span></li>
                        <li><label for="message">Message:</label> <textarea
                                name="message" cols="40" rows="6"></textarea></li>
                        <li><button type="submit" class="submit"
                                value="submit">Submit Form</button></li>
                    </ul>
                </html:form>
            </div>
            <div class="col3"></div>
        </section>
        <footer class="footer"></footer>
    </div>
</body>
</html>