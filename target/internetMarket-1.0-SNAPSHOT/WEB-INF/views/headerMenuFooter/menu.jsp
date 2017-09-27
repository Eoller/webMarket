<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>

<div class="listCategory">


    <div class="list-group ">
        <c:forEach items="${categoryList}" var="category">

            <!--  <button onclick="ShowList(${category.id})">${category.name}</button> -->

           <a
                    <c:if test="${active == category.name}">class="list-group-item active"</c:if>
                    <c:if test="${!(active == category.name)}">class="list-group-item"</c:if>
                    href="${context}/getList/${category.id}/${category.name}">${category.name}
            </a>
        </c:forEach>
    </div>




</div>