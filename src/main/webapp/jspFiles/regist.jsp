<%--
  Created by IntelliJ IDEA.
  User: lain
  Date: 2022/12/20
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>学生注册</title>
    <link href="../cssFiles/bootstrap.min.css" rel="stylesheet">
    <!-- CSS only -->
    <%--    <link href="../css/bootstrap.min.css" rel="stylesheet">--%>
</head>
<body>

<div class="container-fluid">
    <div class="row position-absolute top-50 start-50 translate-middle" >

        <form action="../Regist.do" role="form" method="post">
            <div class="row text-center">
                <H3>你好！欢迎注册Web课后辅导教学交流系统</H3>
            </div>
            <div class="mb-4 row text-center">
                <label for="uname" class="control-label col-md-3">账号</label>
                <div class="col-md-8">
                    <input type="text" id="uid" name="uid" class="form-control" placeholder="请输入你的学号" />
                </div>
            </div>
            <div class="mb-4 row text-center">
                <label for="uname" class="control-label col-md-3">身份</label>
                <div class="col-md-8">
                    <input type="text" id="identity" name="uid" class="form-control"  readonly="readonly" placeholder="在此处键入身份" />
                </div>
            </div>
            <div class="mb-4 row text-center">
                <label for="uname" class="control-label col-md-3">姓名</label>
                <div class="col-md-8">
                    <input type="text" id="uname" name="uname" class="form-control" placeholder="请输入你的姓名" />
                </div>
            </div>
            <!-- 输入框 -->
            <div class="mb-4 row text-center">
                <label for="upwd" class="control-label col-md-3">密码</label>
                <div class="col-md-8">
                    <input type="password" id="upwd" name="upwd" class="form-control" placeholder="请为你的帐号设置密码" />
                </div>
            </div>
            <div class="mb-4 row text-center">
                <label for="upwd" class="control-label col-md-3">确认密码</label>
                <div class="col-md-8">
                    <input type="password" id="confirmpwd" name="confirmpwd" class="form-control" placeholder="请再次输入密码以确认" />
                </div>
            </div>
            <div class="mb-4 row text-center">
                <button type="submit" class="btn btn-light">注册</button>
                <button type="reset" class="btn btn-primary">重置</button>
            </div>
        </form>


        <%--        </div>--%>
    </div>
</div>

<script type="text/javascript" src="../jsFiles/jquery-3.6.0.min.js"/>
<script type="text/javascript" src="../jsFiles/bootstrap.min.js"/>

</body>
