<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/public/tag.jsp"%>
<div class="container login-panel">
    <table class="table mytable">
        <thead>
            <tr>
                <th>管理员名称</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr class="active">
                <td>${user.username}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p>
        <a href='#content' onclick="ajaxRefresh('${pageContext.request.contextPath}/user/add')" class="btn btn-primary">添加管理员</a>
    </p>
    <br/>
    <br/>
    <br/>
</div>
