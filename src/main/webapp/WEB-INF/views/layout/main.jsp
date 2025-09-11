<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Verdant Roots</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/profile.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shop.css">    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/contactus.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/address.css">  
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/add-address.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/add-address.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/checkout.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/choose.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/edit-profile.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css"> 
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/search.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cart.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/add-product.css"> 
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/order.css">
</head>
<body>
  
  <div class="layout">
    <%-- Shared Header --%>
     <jsp:include page="header.jsp" />

<%-- <c:set var="originalUri" value="${requestScope['javax.servlet.forward.request_uri']}" />
<c:if test="${empty originalUri}">
    <c:set var="originalUri" value="${pageContext.request.requestURI}" />
</c:if>
<p>DEBUG URI: ${originalUri}</p>
    <c:choose>
    <c:when test="${fn:startsWith(originalUri, '/admins')}">
        <jsp:include page="/WEB-INF/views/layout/admin-header.jsp" />
    </c:when>
    <c:otherwise>
        <jsp:include page="header.jsp" />
    </c:otherwise>
    </c:choose> --%>

    <%-- Page Content --%>
    <div class="container mt-4">
        <c:if test="${not empty body}">
            <jsp:include page="/WEB-INF/views/${body}.jsp" />
        </c:if>
    </div>

    <%-- Shared Footer --%>
    <jsp:include page="footer.jsp" />
    
 </div>
 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
