<%--
  Created by IntelliJ IDEA.
  User: 85181
  Date: 2019/5/8
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form id="supplier-form" method="post">
        <table style="margin:20px auto;" cellpadding="5px" cellspacing="5px">
            <tr>
                <td>商店名称</td>
                <td><input type="text" id="shopname" name="shopname" ></td>
            </tr>
            <tr>
                <td>商店地址</td>
                <td>
                    <input type="text" id="shopaddress" name="shopaddress" >
                </td>
            </tr>
            <tr>
                <td>商店负责人</td>
                <td>
                    <input type="text" id="shopperson" name="shopperson" >
                </td>
            </tr>
            <tr>
                <td>联系方式</td>
                <td>
                    <input type="text" id="shopphone" name="shopphone" >
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
