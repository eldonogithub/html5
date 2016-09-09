<%@ page contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
		$("#firstName").val("Taro");
		$("#lastName").val("Yamada");
	});
</script>
</head>
<body>
	First Name:
	<input id="firstName" />
	<br> Last Name:
	<input id="lastName" />
	<br> Full Name:
	<span id="fullName"></span>
	<br>
</body>
</html>