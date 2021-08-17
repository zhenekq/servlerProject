<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 17.08.2021
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../style/create_new_team.css">
    <style>
        <%@include file="../../style/create_new_team.css"%>
    </style>
    <title>Update team</title>
</head>

<body>
<%@include file="../../parts/header.jsp"%>
<main class="main">
    <div class="bg-box">
        <div class="main-wrapper wrapper">
            <h2 class="main-title">Update team</h2>
            <div class="create-box">
                <div class="create-content">
                    <form class="create-form" action="servlet" method="POST">
                        <input type="hidden" name="command" value="update_team">
                        <ul class="create-list list-reset">
                            <li class="create-item">
                                <p class="create-title">Name of command:</p>
                                <input class="create-input btn-reset" name="name" value="${team.name}" type="text">
                            </li>
                            <li class="create-item">
                                <p class="create-title">Command description:</p>
                                <textarea class="create-input create-texterea btn-reset" name="description" cols="35" rows="8">${team.description}</textarea>
                            </li>
                            <li class="create-item">
                                <p class="create-title">Amount of participants:</p>
                                <input class="create-input btn-reset" name="teamSize" value="${team.teamSize}" min="0" max="100" type="number">
                            </li>
                        </ul>
                        <input class="submit-input btn-reset" type="submit" value="Update">
                    </form>
                    <div>${error}</div>
                </div>
            </div>
        </div>
    </div>
</main>
<%@include file="../../parts/footer.jsp"%>
<script>
    var acc = document.getElementsByClassName("btn");
    var i;
    for(i=0;i<acc.length; i++){
        acc[i].onclick = function() {
            this.classList.toggle("active");
            this.nextElementSibling.classList.toggle("show");
        }
    }
</script>
<script src="${pageContext.request.contextPath}/jsp/js/main.js"></script>
</body>

</html>