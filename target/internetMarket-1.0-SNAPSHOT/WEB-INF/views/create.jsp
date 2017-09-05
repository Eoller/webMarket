<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">
    <div class="row">
        <form:form modelAttribute="product" method="post">
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
                <form:option value="0" label="Select category"/>
                <form:options items="${categoryList}" itemValue="id" itemLabel="name"/>
            </form:select>

            <form:select path="producerId">
                <form:option value="0" label="Select producer"/>
                <form:options items="${producersList}" itemValue="id" itemLabel="name"/>
            </form:select>

            <button type="submit" class="btn btn-default">Add</button>


        </form:form>
    </div>
</div>
