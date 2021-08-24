<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <fmt:setLocale value="${language}" scope="session"/>
    <fmt:setBundle basename="local" var="loc"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title><fmt:message bundle="${loc}" key="local.main-page"/> </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/style/main.css">
    <link rel="icon" href="httр://mysite.ru/myicon.ico">
    <style>
        input.find_place::placeholder {
            color: #ffffff;
        }

        .main-item {
            background-color: var(--black);
            border-radius: 6px;
            margin-bottom: 50px;
        }

        .command-box {
            padding: 20px;
        }

        .command-title {
            display: flex;
            align-items: center;
            justify-content: space-between;
            color: var(--yellow);
            font-family: var(--font);
            font-size: 16px;
        }

        .command-amount {
            color: var(--white);
            display: flex;
        }

        .command-participants:first-child {
            padding-right: 10px;
        }

        .command-descr {
            font-family: var(--font);
            color: var(--white);
            font-size: 17px;
        }

        .descr-text {
            padding-bottom: 20px;
        }

        .edit-link {
            margin-right: 25px;
            display: inline-block;
            padding: 10px;
            background-color: var(--yellow);
            color: var(--black);
            border-radius: 6px;
        }

        .edit-text {
            margin: 0;
        }

        .btn.active,
        .btn:hover,
        .btn:focus {
            outline: none;
        }

        .view-box {
            display: none;
        }

        .view-box.show {
            display: block;
        }

        .btn {
            display: inline-block;
            padding: 10px;
            background-color: transparent;
            color: var(--grey);
            border: 1px solid var(--grey);

            font-family: var(--font);
            color: var(--grey);
            border-radius: 6px;
            font-size: 17px;
            margin-bottom: 30px;
        }

        .view-list {
            margin: 0 auto;
            display: grid;
            gap: 20px;
            grid-template-columns: repeat(3, 1fr);
        }

        .view-item {
            background-color: var(--grey);
            border-radius: 6px;
            width: 220px;
            height: 300px;
        }

        .view-name {
            padding-top: 10px;
            display: block;
            width: 106px;
            margin: 0 auto;
            color: var(--yellow);
        }

        .view-about {
            padding-left: 10px;
        }

        .view-link {
            display: inline-block;
            padding: 7px;
            background-color: transparent;
            color: var(--grey);
            border: 1px solid var(--black);
            font-family: var(--font);
            color: var(--black);
            border-radius: 6px;
            font-size: 15px;
            margin-bottom: 10px;
            margin-left: 10px;
        }
    </style>
