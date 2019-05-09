<%--
  Created by IntelliJ IDEA.
  User: 85181
  Date: 2019/5/2
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/easyui/include.jsp"%>
    <script src="${pageContext.request.contextPath}/js/shopItem/shopItem.js"></script>
</head>
<body>
<table id="dg"></table>

<div id="dg-toolbar">
    商品编号：
    <input id="shopitemid" name="shopitemid" class="easyui-textbox" data-options="width:180" class="easyui-validatebox"  />
    商品名称：
    <input id="shopitemname" name="shopitemname" class="easyui-textbox" data-options="width:180" />
<c:if test="${user.shopId==1}">
    商店名称：
    <select id="shopid" name="shopid">

    </select>
</c:if>
    <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="eventobj.query()">查询</a>
    <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="eventobj.update()">修改</a>
    <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="eventobj.add()">添加</a>
</div>



<div id="supplier-dialog">
    
</div>
</body>
</html>
