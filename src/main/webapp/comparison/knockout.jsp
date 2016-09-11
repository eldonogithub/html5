<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="robots" content="noindex, nofollow">
<meta name="googlebot" content="noindex, nofollow">
<script type="text/javascript"
	src="http://knockoutjs.com/downloads/knockout-3.0.0.js"></script>
<link rel="stylesheet" type="text/css" href="/css/result-light.css">
<style type="text/css">
</style>
<title>Knockout</title>
<script type='text/javascript'>
	//<![CDATA[
	window.onload = function() {
		function AppViewModel() {
			this.firstName = ko.observable("Eldon");
			this.lastName = ko.observable("Olmstead");

			this.fullName = ko.computed(function() {
				return this.firstName() + " " + this.lastName();
			}, this);
		}

		// Activates knockout.js
		ko.applyBindings(new AppViewModel());
	}//]]>
</script>
</head>
<body>
	<p>
		First name:<input data-bind="value: firstName" />
	</p>
	<p>
		Last name:<input data-bind="value: lastName" />
	</p>
	<p>
		Full name:<span data-bind="text: fullName"></span>
	</p>
</body>
</html>