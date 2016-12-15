<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.min.css" />'>
	<title>Evolución de Usuario</title>
</head>
<body>
	<h1>Estadísticas de "${usuario.getNombre()}"</h1>
	<hr>
	<a type="button" class="btn btn-success" href='<c:url value="/evolucionUsuario/${usuario.getId()}/crear" />'>Nuevo</a>
	<table class="table table-striped table-responsive">
		<tbody>
			<tr>
				<th>#</th>
				<th>Fecha</th>
				<th>Peso</th>
				<th>% Grasa</th>
				<th>% Músculo</th>
				<th>IMC</th>
				<th>Operaciones</th>
			</tr>
			<c:forEach items="${evolucionDeUsuario}" var="evolucion">
				<tr>
					<td><c:out value="${evolucion.getId()}"/> </td>
					<td><c:out value="${evolucion.getFecha()}"/></td>
					<td><c:out value="${evolucion.getPeso()}"/></td>
					<td><c:out value="${evolucion.getPorcentajeGrasa()}"/></td>
					<td><c:out value="${evolucion.getPorcentajeMusculo()}"/></td>
					<td><c:out value="${evolucion.getImc()}"/></td>
					<td>
						<a type="button" class="btn btn-warning" href='<c:url value="/evolucionUsuario/${evolucion.id}/editar" />'>Editar</a>
						<a type="button" class="btn btn-danger confirm" href='<c:url value="/evolucionUsuario/${evolucion.id}/eliminar" />'>Eliminar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a type="button" class="btn btn-default" href='<c:url value="/usuario/index" />'>Volver</a>
</body>
<script type="text/javascript" src='<c:url value="/resources/js/jquery-3.1.1.min.js" />'></script>
<script type="text/javascript" src='<c:url value="/resources/js/jquery-3.1.1.js" />'></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".confirm").on("click", function(){
			return confirm("Eliminar estadística de usuario?");
		});
	});
</script>
</html>