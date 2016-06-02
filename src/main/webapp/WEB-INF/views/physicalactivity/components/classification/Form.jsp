<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="panel-body formcontainer" uib-collapse="!status.isFirstOpen">
</div>
<div class="col-lg-8 panel panel-default"></div>
<div class="col-lg-4 panel panel-default">
		
	<div class="panel-body">
		<div id="morris-donut-chart">
			<svg height="352" version="1.1" width="258"
				xmlns="http://www.w3.org/2000/svg"
				xmlns:xlink="http://www.w3.org/1999/xlink"
				style="overflow: hidden; position: relative; left: -0.65625px;">
				<desc style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">Created with Raphaël 2.1.2</desc>
				<defs style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></defs>
				<path fill="none" stroke="#0b62a4"
					d="M129,257.8333333333333A79.33333333333333,79.33333333333333,0,0,0,204.09560056464977,204.08180121907662"
					stroke-width="2" opacity="0"
					style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 0;"></path>
				<path fill="#0b62a4" stroke="#ffffff"
					d="M129,260.8333333333333A82.33333333333333,82.33333333333333,0,0,0,206.935350165834,205.0491802567728L236.91048484500092,215.26040343245464A114,114,0,0,1,129,292.5Z"
					stroke-width="3"
					style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
				<path fill="none" stroke="#3980b5"
					d="M204.09560056464977,204.08180121907662A79.33333333333333,79.33333333333333,0,0,0,57.852819481449785,143.40218693367626"
					stroke-width="2" opacity="1"
					style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 1;"></path>
				<path fill="#3980b5" stroke="#ffffff"
					d="M206.935350165834,205.0491802567728A82.33333333333333,82.33333333333333,0,0,0,55.16237988200882,142.07495870847913L22.279229222174678,125.85328040051438A119,119,0,0,1,241.64340084697466,216.87270182861494Z"
					stroke-width="3"
					style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
				<path fill="none" stroke="#679dc6"
					d="M57.852819481449785,143.40218693367626A79.33333333333333,79.33333333333333,0,0,0,128.97507669869142,257.8333294183903"
					stroke-width="2" opacity="0"
					style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 0;"></path>
				<path fill="#679dc6" stroke="#ffffff"
					d="M55.16237988200882,142.07495870847913A82.33333333333333,82.33333333333333,0,0,0,128.97413422091086,260.8333292703462L128.96418584433812,292.4999943743255A114,114,0,0,1,26.76329522124297,128.06532744250956Z"
					stroke-width="3"
					style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
				<text x="129" y="168.5" text-anchor="middle"
					font-family="&quot;Arial&quot;" font-size="15px" stroke="none"
					fill="#000000"
					style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: Arial; font-size: 15px; font-weight: 800;"
					font-weight="800"
					transform="matrix(1.4276,0,0,1.4276,-55.1478,-75.677)"
					stroke-width="0.7004989495798319">
				<tspan dy="5.5"
					style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">In-Store Sales</tspan></text>
				<text x="129" y="188.5" text-anchor="middle"
					font-family="&quot;Arial&quot;" font-size="14px" stroke="none"
					fill="#000000"
					style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-family: Arial; font-size: 14px;"
					transform="matrix(1.6528,0,0,1.6528,-84.1981,-117.8264)"
					stroke-width="0.6050420168067228">
				<tspan dy="5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">30</tspan></text></svg>
		</div>

	</div>
	<!-- /.panel-body -->
</div>

<!-- End Div Panel Custom Field -->
