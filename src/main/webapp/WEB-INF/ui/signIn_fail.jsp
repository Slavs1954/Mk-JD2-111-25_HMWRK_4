<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Login failed</title>
</head>
<body>
<h1>Неверные данные</h1>

<p>
    Ваш логин или пароль неверны, пожалуйста попробуйте снова
</p>
🔙 <a href="${pageContext.request.contextPath}/ui/signIn">Вернутся</a>
</body>
</html>
