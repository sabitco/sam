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

			<button class="btn btn btn-info pull-left" type="submit">
				<spring:message
					code="param.physicalactivity.description.user.reclassify" />
			</button>
			<button class="btn btn btn-info pull-right" type="submit">
				<spring:message code="param.physicalactivity.description.user.edit" />
			</button>
		</div>

	</div>

	<div class="panel panel-orange panel-default-white">
		<div class="panel-heading">
			<spring:message
				code="param.physicalactivity.description.user.alternative.activities" />
		</div>

		<div class="panel-body">
			<ul class="chat">
				<li class="left clearfix">
					<div class="clearfix">
						<div class="header">
							<strong class="primary-font">Jack Sparrow</strong> <small
								class="pull-right text-muted"> <i
								class="fa fa-clock-o fa-fw"></i> 12 mins ago
							</small>
						</div>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.
						</p>
					</div>
				</li>

				<li class="left clearfix">
					<div class="clearfix">
						<div class="header">
							<strong class="primary-font">Jack Sparrow</strong> <small
								class="pull-right text-muted"> <i
								class="fa fa-clock-o fa-fw"></i> 14 mins ago
							</small>
						</div>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.
						</p>
					</div>
				</li>

				<li class="left clearfix">
					<div class="clearfix">
						<div class="header">
							<strong class="primary-font">Jack Sparrow</strong> <small
								class="pull-right text-muted"> <i
								class="fa fa-clock-o fa-fw"></i> 14 mins ago
							</small>
						</div>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales.
						</p>
					</div>
				</li>
			</ul>
		</div>
	</div>

</div>
