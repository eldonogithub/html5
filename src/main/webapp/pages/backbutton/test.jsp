<!DOCTYPE html>
<html>
<head>
<%@ include file="/includes/head.jspf"%>
</head>
<body>
    <logic:notPresent name="org.apache.struts.action.MESSAGE"
        scope="application">
        <font color="red"> ERROR: Application resources not
            loaded -- check servlet container logs for error messages. </font>
    </logic:notPresent>
    <div class="inputForm">
        <header class="header"></header>
		<%@ include file="/includes/menu.jspf"%>
		<section class="content">
            <div class="col1"></div>
            <div class="col2">
                <html:errors />
                <form action="" id="refreshForm">
                    <input type="hidden" id="refresh" value="no">                
                </form>
                <script type="text/javascript">
                    $(function() {
                        if ( window.location.hash =~ '#' ) {
                            console.log("already loaded");
                        }
                        else {
                            console.log("data not loaded");
                            $("body").attr("data-loaded", "true");
                            window.location.hash = "#loaded";
                        }
                        if ( $("#refresh").val() == 'true') {
                            console.log("input = true");
                        }
                        else {
                            console.log("input = false");
                        }
                    });
                </script>
            </div>
            <div class="col3"></div>
		</section>
	</div>
</body>
</html>