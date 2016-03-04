<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="urn:ca:blackperl:taglib:html5" prefix="html5"%>
<c:url var="baseUrl" value="/" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width">
<title>Create Person</title>
<link rel="stylesheet" href='<c:out value="${baseUrl }/css/main.css"/>'>
</head>
<body>
    <logic:notPresent name="org.apache.struts.action.MESSAGE"
        scope="application">
        <font color="red"> ERROR: Application resources not
            loaded -- check servlet container logs for error messages. </font>
    </logic:notPresent>

    <html:errors />
    <hr>
    <html:link page="/">Home</html:link>

    <html:form action="/hibernate/person.do" styleClass="contact_form">
        <fieldset>
            <legend>Create Person</legend>
            <ul>
                <li>
                    <h2>Create Person</h2> <span
                    class="required_notification">* Denotes
                        Required Field</span>
                </li>
                <li><label for="firstname">First Name:</label> <html:text
                        property="firstname"></html:text></li>
                <li><label for="lastname">Last Name:</label> <html:text
                        property="lastname"></html:text></li>
                <li><label for="age">Age:</label> <html:text
                        property="age"></html:text></li>
                <li><button name="submit" class="submit"
                        value="createPerson">Create Person</button></li>
            </ul>
        </fieldset>
    </html:form>
</body>
</html>