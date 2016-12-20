<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.min.css" />'>
	<title>Evolución de usuario</title>
	
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    google.charts.load('current', {'packages':['line']});
    	google.charts.setOnLoadCallback(drawChart);
    	function drawChart() {
    		var data = new google.visualization.DataTable();
    		var data = google.visualization.arrayToDataTable([
    			['Fecha', 'Peso', 'Porcentaje Grasa', 'Porcentaje Músculo', 'IMC'],
    			<c:forEach items="${listEvolucionUsuario}" var="evolucionUsuario">
    				['<c:out value="${evolucionUsuario.getFecha()}"/> ', 
    					<c:out value="${evolucionUsuario.getPeso()}"/>,
    					<c:out value="${evolucionUsuario.getPorcentajeGrasa()}"/>,
    					<c:out value="${evolucionUsuario.getPorcentajeMusculo()}"/>,
    					<c:out value="${evolucionUsuario.getImc()}"/>
   					],
    			</c:forEach>
    			]);
    		
            var options = {
                    title: 'Gimnasio',
                    curveType: 'function',
                    legend: { position: 'bottom' }
                  };

    		
    		var chart = new google.charts.Line(document.getElementById('linechart_material'));
    		
    		chart.draw(data, options);

    	}
   	</script>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="collapse navbar-collapse">
		  		<ul class="nav navbar-nav">
		  			<li role="presentation"><a href='<c:url value="/cliente/index" />'>Rutina</a></li>
		  			<li role="presentation"><a href='<c:url value="/cliente/${usuario.getId()}/evolucion" />'>Estadísticas</a></li>
				</ul>
				<a class="navbar-brand navbar-right" role="button" href='<c:url value="/logout"/>'>Salir ${usuario.getNombre()} </a>
			</div>
		</div>
	</div>
	<br>
	<br>
<h1>Evolución de Usuario</h1>
<hr>
	<div id="linechart_material" style="width: 900px; height: 500px"></div>
	<a type="button" class="btn btn-info" href='<c:url value="/cliente/index" />'>Volver</a>
</body>