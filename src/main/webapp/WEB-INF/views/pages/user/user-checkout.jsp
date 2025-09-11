<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

    <title>Checkout</title>
    <h2>Order Summary</h2>
        
    <table class="checkout-table">
        <thead>
            <tr>
                <th>Product</th>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
            </tr>
        </thead>
        <tbody>
            <c:set var="grandTotal" value="0" />
            <c:forEach var="item" items="${cart.cartItems}">
                <tr>
                    <td><img src="${item.product.imageUrl}" alt="${item.product.name}" width="80" height="80"></td>
                    <td>${item.product.name}</td>
                    <td>₹${item.product.price}</td>
                    <td>${item.quantity}</td>
                    <td>₹<c:set var="total" value="${item.product.price * item.quantity}" />${total}</td>
                    <c:set var="grandTotal" value="${grandTotal + total}" />
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h3>Total Amount: ₹${grandTotal}</h3>

    <!-- Confirm Order Button -->
    <form action="/orders/place" method="post">
        <button type="submit" class="confirm-order-btn">Confirm Order</button>
    </form>