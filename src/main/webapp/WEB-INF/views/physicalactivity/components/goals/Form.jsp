<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form role="form" ng-submit="ctrl.submit()" name="classifyFormBasic"
	class="form-horizontal col-md-12 list-group">

	<input type="hidden" name="id" value="ctrl.goals.id"
		ng-model="ctrl.goals.id" />


	<div class="panel panel-orange-sports  panel-default-white">
		<div class="panel-heading">
			<spring:message code="param.physicalactivity.goals" />
		</div>

		<ul class="chat" ng-repeat="activities in listSportsCheckedSelect">
			<li class="left clearfix">
				<h3>
					<label> {{activities.name}} </label>
				</h3>
				<div class="col-lg-2 text-muted text-center">
					<h4>
						<label class="radio-inline"> <input type="radio"
							name="{{activities.name}}" ng-model="activities.selected"
							value={{activities.name}}> <strong><spring:message
									code="param.physicalactivity.goals.from.basic.true" /></strong>
						</label> <label class="radio-inline"> <input type="radio"
							ng-model="activities.selected" name="{{activities.name}}"
							value={{activities.name}}> <strong><spring:message
									code="param.physicalactivity.goals.from.basic.false" /></strong>
						</label>
					</h4>
				</div>
				<div class="col-lg-5 panel panel-orange-sports  panel-default-white">
					<div class="panel-heading text-center">
						<spring:message
							code="param.physicalactivity.goals.from.currentactivity" />
					</div>
					<div class="col-lg-12">

						<div class="col-lg-4">
							<span class="input-group-addon"> <spring:message
									code="param.physicalactivity.goals.from.currentactivity.days" />
							</span>
							<p class="text-center">1</p>
						</div>

						<div class="col-lg-4">
							<span class="input-group-addon"> <spring:message
									code="param.physicalactivity.goals.from.currentactivity.minutes" />
							</span>
							<p class="text-center">1</p>
						</div>

						<div class="col-lg-4">
							<span class="input-group-addon"> <spring:message
									code="param.physicalactivity.goals.from.currentactivity.totalweek" />
							</span>
							<p class="text-center">1</p>
						</div>
					</div>
				</div>

				<div class="col-lg-5 panel panel-orange-sports  panel-default-white">
					<div class="panel-heading text-center">
						<spring:message
							code="param.physicalactivity.goals.from.suggestedactivity" />
					</div>
					<div class="col-lg-12">

						<div class="col-lg-4">
							<span class="input-group-addon"> <spring:message
									code="param.physicalactivity.goals.from.suggestedactivity.days" />
							</span>
							<p class="text-center">1</p>
						</div>

						<div class="col-lg-4">
							<span class="input-group-addon"> <spring:message
									code="param.physicalactivity.goals.from.suggestedactivity.minutes" />
							</span>
							<p class="text-center">1</p>
						</div>

						<div class="col-lg-4">
							<span class="input-group-addon"> <spring:message
									code="param.physicalactivity.goals.from.suggestedactivity.totalweek" />
							</span>
							<p class="text-center">1</p>
						</div>
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
