<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1 style="text-align: center">Добро пожаловать!</h1>
<p style="text-align: center">Пожалуйста <b><a href="${pageContext.request.contextPath}/ui/signIn">🡺Войдите🡸</a></b> или
    <b><a href="${pageContext.request.contextPath}/ui/signUp">🡺Зарегестрируйтесь🡸</a></b> что-бы продолжить</p>
</body>
</html>
