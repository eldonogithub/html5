<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- 
Today we’re going to continue developing our HTML5 contact form, using CSS.

Extract the inline CSS from the head of the form and paste it into a new document.  
Name this new stylesheet style.css and make a reference to it in the head of the 
form HTML.  At the top of style.css, I’ve imported Eric Meyer’s stylesheet reset 
(named “reset.css”) and removed the star (*) selector that temporarily reset 
the margin and padding.  (NB: never use the start selector in production!)  
Your stylesheet should now look like this:

 -->
<meta charset="utf-8" />
<title>Contact Form</title>
<link href="../css/nicholahibbert2.css" rel="stylesheet">
</head>
<body>
	<form>
		<fieldset>
			<legend>Contact Details</legend>
			<p>
				<label for="name">Name</label><input id="name" type="text" />
			</p>
			<p>
				<label for="company">Company</label><input id="company" type="text" />
			</p>
			<p>
				<label for="email">Email</label><input id="email" type="email" />
			</p>
			<p>
				<label for="telephone">Telephone</label><input id="telephone"
					type="tel" />
			</p>
			<p>
				<label for="website">Website</label><input id="website" type="url" />
			</p>
		</fieldset>
		<fieldset>
			<legend>Project Details</legend>
			<p>
				<label for="project-type">Type of Project</label> <select
					id="project-type">
					<option>HTML/CSS Build</option>
					<option>Custom jQuery Plugin</option>
					<option>Wordpress Template</option>
					<option>Other</option>
				</select>
			</p>
			<p>
				<label for="completion-date">Projected Completion Date</label><input
					id="completion-date" type="date" />
			</p>
			<p>
				<label for="project-budget">Estimated Budget (&pound;)</label><input
					id="project-budget" type="number" />
			</p>
			<p>
				<label for="project-details">Additional Details</label>
				<textarea id="project-details" rows="5"></textarea>
			</p>
		</fieldset>
		<fieldset>
			<legend>Contact Preferences</legend>
			<p>
				<span>Please contact me by&hellip;</span> <label><input
					id="contact-method" type="radio" value="Phone" checked="checked" />
					Phone</label> <label><input id="contact-method" type="radio"
					value="Email" /> Email</label>
			</p>
			<p>
				<label for="contact-time">Best time to contact?</label><input
					id="contact-time" type="time" />
			</p>
			<p>
				<input type="submit" id="submit" value="Submit Form" />
			</p>
		</fieldset>
	</form>
</body>
</html>