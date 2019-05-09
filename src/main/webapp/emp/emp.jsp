<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/easyui/include.jsp"%>
    <script src="${pageContext.request.contextPath}/js/emp/list.js"></script>
</head>
<body>
<table id="dg"></table>

<div id="dg-toolbar">
    <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="eventobj.query()">查询</a>
    <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="eventobj.add()">新增员工</a>
    <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="eventobj.addJob()">添加职位</a>
    <%--<a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="eventobj.remove()">删除</a>--%>
</div>



<div id="emp-dialog">

</div>
</body>
</html>
