<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-5">
            <span class="label label-info">${product.producerId.name}</span>

            <div class="detailImg">
                <img src="${pageContext.request.contextPath}/productImage/${product.id}">
            </div>
            <div class="detailImgTxt">
                Press and hold to make the image bigger.
            </div>
        </div>
        <div class="col-lg-5">
            <div class="panel panel-default">
                <div class="panel-body"><strong>Name: </strong>${product.name}</div>
            </div>
            <div class="panel panel-default">
                <div class="panel-body"><strong>Price: </strong>${product.price}$</div>
            </div>
            <div class="panel panel-default">
                <div class="panel-body"><strong>Unique number: </strong>${product.uniqueNumber}</div>
            </div>
        </div>
        <div class="col-lg-2">
            <form action="#">
                <button type="submit" class="btn btn-default btn-md detailButton" style="background-color: #fdf1f1">
                    Buy
                </button>
            </form>
            <hr>

            <form action="#">
                <button type="submit" class="btn btn-default btn-md detailButton">Add to Card</button>
            </form>


        </div>
    </div>
    <div class="panel panel-default" style="margin-top: 40px;">
        <div class="panel-body">${product.dscr}</div>
    </div>

    <div class="admin-button">
    <span class="label label-warning"> <a style="color:white;" href="${pageContext.request.contextPath}/showDetails/${product.id}?form">Edit</a></span>
    <span class="label label-danger"><a style="color:white;" href="${pageContext.request.contextPath}/delete/${product.id}" >Delete</a></span>
    </div>

    <!--
    <a href="${pageContext.request.contextPath}/showDetails/${product.id}?form" class="btn btn-default"
       role="button">Edit</a>
    <a href="${pageContext.request.contextPath}/delete/${product.id}" class="btn btn-default" role="button">Delete</a>
    </div>-->
</div>



