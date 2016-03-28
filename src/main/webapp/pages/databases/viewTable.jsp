<!DOCTYPE html>
<html>
<head>
<%@ include file="/includes/head-toursdb.jspf"%>
<title>View Table - ${viewTable.tableName }</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/t/ju/jqc-1.12.0,dt-1.10.11/datatables.min.css" />
<script type="text/javascript" src="https://cdn.datatables.net/t/ju/jqc-1.12.0,dt-1.10.11/datatables.min.js"></script>
</head>
<script src="${baseUrl }/js/viewTable.js"></script>
<body>
    <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
        <font color="red">ERROR: Application resources not loaded -- check servlet container logs for error messages. </font>
    </logic:notPresent>
    <header class="header"></header>
    <%@ include file="/includes/menu.jspf"%>
    <section class="content">
        <div class="col2 ui-widget ui-widget-content ui-corner-top">
            <h1>${viewTable.tableName }</h1>
            <table id="toursdbForm" class="table">
                <thead>
                    <tr>
                        <c:forEach var="col"
                            items="${viewTable.results.header }">
                            <th><c:out value="${col }" /></th>
                        </c:forEach>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="row"
                        items="${viewTable.results.rows }">
                        <tr>
                            <c:forEach var="col" items="${row }">
                                <td><c:out value="${col }" /></td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </section>
    <footer class="footer"></footer>
</body>
</html>
