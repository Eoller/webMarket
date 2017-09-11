<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Eoller
  Date: 11-Sep-17
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form method="POST" class="navbar-form navbar-left" modelAttribute="producer">
    <div class="form-group">
        <form:input path="name" class="form-control"
                    placeholder="Producer name"/>
    </div>
    <button type="submit" class="btn btn-default">Add Producer</button>
</form:form>
