<%@ page contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/includes/head.jspf"%>
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>

<title>jQuery</title>
<script type="text/javascript">
	$(function() {
		console.log("initializing");
		function updateFullName() {
			console.log("updateFullName");
			var fullName = $("#firstName").val() + " " + $("#lastName").val();
			console.log(fullName);
			$("#fullName").text(fullName);
		}
		$("#firstName, #lastName").on("change keyup", function(e) {
			console.log(e);
			updateFullName();
		});
		console.log("initializing");
		$("#firstName").val("Eldon");
		$("#lastName").val("Olmstead");
	});
</script>
</head>
<body>
	<form method="post">
		First Name: <input id="firstName" /> <br> Last Name: <input
			id="lastName" /> <br> Full Name: <span id="fullName"></span> <br>
		<div class="g-recaptcha"
			data-sitekey="6LcE1SkTAAAAAL3p_g5l0VJzN5EHwOWKszPhQ-ZV"></div>
		<input type="submit">
	</form>
</body>
</html>