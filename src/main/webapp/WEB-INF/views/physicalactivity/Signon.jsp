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



<div ng-controller="SignonController as ctrl">
	<!-- consulta personalizada por Pagina -->
	<c:set var="titlePage" scope="session"
		value="formulario de registr01" />

	<c:set var="name" scope="session" value="formulario de registro03" />
	
	<c:set var="namePage" scope="session"
		value="formulario de registro 2" />

	<c:set var="iconPage" scope="session"
		value="user" />

	<c:set var="nameAllPage" scope="session"
		value="" />

	<c:set var="nameListRecentPage" scope="session"
		value="" />

	<c:set var="titleTable" scope="session"
		value="" />

	
	<!-- End consulta personalizada-->

	<c:set var="usernameLogger" scope="session"
		value="Fredy Gonzalo Captuayo Novoa4" />

	<c:set var="userLogger" scope="session" value="FCAPTUAYO5" />




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
            		
            		<div class="col-xs-6 col-sm-3 panel">
						
	            	</div>
	            	
                	<div class="col-xs-12 col-sm-9 ">
<%-- 	                	<jsp:include page="components/includes/Title.jsp" /> --%>
						<jsp:include page="components/signon/Form.jsp" />					
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
					src="<c:url value='/static/js/physicalactivity/service/view_service.js' />"></script>

				<!-- Angular Touch Core JavaScript -->
				<script
					src="<c:url value='/static/js/physicalactivity/service/campus_service.js' />"></script>
				
				<!-- Angular Touch Core JavaScript -->
				<script
					src="<c:url value='/static/js/physicalactivity/service/faculties_service.js' />"></script>
				
				<!-- Angular Touch Core JavaScript -->
				<script
					src="<c:url value='/static/js/physicalactivity/controller/signon_controller.js' />"></script>
				
				
			
			<!-- End Statement JScript-->
		</jsp:body>
	
</t:template>
</div>