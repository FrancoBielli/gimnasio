<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Redireccionar</title>
</head>
<body>
	<sec:authorize access="hasRole('ROLE_USER')">
		<c:redirect url='cliente/index' ></c:redirect>
		USUARIO
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<c:redirect url='usuario/index' ></c:redirect>
	</sec:authorize>

</body>
</html>
