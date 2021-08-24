<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <fmt:setLocale value="${language}" scope="session"/>
    <fmt:setBundle basename="local"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/style/style.css"/>
    <title><fmt:message key="local.welcome"/> </title>
</head>
<body>
<header class="header">
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
    </div>
    <div style="grid-template-columns: repeat(3, 1fr); align-items: center" class="right-header">
        <button class="login header-btn btn-reset"><a class="header-btn-link"
                                                      href="?command=authorization_page"><fmt:message key="local.login"/> </a></button>
        <button style="color: #000;" class="sign-up header-btn btn-reset"><a class="header-btn-link" href="?command=registration_page"><fmt:message key="local.sign-up"/> </a>
        </button>
        <div class="lang">
            <a href="?command=language&language=ru" class="ru-lang link-reset">RU</a>
            <a href="?command=language&language=en" class="en-lang link-reset">EN</a>
        </div>
    </div>
</header>
<main class="main">
    <div class="landing">
        <h1 class="landing-title">Project provider inc.</h1>
    </div>
    <div class="info">
        <p class="info-text">
            <fmt:message key="local.welcome-title"/>
        </p>
    </div>
    <div class="navigation">
        <h2 class="nav-title"><fmt:message key="local.how-to-start"/>?</h2>
        <ul class="nav-list list-reset">
            <li class="nav-item"><p style="text-align: center" class="nav-text"><fmt:message key="local.first-step"/></p></li>
            <li class="nav-item-arrow">
                <svg class="nav-arrow" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" x="0px"
                     y="0px" viewBox="0 0 490.667 490.667" style="enable-background:new 0 0 490.667 490.667;"
                     xml:space="preserve">
              <path style="fill: #fdc62d;" d="M466.219,237.781L231.552,3.115C229.548,1.115,226.831-0.005,224,0H32
            	c-5.891-0.011-10.675,4.757-10.686,10.648c-0.005,2.84,1.123,5.565,3.134,7.571l227.136,227.115L24.448,472.448
            	c-4.171,4.16-4.179,10.914-0.019,15.085c2.006,2.011,4.731,3.139,7.571,3.134h192c2.831,0.005,5.548-1.115,7.552-3.115
            	l234.667-234.667c4.171-4.16,4.179-10.914,0.019-15.085C466.231,237.794,466.225,237.788,466.219,237.781z"/>
            </svg>
            </li>
            <li class="nav-item"><p style="text-align: center" class="nav-text"><fmt:message key="local.second-step"/> </p></li>
            <li class="nav-item-arrow">
                <svg class="nav-arrow" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" x="0px"
                     y="0px" viewBox="0 0 490.667 490.667" style="enable-background:new 0 0 490.667 490.667;"
                     xml:space="preserve">
              <path style="fill: #fdc62d;" d="M466.219,237.781L231.552,3.115C229.548,1.115,226.831-0.005,224,0H32
            	c-5.891-0.011-10.675,4.757-10.686,10.648c-0.005,2.84,1.123,5.565,3.134,7.571l227.136,227.115L24.448,472.448
            	c-4.171,4.16-4.179,10.914-0.019,15.085c2.006,2.011,4.731,3.139,7.571,3.134h192c2.831,0.005,5.548-1.115,7.552-3.115
            	l234.667-234.667c4.171-4.16,4.179-10.914,0.019-15.085C466.231,237.794,466.225,237.788,466.219,237.781z"/>
            </svg>
            </li>
            <li class="nav-item"><p style="text-align: center" class="nav-text"><fmt:message key="local.third-step"/>!</p></li>
        </ul>
    </div>
</main>
<footer class="footer">
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
</footer>
</body>
</html>