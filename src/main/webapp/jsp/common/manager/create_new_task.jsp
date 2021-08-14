<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.08.2021
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/style/new_task.css">
    <title>Project task</title>
    <%--<style>
        <%@include file="../../style/create_new_team.css"%>
    </style>--%>
</head>
<body>
<%@include file="../../parts/header.jsp" %>
<main class="main">
    <div class="bg-box">
        <div class="main-wrapper wrapper">
            <h2 class="main-title">Task for the developers</h2>
            <div class="create-box">
                <div class="create-content">
                    <form class="create-form" action="servlet" method="POST">
                        <input type="hidden" name="command" value="add_new_task"/>
                        <ul class="create-list list-reset">
                            <li class="create-item">
                                <p class="create-title">Name of task:</p>
                                <input class="create-input btn-reset" name="name" type="text">
                            </li>
                            <li class="create-item">
                                <p class="create-title">Task description:</p>
                                <textarea class="create-input create-texterea btn-reset" name="description" cols="35"
                                          rows="8"></textarea>
                            </li>
                            <li class="create-item">
                                <p class="create-title">Choose a command:</p>
                                <div class="form_radio_group">
                                    <c:forEach var="team" items="${teams}">
                                        <div class="form_radio_group-item">
                                            <input id="radio-${team.id}" type="radio" name="team" value="${team.id}">
                                            <label for="radio-${team.id}">${team.name}</label>
                                        </div>
                                    </c:forEach>
                                </div>
                            </li>
                        </ul>
                        <input class="submit-input btn-reset" type="submit" value="Create">
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>
<%@include file="../../parts/footer.jsp" %>
</body>
</html>