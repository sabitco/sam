<%@tag description="SAM template" pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@attribute name="title" fragment="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">


<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="index">
<meta name="author" content="fcaptuayo">

<title><jsp:invoke fragment="title" /></title>

<!-- Bootstrap Core CSS -->
<link
	href="<c:url value="/static//bower_components/bootstrap-3.3.6/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Timeline CSS -->
<link
	href="<c:url value="/static//dist/physicalactivity/css/timeline.css" />"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="<c:url value="/static//dist/physicalactivity/css/sb-admin-2.css"/>"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<c:url value="/static//bower_components/font-awesome/css/font-awesome.min.css"/>"
	rel="stylesheet" type="text/css">

<!-- jQuery -->
<script src="/static/bower_components/jquery-2.1.4/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script
	src="/static/bower_components/bootstrap-3.3.6/js/bootstrap.min.js"></script>

<!-- Angular Core JavaScript -->
<script src="/static/bower_components/angular-1.5.0/angular.js"></script>

<!-- Angular Animate Core JavaScript -->
<script src="/static/bower_components/angular-1.5.0/angular-animate.js"></script>

<!-- Angular Touch Core JavaScript -->
<!-- <script src="/static/bower_components/angular-1.5.0/angular-touch.js"></script>

<!-- Angular Animate Core JavaScript -->
<script
	src="/static/bower_components/ui-bootstrap-tpls-1.1.2/js/ui-bootstrap-tpls-1.2.1.js"></script>

<!-- Js Home -->
<script src="<c:url value='/static/js/physicalactivity/app.js' />"
	ng-module="physicalactivity"></script>


<!-- Morris Import -->
<link data-require="morris.js@~0.5.1" data-semver="0.5.1"
	rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css" />
<script data-require="jquery@1.11.3" data-semver="1.11.3"
	src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script data-require="raphael@2.1.0" data-semver="2.1.0"
	src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script data-require="morris.js@~0.5.1" data-semver="0.5.1"
	src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
<script data-require="angular.js@1.4.1" data-semver="1.4.1"
	src="//code.angularjs.org/1.4.1/angular.js"></script>
<!-- Angular Morris Core JavaScript -->
<script
	src="/static/bower_components/angular_morris/angular-morris-chart.js"></script>


</head>
<body ng-app="physicalactivity">
	<jsp:doBody />
</body>
</html>
