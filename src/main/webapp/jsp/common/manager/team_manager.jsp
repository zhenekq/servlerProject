<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 10.08.2021
  Time: 16:09
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
            <h2 class="main-title">My team</h2>
            <ul class="main-list list-reset">
                <c:forEach var="team" items="${teams}">
                    <li class="main-item">
                        <div class="command-box">
                            <div class="command-title">
                                <h3 class="command-title-text">${team.key.name}</h3>
                                <div class="command-amount">
                                    <p class="command-participants">Participants:</p>
                                    <p class="command-participants">${team.key.currentTeamSize}/</p>
                                    <p class="command-participants">${team.key.teamSize}</p>
                                </div>
                            </div>
                            <div class="command-descr">
                                <p class="descr-text">${team.key.description}</p>
                                <a href="servlet?command=update_team_page&id=${team.key.id}" class="edit-link link-reset" target="_blank">
                                    <p class="edit-text">Edit team</p>
                                </a>
                                <a href="servlet?command=view_tasks&id=${team.key.id}" class="edit-link link-reset" target="_blank">
                                    <p class="edit-text">View task</p>
                                </a>
                                <button style="cursor: pointer" class="btn">View participants</button>
                                <div class="view-box">
                                    <ul class="view-list list-reset">
                                        <c:forEach var="user" items="${team.value}">
                                            <li style="height: 100%" class="view-item">
                                                <h3 class="view-name">${user.nickname}</h3>
                                                <div class="view-about">
                                                    <p class="about-user">About user:</p>
                                                    <p class="about-text">${user.userInfo.qualification}</p>
                                                </div>
                                                <div class="view-links">
                                                    <a href="servlet?command=user_profile&id=${user.id}" class="view-link link-reset" target="_blank">
                                                        <p class="edit-text">View profile</p>
                                                    </a>
                                                    <a href="servlet?command=delete_teammate&id=${user.id}" class="view-link link-reset">
                                                        <p class="edit-text">Delete</p>
                                                    </a>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
            <a href="?command=create_new_team" class=" add-link link-reset">
                <p class="edit-text">Add command</p>
            </a>
        </div>
    </div>
</main>

<%@include file="../../parts/footer.jsp"%>
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
