<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11.08.2021
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../style/create_new_team.css">
    <style>
        <%@include file="../../style/create_new_team.css"%>
    </style>
    <title>Create command</title>
</head>

<body>
<%@include file="../../parts/header.jsp"%>
<main class="main">
    <div class="bg-box">
        <div class="main-wrapper wrapper">
            <h2 class="main-title">Create command</h2>
            <div class="create-box">
                <div class="create-content">
                    <form class="create-form" action="servlet" method="POST">
                        <input type="hidden" name="command" value="add_new_team">
                        <ul class="create-list list-reset">
                            <li class="create-item">
                                <p class="create-title">Name of command:</p>
                                <input class="create-input btn-reset" name="name" type="text">
                            </li>
                            <li class="create-item">
                                <p class="create-title">Command description:</p>
                                <textarea class="create-input create-texterea btn-reset" name="description" cols="35" rows="8"></textarea>
                            </li>
                            <li class="create-item">
                                <p class="create-title">Amount of participants:</p>
                                <input class="create-input btn-reset" name="teamSize" min="0" max="100" type="number">
                            </li>
                        </ul>
                        <input class="submit-input btn-reset" type="submit" value="Create">
                    </form>
                    <button class="btn-reset btn">Add participants</button>
                    <div class="view-box">
                        <ul class="view-list list-reset">
                            <li class="view-item">
                                <h3 class="view-name">Nickname</h3>
                                <div class="view-about">
                                    <p class="about-user">About user:</p>
                                    <p class="about-text">djfksjflkjsdkfjsl
                                        dkjfksjhfkshkss kdjfks kdflskjf kdjflskfjs kdjlsfs...
                                    </p>
                                </div>
                                <div class="view-links">
                                    <a href="#" class="view-link link-reset">
                                        <p class="edit-text">View profile</p>
                                    </a>
                                    <a href="#" class="view-link link-reset">
                                        <p class="edit-text">Invite to the team</p>
                                    </a>
                                </div>
                            </li>
                            <li class="view-item">
                                <h3
                                        SVG namespace
                                        www.w3.org

                                        class="view-name">Nickname</h3>
                                <div class="view-about">
                                    <p class="about-user">About user:</p>
                                    <p class="about-text">djfksjflkjsdkfjsl
                                        dkjfksjhfkshkss kdjfks kdflskjf kdjflskfjs kdjlsfs...
                                    </p>
                                </div>
                                <div class="view-links">
                                    <a href="#" class="view-link link-reset">
                                        <p class="edit-text">View profile</p>
                                    </a>
                                    <a href="#" class="view-link link-reset">
                                        <p class="edit-text">Invite to the team</p>
                                    </a>
                                </div>
                            </li>
                            <li class="view-item">
                                <h3 class="view-name">Nickname</h3>
                                <div class="view-about">
                                    <p class="about-user">About user:</p>
                                    <p class="about-text">djfksjflkjsdkfjsl
                                        dkjfksjhfkshkss kdjfks kdflskjf kdjflskfjs kdjlsfs...
                                    </p>
                                </div>
                                <div class="view-links">
                                    <a href="#" class="view-link link-reset">
                                        <p class="edit-text">View profile</p>
                                    </a>
                                    <a href="#" class="view-link link-reset">
                                        <p class="edit-text">Invite to the team</p>
                                    </a>
                                </div>
                            </li>
                            <li class="view-item">
                                <h3 class="view-name">Nickname</h3>
                                <div class="view-about">
                                    <p class="about-user">About user:</p>
                                    <p class="about-text">djfksjflkjsdkfjsl
                                        dkjfksjhfkshkss kdjfks kdflskjf kdjflskfjs kdjlsfs...
                                    </p>
                                </div>
                                <div class="view-links">
                                    <a href="#" class="view-link link-reset">
                                        <p class="edit-text">View profile</p>
                                    </a>
                                    <a href="#" class="view-link link-reset">
                                        <p class="edit-text">Invite to the team</p>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<%--<footer class="footer">
    <div class="footer-wrapper wrapper">
        <div class="left-header">
            <div class="header-logo">
                <svg class="footer-logo" enable-background="new 0 0 24 24" height="50" viewBox="0 0 24 24" width="50"
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
            <p class="footer-subtitle">©Yauheny Vozny - 2021</p>
        </div>
        <div class="right-header">
            <button class="footer-logout btn-reset"><a class="header-btn-link">Logout</a></button>
        </div>
    </div>
</footer>--%>
<%@include file="../../parts/footer.jsp"%>
<script>
    var acc = document.getElementsByClassName("btn");
    var i;
    for(i=0;i<acc.length; i++){
        acc[i].onclick = function() {
            this.classList.toggle("active");
            this.nextElementSibling.classList.toggle("show");
        }
    }
</script>
<script src="${pageContext.request.contextPath}/jsp/js/main.js"></script>
</body>

</html>