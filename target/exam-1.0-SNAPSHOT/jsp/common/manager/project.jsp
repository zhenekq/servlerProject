<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25.07.2021
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/style/project.css">
    <title>Order response</title>
</head>
<body>
<%@include file="../../parts/header.jsp"%>

<main class="main">
    <div class="bg-box"></div>
    <div class="response-box">
        <form class="responce-form" action="servlet" method="POST">
            <input type="hidden" name="command" value="response_for_project"/>
            <ul class="responce-list list-reset">
                <li class="responce-item">
                    <h2 class="responce-subtitle">Owner:</h2>
                    <a class="responce-info link-reset" href="?command=user_profile&id=${project.user_id}">Owner of project</a>
                </li>
                <li class="responce-item">
                    <h2 class="responce-subtitle">Progect details:</h2>
                    <textarea class="responce-textarea btn-reset" name="details" cols="40" rows="8"></textarea>
                </li>
                <li class="responce-item">
                    <h2 class="responce-subtitle">Cost:</h2>
                    <input type="text" name="cost" class="responce-input btn-reset">
                </li>
                <li class="responce-item">
                    <h2 class="responce-subtitle">Date:</h2>
                    <input type="date" value="2021-01-01" name="date" class="responce-input responce-date btn-reset">
                </li>
            </ul>
            <input class="responce-submit btn-reset" type="submit" value="Submit">
        </form>
    </div>
    </div>
</main>
<footer class="footer">
    <div class="footer-wrapper wrapper">
        <div class="left-header">
            <div class="header-logo">
                <svg class="footer-logo" enable-background="new 0 0 24 24" height="50" viewBox="0 0 24 24" width="50"
                     xmlns="http://www.w3.org/2000/svg">
                    <path
                            d="m8.843 12.651c-1.392 0-2.521 1.129-2.521 2.521v6.306c0 1.392 1.129 2.521 2.521 2.521s2.521-1.129 2.521-2.521v-6.306c-.001-1.392-1.13-2.521-2.521-2.521z" />
                    <path
                            d="m.019 15.172c0 1.393 1.13 2.523 2.523 2.523s2.523-1.13 2.523-2.523v-2.523h-2.521c-.001 0-.001 0-.002 0-1.393 0-2.523 1.13-2.523 2.523z" />
                    <path
                            d="m8.846-.001c-.001 0-.002 0-.003 0-1.393 0-2.523 1.13-2.523 2.523s1.13 2.523 2.523 2.523h2.521c0-1.431 0-1.083 0-2.528-.001-1.391-1.128-2.518-2.518-2.518z" />
                    <path
                            d="m2.525 11.37h6.318c1.393 0 2.523-1.13 2.523-2.523s-1.13-2.523-2.523-2.523h-6.318c-1.393 0-2.523 1.13-2.523 2.523s1.13 2.523 2.523 2.523z" />
                    <path
                            d="m21.457 6.323c-1.391 0-2.518 1.127-2.518 2.518v.005 2.523h2.521c1.393 0 2.523-1.13 2.523-2.523s-1.13-2.523-2.523-2.523c-.001 0-.002 0-.003 0z" />
                    <path
                            d="m12.641 2.522v6.325c0 1.392 1.129 2.521 2.521 2.521s2.521-1.129 2.521-2.521v-6.325c0-1.392-1.129-2.521-2.521-2.521-1.392 0-2.521 1.129-2.521 2.521z" />
                    <path
                            d="m17.682 21.476c0-1.392-1.129-2.521-2.521-2.521h-2.521v2.523c.001 1.391 1.129 2.519 2.521 2.519s2.521-1.129 2.521-2.521z" />
                    <path
                            d="m21.479 12.649h-6.318c-1.393 0-2.523 1.13-2.523 2.523s1.13 2.523 2.523 2.523h6.318c1.393 0 2.523-1.13 2.523-2.523s-1.13-2.523-2.523-2.523z" />
                </svg>
            </div>
            <p class="footer-subtitle">©Yauheny Vozny - 2021</p>
        </div>
        <div class="right-header">
            <button class="footer-logout btn-reset"><a class="header-btn-link">Logout</a></button>
        </div>
    </div>
</footer>
<script src="/jsp/js/project_form.js"></script>
</body>
</html>
