<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalles de Ejercicio</title>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.min.css" />'>
</head>
<body>
<c:import url="/WEB-INF/views/shared/admin.jsp"></c:import>
	<h1>Detalles de Ejercicio: <strong> <c:out value="${ejercicio.getNombre() }"/></strong></h1>
	<hr>
	<table class="table">
		<tr>
			<td class="col-md-4">Nombre</td>
			<td><c:out value="${ejercicio.getNombre()}"/></td>
		</tr>
		<tr>
			<td>Grupo Muscular</td>
			<td><c:out value="${ejercicio.getGrupoMuscular().getNombre()}"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<a type="button" class="btn btn-warning" href='<c:url value="/ejercicio/index" />'>Volver</a>
				<a type="button" class="btn btn-info" href='<c:url value="/ejercicio/${ejercicio.id}/editar" />'>Editar</a>
			</td>
		</tr>
	</table>
	
</body>
</html>