<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!--Statement Footer-->
<footer class="site-footer">
	<div class="alert">
		<spring:message code="param.physicalactivity.footer.name" />

		<div class="pull-right">
			<a href="/physicalactivity/terms" class="btn btn-outline btn-link"><spring:message
					code="param.physicalactivity.home.terms.conditions" /></a> <a
				href="/physicalactivity/about" class="btn btn-outline btn-link"><spring:message
					code="param.physicalactivity.home.about" /></a>
		</div>
		<!-- DescriptionPage -->
		<div class="col-lg-12 text-muted">
			<div class="panel panel-orange-sports  panel-default-white">
				
				<div class="panel-body">
					<small> 
					SAM es una plataforma interactiva diseñada para ayudarle a mejorar su nivel de actividad física. Con cada meta alcanzada mejora su clasificación de nivel de usuario que lo puede llevar a obtener algunos reconocimientos, al tiempo que disminuye su riesgo cardiovascular.
					<br>
Es una intervención innovadora diseñada por una profesional de enfermería, con el apoyo de un equipo interdisciplinario, basada en la integración de de los conceptos de la teoría de la autoeficacia de Bárbara Resnick y los de promoción de la salud y gamificación. 
						<br>
Su propósito es promover en los estudiantes de la Universidad Nacional un estilo de vida saludable relacionado con la actividad física y el mantenimiento del peso ideal, mediante el control de variables como el índice de masa corporal y la cuantificación de minutos de actividad física, teniendo en cuenta que la meta es alcanzar más de 150 minutos semanales de actividad física, según últimos lineamientos de la OMS.

					</small>

					<div class="clearfix">
						<p></p>
					</div>
				</div>
			</div>
		</div>
	</div>
</footer>
<!--End Statement Footer-->
