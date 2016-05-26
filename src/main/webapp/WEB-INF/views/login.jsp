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

.custom-width {
	width: 100px !important;
}
</style>
<t:loguintemplate>
  <jsp:attribute name="title">
    <spring:message code="page.login.title" />
	</jsp:attribute>
  <jsp:body>
    <div class="container">
      <div class="row">
        <div class="col-md-3 col-md-offset-4">
	      <div class="login-panel panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Please Sign In</h3>
            </div>
              <div class="panel-body">
                <form th:action="@{/login}" method="post" role="form">
                  <fieldset>
                    <div class="form-group">
                      <input class="form-control" placeholder="Username"
                      name="username" autofocus>
                    </div>
                    <div class="form-group">
                      <input class="form-control" placeholder="Password"
                      name="password" type="password" value="">
                    </div>
                    <div>
    <button onclick="location.href='/physicalactivity/signon';" 
                      class="btn btn-warning btn-sm pull-left custom-width">Crear Cuenta</button>
                     <button
                      class="btn btn-warning btn-sm pull-right custom-width"
                      type="submit">Ingresar</button>
                    </div>
                  </fieldset>
                </form>
              </div>
            </div>
          </div>
	   </div>
     </div>
  </jsp:body>
</t:loguintemplate>