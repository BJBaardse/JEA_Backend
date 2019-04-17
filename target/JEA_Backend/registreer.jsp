<%--
  Created by IntelliJ IDEA.
  User: Joey
  Date: 14-3-2019
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Op deze pagina kan worden ingelogd</title>
    <form method="post" action="${pageContext.request.contextPath}/login">
        <input type="text" name="username" placeholder="username">
        <input type="password" name="password" placeholder="password">
        <input type="submit" value="Login!" />
    </form>
</head>
<body>

</body>
</html>
