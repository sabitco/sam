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

	<form ng-submit="ctrl.submit()" name="pageForm" class="form-horizontal">

		<input type="hidden" ng-model="ctrl.page.id" /> <input type="hidden"
			ng-model="ctrl.page.dateRegister" />

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="name">
					<spring:message
						code="param.form.custom.page.name" /> </label>
				<div class="col-md-7">
					<input type="text" ng-model="ctrl.page.name" id="name"
						class="name form-control input-sm"
						placeholder="${nameRequiredCustomForm}" required ng-minlength="4" />
					<div class="has-error" ng-show="pageForm.name.$dirty">

						<span ng-show="pageForm.name.$error.required"> 11 </span> <span
							ng-show="pageForm.name.$error.minlength"> 2 </span> <span
							ng-show="pageForm.name.$invalid"> 3 </span>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="order">
					<spring:message
						code="param.form.custom.page.order.page" /> </label>
				<div class="col-md-7">
					<input type="number" ng-model="ctrl.page.order" id="order"
						class="order form-control input-sm"
						placeholder="${orderRequieredCustomForm}" required min="1"
						max="20" />
					<div class="has-error" ng-show="pageForm.order.$dirty">
						<span ng-show="pageForm.order.$error.required"> 5 </span> <span
							ng-show="pageForm.order.$error.minlength"> 6 </span> <span
							ng-show="pageForm.order.$invalid"> 7 </span>
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
					<select ng-init="ctrl.page.state = ctrl.page.state || items[0]"
						ng-options="stateEnum for stateEnum in ctrl.enumStates"
						ng-model="ctrl.page.state" ng-change="show()" required>
					</select>
					<div class="has-error" ng-show="pageForm.state.$dirty">
						<span ng-show="pageForm.state.$error.required">This is a
							required field</span> <span ng-show="pageForm.state.$invalid">This
							field is invalid </span>

					</div>
				</div>
			</div>
		</div>

		<div class="pull-right  form-actions floatRight">
			<input type="submit" value="{{!ctrl.page.id ? 'Add' : 'Update'}}"
				class="btn btn-success btn-sm" ng-disabled="pageForm.$invalid">

			<button type="button" ng-click="ctrl.reset()"
				class="btn btn-warning btn-sm" ng-disabled="pageForm.$pristine">
				<spring:message code="param.botton.form.recent" />
				Form
			</button>
		</div>
	</form>
</div>
<!-- End Div Panel Custom Field -->
