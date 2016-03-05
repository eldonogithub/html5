<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="urn:ca:blackperl:taglib:html5" prefix="html5"%>
<c:url var="baseUrl" value="/" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- http://cssmediaqueries.com/overview.html -->
<!-- https://css-tricks.com/snippets/css/media-queries-for-standard-devices/ -->
<!-- http://www.quirksmode.org/blog/archives/2010/09/combining_meta.html -->
<meta name="viewport" content="width=device-width">
<script type='text/javascript' src='${baseUrl }/dwr/engine.js'></script>
<script type='text/javascript' src='${baseUrl }/dwr/util.js'></script>
<script type='text/javascript'
    src='${baseUrl }/dwr/interface/AjaxBean.js'></script>
<script type='text/javascript'
    src='${baseUrl }/dwr/interface/AjaxHibernate.js'></script>
<link rel="stylesheet" href="${baseUrl }/js/jquery-ui.css">
<script src="${baseUrl }/js/jquery-1.12.1.js"></script>
<script src="${baseUrl }/js/jquery-ui.js"></script>
<link rel="stylesheet"
    href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="${baseUrl }/bootstrap/js/bootstrap.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			minDate : new Date()
		});
	});
</script>
<link rel="stylesheet" href='<c:out value="${baseUrl }/css/main.css"/>'>
<link rel="stylesheet" href="//codepen.io/assets/reset/normalize.css">