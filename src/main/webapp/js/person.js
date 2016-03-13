$(function() {
	var dt;
	var persons;
	// Crazy stupid way of doing HTML encoding for javascript. But it works
	function encode(txt) {
		var t2h = $("<div/>");
		return t2h.text(txt).html();
	}

	// populate table
	function loadTable() {
		console.log("Loading the table");
		dt = $("table#personForm")
				.DataTable(
						{
							"ajax" : function(data, cb, settings) {
								console.log("AjaxHibernate.getPersons() invoked");
								AjaxHibernate
										.getPersons({
											"callback" : function(ajaxPersons) {
												console
														.log("Received a result back "
																+ ajaxPersons.status);
												if (ajaxPersons.status === 'SUCCESS') {
													console.log("Calling DataTable() callback...");
													console.log("Received data as ", ajaxPersons.results);
													cb({"data" : ajaxPersons.results});
												}
											}
										});
							},
							"columns" : [ {
								"data" : "id",
								"title" : "ID"
							}, {
								"data" : "firstname",
								"title" : "First Name"
							}, {
								"data" : "lastname",
								"title" : "Last Name"
							}, {
								"data" : "age",
								"title" : "Name"
							} ],
							"pageLength" : 10
						});
	}

	// Load the table with the initial data
	loadTable();
	$("form#personForm tr").each(function(idx, row) {
		console.log("Row = ", row);
		$(row).click(function() {
			console.log("row clicked: " + row);
		});
	});

	// Set the on submit handler
	$("form#personForm").submit(function(e) {

		e.preventDefault();

		// serialize the form data
		var data = $(this).serializeArray();
		console.log("Data serialized");
		console.log(data)

		// this won't work always, multiple form fields won't be injected
		// corrected
		var result = {};
		$(data).each(function(idx, field) {
			result[field.name] = field.value;
			console.log(field.name + " = " + field.value);
		});
		console.log("result converted to:");
		console.log(result);
		AjaxHibernate.submitPerson(result, {
			callback : function(ajaxPersons) {
				console.log("Received a result back " + ajaxPersons.status);
				console.log("Submit Person result ", ajaxPersons);
				if (ajaxPersons.status === 'SUCCESS') {
					console.log("Reloading DataTable()...");
					dt.ajax.reload();
				}
			}
		});
		return false;
	});
});
