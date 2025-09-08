<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file= "user-header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Address</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/add-address.css">
</head>
<body>

<div class= "form-container">
    <h2>Add New Address</h2>
    
    <form action="${pageContext.request.contextPath}/users/save-address" method="post">
        <label>Street:</label>
        <input type="text" name="street" required><br>
        
        <label>City:</label>
        <input type="text" name="city" required><br>
        
        <label>Landmark:</label>
        <input type="text" name="landmark" required><br>

        <label>State:</label>
        <input type="text" name="state" required><br>

        <label>Pin Code:</label>
        <input type="text" name="pinCode" required><br>

        <label>Country:</label>
        <input type="text" name="country" required><br>

        <button type="submit">Save Address</button>
    </form>

    <br>
    <a href="${pageContext.request.contextPath}/users/addresses">Back to Addresses</a>
  </div>  

<%@ include file= "user-footer.jsp" %>
