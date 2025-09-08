<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file= "admin-header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>manage product</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css"> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/add-product.css"> 
</head>
<body>

<div class = "manage-product">
    <h2>Manage Products</h2>
    <!-- Add New Product Form -->
    <form action="${pageContext.request.contextPath}/products/add" method="post">
    
        <label for="name">Product Name:</label>
        <input type="text" name="name" placeholder="Product Name" required><br>
        
        <label for="category">Category:</label>
        <input type="text" name="category" placeholder="Category" required><br>
        
        <label for="price">Price:</label>
        <input type="number" name="price" placeholder="Price" step="0.01" required><br>
        
        <label for="description">Description:</label>
        <textarea name="description" placeholder="Description" required></textarea><br>

        <label for="stock">Stock:</label>
        <input type="number" name="stock" placeholder="Stock" required><br>
        
        <label for="imageUrl">Image URL:</label>
        <input type="text" name="imageUrl" placeholder="Image URL" required><br>
        
        <button type="submit" class="submit-button">Add Product</button>
        
    </form> 
    
    <a href="${pageContext.request.contextPath}/products/list">
           <button type="submit" value="productlist" class="list-button">Show List</button>
    </a>
  </div>  
  
<%@ include file= "admin-footer.jsp" %>
    
