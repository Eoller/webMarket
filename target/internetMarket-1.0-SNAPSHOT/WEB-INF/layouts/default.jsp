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
                        <div class="container-fluid searchForm">
                            <form:form method="POST" commandName="searchCriteria" class="navbar-form navbar-left" action="${context}/searchString">
                                <div class="form-group">
                                    <form:input path="searchString" class="form-control" placeholder="Search" />
                                </div>
                                <button type="submit" class="btn btn-default">Submit</button>
                            </form:form>
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



<form:form method="POST" commandName="searchCriteria" cssClass="navbar-form navbar-left" action="/internetMarket-1.0-SNAPSHOT/a">
    <form:label path="searchString">PutSearchStringHere</form:label>
    <form:password path="searchString"/>
    </fieldset>
    <footer>
        <input type="submit" class="btn btn-default" value="Search" tabindex="4">
    </footer>
</form:form>