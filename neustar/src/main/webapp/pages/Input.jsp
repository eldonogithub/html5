<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
fieldset {
	border: none;
}
</style>
<script type="text/javascript">
	<html:javascript formName="inputForm" dynamicJavascript="false" />
</script>
<html:javascript formName="inputForm" staticJavascript="false" />
<html:javascript formName="inputForm2" staticJavascript="false" />
</head>
<body>
	<html:errors />
	<html:form action="/Input.do"
		onsubmit="return validateInputForm(this);">
		<fieldset>
			<legend>Input Form 1</legend>
			<html:text property="input"></html:text>
			<button value="x" name="submit" type="submit">Submit</button>
		</fieldset>
	</html:form>
	<c:if test="${not empty received }">
		<div>
			Received the data in Input class:
			<c:out value="${inputForm.input }" />
		</div>
	</c:if>
	<html:form action="/Input2.do"
		onsubmit="return validateInputForm2(this);">
		<fieldset>
			<legend>Input Form 2</legend>
			<html:checkbox property="input1" value="true" ></html:checkbox>
			<html:text property="input2"></html:text>
			<button value="x" name="submit" type="submit">Submit</button>
		</fieldset>
	</html:form>
	<c:if test="${not empty received2 }">
		<div>
			Received the data in the Input2 class:
			<c:out value="${inputForm2.input1 }" />
		</div>
	</c:if>
</body>
</html>