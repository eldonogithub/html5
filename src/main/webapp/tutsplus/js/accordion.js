// jQuery UI accordion 

$(function() {
	var icons = {
		header : "ui-icon-circle-arrow-e",
		headerSelected : "ui-icon-circle-arrow-s"
	};

	$("#accordion1").accordion({
		icons : icons,
		collapsible : true,
		active : false
	});

	$("#accordion2").accordion({
		icons : icons,
		collapsible : true,
		active : false
	});

	$("#accordion3").accordion({
		icons : icons,
		collapsible : true,
		active : false
	});

	$("#accordion4").accordion({
		icons : icons,
		collapsible : true,
		active : false
	});

});
