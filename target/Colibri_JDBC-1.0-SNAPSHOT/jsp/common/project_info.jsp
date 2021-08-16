<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12.08.2021
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/style/project_view.css">
    <title>Project view</title>
</head>

<body>
<%@include file="../parts/header.jsp"%>
<main class="main">
    <div class="bg-box">
        <div class="main-wrapper wrapper">
            <h2 style="width: 175px" class="main-title">Project view</h2>
            <ul class="main-order-list list-reset">
                <li class="order-item">
                    <button type="button" class="order-box order-btn btn-reset">
                        <div class="order-title-box">
                            <h3 class="order-title">${project.title}</h3>
                            <p class="order-price">${project.cost}$</p>
                        </div>
                        <p class="order-dscr">${project.description}</p>
                    </button>
                    <div class="order-info">
                        <div class="name-of-customer">
                            <p class="name-text main-text">Customer: </p>
                            <h3 class="name">
                                <a class="link-reset" style="text-decoration: underline" href="?command=user_profile&id=${project.user_id}" target="_blank">
                                    Check owner of project
                                </a>
                            </h3>
                        </div>
                        <div class="technologies">
                            <p class="technologies-text main-text">Technologies stack: </p>
                            <p class="technologies-stack">${project.qualification}</p>
                        </div>
                        <div class="comand">
                            <p class="comand-text main-text">Size of command: </p>
                            <p class="size-of-comand">${project.teamSize} people</p>
                        </div>
                        <div class="deadline">
                            <p class="deadline-text main-text">Deadline: </p>
                            <p class="deadline-date">${project.deadline}</p>
                        </div>
                    </div>
                </li>
            </ul>
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
                            d="m8.843 12.651c-1.392 0-2.521 1.129-2.521 2.521v6.306c0 1.392 1.129 2.521 2.521 2.521s2.521-1.129 2.521-2.521v-6.306c-.001-1.392-1.13-2.521-2.521-2.521z"/>
                    <path
                            d="m.019 15.172c0 1.393 1.13 2.523 2.523 2.523s2.523-1.13 2.523-2.523v-2.523h-2.521c-.001 0-.001 0-.002 0-1.393 0-2.523 1.13-2.523 2.523z"/>
                    <path
                            d="m8.846-.001c-.001 0-.002 0-.003 0-1.393 0-2.523 1.13-2.523 2.523s1.13 2.523 2.523 2.523h2.521c0-1.431 0-1.083 0-2.528-.001-1.391-1.128-2.518-2.518-2.518z"/>
                    <path
                            d="m2.525 11.37h6.318c1.393 0 2.523-1.13 2.523-2.523s-1.13-2.523-2.523-2.523h-6.318c-1.393 0-2.523 1.13-2.523 2.523s1.13 2.523 2.523 2.523z"/>
                    <path
                            d="m21.457 6.323c-1.391 0-2.518 1.127-2.518 2.518v.005 2.523h2.521c1.393 0 2.523-1.13 2.523-2.523s-1.13-2.523-2.523-2.523c-.001 0-.002 0-.003 0z"/>
                    <path
                            d="m12.641 2.522v6.325c0 1.392 1.129 2.521 2.521 2.521s2.521-1.129 2.521-2.521v-6.325c0-1.392-1.129-2.521-2.521-2.521-1.392 0-2.521 1.129-2.521 2.521z"/>
                    <path
                            d="m17.682 21.476c0-1.392-1.129-2.521-2.521-2.521h-2.521v2.523c.001 1.391 1.129 2.519 2.521 2.519s2.521-1.129 2.521-2.521z"/>
                    <path
                            d="m21.479 12.649h-6.318c-1.393 0-2.523 1.13-2.523 2.523s1.13 2.523 2.523 2.523h6.318c1.393 0 2.523-1.13 2.523-2.523s-1.13-2.523-2.523-2.523z"/>
                </svg>
            </div>
            <p class="footer-subtitle">©Yauheny Vozny - 2021</p>
        </div>
        <div class="right-header">
            <button class="footer-logout btn-reset"><a class="header-btn-link">Logout</a></button>
        </div>
    </div>
</footer>
<script src="${pageContext.request.contextPath}/jsp/js/main.js"></script>
</body>
</html>
