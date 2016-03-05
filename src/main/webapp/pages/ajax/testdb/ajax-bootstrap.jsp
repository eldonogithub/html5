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
<jsp:include page="/pages/head.jsp"></jsp:include>
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