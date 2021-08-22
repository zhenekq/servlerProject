<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25.07.2021
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add new project</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/style/new_project.css">
</head>
<body>
<jsp:include page="../../parts/header.jsp"/>
<main class="main">
    <div class="bg-box">
        <div class="main-wrapper wrapper">
            <form style="left: 25%" class="progect-form" action="servlet" method="POST">
                <input type="hidden" name="command" value="add_new_project">

                <div class="progect-form-content">
                    <h2 class="main-title">Create new project</h2>
                    <ul class="progect-list list-reset">
                        <li class="progect-item">
                            <p class="progect-subtitle">Title of order form:</p>
                            <input type="text" name="title" class="progect-input btn-reset">
                        </li>
                        <li class="progect-item">
                            <p class=" textarea-text">Short description:</p>
                            <textarea name="description" class="progect-textarea btn-reset" cols="40" rows="5"></textarea>
                        </li>
                        <li class="progect-item">
                            <p class=" textarea-text">Stack of technologies:</p>
                            <textarea name="qualification" class="progect-textarea btn-reset" cols="40" rows="5"></textarea>
                        </li>
                        <li class="progect-item">
                            <p class="progect-subtitle">Team size:</p>
                            <input type="text" name="teamSize" class="progect-input btn-reset">
                        </li>
                        <li class="progect-item">
                            <p class="progect-subtitle">Deadline: </p>
                            <input type="text" name="deadline" class="progect-input btn-reset">
                        </li>
                        <li class="progect-item">
                            <p class="progect-subtitle">Prise: </p>
                            <input type="text" name="cost" class="progect-input btn-reset">
                        </li>
                    </ul>
                    <input class="submit-input btn-reset" type="submit" value="Save">
                </div>
            </form>
        </div>
    </div>
</main>
<jsp:include page="../../parts/footer.jsp"/>
<script src="${pageContext.request.contextPath}/jsp/js/project_form.js"></script>
</body>
</html>