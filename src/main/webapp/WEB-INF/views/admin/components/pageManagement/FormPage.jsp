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

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="id"> <spring:message
						code="param.form.custom.page.id" />
				</label>
				<div class="col-md-7">
					<input type="text" ng-model="ctrl.page.id" id="id"
						class="name form-control input-sm" ng-disabled="true" />
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="name"> <spring:message
						code="param.form.custom.page.name" />
				</label>
				<div class="col-md-7" style="border-color: yellow;">
					<input type="text" ng-model="ctrl.page.name" id="name" name="name"
						class="input-validate form-control input-sm"
						placeholder="<spring:message
						code="param.form.required.custom.page.name" />"
						ng-model="pageForm.name" required
						ng-minlength="
							<spring:message code="param.form.quantity.minlength.custom.page.name" />
						" />
					<div class="has-error" ng-show="pageForm.name.$dirty">
						<span ng-show="pageForm.name.$error.minlength"> <spring:message
								code="param.form.minlength.custom.page.name" />
						</span>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="title"> <spring:message
						code="param.form.custom.page.title" />
				</label>
				<div class="col-md-7">
					<input type="text" ng-model="ctrl.page.title" id="title"
						name="title" class="input-validate form-control input-sm"
						placeholder="<spring:message
						code="param.form.required.page.title" />"
						required
						ng-minlength="
							<spring:message code="param.form.quantity.minlength.page.title" />
						" />
					<div class="has-error" ng-show="pageForm.title.$dirty">
						<span ng-show="pageForm.title.$error.minlength"> <spring:message
								code="param.form.minlength.page.title" />
						</span>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="descriptionPage">
					<spring:message code="param.form.custom.page.description.page" />
				</label>
				<div class="col-md-7">
					<input type="text" ng-model="ctrl.page.descriptionPage"
						id="descriptionPage" name="descriptionPage"
						class="input-validate form-control input-sm"
						placeholder="<spring:message
						code="param.form.required.page.description.page" />"
						required
						ng-minlength="
							<spring:message code="param.form.quantity.minlength.page.description.page" />
						" />
					<div class="has-error" ng-show="pageForm.descriptionPage.$dirty">
						<span ng-show="pageForm.descriptionPage.$error.minlength">
							<spring:message code="param.form.minlength.page.description.page" />
						</span>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="base"> <spring:message
						code="param.form.custom.page.base" />
				</label>
				<div class="col-md-7">
					<input type="text" ng-model="ctrl.page.base" id="base" name="base"
						class="input-validate form-control input-sm"
						placeholder="<spring:message
						code="param.form.required.page.base" />"
						required
						ng-minlength="
							<spring:message code="param.form.quantity.minlength.page.base" />
						" />
					<div class="has-error" ng-show="pageForm.base.$dirty">
						<span ng-show="pageForm.base.$error.minlength"> <spring:message
								code="param.form.minlength.page.base" />
						</span>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="url"> <spring:message
						code="param.form.custom.page.url" />
				</label>
				<div class="col-md-7">
					<input type="text" ng-model="ctrl.page.url" id="url" name="url"
						class="input-validate form-control input-sm"
						placeholder="<spring:message
						code="param.form.required.page.url" />"
						required
						ng-minlength="
							<spring:message code="param.form.quantity.minlength.page.url" />
						" />
					<div class="has-error" ng-show="pageForm.url.$dirty">
						<span ng-show="pageForm.url.$error.minlength"> <spring:message
								code="param.form.minlength.page.url" />
						</span>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="icone"> <spring:message
						code="param.form.custom.page.icone" />
				</label>
				<div class="col-md-7">
					<input type="text" ng-model="ctrl.page.icone" name="icone"
						id="icone" class="input-validate form-control input-sm"
						placeholder="<spring:message
						code="param.form.required.page.icone" />"
						required
						ng-minlength="
							<spring:message code="param.form.quantity.minlength.page.icone" />
						" />
					<div class="has-error" ng-show="pageForm.icone.$dirty">
						<span ng-show="pageForm.icone.$error.minlength"> <spring:message
								code="param.form.minlength.page.icone" />
						</span>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="allNamePageAll">
					<spring:message code="param.form.custom.page.name.all.page" />
				</label>
				<div class="col-md-7">
					<input type="text" ng-model="ctrl.page.namePageAll"
						id="allNamePageAll" name="allNamePageAll"
						class="input-validate form-control input-sm"
						placeholder="<spring:message
						code="param.form.required.page.name.all.page" />"
						required
						ng-minlength="
							<spring:message code="param.form.quantity.minlength.page.name.all.page" />
						" />
					<div class="has-error" ng-show="pageForm.allNamePageAll.$dirty">
						<span ng-show="pageForm.allNamePageAll.$error.minlength"> <spring:message
								code="param.form.minlength.page.name.all.page" />
						</span>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="namePage"> <spring:message
						code="param.form.custom.page.name.page" />
				</label>
				<div class="col-md-7">
					<input type="text" ng-model="ctrl.page.namePage" name="namePage"
						id="namePage" class="input-validate form-control input-sm"
						placeholder="<spring:message
						code="param.form.required.page.name.page" />"
						required
						ng-minlength="
							<spring:message code="param.form.quantity.minlength.page.name.page" />
						" />
					<div class="has-error" ng-show="pageForm.namePage.$dirty">
						<span ng-show="pageForm.namePage.$error.minlength"> <spring:message
								code="param.form.minlength.page.name.page" />
						</span>
					</div>
				</div>
			</div>
		</div>



		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="descriptionListRecent">
					<spring:message
						code="param.form.custom.page.description.list.recent" />
				</label>
				<div class="col-md-7">
					<input type="text" ng-model="ctrl.page.descriptionListRecent"
						id="descriptionListRecent" name="descriptionListRecent"
						class="input-validate form-control input-sm"
						placeholder="<spring:message
						code="param.form.required.page.description.list.recent" />"
						required
						ng-minlength="
							<spring:message code="param.form.quantity.minlength.page.description.list.recent" />
						" />
					<div class="has-error"
						ng-show="pageForm.descriptionListRecent.$dirty">
						<span ng-show="pageForm.descriptionListRecent.$error.minlength">
							<spring:message
								code="param.form.minlength.page.description.list.recent" />
						</span>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="descriptionList">
					<spring:message code="param.form.custom.page.description.list" />
				</label>
				<div class="col-md-7">
					<input type="text" ng-model="ctrl.page.descriptionList"
						id="descriptionList" name="descriptionList"
						class="input-validate form-control input-sm"
						placeholder="<spring:message
						code="param.form.required.page.description.list" />"
						required
						ng-minlength="
							<spring:message code="param.form.quantity.minlength.page.description.list" />
						" />
					<div class="has-error" ng-show="pageForm.descriptionList.$dirty">
						<span ng-show="pageForm.descriptionList.$error.minlength">
							<spring:message code="param.form.minlength.page.description.list" />
						</span>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="typePage"> <spring:message
						code="param.form.custom.page.type_page_id" />
				</label>
				<div class="col-md-7">
					<select id="typePage" name="typePage"
						class="input-validate form-control"
						ng-init="ctrl.page.typePage = ctrl.page.typePage || items[0]"
						ng-options="typePageEnum for typePageEnum in ctrl.enumTypePages"
						ng-model="ctrl.page.typePage" ng-change="show()" required>
					</select>
					<div class="has-error" ng-show="pageForm.typePage.$dirty">
						<span ng-show="pageForm.typePage.$error.required"> <spring:message
								code="param.form.required.page.type_page_id" />
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
						ng-init="ctrl.page.state = ctrl.page.state || items[0]"
						ng-options="stateEnum for stateEnum in ctrl.enumStates"
						ng-model="ctrl.page.state" ng-change="show()" required>
					</select>
					<div class="has-error" ng-show="pageForm.state.$dirty">
						<span ng-show="pageForm.state.$error.required"> <spring:message
								code="param.form.required.page.state" />
						</span>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="orderPage"> <spring:message
						code="param.form.custom.page.order.page" />
				</label>
				<div class="col-md-7">
					<input type="number" ng-model="ctrl.page.orderPage" id="orderPage"
						name="orderPage" class="input-validate form-control input-sm"
						placeholder="<spring:message
						code="param.form.custom.page.order.page" />"
						required min="1" max="20"
						ng-minlength="
							<spring:message code="param.form.quantity.minlength.page.order.page" />
						" />
					<div class="has-error" ng-show="pageForm.orderPage.$dirty">
						<span ng-show="pageForm.orderPage.$error.required"> <spring:message
								code="param.form.required.page.order.page" />
						</span> <span ng-show="pageForm.orderPage.$error.minlength"> <spring:message
								code="param.form.minlength.page.order.page" />
						</span> <span ng-show="pageForm.orderPage.$invalid"> <spring:message
								code="param.form.invalid.page.order.page" />
						</span>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="registerdate"> <spring:message
						code="param.form.custom.page.register.date" />
				</label>
				<div class="col-md-7">
					<input type="datetime-local" ng-model="ctrl.page.dateRegister" id="registerdate"
						class="name form-control input-sm" ng-disabled="true" />
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="updatedate"> <spring:message
						code="param.form.custom.page.update.date" />
				</label>
				<div class="col-md-7">
					<input type="datetime-local" ng-model="ctrl.page.dateUpdate" id="updatedate"
						class="name form-control input-sm" ng-disabled="true" />
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
