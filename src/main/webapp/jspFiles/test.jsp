<%--
  Created by IntelliJ IDEA.
  User: lain
  Date: 2022/12/26
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>购买数量</td>
        </tr>
        <tr>
            <form action="./Servlet1.do" method="post">
                <input type="text" name="name">
                <input type="text" name="price">
                <input type="text" name="num">
                <input type="submit" value="submit">
            </form>
        </tr>
    </table>

</body>
</html>
