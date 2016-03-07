<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="co.edu.unal.sam.aspect.properties.ReadFromPropertiesFile"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
     
     
<!-- Parameter of custom field form-->

<c:set var="idCustomForm" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('parameter.from.custom.id')}" />
     
<c:set var="registerDateCustomForm" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('parameter.from.custom.register.date')}" />

<c:set var="nameCustomForm" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('parameter.from.custom.name')}" />
     
<c:set var="stateCustomForm" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('parameter.from.custom.state')}" />     
  
<c:set var="orderCustomForm" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('parameter.from.custom.order')}" />       
     
<c:set var="typePageCustomForm" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('parameter.from.custom.type.page')}" />
     
<c:set var="urlCustomForm" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('parameter.from.custom.url')}" />
     
<c:set var="basePageCustomForm" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('parameter.from.custom.base.page')}" />
     
<c:set var="listPageCustomForm" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('parameter.from.custom.list.page')}" />
     
<c:set var="descriptionPageCustomForm" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('parameter.from.custom.description.page')}" />

<c:set var="IconePageCustomForm" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('parameter.from.custom.icone.page')}" />
          
<c:set var="namePageCustomForm" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('parameter.from.custom.name.page')}" />
     
<c:set var="tituloPageCustomForm" scope="session" 
     value="${ReadFromPropertiesFile.getProperties('parameter.from.custom.titulo.page')}" />
