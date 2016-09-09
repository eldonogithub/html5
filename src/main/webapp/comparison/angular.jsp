<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <meta name="robots" content="noindex, nofollow">
  <meta name="googlebot" content="noindex, nofollow">
  <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.1/angular.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/result-light.css">
  <style type="text/css">
  </style>
  <title>Angular</title>
<script type='text/javascript'>
function PersonController($scope) {
  $scope.firstName = "Taro";
  $scope.lastName  = "Yamada";
  $scope.getFullName = function() {
    return $scope.firstName + " " + $scope.lastName;
   };
}
</script>
</head>
<body>
  <div ng-app ng-controller="PersonController">
First Name: <input type=text ng-model="firstName"> <br>
Last Name: <input type=text ng-model="lastName"><br>
Full Name: {{getFullName()}}
</div>
</body>
</html>

