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
				<i class="fa fa-money fa-fw"></i> <strong
					class="primary-font text-muted ">IMC:</strong> <strong
					class="primary-font">${sessionScope.user.bmi.name}</strong>
			</div>

			<div class="header">
				<i class="fa fa-bolt fa-fw"></i> <strong
					class="primary-font text-muted ">Nivel:</strong> <strong
					class="primary-font">${sessionScope.user.reward.name}</strong>
			</div>
		</div>
		<a href="/physicalactivity/home" class="btn btn btn-info pull-right"><spring:message
				code="param.physicalactivity.description.user.home" /></a>
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

						<div class="text-right">
							<a class="btn btn-outline btn-link"
								href=" https://twitter.com/intent/tweet?text={{event.name}}&url=http:%3A%2F%2Fsam.net.co"
								target="_blank"> <i class="fa fa-twitter fa-fw"></i>
							</a> <a class="btn btn-outline btn-link"
								href="https://www.facebook.com/sharer.php?u=sam.net.co&description={{event.name}}"
								target="_blank"> <i class="fa fa-facebook fa-fw"></i>
							</a>
						</div>

						<div class="header">
							<small class="primary-font">{{event.name}}</small> <small
								class="pull-right text-muted"> <i
								class="fa fa-link fa-fw"></i> {{event.date}}
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



