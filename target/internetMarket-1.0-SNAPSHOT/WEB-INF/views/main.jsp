<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
</head>
<body>

<p>Hello ${user.name}!</p>
<p>Your password is  ${user.password}!</p>
<c:if test="${!empty genres}">
<c:forEach items="${genres}" var="genre">
    <a href="/internetMarket-1.0-SNAPSHOT/gen/${genre.id}/${genre.name}">${genre.name}</a>
</c:forEach></c:if>
<p>${product.name}</p>

<form:form method="POST" commandName="searchCriteria" action="/internetMarket-1.0-SNAPSHOT/a">
    <form:label path="searchString">PutSearchStringHere</form:label>
    <form:password path="searchString"/>
    </fieldset>
    <footer>
        <input type="submit" class="btnLogin" value="Search" tabindex="4">
    </footer>
</form:form>

<c:if test="${!empty list}">
    <table class="data" border="1">
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
</c:if>



</body>
</html>
