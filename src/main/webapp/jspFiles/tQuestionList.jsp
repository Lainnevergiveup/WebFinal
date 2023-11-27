<%--
  Created by IntelliJ IDEA.
  User: lain
  Date: 2022/12/21
  Time: 00:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"   isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>提问列表</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">
</head>

<body>

<div class="py-5 h-100 w-100">
    <div class="container w-100 h-100" style="height: 100%">
        <div class="row" style="height: 100%">
            <div class="col-3 col-md-2" style="">
                <ul class="nav nav-pills flex-column">
                    <li class="nav-item"> <a href="" class="active nav-link" data-toggle="pill" data-target="#chooseCourse">提问列表</a> </li>
                </ul>
            </div>
            <div class="col-9 col-md-10 h-100 w-100" style="height: 100%">
                <div class="tab-content">
                    <div class="tab-pane fade show active h-100" id="questionList" role="tabpanel" height="100%">
                        <c:forEach items="${questionList}" var="q">
                            <div class="card" >
                                <div class="card-body">
                                    <h5 class="card-title"><b>${q.title}</b></h5>
                                    <h6 class="card-subtitle my-2 text-muted">${q.state}</h6>
                                    <p class="card-text">${q.question}</p>
                                    <a href="./questionDetail.do?qid=${q.id}" class="card-link">回复</a>
                                    <a href="./deletequestion.do?qid=${q.id}" class="card-link">删除</a>
                                </div>
                            </div>
                        </c:forEach>
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
