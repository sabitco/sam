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
					<small> La presente plataforma interactiva, se constituye
						en una intervención de enfermería e interdisciplinaria para la
						promoción de la actividad física. Cuenta con el respaldo de la
						teoría de autoeficacia de Bárbara Resnick así como los siete
						conceptos para el diseño de programas de promoción de salud.
						Además, retoma elementos claves de gamificación. La intervención
						de enfermería diseñada, buscar establecer conductas para el
						fomento de estilos de vida saludable relacionadas con la actividad
						física y mantenimiento del peso ideal, mediante el control de
						variables como es el índice de masa corporal y la cuantificación
						de los minutos de actividad física, teniendo en cuenta que la meta
						es alcanzar más de 150 minutos semanales de actividad física.</small>

					<div class="clearfix">
						<p></p>
					</div>
				</div>
			</div>
		</div>
	</div>
</footer>
<!--End Statement Footer-->