<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    				['<fmt:formatDate pattern="dd-MM-yyyy" value="${evolucionUsuario.getFecha()}" />', 
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
	<c:import url="/WEB-INF/views/shared/cliente.jsp"></c:import>
	<h1>Evolución de Usuario</h1>
	<hr>
	<div id="linechart_material" style="width: 900px; height: 500px"></div>
	
	<hr>
	<h2>Datos del gráfico</h2>
	<div>
		<table class="table table-striped">
			<tr>
				<th>Fecha</th>
				<th>Peso</th>
				<th>Porcentaje de músculo</th>
				<th>Porcentaje de grasa</th>
				<th>Índice de Masa Corporal</th>
			</tr>
			<c:forEach items="${listEvolucionUsuario}" var="evolucionUsuario">
				<tr>
					<td>
						<fmt:formatDate pattern="dd-MM-yyyy" value="${evolucionUsuario.getFecha()}" />
					</td>
					<td>
						<c:out value="${evolucionUsuario.getPeso() }"/>
					</td>
					<td>
						<c:out value="${evolucionUsuario.getPorcentajeMusculo() }"/>
					</td>
					<td>
						<c:out value="${evolucionUsuario.getPorcentajeGrasa() }"/>
					</td>
					<td>
						<c:out value="${evolucionUsuario.getImc() }"/>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</body>