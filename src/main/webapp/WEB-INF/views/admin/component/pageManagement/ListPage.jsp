<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

						<!-- List Register-->
<em>
	<h3 class="page-header-titlelist page-header">
		Listado de Pages
		<span class="pull-right">
			<i class="pull-right glyphicon" 
      			ng-class="{'': 
      						status.isFirstOpen, 
      						'glyphicon-remove btn btn-danger btn-circle': 
      						!status.isFirstOpen}"
      			ng-click="status.isFirstOpen = !status.isFirstOpen" 			
      					>
      			</i>
		</span>
	</h3>
</em>

<div class="table-responsive">
	<table class="table table-hover table-striped">
		<thead>
			<tr>
				<th>name</th>
				<th>${registerDateCustomForm}</th>
				<th>${nameCustomForm}</th>
				<th>${stateCustomForm}</th>
				<th>${orderCustomForm}</th>
				<th>${typePageCustomForm}</th>
				<th>${urlCustomForm}</th>
				<th>${basePageCustomForm}</th>
				<th>${listPageCustomForm}</th>
				<th>${descriptionPageCustomForm}</th>
				<th>${IconePageCustomForm}</th>                                
				<th>${namePageCustomForm}</th>
				<th>${tituloPageCustomForm}</th>
				<th width="20%"></th>
			</tr>	
		</thead>
		<tbody>
			<tr ng-repeat="page in ctrl.pages">
				<td>{{page.id}}</span></td>
				<td>{{page.dateRegister}}</td>
				<td>{{page.name}}</span></td>
				<td>{{page.state}}</span></td>
				<td>{{page.orderPage}}</span></td>
				<td>{{page.typePage}}</span></td>
				<td>{{page.url}}</span></td>
				<td>{{page.base}}</span></td>
				<td>{{page.descriptionList}}</span></td>
				<td>{{page.descriptionPage}}</span></td>
				<td>{{page.icone}}</span></td>
				<td>{{page.namePage}}</span></td>
				<td>{{page.title}}</span></td>
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
