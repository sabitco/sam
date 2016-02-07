<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:template>
	<jsp:attribute name="title">Admin de Usuarios</jsp:attribute>
	<jsp:body>
		<div ng-controller="UserController as ctrl">
			<form ng-submit="ctrl.submit()" name="userForm">
				<fieldset>
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
						<label for="email">Mail</label>
						<input type="email" id="email" name="email" ng-model="ctrl.user.email" placeholder="Email" required />
						<span style="color: red" ng-show="userForm.email.$dirty && userForm.email.$invalid">
							<span ng-show="userForm.email.$error.required">Email is required.</span>
						</span>
					</p>
					<p>
						<label for="dateBirth">Date of birth</label>
						<input type="date" id="dateBirth" name="dateBirth" ng-model="ctrl.user.dateBirth" placeholder="Date of birth" required />
						<span style="color: red" ng-show="userForm.birthdate.$dirty && userForm.dateBirth.$invalid">
							<span ng-show="userForm.dateBirth.$error.required">Birthdate is required.</span>
						</span>
					</p>
					<input type="submit" value="{{!ctrl.user.id ? 'Add' : 'Update'}}" ng-disabled="userForm.$invalid">
					<button type="button" ng-click="ctrl.reset()" ng-disabled="userForm.$pristine">Reset Form</button>
				</fieldset>
			</form>
			<table ng-show="ctrl.users.length > 0">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Username</th>
						<th>Email</th>
						<th>Date of birth</th>
						<th>State</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="user in ctrl.users">
						<td>{{user.id}}</td>
						<td>{{user.name}}</td>
						<td>{{user.username}}</td>
						<td>{{user.email}}</td>
						<td>{{user.dateBirth}}</td>
						<td>{{user.state}}</td>
						<td>
					        <a  href="#" ng-click="ctrl.editUser(user)">Edit</a> | 
					        <a href="#" ng-click="ctrl.deleteUser(user.id)">Delete</a>
					    </td>
					</tr>
				</tbody>
			</table>
      	</div>
      	<script src="<c:url value='/static/js/physicalactivity/service/user_service.js' />"></script>
 		<script src="<c:url value='/static/js/physicalactivity/controller/user_controller.js' />"></script>
    </jsp:body>
</t:template>