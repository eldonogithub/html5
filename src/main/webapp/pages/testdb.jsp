<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<sql:query var="rs" dataSource="jdbc/TestDB">
select * from testdata
</sql:query>

<html>
<head>
<title>DB Test</title>
</head>
<body>

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
                <tr><td>${row.id }</td><td>${row.name }</td></tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

</body>
</html>