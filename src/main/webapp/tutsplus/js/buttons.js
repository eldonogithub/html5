// jQuery UI Button 

// First Button 
$(function() {
	$(".demo button:first").button({
		icons : {
			primary : "ui-icon-locked"
		},
		text : false
	// Second Button
	}).next().button({
		icons : {
			primary : "ui-icon-locked"
		}
	// Third Button
	}).next().button({
		icons : {
			primary : "ui-icon-gear",
			secondary : "ui-icon-triangle-1-s"
		}
	// Fourth Button
	}).next().button({
		icons : {
			primary : "ui-icon-gear",
			secondary : "ui-icon-triangle-1-s"
		},
		text : false
	// Fifth Button
	}).next().button({});
});
