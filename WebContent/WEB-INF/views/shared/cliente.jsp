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
			<a class="navbar-brand" href='<c:url value="/cliente/index" />'>Rutinas</a>
			<a class="navbar-brand"
				href='<c:url value="/cliente/${usuario.getId() }/evolucion" />'>Estadísticas</a>
		</div>
		<div class="navbar-right">
			<a class="navbar-brand" href='<c:url value="/logout" />'>Salir</a>
		</div>
		
	</div>
</div>