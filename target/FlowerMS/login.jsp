<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/public/tag.jsp"%>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <%@include file="/public/meta.jsp"%>
    <title>登录</title>
</head>
<body>

<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse"
                data-target="#example-navbar-collapse">
            <span class="sr-only">切换导航</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand title-text" href="#"><font color="#31B0D5">花卉后台管理系统</font></a>
    </div>
</nav>

<div class="container login-panel">
    <div class="panel panel-default text-center">
        <div class="panel-heading">
            <h1>管理员登录</h1>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/user/login"
                  method="post" onsubmit="return loginCheck()">
                <div class="form-group ">
                    <label for="username" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="username" name="username"
                               placeholder="请输入管理员用户名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="password" name="password"
                               placeholder="请输入密码">
                    </div>
                </div>

                <c:if test="${!empty(message)}">
                    <div class="form-group">
                        <h5 style="color:red;">${message}</h5>
                    </div>
                </c:if>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> 请记住我
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-info">登录</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
