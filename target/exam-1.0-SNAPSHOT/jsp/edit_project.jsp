<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 05.08.2021
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit project</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/style/new_project.css">
    <style>
        <%@include file="style/new_project.css"%>
    </style>
</head>
<body>
<jsp:include page="parts/header.jsp"/>
<main class="main">
    <div class="bg-box">
        <div class="main-wrapper wrapper">
            <form class="progect-form" action="servlet" method="POST">
                <input type="hidden" name="command" value="update_project">
                <div class="progect-form-content">
                    <h2 class="main-title">Filling out the order form</h2>
                    <ul class="progect-list list-reset">
                        <li class="progect-item">
                            <p class="progect-subtitle">Title of order form:</p>
                            <input type="text" name="title" value="${project.title}" class="progect-input btn-reset">
                        </li>
                        <li class="progect-item">
                            <p class=" textarea-text">Short description:</p>
                            <textarea name="description" class="progect-textarea btn-reset" cols="40" rows="5">
                                <c:out value="${project.description}"/>
                            </textarea>
                        </li>
                        <li class="progect-item">
                            <p class=" textarea-text">Stack of technologies:</p>
                            <textarea name="qualification" class="progect-textarea btn-reset" cols="40" rows="5">
                                <c:out value="${project.qualification}"/>
                            </textarea>
                        </li>
                        <li class="progect-item">
                            <p class="progect-subtitle">Team size:</p>
                            <input type="text" name="teamSize" value="${project.teamSize}" class="progect-input btn-reset">
                        </li>
                        <li class="progect-item">
                            <p class="progect-subtitle">Deadline: </p>
                            <input type="text" name="deadline" value="${project.deadline}" class="progect-input btn-reset">
                        </li>
                        <li class="progect-item">
                            <p class="progect-subtitle">Prise: </p>
                            <input type="text" name="cost"  value="${project.cost}" class="progect-input btn-reset">
                        </li>
                    </ul>
                    <input class="submit-input btn-reset" type="submit" value="Update">
                </div>
            </form>
        </div>
    </div>
</main>
<jsp:include page="parts/footer.jsp"/>
</body>
</html>
