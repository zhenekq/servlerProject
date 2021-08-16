<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12.08.2021
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My projects</title>
    <link rel="stylesheet" href="../../style/main.css">
    <style>
        <%@include file="../../style/main.css"%>
    </style>
</head>
<body>
<%@include file="../../parts/header.jsp" %>
<main class="main">
    <div class="main-wrapper wrapper">
        <h2 class="main-title" style="width: 310px">Managed projects</h2>
        <ul id="main-order-list" class="main-order-list list-reset">
            <c:forEach var="response" items="${projectResponses}">
                <li class="order-item">
                    <button type="button" class="order-box order-btn btn-reset">
                        <div class="order-title-box">
                            <h3 class="order-title"><%--<c:out value="${response.ownerId}"/><--%>Project status</h3>
                            <p class="order-price"><c:out value="${response.status}"/></p>
                        </div>
                            <%--<p class="order-dscr"><c:out value="${response.projectId}"/></p>--%>
                    </button>
                    <div class="order-info">
                        <div class="name-of-customer">
                            <p class="name-text main-text">Customer: </p>
                            <h3 class="name">
                                <a class="link-reset" href="?command=user_profile&id=${response.ownerId}"
                                   target="_blank">
                                    Check owner of project
                                </a>
                            </h3>
                        </div>
                        <div class="name-of-customer">
                            <p class="name-text main-text">Project: </p>
                            <h3 class="name">
                                <a class="link-reset" href="?command=project_info&id=${response.projectId}"
                                   target="_blank">
                                    Check project
                                </a>
                            </h3>
                        </div>
                        <div class="technologies">
                            <p class="technologies-text main-text">Technologies stack: </p>
                            <p class="technologies-stack"><c:out value="${response.projectDetails}"/></p>
                        </div>
                        <div class="comand">
                            <p class="comand-text main-text">Project Cost: </p>
                            <p class="size-of-comand"><c:out value="${response.possiblePrice}"/></p>
                        </div>
                        <div class="deadline">
                            <p class="deadline-text main-text">Deadline: </p>
                            <p class="deadline-date"><c:out value="${response.deadline}"/></p>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</main>
<script src="${pageContext.request.contextPath}/jsp/js/main.js"></script>
<%@include file="../../parts/footer.jsp" %>
</body>
</html>
