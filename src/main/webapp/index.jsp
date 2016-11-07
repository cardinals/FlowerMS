<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!doctype html>
<html class="no-js" lang="">
<head>
    <%@include file="/public/meta.jsp"%>
    <title>主页</title>
</head>
<body>

<%@include file="/public/header.jsp"%>

<div class="container">
    <div class="panel panel-default text-center">
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade in active" id="home" style="background-image:url(${pageContext.request.contextPath}/public/bg.jpg);">
                <br/><br/><br/><br/><br/><br/>
                <br/><br/><br/><br/>
                <p>
                    <font size="20px" font-fimaly="黑体" color="#31B0D5">欢迎使用花卉后台管理系统</font>
                </p>
                <br/><br/><br/><br/><br/><br/>
                <br/><br/><br/><br/><br/>
            </div>
            <div class="tab-pane fade" id="settings">
                <br/>
                <br/>
                <br/>
                <div class="panel-body">
                    <a href="#content" onclick="ajaxRefresh('${pageContext.request.contextPath}/user/list')" data-toggle="tab"
                       class="btn btn-primary btn-lg">管理员资料管理</a>
                </div>
                <br/>
                <br/>
                <br/>
                <div class="panel-body">
                    <a href="#content" onclick="ajaxRefresh('${pageContext.request.contextPath}/worker/list')" data-toggle="tab"
                       class="btn btn-primary btn-lg">职工资料管理</a>
                </div>
                <br/>
                <br/>
                <br/>
                <br/>
            </div>
            <div class="tab-pane fade" id="content">

            </div>
            <div class="tab-pane fade" id="system">
                <div class="panel-info">
                    <h1>数据库备份</h1>
                </div>
                <div class="panel-body">
                    <form class="form-inline" role="form">
                        <div class="form-group">
                            <label class="sr-only" for="name">请选择备份位置：</label>
                            <input type="text" class="form-control" id="backcupname"
                                   placeholder="请选择备份位置...">
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="backcupfile">备份目录</label>
                            <input type="file" id="backcupfile">
                        </div>
                        <button type="submit" class="btn btn-default">备份数据库</button>
                    </form>
                </div>
                <div class="panel-info">
                    <h1>数据库还原</h1>
                </div>
                <div class="panel-body">
                    <form class="form-inline" role="form">
                        <div class="form-group">
                            <label class="sr-only" for="name">请选择数据库还原文件(仅支持.sql文件)</label>
                            <input type="text" class="form-control" id="name"
                                   placeholder="请选择.sql还原文件">
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="recoveryfile">还原文件</label>
                            <input type="file" id="recoveryfile">
                        </div>
                        <button type="submit" class="btn btn-default">还原数据库</button>
                    </form>
                </div>
                <br/>
                <br/>
                <br/>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        $('#myTab a:first').tab('show')
    })
    setInterval(function () {
        var date = new Date();
        //year
        var year = date.getFullYear();
        //month
        var month = date.getMonth() + 1;
        if (month < 10) {
            month = '0' + month;
        }
        //day
        var day = date.getDate();
        if (day < 10) {
            day = '0' + day;
        }
        //hour
        var hour = date.getHours();
        if (hour < 10) {
            hour = '0' + hour;
        }
        //minute
        var minute = date.getMinutes();
        if (minute < 10) {
            minute = '0' + minute;
        }
        //second
        var second = date.getSeconds();
        if (second < 10) {
            second = '0' + second;
        }
        var show = year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second;
        var time = $('#index-time');
        time.html(show);
    }, 1000);
</script>
</html>

