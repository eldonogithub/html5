<!DOCTYPE html>
<html>
<head>
<%@ include file="/includes/head.jspf" %>
<title>Person</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/t/ju/jqc-1.12.0,dt-1.10.11/datatables.min.css"/>
<script type="text/javascript" src="https://cdn.datatables.net/t/ju/jqc-1.12.0,dt-1.10.11/datatables.min.js"></script></head>
<script src="${baseUrl }/js/person.js"></script>
<body>
    <logic:notPresent name="org.apache.struts.action.MESSAGE"
        scope="application">
        <font color="red"> ERROR: Application resources not
            loaded -- check servlet container logs for error messages. </font>
    </logic:notPresent>
    <header class="header"></header>
    <%@ include file="/includes/menu.jspf" %>
    <section class="content">
        <hr>
        <div class="col1"></div>
        <div class="col2">
            <html:errors />
            <html:form action="/hibernate/person.do" styleId="personForm"
                styleClass="contact_form">
                <html:hidden property="id"/>
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
    </section>
    <section class="content">
        <div class="col1"></div>
        <div class="col2">
            <h1>Persons</h1>
            Person size:
            <c:out value="${fn:length(personForm.persons) }"></c:out>
                <table id="personForm" class="table">
                </table>
        </div>
        <div class="col3"></div>
    </section>
    <footer class="footer"></footer>
</body>
</html>
