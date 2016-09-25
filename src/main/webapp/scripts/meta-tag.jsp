<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Meta-Tag Test</title>
<% System.out.println("Loading"); %>
<!--[if gte IE 8]>
<style type="text/css">
body {
 color: #0000ff;
 background-color: #000000;
}
</style>
<![endif]-->
<!--[if lt IE 8]>
<style type="text/css">
body {
 color: #000000;
 background-color: #ffffff;
}
</style>
<![endif]-->
<style type="text/css">
.odd {
	font-weight: bold;
}
.header {
	font-weight: bold;
}
</style>
<script>
//Production steps of ECMA-262, Edition 5, 15.4.4.21
//Reference: http://es5.github.io/#x15.4.4.21
if (!Array.prototype.reduce) {
Array.prototype.reduce = function(callback /*, initialValue*/) {
 'use strict';
 if (this === null) {
   throw new TypeError('Array.prototype.reduce called on null or undefined');
 }
 if (typeof callback !== 'function') {
   throw new TypeError(callback + ' is not a function');
 }
 var t = Object(this), len = t.length >>> 0, k = 0, value;
 if (arguments.length == 2) {
   value = arguments[1];
 } else {
   while (k < len && !(k in t)) {
     k++; 
   }
   if (k >= len) {
     throw new TypeError('Reduce of empty array with no initial value');
   }
   value = t[k++];
 }
 for (; k < len; k++) {
   if (k in t) {
     value = callback(value, t[k], k, t);
   }
 }
 return value;
};
}
//Production steps of ECMA-262, Edition 5, 15.4.4.19
//Reference: http://es5.github.io/#x15.4.4.19
if (!Array.prototype.map) {

Array.prototype.map = function(callback, thisArg) {

 var T, A, k;

 if (this == null) {
   throw new TypeError(' this is null or not defined');
 }

 // 1. Let O be the result of calling ToObject passing the |this| 
 //    value as the argument.
 var O = Object(this);

 // 2. Let lenValue be the result of calling the Get internal 
 //    method of O with the argument "length".
 // 3. Let len be ToUint32(lenValue).
 var len = O.length >>> 0;

 // 4. If IsCallable(callback) is false, throw a TypeError exception.
 // See: http://es5.github.com/#x9.11
 if (typeof callback !== 'function') {
   throw new TypeError(callback + ' is not a function');
 }

 // 5. If thisArg was supplied, let T be thisArg; else let T be undefined.
 if (arguments.length > 1) {
   T = thisArg;
 }

 // 6. Let A be a new array created as if by the expression new Array(len) 
 //    where Array is the standard built-in constructor with that name and 
 //    len is the value of len.
 A = new Array(len);

 // 7. Let k be 0
 k = 0;

 // 8. Repeat, while k < len
 while (k < len) {

   var kValue, mappedValue;

   // a. Let Pk be ToString(k).
   //   This is implicit for LHS operands of the in operator
   // b. Let kPresent be the result of calling the HasProperty internal 
   //    method of O with argument Pk.
   //   This step can be combined with c
   // c. If kPresent is true, then
   if (k in O) {

     // i. Let kValue be the result of calling the Get internal 
     //    method of O with argument Pk.
     kValue = O[k];

     // ii. Let mappedValue be the result of calling the Call internal 
     //     method of callback with T as the this value and argument 
     //     list containing kValue, k, and O.
     mappedValue = callback.call(T, kValue, k, O);

     // iii. Call the DefineOwnProperty internal method of A with arguments
     // Pk, Property Descriptor
     // { Value: mappedValue,
     //   Writable: true,
     //   Enumerable: true,
     //   Configurable: true },
     // and false.

     // In browsers that support Object.defineProperty, use the following:
     // Object.defineProperty(A, k, {
     //   value: mappedValue,
     //   writable: true,
     //   enumerable: true,
     //   configurable: true
     // });

     // For best browser support, use the following:
     A[k] = mappedValue;
   }
   // d. Increase k by 1.
   k++;
 }

 // 9. return A
 return A;
};
}
//Production steps of ECMA-262, Edition 5, 15.4.4.18
//Reference: http://es5.github.io/#x15.4.4.18
if (!Array.prototype.forEach) {

Array.prototype.forEach = function(callback, thisArg) {

 var T, k;

 if (this === null) {
   throw new TypeError(' this is null or not defined');
 }

 // 1. Let O be the result of calling toObject() passing the
 // |this| value as the argument.
 var O = Object(this);

 // 2. Let lenValue be the result of calling the Get() internal
 // method of O with the argument "length".
 // 3. Let len be toUint32(lenValue).
 var len = O.length >>> 0;

 // 4. If isCallable(callback) is false, throw a TypeError exception. 
 // See: http://es5.github.com/#x9.11
 if (typeof callback !== "function") {
   throw new TypeError(callback + ' is not a function');
 }

 // 5. If thisArg was supplied, let T be thisArg; else let
 // T be undefined.
 if (arguments.length > 1) {
   T = thisArg;
 }

 // 6. Let k be 0
 k = 0;

 // 7. Repeat, while k < len
 while (k < len) {

   var kValue;

   // a. Let Pk be ToString(k).
   //    This is implicit for LHS operands of the in operator
   // b. Let kPresent be the result of calling the HasProperty
   //    internal method of O with argument Pk.
   //    This step can be combined with c
   // c. If kPresent is true, then
   if (k in O) {

     // i. Let kValue be the result of calling the Get internal
     // method of O with argument Pk.
     kValue = O[k];

     // ii. Call the Call internal method of callback with T as
     // the this value and argument list containing kValue, k, and O.
     callback.call(T, kValue, k, O);
   }
   // d. Increase k by 1.
   k++;
 }
 // 8. return undefined
};
}
	function logArrayElements(element, index, array) {
		console.log('a[' + index + '] = ' + element);
	}
	window.onload = function() {
	var a = navigator.userAgent.split(/(\S+\/\S+)/);
	a.forEach(logArrayElements);
	document.getElementById("info").innerHTML = a.map(function(element,  index, array) {
		var clazz = index % 2 ? "odd" : "even"; 
		return "<span class=\"" + clazz + "\">" + element + "</span>";
	}).reduce(function (prev, curr, index) {
		return prev + curr;
	});
	document.getElementById("original").innerHTML = navigator.userAgent;
}
</script>
<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script',
			'https://www.google-analytics.com/analytics.js', 'ga');

	ga('create', 'UA-45512008-1', 'auto');
	ga('send', 'pageview');
