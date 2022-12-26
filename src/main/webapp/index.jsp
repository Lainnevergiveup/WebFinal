<%--
  Created by IntelliJ IDEA.
  User: lain
  Date: 2022/12/20
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>
    <link href="cssFiles/bootstrap.min.css" rel="stylesheet">
    <!-- CSS only -->
<%--    <link href="../css/bootstrap.min.css" rel="stylesheet">--%>
</head>
<body>

    <div class="container-fluid " >
    <div class="row position-absolute top-50 start-50 translate-middle" >

            <form action="./Login.do" role="form" method="post" >
                <div class="row text-center">
                    <H3>欢迎使用Web课后辅导教学交流系统</H3>
                </div>
                <div class="mb-4 row text-center">
                    <label for="uname" class="control-label col-md-3">账号</label>
                    <div class="col-md-8">
                        <input type="text" id="uname" name="uname" class="form-control" placeholder="请输入账号" />
                    </div>
                </div>
                <!-- 输入框 -->
                <div class="mb-4 row text-center">
                    <label for="upwd" class="control-label col-md-3">密码</label>
                    <div class="col-md-8">
                        <input type="password" id="upwd" name="upwd" class="form-control" placeholder="请输入密码" />
                    </div>
                </div>
                <div class="mb-4 row text-center">
                    <button type="submit" class="btn btn-light">登录</button>
                    <a href="jspFiles/regist.jsp?identity=学生" class="btn btn-success">学生注册</a>
                    <button type="reset" class="btn btn-primary">取消</button>

                </div>
            </form>


<%--        </div>--%>
    </div>
    </div>

    <script type="text/javascript" src="jsFiles/jquery-3.6.0.min.js"/>
    <script type="text/javascript" src="jsFiles/bootstrap.min.js"/>

</body>
</html>
