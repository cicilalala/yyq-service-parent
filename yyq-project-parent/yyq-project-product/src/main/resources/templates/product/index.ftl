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
                    <form role="form" method="post" action="/sell/seller/product/save">
                        <div class="form-group">
                            <label>商品名称</label>
                            <input name="productName" class="form-control" value="${(productInfo.productName)!''}" type="text" />
                        </div>
                        <div class="form-group">
                            <label>商品价格</label>
                            <input name="productPrice" class="form-control" value="${(productInfo.productPrice)!''}" type="text" />
                        </div>
                        <div class="form-group">
                            <label>商品库存</label>
                            <input name="productStock" class="form-control" value="${(productInfo.productStock)!''}" type="number" />
                        </div>
                        <div class="form-group">
                            <label>商品描述</label>
                            <input name="productDescription" class="form-control" value="${(productInfo.productDescription)!''}" type="text" />
                        </div>
                        <div class="form-group">
                            <label>商品图片</label>
                            <img style="height: 100px; width: 100px;" src="${(productInfo.productIcon)!''}" alt="">
                            <input name="productIcon" class="form-control" value="${(productInfo.productDescription)!''}" type="text" />
                        </div>
                        <div class="form-group">
                            <label>商品图片</label>
                            <select name="categoryType" class="form-control">
                            <#list categoryList as category>
                                <option value="${category.categoryType}"
                                    <#if (productInfo.categoryType)?? && productInfo.categoryType == category.categoryType>
                                        selected
                                    </#if>
                                >${category.categoryName}
                                </option>
                            </#list>
                            </select>
                        </div>
                        <input hidden type="text" name="productId" value="${(productInfo.productId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
            <div class="col-md-2"></div>
        </div>
    </div>
</div>
</body>
</html>