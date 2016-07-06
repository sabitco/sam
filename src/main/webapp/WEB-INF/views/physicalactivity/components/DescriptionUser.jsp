<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- List Register-->
<div class="menu-superior">
	<div class="panel panel-default panel-default-white">
		<div class="row text-center logo-sam ">
			<img src="/static//dist/physicalactivity/images/ocono1.png"
				alt="logo">
		</div>
		<div class="panel-body">
			<a href="/physicalactivity/classification"
				class="btn btn btn-info pull-left"><spring:message
					code="param.physicalactivity.description.user.reclassify" /></a>

			<button class="btn btn btn-info pull-right" type="submit">
				<spring:message code="param.physicalactivity.description.user.edit" />
			</button>


		</div>
		<div class="panel-body">
			 
			<div class="header">
				<i class="fa fa-money fa-fw"></i>
				<strong class="primary-font text-muted ">Nivel:</strong>
				<strong class="primary-font">${sessionScope.user.bmi.name}</strong>
			</div>
			
			<div class="header">
				<i class="fa fa-bolt fa-fw"></i>
				<strong class="primary-font text-muted ">BMI:</strong>
				<strong class="primary-font">${sessionScope.user.reward.name}</strong>
			</div>
		</div>



	</div>

	<div class="panel panel-orange panel-default-white"
		ng-controller="RightController as ctrlDescription" ng-init="getInit()">
		<div class="panel-heading">
			<spring:message
				code="param.physicalactivity.description.user.alternative.activities" />
		</div>

		<div class="panel-body">
			<ul class="chat">

				<li class="left clearfix"
					ng-repeat="event in ctrlDescription.listEvents">
					<div class="clearfix">
						<div class="header">
							<strong class="primary-font">{{event.name}}</strong> <small
								class="pull-right text-muted"> <i
								class="fa fa-clock-o fa-fw"></i> {{event.date}}
							</small>
						</div>
						<p>
							<!-- //TODO: AGREGAR DESCRIPCION -->
						</p>
					</div>
				</li>
			</ul>
		</div>
	</div>

</div>
