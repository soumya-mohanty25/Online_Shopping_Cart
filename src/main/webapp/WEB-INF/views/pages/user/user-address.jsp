<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file= "user-header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Address</title>
             <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/logo.png">
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/address.css">  
    
</head>
<body>


    <div class="heading-box">
    <h2>Manage Your Addresses</h2>
    </div>

    <c:choose>
        <c:when test="${empty addresses}">
          <p style= "color:white;">No address found. </p>
          <div><a href="${pageContext.request.contextPath}/users/add-address"><button class="add-button">Add Address</button></a></div>  
        </c:when>
        <c:otherwise>
            <table border="1">
                <tr>
                    <th>Street</th>
                    <th>City</th>
                    <th>Landmark</th>
                    <th>State</th>
                    <th>Pin Code</th>
                    <th>Country</th>
                    <th>Actions</th>
                </tr>
                <c:forEach var="address" items="${addresses}">
                    <tr>
                        <td>${address.street}</td>
                        <td>${address.city}</td>
                        <td>${address.landmark}</td>
                        <td>${address.state}</td>
                        <td>${address.pinCode}</td>
                        <td>${address.country}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/users/edit-address/${address.id}">Edit</a> |
                            <a href="${pageContext.request.contextPath}/users/delete-address/${address.id}" onclick="return confirm('Are you sure?')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <a href="${pageContext.request.contextPath}/users/add-address">
                <button class="address-button">Add New Address</button>
            </a>
        </c:otherwise>
    </c:choose>
<!-- Footer -->
     <div class="foot">
        <p style="color: white;">&copy; 2025<a style="color: white; text-decoration: none;" href="https://r.search.yahoo.com/_ylt=AwrKAwt5KgZoOQIA_1W7HAx.;_ylu=Y29sbwNzZzMEcG9zAzEEdnRpZAMEc2VjA3Ny/RV=2/RE=1746444153/RO=10/RU=https%3a%2f%2fwww.aashditnutritech.com%2f/RK=2/RS=ytwGym55WBZ5FFMKmYO_MC6i2Gg-">   Aashdit Nutritech</a>. All rights reserved.</p>
    </div>
   </body>
</html>