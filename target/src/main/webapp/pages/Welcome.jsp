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
        </div>
        <div class="col3"></div>
    </section>
</body>
</html:html>
