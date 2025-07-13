<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>📊 Stats</title>
</head>
<body>

<h1>📊 Статистика приложения</h1>
<hr/>

<h2>Пользователи</h2>
<ul>
    <li><strong>Всего зарегистрировано пользователей:</strong> ${userCount}</li>
    <li><strong>Сейчас активно пользователей:</strong> ${activeUserCount}</li>
</ul>

<h2>Сообщения</h2>
<ul>
    <li><strong>Всего сообщений отправлено:</strong> ${messageCount}</li>
</ul>

<hr/>
<p><strong>Отчёт от:</strong> <%= new java.util.Date() %></p>

</body>
</html>
