<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="co.edu.unal.sam.aspect.properties.ReadFromPropertiesFile"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="title" scope="session"
     value="${ReadFromPropertiesFile.getProperties('param.administrador.title')}" />
     
<c:set var="req" value="${pageContext.request}" />
<c:set var="url" value="${req.requestURL}" />
<c:set var="uri" value="${req.requestURI}" />
  
<c:set var="titleAdministrado" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('param.administrador.title.name')}" />
       
<c:set var="logout" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('param.administrador.option.logout')}" />

<c:set var="userLogger" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('param.administrador.userlogger.name')}" />  
     
<c:set var="descritionoptionone" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('param.administrador.menu.option.one.description')}" />   

<c:set var="iconoptionone" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('param.administrador.menu.option.one.icon')}" />
     
<c:set var="linkoptionone" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('param.administrador.menu.option.one.link')}" /> 
     
<c:set var="footer" scope="session"
     value="${ReadFromPropertiesFile.getProperties('param.administrador.footer.description')}" />   

<c:set var="titlepage" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('param.administrador.user.title')}" />
               
<c:set var="descriptionpage" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('param.administrador.user.description.page')}" />

<c:set var="descriptionpage" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('param.administrador.user.description.list')}" />
<t:admintemplate>
     <jsp:attribute name="title">${titlepage}</jsp:attribute>
     <jsp:body>
 
    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation"
                    style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                              data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <span class="navbar-brand"> ${ titleAdministrado } </span>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    
                </li>

                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li>
                        	<a href="#">
                        		<i class="btn-danger btn-circle fa fa-user fa-fw"></i>  
                        		${userLogger} 
                        	</a>
                        </li>
                        <li class="divider"></li>
                       	<li>
                        	<a href="login.html">
                        		<i class="fa fa-sign-out fa-fw"></i> 
                        		${logout} 
                       		</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>

                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                              <a href="${linkoptionone}"><i class="fa  ${iconoptionone} fa-fw"></i> ${descritionoptionone} </a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <!-- /.row -->
            <div class=" row page-header">    
                   
               <div class="generic-container" ng-controller="UserController as ctrl">
          <div class="panel panel-default">
               <div class="alert alert-info">
                    <h1 class=" timeline-title">
                        ${descriptionpage}
                    </h1>
               </div>
               <div class="formcontainer">

                    <form ng-submit="ctrl.submit()" name="userForm" class="form-horizontal">

                         <input type="hidden" ng-model="ctrl.user.id" />

                         <div class="row">
                              <div class="form-group col-md-12">
                                   <label class="col-md-2 control-lable" for="name">Name</label>
                                   <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.user.name" id="name"
                                                                 class="name form-control input-sm"
                                                                 placeholder="Enter your name"
                                                                 required ng-minlength="4" />
                                        <div class="has-error" ng-show="userForm.name.$dirty">
                                             <span ng-show="userForm.name.$error.required">This is a
                                                  required field</span> <span
                                                                      ng-show="userForm.name.$error.minlength">Minimum
                                                  length required is 4</span> <span
                                                                      ng-show="userForm.name.$invalid">This
                                                  field is invalid </span>

                                        </div>
                                   </div>
                              </div>
                         </div>

                         <div class="row">
                              <div class="form-group col-md-12">
                                   <label class="col-md-2 control-lable" for="username">Username</label>
                                   <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.user.username"
                                                                 id="username"
                                                                 class="username form-control input-sm"
                                                                 placeholder="Enter your username"
                                                                 required ng-minlength="4" />
                                        <div class="has-error" ng-show="userForm.username.$dirty">
                                             <span ng-show="userForm.username.$error.required">This
                                                  is a required field</span> <span
                                                                      ng-show="userForm.username.$error.minlength">Minimum
                                                  length required is 4</span> <span
                                                                      ng-show="userForm.username.$invalid">This field is
                                                  invalid </span>

                                        </div>
                                   </div>
                              </div>
                         </div>

                         <div class="row">
                              <div class="form-group col-md-12">
                                   <label class="col-md-2 control-lable" for="email">Mail</label>
                                   <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.user.email" id="email"
                                                                 class="email form-control input-sm"
                                                                 placeholder="Enter your email"
                                                                 required ng-minlength="4" />
                                        <div class="has-error" ng-show="userForm.email.$dirty">
                                             <span ng-show="userForm.email.$error.required">This is a
                                                  required field</span> <span
                                                                      ng-show="userForm.email.$error.minlength">Minimum
                                                  length required is 4</span> <span
                                                                      ng-show="userForm.email.$invalid">This
                                                  field is invalid </span>
                                        </div>
                                   </div>
                              </div>
                         </div>

                         <div class="row">
                              <div class="form-group col-md-12">
                                   <label class="col-md-2 control-lable" for="dateBirth">Date
                                        of birth</label>
                                   <div class="col-md-7">
                                        <input type="date" ng-model="ctrl.user.dateBirth"
                                                                 id="dateBirth"
                                                                 class="dateBirth form-control input-sm"
                                                                 placeholder="Enter your dateBirth"
                                                                 required ng-minlength="4" />
                                        <div class="has-error" ng-show="userForm.dateBirth.$dirty">
                                             <span ng-show="userForm.dateBirth.$error.required">This
                                                  is a required field</span> <span
                                                                      ng-show="userForm.dateBirth.$error.minlength">Minimum
                                                  length required is 4</span> <span
                                                                      ng-show="userForm.dateBirth.$invalid">This field is
                                                  invalid </span>
                                        </div>
                                   </div>
                              </div>
                         </div>

                         <div class="row">
                              <div class="form-actions floatRight">
                                   <input type="submit" value="{{!ctrl.user.id ? 'Add' : 'Update'}}"
                                                            class="btn btn-primary btn-sm"
                                                            ng-disabled="userForm.$invalid">

                                   <button type="button" ng-click="ctrl.reset()"
                                                            class="btn btn-warning btn-sm"
                                                            ng-disabled="userForm.$pristine">Reset
                                        Form</button>
                              </div>
                         </div>
                    </form>
               </div>
          </div>
          <div class="panel panel-default">
               <!-- Default panel contents -->
               <div class="panel-heading">
                    <span class="lead">List of Users </span>
               </div>
               <div class="tablecontainer">
                    <table ng-show="ctrl.users.length > 0">
                         <thead>
                              <tr>
                                   <th>Id</th>
                                   <th>Name</th>
                                   <th>Username</th>
                                   <th>Email</th>
                                   <th>Date of birth</th>
                                   <th>State</th>
                                   <th width="20%"></th>
                              </tr>
                         </thead>
                         <tbody>
                              <tr ng-repeat="user in ctrl.users">
                                   <td>{{user.id}}</span></td>
                                   <td>{{user.name}}</td>
                                   <td>{{user.username}}</span></td>
                                   <td>{{user.email}}</span></td>
                                   <td>{{user.dateBirth}}</span></td>
                                   <td>{{user.state}}</span></td>
                                   <td>
                                        <button type="button" ng-click="ctrl.editUser(user)"
                                                                 class="btn btn-success custom-width">Edit</button>

                                        <button type="button" ng-click="ctrl.deleteUser(user.id)"
                                                                 class="btn btn-danger custom-width">Remove</button>
                                   </td>
                              </tr>
                         </tbody>
                    </table>
               </div>
          </div>
     </div>       
                   
                   
                   
                        

            </div>
            <!-- /.row -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

     <!--footer start-->
     <footer class="site-footer">
          <div class="alert alert-danger">
               ${footer}
               <a href="index.html#" class="go-top">
                    <i class="fa fa-angle-up"></i>
               </a>
          </div>
    </footer>
     <!--footer end-->

	<!-- Angular Touch Core JavaScript -->
	<script src="<c:url value='/static/js/physicalactivity/service/crud_service.js' />"></script>
 	
 	<!-- Angular Touch Core JavaScript -->
 	<script src="<c:url value='/static/js/physicalactivity/controller/user_controller.js' />"></script>
     
    </jsp:body>
</t:admintemplate>
