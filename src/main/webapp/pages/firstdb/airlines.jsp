<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="urn:ca:blackperl:taglib:html5" prefix="html5"%>
<c:url var="baseUrl" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- http://cssmediaqueries.com/overview.html -->
<!-- https://css-tricks.com/snippets/css/media-queries-for-standard-devices/ -->
<!-- http://www.quirksmode.org/blog/archives/2010/09/combining_meta.html -->
<meta name="viewport" content="width=device-width">
<title>Airlines</title>
<link rel="stylesheet" href='<c:out value="${baseUrl }/css/main.css"/>'>
</head>
<body>
    <section class="content">
        <div class="col1"></div>
        <div class="col2">
            <table id="derbyTable">
                <thead>
                    <tr>
                        <c:forEach var="col"
                            items="${derbyForm.results.header }">
                            <th><c:out value="${col }" /></th>
                        </c:forEach>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="row"
                        items="${derbyForm.results.rows }">
                        <tr>
                            <c:forEach var="col" items="${row }">
                                <td><c:out value="${col }" /></td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col3"></div>
    </section>

</body>
</html>