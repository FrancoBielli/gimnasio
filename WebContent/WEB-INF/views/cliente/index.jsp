<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Inicio</title>
</head>
<body>
	<c:import url="/WEB-INF/views/shared/cliente.jsp"></c:import>
	<h1>Rutina de <c:out value="${usuario.getNombre()}"/> </h1>
	<hr>	
	<h2>Ejercicios De la Rutina</h2>
				<c:set var="semana" value="1"/>
				<c:forEach items="${ejerciciosRutina}" var="ejercicioRutina" varStatus="status">
					<table class="table table-condensed">
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
								<th class="col-md-2">Ejercicio</th>
								<th class="col-md-2">Series</th>
								<th class="col-md-2">Repeticiones (Por serie)</th>
								<th class="col-md-2">Peso (KG)</th>
								<th class="col-md-2">Descanso (Segundos)</th>
							</tr>
						</c:if>	
						<tr>
							<td class="col-md-2"> <c:out value="${ejercicioRutina.ejercicio.getNombre()}"/> </td>
							<td class="col-md-2"> <c:out value="${ejercicioRutina.getSeries()}"/> </td>
							<td class="col-md-2"> <c:out value="${ejercicioRutina.getRepeticiones()}"/> </td>
							<td class="col-md-2"> <c:out value="${ejercicioRutina.getPeso()}"/> </td>
							<td class="col-md-2"> <c:out value="${ejercicioRutina.getDescanso()}"/> </td>
						</tr>
					</table>
		</c:forEach>	
	<br>
</body>
</html>