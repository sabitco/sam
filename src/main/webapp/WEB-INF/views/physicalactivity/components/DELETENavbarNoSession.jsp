<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation"
	style="margin-bottom: 0">

	<!-- .navbar-header-->
	<div class="navbar-header">
		<span class="navbar-brand"> <spring:message
				code="param.physicalactivity.title.name" />
		</span>
	</div>
	<!-- End .navbar-header -->

	<!-- ul .navbar top links--->
	<ul class="nav navbar-top-links navbar-right">
		<!-- li .dropdown-option -->
		<li class="dropdown"><a
			href="Z
							<spring:message code="param.physicalactivity.menu.option.home.link"/>
						">
				<strong>
					<div>
						<i
							class="<spring:message code="param.physicalactivity.menu.option.home.class"/>"></i>
						<em> <spring:message
								code="param.physicalactivity.menu.option.home.description" />
						</em>
					</div>
			</strong>
		</a></li>
		<!-- End li .dropdown-option -->

	</ul>
	<!-- End ul .navbar-top-links -->
</nav>
<!-- End .navbar-static-side -->

