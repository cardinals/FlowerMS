<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <%@include file="/public/meta.jsp"%>
    <meta http-equiv="refresh" content="3;url=${pageContext.request.contextPath}/index.jsp">
    <title>消息页面</title>
</head>
<body>

<%@include file="/public/header.jsp"%>

<div class="container login-panel">
    <div class="panel panel-default text-center">
        <div class="panel-heading">
            <h1>${message}</h1>
            <p><a href="${pageContext.request.contextPath}/index.jsp">3秒后自动跳转回主页，若未自动跳转，可点击此链接跳转</a> </p>
        </div>

    </div>
</div>
</body>
</html>
