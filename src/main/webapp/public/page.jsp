<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<ul class="pagination pager">
    <li class="previous"><a href="#content" onclick="ajaxRefresh('${page.url}/1')">&larr; 首页</a></li>

    <c:if test="${page.pagenum>1 }">
        <li><a href="#content')" onclick="ajaxRefresh('${page.url}/${page.pagenum-1}')">上一页</a></li>
    </c:if>

    <c:forEach begin="${page.startpage}" end="${page.endpage}" var="pagenum">
        <li><a href="#content" onclick="ajaxRefresh('${page.url}/${pagenum}')">${pagenum }</a><li>
    </c:forEach>

    <c:if test="${page.pagenum<page.totalpage }">
        <li><a href="#content" onclick="ajaxRefresh('${page.url}/${page.pagenum+1}')">下一页</a></li>
    </c:if>
    <li class="next"><a href="#content" onclick="ajaxRefresh('${page.url}/${page.totalpage}')">末页 &rarr;</a></li>
</ul>