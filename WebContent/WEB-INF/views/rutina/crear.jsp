<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Crear Rutina</title>
	
	<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/bootstrap.min.css" />'>
	
</head>
<body>
<c:import url="/WEB-INF/views/shared/admin.jsp"></c:import>
	<h1>Nueva Rutina</h1>
	<sf:form method="post" action="${pageContext.request.contextPath}/rutina/crearRutina" commandName="rutina" cssClass="form-horizontal">
		<div class="form-group">
			<label class="col-md-4 control-label" for="nombre">Nombre: </label>
			<div class="col-md-4">
				<sf:input path="nombre" type="text" class="form-control input-md"
					id="nombre" placeholder="Nombre de la Rutina" />
					<sf:errors path="nombre" class="text-danger"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="semanas">Semanas: </label>
			<div class="col-md-4">
				<sf:input path="semanas" type="number" class="form-control input-md"
					id="semanas" placeholder="Semanas de duración" />
					<sf:errors path="semanas" class="text-danger"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="dias">Días por semana: </label>
			<div class="col-md-4">
				<sf:input path="dias" type="number" class="form-control input-md"
					id="dias" placeholder="Días por semana de la rutina" />
					<sf:errors path="dias" class="text-danger"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="ejerciciosPorDia">Ejercicios Por Día: </label>
			<div class="col-md-4">
				<sf:input path="ejerciciosPorDia" type="number" class="form-control input-md"
					id="ejerciciosPorDia" placeholder="Cantidad de ejercicios por día" />
					<sf:errors path="ejerciciosPorDia" class="text-danger"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label"></label>
			<div>
				<input type="submit" value="Aceptar" class="btn btn-success">
				<a type="button" class="btn btn-warning" href='<c:url value="/rutina/index" />'>Cancelar</a>
			</div>
		</div>
		
	</sf:form>
</body>
</html>