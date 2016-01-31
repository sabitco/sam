<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:template>
	<jsp:attribute name="title">Admin de Usuarios</jsp:attribute>
	<jsp:body>
		<div ng-controller="UserController as ctrl">
			<form ng-submit="ctrl.submit()" name="userForm">
				<p>
					<label for="name">Name</label>
					<input type="text" id="name" name="name" ng-model="ctrl.user.name" placeholder="Name" required />
					<span style="color: red" ng-show="userForm.name.$dirty && userForm.name.$invalid">
						<span ng-show="userForm.name.$error.required">Name is required.</span>
					</span>
				</p>
				<p>
					<label for="username">Username</label>
					<input type="text" id="username" name="username" ng-model="ctrl.user.username" placeholder="Username" required />
					<span style="color: red" ng-show="userForm.username.$dirty && userForm.username.$invalid">
						<span ng-show="userForm.username.$error.required">Username is required.</span>
					</span>
				</p>
				<p>
					<label for="birthdate">Birthdate</label>
					<input type="date" id="birthdate" name="birthdate" ng-model="ctrl.user.birthdate" placeholder="Birthdate" required />
					<span style="color: red" ng-show="userForm.birthdate.$dirty && userForm.birthdate.$invalid">
						<span ng-show="userForm.birthdate.$error.required">Birthdate is required.</span>
					</span>
				</p>
				<input type="submit" value="{{!ctrl.user.id ? 'Add' : 'Update'}}" ng-disabled="userForm.$invalid">
				<button type="button" ng-click="ctrl.reset()" ng-disabled="userForm.$pristine">Reset Form</button>
			</form>
			<table>
				<thead>
					<tr>
						<th>Name</th>
						<th>Username</th>
						<th>Birthdate</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="user in ctrl.users">
						<td>{{user.name}}</td>
						<td>{{user.username}}</td>
						<td>{{user.birthdate}}</td>
					</tr>
				</tbody>
			</table>
      	</div>
      	<script src="<c:url value='/static/js/physicalactivity/service/user_service.js' />"></script>
 		<script src="<c:url value='/static/js/physicalactivity/controller/user_controller.js' />"></script>
    </jsp:body>
</t:template>