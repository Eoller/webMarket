<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid">
    <div class="row">
        <nav class="navbar navbar-default listband">
            <div class="container">
                <ul class="nav navbar-nav">
                    <li><a href="#"><span class="glyphicon glyphicon-sort-by-alphabet"></span></a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-sort-by-alphabet-alt"></span></a></li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Sort by<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Price - increase</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Price - decrease</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</div>
<div class="container-fluid">
    <div class="row">
        <c:forEach items="${productList}" var="abc">
            <div class="col-lg-4">
                <div class="thumbnail" style="position: relative;">
                    <div class="productPhoto">
                        <img src="${pageContext.request.contextPath}/productImage/${abc.id}" alt="${abc.name}">
                    </div>

                    <div class="caption" style="position: absolute; bottom: 0; width: 170px; left: 45px;">
                        <h3>${abc.name}</h3>
                        <p>${abc.price}$</p>
                        <p>
                            <a href="#" class="btn btn-primary" role="button"><spring:message code="Buy"/></a>
                            <a href="${pageContext.request.contextPath}/showDetails/${abc.id}" class="btn btn-default" role="button"><spring:message code="Details"/> </a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
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