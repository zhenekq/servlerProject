<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 19.08.2021
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../style/team.css">
    <title>Commands</title>
    <style>
        <%@include file="../../style/team.css"%>
    </style>

</head>
<body>
<%@include file="../../parts/header.jsp" %>
<main class="main">
    <div class="bg-box">
        <div class="main-wrapper wrapper">
            <h2 style="width: 100%; text-align: center" class="main-title">My team</h2>
            <c:if test="${team.id != 0}">
                <ul class="main-list list-reset">
                    <li class="main-item">
                        <div class="command-box">
                            <div class="command-title">
                                <h3 class="command-title-text">${team.name}</h3>
                                <div class="command-amount">
                                    <p class="command-participants">Participants:</p>
                                    <p class="command-participants">${team.currentTeamSize}/</p>
                                    <p class="command-participants">${team.teamSize}</p>
                                </div>
                            </div>
                            <div class="command-descr">
                                <p class="descr-text">${team.description}</p>
                                <a href="servlet?command=leave_team&id=${team.id}" class="edit-link link-reset"
                                   target="_blank">
                                    <p class="edit-text">Leave team</p>
                                </a>
                                <button style="cursor: pointer" class="btn">View participants</button>
                                <div class="view-box">
                                    <ul class="view-list list-reset">
                                        <c:forEach var="user" items="${users}">
                                            <li style="height: 100%" class="view-item">
                                                <h3 class="view-name">${user.nickname}</h3>
                                                <div class="view-about">
                                                    <p class="about-user">About user:</p>
                                                    <p class="about-text">${user.userInfo.qualification}</p>
                                                </div>
                                                <div class="view-links">
                                                    <a href="servlet?command=user_profile&id=${user.id}"
                                                       class="view-link link-reset" target="_blank">
                                                        <p class="edit-text">View profile</p>
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
            </c:if>
        </div>
    </div>
</main>

<%@include file="../../parts/footer.jsp" %>
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
