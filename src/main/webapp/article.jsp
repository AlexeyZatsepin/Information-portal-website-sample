<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${article.getTitle()}</title>
</head>
<body>
<p>${article.getText()}</p>
<p>${article.getCreationStamp()}</p>
</body>
</html>
