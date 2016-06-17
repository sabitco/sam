<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form role="form" ng-submit="ctrl.submit()" name="classifyFormBasic"
	class="form-horizontal col-md-12 list-group">

	<input type="hidden" name="id" value="ctrl.classify.id"
		ng-model="ctrl.classify.id" />

	<fieldset class="col-md-6  text-muted menu-superior pull-right">
		<div donut-chart="" donut-data="ctrl.chartData"
			donut-colors="ctrl.chartColors" donut-formatter="ctrl.myFormatter"></div>

		<div class=" text-center text-muted  control-lable ">
			<spring:message code="param.physicalactivity.classify.morris.title" />

		</div>
	</fieldset>
	<fieldset class="col-md-6  text-muted menu-superior">
		<div class="row ">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="username"> <spring:message
						code="param.physicalactivity.signon.from.basic.username" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="text" ng-model="ctrl.classify.username" id="username"
					name="username" class="input-validate form-control input-sm"
					disabled />
			</div>
		</div>



		<div class="row">
			<div class=" text-muted col-lg-4">
				<label class="control-lable" for="name"> <spring:message
						code="param.physicalactivity.signon.from.basic.name" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="text" ng-model="ctrl.classify.name" id="name"
					name="name" class="input-validate form-control input-sm" disabled />
			</div>
		</div>


		<div class="row ">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="surname"> <spring:message
						code="param.physicalactivity.signon.from.basic.lastname" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="text" ng-model="ctrl.classify.surname" id="surname"
					name="surname" class="input-validate form-control input-sm"
					disabled />
			</div>
		</div>

		<div class="row">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="email"> <spring:message
						code="param.physicalactivity.signon.from.basic.email" />
				</label>
			</div>
			<div class="col-lg-8">

				<input type="text" ng-model="ctrl.classify.email" id="email"
					name="email" class="input-validate form-control input-sm" disabled />
			</div>

		</div>

		<div class="row">
			<div class=" text-muted col-lg-4">
				<label class="control-lable" for="identityDocument"> <spring:message
						code="param.physicalactivity.signon.from.basic.document" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="text" ng-model="ctrl.classify.identityDocument"
					id="identityDocument" name="identityDocument"
					class="input-validate form-control input-sm" disabled />
			</div>
		</div>

		<div class="row">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="age"> <spring:message
						code="param.physicalactivity.signon.from.basic.age" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="text" ng-model="ctrl.classify.age" id="age" name="age"
					class="input-validate form-control input-sm" disabled />
			</div>
		</div>

		<div class="row">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="height"> <spring:message
						code="param.physicalactivity.signon.from.basic.height" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="number" ng-model="ctrl.classify.height" id="height"
					name="height" class="input-validate form-control input-sm"
					step="any" disabled />
			</div>
		</div>


		<div class="row">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="weight"> <spring:message
						code="param.physicalactivity.signon.from.basic.weight" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="number" ng-model="ctrl.classify.weight" id="weight"
					name="weight" class="input-validate form-control input-sm"
					step="any" disabled />
			</div>
		</div>
	</fieldset>

	<fieldset class="col-md-12  text-muted menu-superior">
		<div class="panel panel-orange panel-default-white">
			<div class="panel-heading">
				<spring:message
					code="param.physicalactivity.classify.present.sports" />
			</div>

			<div class="panel-body">
				<ul class="chat" ng-repeat="activities in listSportsCheckedSelect">
					<li class="left clearfix">
						<div class="clearfix">
							<div class="header">
								<strong class="primary-font">{{activities.name}}</strong> <small
									class="pull-right text-muted"> <i
									class="fa fa-clock-o fa-fw"></i>
								</small>
							</div>

							<div class="col-lg-6">

								<div class=" col-lg-4">
									<spring:message
										code="param.physicalactivity.classifydetail.from.basic.frequency" />

								</div>
								<div class="col-lg-6">
									<input type="number" ng-model="ctrl.classify.frequency"
										id="height" name="height"
										class="input-validate form-control input-sm" step="any"
										placeholder="<spring:message
						code="param.physicalactivity.classifydetail.from.basic.required.frequency" />"
										required min="1" max="7"
										ng-minlength="
							<spring:message code="param.physicalactivity.classifydetail.from.basic.quantity.minlength.frequency" />
						"
										string-to-number />
								</div>
								<div class=" text-muted col-lg-1">
									<label for="height"> <spring:message
											code="param.physicalactivity.classifydetail.from.basic.suffix.frequency" />
									</label>
								</div>
								<div
									class="has-error text-danger text-muted col-lg-12 text-center"
									ng-show="classifyFormBasic.height.$dirty">
									<span ng-show="classifyFormBasic.height.$error.minlength">
										<spring:message
											code="param.physicalactivity.classifydetail.from.basic.minlength.frequency" />
									</span>
								</div>
							</div>

							<div class="col-lg-6">

								<div class=" col-lg-4">
									<spring:message
										code="param.physicalactivity.classifydetail.from.basic.duration" />

								</div>
								<div class="col-lg-6">
									<input type="number" ng-model="ctrl.classify.duration"
										id="height" name="height"
										class="input-validate form-control input-sm" step="any"
										placeholder="<spring:message
						code="param.physicalactivity.classifydetail.from.basic.required.duration" />"
										required min="1" max="7"
										ng-minlength="
							<spring:message code="param.physicalactivity.classifydetail.from.basic.quantity.minlength.duration" />
						"
										 />
								</div>
								<div class=" text-muted col-lg-1">
									<label for="height"> <spring:message
											code="param.physicalactivity.classifydetail.from.basic.suffix.duration" />
									</label>
								</div>
								<div
									class="has-error text-danger text-muted col-lg-12 text-center"
									ng-show="classifyFormBasic.height.$dirty">
									<span ng-show="classifyFormBasic.height.$error.minlength">
										<spring:message
											code="param.physicalactivity.classifydetail.from.basic.minlength.duration" />
									</span>
								</div>
							</div>
					</li>
				</ul>
			</div>
		</div>

	</fieldset>

	<fieldset class="col-md-12  text-muted menu-superior">
		<div class="  form-actions text-center">
			<input type="submit"
				value="<spring:message code="param.physicalactivity.classify.botton.next" />"
				class="btn btn-warning btn-lg btn-block"
				ng-disabled="classifyFormBasic.$invalid">
		</div>
	</fieldset>



</form>


<!-- End Div Panel Custom Field -->
