<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<input type="hidden" name="id" value="ctrl.goals.id"
	ng-model="ctrl.goals.id" />

<div class="col-lg-7 text-muted text-center">

	<div class="panel panel-orange-sports  panel-default-white">
		<div class="panel-heading">
			<spring:message code="param.physicalactivity.tip" />
		</div>

		<ul class="chat" ng-repeat="goals in listGoalsSelect">
			<li class="left clearfix">
				<h3>
					<label> {{goals.name}} </label>
				</h3>
			</li>
		</ul>
	</div>

	<div class="panel panel-orange-sports  panel-default-white">
		<div class="panel-heading">
			<spring:message code="param.physicalactivity.advantage" />
		</div>

		<ul class="chat" ng-repeat="goals in listGoalsSelect">
			<li class="left clearfix">
				<h3>
					<label> {{goals.name}} </label>
				</h3>
			</li>
		</ul>
	</div>

	<div class="panel panel-orange-sports  panel-default-white">
		<div class="panel-heading">
			<spring:message code="param.physicalactivity.alert" />
		</div>

		<ul class="chat" ng-repeat="goals in listGoalsSelect">
			<li class="left clearfix">
				<h3>
					<label> {{goals.name}} </label>
				</h3>
			</li>
		</ul>
	</div>

	<div class="panel panel-orange-sports  panel-default-white">
		<div class="panel-heading">
			<spring:message code="param.physicalactivity.myth" />
		</div>

		<ul class="chat" ng-repeat="goals in listGoalsSelect">
			<li class="left clearfix">
				<h3>
					<label> {{goals.name}} </label>
				</h3>
			</li>
		</ul>
	</div>

</div>

<div class="col-lg-5 text-muted text-center">
	<fieldset class="text-muted menu-superior text-center">
		<div donut-chart="" donut-data="ctrl.chartData"
			donut-colors="ctrl.chartColors" donut-formatter="ctrl.myFormatter"></div>

		<div class=" text-center text-muted  control-lable ">
			<spring:message code="param.physicalactivity.classify.morris.title" />
		</div>
	</fieldset>


	<fieldset class="col-md-12"
		ng-repeat="goals in ctrl.listGoals">

		
		<div donut-chart="" donut-data="goals.activity"
			donut-colors="ctrl.chartColors" donut-formatter="ctrl.myFormatter"></div>

		<h4 class=" text-center text-muted  control-lable ">Min
			Semanales:{{goals.totalsemanaminutes}}</h4>
		<h4 class=" text-center text-muted  control-lable ">Min
			Mesuales:{{goals.totalmesminutes}}</h4>
	</fieldset>
</div>

<!-- End Div Panel Custom Field -->
