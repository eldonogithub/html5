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
	<html:form action="/form/checkbox">
		<fieldset>
			<html:checkbox property="checkboxGroup" value="cb1">checkbox1</html:checkbox>
			<html:checkbox property="checkboxGroup" value="cb2">checkbox2</html:checkbox>
			<html:checkbox property="checkboxGroup" value="cb3">checkbox3</html:checkbox>
			<html:checkbox property="checkboxGroup" value="cb4">checkbox4</html:checkbox>
			<html:checkbox property="checkboxGroup" value="cb5">checkbox5</html:checkbox>
			<html:checkbox property="checkboxGroup" value="cb5">checkbox6</html:checkbox>
			<html:checkbox property="checkboxGroup" value="cb6">checkbox7</html:checkbox>
		</fieldset>
	<input type="submit" value="submit">
	</html:form>
</body>
</html>