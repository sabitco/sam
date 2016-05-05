<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!-- Var of Error validation -->
<c:set var="messageErrorFormRequiredField">
	<spring:message code="param.message.error.form.required.field" />
</c:set>

<c:set var="messageErrorFormMinimumLengthRequired">
	<spring:message code="param.message.error.form.minimum.length.required" />
</c:set>

<c:set var="messageErrorFormFieldInvalid">
	<spring:message code="param.message.error.form.field.invalid" />
</c:set>
<!-- End Var of Error Validation -->



<div class="panel-body formcontainer" uib-collapse="!status.isFirstOpen">

	<h3 class="page-header-titlelist page-header">
		<em class="text-primary"> <spring:message
				code="param.component.form" /> <i class="pull-right glyphicon"
			ng-class="{'glyphicon-remove btn btn-danger btn-circle': 
					        						status.isFirstOpen, 
					        						'glyphicon-arrow-down btn btn-info btn-circle': 
					        						!status.isFirstOpen}"
			ng-click="status.isFirstOpen = !status.isFirstOpen"> </i>
		</em>
	</h3>

	<form ng-submit="ctrl.submit()" name="userForm" class="form-horizontal">

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="id"> <spring:message
						code="param.form.custom.user.id" />
				</label>
				<div class="col-md-7">
					<input type="text" ng-model="ctrl.user.id" id="id"
						class="name form-control input-sm" ng-disabled="true" />
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="name"> <spring:message
						code="param.form.custom.user.name" />
				</label>
				<div class="col-md-7" style="border-color: yellow;">
					<input type="text" ng-model="ctrl.user.name" id="name" name="name"
						class="input-validate form-control input-sm"
						placeholder="<spring:message
						code="param.form.required.custom.user.name" />"
						ng-model="userForm.name" required
						ng-minlength="
							<spring:message code="param.form.quantity.minlength.custom.user.name" />
						" />
					<div class="has-error" ng-show="userForm.name.$dirty">
						<span ng-show="userForm.name.$error.minlength"> <spring:message
								code="param.form.minlength.custom.user.name" />
						</span>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="state"> <spring:message
						code="parameter.from.custom.state" />
				</label>
				<div class="col-md-7">
					<select id="state" name="state"
						class="input-validate form-control"
						ng-init="ctrl.user.state = ctrl.user.state || items[0]"
						ng-options="stateEnum for stateEnum in ctrl.enumStates"
						ng-model="ctrl.user.state" ng-change="show()" required>
					</select>
					<div class="has-error" ng-show="userForm.state.$dirty">
						<span ng-show="userForm.state.$error.required"> <spring:message
								code="param.form.required.user.state" />
						</span>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="registerdate"> <spring:message
						code="param.form.custom.user.register.date" />
				</label>
				<div class="col-md-7">
					<input type="text" ng-model="ctrl.user.id" id="registerdate"
						class="name form-control input-sm" ng-disabled="true" />
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="updatedate"> <spring:message
						code="param.form.custom.user.update.date" />
				</label>
				<div class="col-md-7">
					<input type="text" ng-model="ctrl.user.id" id="updatedate"
						class="name form-control input-sm" ng-disabled="true" />
				</div>
			</div>
		</div>


		<div class="pull-right  form-actions floatRight">
			<input type="submit" value="{{!ctrl.user.id ? 'Add' : 'Update'}}"
				class="btn btn-success btn-sm" ng-disabled="userForm.$invalid">

			<button type="button" ng-click="ctrl.reset()"
				class="btn btn-warning btn-sm" ng-disabled="userForm.$pristine">
				<spring:message code="param.botton.form.recent" />
				Form
			</button>
		</div>
	</form>
</div>
<!-- End Div Panel Custom Field -->
