<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="co.edu.unal.sam.aspect.properties.ReadFromPropertiesFile"%>
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



<div>
	<t:loguintemplate>
		<jsp:attribute name="title">
			<spring:message code="page.login.title" />
		</jsp:attribute>
		<jsp:body>	
		<div class="panel-body formcontainer">
			<div th:if="${param.error}">
            	Invalid username and password.
        	</div>
        	<div th:if="${param.logout}">
            	You have been logged out.
        	</div>
        	<form th:action="@{/login}" method="post"
					class="form-horizontal">
            	
            	<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-2 control-lable" for="username"> 
							User Name
						</label>
						<div class="col-md-7" style="border-color: yellow;">
							<input type="text" id="username" name="username"
											class="input-validate form-control input-sm"
											placeholder="digite su user name" />
						</div>
					</div>
				</div>
            	<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-2 control-lable" for="password"> 
							Password
						</label>
						<div class="col-md-7" style="border-color: yellow;">
							<input type="password" id="password" name="password"
											class="input-validate form-control input-sm"
											placeholder="digite su user password" />
						</div>
					</div>
				</div>
        

				<div class="pull-right  form-actions floatRight">
					<input type="submit" value="Sign In"
						class="btn btn-success btn-sm">
				</div>
        	</form>	
        </div>
		</jsp:body>

	</t:loguintemplate>
</div>




