<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/public/tag.jsp"%>
<div class="container login-panel">
    <div class="panel-default">
        <div class="form-inline">
            <div class="form-group">
                <label class="sr-only" for="workerID">职工编号</label>
                <input type="text" class="form-control" id="workerID" name="workerID"
                       placeholder="请输入职工编号查询">
            </div>
            <div class="form-group">
                <label class="sr-only" for="workername">职工姓名</label>
                <input type="text" class="form-control" id="workername" name="workername"
                       placeholder="请输入职工姓名查询">
            </div>
            &nbsp;
            <button onclick="ajaxFormWorker('${pageContext.request.contextPath}/worker/query','workerID','workername')" class="btn btn-default">
                查询
            </button>
        </div>
    </div>
    <br/>
    <table class="table mytable">
        <thead>
            <tr>
                <th>职工编号</th>
                <th>职工姓名</th>
                <th>删 除</th>
                <th>修 改</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${workers}" var="worker">
            <tr class="active">
                <td>${worker.workerID}</td>
                <td>${worker.workername}</td>
                <td>
                    <a href='#content' onclick="ajaxRefresh('${pageContext.request.contextPath}/worker/${worker.workerID}/delete')">删 除</a>
                </td>
                <td>
                    <a href='#content' onclick="ajaxRefresh('${pageContext.request.contextPath}/worker/${worker.workerID}/update')">修 改</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p>
        <a href='#content' onclick="ajaxRefresh('${pageContext.request.contextPath}/worker/add')" class="btn btn-primary">添加职工</a>
    </p>
    <br/>
    <br/>
    <br/>
</div>
