<html>
<#include "../common/head.ftl">
<body>
<div class="container-fluid">
    <div class="header">
        <#include "../common/header.ftl">
    </div>
    <div class="content">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="alert alert-dismissable alert-success">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <h4>成功！</h4>
                    <strong>${message!""}</strong> <a href="${url}" class="alert-link">3s后自动跳转</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    setTimeout("location.href='${url}'", 3000);
</script>
</html>