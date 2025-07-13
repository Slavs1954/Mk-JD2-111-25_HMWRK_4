<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Messages</title>
</head>
<body>
<h1 style="text-align: center">Ваши сообщения</h1>
<p style="text-align: center">Желаете <a href="${pageContext.request.contextPath}/ui/user/message">отправить</a> сообщение?</p><br>
<ul>
  <c:forEach items="${messages}" var="message">
    <li> ==========================
      <ul>
        <li>От: ${message.sender}</li>
        <li>Кому: ${message.receiver}</li>
        <li>Сообщение: ${message.message}</li>
        <li>Отправлено: ${message.dtSend}</li>
      </ul>
    </li>
  </c:forEach>
</ul>
</body>
</html>
