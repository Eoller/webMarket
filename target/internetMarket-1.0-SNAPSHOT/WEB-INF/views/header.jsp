<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="row">
    <nav role="navigation" class="navbar navbar-inverse">
        <div class="container">
            <div class="navbar-header header">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1><a href="#"><spring:message code="shopName"/></a></h1>
                            <p>Shop number ONE in EU</p>
                        </div>
                    </div>
                </div>
                <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div id="navbarCollapse" class="collapse navbar-collapse navbar-right">
                <ul class="nav nav-pills">
                    <li class="active"><a href="#">Main</a></li>
                    <li><a href="${pageContext.request.contextPath}/news">News</a></li>
                    <li><a href="#">Contact</a></li>
                    <li><a href="#">Forum</a></li>
                    <li><a href="#">Sales</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>