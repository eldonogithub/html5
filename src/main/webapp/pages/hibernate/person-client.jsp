<!DOCTYPE html>
<html>
<head>
<%@ include file="/includes/head.jspf"%>
<title>Person</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/ju/dt-1.10.12/datatables.min.css" />

<script type="text/javascript" src="https://cdn.datatables.net/v/ju/dt-1.10.12/datatables.min.js"></script>
<script src="${baseUrl }/js/person-client.js"></script>
<style type="text/css">
#delete-confirm {
	display: none;
}
</style>
</head>

<body>
    <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
        <font color="red"> ERROR: Application resources not loaded -- check servlet container logs for error messages. </font>
    </logic:notPresent>
    <header class="header"></header>
    <%@ include file="/includes/menu.jspf"%>
    <section class="content">
        <hr>
        <div class="col1"></div>
        <div class="col2">
            <html:errors />
            <html:form action="/hibernate/person/client.do" styleId="personForm" styleClass="contact_form">
                <ul>
                    <html:hidden property="id" />
                    <li>
                        <h2>Persons</h2> <span class="required_notification">* Denotes Required Field</span>
                    </li>

                    <li><label for="id">ID:</label> <html:text property="id" disabled="true"></html:text></li>
                    <li><label for="firstname">First Name:</label> <html:text property="firstname"></html:text></li>
                    <li><label for="lastname">Last Name:</label> <html:text property="lastname"></html:text></li>
                    <li><label for="age">Age:</label> <html:text property="age"></html:text></li>
                    <li><label></label>
                        <button type="submit" name="submit" class="submit" value="createPerson">Create Person</button>
                        <button type="submit" name="submit" class="submit" value="updatePerson">Update Person</button>
                        <button type="reset" name="submit" class="submit" value="reset">Reset</button></li>
                </ul>
            </html:form>
        </div>
        <div class="col3"></div>
    </section>
    <section class="content"></section>
    <section class="content">
        <div class="col1"></div>
        <div class="col2">
            <h1>Persons</h1>
            Person size: <span id="personSize"></span>
            <table id="personTable" class="table stripe row-border hover">
            </table>
        </div>
        <div class="col3"></div>
    </section>
    <footer class="footer"></footer>
    <div id="delete-confirm" title="Delete Person">
        <p>
            <span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span><span id="msg"></span>
        </p>
    </div>
</body>
</html>
