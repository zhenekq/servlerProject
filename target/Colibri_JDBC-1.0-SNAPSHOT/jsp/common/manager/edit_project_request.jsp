<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 10.08.2021
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/style/project.css">
    <title>Edit project request</title>
</head>
<body>
<%@include file="../../parts/header.jsp"%>

<main class="main">
    <div class="bg-box"></div>
    <div class="response-box">
        <form class="responce-form" action="servlet" method="POST">
            <input type="hidden" name="command" value="update_project_request"/>
            <ul class="responce-list list-reset">
                <li class="responce-item">
                    <h2 class="responce-subtitle">Owner:</h2>
                    <a class="responce-info link-reset" href="?command=user_profile&id=${response.ownerId}">Owner of project</a>
                </li>
                <li class="responce-item">
                    <h2 class="responce-subtitle">Progect details:</h2>
                    <textarea class="responce-textarea btn-reset" name="details" cols="40" rows="8">
                        <c:out value="${response.projectDetails}"/>
                    </textarea>
                </li>
                <li class="responce-item">
                    <h2 class="responce-subtitle">Cost:</h2>
                    <input type="text" name="cost" value="${response.possiblePrice}" class="responce-input btn-reset">
                </li>
                <li class="responce-item">
                    <h2 class="responce-subtitle">Date:</h2>
                    <input type="date" value="${response.deadline}" name="date" class="responce-input responce-date btn-reset">
                </li>
            </ul>
            <input class="responce-submit btn-reset" type="submit" value="Submit">
        </form>
    </div>
    </div>
</main>
<jsp:include page="../../parts/footer.jsp"/>
<script src="${pageContext.request.contextPath}/jsp/js/project_form.js"></script>

</body>
</html>
