<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<div class="listCategory">
    <ul class="list-group">
        <c:forEach items="${categoryList}" var="category">
            <li
                    <c:if test="${active == category.name}">class="list-group-item active"</c:if>
                    <c:if test="${!(active == category.name)}">class="list-group-item"</c:if>
            >
                <!-- HOW MANY PRODUCTS IN THAT CATEGORY <span class="badge">${category.id}</span> -->
                <a href="${context}/getList/${category.id}/${category.name}">${category.name}</a>
            </li>
        </c:forEach>
    </ul>
</div>