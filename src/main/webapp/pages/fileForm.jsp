<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/includes/head.jspf"%>
<title>Form</title>
</head>
<body>
	<div class="inputForm">
		<header class="header"></header>
		<%@ include file="/includes/menu.jspf"%>
		<section class="content">
			<div class="col1"></div>
			<div class="col2">
				<logic:notPresent name="org.apache.struts.action.MESSAGE"
					scope="application">
					<font color="red"> ERROR: Application resources not loaded
						-- check servlet container logs for error messages. </font>
				</logic:notPresent>

				<html:errors />
				<html:form action="/simple/fileForm.do" styleClass="contact_form"
					enctype="multipart/form-data">
					<ul>
						<li><label for="file">Name:</label> <html5:input type="file"
								property="file" placeholder="John Doe"></html5:input></li>
						<li id="button"><button type="submit" class="submit"
								value="submit">Submit Form</button></li>
					</ul>
				</html:form>
			</div>
			<div class="col3"></div>
		</section>
		<footer class="footer"></footer>
	</div>
</body>
</html>