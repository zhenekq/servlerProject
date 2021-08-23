<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.08.2021
  Time: 13:29
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/style/main.css">
    <title><fmt:message key="local.find-developer"/> </title>
</head>
<body>
<%@include file="../../parts/header.jsp"%>
<main class="main">
    <div class="main-wrapper wrapper">
        <h2 style="text-align: center" class="main-title"><fmt:message key="local.developers"/> </h2>
        <ul id="main-order-list" class="main-order-list list-reset">
            <c:forEach var="developer" items="${developers}">
                <li class="order-item">
                    <button type="button" class="order-box order-btn btn-reset">
                        <div class="order-title-box">
                            <h3 class="order-title"><c:out value="${developer.nickname}"/></h3>
                            <p class="order-price"><c:out value="${developer.userInfo.city}"/></p>
                        </div>
                        <p class="order-dscr"><%--<c:out value="${manager.userInfo.qualification}"/>--%></p>
                    </button>
                    <div class="order-info">
                        <div class="name-of-customer">
                            <p class="name-text main-text"><fmt:message key="local.developer"/>: </p>
                            <h3 class="name">
                                <a class="link-reset" href="?command=user_profile&id=${developer.id}" target="_blank">
                                    <c:out value="${developer.nickname}"/>
                                </a>
                            </h3>
                        </div>
                        <div class="technologies">
                            <p class="technologies-text main-text"><fmt:message key="local.technologies-stack"/>: </p>
                            <p class="technologies-stack"><c:out value="${developer.userInfo.qualification}"/></p>
                        </div>
                        <div class="comand">
                            <p class="comand-text main-text"><fmt:message key="local.country"/>: </p>
                            <p class="size-of-comand"><c:out value="${developer.userInfo.country}"/></p>
                        </div>
                        <div class="deadline">
                            <p class="deadline-text main-text"><fmt:message key="local.contact-me"/>: </p>
                            <p class="deadline-date">
                                <a class="link-reset" href="${developer.userInfo.socialLink}">
                                    <c:out value="${developer.userInfo.socialLink}"/>
                                </a>
                            </p>
                        </div>
                        <a class="respond-btn link-reset" href="?command=add_to_team_page&id=${developer.id}">
                            <p class="respond-text">
                                <fmt:message key="local.add"/>
                            </p>
                        </a>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</main>
<%@include file="../../parts/footer.jsp"%>
<script src="${pageContext.request.contextPath}/jsp/js/main.js"></script>
</body>
</html>
