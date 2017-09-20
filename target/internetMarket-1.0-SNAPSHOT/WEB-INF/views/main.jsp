<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Eoller
  Date: 17-Sep-17
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner karusel" role="listbox">
        <div class="item active">
            <img src="<c:url value="/resources/img/iPhone-8X.jpg"/> " alt="...">
            <div class="carousel-caption">
                <h3>New perfect</h3>
            </div>
        </div>
        <div class="item">
            <img src="<c:url value="/resources/img/iphoneX.png"/>" alt="...">
            <div class="carousel-caption">
            </div>
        </div>
        <div class="item">
            <img src="<c:url value="/resources/img/Samsung_Logo.svg.png"/> " alt="...">
            <div class="carousel-caption">
            </div>
        </div>

    </div>

    <!-- Controls -->

</div>
