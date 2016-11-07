<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/public/tag.jsp" %>
<div class="container list-panel">
    <div class="panel-default">
        <div class="form-inline">
            <div class="form-group">
                <label class="sr-only" for="flowerName">名称</label>
                <input type="text" class="form-control" id="flowerName" name="flowerName"
                       placeholder="请输入商品名称查询">
            </div>
            &nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;
            <button onclick="ajaxForm('${pageContext.request.contextPath}/product/query/1','flowerName')" class="btn btn-default">
                查询
            </button>
        </div>
    </div>
    <br/>
    <br/>
    <table class="table myTable">
        <thead>
        <tr>
            <th>商品号</th>
            <th>商品名</th>
            <th>单价</th>
            <th>商品图片</th>
            <th>商品备注</th>
            <th>操作此商品</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="pro">
            <tr class="danger">
                <td><a href='#content'
                       onclick="ajaxRefresh('${pageContext.request.contextPath}/product/${pro.flowerID}')">${pro.flowerID}</a>
                </td>
                <td>${pro.flowerName}</td>
                <td>${pro.price}</td>
                <td><a href="${pageContext.request.contextPath}${pro.images}">样图</a></td>
                <td>${pro.remarks}</td>
                <td>
                    <div align=center class=style13>
                        <a href='#content'
                           onclick="ajaxRefresh('${pageContext.request.contextPath}/product/${pro.flowerID}/update')">修改</a>&nbsp;&nbsp;
                        <a href='${pageContext.request.contextPath}/product/${pro.flowerID}/delete'>删除</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p>
        <a href='#content' onclick="ajaxRefresh('${pageContext.request.contextPath}/product/add')"
           class="btn btn-primary">添加花种</a>
    </p>
    <%@include file="/public/page.jsp" %>
</div>
