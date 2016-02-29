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
<title>Test Database using javascript</title>
<script type='text/javascript' src='${baseUrl }/dwr/engine.js'></script>
<script type='text/javascript'
    src='${baseUrl }/dwr/interface/AjaxBean.js'></script>
<script type='text/javascript' src='${baseUrl }/dwr/util.js'></script>
<link rel="stylesheet"
    href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="//yui.yahooapis.com/3.18.1/build/yui/yui-min.js"></script>
<script src="${baseUrl }/js/ajax-yui.js"></script>
</head>
<body class="yui3-skin-night">
    <h1>Test Data database</h1>
    <div id="results"></div>
    
    <!-- You need this skin class -->
    <div class="example">

        <div id="testData"></div>

        <div id="simple"></div>

        <div id="labels"></div>
    </div>
</body>
</html>