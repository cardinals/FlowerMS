<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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
    <div class="collapse navbar-collapse" id="example-navbar-collapse">
        <ul id="myTab" class="nav nav-tabs">
            <li class="active tab-text">
                <a href="#home" data-toggle="tab">
                    主页
                </a>
            </li>
            <li class="tab-text"><a href="#system" data-toggle="tab">系统管理</a></li>
            <li class="tab-text"><a href="#content" onclick="ajaxRefresh('${pageContext.request.contextPath}/product/list/1')"
                                    data-toggle="tab">商品管理</a></li>
            <li class="tab-text"><a href="#content" onclick="ajaxRefresh('${pageContext.request.contextPath}/customer/list/1')"
                                    data-toggle="tab">客户关系</a></li>
            <li class="tab-text"><a href="#content" onclick="ajaxRefresh('${pageContext.request.contextPath}/order/list/1')" data-toggle="tab">订单管理</a>
            </li>
            <li class="tab-text"><a href="#settings" data-toggle="tab">基本设置</a></li>
            <li class="tab-text"><a href="${pageContext.request.contextPath}/user/logout">退出系统</a></li>
            <li class="tab-text">&nbsp;&nbsp;&nbsp;</li>
            <li class="tab-text"><a href="#" id="index-time"></a></li>
        </ul>
    </div>
</nav>
