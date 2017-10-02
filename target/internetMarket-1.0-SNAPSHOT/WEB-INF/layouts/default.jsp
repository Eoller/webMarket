<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <link href="<c:url value="/webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <c:set var="context" value="${pageContext.request.contextPath}"/>



    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#dialog" ).dialog();
        } );
    </script>
</head>
<body>

<div class="container-fluid">
    <div class="headerWrapper">
        <tiles:insertAttribute name="header" ignore="true"/>
    </div>
    <div class="menuContentWrapper">
        <div class="wrapper">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 leftmenu">
                        <tiles:insertAttribute name="menu" ignore="true"/>
                    </div>
                    <div class="col-lg-9" rightmenu>
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-lg-10">
                                    <div class="container-fluid searchForm">
                                        <form:form method="POST" class="navbar-form navbar-left"
                                                   action="${context}/searchString">
                                            <div class="form-group">
                                                <input class="form-control" placeholder="Search" type="text"
                                                       name="searchString">
                                            </div>
                                            <button type="submit" class="btn btn-default">Submit</button>

                                        </form:form>
                                    </div>
                                </div>
                                <div class="col-lg-2">
                                    <div class="dropdown" style="margin-top: 8px; margin-left: 60px;">
                                        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1"
                                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                            <span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                            <li><a href="?lang=ru">ru</a></li>
                                            <li><a href="?lang=en">eng</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <tiles:insertAttribute name="body"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div class="footerWrapper">
    <tiles:insertAttribute name="footer" ignore="true"/>
</div>

<script src="${context}/webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="${context}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${context}/ckeditor/ckeditor.js" type="text/javascript"></script>
<script src="${context}/ckeditor/adapters/jquery.js" type="text/javascript"></script>
<script type="text/javascript">



        var ShowList = function (id) {
            $.ajax({
                type: 'GET',
                async: true,
                url: "http://localhost:8080/internetMarket-1.0-SNAPSHOT/json/getList/" + id,
                success: function (data) {
                    $.each(data, function (index, product) {
                        var uri = "http://localhost:8080/internetMarket-1.0-SNAPSHOT/productImage/" + product.id;
                        $(".listProducts").html("<img src="+ uri +">");
                    });

                }
            });
        }

        var seccessAddingToCart = function(name) {
            alert("Product " + name + " was successfully added to your cart");
        }

        var JustTestRest = function (id) {
            $.ajax({
                type: 'GET',
                async: 'true',
                url: 'http://localhost:8080/internetMarket-1.0-SNAPSHOT/rest/product/' + id,
                success: function (result) {
                    var obj = JSON.parse(result);
                    alert(obj.id + obj.name + obj.price);
                }
            });
        }

        var prefix = '/cart/delete';

        var RestControllerDelete = function (id) {
            $.ajax({
               type: 'DELETE',
                async: 'true',
                url: 'http://localhost:8080/internetMarket-1.0-SNAPSHOT/rest/delete/' + id,
                success: function (result) {
                    alert(result);
                }

            });
        }

        var RestDelete = function (id) {
            $.ajax({
               type: 'DELETE',
                async: true,
                url: 'http://localhost:8080/internetMarket-1.0-SNAPSHOT/cart/delete/' + id,
                success: function (result) {
                    $("#modl"+result).hide();
                }
            });
        }
        
        var RestDelete1 = function (id) {
            var url = "http://localhost:8080/internetMarket-1.0-SNAPSHOT/ajax/test/"+id;
            $.get( url , function (data, status) {
                    alert("Data: " + data);
            });
        }

</script>
</body>
</html>
