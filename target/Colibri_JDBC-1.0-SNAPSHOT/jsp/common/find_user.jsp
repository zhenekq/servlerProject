<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 16.08.2021
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Users result</title>
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
        <h2 style="padding-bottom: 30px" class="main-title">Users</h2>
        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" method="get" action="servlet">
            <input type="hidden" name="command" value="find_user">
            <input style="color: #fdc62d;background-color: #666; width: 700px; margin: 0 auto"
                   type="search" name="tag" class="form-control form-control-dark find_place"
                   placeholder="Enter name or another info about user!" aria-label="Search">
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
    </div>
</main>
<jsp:include page="../parts/footer.jsp"/>
<script src="${pageContext.request.contextPath}/WEB-INF/jsp/js/main.js"></script>
</body>
</html>
