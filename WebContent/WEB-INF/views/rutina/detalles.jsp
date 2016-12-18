<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalles de Rutina</title>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.min.css" />'>
</head>
<body>
	<h1>Detalles de Rutina: <strong> <c:out value="${rutina.getNombre() }"/></strong></h1>
	<hr>
	<table class="table">
		<tr>
			<td class="col-md-2">Nombre</td>
			<td><c:out value="${rutina.getNombre()}"/></td>
		</tr>
		<tr>
			
			<td colspan="2">
				<table class="table table-striped">
					<tr>
						<th>Ejercicio</th>
						<th>Series</th>
						<th>Repeticiones</th>
						<th>Peso</th>
						<th>Descanso</th>
						<th>Dia</th>
					</tr>
					<c:forEach items="${ejerciciosRutina}" var="ejercicioRutina" varStatus="status">
						<tr>
							<td> <c:out value="${ejercicioRutina.ejercicio.getNombre()}"/> </td>
							<td> <c:out value="${ejercicioRutina.getSeries()}"/> </td>
							<td> <c:out value="${ejercicioRutina.getRepeticiones()}"/> </td>
							<td> <c:out value="${ejercicioRutina.getPeso()}"/> </td>
							<td> <c:out value="${ejercicioRutina.getDescanso()}"/> </td>
							<td> <c:out value="${ejercicioRutina.getDia()+1}"/> </td>
						</tr>
					</c:forEach>				
				</table>
				
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<a type="button" class="btn btn-warning" href='<c:url value="/rutina/index" />'>Volver</a>
			</td>
		</tr>
	</table>
	
</body>
</html>