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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Main page</title>
    <link rel="stylesheet" href="/style/main.css">
    <style>
        <%@include file="../style/main.css"%>
        input.find_place::placeholder {
            color: #ffffff;
        }
    </style>
</head>
<body>
<jsp:include page="../parts/header.jsp"/>
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
                                    <a class="link-reset" href="?command=user_profile&id=${project.value.id}"
                                       target="_blank">
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
                                    <a class="link-reset" href="?command=user_profile&id=${manager.id}" target="_blank">
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

        <c:if test="${role.equals('ADMIN')}">
            <h2 style="padding-bottom: 30px" class="main-title">Users</h2>
            <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" method="get" action="servlet">
                <input type="hidden" name="command" value="authorized_main_page">
                <input style="color: #fdc62d;background-color: #666; width: 700px; margin: 0 auto"
                       type="search" class="form-control form-control-dark find_place"
                       name="tag" placeholder="Enter name or another info about user!" aria-label="Search">
            </form>
            <ul id="main-order-list" class="main-order-list list-reset">
                <c:forEach var="user" items="${users}">
                    <li class="order-item">
                        <button type="button" class="order-box order-btn btn-reset">
                            <div class="order-title-box">
                                <h3 class="order-title"><c:out value="${user.nickname}"/></h3>
                                <p class="order-price"><c:out value="${user.userInfo.city}"/></p>
                            </div>
                            <p class="order-dscr"><%--<c:out value="${manager.userInfo.qualification}"/>--%></p>
                        </button>
                        <div class="order-info">
                            <div class="name-of-customer">
                                <p class="name-text main-text">Manager: </p>
                                <h3 class="name">
                                    <a class="link-reset" href="?command=user_profile&id=${user.id}" target="_blank">
                                        <c:out value="${user.nickname}"/>
                                    </a>
                                </h3>
                            </div>
                            <div class="technologies">
                                <p class="technologies-text main-text">Technologies stack: </p>
                                <p class="technologies-stack"><c:out value="${user.userInfo.qualification}"/></p>
                            </div>
                            <div class="comand">
                                <p class="comand-text main-text">Country: </p>
                                <p class="size-of-comand"><c:out value="${user.userInfo.country}"/></p>
                            </div>
                            <div class="comand">
                                <p class="comand-text main-text">Status: </p>
                                <p class="size-of-comand"><c:out value="${user.userInfo.status}"/></p>
                            </div>
                            <div class="deadline">
                                <p class="deadline-text main-text">Contact me there: </p>
                                <p class="deadline-date">
                                    <a class="link-reset" href="${user.userInfo.socialLink}">
                                        <c:out value="${user.userInfo.socialLink}"/>
                                    </a>
                                </p>
                            </div>
                            <div style="display: flex">
                                <a class="respond-btn link-reset" href="?command=show_project&id=${user.id}">
                                    <p class="respond-text">Edit</p>
                                </a>
                                <c:set var="status" value="${user.userInfo.status}"/>
                                <c:if test="${!status.equals('BLOCKED')}">
                                    <a class="respond-btn link-reset" href="?command=block_user&id=${user.id}">
                                        <p class="respond-text">Block</p>
                                    </a>
                                </c:if>
                                <c:if test="${status.equals('BLOCKED')}">
                                    <a class="respond-btn link-reset" href="?command=unblock_user&id=${user.id}">
                                        <p class="respond-text">Unblock</p>
                                    </a>
                                </c:if>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </c:if>

    </div>
</main>
<%@include file="../parts/footer.jsp"%>
<script src="${pageContext.request.contextPath}/jsp/js/main.js"></script>
</body>
</html>