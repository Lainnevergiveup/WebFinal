
<%--
  Created by IntelliJ IDEA.
  User: lain
  Date: 2022/12/20
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>管理员主页</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container"> <button class="navbar-toggler navbar-toggler-right border-0 p-0" type="button" data-toggle="collapse" data-target="#navbar20">
        <p class="navbar-brand text-white mb-0">
            <i class="fa d-inline fa-lg fa-stop-circle"></i> Web课后辅导系统管理员端 </p>
    </button>
        <div class="collapse navbar-collapse" id="navbar20">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item"> <a class="nav-link" href="./index.jsp">Home</a> </li>
                <li class="nav-item"> <a class="nav-link" href="#">About</a> </li>
            </ul>
            <p class="d-none d-md-block lead mb-0 text-white"> <i class="fa d-inline fa-lg fa-stop-circle"></i> <b> Web课后辅导系统管理员端</b> </p>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item mx-1"> <a class="nav-link" href="https://github.com/Lainnevergiveup/WebFinal">
                    <i class="fa fa-github fa-fw fa-lg"></i>
                </a> </li>
                <li class="nav-item mx-1"> <a class="nav-link" href="./index.jsp">
                    <i class="fa fa-bitbucket fa-fw fa-lg"></i>
                </a> </li>
            </ul>
        </div>
    </div>
</nav>
<div class="py-5 h-100 w-100">
    <div class="container w-100 h-100" style="height: 100%">
        <div class="row" style="height: 100%">
            <div class="col-3 col-md-2" style="">
                <ul class="nav nav-pills flex-column">
                    <li class="nav-item"> <a href="" class="active nav-link" data-toggle="pill" data-target="#courseBase">课程管理</a> </li>
                    <li class="nav-item" style="" > <a class="nav-link" href="" data-toggle="pill" data-target="#teacherBase">教师管理</a> </li>
                    <li class="nav-item"> <a href="" class="nav-link" data-toggle="pill" data-target="#courseConn">课程分配</a> </li>
                    <li class="nav-item"> <a href="" class="nav-link" data-toggle="pill" data-target="#editpsw">修改密码</a> </li>
                </ul>
            </div>
            <div class="col-9 col-md-10 h-100 w-100" style="height: 100%">
                <div class="tab-content">
                    <div class="tab-pane fade show active h-100" id="courseBase" role="tabpanel" height="100%">
                        <table class="table table-striped table-borderless">
                            <thead>
                            <tr>
                                <th scope="col">课程编号</th>
                                <th scope="col">课程名称</th>
                                <th scope="col">课程评价</th>
                                <th scope="col">课程评分</th>
                                <th scope="col">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${courseList}" var="course">
                                    <form action="./courseChange.do" method="post">
                                        <tr>
                                            <th scope="row"><input type="text" name="id" value="${course.id}"></th>
                                            <td><input type="text" name="name" value="${course.name}"></td>
                                            <td><input type="text" name="description" value="${course.description}"></td>
                                            <td><input type="text" name="score" value="${course.score}"></td>
                                            <td><input type="submit" value="更改" name="update" id="${course.id}"/><input type="submit" value="删除" name="delete" id="${course.id}"/></td>
                                        </tr>
                                    </form>
                                </c:forEach>
                                <form action="./courseChange.do" method="post">
                                    <tr>
                                        <th scope="row"><input type="text" name="id" value="课程编号"></th>
                                        <td><input type="text" name="name" value="课程名称"></td>
                                        <td><input type="text" name="description" value="课程描述"></td>
                                        <td><input type="text" name="score" value="课程评分"></td>
                                        <td><input type="submit" value="新增" name="insert" id="newC"/></td>
                                    </tr>
                                </form>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane fade" id="teacherBase" role="tabpanel">
                        <table class="table table-striped table-borderless">
                            <thead>
                            <tr>
                                <th scope="col">教师编号</th>
                                <th scope="col">教师姓名</th>
                                <th scope="col">教师密码</th>
                                <th scope="col">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${teacherList}" var="teacher">
                                <form action="../TeacherChange.do" method="post">
                                    <tr>
                                        <th scope="row"><input type="text" name="id" value="${teacher.id}"></th>
                                        <td><input type="text" name="name" value="${teacher.name}"></td>
                                        <td><input type="text" name="password" value="${teacher.password}"></td>
                                        <td><input type="submit" value="更改" name="update" id="${teacher.id}"/><input type="submit" value="删除" name="delete" id="${teacher.id}"/></td>
                                    </tr>
                                </form>
                            </c:forEach>
                            <form action="./TeacherChange.do" method="post">
                                <tr>
                                    <th scope="row"><input type="text" name="id" value="教师账号"></th>
                                    <td><input type="text" name="name" value="教师姓名"></td>
                                    <td><input type="text" name="password" value="教师密码"></td>
                                    <td><input type="submit" value="新增" name="insert" id="newT"/></td>
                                </tr>
                            </form>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane fade" id="courseConn" role="tabpanel">
                        <table class="table table-striped table-borderless">
                            <thead>
                            <tr>
                                <th scope="col">课程编号</th>
                                <th scope="col">课程名称</th>
                                <th scope="col">教师编号</th>
                                <th scope="col">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${courseList}" var="tc">
                                <form action="./TCChange.do" method="post">
                                    <tr>
                                        <th scope="row"><input type="text" name="cid" value="${tc.id}" readonly="readonly"></th>
                                        <td><input type="text" value="${tc.name}" readonly="readonly"></td>
                                        <td><input type="text" name="tid" value="${tc.teacher.id}"></td>
                                        <td><input type="submit" value="更改" name="update" id="${tc.id}"/></td>
                                    </tr>
                                </form>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane fade" id="editpsw" role="tabpanel">
                        <form action="./ChangePWD.do" role="form" method="post">
                            <br>
                            <div class="mb-4 row text-center">
                                <label for="uname" class="control-label col-md-3">账号</label>
                                <div class="col-md-8">
                                    <input type="text" id="uname" name="uname" class="form-control" readonly="readonly" value="${sessionScope.account.id}" placeholder=${sessionScope.account.id} />
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
                            <div class="mb-8 row text-center ">
                                <button type="submit" class="btn btn-light">修改</button>
                                <button type="reset" class="btn btn-primary">重置</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous" style=""></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous" style=""></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous" style=""></script>
</body>
</html>
