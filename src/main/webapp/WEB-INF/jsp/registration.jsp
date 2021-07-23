<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>
    <link rel="stylesheet" href="style/registration.css">
    <style>
        <%@include file="style/registration.css"%>
    </style>
</head>
<body>
<main class="main">
    <div class="registration">
        <div class="reg-content">
            <h1 class="reg-title">Registration</h1>
            <form class="reg-radio" action="servlet" method="POST">
                <ul class="reg-list list-reset">
                    <li class="list-item">
                      <input type="hidden" name="command" value="registration">
                        <div class="registration-wrapper">
                            <div class="reg-form">
                                <input class="reg-name reg-item" type="name" name="username" placeholder="Name">
                            </div>
                            <div class="reg-form">
                                <input class="reg-mail reg-item" type="email" name="email" placeholder="Email">
                            </div>
                            <div class="reg-form">
                                <input class="reg-password reg-item" type="password" name="password" placeholder="Password">
                            </div>
                        </div>
                    </li>
                    <li class="list-item">
                        <div class="form_radio_group">
                            <div class="form_radio_group-item">
                                <input id="radio-1" type="radio" name="radio" value="Developer">
                                <label for="radio-1">Developer</label>
                            </div>
                            <div class="form_radio_group-item">
                                <input id="radio-2" type="radio" name="radio" value="Customer">
                                <label for="radio-2">Customer</label>
                            </div>
                            <div class="form_radio_group-item">
                                <input id="radio-3" type="radio" name="radio" value="Manager">
                                <label for="radio-3">Manager</label>
                            </div>
                        </div>
                    </li>
                </ul>
                <div class="reg-link">
                    <input class="reg-button btn-reset" type="submit" value="Registrate">
                </div>
                <a class="reg-accaunt" href="?command=authorization_page">I already have an account</a>
                <p class="message_error"><c:out value="${error_message}"/> </p>
            </form>
        </div>
    </div>
</main>
</body>
</html>