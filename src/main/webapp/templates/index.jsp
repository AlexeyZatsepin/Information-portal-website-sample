<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title><spring:message code="title"/></title>
</head>
<body>
<p>Hello, ${name}</p>
<p>${text}</p>
</body>
</html>