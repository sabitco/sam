<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<style>
.input-validate.ng-valid {
 background-color: lightgreen;
}

.input-validate.ng-dirty.ng-invalid-required {
 background-color: red;
}

.input-validate.ng-dirty.ng-invalid-minlength {
 background-color: yellow;
}

.input-validate.ng-dirty.ng-invalid {
 background-color: red;
}
</style>



<div ng-controller="PageController as ctrl">
	<!-- consulta personalizada por Pagina -->
	<c:set var="titlePageAdministrator" scope="session"
		value="{{ctrl.descriptionPage.title}}" />


	<c:set var="namePageAdministrator" scope="session"
		value="{{ctrl.descriptionPage.namePage}}" />

	<c:set var="iconPageAdministrator" scope="session"
		value="{{ctrl.descriptionPage.icone}}" />

	<c:set var="nameAllPageAdministrator" scope="session"
		value="{{ctrl.descriptionPage.namePageAll}}" />

	<c:set var="nameListRecentPage" scope="session"
		value="{{ctrl.descriptionPage.descriptionListRecent}}" />

	<c:set var="titleTable" scope="session"
		value="{{ctrl.descriptionPage.descriptionList}}" />

	<c:set var="name" scope="session" value="{{ctrl.descriptionPage.name}}" />
	<!-- End consulta personalizada-->

	<c:set var="usernameLogger" scope="session"
		value="Fredy Gonzalo Captuayo Novoa4" />

	<c:set var="userLogger" scope="session" value="FCAPTUAYO5" />




<t:admintemplate>	
		<jsp:attribute name="title">
			${titlePageAdministrator}
		</jsp:attribute>
		<jsp:body>	
		<!--Div Wrapper-->
    		<div id="wrapper" style="min-height: 278px;">
				<jsp:include page="components/Navbar.jsp" /> 
			
				<!--Div Page Wrapper-->
        		<div id="page-wrapper" class="row">
            		<!-- Div .col-lg-12 -->
                	<div class="col-xs-12 col-sm-9 ">
	                	<jsp:include page="components/includes/Title.jsp" />
						<jsp:include page="components/pageManagement/FormPage.jsp" />					
		            </div>
	           		<div class="col-xs-6 col-sm-3 panel">
						<jsp:include page="components/pageManagement/ListRecentPage.jsp" /> 
	            	</div>
	            	<div class="col-lg-12">
						<jsp:include page="components/pageManagement/ListPage.jsp" /> 
					</div>
			 		<!-- End Div .col-lg-12 -->
     			</div>       
          		<!--End Div Page Wrapper-->  
          	                 
				<!--Statement Footer-->
				<div class="col-lg-12 ">
					<jsp:include page="components/Footer.jsp" /> 	
				</div>
				<!--End Statement Footer-->
			</div>
			<!--End Div Wrapper-->
	
			<!-- Statement JScript-->
			
				<!-- Angular Touch Core JavaScript -->
				<script
					src="<c:url value='/static/js/physicalactivity/service/crud_service.js' />"></script>
				<!-- Angular Touch Core JavaScript -->
				<script
					src="<c:url value='/static/js/physicalactivity/service/type_page_service_enum.js' />"></script>
				
				<!-- Angular Touch Core JavaScript -->
				<script
					src="<c:url value='/static/js/physicalactivity/service/state_service_enum.js' />"></script>
				
				<!-- Angular Touch Core JavaScript -->
				<script
					src="<c:url value='/static/js/physicalactivity/service/search_page_service.js' />"></script>
				
				<!-- Angular Touch Core JavaScript -->
				<script
					src="<c:url value='/static/js/physicalactivity/controller/page_controller.js' />"></script>
				
				<!-- Angular Touch Core JavaScript -->
				<script
					src="<c:url value='/static/js/physicalactivity/controller/description_page_controller.js' />"></script>
			<!-- End Statement JScript-->
		</jsp:body>
	
</t:admintemplate>
</div>