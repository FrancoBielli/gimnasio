<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.min.css" />'>
	<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.css" />'>
	<script type="text/javascript" src='<c:url value="/resources/js/jquery-3.1.1.min.js" />'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/jquery-3.1.1.js" />'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/bootstrap.js" />'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/bootstrap.min.js" />'></script>
<div class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand"	href='<c:url value="/usuario/index" />'>Usuarios</a>
			<a class="navbar-brand"	href='<c:url value="/grupoMuscular/index" />'>Grupos Musculares</a>
			<a class="navbar-brand"	href='<c:url value="/ejercicio/index" />'>Ejercicios</a>
			<a class="navbar-brand" href='<c:url value="/rutina/index" />'>Rutinas</a>
		</div>
		<div class="navbar-right">
			<a class="navbar-brand" href='#'><c:out value="${usuario.getNombre() }"/></a> 
			<a class="navbar-brand" href='<c:url value="/logout" />'>Salir</a>
		</div>
		
	</div>
</div>