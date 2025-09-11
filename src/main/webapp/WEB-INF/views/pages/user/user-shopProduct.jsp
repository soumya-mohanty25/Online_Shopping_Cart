<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

    <h2 style ="color: #c1feff">Shop Products</h2>
    
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
