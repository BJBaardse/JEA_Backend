<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<h2>Hello World!!</h2>
<h2>${helloMessage}</h2>

<h2>Geef het userid voor om de gebruiker te krijgen.</h2>
<form method="post" action="${pageContext.request.contextPath}/test">
    <input type="text" name="personid">
    <input type="submit" value="Login!" />
</form>
</body>
</html>