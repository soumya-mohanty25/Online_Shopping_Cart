<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file= "user-header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Shop Products</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shop.css">    
    
</head>
<body>
	
    <h2>Shop Products</h2>
    
    <div class="product-container">
        <c:forEach var="product" items="${products}">
            <div class="product-card">
                <img src="${product.imageUrl}" alt="${product.name}" width="150">
                <h3>${product.name}</h3>
                <p>${product.description}</p>
                <p><strong>Price:</strong> ₹${product.price}</p>
                <p><strong>Stock:</strong> ${product.stock} left</p>
                <form action="${pageContext.request.contextPath}/carts/add" method="post">
                   <input type="hidden" name="productId" value="${product.id}" >
                   <input type="hidden" name="quantity" value="1">
                   <button type="submit" class="add-btn">Add to Cart</button>
                 </form>
            </div>
        </c:forEach>
    </div>
<%@ include file= "user-footer.jsp" %>