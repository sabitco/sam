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
					<th><spring:message code="param.form.custom.page.id" /></th>
					<th><spring:message code="param.form.custom.page.name" /></th>
					<th><spring:message code="param.form.custom.page.title" /></th>
					<th><spring:message
							code="param.form.custom.page.description.page" /></th>
					<th><spring:message code="param.form.custom.page.base" /></th>
					<th><spring:message code="param.form.custom.page.url" /></th>
					<th><spring:message code="param.form.custom.page.icone" /></th>
					<th><spring:message code="param.form.custom.page.name.page" /></th>
					<th><spring:message
							code="param.form.custom.page.name.all.page" /></th>
					<th><spring:message
							code="param.form.custom.page.description.list.recent" /></th>
					<th><spring:message
							code="param.form.custom.page.description.list" /></th>
					<th><spring:message code="param.form.custom.page.type_page_id" /></th>
					<th><spring:message code="param.form.custom.page.state" /></th>
					<th><spring:message code="param.form.custom.page.order.page" /></th>
					<th><spring:message
							code="param.form.custom.page.register.date" /></th>
					<th><spring:message code="param.form.custom.page.update.date" /></th>
					<th width="20%"></th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="page in ctrl.pages.content">
					<td>
						<button type="button" ng-click="ctrl.editPage(page)"
							class="btn btn-success btn-circle">
							<i class="fa fa-edit" ng-click="status.isFirstOpen = !status.isFirstOpen"></i>
						</button>
					</td>
					<td>{{page.id}}</span></td>
					<td>{{page.name}}</td>
					<td>{{page.title}}</span></td>
					<td>{{page.descriptionPage}}</span></td>
					<td>{{page.base}}</span></td>
					<td>{{page.url}}</span></td>
					<td>{{page.icone}}</span></td>
					<td>{{page.namePage}}</span></td>
					<td>{{page.namePageAll}}</span></td>
					<td>{{page.descriptionListRecent}}</span></td>
					<td>{{page.descriptionList}}</span></td>
					<td>{{page.typePage}}</span></td>
					<td>{{page.state}}</span></td>
					<td>{{page.orderPage}}</span></td>
					<td>{{page.dateRegister | date:'dd/MM/yyyy'}}</span></td>
					<td>{{page.dateUpdate | date:'dd/MM/yyyy'}}</span></td>
					<td>
						<button type="button" ng-click="ctrl.editPage(page)"
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
