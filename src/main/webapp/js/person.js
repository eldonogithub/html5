$(function() {
	var persons;
	// Crazy stupid way of doing HTML encoding for javascript. But it works
	function encode(txt) {
		var t2h = $("<div/>");
		return t2h.text(txt).html();
	}
	function loadTable() {
		AjaxHibernate.getPersons({
			callback : function(ajaxPersons) {
				console.log(ajaxPersons.status);
				if (ajaxPersons.status === 'SUCCESS') {
					updateTable(ajaxPersons);
					console.log("Calling DataTable()");
					$("table#personForm").DataTable();
				}
			}
		});
	}
	// Update the table
	function updateTable(ajaxPersons) {
		$("table#personForm tbody tr").each(function(idx, row) {
			console.log("[" + idx + "] = ", row);
		});
		$("table#personForm tbody tr").remove();
		var text = "";
		persons = ajaxPersons.results;
		console.log("Result = ", persons);
		for (i = 0; i < persons.length; i++) {
			text += "<tr><td>" + encode(persons[i].id) + "</td><td>"
					+ encode(persons[i].firstname) + "</td><td>"
					+ encode(persons[i].lastname) + "</td><td>"
					+ encode(persons[i].age) + "</td></tr>";
		}
		console.log("new row = ", text);
		$("table#personForm tbody").append(text);
		console.log("done updating table");
	}
	// Load the table with the initial data
	loadTable();
	$("form#personForm tr").each(function(idx, row) {
		console.log("Row = ", row);
		$(row).click(function() {
		});
	});
	// Set the on submit handler
	$("form#personForm").submit(function(e) {
		e.preventDefault();
		var data = $(this).serializeArray();
		console.log("Data serialized");
		console.log(data)
		// this won't work always
		var result = {};
		$(data).each(function(idx, field) {
			result[field.name] = field.value;
			console.log(field.name + " = " + field.value);
		});
		console.log("result converted to:");
		console.log(result);
		AjaxHibernate.submitPerson(result, {
			callback : function(ajaxPersons) {
				console.log(ajaxPersons);
				console.log(ajaxPersons.status);
				if (ajaxPersons.status === 'SUCCESS') {
					updateTable(ajaxPersons);
				}
			}
		});
		return false;
	});
});
