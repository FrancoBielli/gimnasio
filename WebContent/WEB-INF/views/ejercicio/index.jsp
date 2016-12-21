<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.min.css" />'>
	<title>Ejercicios</title>
</head>
<body>
<c:import url="/WEB-INF/views/shared/admin.jsp"></c:import>
	<h1>Lista de Ejercicios</h1>
	<hr>
	<a type="button" class="btn btn-success" href='<c:url value="/ejercicio/crear" />'>Nuevo</a>
	<table class="table table-striped table-responsive">
		<tbody>
			<tr>
				<th>#</th>
				<th>Nombre</th>
				<th>Grupo Muscular</th>
				<th>Operaciones</th>
			</tr>
			<c:forEach items="${ejercicios}" var="ejercicio">
				<tr>
					<td><c:out value="${ejercicio.getId()}"/> </td>
					<td><c:out value="${ejercicio.getNombre()}"/></td>
					<td><c:out value="${ejercicio.getGrupoMuscular().getNombre()}"/></td>
					<td>
						<a type="button" class="btn btn-info" href='<c:url value="/ejercicio/${ejercicio.id}/detalle" />'>Detalles</a>
						<a type="button" class="btn btn-warning" href='<c:url value="/ejercicio/${ejercicio.id}/editar" />'>Editar</a>
						<a type="button" class="btn btn-danger confirm" href='<c:url value="/ejercicio/${ejercicio.id}/eliminar" />'>Eliminar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
<script type="text/javascript" src='<c:url value="/resources/js/jquery-3.1.1.min.js" />'></script>
<script type="text/javascript" src='<c:url value="/resources/js/jquery-3.1.1.js" />'></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".confirm").on("click", function(){
			return confirm("Eliminar ejercicio?");
		});
	});
</script>
</html>