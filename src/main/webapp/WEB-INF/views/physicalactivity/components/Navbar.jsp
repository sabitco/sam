<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation"
	style="margin-bottom: 0">

	<!-- .navbar-header-->
	<div class=" ">
		<div class="navbar-header logo-sam">
			<img src="/static//dist/physicalactivity/images/logo2.png" alt="logo">
		</div>

	</div>

	<!-- End .navbar-header -->

	<!-- ul .navbar top links--->
	<ul class="nav navbar-top-links navbar-right text-white">
		<!-- li .dropdown-option -->
		${emailLogger}
		<!-- End li .dropdown-option -->

		<!-- li .dropdown-user -->
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
				<i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-user">
				<li><a href="">
						<p>
							<strong>
								<div>
									<i class="btn-danger btn-circle fa fa-user fa-fw"></i> <em>${userLogger}</em>
								</div>
							</strong>
						</p>
						<p>
							<strong>
								<div class="alignCenter">${usernameLogger}</div>
							</strong>
						</p>

				</a></li>
				<li class="divider"></li>
				<li><a href="login.html"> <i class="fa fa-sign-out fa-fw"></i>
						<strong> <spring:message
								code="param.physicalactivity.option.logout" />
					</strong>
				</a></li>
			</ul> <!-- /.dropdown-user --></li>
		<!-- End li .dropdown-user -->

	</ul>
	<!-- End ul .navbar-top-links -->
</nav>
<!-- End .navbar-static-side -->

