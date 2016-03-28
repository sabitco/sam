<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="table-responsive">
	<table class="table table-hover table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>${nameCustomForm}</th>
				<th width="20%"></th>
			</tr>	
		</thead>
		<tbody>
			<tr ng-repeat="page in ctrl.pages">
				<td>{{page.id}}</span></td>
				<td>{{page.name}}</span></td>
				<td>
					<button type="button"
						ng-click="ctrl.editPage(page)"
						class="btn btn-success custom-width">
							Edit	
					</button>

					<button type="button"
						ng-click="ctrl.deletePage(page.id)"
						class="btn btn-danger custom-width">
							Remove
					</button>
				</td>
     		</tr>
		</tbody>
	</table>
</div>
<!-- /.table-responsive -->

