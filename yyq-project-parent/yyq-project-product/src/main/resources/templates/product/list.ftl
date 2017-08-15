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
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>图片</th>
                            <th>商品id</th>
                            <th>名称</th>
                            <th>价格</th>
                            <th>库存</th>
                            <th>描述</th>
                            <th>类目</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list productInfoPage.content as productInfo>
                        <tr>
                            <td><img style="height: 100px; width: 100px" src="${productInfo.productIcon}" alt="图片"></td>
                            <td>${productInfo.productId}</td>
                            <td>${productInfo.productName}</td>
                            <td>${productInfo.productPrice}</td>
                            <td>${productInfo.productStock}</td>
                            <td>${productInfo.productDescription}</td>
                            <td>${productInfo.categoryType}</td>
                            <td>${productInfo.createTime}</td>
                            <td>${productInfo.updateTime}</td>
                            <td>
                                <a href="/sell/seller/product/index?productId=${productInfo.productId}">修改</a>
                            </td>
                            <td>
                            <#if productInfo.getProductStatusEnum().message == "UP">
                                <a href="/sell/seller/product/offSale?productId=${productInfo.productId}">下架</a>
                            <#else>
                                <a href="/sell/seller/product/onSale?productId=${productInfo.productId}">上架</a>
                            </#if>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                    <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li><a href="/sell/seller/product/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>
                    <#list 1..productInfoPage.getTotalPages() as index>
                    <#if currentPage == index>
                        <li class="disabled"><a href="#">${index}</a></li>
                    <#else>
                        <li><a href="/sell/seller/product/list?page=${index}&size=${size}">${index}</a></li>
                    </#if>
                    </#list>
                    <#if currentPage gte productInfoPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/sell/seller/product/list?${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
            <div class="col-md-2"></div>
        </div>
    </div>
</div>
</body>
</html>