<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">
    <div class="row">
        <form:form modelAttribute="product"  method="post" action="${pageContext.request.contextPath}/added">
            <div class="form-group">
                <form:input path="name" class="form-control"
                            placeholder="Product name"/>
            </div>
            <div class="form-group">
                <form:input path="price" class="form-control"
                            placeholder="Product price"/>
            </div>
            <div class="form-group">
                <form:input path="dscr" class="form-control"
                            placeholder="Product dscr"/>
            </div>

            <div class="form-group">
                <form:input path="uniqueNumber" class="form-control"
                            placeholder="Product unique number"/>
            </div>

            <form:select path="categoryId">
                <form:options items="${categoryList}" itemLabel="name" itemValue="id" />
            </form:select>


            <button type="submit" class="btn btn-default">Create</button>


        </form:form>
    </div>
</div>
