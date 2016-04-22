<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div ng-if="!status.isFirstOpen" class="table table-hover table-striped">
	<h4 class="row">
		<em class="text-primary"> <spring:message
				code="param.component.form" />
		</em> <i class="pull-right glyphicon"
			ng-class="{'glyphicon-resize-small btn btn-danger btn-circle': 
					        						status.isFirstOpen, 
					        						'glyphicon-resize-full btn btn-info btn-circle': 
					        						!status.isFirstOpen}"
			ng-click="status.isFirstOpen = !status.isFirstOpen"> </i>
	</h4>
</div>

<div class="col-sm-12 table-responsive panel-body formcontainer" uib-collapse="!status.isFirstOpen">

		<h3 class="page-header-titlelist page-header">
			<em class="text-danger"> ${nameListRecentPage}</em>
		</h3>

		<table class="table">
			<thead>
				<tr>
					<th><spring:message code="param.form.custom.page.name" /></th>
					<th width="20%"></th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="page in ctrl.pages">
					<td>{{page.name}}</span></td>
					<td>
						<button type="button" ng-click="ctrl.editPage(page)"
							class="btn btn-info btn-circle">
							<i class="fa fa-edit"></i>
						</button>
					</td>
				</tr>
			</tbody>
		</table>
	<!-- /.table-responsive -->
</div>
<div class="pull-right" uib-collapse="!status.isFirstOpen">
	<a href="" ng-click="status.isFirstOpen = !status.isFirstOpen"
		class=" next ng-binding"> ${nameAllPageAdministrator} </a>
</div>