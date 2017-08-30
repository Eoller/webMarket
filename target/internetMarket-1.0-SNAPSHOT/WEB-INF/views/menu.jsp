<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<div class="list-group listGenre">
    <c:forEach items="${genreList}" var="genre">
        <a href="${context}/getList/${genre.id}/${genre.name}"
           class="list-group-item">${genre.name}</a>
    </c:forEach>
</div>