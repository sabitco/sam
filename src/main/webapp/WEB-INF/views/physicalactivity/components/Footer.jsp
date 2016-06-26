<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!--Statement Footer-->
<footer class="site-footer">
	<div class="alert">
		<spring:message code="param.physicalactivity.footer.name" />
		<div class="pull-right">
			<a href="/physicalactivity/terms" class="btn btn-outline btn-link"><spring:message
					code="param.physicalactivity.home.terms.conditions" /></a> <a
				href="/physicalactivity/about" class="btn btn-outline btn-link"><spring:message
					code="param.physicalactivity.home.about" /></a>
		</div>
	</div>
</footer>
<!--End Statement Footer-->