<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Sending...</title>
</head>
<body>
<h1>Отправить сообщение</h1>
<p>Желаете <a href="${pageContext.request.contextPath}/ui/user/chats">посмотреть</a> свои сообщения?</p>
<form action="${pageContext.request.contextPath}/api/message" method="POST">
    <label for="receiver">Получатель:</label>
    <select id="receiver" name="receiver" required="required">
        <c:forEach items="${receivers}" var="receiver">
            <option>${receiver}</option>
        </c:forEach>
    </select> <br><br>
    <label for="message">Текст:</label>
    <input type="text" id="message" name="message"><br><br>
    <input type="submit" value="Отправить">
</form>
</body>
</html>
