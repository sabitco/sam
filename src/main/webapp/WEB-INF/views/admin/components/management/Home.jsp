<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="panel-body formcontainer" ng-repeat="page in ctrl.pages.content">
	<div class="col-lg-3 col-md-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-3">
						<i class=" fa {{page.icone}} fa-5x"></i>
					</div>
					<div class="col-xs-9 text-right"></div>
				</div>
			</div>
			<a href="{{page.url}}">
				<div class="panel-footer">
					<span class="pull-left">{{page.name}}</span> <span
						class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
					<div class="clearfix"></div>
				</div>
			</a>
		</div>
	</div>
</div>
<!-- End Div Panel Custom Field -->
