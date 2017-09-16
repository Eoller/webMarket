<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
        <form:form modelAttribute="product" method="post" enctype="multipart/form-data">
            <div class="form-group">
                Product name:
                <form:input path="name" class="form-control"
                            placeholder="Product name"/>
            </div>
            <div class="form-group">
                Product price:
                <form:input path="price" class="form-control"
                            placeholder="Product price"/>
            </div>
            <div class="form-group">
                Product dscr:
                <form:input path="dscr" class="form-control"
                            placeholder="Product dscr"/>
            </div>

            <div class="form-group">
                Product unique number:
                <form:input path="uniqueNumber" class="form-control"
                            placeholder="Product unique number"/>
            </div>

            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-2">
                        <form:select path="categoryId.id">
                            <form:option value="0" label="Select category"/>
                            <form:options items="${categoryList}" itemValue="id" itemLabel="name"/>
                        </form:select>
                    </div>
                    <div class="col-lg-2">
                        <form:select path="producerId.id">
                            <form:option value="0" label="Select producer"/>
                            <form:options items="${producerList}" itemValue="id" itemLabel="name"/>
                        </form:select>
                    </div>
                    <div class="col-lg-3">
                        <Photo></Photo>:<input type="file" name="file">
                    </div>

                </div>
            </div>
            <br>
            <button type="submit" class="btn btn-default"><spring:message code="Add_Product"/></button>


        </form:form>
    </div>
</div>
