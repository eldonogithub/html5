<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="urn:ca:blackperl:taglib:html5" prefix="html5"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:url var="baseUrl" value="/" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/pages/head.jsp"></jsp:include>
<title>Person</title>
</head>
<body>
    <logic:notPresent name="org.apache.struts.action.MESSAGE"
        scope="application">
        <font color="red"> ERROR: Application resources not
            loaded -- check servlet container logs for error messages. </font>
    </logic:notPresent>
    <jsp:include page="/pages/menu.jsp"></jsp:include>
    <section class="content">
        <hr>
        <div class="col1"></div>
        <div class="col2">
            <html:errors />
            <html:form action="/hibernate/person.do"
                styleClass="contact_form">
                <ul>
                    <li>
                        <h2>Create Person</h2> <span
                        class="required_notification">* Denotes
                            Required Field</span>
                    </li>
                    <li><label for="firstname">First Name:</label>
                        <html:text property="firstname"></html:text></li>
                    <li><label for="lastname">Last Name:</label> <html:text
                            property="lastname"></html:text></li>
                    <li><label for="age">Age:</label> <html:text
                            property="age"></html:text></li>
                    <li><label></label>
                        <button name="submit" class="submit"
                            value="createPerson">Create Person</button></li>
                </ul>
            </html:form>
        </div>
        <div class="col3"></div>
    </section>
    <section class="content">
        <div class="col1"></div>
        <div class="col2">
            <h1>Persons</h1>
            Person size:
            <c:out value="${fn:length(personForm.persons) }"></c:out>
            <c:if test="${not empty personForm.persons }">
                <table class="table">
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
                            items="${personForm.persons }">
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
        </div>
        <div class="col3"></div>
    </section>
</body>
</html>
