<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Eoller
  Date: 11-Sep-17
  Time: 15:02
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
                    <li><a href="${pageContext.request.contextPath}/news/add">Add News</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false"><spring:message code="Delete_Producer"/><span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <c:forEach items="${producerList}" var="producer">
                                <li>
                                    <a href="${pageContext.request.contextPath}/producer/delete/${producer.id}">${producer.name}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false"><spring:message code="Delete_Category"/><span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <c:forEach items="${categoryList}" var="category">
                                <li>
                                    <a href="${pageContext.request.contextPath}/category/delete/${category.id}">${category.name}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</div>
<div class="container-fluid">
    <div class="row">
        <form:form modelAttribute="news" method="post">
            <div class="form-group">
                News topic:
                <form:input path="topic" class="form-control"
                            placeholder="topic"/>
            </div>
            <div class="form-group">
                News content:
                <form:textarea rows="10" cols="60" path="newsText" class="form-control"
                            placeholder="content"/>
            </div>
            <button type="submit" class="btn btn-default">Add news</button>
        </form:form>
    </div>
</div>
