<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="robots" content="noindex, nofollow">
<meta name="googlebot" content="noindex, nofollow">

<script type="text/javascript" src="//code.jquery.com/jquery-2.0.2.js"></script>
<script type="text/javascript"
	src="http://builds.handlebarsjs.com.s3.amazonaws.com/handlebars-v1.1.2.js"></script>
<script type="text/javascript"
	src="http://builds.emberjs.com/tags/v1.2.0/ember.min.js"></script>
<style type="text/css">
body {
	font-family: sans-serif;
}
</style>
<title>Ember JS</title>
<script type='text/javascript'>
	App = Ember.Application.create();
	App.Person = Ember.Object.extend({
		firstName : null,
		lastName : null,

		fullName : function() {
			return this.get('firstName') + ' ' + this.get('lastName');
		}.property('firstName', 'lastName')
	});

	var person = App.Person.create({
		firstName : "Eldon",
		lastName : "Olmstead"
	});

	App.Router.map(function() {
	});

	App.IndexRoute = Ember.Route.extend({
		model : function() {
			return person;
		}
	});
</script>
</head>
<body>
	<script type="text/x-handlebars" data-template-name="index">
First Name:{{input type="text" value=firstName}}<br/>
Last Name:{{input type="text" value=lastName}}<br/>
Full Name: {{model.fullName}}<br/>
</script>
</body>
</html>

