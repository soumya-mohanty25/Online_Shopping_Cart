<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

    <title>Shopping Cart</title>
    
   <!-- Cart Section -->
  <main class="cart-container">
    <h2>Shopping Cart</h2>
    <c:choose>
        <c:when test="${not empty cart and not empty cart.cartItems}">
            <table class="cart-table">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Stock</th>
                        <th>Quantity</th>
                        <th>Total</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${cart.cartItems}">
                        <tr>
                            <td><img src="${item.product.imageUrl}" alt="${item.product.name}" width="80" height="80"></td>
                            <td>${item.product.name}</td>
                            <td>₹${item.product.price}</td>
                            <td>${item.product.stock}</td>
                            <td>
                                <form action="/carts/updateQuantity" method="post">
                                        <input type="hidden" name="cartItemId" value="${item.id}">
                                        <input type="number" name="quantity" value="${item.quantity}" min="1" max="${item.product.stock}">
                                        <button type="submit">Update</button>
                                </form>
                            </td>
                            <td>₹${item.product.price * item.quantity}</td>
                            <td>
                                <form action="/carts/remove" method="post">
                                    <input type="hidden" name="productId" value="${item.product.id}">
                                    <button type="submit" class="remove-btn">Remove</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <!-- Place Order Button -->
            <form action="/carts/checkout" method="post">
                <button type="submit" class="place-order-btn">Place Order</button>
            </form>
        </c:when>
        <c:otherwise>
            <p class="empty-cart-msg">Your cart is empty.</p>
            <a href="${pageContext.request.contextPath}/products/shop" class="continue-shopping">⬅️ Continue Shopping</a>
        </c:otherwise>
    </c:choose>
</main>