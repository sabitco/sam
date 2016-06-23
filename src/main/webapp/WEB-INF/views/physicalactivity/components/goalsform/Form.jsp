<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form role="form" ng-submit="ctrl.submit()" name="goalsFormBasic"
	class="form-horizontal col-md-12 list-group">

	<input type="hidden" name="id" value="ctrl.goals.id"
		ng-model="ctrl.goals.id" />


	<div class="panel panel-orange-sports  panel-default-white">
		<div class="panel-heading">
			<spring:message code="param.physicalactivity.goalsform" />
		</div>

		<ul class="chat">
			<li class="left clearfix">
				<h3>
					<label><spring:message
							code="param.physicalactivity.goalsform.message" /></label>
				</h3>
				<div class="col-lg-2 text-muted text-center">
					<h4>
						<select id="universitysede" name="universitysede"
							class="input-validate form-control"
							ng-init="ctrl.signonBasic.universitysede = ctrl.signonBasic.universitysede || items[0]"
							ng-options="goals.activity.id as goals.activity.name for goals in listGoalsSelect"
							ng-model="ctrl.signonBasic.universitysede"
							ng-change="loadFacultiesListByCampus()" required>
						</select>
					</h4>
				</div>

				<div class="col-lg-5">
					<span class="input-group-addon"> <spring:message
							code="param.physicalactivity.classifydetail.from.basic.suffix.frequency" />
					</span> <input type="number" ng-model="activities.days" id="height"
						name="height" class="input-validate form-control input-sm"
						step="any"
						placeholder="<spring:message
						code="param.physicalactivity.classifydetail.from.basic.required.frequency" />"
						required min="1" max="7"
						ng-minlength="
							<spring:message code="param.physicalactivity.classifydetail.from.basic.quantity.minlength.frequency" />
						"
						string-to-number />
					<div class="has-error text-danger text-muted col-lg-12 text-center"
						ng-show="classifyFormBasic.height.$dirty">
						<span ng-show="classifyFormBasic.height.$error.minlength">
							<spring:message
								code="param.physicalactivity.classifydetail.from.basic.minlength.frequency" />
						</span>
					</div>
				</div>

				<div class="col-lg-5">

					<span class="input-group-addon"> <spring:message
							code="param.physicalactivity.classifydetail.from.basic.suffix.duration" />
					</span> <input type="number" ng-model="activities.minutes" id="height"
						name="height" class="input-validate form-control input-sm"
						step="any"
						placeholder="<spring:message
						code="param.physicalactivity.classifydetail.from.basic.required.duration" />"
						required min="1" max="1440"
						ng-minlength="
							<spring:message code="param.physicalactivity.classifydetail.from.basic.quantity.minlength.duration" />
						" />

					<div class="has-error text-danger text-muted col-lg-12 text-center"
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
