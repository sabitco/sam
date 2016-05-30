<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>





<div ng-controller="SignonController as ctrl">
	<!-- consulta personalizada por Pagina -->
	<c:set var="titlePage" scope="session" value="formulario de registr01" />

	<c:set var="name" scope="session" value="Unete y Motivate!" />

	<c:set var="namePage" scope="session" value="formulario de registro 2" />

	<c:set var="iconPage" scope="session" value="user" />

	<c:set var="nameAllPage" scope="session" value="" />

	<c:set var="nameListRecentPage" scope="session" value="" />

	<c:set var="titleTable" scope="session" value="" />
	<t:signon>
		<jsp:attribute name="title">
			${titlePage}
		</jsp:attribute>
		<jsp:body>		
		<!--Div Wrapper-->
			<div id="wrapper" class="row page-wrapper">      		
				<!-- From signon -->
	            <div class="col-md-4 col-md-offset-4">
	                <div class="login-panel">
		                <h1 class="text-white text-center">
							 ${name}
						</h1>
		                <div class="panel panel-body">
		                    <div class="panel-orange text-muted">
								<spring:message code="param.physicalactivity.signon.from.basic" />
							</div>
							<div class="row text-center logo-sam">
                            	<img
									src="/static//dist/physicalactivity/images/logo1.png"
									alt="logo">    
                            </div>
							
	                       <jsp:include page="components/signon/Form.jsp" />
	                  
						</div>
	                </div>
	            </div>
	   		</div> 
			<!-- Statement JScript-->
			
				<!-- Angular Touch Core JavaScript -->
				<script
				src="<c:url value='/static/js/physicalactivity/service/view_service.js' />"></script>

				<!-- Angular Touch Core JavaScript -->
				<script
				src="<c:url value='/static/js/physicalactivity/service/campus_service.js' />"></script>
				
				<!-- Angular Touch Core JavaScript -->
				<script
				src="<c:url value='/static/js/physicalactivity/service/faculties_service.js' />"></script>
				
				<!-- Angular Touch Core JavaScript -->
				<script
				src="<c:url value='/static/js/physicalactivity/service/user_service.js' />"></script>
				
				<!-- Angular Touch Core JavaScript -->
				<script
				src="<c:url value='/static/js/physicalactivity/controller/signon_controller.js' />"></script>
				
				
			
			<!-- End Statement JScript-->
		</jsp:body>

	</t:signon>
</div>