<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>	
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Editar Ejercicios de Rutina</title>
	
	<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/bootstrap.min.css" />'>
</head>
<body>
<c:import url="/WEB-INF/views/shared/admin.jsp"></c:import>
	<h2>Ejercicios de la Rutina : <c:out value="${rutina.getNombre()}"/> </h2>
	<c:set var="semana" value="1"/>
	<sf:form method="POST" modelAttribute="ejerciciosRutinaForm"
	action="${pageContext.request.contextPath}/rutina/editarEjercicios">
	<input type="hidden" name="rutinaId" value="${rutinaId}">
	<c:forEach items="${ejerciciosRutinaForm.ejerciciosRutina}" var="ejercicioRutina" varStatus="status">
		<input type="hidden" name="ejerciciosRutina[${status.index}].rutina.id" value="${ejercicioRutina.rutina.id }" />
		<input type="hidden" name="ejerciciosRutina[${status.index}].id" value="${ejercicioRutina.id }" />
		<input type="hidden" name="ejerciciosRutina[${status.index}].dia" value="${ejercicioRutina.getDia()}">
		<table class="table table-condensed">
			<c:if test="${status.index % rutina.ejerciciosPorDia == 0 }">
				<h3>
					<c:if test="${ejercicioRutina.getDia() % rutina.getDias() == 0 }">
						Semana
						<c:out value="${semana}"/>
						<hr>
						<c:set var="semana" value="${semana+1 }"/>
					</c:if> 
					Día <c:out value="${ejercicioRutina.getDia() + 1 }"/>
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
				<td>	
					<sf:select path="ejerciciosRutina[${status.index}].ejercicio.id" id="ejercicio" >		
						<c:forEach items="${ejercicios}" var="ejercicio">
					        <sf:option  value="${ejercicio.id}">
					            <c:out value="${ejercicio.nombre}"/>
					        </sf:option>                     
					    </c:forEach>
					</sf:select>
					<sf:errors path="ejerciciosRutina[${status.index}].ejercicio.id" class="text-danger"/>
				</td>
				<td>
					<sf:input type="number" path="ejerciciosRutina[${status.index}].series" value="${ejercicioRutina.getSeries()}"/>
					<sf:errors path="ejerciciosRutina[${status.index}].series" class="text-danger"/>
				</td>
				<td>
					<sf:input type="number" path="ejerciciosRutina[${status.index}].repeticiones" value="${ejercicioRutina.getRepeticiones()}" />
					<sf:errors path="ejerciciosRutina[${status.index}].repeticiones" class="text-danger"/>
				</td>
				<td>
					<sf:input type="number" path="ejerciciosRutina[${status.index}].peso" value="${ejercicioRutina.getPeso()}"/>
					<sf:errors path="ejerciciosRutina[${status.index}].peso" class="text-danger"/>
				</td>
				<td>
					<sf:input type="number" path="ejerciciosRutina[${status.index}].descanso" value="${ejercicioRutina.getDescanso()}" />
					<sf:errors path="ejerciciosRutina[${status.index}].descanso" class="text-danger"/>
				</td>
			</tr>
		</table>
	</c:forEach>
	<div class="form-group">
			<label class="col-md-4 control-label"></label>
			<div>
				<input type="submit" value="Aceptar" class="btn btn-lg btn-success">
				<a type="button" class="btn btn-lg btn-danger" href='<c:url value="/rutina/index" />'>Cancelar</a>
			</div>
	</div>
	</sf:form>
</body>