<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.net.URLClassLoader"%>
<%@ page import="java.lang.Thread"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Class Path</title>
</head>
<body>
    <h1>Class Path</h1>
    <%
    	request.setAttribute("env", System.getenv());
    %>
    <hr>
    <%
    	ClassLoader cl = Thread.currentThread().getContextClassLoader();
    	while (cl != null) {
    		URL[] urls = ((URLClassLoader) cl).getURLs();
    		for (URL url : urls) {
    			out.println(url.getFile());
    			out.println("<br>");
    		}
    		out.println("<hr>");
    		cl = cl.getParent();
    	}
    %>
    <ul>
        <c:forEach var="item" items="${env }">
            <li>${item.key}- ${item.value}</li>
        </c:forEach>
    </ul>
</body>
</html>