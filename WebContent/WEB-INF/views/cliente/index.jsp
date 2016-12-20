<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.min.css" />'>
	<title>Inicio</title>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="collapse navbar-collapse">
		  		<ul class="nav navbar-nav">
		  			<li role="presentation"><a href='<c:url value="/cliente/index" />'>Rutina</a></li>
		  			<li role="presentation"><a href='<c:url value="/cliente/${usuario.getId()}/evolucion" />'>Estadísticas</a></li>
				</ul>
				<a class="navbar-brand navbar-right" role="button" href='<c:url value="/logout"/>'>Salir ${usuario.getNombre()} </a>
			</div>
		</div>
	</div>
	<br>
	<br>
	<h1>Rutina de <c:out value="${usuario.getNombre()}"/> </h1>
	<hr>
	<a type="button" class="btn btn-info" href='<c:url value="/cliente/${usuario.id}/evolucion" />'>Mis estadísticas</a>
	<hr>
	
	<h2>Ejercicios De la Rutina</h2>
				<c:set var="semana" value="1"/>
				<c:forEach items="${ejerciciosRutina}" var="ejercicioRutina" varStatus="status">
					<table class="table table-striped">
						<c:if test="${status.index % rutina.ejerciciosPorDia == 0 }">
							<h3>
								<c:if test="${ejercicioRutina.getDia() % rutina.getDias() == 0 }">
									Semana
									<c:out value="${semana}"/>
									<hr>
									<c:set var="semana" value="${semana+1 }"/>
								</c:if> 
								Día <c:out value="${ejercicioRutina.getDia()+1}"/>
							</h3>
							<tr>
								<th>Ejercicio</th>
								<th>Series</th>
								<th>Repeticiones (Por serie)</th>
								<th>Peso (KG)</th>
								<th>Descanso (Segundos)</th>
							</tr>
						</c:if>	
						<tr>
							<td> <c:out value="${ejercicioRutina.ejercicio.getNombre()}"/> </td>
							<td> <c:out value="${ejercicioRutina.getSeries()}"/> </td>
							<td> <c:out value="${ejercicioRutina.getRepeticiones()}"/> </td>
							<td> <c:out value="${ejercicioRutina.getPeso()}"/> </td>
							<td> <c:out value="${ejercicioRutina.getDescanso()}"/> </td>
						</tr>
					</table>
		</c:forEach>	
	<br>
</body>
</html>