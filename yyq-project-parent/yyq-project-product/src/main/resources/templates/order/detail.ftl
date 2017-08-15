<html>
<#include "../common/head.ftl">
<body>
    <div class="container-fluid">
        <div class="header">
            <#include "../common/header.ftl">
        </div>
        <div class="content">
            <div class="row clearfix">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="col-md-12 column">
                        <ul class="breadcrumb">
                            <li>
                                <a href="/sell/seller/order/list">列表</a>
                            </li>
                            <li class="active">
                                详情
                            </li>
                        </ul>
                    </div>
                    <div class="col-md-12 column">
                        <table class="table table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>订单id</th>
                                <th>订单总金额</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>${orderDTO.orderId}</td>
                                <td>${orderDTO.orderAmount}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-12 column">
                        <table class="table table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>商品id</th>
                                <th>商品名称</th>
                                <th>价格</th>
                                <th>数量</th>
                                <th>总额</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list orderDTO.orderDetailsList as orderDetails>
                            <tr>
                                <td>${orderDetails.productId}</td>
                                <td>${orderDetails.productName}</td>
                                <td>${orderDetails.productPrice}</td>
                                <td>${orderDetails.productQuantity}</td>
                                <td>${orderDetails.productQuantity * orderDetails.productPrice}</td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-12 column">
                    <#if orderDTO.getOrderStatusEnum().message == "新订单">
                        <a href="/sell/seller/order/finish?orderId=${orderDTO.orderId}" type="button" class="btn btn-default btn-primary">完结订单</a>
                        <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}" type="button" class="btn btn-default btn-danger">取消订单</a>
                    </#if>
                    </div>
                </div>
                <div class="col-md-2"></div>
            </div>
        </div>
    </div>
</body>
</html>