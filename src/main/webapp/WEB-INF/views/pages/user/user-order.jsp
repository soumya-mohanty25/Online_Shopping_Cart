<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

    <title>Your Orders</title>

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