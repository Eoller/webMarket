<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Eoller
  Date: 11-Sep-17
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">
    <div class="row">
        <form:form modelAttribute="news" method="post">
            <div class="form-group">
                News topic:
                <form:input path="topic" class="form-control"
                            placeholder="topic"/>
            </div>
            <div class="form-group">
                News content:
                <form:textarea rows="10" cols="60" path="newsText" class="form-control"
                            placeholder="content"/>
            </div>
            <button type="submit" class="btn btn-default">Add news</button>
        </form:form>
    </div>
</div>
