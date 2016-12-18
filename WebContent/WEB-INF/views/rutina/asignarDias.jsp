<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Asignar Ejercicios a Rutina</title>
	
	<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/bootstrap.min.css" />'>
	
</head>
<body>
	<h1>Días, semanas y ejercicios de Rutina</h1>
	<form method="POST" action="${pageContext.request.contextPath}/rutina/asignarDias" Class="form-horizontal">
		<input type="hidden" name="id" id="id" value="${id}"/>
		<div class="form-group">
			<label class="col-md-4 control-label" for="semanas">Semanas: </label>
			<div class="col-md-4">
				<input  type="number" class="form-control input-md"
					id="semanas" name="semanas" placeholder="Semanas de duración de la rutina" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="dias">días: </label>
			<div class="col-md-4">
				<input name="dias" type="number" class="form-control input-md"
					id="dias" placeholder="Dias a la semana" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="ejerciciosPorDia">Ejercicios por día: </label>
			<div class="col-md-4">
				<input name="ejerciciosPorDia" type="number" class="form-control input-md"
				id="ejerciciosPorDia" placeholder="Cantidad de Ejercicios por día" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label"></label>
			<div>
				<input type="submit" value="Aceptar" class="btn btn-success">
				<a type="button" class="btn btn-warning" href='<c:url value="/rutina/index" />'>Cancelar</a>
			</div>
		</div>
	</form>
</body>