<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25.07.2021
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/jsp/style/user_profile.css">
    <title>User profile</title>
    <style>
        <%@include file="style/user_profile.css"%>
    </style>
</head>
<body>
<%--<header class="header">
    <div class="header-wrapper wrapper">
        <div class="left-header">
            <div class="header-logo">
                <svg class="logo" enable-background="new 0 0 24 24" height="50" viewBox="0 0 24 24" width="50"
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
            <ul class="header-list list-reset">
                <li class="headerLinks-item"><a href="#" class="link-reset link-header">Fkjdkls</a></li>
                <li class="headerLinks-item"><a href="#" class="link-reset link-header">dkjls</a></li>
                <li class="headerLinks-item"><a href="#" class="link-reset link-header">Ldkd</a></li>
                <li class="headerLinks-item"><a href="#" class="link-reset link-header">Ddkjslkjf</a></li>
            </ul>
        </div>
        <div class="right-header">
            <h2 class="username">Username</h2>
            <div class="dropdown">
                <button onclick="myFunction()" class="dropbtn btn-reset"></button>
                <div id="myDropdown" class="dropdown-content">
                    <a class="navigation-item" href="#">Profile</a>
                    <a class="navigation-item" href="#">Logout</a>
                </div>
            </div>
            <p class="user-role-title">Role:</p>
            <p class="user-role">Manager</p>
        </div>
    </div>
</header>--%>
<jsp:include page="parts/header.jsp"/>
<main class="main">
    <div class="bg-box">
        <div class="main-wrapper wrapper">
            <div class="user-info-box">
                <div class="user-info-content">
                    <h2 class="user-info-title">User information</h2>
                    <ul class="user-list list-reset">
                        <li class="user-item">
                            <p class="user-subtitle">Username:</p>
                            <p class="info-subtitle">${user.nickname}</p>
                        </li>
                        <li class="user-item">
                            <p class="user-subtitle">Email:</p>
                            <p class="info-subtitle">${user.email}</p>
                        </li>
                        <li class="user-from-item user-item">
                            <div class="country-item">
                                <p class="user-subtitle">Country:</p>
                                <p class="info-subtitle">${userInfo.country}</p>
                            </div>
                            <div class="city-item">
                                <p class="user-subtitle">City:</p>
                                <p class="info-subtitle">${userInfo.city}</p>
                            </div>
                        </li>
                        <li class="user-item">
                            <p class="user-subtitle">Experience:</p>
                            <p class="info-subtitle">${userInfo.experience}</p>
                        </li>
                        <li class="user-item about-item">
                            <p class="about-subtitle user-subtitle">About user:</p>
                            <p class="info-subtitle">${userInfo.qualification}</p>
                        </li>
                        <li class="user-item">
                            <p class="user-subtitle">Link to social network:</p>
                            <a class="info-subtitle link-reset" href="${userInfo.socialLink}"
                               target="_blank">${userInfo.socialLink}</a>
                        </li>
                        <li class="user-item">
                            <p class="user-subtitle">Date of Birth:</p>
                            <p class="info-subtitle">${userInfo.dateOfRegistration}</p>
                        </li>
                        <li class="user-item">
                            <p class="user-subtitle">Count of progects:</p>

                            <a class="info-subtitle link-reset">13</a>
                        </li>
                    </ul>
                </div>
            </div>
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
<script src="/jsp/js/project_form.js"></script>
</body>
</html>
</body>
</html>
