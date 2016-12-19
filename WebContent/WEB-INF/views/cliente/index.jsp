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
<sec:authorize access="hasRole('ROLE_USER')">Usuario</sec:authorize>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
	<c:set var="principal" value="${principal}"></c:set>
	<c:out value="${principal.toString()}"></c:out>
	<sec:authentication property="credentials" var="detalles"/>
	<br>
	<c:out value="${detalles }"></c:out>
</sec:authorize>
<a class="btn btn-warning" href='<c:url value="/logout"/>'>Salir</a>
	<br>
	<h1>Rutina de <c:out value="${usuario.getNombre()}"/> </h1>
	<hr>
	<br>
	<table class="table">
	<tr>
		<th>Ejercicio</th>
		<th>Series</th>
		<th>Repeticiones</th>
		<th>Peso</th>
		<th>Descanso entre series</th>
		<th>Dia</th>
	</tr>
	<c:forEach items="${ejerciciosRutina}" var="ejercicioRutina">
		<tr>
			<td>
				<c:out value="${ejercicioRutina.getEjercicio().getNombre() }"/>
			</td>
			<td>
				<c:out value="${ejercicioRutina.getSeries() }"/>
			</td>
			<td>
				<c:out value="${ejercicioRutina.getRepeticiones() }"/>
			</td>
			<td>
				<c:out value="${ejercicioRutina.getPeso() }"/>
			</td>
			<td>
				<c:out value="${ejercicioRutina.getDescanso() }"/>
			</td>
			<td>
				<c:out value="${ejercicioRutina.getDia() +1 }"/>
			</td>
		</tr>
	</c:forEach>
	</table>
	<br>
</body>
</html>