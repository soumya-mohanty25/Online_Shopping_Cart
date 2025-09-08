<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file= "user-header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Choose Your Address</title>
     <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/logo.png">
    
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/choose.css">
    
    
</head>
<body>


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

<%@ include file="user-footer.jsp" %>