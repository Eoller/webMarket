<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>

<div class="listCategory">

    <div class="list-group producersList" style="display: none;" >
        <c:forEach items="${producersList}" var="category">
            <!-- HOW MANY PRODUCTS IN THAT CATEGORY <span class="badge">${category.id}</span> -->
            <a
                    <c:if test="${active == category.name}">class="list-group-item active"</c:if>
                    <c:if test="${!(active == category.name)}">class="list-group-item"</c:if>
                    href="${context}/getList/${category.id}/${category.name}">${category.name}
            </a>
        </c:forEach>
    </div>

    <div class="list-group ">
        <c:forEach items="${categoryList}" var="category">
            <!-- HOW MANY PRODUCTS IN THAT CATEGORY <span class="badge">${category.id}</span> -->
            <a
                    <c:if test="${active == category.name}">class="list-group-item active"</c:if>
                    <c:if test="${!(active == category.name)}">class="list-group-item"</c:if>
                    href="${context}/getList/${category.id}/${category.name}">${category.name}
            </a>
        </c:forEach>
    </div>




</div>