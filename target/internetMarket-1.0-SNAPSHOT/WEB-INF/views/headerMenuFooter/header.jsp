<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <nav role="navigation" class="navbar navbar-inverse mynavbar-inverse navbar-static-top">
        <div class="container">
            <div class="navbar-header header">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-10">
                            <h1><a href="${pageContext.request.contextPath}/"><spring:message code="shopName"/>&reg</a>
                            </h1>
                            <p style="text-align: left"><em>Shop number ONE in EU</em></p>
                        </div>
                        <div class="col-lg-2">
                            <div id="f">
                                <a target="_blank" href="https://www.linkedin.com/in/jegor-melnik-0a9b18122/"><i
                                        class="fa fa-linkedin"></i></a>
                                <a target="_blank" href="https://www.facebook.com/egorpyp"><i
                                        class="fa fa-facebook"></i></a>
                                <a target="_blank" href="https://vk.com/id130301806"><i class="fa fa-vk"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
                <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div id="navbarCollapse" class="collapse navbar-collapse navbar-right">
                <ul class="nav nav-pills">
                    <li
                            <c:if test="${active == 'main'}">class="active"</c:if> ><a
                            href="<spring:url value="/all"/>"><spring:message code="Main"/></a></li>
                    <li
                            <c:if test="${active == 'news'}">class="active"</c:if> ><a
                            href="${pageContext.request.contextPath}/news/getAll"><spring:message code="news"/></a></li>
                    <li
                            <c:if test="${active == 'contact'}">class="active"</c:if> ><a
                            href="${pageContext.request.contextPath}/email/send"><spring:message code="Contact_us"/></a>
                    </li>
                    <li
                            <c:if test="${active == 'forum'}">class="active"</c:if> data-toggle="modal"
                            data-target="#myModal"><a href="#">Card <span
                            class="glyphicon glyphicon-shopping-cart"></span><span class="badge"
                                                                                   style="background-color: black;">${sessionScope.cartSize}</span></a>
                    </li>
                    <li
                            <c:if test="${active == 'admin'}">class="active"</c:if> >
                        <a href="${pageContext.request.contextPath}/admin"><spring:message code="Admin"/></a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel"><span
                            class="glyphicon glyphicon-shopping-cart"></span> Your shopping card</h4>

                </div>
                <div class="modal-body">
                    <c:forEach items="${sessionScope.cart.productList}" var="item">
                        <div class="media" id="modl${item.product.id}">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-lg-3">
                                        <div class="media-left media-middle">
                                            <a href="#">
                                                <img style="max-width: 100px; max-height: 100px;" class="media-object"
                                                     src="${pageContext.request.contextPath}/productImage/${item.product.id}"
                                                     alt="...">
                                            </a>
                                        </div>
                                    </div>
                                    <div class="col-lg-8">
                                        <div class="media-body">
                                            <h4 class="media-heading"><a
                                                    href="${pageContext.request.contextPath}/showDetails/${item.product.id}">${item.product.name}</a>
                                            </h4>
                                            <div>
                                                <br>
                                                <strong>Quantity: </strong>${item.quantity}<br>
                                                <strong>Price for one: </strong> ${item.product.price}<span
                                                    class="glyphicon glyphicon-usd"></span>

                                            </div>
                                        </div>
                                        <button id="but1" onclick="RestDelete(${item.product.id})" class="btn btn-default">Delete</button>
                                    </div>
                                    <div class="col-lg-1">
                                        <a href="${pageContext.request.contextPath}/cart/delete/${item.product.id}"><span
                                                class="glyphicon glyphicon-remove"></span></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr>

                    </c:forEach>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Buy <span class="badge">${sessionScope.cart.totalPrice}$</span></button>
                </div>
            </div>
        </div>
    </div>

</div>