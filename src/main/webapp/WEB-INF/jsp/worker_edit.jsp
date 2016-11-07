<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/public/tag.jsp"%>
<div class="container login-panel">
    <div class="panel panel-heading">
        <h1>${title}</h1>
    </div>
    <form class="form-horizontal" role="form" action="${url}" method="post"
          onsubmit="return workerCheck()">
        <div class="form-group">
            <label for="status" class="col-sm-4 control-label">职工状态:</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="status" name="status" value="${worker.status}"
                       placeholder="请输入职工状态号...">
            </div>
        </div>
        <div class="form-group">
            <label for="workername" class="col-sm-4 control-label">姓&nbsp;&nbsp;名:</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="workername" name="workername" value="${worker.workername}"
                       placeholder="请输入职工姓名...">
            </div>
        </div>
        <button type="submit" class="btn btn-default">提交</button>
    </form>
    <br/>
    <br/>
    <br/>
</div>
