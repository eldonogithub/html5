<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="cssUrl" value="/css/main.css"></c:url>
<sql:query var="rs" dataSource="jdbc/TestDB">
select * from testdata
</sql:query>
<html>
<head>
<title>DB Test</title>
<link rel="stylesheet" href='<c:out value="${cssUrl }"/>'>
</head>
<body>
    <div class="inputForm">
        <header class="header"></header>
        <nav class="nav-bar">
            <ul class="nav">
                <li><a href="#">menu 1</a></li>
                <li><a href="#">menu 2</a></li>
                <li><a href="#">menu 3</a></li>
            </ul>
        </nav>
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