<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.min.css" />'>
</head>
<body>
<div class="container">
	<h1>Ingresar Al Sistema</h1>
	<hr>
	<c:if test="${param.error != null }">
		<span style="color:red;"> !Error !</span>
	</c:if>
	<form name='f' action="j_spring_security_check" method='POST' class="form form-inline">
		<div class="form-group">
		    <label for="Email">Email:</label>
		    <input type='text' class="form-control" name='email' value=''>
		</div>
		<div class="form-group">
		    <label for="password">Contraseña:</label>
		    <input type='password' class="form-control" name='password' value=''>
		</div>
		<div class="form-check">
		    <label class="form-check-label">
		      <input class="form-check-input" name='_spring_security_remember_me' type="checkbox" checked="checked"> Recordarme
		    </label>
		  </div>
		<div class="form-group col-md-12">  
            <input name="submit" class="btn btn-primary" type="submit" value="Aceptar" />
         </div>
      
  </form>
  </div>
</body>
</html>