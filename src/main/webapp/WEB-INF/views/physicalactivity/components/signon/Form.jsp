<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>





<div class="panel-body formcontainer" >

	<h3 class="page-header-titlelist page-header">
		<em class="text-primary"> <spring:message
				code="param.component.form" />
		</em>
	</h3>

	<form ng-submit="ctrl.submit()" name="pageForm" class="form-horizontal">

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-2 control-lable" for="id"> <spring:message
						code="param.form.custom.page.id" />
				</label>
				<div class="col-md-7">
					<input type="text" ng-model="ctrl.page.id" id="id"
						class="name form-control input-sm" ng-disabled="true" />
				</div>
			</div>
		</div>


		<div class="pull-right  form-actions floatRight">
			<input type="submit" value="{{!ctrl.page.id ? 'Add' : 'Update'}}"
				class="btn btn-success btn-sm" ng-disabled="pageForm.$invalid">

			<button type="button" ng-click="ctrl.reset()"
				class="btn btn-warning btn-sm" ng-disabled="pageForm.$pristine">
				<spring:message code="param.botton.form.recent" />
				Form
			</button>
		</div>
	</form>
</div>
<!-- End Div Panel Custom Field -->
