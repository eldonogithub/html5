<!doctype html>
<html lang="en">
<head>
<%@ include file="/includes/head.jspf" %>
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