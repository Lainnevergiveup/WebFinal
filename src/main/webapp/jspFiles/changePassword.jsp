<%--
  Created by IntelliJ IDEA.
  User: lain
  Date: 2022/12/21
  Time: 00:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改密码</title>
    <link href="../cssFiles/bootstrap.min.css" rel="stylesheet">
    <!-- CSS only -->
    <%--    <link href="../css/bootstrap.min.css" rel="stylesheet">--%>
</head>
<body>
<div class="container-fluid">
    <div class="row position-absolute top-50 start-50 translate-middle" >

        <form action="#" role="form" method="post">
            <br>
            <div class="mb-4 row text-center">
                <label for="uname" class="control-label col-md-3">账号</label>
                <div class="col-md-8">
                    <input type="text" id="uname" name="uname" class="form-control" placeholder="请输入你的账号" />
                </div>
            </div>

            <!-- 输入框 -->
            <div class="mb-4 row text-center">
                <label for="upwd" class="control-label col-md-3">原密码</label>
                <div class="col-md-8">
                    <input type="password" id="upwd" name="upwd" class="form-control" placeholder="请输入原密码" />
                </div>
            </div>
            <div class="mb-4 row text-center">
                <label for="upwd" class="control-label col-md-3">新密码</label>
                <div class="col-md-8">
                    <input type="password" id="newpwd" name="newpwd" class="form-control" placeholder="请设置新密码" />
                </div>
            </div>
            <div class="mb-4 row text-center">
                <label for="upwd" class="control-label col-md-3">确认密码</label>
                <div class="col-md-8">
                    <input type="password" id="confirmpwd" name="confirmpwd" class="form-control" placeholder="请再次输入新密码以确认" />
                </div>
            </div>
            <div class="mb-4 row text-center">
                <button type="submit" class="btn btn-light">修改</button>
                <button type="reset" class="btn btn-primary">重置</button>
            </div>
        </form>


        <%--        </div>--%>
    </div>
</div>

<script type="text/javascript" src="../jsFiles/jquery-3.6.0.min.js"/>
<script type="text/javascript" src="../jsFiles/bootstrap.min.js"/>

</body>
</html>
