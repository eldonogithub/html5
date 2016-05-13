<%--
    Licensed to the Apache Software Foundation (ASF) under one or more
    contributor license agreements.  See the NOTICE file distributed with
    this work for additional information regarding copyright ownership.
    The ASF licenses this file to You under the Apache License, Version 2.0
    (the "License"); you may not use this file except in compliance with
    the License.  You may obtain a copy of the License at
   
         http://www.apache.org/licenses/LICENSE-2.0
   
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
--%>
<html:html>
<head>
<%@ include file="/includes/head.jspf"%>
<title><bean:message key="welcome.title" /></title>
<html:base />
<link rel="stylesheet" href='${baseUrl }/css/main.css'>
</head>
<body>
    <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
        <font color="red"> ERROR: Application resources not loaded -- check servlet container logs for error messages. </font>
    </logic:notPresent>
    <header class="header"></header>
    <%@ include file="/includes/menu.jspf"%>
    <nav></nav>
    <section class="content">
        <div class="col1"></div>
        <div class="col2">
            <h3>
                <bean:message key="welcome.heading" />
            </h3>
            <p>
                <bean:message key="welcome.message" />
            </p>
            <ul>
                <li><html:link page="/jqueryui/index.html">JQuery UI</html:link></li>
                <li><html:link action="/jndi/log.do">Jndi Page</html:link></li>
                <li><html:link action="/Input.do">Input Form</html:link></li>
                <li><html:link action="/form/load.do">Load Token Form</html:link></li>
                <li><html:link page="/pages/simple/testdb.jsp">Test Database</html:link></li>
                <li><html:link page="/scripts/classpath.jsp">Class Path</html:link></li>
                <li><html:link page="/pages/flexbox.jsp">Flex Box</html:link></li>
                <li><html:link action="/derby/load.do">Derby Form</html:link></li>
                <li><html:link page="/dwr">Direct Web Remoting</html:link></li>
                <li><html:link page="/pages/ajax/testdb/ajax-yui.jsp">Ajax Test Data - YUI</html:link></li>
                <li><html:link page="/pages/ajax/testdb/ajax-bootstrap.jsp">Ajax Test Data - Bootstrap</html:link></li>
                <li><html:link page="/pages/ajax/testdb/modal-message.jsp">JQuery Modal Message</html:link></li>
                <li><html:link action="/hibernate/person/client.do">Person Form - Client Side</html:link></li>
                <li><html:link action="/hibernate/person/server.do">Person Form - Server Side</html:link></li>
                <li><html:link action="/hibernate/event.do">Event Form</html:link></li>
                <li><html:link action="/hibernate/manager.do?method=list">Manager Form</html:link></li>
                <li><html:link page="/pages/nicholahibbert.jsp">Nichola Hibbert 1</html:link></li>
                <li><html:link page="/pages/nicholahibbert2.jsp">Nichola Hibbert 2</html:link></li>
                <li><html:link action="/databases/toursdb/client.do">Tours DB - Client Side</html:link></li>
                <li><html:link action="/databases/toursdb/server.do">Tours DB - Server Side</html:link></li>
                <li><html:link action="/backbutton/test.do">Back Button Test</html:link></li>
            </ul>
        </div>
        <div class="col3"></div>
    </section>
</body>
</html:html>
