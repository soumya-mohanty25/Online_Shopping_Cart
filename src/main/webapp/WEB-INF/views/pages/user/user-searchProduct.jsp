<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file= "user-header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Search Results - ${searchKeyword}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    
</head>
<body>

    <h2>Search Results for "<span style="color:#e91e63">${searchKeyword}</span>"</h2>

    <c:if test="${empty products}">
        <p>No products found for "<b>${searchKeyword}</b>".</p>
    </c:if>

    <div class="product-grid">
        <c:forEach var="product" items="${products}">
            <div class="product-card">
                <img src="${product.imageUrl}" alt="${product.name}" class="product-img"/>
                <h3>${product.name}</h3>
                <p>${product.description}</p>
                <p><strong>Price:</strong> ₹${product.price}</p>
                <p><strong>Category:</strong> ${product.category}</p>

                <form action="${pageContext.request.contextPath}/carts/add" method="post">
                   <input type="hidden" name="productId" value="${product.id}" >
                   <input type="hidden" name="quantity" value="1">
                   <button type="submit" class="add-btn">Add to Cart</button>
                 </form>
            </div>
        </c:forEach>
    </div>
    
<%@ include file= "user-footer.jsp" %>