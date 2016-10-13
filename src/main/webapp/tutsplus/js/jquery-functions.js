// jQuery UI Tabs 

$(function() {
	$("#tabs").tabs({
		active : 1
	});
	
	console.log("tabs called");

	var root = $("body");
    console.log(root);
    var stack = [];
    function visit(index, element) {
    	stack.push(element.tagName);
    	var zindex = $(element).css("overflow");
    	if ( zindex != 'visible') {
    		console.log(element.tagName + "{ overflow: " + zindex + "; }");
    	}

    	var children = $(element).children();
    	$.each(children, visit);
    }
    
    $.each(root, visit);
});