<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <link href="<c:url value="/webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
    <c:set var="context" value="${pageContext.request.contextPath}"/>
</head>
<body>

<div class="container-fluid">
    <div class="headerWrapper">
        <tiles:insertAttribute name="header" ignore="true"/>
    </div>
    <div class="menuContentWrapper">
        <div class="wrapper">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 leftmenu">
                        <tiles:insertAttribute name="menu" ignore="true"/>
                    </div>
                    <div class="col-lg-9" rightmenu>
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-lg-10">
                                    <div class="container-fluid searchForm">
                                        <form:form method="POST" class="navbar-form navbar-left" action="${context}/searchString">
                                            <div class="form-group">
                                                <input class="form-control" placeholder="Search" type="text" name="searchString">
                                            </div>
                                            <button type="submit" class="btn btn-default">Submit</button>
                                        </form:form>
                                    </div>
                                </div>
                                <div class="col-lg-2">
                                    <div class="dropdown" style="margin-top: 8px; margin-left: 60px;">
                                        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1"
                                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                            <span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                            <li><a href="?lang=ru">ru</a></li>
                                            <li><a href="?lang=en">eng</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <tiles:insertAttribute name="body"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div class="footerWrapper">
    <tiles:insertAttribute name="footer" ignore="true"/>
</div>


<script src="${context}/webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="${context}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
