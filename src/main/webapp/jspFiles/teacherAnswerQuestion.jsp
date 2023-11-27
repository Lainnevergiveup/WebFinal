<%--
  Created by IntelliJ IDEA.
  User: lain
  Date: 2022/12/21
  Time: 00:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">
    <title>问题编辑</title>

</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container"> <button class="navbar-toggler navbar-toggler-right border-0 p-0" type="button" data-toggle="collapse" data-target="#navbar20">
        <p class="navbar-brand text-white mb-0">
            <i class="fa d-inline fa-lg fa-stop-circle"></i> Web课后辅导系统教师端 </p>
    </button>
        <div class="collapse navbar-collapse" id="navbar20">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item"> <a class="nav-link" href="../index.jsp">Home</a> </li>
                <li class="nav-item"> <a class="nav-link" href="#">About</a> </li>
            </ul>
            <p class="d-none d-md-block lead mb-0 text-white"> <i class="fa d-inline fa-lg fa-stop-circle"></i> <b> Web课后辅导系统教师端</b> </p>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item mx-1"> <a class="nav-link" href="https://github.com/Lainnevergiveup/WebFinal">
                    <i class="fa fa-github fa-fw fa-lg"></i>
                </a> </li>
                <li class="nav-item mx-1"> <a class="nav-link" href="../index.jsp">
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
                    <li class="nav-item"> <a href="" class="active nav-link" data-toggle="pill" data-target="#questionDetail">提问详情</a> </li>
                </ul>
            </div>
            <div class="col-9 col-md-10 h-100 w-100" style="height: 100%">
                <div class="tab-content">
                    <div class="tab-pane fade show active h-100" id="questionDetail" role="tabpanel" height="100%">
                            <c:if test="${!empty q}">
                            <div class="card" >
                                <div class="card-body">
                                    <h5 class="card-title"><b>${q.title}</b></h5>
                                    <h6 class="card-subtitle my-2 text-muted">${q.state}</h6>
                                    <p class="card-text">${q.question}</p>
                                </div>
                            </div>
                            <form action="./questionEdit.do?method=ans" method="post">
                                <div class="form-group">
                                    <input type="text" name="answer"class="form-control" value="${q.answer}"/>
                                    <input type="submit" name="method"class="form-control" value="ans"/>
                                </div>
                            </form>
                            </c:if>
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
