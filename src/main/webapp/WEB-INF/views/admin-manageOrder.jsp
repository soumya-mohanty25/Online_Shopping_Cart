<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file= "admin-header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Manage Orders</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles2.css">
</head>
<body>
<main class="content-wrapper">
    <h2>Manage Customer Orders</h2>
    
    <c:if test="${not empty orders}">
        <table class="order-table">
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>User</th>
                    
                    <th>Total Price</th>
                    <th>Status</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${orders}">
                    <tr>
                        <td>${order.id}</td>
                        <td>${order.customer.fullName}</td>
                       
                        <td>₹ ${order.totalAmount}</td>
                        <td>
                            <form method="post" action="/orders/update-status">
                                <input type="hidden" name="orderId" value="${order.id}" />
                                <select name="status">
                                    <option ${order.status == 'Pending' ? 'selected' : ''}>Pending</option>
                                    <option ${order.status == 'Packed' ? 'selected' : ''}>Packed</option>
                                    <option ${order.status == 'Shipped' ? 'selected' : ''}>Shipped</option>
                                    <option ${order.status == 'Out for Delivery' ? 'selected' : ''}>Out for Delivery</option>
                                    <option ${order.status == 'Delivered' ? 'selected' : ''}>Delivered</option>
                                    <option ${order.status == 'Cancelled' ? 'selected' : ''}>Cancelled</option>
                                </select>
                                <button type="submit">Update</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty orders}">
        <p>No orders found.</p>
    </c:if>
</main>
<%@ include file= "admin-footer.jsp" %>
