<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<c:url var="baseUrl" value="/" />
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>jQuery UI Dialog - Modal message</title>
<link rel="stylesheet"
    href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="${baseUrl}/css/jquery.css">
<script>
	$(function() {
		$("#dialog-message").dialog({
			modal : true,
			buttons : {
				Ok : function() {
					$(this).dialog("close");
				}
			}
		});
	});
</script>
</head>
<body>

    <div id="dialog-message" title="Download complete">
        <p>
            <span class="ui-icon ui-icon-circle-check"
                style="float: left; margin: 0 7px 50px 0;"></span> Your
            files have downloaded successfully into the My Downloads
            folder.
        </p>
        <p>
            Currently using <b>36% of your storage space</b>.
        </p>
    </div>

    <p>
        Sed vel diam id libero <a href="http://example.com">rutrum
            convallis</a>. Donec aliquet leo vel magna. Phasellus rhoncus
        faucibus ante. Etiam bibendum, enim faucibus aliquet rhoncus,
        arcu felis ultricies neque, sit amet auctor elit eros a lectus.
    </p>


</body>
</html>