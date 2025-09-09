<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <!-- Header Section -->
    <head>
             <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/logo.png">
    
    </head>
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
            <a href="${pageContext.request.contextPath}/admins/registration">
                <button class="register-button">👨‍💼Register</button>
            </a>
        </div>
    </header>
    
    <!-- Navigation Bar -->
    <nav class="nav-bar">
        <ul>
            <li><a href="/admins/dashboard">Home</a></li>
            <li><a href="/products/manage">Manage Products</a></li>
            <li><a href="manage-orders.jsp">Manage Orders</a></li>
            <li><a href="manage-Customers.jsp">Manage Customers</a></li>
            <li><a href="manage-payments.jsp">Manage Payments</a></li>
            <li><a href="logout.jsp">Logout</a></li>
        </ul>
    </nav>