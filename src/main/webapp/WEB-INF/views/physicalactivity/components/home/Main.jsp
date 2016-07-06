<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="col-lg-12 text-muted">
	<!-- Tips -->
	<div class="panel panel-orange-sports  panel-default-white">
		<div class="panel-heading">
			<spring:message code="param.physicalactivity.classify.morris.title" />
		</div>
		<div class="panel-body">
			<div donut-chart="" donut-data="ctrl.chartData"
				donut-colors="ctrl.chartColors" donut-formatter="ctrl.myFormatter"></div>
			<span class="pull-right"> <a
				href="/physicalactivity/goalsform"
				class="btn btn btn-info pull-left"><spring:message
						code="param.physicalactivity.home.morris.activities.button" /></a>
			</span>
		</div>
	</div>

</div>


<div class="col-lg-8 text-muted">
	<!-- Tips -->
	<div class="panel panel-orange-sports  panel-default-white">
		<div class="panel-heading">
			<spring:message code="param.physicalactivity.tip" />
		</div>
		<div class="panel-body">
			<ul class="chat" ng-repeat="tip in ctrl.listTips">
				<li class="left clearfix">
					<div class="clearfix">
						<p>{{tip.name}}</p>
						<a class="btn btn-outline btn-link"
							href=" https://twitter.com/intent/tweet?text={{tip.name}}&url=http:%3A%2F%2Fsam.net.co"
							target="_blank"> <i class="fa fa-twitter fa-fw"></i>
						</a> <a class="btn btn-outline btn-link"
							href="https://www.facebook.com/sharer.php?u=sam.net.co&description={{tip.name}}"
							target="_blank"> <i class="fa fa-facebook fa-fw"></i>
						</a>
					</div>
				</li>
			</ul>
		</div>
	</div>

	<!-- Alert -->
	<div class="panel panel-orange-sports  panel-default-white">

		<div class="panel-heading">
			<spring:message code="param.physicalactivity.alert" />
		
		</div>


		<div class="panel-body">
			<ul class="chat" ng-repeat="alert in ctrl.listAlerts">
				<li class="left clearfix">
					<div class="clearfix">
						<p ng-bind-html="alert.name"></p>
						<a class="btn btn-outline btn-link"
							href=" https://twitter.com/intent/tweet?text={{alert.name}}&url=http:%3A%2F%2Fsam.net.co"
							target="_blank"> <i class="fa fa-twitter fa-fw"></i>
						</a> <a class="btn btn-outline btn-link"
							href="https://www.facebook.com/sharer.php?u=sam.net.co&description={{alert.name}}"
							target="_blank"> <i class="fa fa-facebook fa-fw"></i>
						</a>
					</div>
				</li>
			</ul>
		</div>
	</div>


	<!-- 		<!-- Myth -->
	

	<!-- 		<div class="panel panel-orange-sports  panel-default-white"> -->
	<!-- 			<div class="panel-heading"> -->
	<%-- 				<spring:message code="param.physicalactivity.myth" /> --%>
	<!-- 			</div> -->
	<!-- 			<div class="panel-body"> -->
	<!-- 				<ul class="chat" ng-repeat="myth in listMyths"> -->
	<!-- 					<li class="left clearfix"> -->
	<!-- 						<div class="clearfix"> -->
	<!-- 							<p>{{myth.name}}</p> -->
	<!-- 						</div> -->
	<!-- 					</li> -->
	<!-- 				</ul> -->
	<!-- 			</div> -->
	<!-- 		</div> -->

</div>

<div class="col-lg-4 text-muted">
	<!-- Advantage -->
	<div class="panel panel-orange-sports  panel-default-white">
		<div class="panel-heading">
			<spring:message code="param.physicalactivity.advantage" />
		</div>
		<div class="panel-body">
			<ul class="chat" ng-repeat="advantage in ctrl.listAdvantages">
				<li class="left clearfix">
					<div class="clearfix">
						<p>{{advantage.name}}</p>
						<a class="btn btn-outline btn-link"
							href=" https://twitter.com/intent/tweet?text={{advantage.name}}&url=http:%3A%2F%2Fsam.net.co"
							target="_blank"> <i class="fa fa-twitter fa-fw"></i>
						</a> <a class="btn btn-outline btn-link"
							href="https://www.facebook.com/sharer.php?u=sam.net.co&description={{advantage.name}}"
							target="_blank"> <i class="fa fa-facebook fa-fw"></i>
						</a>
					</div>
				</li>
			</ul>
		</div>
	</div>
</div>


<div class="col-lg-12 text-muted">
	<div class="panel panel-orange-sports  panel-default-white">
		<div class="panel-heading">
			<spring:message
				code="param.physicalactivity.home.morris.specific.goals" />
		</div>
		<div class="panel-body">

			<fieldset class="col-md-6"
				ng-repeat="goalsMorris in ctrl.listGoalsMorrisSelect">
				<div donut-chart="" donut-data="goalsMorris.chart"
					donut-colors="ctrl.chartColors" donut-formatter="ctrl.myFormatter"></div>

				<h4 class=" text-center text-muted  control-lable ">

					<spring:message code="param.physicalactivity.home.morris.current" />


				</h4>
				<h4 class=" text-center text-muted  control-lable ">

					<spring:message code="param.physicalactivity.home.morris.goal" />


				</h4>
			</fieldset>
			<span class="pull-right"> <a
				href="/physicalactivity/goalsform"
				class="btn btn btn-info pull-left"><spring:message
						code="param.physicalactivity.home.morris.activities.button" /></a>
			</span>

		</div>
	</div>
</div>



<!-- End Div Panel Custom Field -->
