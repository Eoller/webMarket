<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-11">
            <div class="container-fluid">
                <c:forEach items="${news}" var="new">
                    <div class="row">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-lg-10">
                                            <h4>${new.topic} </h4>
                                        </div>
                                        <div class="col-lg-2">
                                            <div class="deletenewform" style="text-align: right">
                                            <form action="${pageContext.request.contextPath}/news/read/${new.id}">
                                                <button type="submit" class="btn btn-default btn-md">
                                                    <span class="glyphicon glyphicon-book" aria-hidden="true"></span>
                                                    Read
                                                </button>
                                            </form>

                                            <span class="label label-danger"><a style="color:white;"
                                                                                href="${pageContext.request.contextPath}/news/delete/${new.id}">Delete</a></span>
                                            </div>
                                            <!--<form action="${pageContext.request.contextPath}/news/delete/${new.id}">
                                                <button type="submit" class="btn btn-default btn-md">
                                                    <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                                                    Delete
                                                </button>
                                            </form>-->
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
