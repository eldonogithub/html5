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
<title>Insert title here</title>
</head>
<body>
    <logic:notPresent name="org.apache.struts.action.MESSAGE"
        scope="application">
        <font color="red"> ERROR: Application resources not
            loaded -- check servlet container logs for error messages. </font>
    </logic:notPresent>

    <html:errors />
    <hr>
    <html:link page="/hibernate/store.do?method=load">Event Store</html:link>
    <html:link page="/">Home</html:link>

    <html:form action="/hibernate/store.do">
        <fieldset>
            <legend>Buttons trigger hibernate to perform
                actions</legend>
            <html:text property="person.firstName"></html:text>
            <html:text property="person.lastName"></html:text>
            <html:text property="person.age"></html:text>
            <html:submit property="method" value="store"></html:submit>
            <html:submit property="method" value="list"></html:submit>
            <html:cancel></html:cancel>
        </fieldset>
    </html:form>

    <c:if test="${not empty eventForm.list }">
        <table id="events">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="eventForm.events">
                    <tr>
                        <td>${item.id }</td>
                        <td>${item.title }</td>
                        <td>${item.date }</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>