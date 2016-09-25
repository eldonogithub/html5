<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/includes/head.jspf"%>
<title>Insert title here</title>
</head>
<body>
	<html:form action="/form/checkbox2">
		<fieldset>
			<html:multibox property="checkboxGroup"></html:multibox>
		</fieldset>
	<input type="submit" value="submit">
	</html:form>
</body>
</html>