<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

    <meta charset="UTF-8">
    <title>Choose Your Address</title>

<h2>Choose a Delivery Address</h2>

<form action="${pageContext.request.contextPath}/orders/select-address" method="post">
    <input type="hidden" name="orderId" value="${orderId}" />

    <c:forEach var="address" items="${addresses}">
        <div>
            <input type="radio" name="addressId" value="${address.id}" id="address-${address.id}" />
            <label for="address-${address.id}">
                ${address.street}, ${address.city}, ${address.landmark}, ${address.state}, ${address.pinCode}, ${address.country}
            </label>
        </div>
    </c:forEach>

    <button type="submit">Confirm Address</button>
</form>