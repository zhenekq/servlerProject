<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25.07.2021
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/style/user_profile.css">
    <title>User profile</title>
</head>
<body>
<jsp:include page="../parts/header.jsp"/>
<main class="main">
    <div class="bg-box">
        <div class="main-wrapper wrapper">
            <div class="user-info-box">
                <div class="user-info-content">
                    <h2 class="user-info-title">User information</h2>
                    <ul class="user-list list-reset">
                        <li class="user-item">
                            <p class="user-subtitle">Username:</p>
                            <p class="info-subtitle">${userBasics.nickname}</p>
                        </li>
                        <li class="user-item">
                            <p class="user-subtitle">Email:</p>
                            <p class="info-subtitle">${userBasics.email}</p>
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
                            <a class="info-subtitle link-reset" href="">13</a>
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
