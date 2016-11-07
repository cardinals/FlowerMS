<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/public/tag.jsp"%>
<div class="container login-panel">
    <div class="panel panel-heading">
        <h1>${title}</h1>
    </div>
    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/user/adduser"
          method="post" onsubmit="return adminCheck()">
        <div class="form-group">
            <label for="name1" class="col-sm-4 control-label">管理员用户名:</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="username" name="username"
                       placeholder="管理员用户名">
            </div>
        </div>
        <div class="form-group">
            <label for="name2" class="col-sm-4 control-label">密码:</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="password" name="password"
                       placeholder="密码">
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-4 control-label">Email:</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="email" name="email"
                       placeholder="Email">
            </div>
        </div>
        <div class="form-group">
            <label for="tel" class="col-sm-4 control-label">手机号:</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="tel" name="tel"
                       placeholder="请输入手机号...">
            </div>
        </div>
        <div class="form-group">
            <label for="name" class="col-sm-4 control-label">姓名:</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="name" name="name"
                       placeholder="请输入姓名...">
            </div>
        </div>
        <div class="form-group">
            <label for="cardID" class="col-sm-4 control-label">身份证号:</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="cardID" name="cardID"
                       placeholder="请输入身份证号...">
            </div>
        </div>
        <div class="form-group">
            <label for="address" class="col-sm-4 control-label">地址:</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="address" name="address"
                       placeholder="请输入地址...">
            </div>
        </div>
        <input type="submit" class="btn btn-default">提交</input>
    </form>
    <br/>
    <br/>
    <br/>
</div>
