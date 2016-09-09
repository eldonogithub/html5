<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/includes/head.jspf" %>
<title>Form</title>
</head>
<body>
    <div class="inputForm">
        <header class="header"></header>
        <%@ include file="/includes/menu.jspf" %>
        <section class="content">
            <div class="col1"></div>
            <div class="col2">
                <logic:notPresent
                    name="org.apache.struts.action.MESSAGE"
                    scope="application">
                    <font color="red"> ERROR: Application
                        resources not loaded -- check servlet container
                        logs for error messages. </font>
                </logic:notPresent>

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
                        <li id="button"><button type="submit" class="submit"
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