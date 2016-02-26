<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="cssUrl" value="/css/flexbox.css"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" href='<c:out value="${cssUrl }"/>'>
</head>
<body>
    <section>
        <div id="container">
            <p>justify-content: flex-start</p>
            <div id="flex-start">
                <div></div>
                <div></div>
                <div></div>
            </div>

            <p>justify-content: flex-end</p>
            <div id="flex-end">
                <div></div>
                <div></div>
                <div></div>
            </div>

            <p>justify-content: center</p>
            <div id="center">
                <div></div>
                <div></div>
                <div></div>
            </div>

            <p>justify-content: space-between</p>
            <div id="space-between">
                <div></div>
                <div></div>
                <div></div>
            </div>

            <p>justify-content: space-around</p>
            <div id="space-around">
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
    </section>

</body>
</html>