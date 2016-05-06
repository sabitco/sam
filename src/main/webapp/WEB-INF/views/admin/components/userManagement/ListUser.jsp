<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- List Register-->
<div uib-collapse="status.isFirstOpen" class="">
	<h3 class="page-header-titlelist page-header">
		<em class="text-primary"> ${titleTable} <i
			class="pull-right glyphicon"
			ng-class="{'': 
      						status.isFirstOpen, 
      						'glyphicon-remove btn btn-danger btn-circle': 
      						!status.isFirstOpen}"
			ng-click="status.isFirstOpen = !status.isFirstOpen"> </i>
		</em>
	</h3>

	<div class="table-responsive">
		<table class="table table-hover table-striped">
			<thead>
				<tr>
					<th width="20%"></th>
					<th><spring:message code="param.form.custom.user.id" /></th>
					<th><spring:message code="param.form.custom.user.name" /></th>
					<th><spring:message code="param.form.custom.user.state" /></th>
					<th><spring:message
							code="param.form.custom.user.register.date" /></th>
					<th><spring:message code="param.form.custom.user.update.date" /></th>
					<th width="20%"></th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="user in ctrl.users.content">
					<td>
						<button type="button" ng-click="ctrl.editUser(user)"
							class="btn btn-success btn-circle">
							<i class="fa fa-edit" ng-click="status.isFirstOpen = !status.isFirstOpen"></i>
						</button>
					</td>
					<td>{{user.id}}</span></td>
					<td>{{user.dateRegister}}</td>
					<td>{{user.name}}</span></td>
					<td>{{user.state}}</span></td>
					<td>
						<button type="button" ng-click="ctrl.editUser(user)"
							class="btn btn-success btn-circle">
							<i class="fa fa-edit" ng-click="status.isFirstOpen = !status.isFirstOpen"></i>
						</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- /.table-responsive -->
</div>
