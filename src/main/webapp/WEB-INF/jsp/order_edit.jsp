<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/public/tag.jsp"%>
<div class="container login-panel">
    <div class="panel panel-heading">
        <h1>${title}</h1>
    </div>
    <form class="form-horizontal" role="form" action="${url}" method="post"
          onsubmit="return orderCheck()">
        <div class="form-group">
            <label for="receiveName" class="col-sm-4 control-label">接收人姓名:</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="receiveName" name="receiveName" value="${order.receiveName}"
                       placeholder="请输入接收人姓名">
            </div>
        </div>
        <div class="form-group">
            <label for="sendName" class="col-sm-4 control-label">订花人:</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="sendName" name="sendName" value="${order.sendName}"
                       placeholder="请输入订花人">
            </div>
        </div>
        <div class="form-group">
            <label for="receiveTel" class="col-sm-4 control-label">收花人电话:</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="receiveTel" name="receiveTel" value="${order.receiveTel}"
                       placeholder="请输入收花人电话">
            </div>
        </div>
        <div class="form-group">
            <label for="receiveAdd" class="col-sm-4 control-label">收花人地址:</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="receiveAdd" name="receiveAdd" value="${order.receiveAdd}"
                       placeholder="请输入收花人地址">
            </div>
        </div>
        <div class="form-group">
            <label for="payState" class="col-sm-4 control-label">付款状态:</label>
            <div class="col-sm-8">
                <select class="form-control" name="payState" id="payState">
                    <option value="0" ${order.payState==0?'selected':''}>未付款</option>
                    <option value="1" ${order.payState==1?'selected':''}>已付款</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="remarks" class="col-sm-4 control-label">备注:</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="remarks" name="remarks" value="${order.remarks}"
                       placeholder="请输入备注">
            </div>
        </div>
        <div class="form-group">
            <label for="status" class="col-sm-4 control-label">订单状态:</label>
            <div class="col-sm-8">
                <select class="form-control" name="status" id="status">
                    <option value="0" ${order.status==0?'selected':''}>已取消</option>
                    <option value="1" ${order.status==1?'selected':''}>正在进行中</option>
                    <option value="2" ${order.status==2?'selected':''}>已完成</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="sendState" class="col-sm-4 control-label">发送状态:</label>
            <div class="col-sm-8">
                <select class="form-control" name="sendState" id="sendState">
                    <option value="0" ${order.sendState==0?'selected':''}>未发送</option>
                    <option value="1" ${order.sendState==1?'selected':''}>已发送</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="name9" class="col-sm-4 control-label">发送日期:</label>
            <div class="col-sm-8">
                <input type="datetime-local" class="form-control" id="name9" name="sendTimeShow" value="${order.sendTimeShow}"
                       placeholder="请输入发送日期">
            </div>
        </div>
        <div class="form-group">
            <label for="salesman" class="col-sm-4 control-label">业务员:</label>
            <div class="col-sm-8">
                <select class="form-control" name="salesman" id="salesman">
                    <c:forEach items="${workers}" var="worker">
                        <option value="${worker.workerID}" ${worker.workerID==order.salesman?'selected':''}>${worker.workername}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="flowerID" class="col-sm-4 control-label">花种:</label>
            <div class="col-sm-8">
                <select class="form-control" name="flowerID" id="flowerID">
                    <c:forEach items="${flowers}" var="flower">
                        <option value="${flower.flowerID}" ${flower.flowerID==order.flowerID?'selected':''}>${flower.flowerName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="quantity" class="col-sm-4 control-label">数量:</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="quantity" name="quantity" value="${order.quantity}"
                       placeholder="请输入数量">
            </div>
        </div>
        <input type="submit" class="btn btn-default">
    </form>
    <br/>
    <br/>
    <br/>
</div>
<script type="text/javascript">
    function payStateOf(state){
        return payState[state];
    }
</script>
