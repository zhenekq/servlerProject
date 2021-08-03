<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Main page</title>
    <link rel="stylesheet" href="/style/main.css">
    <style>
        <%@include file="style/main.css"%>
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
                <li class="headerLinks-item"><a href="#" class="link-reset link-header">Projects</a></li>
                <li class="headerLinks-item"><a href="#" class="link-reset link-header">My projects</a></li>
                <li class="headerLinks-item"><a href="#" class="link-reset link-header">My team</a></li>
                <li class="headerLinks-item"><a href="?command=add_new_project_page" class="link-reset link-header">Create new Project</a></li>
            </ul>
        </div>
        <div class="right-header">
            <h2 class="username">${user.nickname}</h2>
            <div class="dropdown">
                <button onclick="myFunction()" class="dropbtn btn-reset"></button>
                <div id="myDropdown" class="dropdown-content">
                    <a class="navigation-item" href="#">Profile</a>
                    <a class="navigation-item" href="?command=logout_page">Logout</a>
                </div>
            </div>
            <p class="user-role-title">Role:</p>
            <p class="user-role">${user.role}</p>
        </div>
    </div>
</header>--%>
<jsp:include page="parts/header.jsp"/>
<main class="main">
    <div class="main-wrapper wrapper">
        <c:set var="role" value="${user.role}"/>
        <!--MAIN PAGE TITLE-->
        <c:if test="${role.equals('MANAGER')}">
            <h2 class="main-title">Projects</h2>
            <ul id="main-order-list" class="main-order-list list-reset">
                <c:forEach var="project" items="${projects}">
                    <li class="order-item">
                        <button type="button" class="order-box order-btn btn-reset">
                            <div class="order-title-box">
                                <h3 class="order-title"><c:out value="${project.key.title}"/></h3>
                                <p class="order-price"><c:out value="${project.key.cost}"/>$</p>
                            </div>
                            <p class="order-dscr"><c:out value="${project.key.description}"/></p>
                        </button>
                        <div class="order-info">
                            <div class="name-of-customer">
                                <p class="name-text main-text">Name of customer: </p>
                                <h3 class="name">
                                    <a class="link-reset" href="?command=user_profile&id=${project.value.id}">
                                        <c:out value="${project.value.nickname}"/>
                                    </a>
                                </h3>
                            </div>
                            <div class="technologies">
                                <p class="technologies-text main-text">Technologies stack: </p>
                                <p class="technologies-stack"><c:out value="${project.key.qualification}"/></p>
                            </div>
                            <div class="comand">
                                <p class="comand-text main-text">Size of command: </p>
                                <p class="size-of-comand"><c:out value="${project.key.teamSize}"/></p>
                            </div>
                            <div class="deadline">
                                <p class="deadline-text main-text">Deadline: </p>
                                <p class="deadline-date"><c:out value="${project.key.deadline}"/></p>
                            </div>
                            <a class="respond-btn link-reset" href="?command=show_project&id=${project.key.id}">
                                <p class="respond-text">Respond</p>
                            </a>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </c:if>

        <c:if test="${role.equals('CUSTOMER')}">
            <h2 class="main-title">Managers</h2>
            <ul id="main-order-list" class="main-order-list list-reset">
                <c:forEach var="manager" items="${managers}">
                    <li class="order-item">
                        <button type="button" class="order-box order-btn btn-reset">
                            <div class="order-title-box">
                                <h3 class="order-title"><c:out value="${manager.nickname}"/></h3>
                                <p class="order-price"><c:out value="${manager.userInfo.city}"/></p>
                            </div>
                            <p class="order-dscr"><%--<c:out value="${manager.userInfo.qualification}"/>--%></p>
                        </button>
                        <div class="order-info">
                            <div class="name-of-customer">
                                <p class="name-text main-text">Manager: </p>
                                <h3 class="name">
                                    <a class="link-reset" href="?command=user_profile&id=${manager.id}">
                                        <c:out value="${manager.nickname}"/>
                                    </a>
                                </h3>
                            </div>
                            <div class="technologies">
                                <p class="technologies-text main-text">Technologies stack: </p>
                                <p class="technologies-stack"><c:out value="${manager.userInfo.qualification}"/></p>
                            </div>
                            <div class="comand">
                                <p class="comand-text main-text">Country: </p>
                                <p class="size-of-comand"><c:out value="${manager.userInfo.country}"/></p>
                            </div>
                            <div class="deadline">
                                <p class="deadline-text main-text">Contact me there: </p>
                                <p class="deadline-date">
                                    <a class="link-reset" href="${manager.userInfo.socialLink}">
                                        <c:out value="${manager.userInfo.socialLink}"/>
                                    </a>
                                </p>
                            </div>
                            <a class="respond-btn link-reset" href="?command=show_project&id=${manager.id}">
                                <p class="respond-text">Respond</p>
                            </a>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </c:if>

        <c:if test="${role.equals('DEVELOPER')}">
            <h2 class="main-title">Teams</h2>
        </c:if>

        <!--
        <ul id="main-order-list" class="main-order-list list-reset">
            <c:forEach var="project" items="${projects}">
                <li class="order-item">
                    <button type="button" class="order-box order-btn btn-reset">
                        <div class="order-title-box">
                            <h3 class="order-title"><c:out value="${project.key.title}"/></h3>
                            <p class="order-price"><c:out value="${project.key.cost}"/>$</p>
                        </div>
                        <p class="order-dscr"><c:out value="${project.key.description}"/></p>
                    </button>
                    <div class="order-info">
                        <div class="name-of-customer">
                            <p class="name-text main-text">Name of customer: </p>
                            <h3 class="name">
                                <a class="link-reset" href="?command=user_profile&id=${project.value.id}">
                                    <c:out value="${project.value.nickname}"/>
                                </a>
                            </h3>
                        </div>
                        <div class="technologies">
                            <p class="technologies-text main-text">Technologies stack: </p>
                            <p class="technologies-stack"><c:out value="${project.key.qualification}"/></p>
                        </div>
                        <div class="comand">
                            <p class="comand-text main-text">Size of command: </p>
                            <p class="size-of-comand"><c:out value="${project.key.teamSize}"/></p>
                        </div>
                        <div class="deadline">
                            <p class="deadline-text main-text">Deadline: </p>
                            <p class="deadline-date"><c:out value="${project.key.deadline}"/></p>
                        </div>
                        <a class="respond-btn link-reset" href="?command=show_project&id=${project.key.id}">
                            <p class="respond-text">Respond</p>
                        </a>
                    </div>
                </li>
            </c:forEach>
        </ul>
        -->
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
            </button>
        </div>
    </div>
</footer>
<script src="${pageContext.request.contextPath}/jsp/js/main.js"></script>
</body>
</html>