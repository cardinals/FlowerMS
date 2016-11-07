<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/public/tag.jsp"%>
<div class="container list-panel">
    <form action="viewAllOrders.jsp" method="post" name="form1" role="form">
        <table width="100%">
            <tr>
                <td width="20%" class="style13" align="right">
                    <div class="form-group">
                        按订单号查询：
                    </div>
                </td>
                <td width="15%" class="style13" align="left" colspan="2">
                    <div class="form-group">
                        <input type="text" class="form-control" id="orderid" name="orderid" size="29"
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
                        <select class="form-control" name="userid" id="userid">
                            <option>请选择</option>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                </td>
                <td width="3%" class="style13">&nbsp;</td>
                <td width="10%" class="style13">&nbsp;</td>
            </tr>
            <tr>
                <td width="10%" class="style13" align="right">
                    <div class="form-group">按订单日期查询：
                    </div>
                </td>
                <td width="6%" class="style13" align="left">
                    <div class="form-group">
                        <input type="datetime-local" class="form-control" id="a1" name="orderdate1" size="7"
                               placeholder="起始日期">
                    </div>
                </td>
                <td width="2%" class="style13" align="left">
                    <div class="form-group">
                        至
                    </div>
                </td>
                <td width="6%" class="style13" align="left">
                    <div class="form-group">
                        <input type="datetime-local" class="form-control" id="a2" name="orderdate2" size="10"
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
                            <option>请选择</option>
                        </select>
                    </div>
                </td>
                <td width="3%" class="style13">&nbsp;</td>
                <td width="10%" class="style13">
                    <div class="form-group">
                        <input type="submit" value="查询" class="btn btn-default">
                    </div>
                </td>
            </tr>
        </table>
    </form>
    <table class="table mytable">
        <thead>
        <tr>
            <th>订单号</th>
            <th>订单日期</th>
            <th>订单发送日期</th>
            <th>发送时间(点)</th>
            <th>接收人姓名</th>
            <th>订花人</th>
            <th>收花人电话</th>
            <th>收花人地址</th>
            <th>付款状态</th>
            <th>业务员</th>
            <th>备注</th>
            <th>订单状态</th>
            <th>订单状态</th>
        </tr>
        </thead>
        <tbody>
        <tr class="active">
            <td>产品1</td>
            <td>23/11/2013</td>
            <td>待发货</td>
            <td>待发货</td>
            <td>待发货</td>
            <td>待发货</td>
            <td>产品1</td>
            <td>23/11/2013</td>
            <td>待发货</td>
            <td>待发货</td>
            <td>待发货</td>
            <td>待发货</td>
            <td>待发货</td>
        </tr>
        <tr class="success">
            <td>产品2</td>
            <td>10/11/2013</td>
            <td>发货中</td>
            <td>发货中</td>
            <td>发货中</td>
            <td>发货中</td>
            <td>产品1</td>
            <td>23/11/2013</td>
            <td>待发货</td>
            <td>待发货</td>
            <td>待发货</td>
            <td>待发货</td>
            <td>待发货</td>
        </tr>
        <tr class="warning">
            <td>产品3</td>
            <td>20/10/2013</td>
            <td>待确认</td>
            <td>待确认</td>
            <td>待确认</td>
            <td>待确认</td>
            <td>产品1</td>
            <td>23/11/2013</td>
            <td>待发货</td>
            <td>待发货</td>
            <td>待发货</td>
            <td>待发货</td>
            <td>待发货</td>
        </tr>
        <tr class="danger">
            <td>产品4</td>
            <td>20/10/2013</td>
            <td>已退货</td>
            <td>已退货</td>
            <td>已退货</td>
            <td>已退货</td>
            <td>产品1</td>
            <td>23/11/2013</td>
            <td>待发货</td>
            <td>待发货</td>
            <td>待发货</td>
            <td>待发货</td>
            <td>待发货</td>
        </tr>
        </tbody>
    </table>
    <p>
        <a href="#" class="btn btn-primary">添加订单</a>
    </p>
    <ul class="pagination pager">
        <li class="previous"><a href="#">&larr; 首页</a></li>
        <li><a href="#">&laquo;</a></li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">...</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">&raquo;</a></li>
        <li class="next"><a href="#">末页 &rarr;</a></li>
    </ul>
</div>
