<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>





<div class="panel-body formcontainer">

	<h3 class="page-header-titlelist page-header">
		<em class="text-primary"> ${name} </em>
	</h3>

	<form ng-submit="ctrl.submit()" name="signonFormBasic"
		class="form-horizontal">

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="name"> <spring:message
						code="param.physicalactivity.signon.from.basic.name" />
				</label>
				<div class="col-md-7">
					<input type="text" ng-model="ctrl.signonBasic.name" id="name"
						name="name" class="input-validate form-control input-sm"
						placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.name" />"
						required
						ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.name" />
						" />
					<div class="has-error" ng-show="signonFormBasic.name.$dirty">
						<span ng-show="signonFormBasic.name.$error.minlength"> <spring:message
								code="param.physicalactivity.signon.from.basic.minlength.name" />
						</span>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="lastname"> <spring:message
						code="param.physicalactivity.signon.from.basic.lastname" />
				</label>
				<div class="col-md-7">
					<input type="text" ng-model="ctrl.signonBasic.lastname" id="lastname"
						name="lastname" class="input-validate form-control input-sm"
						placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.lastname" />"
						required
						ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.lastname" />
						" />
					<div class="has-error" ng-show="signonFormBasic.lastname.$dirty">
						<span ng-show="signonFormBasic.lastname.$error.minlength"> <spring:message
								code="param.physicalactivity.signon.from.basic.minlength.lastname" />
						</span>
					</div>
				</div>
			</div>
		</div>
		
		
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="document"> <spring:message
						code="param.physicalactivity.signon.from.basic.document" />
				</label>
				<div class="col-md-7">
					<input type="number" ng-model="ctrl.signonBasic.document" id="document"
						name="document" class="input-validate form-control input-sm"
						placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.document" />"
						required
						ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.document" />
						" />
					<div class="has-error" ng-show="signonFormBasic.document.$dirty">
						<span ng-show="signonFormBasic.document.$error.minlength"> <spring:message
								code="param.physicalactivity.signon.from.basic.minlength.document" />
						</span>
					</div>
				</div>
			</div>
		</div>
		<div class="pull-right  form-actions floatRight">
			<input type="submit"
				value="{{!ctrl.signonBasic.id ? 'Add' : 'Update'}}"
				class="btn btn-success btn-sm"
				ng-disabled="signonFormBasic.$invalid">

			<button type="button" ng-click="ctrl.resetBasic()"
				class="btn btn-warning btn-sm"
				ng-disabled="signonFormBasic.$pristine">
				<spring:message code="param.botton.form.recent" />
				Form
			</button>
		</div>
	</form>
</div>
<!-- End Div Panel Custom Field -->
