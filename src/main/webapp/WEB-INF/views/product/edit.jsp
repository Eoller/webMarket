<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Eoller
  Date: 06-Sep-17
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form modelAttribute="product" id="productUpdateForm" method="post" enctype="multipart/form-data">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-5">
                <div class="detailImg">
                    <img src="${pageContext.request.contextPath}/productImage/${product.id}">
                </div>
                <div class="detailImgTxt">
                    Press and hold to make the image bigger.
                </div>
            </div>
            <div class="col-lg-5">
                <div class="panel panel-default">
                    <div class="panel-body"><strong>

                        Name:<form:input path="name"/>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-body"><strong></strong>
                        Price:<form:input path="price"/>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-body"><strong></strong>
                        Unique number:<form:input path="uniqueNumber"/>
                    </div>
                </div>
                <select name="category">
                    <option value="0">Change category to</option>
                    <c:forEach items="${categoryList}" var="category">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
                <select name="producer">
                    <option value="0">Change producer to</option>
                    <c:forEach items="${producerList}" var="producer">
                        <option value="${producer.id}">${producer.name}</option>
                    </c:forEach>
                </select>
                <h5>To change photo:</h5>
                <input type="file" name="file">
            </div>
            <div class="col-lg-2">
                <a href="${pageContext.request.contextPath}/showDetails/${product.id}" class="btn btn-default" role="button">Cancel</a>
                <form:button type="submit">Save</form:button>
            </div>
        </div>
        <div class="panel panel-default" style="margin-top: 40px;">
            <div class="panel-heading">
                <h3 class="panel-title">Description</h3>
            </div>
            <div class="panel-body">
                <form:textarea cols="60" rows="8" path="dscr"/>
            </div>
        </div>
    </div>
</form:form>

