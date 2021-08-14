<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14.08.2021
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/style/new_task.css">
    <title>Add to team</title>
</head>
<body>
<%@include file="../../parts/header.jsp" %>
<main class="main">
    <div class="bg-box">
        <div class="main-wrapper wrapper">
            <h2 class="main-title">Add developer to team</h2>
            <div class="create-box">
                <div class="create-content">
                    <form class="create-form" action="servlet" method="POST">
                        <input type="hidden" name="command" value="add_to_team"/>
                        <ul class="create-list list-reset">
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
                        <input class="submit-input btn-reset" type="submit" value="Add to team">
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>
<%@include file="../../parts/footer.jsp" %>
</body>
</html>
