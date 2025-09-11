<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<meta charset="UTF-8">
<title>Customer Registration</title>

    <!-- Registration Form -->
    <div class="registration-container">				
        <h2>Customer Registration</h2>
        <form action="${pageContext.request.contextPath}/users/register" method="post">
            
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" required>
            
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" required>
            
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            
            <label>Gender:</label>
            <select name="gender" required>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
            </select>     
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            
            <label for="phoneNumber">Phone Number:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" required>
            
            <label for="dateOfBirth">Date of Birth:</label>
            <input type="date" id="dateOfBirth" name="dateOfBirth" required>

            <!-- Submit Button -->
            <input type="submit" value="Register" class="submit-button">
        </form>

        <c:if test="${not empty errorMessage}">
            <p class="error">${errorMessage}</p>
        </c:if>
    </div>