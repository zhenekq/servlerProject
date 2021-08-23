<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12.08.2021
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <fmt:setLocale value="${language}" scope="session"/>
    <fmt:setBundle basename="local"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/style/project_view.css">
    <title><fmt:message key="local.project"/></title>
</head>

<body>
<%@include file="../parts/header.jsp"%>
<main class="main">
    <div class="bg-box">
        <div class="main-wrapper wrapper">
            <h2 style="width: 175px; text-align: center" class="main-title"><fmt:message key="local.project"/></h2>
            <ul class="main-order-list list-reset">
                <li class="order-item">
                    <button type="button" class="order-box order-btn btn-reset">
                        <div class="order-title-box">
                            <h3 class="order-title">${project.title}</h3>
                            <p class="order-price">${project.cost}$</p>
                        </div>
                        <p class="order-dscr">${project.description}</p>
                    </button>
                    <div class="order-info">
                        <div class="name-of-customer">
                            <p class="name-text main-text"><fmt:message key="local.customer"/>: </p>
                            <h3 class="name">
                                <a class="link-reset" style="text-decoration: underline" href="?command=user_profile&id=${project.user_id}" target="_blank">
                                    <fmt:message key="local.check-owner-of-project"/>
                                </a>
                            </h3>
                        </div>
                        <div class="technologies">
                            <p class="technologies-text main-text"><fmt:message key="local.technologies-stack"/>: </p>
                            <p class="technologies-stack">${project.qualification}</p>
                        </div>
                        <div class="comand">
                            <p class="comand-text main-text"><fmt:message key="local.team-size"/>: </p>
                            <p class="size-of-comand">${project.teamSize} people</p>
                        </div>
                        <div class="deadline">
                            <p class="deadline-text main-text"><fmt:message key="local.deadline"/>: </p>
                            <p class="deadline-date">${project.deadline}</p>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</main>
<jsp:include page="../parts/footer.jsp"/>
<script src="${pageContext.request.contextPath}/jsp/js/main.js"></script>
</body>
</html>
