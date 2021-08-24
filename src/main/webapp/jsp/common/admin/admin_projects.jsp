<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 15.08.2021
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <fmt:setLocale value="${language}" scope="session"/>
    <fmt:setBundle basename="local"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><fmt:message key="local.projects"/> </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/style/main.css">

</head>
<body>
<jsp:include page="../../parts/header.jsp"/>
<main class="main">
    <div class="main-wrapper wrapper">
        <h2 class="main-title"><fmt:message key="local.projects"/></h2>
        <ul id="main-order-list" class="main-order-list list-reset">
            <c:forEach var="project" items="${projects}">
                <li class="order-item">
                    <button type="button" class="order-box order-btn btn-reset">
                        <div class="order-title-box">
                            <h3 class="order-title"><c:out value="${project.key.title}"/></h3>
                            <p class="order-price"><c:out value="${project.key.cost}"/>$</p>
                        </div>
                        <p class="order-dscr"><c:out value="${project.key.description}"/></p>
                    </button>
                    <div class="order-info">
                        <div class="name-of-customer">
                            <p class="name-text main-text"><fmt:message key="local.name-customer"/>: </p>
                            <h3 class="name">
                                <a class="link-reset" href="?command=user_profile&id=${project.value.id}"
                                   target="_blank">
                                    <c:out value="${project.value.nickname}"/>
                                </a>
                            </h3>
                        </div>
                        <div class="technologies">
                            <p class="technologies-text main-text"><fmt:message key="local.technologies-stack"/>: </p>
                            <p class="technologies-stack"><c:out value="${project.key.qualification}"/></p>
                        </div>
                        <div class="comand">
                            <p class="comand-text main-text"><fmt:message key="local.team-size"/>: </p>
                            <p class="size-of-comand"><c:out value="${project.key.teamSize}"/></p>
                        </div>
                        <div class="deadline">
                            <p class="deadline-text main-text"><fmt:message key="local.deadline"/>: </p>
                            <p class="deadline-date"><c:out value="${project.key.deadline}"/></p>
                        </div>
                        <div class="deadline">
                            <p class="deadline-text main-text"><fmt:message key="local.projects-status"/>: </p>
                            <p class="deadline-date"><c:out value="${project.key.status}"/></p>
                        </div>
                        <div style="display: flex">
                            <a class="respond-btn link-reset" href="?command=edit_project&id=${project.key.id}">
                                <p class="respond-text"><fmt:message key="local.edit"/></p>
                            </a>
                            <c:set var="status" value="${project.key.status}"/>
                            <c:if test="${status.equals('CLOSED_FOR_REQUESTS')}">
                                <a style="width: 140px" class="respond-btn link-reset"
                                   href="?command=open_requests_for_project&id=${project.key.id}">
                                    <p style="width: 110px" class="respond-text"><fmt:message key="local.unblock"/></p>
                                </a>
                            </c:if>
                            <c:if test="${status.equals('OPEN_FOR_REQUESTS')}">
                                <a style="width: 140px" class="respond-btn link-reset"
                                   href="?command=close_requests_for_project&id=${project.key.id}">
                                    <p style="width: 110px" class="respond-text"><fmt:message key="local.block"/></p>
                                </a>
                            </c:if>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</main>
<jsp:include page="../../parts/footer.jsp"/>
<script src="${pageContext.request.contextPath}/jsp/js/main.js"></script>
</body>
</html>
