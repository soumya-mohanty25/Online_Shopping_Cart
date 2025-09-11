<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

    <meta charset="UTF-8">
    <title>Edit Profile</title>

    <!-- Edit Profile Section -->
    <div class="edit-profile-container">
        <h2>Edit Profile</h2>
<form action="${pageContext.request.contextPath}/users/update-profile/${user.id}" method="post">
            
            <input type="hidden" name="id" value="${user.id}" />
            
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" value="${user.firstName}" required>
            
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" value="${user.lastName}" required>
            
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="${user.username}" required>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${user.email}" required>
            
            <label for="phoneNumber">Phone Number:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" value="${user.phoneNumber}" required>
            
            <label>Gender:</label>
            <select name="gender" required>
                <option value="Male" ${user.gender == 'Male' ? 'selected' : ''}>Male</option>
                <option value="Female" ${user.gender == 'Female' ? 'selected' : ''}>Female</option>
                <option value="Other" ${user.gender == 'Other' ? 'selected' : ''}>Other</option>
            </select>
            
            <label for="dateOfBirth">Date of Birth:</label>
            <input type="date" id="dateOfBirth" name="dateOfBirth" value="${user.dateOfBirth}" required>
            
            <input type="submit" value="Save Changes" class="submit-button">
        </form>
    </div>
