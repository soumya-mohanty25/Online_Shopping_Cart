<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>	

<meta charset="UTF-8">
<title>my profile</title>
    <!-- Profile Section -->
    <div class="profile-container">
        <h2>My Profile</h2>
        <p><strong>First Name:</strong> ${user.firstName}</p>
        <p><strong>Last Name:</strong> ${user.lastName}</p>
        <p><strong>Username:</strong> ${user.username}</p>
        <p><strong>Email:</strong> ${user.email}</p>
        <p><strong>Phone Number:</strong> ${user.phoneNumber}</p>
        <p><strong>Gender:</strong> ${user.gender}</p>
        <p><strong>Date of Birth:</strong> ${user.dateOfBirth}</p>
        
        <a href="${pageContext.request.contextPath}/users/edit-profile/${user.id}">
           <button class="edit-button">Edit Profile</button>
        </a>
        <a href="${pageContext.request.contextPath}/users/logout">
           <button class="logout-button">Logout</button>
        </a>
     </div>
