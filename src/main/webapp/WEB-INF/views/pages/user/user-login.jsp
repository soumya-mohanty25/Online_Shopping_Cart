<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file= "user-header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
     <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/logo.png">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
    
</head>
<body>

    <!-- Login Form -->
    <div class="login-container">
        <h2>Customer Login</h2>
        <form action="${pageContext.request.contextPath}/users/login" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <input type="submit" value="Login" class="submit-button">
            
            <!-- Forgot Password Link -->
            <div class="forgot-password">
                <a href="${pageContext.request.contextPath}/users/forgot-password">Forgot Password?</a>
                <p style="color: blue;"><a href="/users/registration">New to Shop?Please Register</a></p>
            </div>
        </form>

        <c:if test="${not empty errorMessage}">
            <p class="error">${errorMessage}</p>
        </c:if>

    </div>

<%@ include file= "user-footer.jsp" %>