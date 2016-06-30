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

		<ul class="chat" ng-repeat="goals in listGoalsSelect">
			<li class="left clearfix">

				<div class="col-lg-2 text-center">
					<h3>
						<label> {{goals.activity.name}} </label>
					</h3>
				</div>

				<div class="col-lg-5">
					<span class="input-group-addon"> <spring:message
							code="param.physicalactivity.goals.from.basic.suffix.frequency" />
					</span> <input type="number" ng-model="goals.days" id="days"
						name="days" class="input-validate form-control input-sm"
						step="any"
						placeholder="<spring:message
						code="param.physicalactivity.goals.from.basic.required.frequency" />"
						required min="1" max="7"
						ng-minlength="
							<spring:message code="param.physicalactivity.goals.from.basic.quantity.minlength.frequency" />
						"
						string-to-number />
					<div class="has-error text-danger text-muted col-lg-12 text-center"
						ng-show="goalsFormBasic.days.$dirty">
						<span ng-show="goalsFormBasic.days.$error.minlength">
							<spring:message
								code="param.physicalactivity.goals.from.basic.minlength.frequency" />
						</span>
					</div>
				</div>

				<div class="col-lg-5">

					<span class="input-group-addon"> <spring:message
							code="param.physicalactivity.goals.from.basic.suffix.duration" />
					</span> <input type="number" ng-model="activities.minutes" id="duration"
						name=duration class="input-validate form-control input-sm"
						step="any"
						placeholder="<spring:message
						code="param.physicalactivity.goals.from.basic.required.duration" />"
						required min="1" max="1440"
						ng-minlength="
							<spring:message code="param.physicalactivity.goals.from.basic.quantity.minlength.duration" />
						" />

					<div class="has-error text-danger text-muted col-lg-12 text-center"
						ng-show="goalsFormBasic.duration.$dirty">
						<span ng-show="goalsFormBasic.duration.$error.minlength">
							<spring:message
								code="param.physicalactivity.goals.from.basic.minlength.duration" />
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
				ng-disabled="goalsFormBasic.$invalid">
		</div>
	</fieldset>
</form>


<!-- End Div Panel Custom Field -->
