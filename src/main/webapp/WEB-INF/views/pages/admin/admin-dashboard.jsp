<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<jsp:include page="admin-header.jsp" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Dashboard</title>
         <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/logo.png">

<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">    
</head>
<body>

     <!-- Header Section -->
    <header class="header">
        <div class="header-left">
            <img src="${pageContext.request.contextPath}/images/logo.png" alt="Logo" class="header-logo">
            <h1>AASHDIT CART</h1>
        </div>

        <form action="${pageContext.request.contextPath}/products/search" method="get" class="search-container">
             <img src="${pageContext.request.contextPath}/images/logo.png" alt="Search Logo" class="search-logo">
             <input type="text" name="keyword" placeholder="Search..." required />
             <button type="submit" class="search-container-button">🔍</button>
        </form>

        <div class="header-right">
            <a href="${pageContext.request.contextPath}/admins/registration">
                <button class="register-button">👨‍💼Register</button>
            </a>
        </div>
    </header> --%>
    
    <main class="main-content">
        <div class="welcome-box">
            <h2>Welcome, Admin</h2>
            <p>Manage your e-commerce platform efficiently.</p>
        </div>
    </main>    