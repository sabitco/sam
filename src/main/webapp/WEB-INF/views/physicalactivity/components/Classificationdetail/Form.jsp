<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>




<form role="form" ng-submit="ctrl.submit()" name="classifyDetailFormBasic"
	class="form-horizontal col-md-12 list-group">
	<fieldset class="col-md-6  text-muted menu-superior pull-right">
		<div donut-chart="" donut-data="ctrl.chartData"
			donut-colors="ctrl.chartColors" donut-formatter="ctrl.myFormatter"></div>

		<div class=" text-center text-muted  control-lable ">
			<spring:message code="param.physicalactivity.classifydetail.morris.title" />

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
				<input type="text" ng-model="ctrl.classifydetail.username" id="username"
					name="username" class="input-validate form-control input-sm"
					placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.username" />"
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
				<input type="text" ng-model="ctrl.classifydetail.name" id="name"
					name="name" class="input-validate form-control input-sm"
					placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.name" />"
					disabled />
			</div>
		</div>


		<div class="row ">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="surname"> <spring:message
						code="param.physicalactivity.signon.from.basic.lastname" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="text" ng-model="ctrl.classifydetail.surname" id="surname"
					name="surname" class="input-validate form-control input-sm"
					placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.lastname" />"
					required disabled />
			</div>
		</div>

		<div class="row">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="email"> <spring:message
						code="param.physicalactivity.signon.from.basic.email" />
				</label>
			</div>
			<div class="col-lg-8">

				<input type="email" ng-model="ctrl.classifydetail.email" id="email"
					name="email" class="input-validate form-control input-sm"
					placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.email" />"
					required disabled />
			</div>

		</div>

		<div class="row">
			<div class=" text-muted col-lg-4">
				<label class="control-lable" for="identityDocument"> <spring:message
						code="param.physicalactivity.signon.from.basic.document" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="text" ng-model="ctrl.classifydetail.identityDocument"
					id="identityDocument" name="identityDocument"
					class="input-validate form-control input-sm"
					placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.document" />"
					required disabled />
			</div>
		</div>

		<div class="row">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="age"> <spring:message
						code="param.physicalactivity.signon.from.basic.age" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="number" ng-model="ctrl.classifydetail.age" id="age"
					name="age" class="input-validate form-control input-sm" step="any"
					placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.age" />"
					required disabled />
			</div>
		</div>

		<div class="row">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="height"> <spring:message
						code="param.physicalactivity.signon.from.basic.height" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="number" ng-model="ctrl.classifydetail.height" id="height"
					name="height" class="input-validate form-control input-sm"
					step="any"
					placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.height" />"
					required disabled />
			</div>
		</div>


		<div class="row">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="weight"> <spring:message
						code="param.physicalactivity.signon.from.basic.weight" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="number" ng-model="ctrl.classifydetail.weight" id="weight"
					name="weight" class="input-validate form-control input-sm"
					step="any"
					placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.weight" />"
					required disabled />
			</div>

		</div>



		<div class="row ">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="descriptionHistory"> <spring:message
						code="param.physicalactivity.signon.from.basic.descriptionHistory" />
				</label>
			</div>
			<div class="col-lg-8">
				<textarea ng-model="ctrl.classifydetail.descriptionHistory"
					id="descriptionHistory" name="descriptionHistory"
					class="input-validate form-control input-sm"
					placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.descriptionHistory" />"
					disabled></textarea>
			</div>
		</div>


		<!-- Change this to a button or input when using this as a form -->
		<!-- 		<a class="btn btn-lg btn-success btn-block" href="index.html">Login</a> -->
	</fieldset>

	<fieldset class="col-md-12  text-muted menu-superior">
		<div class="panel panel-orange panel-default-white ">

			<div class="panel-heading">
				<spring:message
					code="param.physicalactivity.classifydetail.present.status" />
			</div>



			<div class="panel-body col-md-4 text-muted page-wrapper-sam">
				<div class="panel-orange text-muted">
					<label><spring:message
							code="param.physicalactivity.classifydetail.present.diseases" /></label>
				</div>
				<div class="checkbox">
					<label> <input type="checkbox" value="">Checkbox 2
					</label>
				</div>
				<div class="checkbox">
					<label> <input type="checkbox" value="">Checkbox 2
					</label>
				</div>
				<div class="checkbox">
					<label> <input type="checkbox" value="">Checkbox 3
					</label>
				</div>
				<div class="checkbox">
					<input type="text" ng-model="ctrl.classifydetail.otherDisease"
						id="otherDisease" name="otherDisease"
						class="input-validate form-control input-sm"
						placeholder="<spring:message
							code="param.physicalactivity.classifydetail.from.basic.otherDisease" />" />
				</div>
			</div>

			<div class="panel-body col-md-4 text-muted page-wrapper-sam">
				<div class="panel-orange text-muted">
					<label><spring:message
							code="param.physicalactivity.classifydetail.present.sports" /></label>
				</div>
				<div class="checkbox">
					<label> <input type="checkbox" value="">Checkbox 1
					</label>
				</div>
				<div class="checkbox">
					<label> <input type="checkbox" value="">Checkbox 2
					</label>
				</div>
				<div class="checkbox">
					<label> <input type="checkbox" value="">Checkbox 3
					</label>
				</div>
			</div>

			<div class="panel-body col-md-4 text-muted page-wrapper-sam">
				<div class="row ">
					<div class="panel-orange text-muted">
						<label><spring:message
								code="param.physicalactivity.classifydetail.present.practice.days" /></label>
					</div>
					<div class="checkbox">
						<label> <input type="checkbox" value="">Checkbox 1
						</label>
					</div>
					<div class="checkbox">
						<label> <input type="checkbox" value="">Checkbox 2
						</label>
					</div>
					<div class="checkbox">
						<label> <input type="checkbox" value="">Checkbox 3
						</label>
					</div>

				</div>

			</div>
		</div>
	</fieldset>

	<fieldset class="col-md-12  text-muted menu-superior">
		<div class="  form-actions text-center">
			<input type="submit"
				value="<spring:message code="param.physicalactivity.classifydetail.botton.next" />"
				class="btn btn-warning btn-lg btn-block"
				ng-disabled="classifyDetailFormBasic.$invalid">
		</div>
	</fieldset>



</form>


<!-- End Div Panel Custom Field -->
