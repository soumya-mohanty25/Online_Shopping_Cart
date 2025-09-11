<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

    <meta charset="UTF-8">
    <title>Manage Address</title> 
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