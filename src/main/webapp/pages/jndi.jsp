<!DOCTYPE html>
<html>
<head>
<%@ include file="/includes/head.jspf"%>
</head>
<body>
    <logic:notPresent name="org.apache.struts.action.MESSAGE"
        scope="application">
        <font color="red"> ERROR: Application resources not
            loaded -- check servlet container logs for error messages. </font>
    </logic:notPresent>
    <div class="inputForm">
        <header class="header"></header>
        <%@ include file="/includes/menu.jspf"%>
        <section class="content">
            <div class="col1"></div>
            <div class="col2">
                <html:errors />
                <ul>
                    <c:forEach var="item"
                        items="${ jndiForm.list }">
                        <li>${item.name } - ${item.className }</li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col3"></div>
        </section>
    </div>
</body>
</html>