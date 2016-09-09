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
		$("form#personForm button[value=updatePerson]").hide();
		$("form#personForm button[value=createPerson]").show();
		function ajaxHandler(data, cb, settings) {
			console.log("AjaxHibernate.getPersons() invoked");
			function ajaxCallback(ajaxPersons) {
				console.log("Received a result back " + ajaxPersons.status);
				if (ajaxPersons.status === 'SUCCESS') {
					console.log("Calling DataTable() callback...");
					$("#personSize").text(ajaxPersons.data.length);
					cb({
						"data" : ajaxPersons.data
					});

				}
			}

			// Call get persons
			AjaxHibernate.getPersons({
				"callback" : ajaxCallback
			});
		}

		function operationRenderer(data, type, row, meta) {
			// msg = '<button class="edit ui-button ui-widget ui-state-default
			// ui-corner-all ui-button-text-only" role="button"><span
			// class="ui-button-text">Edit</span></button>'
			// + '<button class="delete ui-button ui-widget ui-state-default
			// ui-corner-all ui-button-text-only" role="button"><span
			// class="ui-button-text">Delete</span></button>'
			// + '<button class="copy ui-button ui-widget ui-state-default
			// ui-corner-all ui-button-text-only" role="button"><span
			// class="ui-button-text">Copy</span></button>';
			msg = "<button class='edit'>Edit</button>"
					+ "<button class='delete'>Delete</button>"
					+ "<button class='copy'>Copy</button>";
			return msg;
		}

		dt = $("table#personTable").DataTable({
			"ajax" : ajaxHandler,
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
				"title" : "Age"
			}, {
				"data" : null,
				"title" : "Operation",
				"render" : operationRenderer,
			} ],
			"pageLength" : 10,
			"processing" : true,
		});

		function editHandler() {
			var data = dt.row($(this).parents('tr')).data();
			console.log("edit clicked: " + data.id);
			$("#personForm input[name=id]").val(data.id);
			$("#personForm input[name=firstname]").val(data.firstname);
			$("#personForm input[name=lastname]").val(data.lastname);
			$("#personForm input[name=age]").val(data.age);
			$("form#personForm button[value=updatePerson]").show();
			$("form#personForm button[value=createPerson]").hide();
		}

		$('table#personTable tbody').on('click', 'button.edit', editHandler);

		$('table#personTable tbody').on('click', 'button.copy', function() {
			var data = dt.row($(this).parents('tr')).data();
			console.log("copy clicked: " + data.id);
			$("#personForm input[name=id]").val("");
			$("#personForm input[name=firstname]").val(data.firstname);
			$("#personForm input[name=lastname]").val(data.lastname);
			$("#personForm input[name=age]").val(data.age);
			$("form#personForm button[value=updatePerson]").hide();
			$("form#personForm button[value=createPerson]").show();
		});

		function deleteHandler() {
			var data = dt.row($(this).parents('tr')).data();
			console.log("delete clicked: " + data.id);
			var msg = "<span id='msg'>Delete Person ID " + data.id + " "
					+ data.firstname + " " + data.lastname
			"</span>";

			$("#delete-confirm p span#msg").remove();
			$("#delete-confirm p").append(msg);

			// Called when the user clicks on the delete button in the confirm
			// dialog
			function deleteAction() {
				function deleteCallback(ajaxPersons) {
					console.log("Received a result back " + ajaxPersons.status);
					console.log("Submit Person result ", ajaxPersons);
					if (ajaxPersons.status === 'SUCCESS') {
						console.log("Reloading DataTable()...");
						dt.ajax.reload();
					} else {
						$("ul#errors").append(
								"<li>" + ajaxPersons.message + "</li>");
					}
				}
				$(this).dialog("close");
				AjaxHibernate.deletePerson(data.id, {
					callback : deleteCallback
				});
			}

			// Called when the user clicks on the cancel button in the confirm
			// dialog
			function cancelAction() {
				$(this).dialog("close");
			}

			// Invoke the confirm dialog
			$("#delete-confirm").dialog({
				modal : true,
				buttons : {
					"Delete" : deleteAction,
					"Cancel" : cancelAction
				}
			});
		}

		// Assign confirm delete handler to each button in the table
		$('table#personTable tbody')
				.on('click', 'button.delete', deleteHandler);
	}
	// Load the table with the initial data
	loadTable();
	$("button").button();
	// Set the on submit handler
	var button;

	$("form#personForm button[type=submit]").click(function() {
		button = $(this).attr("value");
	});

	$("form#personForm button[type=reset]").click(function() {
		$("ul#errors *").remove();
		$("#personForm input[name=id]").val("");
		$("#personForm input[name=firstname]").val("");
		$("#personForm input[name=lastname]").val("");
		$("#personForm input[name=age]").val("");
		$("form#personForm button[value=updatePerson]").hide();
		$("form#personForm button[value=createPerson]").show();
	});

	function submitHandler(e) {
		$("ul#errors").empty();
		e.preventDefault();

		if (button == "createPerson") {
			$(this).find("input[name=id]").val("");
		}
		console.log("called " + button);

		// serialize the form data
		var data = $(this).serializeArray();
		console.log("Data serialized");
		console.log(data)

		// this won't work always, multiple identical form fields won't
		// be
		// injected
		// correctly
		var result = {};
		$(data).each(function(idx, field) {
			result[field.name] = field.value;
			console.log(field.name + " = " + field.value);
		});
		console.log("result converted to:");
		console.log(result);

		function callbackHandler(ajaxPersons) {
			console.log("Received a result back " + ajaxPersons.status);
			console.log("Submit Person result ", ajaxPersons);
			if (ajaxPersons.status === 'SUCCESS') {
				console.log("Reloading DataTable()...");
				dt.ajax.reload();
			} else {
				$("ul#errors").append("<li>" + ajaxPersons.message + "</li>");
			}
		}

		AjaxHibernate.createOrUpdatePerson(result, {
			callback : callbackHandler
		});
		return false;
	}

	// assign a submit handler for this form
	$("form#personForm").submit(submitHandler);

	var options = [ {
		"id" : "1",
		"value" : "Basic"
	}, {
		"id" : "2",
		"value" : "Premium"
	} ];
	function getEmailTemplate(options) {
		function reducer(previous, current, currentIndex, arr) {
			var item = "<option id='" + current.id + "'>" + current.value
					+ "</option>";
			if (previous == null) {
				return item;
			} else {
				return previous + item;
			}
		}
		var select = "<li><select name='type'>" + options.reduce(reducer, null)
				+ "</select><input type='text'><button class='addEmail'>&nbsp;+&nbsp;</button><button class='removeEmail'>&nbsp;-&nbsp;</button></li>";
		return select;
	}

	console.log("generating the email template")
	function addEmailHandler(e) {
		$("ul#emails").append(getEmailTemplate(options));
	}

	function removeEmailHandler(e) {
		$(this).parent("li").remove();
	}

	$("ul#emails").append(getEmailTemplate(options));
	$('ul#emails').on('click', 'button.addEmail', addEmailHandler);
	$('ul#emails').on('click', 'button.removeEmail', removeEmailHandler);
});
