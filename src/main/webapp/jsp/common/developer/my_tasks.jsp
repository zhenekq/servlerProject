<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 15.08.2021
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <fmt:setLocale value="${language}" scope="session"/>
    <fmt:setBundle basename="local"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/style/main.css">
    <title><fmt:message key="local.tasks"/> </title>
</head>
<body>
<%@include file="../../parts/header.jsp" %>
<main class="main">
    <div class="main-wrapper wrapper">
        <h2 class="main-title">
            <fmt:message key="local.tasks"/>
        </h2>
        <ul id="main-order-list" class="main-order-list list-reset">
            <c:forEach var="task" items="${tasks}">
                <li class="order-item">
                    <button type="button" class="order-box order-btn btn-reset">
                        <div class="order-title-box">
                            <h3 class="order-title"><c:out value="${task.name}"/></h3>
                            <p class="order-price"><c:out value="${task.status}"/></p>
                        </div>
                        <p class="order-dscr"></p>
                    </button>
                    <div class="order-info">
                        <div class="name-of-customer">
                            <p class="name-text main-text"><fmt:message key="local.team"/>: </p>
                            <h3 class="name">
                                <a class="link-reset" href="?command=show_team&id=${task.teamId}" target="_blank">
                                    <fmt:message key="local.check-team"/>
                                </a>
                            </h3>
                        </div>
                        <div class="technologies">
                            <p class="technologies-text main-text"><fmt:message key="local.task-status"/>: </p>
                            <p class="technologies-stack"><c:out value="${task.status}"/></p>
                        </div>
                        <div class="comand">
                            <p class="comand-text main-text"><fmt:message key="local.task-description"/>: </p>
                            <p class="size-of-comand"><c:out value="${task.description}"/></p>
                        </div>
                        <a class="respond-btn link-reset" href="?command=complete_task_page&id=${task.id}">
                            <p class="respond-text"><fmt:message key="local.complete"/></p>
                        </a>
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