</script>
</head>
<body>
	<span class="header">Original User Agent:</span><div id="original"></div>
	<span class="header">Parsed User Agent:</span><div id="info"></div>
	<!--[if IE]><p>You are using Internet Explorer.</p><![endif]-->
	<![if !IE]>
	<p>You are not using Internet Explorer.</p>
	<![endif]>

	<!--[if IE 7]><p>Welcome to Internet Explorer 7!</p><![endif]-->
	<!--[if !(IE 7)]><p>You are not using version 7.</p><![endif]-->

	<!--[if gte IE 7]><p>You are using IE 7 or greater.</p><![endif]-->
	<!--[if (IE 5)]><p>You are using IE 5 (any version).</p><![endif]-->
	<!--[if (gte IE 5.5)&(lt IE 7)]><p>You are using IE 5.5 or IE 6.</p><![endif]-->
	<!--[if lt IE 5.5]><p>Please upgrade your version of Internet Explorer.</p><![endif]-->

	<!--[if true]>You are using an <em>uplevel</em> browser.<![endif]-->
	<!--[if false]>You are using a <em>downlevel</em> browser.<![endif]-->

	<!--[if true]><![if IE 7]><p>This nested comment is displayed in IE 7.</p><![endif]><![endif]-->
	<a href="/html5/scripts/meta-tag.jsp">RETURN TO SAME PAGE</a>
</body>
</html>