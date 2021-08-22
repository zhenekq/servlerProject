<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 17.08.2021
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/jsp/style/main.css">
    <title>Tasks</title>
</head>
<body>
<%@include file="../../parts/header.jsp" %>
<main class="main">
    <div class="main-wrapper wrapper">
        <h2 class="main-title">Tasks</h2>
        <ul id="main-order-list" class="main-order-list list-reset">
            <c:forEach var="task" items="${tasks}">
                <li class="order-item">
                    <button type="button" class="order-box order-btn btn-reset">
                        <div class="order-title-box">
                            <h3 class="order-title"><c:out value="${task.name}"/></h3>
                            <p class="order-price"><c:out value="${task.status}"/></p>
                        </div>
                        <p class="order-dscr"><%--<c:out value="${manager.userInfo.qualification}"/>--%></p>
                    </button>
                    <div class="order-info">
                        <div class="name-of-customer">
                            <p class="name-text main-text">Team: </p>
                            <h3 class="name">
                                <a class="link-reset" href="?command=show_team&id=${task.teamId}" target="_blank">
                                    Check team
                                </a>
                            </h3>
                        </div>
                        <div class="technologies">
                            <p class="technologies-text main-text">Task status: </p>
                            <p class="technologies-stack"><c:out value="${task.status}"/></p>
                        </div>
                        <div class="comand">
                            <p class="comand-text main-text">Description: </p>
                            <p class="size-of-comand"><c:out value="${task.description}"/></p>
                        </div>
                        <div style="display: flex">
                            <a class="respond-btn link-reset" href="?command=edit_task&id=${task.id}">
                                <p class="respond-text">Edit</p>
                            </a>
                            <a class="respond-btn link-reset" href="?command=delete_task&id=${task.id}">
                                <p class="respond-text">Delete</p>
                            </a>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</main>
<%@include file="../../parts/footer.jsp" %>
<script src="${pageContext.request.contextPath}/jsp/js/main.js"></script>
</body>
</html>
