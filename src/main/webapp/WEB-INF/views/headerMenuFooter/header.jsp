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
                            <h1><a href="${pageContext.request.contextPath}/"><spring:message code="shopName"/>&reg</a></h1>
                            <p style="text-align: left"><em>Shop number ONE in EU</em></p>
                        </div>
                        <div class="col-lg-2">
                            <div id="f">
                                <a target="_blank" href="https://www.linkedin.com/in/jegor-melnik-0a9b18122/"><i class="fa fa-linkedin"></i></a>
                                <a target="_blank" href="https://www.facebook.com/egorpyp"><i class="fa fa-facebook"></i></a>
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
                            href="${pageContext.request.contextPath}/all">Main</a></li>
                    <li
                            <c:if test="${active == 'news'}">class="active"</c:if> ><a
                            href="${pageContext.request.contextPath}/news/getAll"><spring:message code="news"/></a></li>
                    <li
                            <c:if test="${active == 'contact'}">class="active"</c:if> ><a href="#">Contact</a></li>
                    <li
                            <c:if test="${active == 'forum'}">class="active"</c:if> ><a href="#">Forum</a></li>
                    <li
                            <c:if test="${active == 'admin'}">class="active"</c:if> >
                        <a href="${pageContext.request.contextPath}/admin">Admin</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>