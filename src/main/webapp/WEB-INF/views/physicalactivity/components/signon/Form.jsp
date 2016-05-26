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
							<label class="col-md-2 control-lable" for="username"> <spring:message
									code="param.physicalactivity.signon.from.basic.username" />
							</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.signonBasic.username"
									id="username" name="username"
									class="input-validate form-control input-sm"
									placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.username" />"
									required
									ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.username" />
						" />
								<div class="has-error" ng-show="signonFormBasic.username.$dirty">
									<span ng-show="signonFormBasic.username.$error.minlength">
										<spring:message
											code="param.physicalactivity.signon.from.basic.minlength.username" />
									</span>
								</div>
							</div>
						</div>
					</div>

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
							<label class="col-md-2 control-lable" for="surname"> <spring:message
									code="param.physicalactivity.signon.from.basic.lastname" />
							</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.signonBasic.surname"
									id="surname" name="surname"
									class="input-validate form-control input-sm"
									placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.lastname" />"
									required
									ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.lastname" />
						" />
								<div class="has-error" ng-show="signonFormBasic.surname.$dirty">
									<span ng-show="signonFormBasic.surname.$error.minlength">
										<spring:message
											code="param.physicalactivity.signon.from.basic.minlength.lastname" />
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="password"> <spring:message
									code="param.physicalactivity.signon.from.basic.password" />
							</label>
							<div class="col-md-7">
								<input type="password" ng-model="ctrl.signonBasic.password"
									id="password" name="password"
									class="input-validate form-control input-sm"
									placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.password" />"
									required
									ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.password" />
						" />
								<div class="has-error" ng-show="signonFormBasic.password.$dirty">
									<span ng-show="signonFormBasic.password.$error.minlength">
										<spring:message
											code="param.physicalactivity.signon.from.basic.minlength.password" />
									</span>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="password"> <spring:message
									code="param.physicalactivity.signon.from.basic.confirmpassword" />
							</label>
							<div class="col-md-7">
								<input type="password" ng-model="ctrl.signonBasic.confirmpassword"
									id="confirmpassword" name="confirmpassword"
									class="input-validate form-control input-sm"
									placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.confirmpassword" />"
									required
									pw-check="confirmpassword"
									ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.confirmpassword" />
						" />
								<div class="has-error" ng-show="signonFormBasic.password.$dirty">
									<span ng-show="signonFormBasic.password.$error.minlength">
										<spring:message
											code="param.physicalactivity.signon.from.basic.invalid.confirmpassword" />
									</span>
									<span ng-show="signonFormBasic.password.$error.pwmatch">
										<spring:message
											code="param.physicalactivity.signon.from.basic.invalid.confirmpassword.compare" />
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="identityDocument"> <spring:message
									code="param.physicalactivity.signon.from.basic.document" />
							</label>
							<div class="col-md-7">
								<input type="number" ng-model="ctrl.signonBasic.identityDocument"
									id="identityDocument" name="identityDocument"
									class="input-validate form-control input-sm"
									placeholder="<spring:message
						code="param.physicalactivity.signon.from.basic.required.document" />"
									required min="999999"
									ng-minlength="
							<spring:message code="param.physicalactivity.signon.from.basic.quantity.minlength.document" />
						" />
								<div class="has-error" ng-show="signonFormBasic.identityDocument.$dirty">
									<span ng-show="signonFormBasic.identityDocument.$error.minlength">
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
									</span> <span ng-show="signonFormBasic.email.$error.email"> <spring:message
											code="param.physicalactivity.signon.from.basic.invalid.email" />
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
									ng-model="ctrl.signonBasic.universitysede"
									ng-change="loadFacultiesListByCampus()" required>
								</select>
								<div class="has-error"
									ng-show="signonFormBasic.universitysede.$dirty">
									<span ng-show="signonFormBasic.universitysede.$error.required">
										<spring:message
											code="param.physicalactivity.signon.from.basic.required.universitysede" />
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="faculty"> <spring:message
									code="param.physicalactivity.signon.from.basic.faculty" />
							</label>
							<div class="col-md-7">
								<select id="faculty" name="faculty"
									class="input-validate form-control"
									ng-init="ctrl.signonBasic.faculty = ctrl.signonBasic.faculty || items[0]"
									ng-options="faculty.id as faculty.name for faculty in ctrl.listFaculties"
									ng-model="ctrl.signonBasic.faculty" required>
								</select>
								<div class="has-error" ng-show="signonFormBasic.faculty.$dirty">
									<span ng-show="signonFormBasic.faculty.$error.required">
										<spring:message
											code="param.physicalactivity.signon.from.basic.required.faculty" />
									</span>
								</div>
							</div>
						</div>
					</div>

					<br />

					<div class="pull-right  form-actions floatRight">
						<input type="submit"
							value="{{!ctrl.signonBasic.id ? '<spring:message code="param.physicalactivity.signon.botton.next" />' : '<spring:message code="param.physicalactivity.signon.botton.update" />'}}"
							class="btn btn-success btn-sm"
							ng-disabled="signonFormBasic.$invalid">

						<button type="button" ng-click="ctrl.resetBasic()"
							class="btn btn-warning btn-sm"
							ng-disabled="signonFormBasic.$pristine">
							<spring:message code="param.physicalactivity.signon.botton.reset" />

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