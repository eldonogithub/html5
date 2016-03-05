<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/includes/head.jspf" %>
</head>
<body>
    <div id="dialog" class="ui-dialog">
        <div class="ui-dialog-content">
            <div class="message"></div>
            <div class="debug"></div>
        </div>
    </div>
    <h1>Test Data database</h1>
    <div id="results"></div>

    <!-- You need this skin class -->
    <div class="example">

        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading">Results from Database</div>
            <div class="panel-body">
                <p>Panel body</p>
            </div>
            <!-- Table -->
            <table id="testData"></table>
        </div>

        <div id="simple"></div>

        <div id="labels"></div>
    </div>
</body>
</html>