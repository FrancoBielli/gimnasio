<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Crear Estadística</title>
	
	<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/bootstrap.min.css" />'>
	
</head>
<body>
<c:import url="/WEB-INF/views/shared/admin.jsp"></c:import>
	<h1>Editar Estadística</h1>
	<sf:form method="post" action="${pageContext.request.contextPath}/evolucionUsuario/editarEvolucionUsuario" commandName="evolucionUsuario" cssClass="form-horizontal">
		<input name="fechaHidden" value="${fechaHidden }" type="hidden"/>
		<sf:input path="usuario.id" type="hidden"/>
		<sf:input path="id" type="hidden" />
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="Peso">Peso</label>
			<div class="col-md-4">
				<sf:input path="peso" type="number" min="0" class="form-control input-md"
					id="peso" placeholder="Peso del Usuario" />
					<sf:errors path="peso" class="text-danger"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="porcentajeGrasa">Porcentaje de Grasa Corporal </label>
			<div class="col-md-4">
				<sf:input path="porcentajeGrasa" type="number" min="0" max="100" class="form-control input-md"
					id="porcentajeGrasa" placeholder="Porcentaje de Grasa Corporal" />
					<sf:errors path="porcentajeGrasa" class="text-danger"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="porcentajeMusculo">Porcentaje de Músculo </label>
			<div class="col-md-4">
				<sf:input path="porcentajeMusculo" type="number" min="0" max="100" class="form-control input-md"
					id="porcentajeMusculo" placeholder="Porcentaje de Músculo" />
					<sf:errors path="porcentajeMusculo" class="text-danger"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="imc">Indice de Masa Corporal </label>
			<div class="col-md-4">
				<sf:input path="imc" type="number" min="0" class="form-control input-md"
					id="imc" placeholder="Indice de Masa Corporal" />
					<sf:errors path="imc" class="text-danger"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label"></label>
			<div>
				<input type="submit" value="Aceptar" class="btn btn-success">
				<a type="button" class="btn btn-warning" href='<c:url value="/evolucionUsuario/${evolucionUsuario.usuario.id}/index" />'>Cancelar</a>
			</div>
		</div>
		
	</sf:form>
</body>
</html>