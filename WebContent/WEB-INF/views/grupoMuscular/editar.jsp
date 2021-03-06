<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Editar Grupo Muscular</title>
	<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.min.css" />'>
</head>
<body>
<c:import url="/WEB-INF/views/shared/admin.jsp"></c:import>
	<h1>Editando Grupo Muscular: <strong><c:out value="${grupoMuscular.getNombre()}"/></strong></h1>
	<hr>
	<sf:form method="post" action="${pageContext.request.contextPath}/grupoMuscular/editarGrupoMuscular" commandName="grupoMuscular" cssClass="form-horizontal">
		<sf:input path="id" type="hidden"/>
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="nombre">Nombre: </label>
			<div class="col-md-4">
				<sf:input path="nombre" type="text" class="form-control input-md"
					id="nombre" placeholder="Nombre del Grupo Muscular" />
					<sf:errors path="nombre" class="text-danger"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label"></label>
			<div class="col-md-4">
				<input type="submit" class="btn btn-success" value="Aceptar">
				<a type="button" class="btn btn-warning" href='<c:url value="/grupoMuscular/index" />'>Cancelar</a>
			</div>
		</div>
	</sf:form>
</body>
</html>