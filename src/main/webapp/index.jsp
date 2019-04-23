<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users CRUD</title>
    <style>
        <%@include file="/WEB-INF/style.css" %>
    </style>
</head>
<body>
<table class="main">
    <tr>
        <td class="main-td">
            <c:url value="/create" var="createUrl"/>
            <form action="${createUrl}" method="post">
                <table class="first" id="users">
                    <caption>Work with users</caption>
                    <c:if test="${user.id ne null}">
                        <tr>
                            <td>User ID</td>
                            <td>
                                <label>
                                    <input type="number" name="id" value="${user.id}" readonly="readonly">
                                </label>
                            </td>
                        </tr>
                    </c:if>
                    <tr>
                        <td>Login</td>
                        <td>
                            <label>
                                <input type="text" name="login" value="${user.login}" required>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td>
                            <label>
                                <input type="text" name="password" value="${user.password}" required>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>Age</td>
                        <td>
                            <label>
                                <input type="number" min="16" name="age" value="${user.age}" required>
                            </label>
                        </td>
                    </tr>
                    <c:if test="${user.id ne null}">
                        <tr>
                            <td colspan="2"><input type="submit" class="button" value="Update User"></td>
                        </tr>
                    </c:if>
                    <c:if test="${user.id eq null}">
                        <tr>
                            <td colspan="2"><input type="submit" class="button" value="Add user"></td>
                        </tr>
                    </c:if>
                </table>
            </form>
        </td>
        <td class="main-table">
            <table class="second">
                <caption>List of users</caption>
                <tr>
                    <th>ID</th>
                    <th>Login</th>
                    <th>Password</th>
                    <th>Age</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
                <c:forEach items="${userslist}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.age}</td>
                        <td>${user.course}</td>
                        <td>${user.speciality}</td>
                        <td>
                            <form action="<c:url value="/update"/>" method="post">
                                <input type="hidden" name="id" value="${user.id}">
                                <input class="button" type="submit" value="Update">
                            </form>
                        </td>
                        <td>
                            <form action="<c:url value="/delete"/>" method="post">
                                <input type="hidden" name="id" value="${user.id}">
                                <input class="button-delete" type="submit" value="Delete">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
