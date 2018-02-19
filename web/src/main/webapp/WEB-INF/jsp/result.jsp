<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<c:forEach var="movie" items="${requestScope.movies}">
    <p>${movie.title} ${movie.createYear} ${movie.country.getName()} ${movie.director.fullName.firstName} ${movie.director.fullName.lastName}
        <c:forEach var="genre" items="${movie.genres}">
            ${genre.getName()}
        </c:forEach>
    </p>
</c:forEach>
<c:forEach var="page" begin="1" end="${requestScope.pages}" step="1">
    <a href="${pageContext.request.contextPath}/result?page=${page}">${page}</a>
</c:forEach>
</body>
</html>
