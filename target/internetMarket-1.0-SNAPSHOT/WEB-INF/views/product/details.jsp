<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
            <form action="${pageContext.request.contextPath}/cart/add/${product.id}">
                <button type="submit" onclick="seccessAddingToCart('${product.name}')" class="btn btn-default btn-md detailButton">Add to Card</button>
            </form>
            <!-- <button class="buttonload">
                 <i class="fa fa-spinner fa-spin"></i>Loading
             </button> -->

        </div>
    </div>
    <div class="panel panel-default" style="margin-top: 40px;">
        <div class="panel-body">${product.dscr}</div>
    </div>

    <div class="admin-button">
        <a href="${pageContext.request.contextPath}/showDetails/${product.id}?form" class="btn btn-primary"
           role="button">Edit</a>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModalDelete">
            Delete
        </button>
    </div>


    <!-- Modal -->
    <div class="modal fade" id="myModalDelete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Deleting ${product.name}</h4>
                </div>
                <div class="modal-body">
                    Are you sure that you want to remove product with name: ${product.name} from the database?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <a href="#" class="btn btn-primary"
                       role="button" onclick="JustTestRest(${product.id})">Delete</a>
                </div>

            </div>
        </div>
    </div>
    <!--
    <a href="${pageContext.request.contextPath}/showDetails/${product.id}?form" class="btn btn-default"
       role="button">Edit</a>
    <a href="${pageContext.request.contextPath}/delete/${product.id}" class="btn btn-default" role="button">Delete</a>
    </div>-->
</div>



