<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>

<p>Hello ${user.name}!</p>
<p>Your password is  ${user.password}!</p>
<c:if test="${!empty genres}">
<c:forEach items="${genres}" var="genre">
    <a href="${pageContext.request.contextPath}/gen/${genre.id}/${genre.name}">${genre.name}</a>
</c:forEach></c:if>
<p>${product.name}</p>

<form:form method="POST" commandName="searchCriteria" action="/internetMarket-1.0-SNAPSHOT/a">
    <form:label path="searchString">PutSearchStringHere</form:label>
    <form:password path="searchString"/>
    </fieldset>
    <footer>
        <input type="submit" class="btnLogin " value="Search" tabindex="4">
    </footer>
</form:form>


<div class="panel panel-default">
    <table class="data table" border="1">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>dscr</th>
        </tr>
        <c:forEach items="${list}" var="abc">
            <tr>
                <td>${abc.id}</td>
                <td>${abc.name}</td>
                <td>${abc.dscr}</td>
            </tr>
        </c:forEach>
    </table>
</div>



<script src="${pageContext.request.contextPath}/webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