</head>
<body>
<jsp:include page="../parts/header.jsp"/>
<main style="background-image: url(/images/bg_seri.jpg)" class="main">
    <div class="main-wrapper wrapper">
        <c:set var="role" value="${user.role}"/>
        <!--MAIN PAGE TITLE-->
        <c:if test="${role.equals('MANAGER')}">
            <h2 class="main-title">
                <fmt:message bundle="${loc}" key="local.projects"/>
            </h2>
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
                                <p class="name-text main-text">
                                    <fmt:message bundle="${loc}" key="local.name-customer"/>:
                                </p>
                                <h3 class="name">
                                    <a class="link-reset" href="?command=user_profile&id=${project.value.id}"
                                       target="_blank">
                                        <c:out value="${project.value.nickname}"/>
                                    </a>
                                </h3>
                            </div>
                            <div class="technologies">
                                <p class="technologies-text main-text">
                                    <fmt:message bundle="${loc}" key="local.technologies-stack"/>:
                                </p>
                                <p class="technologies-stack"><c:out value="${project.key.qualification}"/></p>
                            </div>
                            <div class="comand">
                                <p class="comand-text main-text">
                                    <fmt:message bundle="${loc}" key="local.team-size"/>:
                                </p>
                                <p class="size-of-comand"><c:out value="${project.key.teamSize}"/></p>
                            </div>
                            <div class="deadline">
                                <p class="deadline-text main-text">
                                    <fmt:message bundle="${loc}" key="local.deadline"/>:
                                </p>
                                <p class="deadline-date">
                                    <c:out value="${project.key.deadline}"/>
                                </p>
                            </div>
                            <a class="respond-btn link-reset" href="?command=show_project&id=${project.key.id}">
                                <p class="respond-text">
                                    <fmt:message bundle="${loc}" key="local.respond"/>
                                </p>
                            </a>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </c:if>

        <c:if test="${role.equals('CUSTOMER')}">
            <h2 class="main-title"><fmt:message bundle="${loc}" key="local.managers"/> </h2>
            <ul id="main-order-list" class="main-order-list list-reset">
                <c:forEach var="manager" items="${managers}">
                    <li class="order-item">
                        <button type="button" class="order-box order-btn btn-reset">
                            <div class="order-title-box">
                                <h3 class="order-title"><c:out value="${manager.nickname}"/></h3>
                                <p class="order-price"><c:out value="${manager.userInfo.city}"/></p>
                            </div>
                            <p class="order-dscr"></p>
                        </button>
                        <div class="order-info">
                            <div class="name-of-customer">
                                <p class="name-text main-text"><fmt:message bundle="${loc}" key="local.manager"/>: </p>
                                <h3 class="name">
                                    <a class="link-reset" href="?command=user_profile&id=${manager.id}" target="_blank">
                                        <c:out value="${manager.nickname}"/>
                                    </a>
                                </h3>
                            </div>
                            <div class="technologies">
                                <p class="technologies-text main-text"><fmt:message bundle="${loc}" key="local.technologies-stack"/>: </p>
                                <p class="technologies-stack"><c:out value="${manager.userInfo.qualification}"/></p>
                            </div>
                            <div class="comand">
                                <p class="comand-text main-text"><fmt:message bundle="${loc}" key="local.country"/>: </p>
                                <p class="size-of-comand"><c:out value="${manager.userInfo.country}"/></p>
                            </div>
                            <div class="deadline">
                                <p class="deadline-text main-text"><fmt:message bundle="${loc}" key="local.contact-me"/>: </p>
                                <p class="deadline-date">
                                    <a class="link-reset" href="${manager.userInfo.socialLink}">
                                        <c:out value="${manager.userInfo.socialLink}"/>
                                    </a>
                                </p>
                            </div>
                            <a class="respond-btn link-reset" href="?command=show_project&id=${manager.id}">
                                <p class="respond-text"><fmt:message bundle="${loc}" key="local.respond"/></p>
                            </a>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </c:if>

        <c:if test="${role.equals('DEVELOPER')}">
            <h2 class="main-title">
                <fmt:message bundle="${loc}" key="local.teams"/>
            </h2>

            <ul style="margin-top: 40px" class="main-list list-reset">
                <c:forEach var="team" items="${teams}">
                    <li style="width: 800px; margin: 0 auto; margin-bottom: 50px;" class="main-item">
                        <div class="command-box">
                            <div class="command-title">
                                <h3 class="command-title-text">${team.key.name}</h3>
                                <div class="command-amount">
                                    <p class="command-participants">
                                        <fmt:message bundle="${loc}" key="local.participants"/>:
                                    </p>
                                    <p class="command-participants">${team.key.currentTeamSize}/</p>
                                    <p class="command-participants">${team.key.teamSize}</p>
                                </div>
                            </div>
                            <div class="command-descr">
                                <p class="descr-text">${team.key.description}</p>
                                <a href="servlet?command=work_there&id=${team.key.id}"
                                   class="edit-link link-reset" target="_blank">
                                    <p class="edit-text">
                                        <fmt:message bundle="${loc}" key="local.work-there"/>
                                    </p>
                                </a>
                                <a href="servlet?command=user_profile&id=${team.key.managerId}"
                                   class="edit-link link-reset"
                                   target="_blank">
                                    <p class="edit-text">
                                        <fmt:message bundle="${loc}" key="local.check-manager-info"/>
                                    </p>
                                </a>
                                <button style="cursor: pointer; margin-bottom: 0;" class="btn">
                                    <fmt:message bundle="${loc}" key="local.view-participants"/>
                                </button>
                                <div class="view-box">
                                    <ul style="padding-top: 20px" class="view-list list-reset">
                                        <c:forEach var="user" items="${team.value}">
                                            <li style="height: 100%; margin-bottom: 20px" class="view-item">
                                                <h3 style="font-size: 18px" class="view-name">${user.nickname}</h3>
                                                <div class="view-about">
                                                    <p class="about-user">
                                                        <fmt:message bundle="${loc}" key="local.user-about"/>:
                                                    </p>
                                                    <p class="about-text">${user.userInfo.qualification}</p>
                                                </div>
                                                <div class="view-links">
                                                    <a href="servlet?command=user_profile&id=${user.id}"
                                                       class="view-link link-reset" target="_blank">
                                                        <p class="edit-text">
                                                            <fmt:message bundle="${loc}" key="local.view-profile"/>
                                                        </p>
                                                    </a>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </c:if>

        <c:if test="${role.equals('ADMIN')}">
            <h2 style="padding-bottom: 30px" class="main-title"><fmt:message bundle="${loc}" key="local.users"/></h2>
            <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" method="get" action="servlet">
                <input type="hidden" name="command" value="authorized_main_page">
                <input style="color: #fdc62d;background-color: #666; width: 700px; margin: 0 auto"
                       type="search" class="form-control form-control-dark find_place"
                       name="tag" placeholder="<fmt:message bundle="${loc}" key="local.admin-find"/> " aria-label="Search">
            </form>
            <ul id="main-order-list" class="main-order-list list-reset">
                <c:forEach var="user" items="${users}">
                    <li class="order-item">
                        <button type="button" class="order-box order-btn btn-reset">
                            <div class="order-title-box">
                                <h3 class="order-title"><c:out value="${user.nickname}"/></h3>
                                <p class="order-price"><c:out value="${user.userInfo.city}"/></p>
                            </div>
                            <p class="order-dscr"></p>
                        </button>
                        <div class="order-info">
                            <div class="name-of-customer">
                                <p class="name-text main-text"><fmt:message bundle="${loc}" key="local.user-profile"/>: </p>
                                <h3 class="name">
                                    <a class="link-reset" href="?command=user_profile&id=${user.id}" target="_blank">
                                        <c:out value="${user.nickname}"/>
                                    </a>
                                </h3>
                            </div>
                            <div class="technologies">
                                <p class="technologies-text main-text"><fmt:message bundle="${loc}" key="local.technologies-stack"/>: </p>
                                <p class="technologies-stack"><c:out value="${user.userInfo.qualification}"/></p>
                            </div>
                            <div class="comand">
                                <p class="comand-text main-text"><fmt:message bundle="${loc}" key="local.country"/>: </p>
                                <p class="size-of-comand"><c:out value="${user.userInfo.country}"/></p>
                            </div>
                            <div class="comand">
                                <p class="comand-text main-text"><fmt:message bundle="${loc}" key="local.user-status"/>: </p>
                                <p class="size-of-comand"><c:out value="${user.userInfo.status}"/></p>
                            </div>
                            <div class="deadline">
                                <p class="deadline-text main-text"><fmt:message bundle="${loc}" key="local.user-link"/>: </p>
                                <p class="deadline-date">
                                    <a class="link-reset" href="${user.userInfo.socialLink}">
                                        <c:out value="${user.userInfo.socialLink}"/>
                                    </a>
                                </p>
                            </div>
                            <div style="display: flex">
                                <a class="respond-btn link-reset" href="?command=edit_user_page&id=${user.id}">
                                    <p class="respond-text"><fmt:message bundle="${loc}" key="local.edit"/></p>
                                </a>
                                <c:set var="status" value="${user.userInfo.status}"/>
                                <c:if test="${!status.equals('BLOCKED')}">
                                    <a style="width: 140px" class="respond-btn link-reset" href="?command=block_user&id=${user.id}">
                                        <p style="width: 110px" class="respond-text"><fmt:message bundle="${loc}" key="local.block"/></p>
                                    </a>
                                </c:if>
                                <c:if test="${status.equals('BLOCKED')}">
                                    <a style="width: 140px" class="respond-btn link-reset" href="?command=unblock_user&id=${user.id}">
                                        <p style="width: 110px" class="respond-text"><fmt:message bundle="${loc}" key="local.unblock"/></p>
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
<%@include file="../parts/footer.jsp" %>
<script src="${pageContext.request.contextPath}/jsp/js/main.js"></script>
<script>
    var acc = document.getElementsByClassName("btn");
    var i;
    for (i = 0; i < acc.length; i++) {
        acc[i].onclick = function () {
            this.classList.toggle("active");
            this.nextElementSibling.classList.toggle("show");
        }
    }
</script>
</body>
</html>