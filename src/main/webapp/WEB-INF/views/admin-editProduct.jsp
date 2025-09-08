<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file= "admin-header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Product</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/add-product.css"> 
</head>
<body>
<div class = "manage-product">
    <h2>Edit Product</h2>
    <form action="${pageContext.request.contextPath}/products/update/${product.id}" method="post">
        <input type="hidden" name="id" value="${product.id}">
        
        <label>Name:</label>
        <input type="text" name="name" value="${product.name}" required><br>
        
        <label>Category:</label>
        <input type="text" name="category" value="${product.category}" required><br>
        
        <label>Price:</label>
        <input type="number" step="0.01" name="price" value="${product.price}" required><br>
        
        <label>Description:</label>
        <textarea name="description" required>${product.description}</textarea><br>
        
        <label>Stock:</label>
        <input type="number" name="stock" value="${product.stock}" required><br>
        
        <label>Image URL:</label>
        <input type="text" name="imageUrl" value="${product.imageUrl}" required><br>
        
        <button type="submit">Update Product</button>
        <a href="${pageContext.request.contextPath}/products/manage-product">Cancel</a>
    </form>
 </div>
<%@ include file= "admin-footer.jsp" %>
