<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                        <form:select path="categoryId">
                            <form:option value="0" label="Select category"/>
                            <form:options items="${categoryList}" itemValue="id" itemLabel="name"/>
                        </form:select>
                    </div>
                    <div class="col-lg-2">
                        <form:select path="producerId">
                            <form:option value="0" label="Select producer"/>
                            <form:options items="${producersList}" itemValue="id" itemLabel="name"/>
                        </form:select>
                    </div>
                    <div class="col-lg-3">
                        <Photo></Photo>:<input type="file" name="file">
                    </div>

                </div>
            </div>
            <br>
            <button type="submit" class="btn btn-default">Add new product</button>


        </form:form>
    </div>
</div>
