<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.08.2021
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Find developer</title>
    <style>
        <%@include file="../../style/main.css"%>
    </style>
</head>
<body>
<%@include file="../../parts/header.jsp"%>
<main class="main">
    <div class="main-wrapper wrapper">
        <h2 class="main-title">Developers</h2>
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
                            <p class="name-text main-text">Developer: </p>
                            <h3 class="name">
                                <a class="link-reset" href="?command=user_profile&id=${developer.id}" target="_blank">
                                    <c:out value="${developer.nickname}"/>
                                </a>
                            </h3>
                        </div>
                        <div class="technologies">
                            <p class="technologies-text main-text">Technologies stack: </p>
                            <p class="technologies-stack"><c:out value="${developer.userInfo.qualification}"/></p>
                        </div>
                        <div class="comand">
                            <p class="comand-text main-text">Country: </p>
                            <p class="size-of-comand"><c:out value="${developer.userInfo.country}"/></p>
                        </div>
                        <div class="deadline">
                            <p class="deadline-text main-text">Contact me there: </p>
                            <p class="deadline-date">
                                <a class="link-reset" href="${developer.userInfo.socialLink}">
                                    <c:out value="${developer.userInfo.socialLink}"/>
                                </a>
                            </p>
                        </div>
                        <a class="respond-btn link-reset" href="?command=add_to_team_page&id=${developer.id}">
                            <p class="respond-text">Add to team</p>
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