<!-- END Parameter of custom field form-->
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
                        <li><a href="#"><i class="btn-danger btn-circle fa fa-user fa-fw"></i>  ${userLogger} </a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> ${logout} </a>
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
                   
               <div class="generic-container" ng-controller="PageController as ctrl">
          <div class="panel panel-default">
               <div class="alert alert-info">
                    <h1 class=" timeline-title">
                        ${descriptionpage}
                    </h1>
               </div>
               <div class="formcontainer">

                    <form ng-submit="ctrl.submit()" name="pageForm" class="form-horizontal">

                         <input type="hidden" ng-model="ctrl.page.id" />

                         <div class="row">
                              <div class="form-group col-md-12">
                                   <label class="col-md-2 control-lable" for="name">${nameCustomForm}</label>
                                   <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.page.name" id="name"
                                                                 class="name form-control input-sm"
                                                                 placeholder="Enter your name of"
                                                                 required ng-minlength="4" />
                                        <div class="has-error" ng-show="pageForm.name.$dirty">
                                             <span ng-show="pageForm.name.$error.required">This is a
                                                  required field</span> <span
                                                                      ng-show="pageForm.name.$error.minlength">Minimum
                                                  length required is 4</span> <span
                                                                      ng-show="pageForm.name.$invalid">This
                                                  field is invalid </span>

                                        </div>
                                   </div>
                              </div>
                         </div>

                         <div class="row">
                              <div class="form-group col-md-12">
                                   <label class="col-md-2 control-lable" for="orderPage">${orderCustomForm}</label>
                                   <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.page.orderPage" id="orderPage"
                                                                 class="orderPage form-control input-sm"
                                                                 placeholder="Enter your orderPage of"
                                                                 required ng-minlength="4" />
                                        <div class="has-error" ng-show="pageForm.orderPage.$dirty">
                                             <span ng-show="pageForm.orderPage.$error.required">This is a
                                                  required field</span> <span
                                                                      ng-show="pageForm.orderPage.$error.minlength">Minimum
                                                  length required is 4</span> <span
                                                                      ng-show="pageForm.orderPage.$invalid">This
                                                  field is invalid </span>

                                        </div>
                                   </div>
                              </div>
                         </div>
                         
                         <div class="row">
                              <div class="form-group col-md-12">
                                   <label class="col-md-2 control-lable" for="url">${urlCustomForm}</label>
                                   <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.page.url" id="url"
                                                                 class="url form-control input-sm"
                                                                 placeholder="Enter your url of"
                                                                 required ng-minlength="4" />
                                        <div class="has-error" ng-show="pageForm.url.$dirty">
                                             <span ng-show="pageForm.url.$error.required">This is a
                                                  required field</span> <span
                                                                      ng-show="pageForm.url.$error.minlength">Minimum
                                                  length required is 4</span> <span
                                                                      ng-show="pageForm.url.$invalid">This
                                                  field is invalid </span>

                                        </div>
                                   </div>
                              </div>
                         </div>
                         
   
                         <div class="row">
                              <div class="form-group col-md-12">
                                   <label class="col-md-2 control-lable" for="base">${basePageCustomForm}</label>
                                   <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.page.base" id="url"
                                                                 class="base form-control input-sm"
                                                                 placeholder="Enter your base of"
                                                                 required ng-minlength="4" />
                                        <div class="has-error" ng-show="pageForm.base.$dirty">
                                             <span ng-show="pageForm.base.$error.required">This is a
                                                  required field</span> <span
                                                                      ng-show="pageForm.base.$error.minlength">Minimum
                                                  length required is 4</span> <span
                                                                      ng-show="pageForm.base.$invalid">This
                                                  field is invalid </span>

                                        </div>
                                   </div>
                              </div>
                         </div>                                              

                         <div class="row">
                              <div class="form-group col-md-12">
                                   <label class="col-md-2 control-lable" for="descriptionList">${listPageCustomForm}</label>
                                   <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.page.descriptionList" id="descriptionList"
                                                                 class="descriptionList form-control input-sm"
                                                                 placeholder="Enter your descriptionList of"
                                                                 required ng-minlength="4" />
                                        <div class="has-error" ng-show="pageForm.descriptionList.$dirty">
                                             <span ng-show="pageForm.descriptionList.$error.required">This is a
                                                  required field</span> <span
                                                                      ng-show="pageForm.descriptionList.$error.minlength">Minimum
                                                  length required is 4</span> <span
                                                                      ng-show="pageForm.descriptionList.$invalid">This
                                                  field is invalid </span>

                                        </div>
                                   </div>
                              </div>
                         </div>

                         <div class="row">
                              <div class="form-group col-md-12">
                                   <label class="col-md-2 control-lable" for="descriptionPage">${descriptionPageCustomForm}</label>
                                   <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.page.descriptionPage" id="descriptionPage"
                                                                 class="descriptionPage form-control input-sm"
                                                                 placeholder="Enter your descriptionPage of"  
                                                                 required ng-minlength="4" />
                                        <div class="has-error" ng-show="pageForm.descriptionPage.$dirty">
                                             <span ng-show="pageForm.descriptionPage.$error.required">This is a
                                                  required field</span> <span
                                                                      ng-show="pageForm.descriptionPage.$error.minlength">Minimum
                                                  length required is 4</span> <span
                                                                      ng-show="pageForm.descriptionPage.$invalid">This
                                                  field is invalid </span>

                                        </div>
                                   </div>
                              </div>
                         </div>
                         
                         <div class="row">
                              <div class="form-group col-md-12">
                                   <label class="col-md-2 control-lable" for="icone">${IconePageCustomForm}</label>
                                   <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.page.icone" id="icone"
                                                                 class="icone form-control input-sm"
                                                                 placeholder="Enter your icone of"
                                                                 required ng-minlength="4" />
                                        <div class="has-error" ng-show="pageForm.icone.$dirty">
                                             <span ng-show="pageForm.icone.$error.required">This is a
                                                  required field</span> <span
                                                                      ng-show="pageForm.icone.$error.minlength">Minimum
                                                  length required is 4</span> <span
                                                                      ng-show="pageForm.icone.$invalid">This
                                                  field is invalid </span>

                                        </div>
                                   </div>
                              </div>
                         </div>        
                         
                         <div class="row">
                              <div class="form-group col-md-12">
                                   <label class="col-md-2 control-lable" for="namePage">${namePageCustomForm}</label>
                                   <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.page.namePage" id="namePage"
                                                                 class="namePage form-control input-sm"
                                                                 placeholder="Enter your namePage of"
                                                                 required ng-minlength="4" />
                                        <div class="has-error" ng-show="pageForm.namePage.$dirty">
                                             <span ng-show="pageForm.namePage.$error.required">This is a
                                                  required field</span> <span
                                                                      ng-show="pageForm.namePage.$error.minlength">Minimum
                                                  length required is 4</span> <span
                                                                      ng-show="pageForm.namePage.$invalid">This
                                                  field is invalid </span>

                                        </div>
                                   </div>
                              </div>
                         </div> 
                         <div class="row">
                              <div class="form-group col-md-12">
                                   <label class="col-md-2 control-lable" for="title">${tituloPageCustomForm}</label>
                                   <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.page.title" id="title"
                                                                 class="title form-control input-sm"
                                                                 placeholder="Enter your title of"
                                                                 required ng-minlength="4" />
                                        <div class="has-error" ng-show="pageForm.title.$dirty">
                                             <span ng-show="pageForm.title.$error.required">This is a
                                                  required field</span> <span
                                                                      ng-show="pageForm.title.$error.minlength">Minimum
                                                  length required is 4</span> <span
                                                                      ng-show="pageForm.title.$invalid">This
                                                  field is invalid </span>

                                        </div>
                                   </div>
                              </div>
                         </div>                                                         
                         <div class="row">
                              <div class="form-actions floatRight">
                                   <input type="submit" value="{{!ctrl.page.id ? 'Add' : 'Update'}}"
                                                            class="btn btn-primary btn-sm"
                                                            ng-disabled="pageForm.$invalid">

                                   <button type="button" ng-click="ctrl.reset()"
                                                            class="btn btn-warning btn-sm"
                                                            ng-disabled="pageForm.$pristine">Reset
                                        Form</button>
                              </div>
                         </div>
                    </form>
               </div>
          </div>
          <div class="panel panel-default">
               <!-- Default panel contents -->
               <div class="panel-heading">
                    <span class="lead">List of Pages </span>
               </div>
               
               <div class="tablecontainer">
                    <table ng-show="ctrl.pages.length > 0">
                         <thead>
                              <tr>
                                   <th>${idCustomForm}</th>
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
                                        <button type="button" ng-click="ctrl.editPage(page)"
                                                                 class="btn btn-success custom-width">Edit</button>

                                        <button type="button" ng-click="ctrl.deletePage(page.id)"
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
 	<script src="<c:url value='/static/js/physicalactivity/controller/page_controller.js' />"></script>
     
    </jsp:body>
</t:admintemplate>
