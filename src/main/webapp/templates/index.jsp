<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title><spring:message code="title"/></title>
</head>
<body>
<p>Hello, ${name}</p>
<p>${text}</p>
<h1>
      Hello <b><c:out value="${pageContext.request.remoteUser}"></c:out></b>
     </h1>
 <form action="/logout" method="post">
      <input type="submit" class="button red big" value="Sign Out" /> <input
           type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
     </form>
</body>
</html>