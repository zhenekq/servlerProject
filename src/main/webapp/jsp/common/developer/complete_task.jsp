<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 15.08.2021
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../style/complete_task.css">
    <title>Hand over the task</title>
    <style>
        <%@include file="../../style/complete_task.css"%>
    </style>
</head>

<body>
<%@include file="../../parts/header.jsp"%>
<main class="main">
    <div class="bg-box">
        <div class="main-wrapper wrapper">
            <h2 class="main-title">Hand over the task</h2>
            <div class="create-box">
                <div class="create-content">
                    <form class="create-form" action="servlet" method="POST">
                        <ul class="create-list list-reset">
                            <li class="create-item">
                                <p class="create-title">File name rules:</p>
                                <p class="create-title">Name your file like USERNAME_TASK_$NAME$.*</p>
                            </li>
                            <li class="create-item">
                                <p class="create-title">Comments:</p>
                                <textarea class="create-input create-texterea btn-reset" cols="35" rows="8"></textarea>
                            </li>
                            <li class="create-item">
                                <div class="input__wrapper">
                                    <input name="file" type="file" name="file" id="input__file" class="input input__file" multiple>
                                    <label for="input__file" class="input__file-button">
<span class="input__file-icon-wrapper"><img class="input__file-icon" src="../../../images/down-arrow.svg" alt="..."
                                            width="25"></span>
                                        <span class="input__file-button-text">Choose file</span>
                                    </label>
                                </div>
                            </li>
                        </ul>
                        <input class="submit-input btn-reset" type="submit" value="Complete">
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>
<%@ include file="../../parts/footer.jsp"%>
<script src="${pageContext.request.contextPath}/jsp/js/main.js"></script>
</body>
</html>
