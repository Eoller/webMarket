<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="listProducts">
    <div class="container-fluid">
        <div class="row">
            <c:forEach items="${productList}" var="abc">
                <div class="col-lg-4">
                    <div class="thumbnail" style="position: relative;">
                        <span class="label label-info">${abc.producerId.name}</span>

                        <div class="productPhoto">
                            <img src="${pageContext.request.contextPath}/productImage/${abc.id}" alt="${abc.name}">
                        </div>

                        <div class="caption" style="position: absolute; bottom: 0; width: 170px; left: 45px;">
                            <div class="name" style="text-align: center;">
                                <h4>${abc.name}</h4>
                            </div>
                            <strong><p>${abc.price}$</p></strong>
                            <p>
                                <a href="#" class="btn btn-primary" role="button"><spring:message code="Buy"/></a>
                                <a href="${pageContext.request.contextPath}/showDetails/${abc.id}"
                                   class="btn btn-default"
                                   role="button"><spring:message code="Details"/> </a>
                            </p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<!-- ALLEGROLIKE version
<div class="container-fluid">
<div class="panel panel-default productPanel">
<table class="table" border="0">
<tr>
<td>
<div class="productPhoto">
<img src="${pageContext.request.contextPath}/productImage/${abc.id}">
</div>
</td>
<td><h3>${abc.name}</h3></h></td>
<td>${abc.dscr}</td>
</tr>

</table>
</div>
</div>
-->