<!DOCTYPE html>
<html>
<head>
<%@ include file="/includes/head.jspf" %>
<title>Input</title>
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
    <logic:notPresent name="org.apache.struts.action.MESSAGE"
        scope="application">
        <font color="red"> ERROR: Application resources not
            loaded -- check servlet container logs for error messages. </font>
    </logic:notPresent>

	<html:errors />
    <header></header>
    <section class="content">
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
    </section>
    <footer class="footer"></footer>
</body>
</html>