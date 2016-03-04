<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<c:url var="baseUrl" value="/" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width">
<title>Test Database using javascript</title>
<script type='text/javascript' src='${baseUrl }/dwr/engine.js'></script>
<script type='text/javascript'
    src='${baseUrl }/dwr/interface/AjaxBean.js'></script>
<script type='text/javascript' src='${baseUrl }/dwr/util.js'></script>
<link rel="stylesheet"
    href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="${baseUrl }/bootstrap/js/bootstrap.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="${baseUrl }/js/ajax-bootstrap.js"></script>
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