<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!-- Var of Error validation -->
<c:set var="messageErrorFormRequiredField""><spring:message code="message.error.form.required.field"/></c:set>
<c:set var="messageErrorFormMinimumLengthRequired""><spring:message code="message.error.form.minimum.length.required.four"/></c:set>
<c:set var="messageErrorFormFieldInvalid"><spring:message code="message.error.form.field.invalid"/></c:set>





<!-- End Var of Error Validation -->

            	<!-- Div .panel-green -->
				<div class="">  

					
					<!-- Div Panel Custom Field -->
					<div class="panel-body formcontainer">
					
						<!-- Form Register-->

	               <div class="formcontainer">
	
	                    <form ng-submit="ctrl.submit()" name="pageForm"
										class="form-horizontal">
	
	                         <input type="hidden" ng-model="ctrl.page.id" />
	
	                         <div class="row">
	                              <div class="form-group col-md-12">
	                                   <label class="col-md-2 control-lable"
													for="name">${nameCustomForm}</label>
	                                   <div class="col-md-7">
	                                        <input type="text"
														ng-model="ctrl.page.name" id="name"
														class="name form-control input-sm"
														placeholder="Enter your ${nameCustomForm}" required ng-minlength="4" />
	                                        <div class="has-error"
														ng-show="pageForm.name.$dirty">
	                                             <span
															ng-show="pageForm.name.$error.required">
																${messageErrorFormRequiredField}
															</span> 
							<span
															ng-show="pageForm.name.$error.minlength"
															
															</span>
																${messageErrorFormMinimumLengthRequired}	
							<span
															ng-show="pageForm.name.$invalid">
																${messageErrorFormFieldInvalid}
															</span>
	
	                                        </div>
	                                   </div>
	                              </div>
	                         </div>
	
	                         <div class="row">
	                              <div class="form-group col-md-12">
	                                   <label class="col-md-2 control-lable"
													for="orderPage">${orderCustomForm}</label>
	                                   <div class="col-md-7">
	                                        <input type="text"
														ng-model="ctrl.page.orderPage" id="orderPage"
														class="orderPage form-control input-sm"
														placeholder="Enter your orderPage of" required
														ng-minlength="4" />
	                                        <div class="has-error"
														ng-show="pageForm.orderPage.$dirty">
	                                             <span
															ng-show="pageForm.orderPage.$error.required">${messageErrorFormRequiredField}</span> <span
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
	                                   <label class="col-md-2 control-lable"
													for="url">${urlCustomForm}</label>
	                                   <div class="col-md-7">
	                                        <input type="text"
														ng-model="ctrl.page.url" id="url"
														class="url form-control input-sm"
														placeholder="Enter your url of" required ng-minlength="4" />
	                                        <div class="has-error"
														ng-show="pageForm.url.$dirty">
	                                             <span
															ng-show="pageForm.url.$error.required">
															${messageErrorFormRequiredField}
															</span> 
							<span
															ng-show="pageForm.url.$error.minlength">
															<spring:message code="message.error.form.minimum.length.required.four"/>
															</span> 
							<span
															ng-show="pageForm.url.$invalid">
															<spring:message code="message.error.form.field.invalid"/>
															</span>
	
	                                        </div>
	                                   </div>
	                              </div>
	                         </div>
	                         
	   
	                         <div class="row">
	                              <div class="form-group col-md-12">
	                                   <label class="col-md-2 control-lable"
													for="base">${basePageCustomForm}</label>
	                                   <div class="col-md-7">
	                                        <input type="text"
														ng-model="ctrl.page.base" id="url"
														class="base form-control input-sm"
														placeholder="Enter your base of" required ng-minlength="4" />
	                                        <div class="has-error"
														ng-show="pageForm.base.$dirty">
	                                             <span
															ng-show="pageForm.base.$error.required">This is a
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
	                                   <label class="col-md-2 control-lable"
													for="descriptionList">${listPageCustomForm}</label>
	                                   <div class="col-md-7">
	                                        <input type="text"
														ng-model="ctrl.page.descriptionList" id="descriptionList"
														class="descriptionList form-control input-sm"
														placeholder="Enter your descriptionList of" required
														ng-minlength="4" />
	                                        <div class="has-error"
														ng-show="pageForm.descriptionList.$dirty">
	                                             <span
															ng-show="pageForm.descriptionList.$error.required">This is a
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
	                                   <label class="col-md-2 control-lable"
													for="descriptionPage">${descriptionPageCustomForm}</label>
	                                   <div class="col-md-7">
	                                        <input type="text"
														ng-model="ctrl.page.descriptionPage" id="descriptionPage"
														class="descriptionPage form-control input-sm"
														placeholder="Enter your descriptionPage of" required
														ng-minlength="4" />
	                                        <div class="has-error"
														ng-show="pageForm.descriptionPage.$dirty">
	                                             <span
															ng-show="pageForm.descriptionPage.$error.required">This is a
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
	                                   <label class="col-md-2 control-lable"
													for="icone">${IconePageCustomForm}</label>
	                                   <div class="col-md-7">
	                                        <input type="text"
														ng-model="ctrl.page.icone" id="icone"
														class="icone form-control input-sm"
														placeholder="Enter your icone of" required ng-minlength="4" />
	                                        <div class="has-error"
														ng-show="pageForm.icone.$dirty">
	                                             <span
															ng-show="pageForm.icone.$error.required">This is a
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
	                                   <label class="col-md-2 control-lable"
													for="namePage">${namePageCustomForm}</label>
	                                   <div class="col-md-7">
	                                        <input type="text"
														ng-model="ctrl.page.namePage" id="namePage"
														class="namePage form-control input-sm"
														placeholder="Enter your namePage of" required
														ng-minlength="4" />
	                                        <div class="has-error"
														ng-show="pageForm.namePage.$dirty">
	                                             <span
															ng-show="pageForm.namePage.$error.required">This is a
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
	                                   <label class="col-md-2 control-lable"
													for="title">${tituloPageCustomForm}</label>
	                                   <div class="col-md-7">
	                                        <input type="text"
														ng-model="ctrl.page.title" id="title"
														class="title form-control input-sm"
														placeholder="Enter your title of" required ng-minlength="4" />
	                                        <div class="has-error"
														ng-show="pageForm.title.$dirty">
	                                             <span
															ng-show="pageForm.title.$error.required">This is a
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
		                              <div class="form-group col-md-12">
		                                   <label class="col-md-2 control-lable"
														for="state">
														<spring:message code="parameter.from.custom.state" />
										</label>
		                                   <div class="col-md-7">
						   						<select 
						   							ng-init="ctrl.page.state = ctrl.page.state || items[0]" 
						                       		ng-options="stateEnum for stateEnum in ctrl.enumStates" 
						                       		ng-model="ctrl.page.state" 
						                       		ng-change="show()" required>
						                   		</select>
		                                        <div class="has-error"
															ng-show="pageForm.state.$dirty">
		                                             <span
																ng-show="pageForm.state.$error.required">This is a
		                                                  required field</span> <span
																ng-show="pageForm.state.$invalid">This
		                                                  field is invalid </span>
		
		                                        </div>
		                                   </div>
		                              </div>
		                         </div>

	                              <div class="pull-right  form-actions floatRight">
	                                   <input type="submit"
													value="{{!ctrl.page.id ? 'Add' : 'Update'}}"
													class="btn btn-success btn-sm"
													ng-disabled="pageForm.$invalid">
	
	                                   <button type="button"
													ng-click="ctrl.reset()" class="btn btn-warning btn-sm"
													ng-disabled="pageForm.$pristine">
													<spring:message code="param.botton.form.recent"/>
	                                        Form</button>
	                              </div>
	                         
	                    </form>
						</div>
                    	<!-- End Form Register-->
                    			
					</div>
					<!-- End Div Panel Custom Field -->	
            	
				</div>
				<!-- End Div .panel-green -->
