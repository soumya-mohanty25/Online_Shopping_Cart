<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <head>
         <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/logo.png">
    </head>
    <header class="header">
        <div class="header-left">
		    <img src="${pageContext.request.contextPath}/images/logo.png" alt="Logo" class="header-logo">
		    <div class="branding-text">
		        <h1 class="site-title">Verdant Roots</h1>
		        <p class="tagline">Nature at Your Doorstep</p>
		    </div>
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