<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title>Home</title>
    <link href="<c:url value="/webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <c:set var="context" value="${pageContext.request.contextPath}"/>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <nav role="navigation" class="navbar navbar-inverse">
            <div class="container">
                <div class="navbar-header header">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <h1><a href="#"><spring:message code="shopName"/></a></h1>
                                <p>Shop number ONE in EU</p>
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
                        <li class="active"><a href="#">Main</a></li>
                        <li><a href="#">News</a></li>
                        <li><a href="#">Contact</a></li>
                        <li><a href="#">Forum</a></li>
                        <li><a href="#">Sales</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>

    <div class="wrapper">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 leftmenu">
                    <div class="list-group listGenre">
                        <c:forEach items="${genreList}" var="category">
                            <a href="${context}/getList/${category.id}/${category.name}"
                               class="list-group-item">${category.name}</a>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-lg-9" rightmenu>
                    <h2>Our products</h2>
                    <hr>
                    <div class="container-fluid">
                        <c:forEach items="${productList}" var="abc">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="container-fluid">
                                        <div class="panel panel-default">
                                            <table class="table" border="0">
                                                <tr>
                                                    <th>id</th>
                                                    <th>name</th>
                                                    <th>dscr</th>
                                                </tr>

                                                <tr>
                                                    <td>${abc.id}</td>
                                                    <td>${abc.name}</td>
                                                    <td>${abc.dscr}</td>
                                                </tr>

                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>

<footer>
    <div class="container">
        <p class="text-center">This web page was creating by Yahor Melnik. 2017</p>
    </div>
</footer>
</div>


<script src="${context}/webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="${context}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>