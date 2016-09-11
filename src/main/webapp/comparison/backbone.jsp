<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Backbone</title>
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script type="text/javascript" src="${baseUrl }/js/underscore.js"></script>
<script type="text/javascript" src="${baseUrl }/js/backbone.js"></script>
<script type="text/javascript">
	$(window).load(
			function() {
				Person = Backbone.Model.extend({});
				PersonView = Backbone.View.extend({
					el : '#person',
					events : {
						'change' : 'change',
					},
					initialize : function() {
						this.listenTo(this.model, 'change', this.render);
						this.render();
					},
					change : function() {
						var firstName = $('#firstName').val();
						var lastName = $('#lastName').val();
						this.model.set({
							firstName : firstName,
							lastName : lastName
						});
					},
					render : function() {
						this.$('#firstName').val(this.model.get('firstName'));
						this.$('#lastName').val(this.model.get('lastName'));
						var fullName = this.model.get('firstName') + ' '
								+ this.model.get('lastName');
						this.$('#fullName').text(fullName);
					},
				});
				person = new Person({
					lastName : "Olmstead",
					firstName : "Eldon"
				});
				personView = new PersonView({
					model : person
				});
			});
</script>
</head>
<body>
	<div id="person">
		First Name: <input id="firstName" value=""><br> Last
		Name: <input id="lastName" value=""><br> Full Name: <span
			id="fullName"></span>
	</div>
</body>
</html>