<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Crear Usuario</title>
	
	<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/bootstrap.min.css" />'>
	
</head>
<body>
	<h1>Nuevo Usuario</h1>
	<sf:form method="post" action="${pageContext.request.contextPath}/usuario/crearUsuario" commandName="usuario" cssClass="form-horizontal">
		<div class="form-group">
			<label class="col-md-4 control-label" for="nombre">Nombre: </label>
			<div class="col-md-4">
				<sf:input path="nombre" type="text" class="form-control input-md"
					id="nombre" placeholder="Nombre y Apellido" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="email">Email: </label>
			<div class="col-md-4">
				<sf:input path="email" type="text" class="form-control input-md"
					id="email" placeholder="Introduce tu Email" />
					<small>Se usará este correo para ingresar al sistema</small>
			</div>
			
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="password">Contraseña: </label>
			<div class="col-md-4">
				<sf:input path="password" type="password" class="form-control input-md"
					id="password" placeholder="Contraseña" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="permiso">Permisos: </label>
			<div class="col-md-4">
				<sf:select path="permiso" type="text" class="form-control input-md"
					id="direccion">
					<sf:option value="ROLE_ADMIN">Administrador</sf:option>
					<sf:option value="ROLE_USER">Cliente</sf:option>
				</sf:select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="direccion">Dirección: </label>
			<div class="col-md-4">
				<sf:input path="direccion" type="text" class="form-control input-md"
					id="direccion" placeholder="Dirección" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="telefono">Teléfono: </label>
			<div class="col-md-4">
				<sf:input path="telefono" type="text" class="form-control input-md"
					id="telefono" placeholder="Teléfono" />
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