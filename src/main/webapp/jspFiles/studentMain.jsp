<%--
  Created by IntelliJ IDEA.
  User: lain
  Date: 2022/12/20
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>学生主页</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container"> <button class="navbar-toggler navbar-toggler-right border-0 p-0" type="button" data-toggle="collapse" data-target="#navbar20">
        <p class="navbar-brand text-white mb-0">
            <i class="fa d-inline fa-lg fa-stop-circle"></i> Web课后辅导系统学生端 </p>
    </button>
        <div class="collapse navbar-collapse" id="navbar20">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item"> <a class="nav-link" href="./index.jsp">Home</a> </li>
                <li class="nav-item"> <a class="nav-link" href="#">About</a> </li>
            </ul>
            <p class="d-none d-md-block lead mb-0 text-white"> <i class="fa d-inline fa-lg fa-stop-circle"></i> <b> Web课后辅导系统学生端</b> </p>
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
                    <li class="nav-item"> <a href="" class="active nav-link" data-toggle="pill" data-target="#chooseCourse">选课</a> </li>
                    <li class="nav-item"> <a class="nav-link" href="" data-toggle="pill" data-target="#questionList">课程列表</a> </li>
                    <li class="nav-item"> <a href="" class="nav-link" data-toggle="pill" data-target="#editpsw">修改密码</a> </li>
                </ul>
            </div>
            <div class="col-9 col-md-10 h-100 w-100" style="height: 100%">
                <div class="tab-content">
                    <div class="tab-pane fade show active h-100" id="chooseCourse" role="tabpanel" height="100%">
                        <table class="table table-striped table-borderless">
                            <thead>
                            <tr>
                                <th scope="col">课程编号</th>
                                <th scope="col">课程名称</th>
                                <th scope="col">授课教师</th>
                                <th scope="col">课程评分</th>
                                <th scope="col">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${courseList}" var="course">
                                <tr>
                                    <th scope="row">${course.id}</th>
                                    <td>${course.name}</td>
                                    <td>${course.teacher.name}</td>
                                    <td>${course.score}</td>
                                    <td>
                                        <form action="./Select.do" method="post">
                                            <input class="btn-primary" type="submit"  value="选中?${course.id}" placeholder="选中" name="select" id="${course.id}"/>
                                            <input class="btn-primary" type="submit"  value="删除?${course.id}" placeholder="删除" name="delete" id="${course.id}"/>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                    </div>
                    <div class="tab-pane fade" id="questionList" role="tabpanel">
                        <form class="form-inline mb-0">
                            <div class="input-group"> <input type="text" class="form-control" placeholder="搜索" id="form2"/>
                                <div class="input-group-append"> <button class="btn btn-primary" type="button">搜索</button> </div>
                            </div>
                        </form>
                        <c:forEach items="${stucourseList}" var="course">
                            <div class="card" >
                                <div class="card-body">
                                    <h5 class="card-title"><b>${course.name}</b></h5>
                                    <h6 class="card-subtitle my-2 text-muted">${course.teacher.name}</h6>
                                    <p class="card-text">${course.description}</p>
                                    <a href="./course.do?cid=${course.id}" class="card-link">查看详情</a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="tab-pane fade" id="editpsw" role="tabpanel">
                        <form action="./ChangePWD.do" role="form" method="post">
                            <br>
                            <div class="mb-4 row text-center">
                                <label for="uname" class="control-label col-md-3">账号</label>
                                <div class="col-md-8">
                                    <input type="text" id="uname" name="uname" class="form-control" readonly="readonly" value="${sessionScope.account.id}" placeholder=""${sessionScope.account.id}" />
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
<%--<script type="text/javascript">--%>
<%--    //选择课程--%>
<%--    $(document).ready(--%>
<%--        function choose() {--%>
<%--            $("input[name='select']").click(function(){--%>
<%--                var node = $(this);--%>
<%--                //获取剩余量--%>
<%--                var nodeId = $(this).attr("id").split("+")[0];--%>
<%--                //通过td里面的元素获得tr,使用tr的children（“td”） 方法获取所有的td，在通过eq(1) 拿第二个td--%>
<%--                var remainNum = $(this).parent().parent().children("td").eq(1).html();--%>
<%--                console.log(remainNum);--%>
<%--                if (!(remainNum == "0")) {--%>
<%--                    $.ajax({--%>
<%--                        url:"../CourseChange.do?random="+ Math.random()%10987,   //请求的url地址--%>
<%--                        dataType:'json',    //返回格式为json--%>
<%--                        async:true,    //请求是否异步，默认为异步，这也是ajax重要特性--%>
<%--                        data:{"id":$(this).attr("id")},    //参数值--%>
<%--                        type:'POST',    //请求方式--%>
<%--                        beforeSend:function(){--%>
<%--                            //请求前的处理--%>
<%--                            // alert("haha")--%>
<%--                        },--%>
<%--                        success:function(req){--%>
<%--                            //请求成功时处理--%>
<%--                            //node.parent().parent().remove();--%>
<%--                            node.parent().parent().children("td").eq(1).html(parseInt(remainNum)-parseInt(1));--%>
<%--                            alert("已选中！");--%>
<%--                            document.getElementById("stuInfoIframe").contentWindow.location.reload(true);--%>
<%--                        },--%>
<%--                        complete:function(){--%>
<%--                            //请求完成的处理--%>
<%--                            //alert("请求完成！");--%>
<%--                        },--%>
<%--                        error:function(){--%>
<%--                            //请求出错处理--%>
<%--                            alert("重复选择！");--%>
<%--                        }--%>
<%--                    });--%>
<%--                } else {--%>
<%--                    alert("此课程人数已满！");--%>
<%--                }--%>
<%--            });--%>
<%--        });--%>
<%--</script>--%>
</body>
</html>
