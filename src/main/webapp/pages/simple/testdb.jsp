<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<sql:query var="rs" dataSource="jdbc/TestDB">
select * from testdata
</sql:query>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/includes/head.jspf" %>
<title>DB Test</title>
</head>
<body>
    <div class="inputForm">
        <header class="header"></header>
        <%@ include file="/includes/menu.jspf" %>
        <section class="content">

            <h2>Results</h2>

            <c:if test="${not empty rs.rows }">
                <table id="testdata">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="row" items="${rs.rows}">
                            <tr>
                                <td>${row.id }</td>
                                <td>${row.name }</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </section>
    </div>
</body>
</html>