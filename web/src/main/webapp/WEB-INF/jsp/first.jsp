
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>First page</title>
</head>
<body>
${requestScope.person.fullName.firstName} ${requestScope.person.fullName.lastName}
${requestScope.person.dateOfBirth}
${requestScope.person.country.name}

</body>
</html>
