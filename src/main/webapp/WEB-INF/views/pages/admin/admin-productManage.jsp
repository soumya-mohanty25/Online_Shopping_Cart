<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<jsp:include page="admin-header.jsp" />
<meta charset="UTF-8">
<title>manage product</title>

<div class="manage-product">
    <h2 style = "color: #60ff6ae6">Manage Products</h2>
    <form action="${pageContext.request.contextPath}/products/add" method="post">
        <table style="width: 100%; border-collapse: collapse;">
            <tr>
                <td><label for="name">Product Name:</label></td>
                <td><input type="text" name="name" placeholder="Product Name" required style="width: 100%; padding: 8px;"></td>
            </tr>
            <tr>
                <td><label for="category">Category:</label></td>
                <td><input type="text" name="category" placeholder="Category" required style="width: 100%; padding: 8px;"></td>
            </tr>
            <tr>
                <td><label for="price">Price:</label></td>
                <td><input type="number" name="price" placeholder="Price" step="0.01" required style="width: 100%; padding: 8px;"></td>
            </tr>
            <tr>
                <td><label for="description">Description:</label></td>
                <td><textarea name="description" placeholder="Description" required style="width: 100%; padding: 8px;" rows="4"></textarea></td>
            </tr>
            <tr>
                <td><label for="stock">Stock:</label></td>
                <td><input type="number" name="stock" placeholder="Stock" required style="width: 100%; padding: 8px;"></td>
            </tr>
            <tr>
                <td><label for="imageUrl">Image URL:</label></td>
                <td><input type="text" name="imageUrl" placeholder="Image URL" required style="width: 100%; padding: 8px;"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center; padding-top: 20px;">
                    <button type="submit" class="submit-button" style="width: 200px; padding: 12px; background-color: #3abe9b; color: white; border: none; border-radius: 8px; cursor: pointer;">Add Product</button>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center; padding-top: 10px;">
                    <a href="${pageContext.request.contextPath}/products/list">
                        <button type="button" class="list-button" style="width: 200px; padding: 12px; background-color: #AAB339; color: white; border: none; border-radius: 8px; cursor: pointer;">Show List</button>
                    </a>
                </td>
            </tr>
        </table>
    </form>
</div>


