<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>First page</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/result" method="post">
    <p>Название фильма:</p>
    <input type="text" maxlength="250" name="title"><br>
    <p>Год:</p>
    <input type=number maxlength="250" name="year"><br>

    <select name="countries">
        <option></option>
        <c:forEach var="country" items="${requestScope.countries}">
            <option value="${country}">${country.getName()}</option>
        </c:forEach>
    </select>

    <button type="submit">Поиск</button>
</form>
</body>
</html>


