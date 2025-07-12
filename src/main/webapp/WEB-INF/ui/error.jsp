<%--
  Created by IntelliJ IDEA.
  User: slavs
  Date: 12.07.2025
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>⚠️ Error</title>
</head>

<body>

<h1 style="text-align: center;">🚨 Something went wrong</h1>

<p style="text-align: center;">
    Your request couldn't be completed.
</p>

<hr>

<h2>Error Details:</h2>
<p>${errMsg}</p>

<hr>

<p>That's all we know.</p>

<p>
    🔙 <a href="<%= request.getContextPath() %>/api/user">Return to the main page</a>
</p>

</body>

</html>
