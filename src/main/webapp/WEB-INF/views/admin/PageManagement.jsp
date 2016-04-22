<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- consulta personalizada por Pagina -->
<c:set var="titlePageAdministrator" scope="session"
	value="titlePageAdministrator6" />
<c:set var="naPageAdministrator" scope="session"
	value="Paginas recientes" />

<c:set var="namePageAdministrator" scope="session"
	value="Home de Paginas1" />

<c:set var="iconPageAdministrator" scope="session" value="fa-sitemap" />

<c:set var="nameAllPageAdministrator" scope="session" value="All Pages2" />

<c:set var="nameListRecentPage" scope="session"
	value="Paginas Recientes3" />

<c:set var="usernameLogger" scope="session"
	value="Fredy Gonzalo Captuayo Novoa4" />

<c:set var="userLogger" scope="session" value="FCAPTUAYO5" />

<c:set var="titleTable" scope="session" value="Listado de Pages7" />

<c:set var="name" scope="session" value="Pages9" />
<!-- End consulta personalizada-->


<t:admintemplate>
	<jsp:attribute name="title">
		${titlePageAdministrator}
	</jsp:attribute>
	<jsp:body>	
		<!--Div Wrapper-->
    	<div id="wrapper" style="min-height: 278px;"
			ng-controller="PageController as ctrl">
			
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
			src="<c:url value='/static/js/physicalactivity/service/enum_service.js' />"></script>
			<!-- Angular Touch Core JavaScript -->
			<script
			src="<c:url value='/static/js/physicalactivity/controller/page_controller.js' />"></script>
		<!-- End Statement JScript-->

    </jsp:body>
</t:admintemplate>
