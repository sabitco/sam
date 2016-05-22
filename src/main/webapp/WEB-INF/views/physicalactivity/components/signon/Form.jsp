<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>





<div class="panel-body formcontainer">

	<h1 class="page-header-titlelist page-header">
		<em class="text-primary"> ${name} </em>
	</h1>

	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<spring:message code="param.physicalactivity.signon.from.basic" />
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">


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
								<input type="text" ng-model="ctrl.signonBasic.lastname"
									id="lastname" name="lastname"
									class="input-validate form-control input-sm"
									placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.lastname" />"
									required
									ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.lastname" />
						" />
								<div class="has-error" ng-show="signonFormBasic.lastname.$dirty">
									<span ng-show="signonFormBasic.lastname.$error.minlength">
										<spring:message
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
								<input type="number" ng-model="ctrl.signonBasic.document"
									id="document" name="document"
									class="input-validate form-control input-sm"
									placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.document" />"
									required min="999999"
									ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.document" />
						" />
								<div class="has-error" ng-show="signonFormBasic.document.$dirty">
									<span ng-show="signonFormBasic.document.$error.minlength">
										<spring:message
											code="param.physicalactivity.signon.from.basic.minlength.document" />
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="email"> <spring:message
									code="param.physicalactivity.signon.from.basic.email" />
							</label>
							<div class="col-md-7">
								<input type="email" ng-model="ctrl.signonBasic.email" id="email"
									name="email" class="input-validate form-control input-sm"
									placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.email" />"
									required
									ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.email" />
						" />
								<div class="has-error" ng-show="signonFormBasic.email.$dirty">
									<span ng-show="signonFormBasic.email.$error.minlength">
										<spring:message
											code="param.physicalactivity.signon.from.basic.minlength.email" />
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="age"> <spring:message
									code="param.physicalactivity.signon.from.basic.age" />
							</label>
							<div class="col-md-7">
								<input type="number" ng-model="ctrl.signonBasic.age"
									id="document" name="document"
									class="input-validate form-control input-sm"
									placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.age" />"
									required min="10" max="100"
									ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.age" />
						" />
								<div class="has-error" ng-show="signonFormBasic.age.$dirty">
									<span ng-show="signonFormBasic.age.$error.minlength"> <spring:message
											code="param.physicalactivity.signon.from.basic.minlength.age" />
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="height"> <spring:message
									code="param.physicalactivity.signon.from.basic.height" />
							</label>
							<div class="col-md-7">
								<input type="number" ng-model="ctrl.signonBasic.height"
									id="height" name="height"
									class="input-validate form-control input-sm"
									placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.height" />"
									required min="1" max="2.5"
									ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.height" />
						" />
								<div class="has-error" ng-show="signonFormBasic.height.$dirty">
									<span ng-show="signonFormBasic.height.$error.minlength">
										<spring:message
											code="param.physicalactivity.signon.from.basic.minlength.height" />
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="weight"> <spring:message
									code="param.physicalactivity.signon.from.basic.weight" />
							</label>
							<div class="col-md-7">
								<input type="number" ng-model="ctrl.signonBasic.weight"
									id="weight" name="weight"
									class="input-validate form-control input-sm"
									placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.weight" />"
									required min="10" max="400"
									ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.weight" />
						" />
								<div class="has-error" ng-show="signonFormBasic.weight.$dirty">
									<span ng-show="signonFormBasic.weight.$error.minlength">
										<spring:message
											code="param.physicalactivity.signon.from.basic.minlength.weight" />
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="universitysede">
								<spring:message
									code="param.physicalactivity.signon.from.basic.universitysede" />
							</label>
							<div class="col-md-7">
								<select id="universitysede" name="universitysede"
									class="input-validate form-control"
									ng-init="ctrl.signonBasic.universitysede = ctrl.signonBasic.universitysede || items[0]"
									ng-options="universitySede.id as universitySede.name for universitySede in ctrl.listCampus"
									ng-model="ctrl.signonBasic.universitysede" ng-change="show()"
									required>
								</select>
								<div class="has-error" ng-show="pageForm.state.$dirty">
									<span ng-show="pageForm.state.$error.required"> <spring:message
											code="param.physicalactivity.signon.from.basic.required.universitysede" />
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
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>


</div>
<!-- End Div Panel Custom Field -->
