<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 06.08.2021
  Time: 11:27
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/style/main.css">
    <title><fmt:message key="local.project-responses"/> </title>

</head>
<body>
<%@include file="../../parts/header.jsp" %>
<main class="main">
    <div class="main-wrapper wrapper">
        <h2 class="main-title" style="width: 340px"><fmt:message key="local.project-responses"/></h2>
        <ul id="main-order-list" class="main-order-list list-reset">
            <c:forEach var="response" items="${projectResponses}">
                <li class="order-item">
                    <button type="button" class="order-box order-btn btn-reset">
                        <div class="order-title-box">
                            <h3 class="order-title"><fmt:message key="local.project-resp"/></h3>
                            <p class="order-price"><c:out value="${response.status}"/></p>
                        </div>
                    </button>
                    <div class="order-info">
                        <div class="name-of-customer">
                            <p class="name-text main-text"><fmt:message key="local.manager"/>: </p>
                            <h3 class="name">
                                <a class="link-reset" href="?command=user_profile&id=${response.responsibleId}" target="_blank">
                                    <fmt:message key="local.check-manager-info"/>
                                </a>
                            </h3>
                        </div>
                        <div class="name-of-customer">
                            <p class="name-text main-text"><fmt:message key="local.project"/>: </p>
                            <h3 class="name">
                                <a class="link-reset" href="?command=project_info&id=${response.projectId}" target="_blank">
                                    <fmt:message key="local.check-project"/>
                                </a>
                            </h3>
                        </div>
                        <div class="technologies">
                            <p class="technologies-text main-text"><fmt:message key="local.technologies-stack"/>: </p>
                            <p class="technologies-stack"><c:out value="${response.projectDetails}"/></p>
                        </div>
                        <div class="comand">
                            <p class="comand-text main-text"><fmt:message key="local.project-cost"/>: </p>
                            <p class="size-of-comand"><c:out value="${response.possiblePrice}"/></p>
                        </div>
                        <div class="deadline">
                            <p class="deadline-text main-text"><fmt:message key="local.deadline"/>: </p>
                            <p class="deadline-date"><c:out value="${response.deadline}"/></p>
                        </div>
                        <div style="display: flex">
                            <c:set var="status" value="${response.status}"/>
                            <c:if test="${status.equals('WAITING_FOR_RESPONSE')}">
                                <a class="respond-btn link-reset"
                                   href="?command=approve_project_request&id=${response.id}">
                                    <p class="respond-text"><fmt:message key="local.approve"/></p>
                                </a>
                                <a class="respond-btn link-reset"
                                   href="?command=reject_project_request&id=${response.id}">
                                    <p class="respond-text"><fmt:message key="local.reject"/></p>
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
