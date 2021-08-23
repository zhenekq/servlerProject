<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 17.08.2021
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <fmt:setLocale value="${language}" scope="session"/>
    <fmt:setBundle basename="local"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/style/team.css">
    <title>Team info</title>
</head>
<body>
<%@include file="../parts/header.jsp" %>
<main class="main">
    <div class="bg-box">
        <div class="main-wrapper wrapper">
            <h2 style="width: 100%; text-align: center" class="main-title"><fmt:message key="local.team"/>: ${team.name}</h2>
            <ul class="main-list list-reset">
                <li class="main-item">
                    <div class="command-box">
                        <div class="command-title">
                            <h3 class="command-title-text">${team.name}</h3>
                            <div class="command-amount">
                                <p class="command-participants"><fmt:message key="local.participants"/>:</p>
                                <p class="command-participants">${team.currentTeamSize}/</p>
                                <p class="command-participants">${team.teamSize}</p>
                            </div>
                        </div>
                        <div class="command-descr">
                            <p class="descr-text">${team.description}</p>
                            <button style="cursor: pointer" class="btn"><fmt:message key="local.view-participants"/></button>
                            <div class="view-box">
                                <ul class="view-list list-reset">
                                    <c:forEach var="user" items="${users}">
                                        <li style="height: 100%" class="view-item">
                                            <h3 class="view-name">${user.nickname}</h3>
                                            <div class="view-about">
                                                <p class="about-user"><fmt:message key="local.user-about"/>:</p>
                                                <p class="about-text">${user.userInfo.qualification}</p>
                                            </div>
                                            <div class="view-links">
                                                <a href="servlet?command=user_profile&id=${user.id}"
                                                   class="view-link link-reset" target="_blank">
                                                    <p class="edit-text"><fmt:message key="local.view-profile"/></p>
                                                </a>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</main>
<%@include file="../parts/footer.jsp" %>
<script>
    var acc = document.getElementsByClassName("btn");
    var i;
    for (i = 0; i < acc.length; i++) {
        acc[i].onclick = function () {
            this.classList.toggle("active");
            this.nextElementSibling.classList.toggle("show");
        }
    }
</script>
<script src="${pageContext.request.contextPath}/jsp/js/main.js"></script>
</body>
</html>
