<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Ingresar Al Sistema</h1>
	<hr>
	<c:if test="${param.error != null }">
		<span style="color:red;"> !Error !</span>
	</c:if>
	<form name='f' action="j_spring_security_check" method='POST'>
      <table>
         <tr>
            <td>Email:</td>
            <td><input type='text' name='email' value=''></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
         </tr>
         <tr>
            <td>Recordarme:</td>
            <td><input type='checkbox' name='_spring_security_remember_me' checked="checked" /></td>
         </tr>
         <tr>
            <td><input name="submit" type="submit" value="Aceptar" /></td>
         </tr>
      </table>
  </form>
</body>
</html>