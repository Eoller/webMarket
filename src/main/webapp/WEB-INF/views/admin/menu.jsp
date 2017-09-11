<%--
  Created by IntelliJ IDEA.
  User: Eoller
  Date: 11-Sep-17
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">
    <div class="row">
        <nav class="navbar navbar-default listband">
            <div class="container">
                <ul class="nav navbar-nav">
                    <li><a href="${pageContext.request.contextPath}/create?form">Add Product</a></li>
                    <li><a href="${pageContext.request.contextPath}/category/add">Add Category</a></li>
                    <li><a href="${pageContext.request.contextPath}/producer/add">Add Producer</a></li>
                    <li><a href="#">New Admin Account</a></li>
                    <li><a href="${pageContext.request.contextPath}/news/add">Add News</a></li>

                </ul>
            </div>
        </nav>
    </div>
</div>
