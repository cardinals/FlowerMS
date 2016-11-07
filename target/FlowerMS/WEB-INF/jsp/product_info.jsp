<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/public/tag.jsp"%>
<div class="container list-panel">
    <div class="panel panel-heading">
        <h1>商品信息</h1>
    </div>
    <table width="65%" align="center">
        <tr>
            <td width="30%" align="center" valign="top" bgcolor="#FFFFFF">
                <img src="${pageContext.request.contextPath}${flower.images}"
                     class="img-rounded" width="250" height="250">
            </td>
            <td width="70%" align="center" valign="top">
                <table width="100%" border="1" class="table table-striped">
                    <tr style="height: 82px;">
                        <td align="center"><h3>商品名称：</h3></td>
                        <td align="center"><h3>${flower.flowerName}</h3></td>
                    </tr>
                    <tr style="height: 82px;">
                        <td align="center"><h3>单&nbsp;&nbsp;&nbsp;&nbsp;价：</h3></td>
                        <td align="center"><h3>${flower.price}</h3></td>
                    </tr>
                    <tr style="height: 82px;">
                        <td align="center"><h3>备&nbsp;&nbsp;&nbsp;&nbsp;注：</h3></td>
                        <td align="center"><h3>${flower.remarks}</h3></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <h4>&nbsp;</h4>
    <br/>
</div>
