// jQuery UI accordion 

$(function() {
	var icons = {
		header : "ui-icon-circle-arrow-e",
		headerSelected : "ui-icon-circle-arrow-s"
	};

	$("#accordion1").collapsible({
		icons : icons,
		collapsible : true,
		active : false
	});

	$("#accordion2").collapsible({
		icons : icons,
		collapsible : true,
		active : false
	});

	$("#accordion3").collapsible({
		icons : icons,
		collapsible : true,
		active : false
	});

	$("#accordion4").collapsible({
		icons : icons,
		collapsible : true,
		active : false
	});

	$("#flip-checkbox-1").flipswitch({
		corners : false,
		mini : true,
		collapse : function(event, ui) {
			console.log("collapse");
		},
		expand : function(event, ui) {
			console.log("expand");
		}
	}).on('vmousedown', function(e) {
		console.log("vmousedown");
	}).on('change', function(e) {
		console.log("changed");
		e.stopPropagation();
		e.preventDefault();
		return false;
	});
});
