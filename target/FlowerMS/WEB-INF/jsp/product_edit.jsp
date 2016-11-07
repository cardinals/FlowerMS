<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/public/tag.jsp"%>
<div class="container login-panel">
    <div class="panel panel-heading">
        <h1>${title}</h1>
    </div>
    <form class="form-horizontal" role="form" action="${url}" method="post"
          enctype="multipart/form-data" onsubmit="return productCheck()">
        <div class="form-group">
            <label for="flowerName" class="col-sm-2 control-label">名称:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="flowerName" name="flowerName" value="${flower.flowerName}"
                       placeholder="请输入名称">
            </div>
        </div>
        <div class="form-group">
            <label for="price" class="col-sm-2 control-label">价格:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="price" name="price" value="${flower.price}"
                       placeholder="请输入价格">
            </div>
        </div>
        <div class="form-group">
            <label for="number" class="col-sm-2 control-label">数目:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="number" name="number" value="${flower.number}"
                       placeholder="请输入花卉数目...">
            </div>
        </div>
        <div class="form-group">
            <label for="remarks" class="col-sm-2 control-label">备注:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="remarks" name="remarks" value="${flower.remarks}"
                       placeholder="请输入备注">
            </div>
        </div>
        <div class="form-group">
            <label for="image"  class="col-sm-2 control-label">图片:</label>
            <div class="col-sm-10">
                <input type="file" id="image" name="images">
            </div>
        </div>
        <button type="submit" class="btn btn-default">提交信息</button>
    </form>
    <br/>
    <br/>
    <br/>
</div>
