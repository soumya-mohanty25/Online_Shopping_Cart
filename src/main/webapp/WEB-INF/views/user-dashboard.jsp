<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Dashboard</title>
         <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/logo.png">
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">    
</head>
<body>

<!-- Header Section -->
    <header class="header">
        <div class="header-left">
            <img src="${pageContext.request.contextPath}/images/logo.png" alt="Logo" class="header-logo">
            <h1>AASHDIT CART</h1>
        </div>

        <form action="${pageContext.request.contextPath}/products/search" method="get" class="search-container">
             <img src="${pageContext.request.contextPath}/images/logo.png" alt="Search Logo" class="search-logo">
             <input type="text" name="keyword" placeholder="Search..." required />
             <button type="submit" class="search-container-button">🔍</button>
        </form>

        <div class="header-right">
            <a href="${pageContext.request.contextPath}/carts/view">
            <button class="cart-button">🛒 Cart</button>
            </a>
            <a href="${pageContext.request.contextPath}/users/registration">
                <button class="register-button">👨‍💼Register</button>
            </a>
        </div>
    </header>

    <!-- Navigation Bar -->
    <nav class="nav-bar">
        <ul>
            <li><a href="/users/dashboard">Home</a></li>
            <li><a href="/products/shop">Shop Products</a></li>
            <li><a href="/users/addresses">Manage Address</a></li>
            <li><a href="/orders/view">Your Order</a></li>
            <li><a href="/users/profile">My Profile</a></li>
            <li><a href="/users/contactus">Contact Us</a></li>
        </ul>
    </nav>
    

   <!-- Main Content -->
<main class="main-content">
    <div class="welcome-box">
        <h1 style="text-transform:uppercase">WELCOME, MR. ${sessionScope.username} 👋</h1>
        <p>Manage your orders and shop for products.</p>
    </div>
    
</main>

<%@ include file="user-footer.jsp" %>
