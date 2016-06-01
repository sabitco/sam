<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>




<form role="form" ng-submit="ctrl.submit()" name="signonFormBasic"
	class="form-horizontal col-md-12 list-group">
	<fieldset>
		<div class="row ">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="username"> <spring:message
						code="param.physicalactivity.signon.from.basic.username" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="text" ng-model="ctrl.signonBasic.username"
					id="username" name="username"
					class="input-validate form-control input-sm"
					placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.username" />"
					required
					ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.username" />
						" />
			</div>


			<div class="has-error text-danger text-muted col-lg-10 text-center "
				ng-show="signonFormBasic.username.$dirty">
				<span ng-show="signonFormBasic.username.$error.minlength"> <spring:message
						code="param.physicalactivity.signon.from.basic.minlength.username" />
				</span>
			</div>
		</div>



		<div class="row">
			<div class=" text-muted col-lg-4">
				<label class="control-lable" for="name"> <spring:message
						code="param.physicalactivity.signon.from.basic.name" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="text" ng-model="ctrl.signonBasic.name" id="name"
					name="name" class="input-validate form-control input-sm"
					placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.name" />"
					required
					ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.name" />
						" />
			</div>
			<div class="has-error text-danger text-muted col-lg-10 text-center"
				ng-show="signonFormBasic.name.$dirty">
				<span ng-show="signonFormBasic.name.$error.minlength"> <spring:message
						code="param.physicalactivity.signon.from.basic.minlength.name" />
				</span>
			</div>

		</div>


		<div class="row ">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="surname"> <spring:message
						code="param.physicalactivity.signon.from.basic.lastname" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="text" ng-model="ctrl.signonBasic.surname" id="surname"
					name="surname" class="input-validate form-control input-sm"
					placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.lastname" />"
					required
					ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.lastname" />
						" />
			</div>
			<div class="has-error text-danger text-muted col-lg-10 text-center"
				ng-show="signonFormBasic.surname.$dirty">
				<span ng-show="signonFormBasic.surname.$error.minlength"> <spring:message
						code="param.physicalactivity.signon.from.basic.minlength.lastname" />
				</span>
			</div>
		</div>



		<div class="row">
			<div class=" text-muted col-lg-4">
				<label class="control-lable" for="password"> <spring:message
						code="param.physicalactivity.signon.from.basic.password" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="password" ng-model="ctrl.signonBasic.password"
					id="password" name="password"
					class="input-validate form-control input-sm"
					placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.password" />"
					required
					ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.password" />
						" />
			</div>
			<div class="has-error text-danger text-muted col-lg-10 text-center"
				ng-show="signonFormBasic.password.$dirty">
				<span ng-show="signonFormBasic.password.$error.minlength"> <spring:message
						code="param.physicalactivity.signon.from.basic.minlength.password" />
				</span>
			</div>
		</div>


		<div class="row">
			<div class="text-muted col-lg-4">
				<label class="control-lable" for="confirmpassword"> <spring:message
						code="param.physicalactivity.signon.from.basic.confirmpassword" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="password" ng-model="ctrl.signonBasic.confirmpassword"
					id="confirmpassword" name="confirmpassword"
					class="input-validate form-control input-sm"
					placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.confirmpassword" />"
					required pw-check="confirmpassword"
					ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.confirmpassword" />
						" />
			</div>
			<div class="has-error text-danger text-muted col-lg-10 text-center"
				ng-show="signonFormBasic.password.$dirty">
				<span ng-show="signonFormBasic.password.$error.minlength"> <spring:message
						code="param.physicalactivity.signon.from.basic.invalid.confirmpassword" />
				</span> <span ng-show="signonFormBasic.password.$error.pwmatch"> <spring:message
						code="param.physicalactivity.signon.from.basic.invalid.confirmpassword.compare" />
				</span>
			</div>
		</div>


		<div class="row">
			<div class=" text-muted col-lg-4">
				<label class="control-lable" for="identityDocument"> <spring:message
						code="param.physicalactivity.signon.from.basic.document" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="text" ng-model="ctrl.signonBasic.identityDocument"
					id="identityDocument" name="identityDocument"
					class="input-validate form-control input-sm"
					placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.document" />"
					required min="999999"
					ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.document" />
						" />
			</div>
			<div class="has-error text-danger text-muted col-lg-10 text-center"
				ng-show="signonFormBasic.identityDocument.$dirty">
				<span ng-show="signonFormBasic.identityDocument.$error.minlength">
					<spring:message
						code="param.physicalactivity.signon.from.basic.minlength.document" />
				</span>
			</div>
		</div>

		<div class="row">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="email"> <spring:message
						code="param.physicalactivity.signon.from.basic.email" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="email" ng-model="ctrl.signonBasic.email" id="email"
					name="email" class="input-validate form-control input-sm"
					placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.email" />"
					required
					ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.email" />
						" />
			</div>
			<div class="has-error text-danger text-muted col-lg-10 text-center"
				ng-show="signonFormBasic.email.$dirty">
				<span ng-show="signonFormBasic.email.$error.minlength"> <spring:message
						code="param.physicalactivity.signon.from.basic.minlength.email" />
				</span> <span ng-show="signonFormBasic.email.$error.email"> <spring:message
						code="param.physicalactivity.signon.from.basic.invalid.email" />
				</span>
			</div>
		</div>

		<div class="row">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="dateBirth"> <spring:message
						code="param.physicalactivity.signon.from.basic.dateBirth" />
				</label>
			</div>
			<div class="col-lg-8">
				<div class="col-lg-10">
					<input type="text" class="form-control" uib-datepicker-popup
						ng-model="dateBirth" is-open="popup2.opened"
						datepicker-options="dateOptions" ng-required="true"
						close-text="Close" />
				</div>
				<div class="col-lg-2">
					<span class="">
						<button type="button" class="btn btn-default" ng-click="open2()">
							<i class="glyphicon glyphicon-calendar"></i>
						</button>
					</span>
				</div>
			</div>
			<div class="has-error text-danger text-muted col-lg-10 text-center"
				ng-show="signonFormBasic.dateBirth.$dirty">
			</div>
		</div>


		<div class="row">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="height"> <spring:message
						code="param.physicalactivity.signon.from.basic.height" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="number" ng-model="ctrl.signonBasic.height" id="height"
					name="height" class="input-validate form-control input-sm" step="any"
					placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.height" />"
					required min="1" max="2.5"
					ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.height" />
						" />
			</div>
			<div class="has-error text-danger text-muted col-lg-10 text-center"
				ng-show="signonFormBasic.height.$dirty">
				<span ng-show="signonFormBasic.height.$error.minlength"> <spring:message
						code="param.physicalactivity.signon.from.basic.minlength.height" />
				</span>
			</div>
		</div>


		<div class="row">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="weight"> <spring:message
						code="param.physicalactivity.signon.from.basic.weight" />
				</label>
			</div>
			<div class="col-lg-8">
				<input type="number" ng-model="ctrl.signonBasic.weight" id="weight"
					name="weight" class="input-validate form-control input-sm" step="any"
					placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.weight" />"
					required min="10" max="400"
					ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.weight" />
						" />
			</div>

			<div class="has-error text-danger text-muted col-lg-10 text-center"
				ng-show="signonFormBasic.weight.$dirty">
				<span ng-show="signonFormBasic.weight.$error.minlength"> <spring:message
						code="param.physicalactivity.signon.from.basic.minlength.weight" />
				</span>
			</div>
		</div>

		<div class="row">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="universitysede"> <spring:message
						code="param.physicalactivity.signon.from.basic.universitysede" />
				</label>
			</div>
			<div class="col-lg-8">
				<select id="universitysede" name="universitysede"
					class="input-validate form-control"
					ng-init="ctrl.signonBasic.universitysede = ctrl.signonBasic.universitysede || items[0]"
					ng-options="universitySede.id as universitySede.name for universitySede in ctrl.listCampus"
					ng-model="ctrl.signonBasic.universitysede"
					ng-change="loadFacultiesListByCampus()" required>
				</select>
			</div>
			<div class="has-error text-danger text-muted col-lg-10 text-center"
				ng-show="signonFormBasic.universitysede.$dirty">
				<span ng-show="signonFormBasic.universitysede.$error.required">
					<spring:message
						code="param.physicalactivity.signon.from.basic.required.universitysede" />
				</span>
			</div>
		</div>


		<div class="row">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="faculty"> <spring:message
						code="param.physicalactivity.signon.from.basic.faculty" />
				</label>
			</div>
			<div class="col-lg-8">
				<select id="faculty" name="faculty"
					class="input-validate form-control"
					ng-model="ctrl.signonBasic.faculty" required>
					<option ng-repeat="faculty in ctrl.listFaculties"
						value="{{faculty}}">{{faculty.name}}</option>
				</select>
			</div>
			<div class="has-error text-danger text-muted col-lg-10 text-center"
				ng-show="signonFormBasic.faculty.$dirty">
				<span ng-show="signonFormBasic.faculty.$error.required"> <spring:message
						code="param.physicalactivity.signon.from.basic.required.faculty" />
				</span>
			</div>
		</div>


		<div class="row ">
			<div class=" text-muted col-lg-4">
				<label class=" control-lable" for="descriptionHistory"> <spring:message
						code="param.physicalactivity.signon.from.basic.descriptionHistory" />
				</label>
			</div>
			<div class="col-lg-8">
				<textarea ng-model="ctrl.signonBasic.descriptionHistory"
					id="descriptionHistory" name="descriptionHistory"
					class="input-validate form-control input-sm"
					placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.descriptionHistory" />"></textarea>
			</div>
		</div>

		<div class="row">

			<div class="col-lg-12">

				<div class=" text-muted">
					<input type="checkbox" ng-model="ctrl.signonBasic.useCondition"
						id="useCondition" name="useCondition" required /> <label
						class=" text-muted control-lable" for="faculty"> <spring:message
							code="param.physicalactivity.signon.from.basic.useCondition" />
					</label>
					<button type="button" ng-click="ctrl.resetBasic()"
						class=" pull-right  form-actions floatRight btn btn-info  btn-xs "
						ng-disabled="signonFormBasic.$pristine">
						<spring:message code="param.physicalactivity.signon.botton.reset" />
					</button>
				</div>
			</div>
		</div>

		<div class="  form-actions text-center">
			<input type="submit"
				value="{{!ctrl.signonBasic.id ? '<spring:message code="param.physicalactivity.signon.botton.next" />' : '<spring:message code="param.physicalactivity.signon.botton.update" />'}}"
				class="btn btn-warning btn-lg"
				ng-disabled="signonFormBasic.$invalid">
		</div>

		<!-- Change this to a button or input when using this as a form -->
		<!-- 		<a class="btn btn-lg btn-success btn-block" href="index.html">Login</a> -->
	</fieldset>
</form>


</div>
<!-- /.panel-body -->
</div>
<!-- /.panel -->
</div>


</div>
<!-- End Div Panel Custom Field -->
