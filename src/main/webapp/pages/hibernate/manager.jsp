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
<title>Manager</title>
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
    <nav class="nav-bar">
        <ul class="nav">
            <li><html:link page="/">Home</html:link></li>
            <li><a href="#">menu 2</a></li>
            <li><a href="#">menu 3</a></li>
        </ul>
    </nav>

    <section>
        <html:form action="/hibernate/manager.do"
            styleClass="contact_form">
            <fieldset>
                <legend>Buttons trigger hibernate to perform
                    actions</legend>
                <ul>
                    <li><label for="personId"></label> <html:text
                            property="personId"></html:text></li>
                    <li><label for="eventId"></label> <html:text
                            property="eventId"></html:text></li>
                    <li><button type="submit" class="submit" name="method"
                            value="addPersonToEvent">Add Person
                            To Event</button></li>
                </ul>
            </fieldset>
        </html:form>
    </section>

    <section>
        <c:if test="${not empty managerForm.events }">
            <table id="events">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${managerForm.events}">
                        <tr>
                            <td>${item.id }</td>
                            <td>${item.title }</td>
                            <td>${item.date }</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </section>
    <section>
        <c:if test="${not empty managerForm.persons }">
            <table id="events">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Age</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item"
                        items="${managerForm.persons }">
                        <tr>
                            <td>${item.id }</td>
                            <td>${item.firstname}</td>
                            <td>${item.lastname}</td>
                            <td>${item.age}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </section>
</body>
</html>