<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/public/tag.jsp"%>
<div class="container list-panel">
    <div class="panel-default">
        <div class="form-inline">
            <div class="form-group">
                <label class="sr-only" for="customerName">请输入客户名称查询</label>
                <input type="text" class="form-control" id="customerName" name="customerName"
                       placeholder="请输入客户名称查询">
            </div>
            &nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;
            <button onclick="ajaxForm('${pageContext.request.contextPath}/customer/query/1','customerName')" class="btn btn-default">
                查询
            </button>
        </div>
    </div>
    <br/>
    <br/>
    <table class="table mytable">
        <thead>
        <tr>
            <th>客户名称</th>
            <th>订货时间</th>
            <th>备注</th>
            <th>删除</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="order">
            <tr class="active">
                <td>${order.sendName}</td>
                <td>${fn:replace(order.orderDateShow,"T"," ")}</td>
                <td>${order.remarks}</td>
                <td><a href="javascript:deleteCustomer('${pageContext.request.contextPath}/customer/${order.sendName}/delete')">删除</a> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%@include file="/public/page.jsp" %>
</div>
<script type="text/javascript">
    function deleteCustomer(url){
        $.post(url);
        ajaxRefresh('${pageContext.request.contextPath}/customer/list/1');
        window.location.href="#content";
    }
</script>
