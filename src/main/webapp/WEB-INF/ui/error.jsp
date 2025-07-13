<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>⚠️ Error</title>
</head>

<body>

<h1 style="text-align: center;">🚨 Что-то пошло не так</h1>

<p style="text-align: center;">
    Ваш запрос не мог быть обработан.
</p>

<hr>

<h2>Error Details:</h2>
<p>${errMsg}</p>

<hr>

<p>Это всё что известно.</p>

<p>
    🔙 <a href="${pageContext.request.contextPath}/ui">Вернуться на главную страницу</a>
</p>

</body>

</html>
