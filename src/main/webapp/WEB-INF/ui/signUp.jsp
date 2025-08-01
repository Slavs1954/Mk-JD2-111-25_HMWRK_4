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
    <c:if test="${not empty errMsg}">
        <div style="color: red">
            <pre>${errMsg}</pre>
        </div>
    </c:if>
        <form action="${pageContext.request.contextPath}/api/user" method="POST">
            <label for="username">Логин:</label>
            <input type="text" id="username" name="username" required="required"><br><br>
            <label for="password">Пароль</label>
            <input type="text" id="password" name="password" required="required"><br><br>
            <label for="fullName">ФИО</label>
            <input type="text" id="fullName" name="fullName"><br><br>
            <label for="dtBirth">Дата рождения</label>
            <input type="date" id="dtBirth" name="dtBirth"><br><br>
            <input type="submit" value="Зарегистрироваться">
        </form>

        <p>Уже зарегистрированы? <b><a href="${pageContext.request.contextPath}/ui/signIn">🡺Войти🡸</a></b></p>

	</body>
</html>