<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8">
		<title>Тег FORM</title>
	</head>
	<body>
	<form action="${pageContext.request.contextPath}/api/login" method="POST">
		<label for="username">Логин:</label>
		<input type="text" id="username" name="username" required="required"><br><br>
		<label for="password">Пароль</label>
		<input type="text" id="password" name="password" required="required"><br><br>
		<input type="submit" value="Отправить">
	</form>

	<p>Не зарегистрированы? <b><a href="${pageContext.request.contextPath}/ui/signUp">🡺Зарегистрироваться🡸</a></b></p>

	</body>
</html>