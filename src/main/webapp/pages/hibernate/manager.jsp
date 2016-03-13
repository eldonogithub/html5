<!DOCTYPE html>
<html>
<head>
<%@ include file="/includes/head.jspf" %>
<title>Manager</title>
</head>
<body>
    <logic:notPresent name="org.apache.struts.action.MESSAGE"
        scope="application">
        <font color="red"> ERROR: Application resources not
            loaded -- check servlet container logs for error messages. </font>
    </logic:notPresent>

    <hr>
    <div class="inputForm">
        <header class="header"></header>
        <%@ include file="/includes/menu.jspf" %>
        <section class="content">
            <div class="col1"></div>
            <div class="col2">
                <html:errors />
                <html:form action="/hibernate/manager.do"
                    styleClass="contact_form">
                    <ul>
                        <li>
                            <h2>Add Person To Event</h2> <span
                            class="required_notification">*
                                Denotes Required Field</span>
                        </li>
                        <li><label for="personId">PersonId:</label> <html:text
                                property="personId"></html:text></li>
                        <li><label for="eventId">EventId:</label> <html:text
                                property="eventId"></html:text></li>
                        <li><label></label>
                            <button type="submit" class="submit"
                                name="method" value="addPersonToEvent">Add
                                Person To Event</button></li>
                    </ul>
                </html:form>
            </div>
            <div class="col3"></div>
        </section>

        <section class="content">
            <div class="col1"></div>
            <div class="col2">
                <h1>Events</h1>
                <c:if test="${not empty managerForm.events }">
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
                                items="${managerForm.events}">
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
        <section class="content">
            <div class="col1"></div>
            <div class="col2">
                <h1>Persons</h1>
                <c:if test="${not empty managerForm.persons }">
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
            </div>
            <div class="col3"></div>
        </section>
        <footer class="footer"></footer>
    </div>
</body>
</html>