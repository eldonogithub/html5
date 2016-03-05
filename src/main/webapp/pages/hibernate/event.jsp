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
<jsp:include page="/pages/head.jsp"></jsp:include>
<title>Create Event</title>
</head>
<body>
    <logic:notPresent name="org.apache.struts.action.MESSAGE"
        scope="application">
        <font color="red"> ERROR: Application resources not
            loaded -- check servlet container logs for error messages. </font>
    </logic:notPresent>
    <div class="inputForm">
        <header class="header"></header>
        <jsp:include page="/pages/menu.jsp"></jsp:include>
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
                        <li id="button"><label></label>
                        <button type="submit" class="submit"
                                name="submit" value="create">Create</button>
                            <button type="submit" class="submit"
                                name="submit" value="cancel">Cancel</button></li>
                    </ul>
                </html:form>
            </div>
            <div class="col3"></div>
        </section>
        <section class="content">
            <div class="col1"></div>
            <div class="col2">
                <c:if test="${not empty eventForm.events }">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Title</th>
                                <th>Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item"
                                items="${eventForm.events}">
                                <tr>
                                    <td>${item.id }</td>
                                    <td>${item.title }</td>
                                    <td>${item.date }</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
            <div class="col3"></div>
        </section>
    </div>
</body>
</html>