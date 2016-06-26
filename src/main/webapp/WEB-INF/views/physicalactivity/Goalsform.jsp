<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="components/Session.jsp" /> 

<div ng-controller="GoalsformController as ctrl"
	ng-init="getSession(
	sessionUserID,
	sessionUserUsername,
	sessionUserName,
	sessionUserSurname,
	sessionUserEmail,
	sessionUserIdentityDocument,
	sessionUserAge,
	sessionUserHeight,
	sessionUserWeight,
	sessionUserProgress)">

	<!-- consulta personalizada por Pagina -->
	<c:set var="titlePage" scope="session" value="Metas Realizadas" />
	<c:set var="namePage" scope="session" value="${sessionScope.user.name}, cuentanos que actividades has hecho para poder cumplir tus metas?" />
	<c:set var="usernameLogger" scope="session"
		value="${sessionScope.user.name}" />

	<c:set var="userLogger" scope="session"
		value="${sessionScope.user.username}" />

	<c:set var="emailLogger" scope="session"
		value="${sessionScope.user.email}" />
	<t:template>
		<jsp:attribute name="title">
			${titlePage}
		</jsp:attribute>
		<jsp:body>	
				
				<!--Div Wrapper-->
    		<div id="wrapper" style="min-height: 278px;">
				<jsp:include page="components/Navbar.jsp" /> 
			
				<!--Div Page Wrapper-->
        		<div id="page-wrapper" class="row">
            		<!-- Div .col-lg-12 -->
            		<div class="col-sm-3 panel page-wrapper-sam ">
						<jsp:include page="components/DescriptionUser.jsp" />
	            	</div>
                	<div class="col-sm-9 page-wrapper-white">
	                	<jsp:include page="components/includes/Title.jsp" />
						<div class="panel panel-body">
<!-- 							<div class="panel-orange text-muted"> -->
<%-- 								<label><spring:message code="param.physicalactivity.goals" /></label>  --%>
<!-- 							</div> -->
							<jsp:include page="components/goalsform/Form.jsp" />
							
						</div>
		            </div>
			 		<!-- End Div .col-lg-12 -->
     			</div>       
          		<!--End Div Page Wrapper-->  
     
			</div>
			<!--End Div Wrapper-->
			<jsp:include page="components/Footer.jsp" />	
	   		<script type="text/ng-template" id="modalContent.html">
				<jsp:include page="components/includes/alertSuccess.jsp" />
			</script>
			
			<script type="text/ng-template" id="modalContentError.html">
				<jsp:include page="components/includes/alertError.jsp" />
			</script>
			
			
			<!-- Statement JScript-->
				<!-- Angular Touch Core JavaScript -->
				<script
				src="<c:url value='/static/js/physicalactivity/service/goals_service.js' />"></script>
				
				<!-- Angular Touch Core JavaScript -->
				<script
				src="<c:url value='/static/js/physicalactivity/service/usergoals_service.js' />"></script>
				
				<!-- Angular Touch Core JavaScript -->
				<script
				src="<c:url value='/static/js/physicalactivity/controller/goalsform_controller.js' />"></script>
				
				<!-- Angular Touch Core JavaScript -->
				<script
				src="<c:url value='/static/js/physicalactivity/controller/modal_controller.js' />"></script>
				
			<!-- End Statement JScript-->
		</jsp:body>
	</t:template>
</div>