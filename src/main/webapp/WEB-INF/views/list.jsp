<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                <th>photo</th>
                            </tr>

                            <tr>
                                <td>${abc.id}</td>
                                <td>${abc.name}</td>
                                <td>${abc.dscr}</td>
                                <td><img src="${pageContext.request.contextPath}/productImage/${abc.id}"></td>
                            </tr>

                        </table>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>