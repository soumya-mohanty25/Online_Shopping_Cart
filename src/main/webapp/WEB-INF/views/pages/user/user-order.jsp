<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Your Orders</title>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/logo.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/order.css">
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

<main class="order-container">
    <h2>Your Orders</h2>
    <c:choose>
        <c:when test="${not empty orders}">
            <table class="order-table">
                <thead>
                    <tr>
                        <th>Image</th>
                        <th>Product Name</th>
                        <th>Price (Each)</th>
                        <th>Quantity</th>
                        <th>Total (Item)</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="order" items="${orders}">
                        <tr>
                            <td colspan="6" style="background: #f5f5f5;">
                                <h3>Status: ${order.status}</h3>
                            </td>
                        </tr>

                        <c:set var="orderTotal" value="0" scope="page" />
                        <c:forEach var="item" items="${order.orderItems}">
                            <c:set var="itemTotal" value="${item.price}" />
                            <c:set var="orderTotal" value="${orderTotal + itemTotal}" scope="page" />

                            <tr>
                                <td><img src="${item.product.imageUrl}" alt="${item.product.name}" width="80" height="80"></td>
                                <td>${item.product.name}</td>
                                <td>₹<fmt:formatNumber value="${item.product.price}" type="currency" currencySymbol=""/></td>
                                <td>${item.quantity}</td>
                                <td>₹<fmt:formatNumber value="${itemTotal}" type="currency" currencySymbol=""/></td>
                                <td>${order.status}</td>
                            </tr>
                        </c:forEach>

                        <!-- Show Order Total -->
                        <tr>
                            <td colspan="6" style="text-align:right; font-weight:bold; background: #f0f0f0;">
                                Total Amount: ₹<fmt:formatNumber value="${orderTotal}" type="currency" currencySymbol=""/>
                            </td>
                        </tr>

                        <!-- Buttons at bottom -->
                        <tr>
                            <td colspan="6" style="text-align:right;">
                                <form action="/orders/remove-item" method="post" style="display:inline;" >
                                    <input type="hidden" name="orderId" value="${order.id}">
                                    <button type="submit" class="remove-btn">Remove Order</button>
                                </form>
                                <form action="/orders/proceed" method="post" style="display:inline;">
                                    <input type="hidden" name="orderId" value="${order.id}">
                                    <button type="submit" class="proceed-btn">Proceed to Payment</button>
                                </form>
                                <form action="/orders/choose-address" method="post" style="display:inline;">
                                    <input type="hidden" name="orderId" value="${order.id}">
                                    <button type="submit" class="proceed-btn">Choose location</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p class="empty-order-msg">You have no orders.</p>
            <a href="${pageContext.request.contextPath}/products/shop" class="shop-now-btn">Shop Now</a>
        </c:otherwise>
    </c:choose>
</main>

<%@ include file="user-footer.jsp" %>
