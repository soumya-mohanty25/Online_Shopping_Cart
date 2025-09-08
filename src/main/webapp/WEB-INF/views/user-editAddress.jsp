<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file= "user-header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Address</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/add-address.css">
</head>
<body>

    <div class="form-container">
    <h2>Edit Address</h2>
    
    <form action="${pageContext.request.contextPath}/users/update-address" method="post">
        <input type="hidden" name="id" value="${address.id}">
        
        <label>Street:</label>
        <input type="text" name="street" value="${address.street}" required><br>
        
        <label>City:</label>
        <input type="text" name="city" value="${address.city}" required><br>
        
        <label>Landmark:</label>
        <input type="text" name="landmark" value= "${address.landmark}" required><br>

        <label>State:</label>
        <input type="text" name="state" value="${address.state}" required><br>

        <label>Pin Code:</label>
        <input type="text" name="pinCode" value="${address.pinCode}" required><br>

        <label>Country:</label>
        <input type="text" name="country" value="${address.country}" required><br>

        <button type="submit">Update Address</button>
    </form>

    <br>
    <a href="${pageContext.request.contextPath}/users/addresses">Back to Addresses</a>
    
    </div>
<%@ include file= "user-footer.jsp" %>
