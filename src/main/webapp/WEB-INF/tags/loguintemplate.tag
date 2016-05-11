


<%@tag description="SAM template" pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@attribute name="title" fragment="true"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4"
	xmlns:spring="http://www.springframework.org"
	xmlns:sec="http://www.springframework.org/tags">
	
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">


<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="index">
<meta name="author" content="fcaptuayo">

<title><jsp:invoke fragment="title" /></title>

<!-- Bootstrap Core CSS -->
<link href="<c:url value="/static//bower_components/bootstrap-3.3.6/css/bootstrap.min.css" />"
     rel="stylesheet">

<!-- Timeline CSS -->
<link href="<c:url value="/static//dist/administrator/css/timeline.css" />" rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value="/static//dist/administrator/css/sb-admin-2.css"/>" rel="stylesheet">

<!-- Custom Fonts -->
<link href="<c:url value="/static//bower_components/font-awesome/css/font-awesome.min.css"/>"
     rel="stylesheet" type="text/css">

<!-- jQuery -->
<script src="/static/bower_components/jquery-2.1.4/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/static/bower_components/bootstrap-3.3.6/js/bootstrap.min.js"></script>

<!-- Angular Core JavaScript -->
<script src="/static/bower_components/angular-1.5.0/angular.js"></script>

<!-- Angular Animate Core JavaScript -->
<script src="/static/bower_components/angular-1.5.0/angular-animate.js"></script>

<!-- Angular Touch Core JavaScript -->
<!-- <script src="/static/bower_components/angular-1.5.0/angular-touch.js"></script>

<!-- Angular Animate Core JavaScript -->
<script src="/static/bower_components/ui-bootstrap-tpls-1.1.2/js/ui-bootstrap-tpls-1.2.1.js"></script>

</head>
<body ng-app="physicalactivity">
     <jsp:doBody />
</body>
</html>
