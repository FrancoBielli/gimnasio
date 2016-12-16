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
	<h1>Ejercicios de la Rutina</h1>
	
	<div>
		<table>
			<tr>
				<th>Rutina</th>
				<th>Dias</th>
				<th>Ejercicios por día</th>
			</tr>
			<tr>
				<th> <c:out value="${rutina.getNombre}"/></th>
				<th> <c:out value="${totalDias}"/></th>
				<th> <c:out value="${ejercicios }"/></th>
			</tr>
		</table>
	</div>
</body>