<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Asignar Rutina</title>
	
	<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/bootstrap.min.css" />'>
	
</head>
<body>
	<c:import url="/WEB-INF/views/shared/admin.jsp"></c:import>
	<h1>Asignar Rutina a "${usuario.getNombre() }"</h1>
	<sf:form method="post" action="${pageContext.request.contextPath}/usuario/asignarRutina" commandName="usuario" cssClass="form-horizontal">
		<div class="form-group">
			<label class="col-md-4 control-label" for="rutina">Rutina: </label>
			<sf:input path="id" type="hidden"/>
			<div class="col-md-4">
				<sf:select path="rutina.id" id="rutina">
					<sf:option value="0" label=" "></sf:option>
					<sf:options items="${rutinas}" itemValue="id" itemLabel="nombre"/>
				</sf:select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label"></label>
			<div>
			</div>
				<input type="submit" value="Aceptar" class="btn btn-success">
				<a type="button" class="btn btn-warning" href='<c:url value="/usuario/index" />'>Cancelar</a>
			</div>
		
	</sf:form>
</body>
</html>