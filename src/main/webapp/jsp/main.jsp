<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 20.07.2021
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/style/main.css">
</head>
<body>
<header class="header">
    <div class="header-wrapper wrapper">
        <div class="left-header">
            <div class="header-logo">
                <svg class="logo" enable-background="new 0 0 24 24" height="50" viewBox="0 0 24 24" width="50"
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
            <ul class="header-list list-reset">
                <li class="headerLinks-item"><a href="#" class="link-reset link-header">link</a></li>
                <li class="headerLinks-item"><a href="#" class="link-reset  link-header">link</a></li>
                <li class="headerLinks-item"><a href="#" class="link-reset link-header">link</a></li>
                <li class="headerLinks-item"><a href="#" class="link-reset link-header">link</a></li>
            </ul>
        </div>
        <div class="right-header">
            <h2 class="username">Username</h2>
            <div class="section">
                <input class="menu__toggle" type="checkbox" />
                <a href="#" class="menu-btn">
                    <span class="span"></span>
                </a>
                <ul class="menu__box">
                    <li><a class="menu__item" href="#">Главная</a></li>
                    <li><a class="menu__item" href="#">Проекты</a></li>
                </ul>
            </div>
            <p class="user-role-title">Role:</p>
            <p class="user-role">Manager</p>
        </div>
    </div>
</header>
<main class="main">
    <div class="main-bg-box">
        <div class="main-wrapper wrapper" >
            <ul id="main-order-list" class="main-order-list list-reset">
                <li class="order-item">
                    <button type="button" class="order-box order-btn btn-reset">
                        <div class="order-title-box">
                            <h3 class="order-title">Title</h3>
                            <p class="order-price">500$</p>
                        </div>
                        <p class="order-dscr">Description description description description description</p>
                    </button>
                    <div class="order-info">

                    </div>
                </li>
                <li class="order-item">
                    <button type="button" class="order-box order-btn btn-reset">
                        <div class="order-title-box">
                            <h3 class="order-title">Title</h3>
                            <p class="order-price">500$</p>
                        </div>
                        <p class="order-dscr">Description description description description description</p>
                    </button>
                    <div class="order-info">
                        <h2 style="color: red;">dspofkdosf</h2>
                    </div>
                </li>
                <li class="order-item">
                    <div class="order-box">
                        <div class="order-title-box">
                            <h3 class="order-title">Title</h3>
                            <p class="order-price">500$</p>
                        </div>
                        <p class="order-dscr">Description description description description description</p>
                    </div>
                    <div class="order-info">
                        oisfdoifjs
                    </div>
                </li>
            </ul>
        </div>
    </div>
</main>
<script src="${pageContext.request.contextPath}/jsp/js/main.js"></script>
</body>
</html>