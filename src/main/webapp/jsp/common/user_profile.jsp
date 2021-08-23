<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25.07.2021
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <fmt:setLocale value="${language}" scope="session"/>
    <fmt:setBundle basename="local"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/style/user_profile.css">
    <title><fmt:message key="local.user-profile"/> </title>
</head>
<body>
<jsp:include page="../parts/header.jsp"/>
<main class="main">
    <div class="bg-box">
        <div class="main-wrapper wrapper">
            <div class="user-info-box">
                <div class="user-info-content">
                    <h2 style="text-align: center" class="user-info-title"><fmt:message key="local.user-information"/></h2>
                    <ul class="user-list list-reset">
                        <li class="user-item">
                            <p class="user-subtitle"><fmt:message key="local.user-username"/>:</p>
                            <p class="info-subtitle">${userBasics.nickname}</p>
                        </li>
                        <li class="user-item">
                            <p class="user-subtitle"><fmt:message key="local.user-email"/>:</p>
                            <p class="info-subtitle">${userBasics.email}</p>
                        </li>
                        <li class="user-from-item user-item">
                            <div class="country-item">
                                <p class="user-subtitle"><fmt:message key="local.user-country"/>:</p>
                                <p class="info-subtitle">${userInfo.country}</p>
                            </div>
                            <div class="city-item">
                                <p class="user-subtitle"><fmt:message key="local.user-city"/>:</p>
                                <p class="info-subtitle">${userInfo.city}</p>
                            </div>
                        </li>
                        <li class="user-item">
                            <p class="user-subtitle"><fmt:message key="local.user-experience"/>:</p>
                            <p class="info-subtitle">${userInfo.experience}</p>
                        </li>
                        <li class="user-item about-item">
                            <p class="about-subtitle user-subtitle"><fmt:message key="local.user-about"/>:</p>
                            <p class="info-subtitle">${userInfo.qualification}</p>
                        </li>
                        <li class="user-item">
                            <p class="user-subtitle"><fmt:message key="local.user-link"/>:</p>
                            <a class="info-subtitle link-reset" href="${userInfo.socialLink}"
                               target="_blank">${userInfo.socialLink}</a>
                        </li>
                        <li class="user-item">
                            <p class="user-subtitle"><fmt:message key="local.user-date"/>:</p>
                            <p class="info-subtitle">${userInfo.dateOfRegistration}</p>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</main>
<jsp:include page="../parts/footer.jsp"/>
<script src="${pageContext.request.contextPath}/jsp/js/project_form.js"></script>
</body>
</html>
