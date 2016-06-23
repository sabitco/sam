<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>





<div ng-controller="">
	<!-- consulta personalizada por Pagina -->
	<c:set var="titlePage" scope="session" value="SAM - Iniciar Sesión" />
	<c:set var="name" scope="session" value="" />
	<t:loguintemplate>
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
								<spring:message code="param.physicalactivity.login.from.basic" />
							</div>
							<div class="row text-center logo-sam">
                            	<img
									src="/static//dist/physicalactivity/images/logo1.png"
									alt="logo">    
                            </div>
							<form action="login" method="post" role="form">
				                  <fieldset>
				                    <div class="form-group">
				                      <input class="form-control"
											placeholder="Nombre de Usuario" name="username" autofocus>
				                    </div>
				                    <div class="form-group">
				                      <input class="form-control"
											placeholder="Contraseña" name="password" type="password"
											value="">
				                    </div>
				                    <div>
				                    <a href="/physicalactivity/signon" class="btn btn-warning btn-sm pull-left custom-width"><spring:message
												code="param.physicalactivity.login.from.button.register" /></a>
				    
				                     <button
											class="btn btn-warning btn-sm pull-right custom-width"
											type="submit">
											<spring:message
												code="param.physicalactivity.login.from.button.login" />
										</button>
				                    </div>
				                  </fieldset>
                			</form>
						</div>
	                </div>
	            </div>
	   		</div> 
		</jsp:body>

	</t:loguintemplate>
</div>

