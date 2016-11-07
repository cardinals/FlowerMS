<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/public/tag.jsp"%>
<div class="container list-panel">
    <div class="form-inline" role="form">
        <table width="100%">
            <tr>
                <td width="20%" class="style13" align="right">
                    <div class="form-group">
                        按订单号查询：
                    </div>
                </td>
                <td width="15%" class="style13" align="left" colspan="2">
                    <div class="form-group">
                        <input type="text" class="form-control" id="orderID" name="orderID" size="29"
                               placeholder="请输入订单号">
                    </div>
                </td>
                <td width="3%" class="style13">&nbsp;</td>
                <td width="20%" class="style13" align="right">
                    <div class="form-group">
                        按订花人查询：
                    </div>
                </td>
                <td width="15%" class="style13" align="left">
                    <div class="form-group">
                        <select class="form-control" name="sendMan" id="sendMan">
                            <option value="">请选择</option>
                            <c:forEach items="${customers}" var="customer">
                                <option value="${customer.sendName}">${customer.sendName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </td>
                <td width="3%" class="style13">&nbsp;</td>
                <td width="10%" class="style13">&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td width="10%" class="style13" align="right">
                    <div class="form-group">按订单日期查询：
                    </div>
                </td>
                <td width="6%" class="style13" align="left">
                    <div class="form-group">
                        <input type="datetime-local" class="form-control" id="startTime" name="startTime" size="7"
                               placeholder="起始日期">
                    </div>
                </td>
                <td width="2%" class="style13" align="left">
                    <div class="form-group">
                        &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;至
                    </div>
                </td>
                <td width="6%" class="style13" align="left">
                    <div class="form-group">
                        <input type="datetime-local" class="form-control" id="endTime" name="endTime" size="10"
                               placeholder="结束日期">
                    </div>
                </td>
                <td width="20%" class="style13" align="right">
                    <div class="form-group">按业务员查询：
                    </div>
                </td>
                <td width="15%" class="style13" align="left">
                    <div class="form-group">
                        <select class="form-control" name="saleman" id="saleman">
                            <option value="-1">请选择</option>
                            <c:forEach items="${workers}" var="worker">
                                <option value="${worker.workerID}">${worker.workername}</option>
                            </c:forEach>
                        </select>
                    </div>
                </td>
                <td width="3%" class="style13">&nbsp;</td>
                <td width="10%" class="style13">
                    <div class="form-group">
                        <button onclick="ajaxFormOrder('${pageContext.request.contextPath}/order/query/1')" class="btn btn-default">
                            查询
                        </button>
                    </div>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
            </tr>
        </table>
    </div>
    <table class="table mytable">
        <thead>
        <tr>
            <th>订单号</th>
            <th>订单日期</th>
            <th>订单发送日期</th>
            <th>接收人姓名</th>
            <th>订花人</th>
            <th>收花人电话</th>
            <th>收花人地址</th>
            <th>付款状态</th>
            <th>业务员</th>
            <th>备注</th>
            <th>发送状态</th>
            <th>订单状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="order">
            <tr class="danger">
                <td>${order.orderID}</td>
                <td>${fn:replace(order.orderDateShow,"T"," ")}</td>
                <td>${fn:replace(order.sendTimeShow,"T"," ")}</td>
                <td>${order.receiveName}</td>
                <td>${order.sendName}</td>
                <td>${order.receiveTel}</td>
                <td>${order.receiveAdd}</td>
                <td>
                    <c:if test="${order.payState==0}">
                        未付款
                    </c:if>
                    <c:if test="${order.payState==1}">
                        已付款
                    </c:if>
                </td>
                <td>
                    ${order.workername}
                </td>
                <td>${order.remarks}</td>
                <td>
                    <c:if test="${order.sendState==0}">
                        未发送
                    </c:if>
                    <c:if test="${order.sendState==1}">
                        已发送
                    </c:if>
                </td>
                <td>
                    <c:if test="${order.status==0}">
                        已取消
                    </c:if>
                    <c:if test="${order.status==1}">
                        正在进行中
                    </c:if>
                    <c:if test="${order.status==2}">
                        已完成
                    </c:if>
                </td>
                <td>
                    <a href='#content' onclick="ajaxRefresh('${pageContext.request.contextPath}/order/${order.orderID}/update')">修改</a>&nbsp;&nbsp;
                    <a href='${pageContext.request.contextPath}/order/${order.orderID}/delete'>删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p>
        <a href='#content' onclick="ajaxRefresh('${pageContext.request.contextPath}/order/${order.orderID}/add')" class="btn btn-primary">添加订单</a>
    </p>
    <%@include file="/public/page.jsp" %>
    <%--<ul class="pagination pager">--%>
        <%--<li class="previous"><a href="#">&larr; 首页</a></li>--%>
        <%--<li><a href="#">&laquo;</a></li>--%>
        <%--<li><a href="#">1</a></li>--%>
        <%--<li><a href="#">2</a></li>--%>
        <%--<li><a href="#">3</a></li>--%>
        <%--<li><a href="#">...</a></li>--%>
        <%--<li><a href="#">4</a></li>--%>
        <%--<li><a href="#">5</a></li>--%>
        <%--<li><a href="#">&raquo;</a></li>--%>
        <%--<li class="next"><a href="#">末页 &rarr;</a></li>--%>
    <%--</ul>--%>
</div>
