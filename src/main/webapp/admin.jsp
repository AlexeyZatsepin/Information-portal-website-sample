<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Admin page</title>
</head>
<body>
<p>Users:</p>
    <%--@elvariable id="users" type="java.util.List"--%>
    <c:forEach var="user" items="${users}">
        <p>Login: ${user.getUsername()}</p>
        <p>Password: ${user.getPassword()}</p>
        <p>Roles: ${user.getRoles()}</p><br>
    </c:forEach>
<p>Add user:</p>
    <form:form method="POST" modelAttribute="userForm" action="/admin/add/user">
        <spring:bind path="username">
                <form:input type="text" path="username" placeholder="Username" autofocus="true"/>
                <form:errors path="username"/>
        </spring:bind>

        <spring:bind path="password">
                <form:input type="password" path="password" placeholder="Password"/>
                <form:errors path="password"/>
        </spring:bind>

        <spring:bind path="passwordConfirm">
                <form:input type="password" path="passwordConfirm" placeholder="Confirm your password"/>
                <form:errors path="passwordConfirm"/>
        </spring:bind>
        <button type="submit">Submit</button>
    </form:form>
<p>Categories: </p>
    <%--@elvariable id="categories" type="java.util.List"--%>
    <c:forEach var="category" items="${categories}">
        <p>Id: ${category.getId()} Title: ${category.getTitle()}</p>
    </c:forEach>
<p>Add category: </p>
    <form:form method="POST" modelAttribute="categoryForm" action="/admin/add/category">
        <spring:bind path="title">
            <form:input type="text" path="title" placeholder="Title" autofocus="true"/>
            <form:errors path="title"/>
        </spring:bind>
        <button type="submit">Submit</button>
    </form:form>
<p>Articles: </p>
    <%--@elvariable id="articles" type="java.util.List"--%>
    <c:forEach var="article" items="${articles}">
        <p>${article}</p>
        <p>Translations: </p>
        <c:forEach var="trans" items="${article.getTranslations()}">
            <p>${trans}</p>
        </c:forEach>
        <p>Add translation:</p>
            <form:form method="POST" modelAttribute="translationForm" action="/admin/add/translation">
                <spring:bind path="title">
                    <form:input path="title" placeholder="Title" autofocus="true"/>
                    <form:errors path="title"/>
                </spring:bind>
                <spring:bind path="text">
                    <form:input path="text" placeholder="Text" autofocus="true"/>
                    <form:errors path="text"/>
                </spring:bind>
                <spring:bind path="locale">
                    <form:select path="locale" placeholder="Locale" autofocus="true" items="${languages}"/>
                    <form:errors path="locale"/>
                </spring:bind>
                <spring:bind path="article">
                    <form:hidden path="article" value="${article.getId()}"/>
                </spring:bind>
                <button type="submit">Submit</button>
            </form:form>
    </c:forEach>
<p>Add article:</p>
<form:form method="POST" modelAttribute="articleForm" action="/admin/add/article">
    <spring:bind path="category">
        <form:select path="category">
            <c:forEach var="category" items="${categories}">
                <form:option value="${category}">${category.getTitle()}</form:option>
            </c:forEach>
        </form:select>
    </spring:bind>
    <button type="submit">Submit</button>
</form:form>

</body>
</html>
