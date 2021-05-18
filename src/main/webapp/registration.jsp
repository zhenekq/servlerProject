<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 16.05.2021
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Sign in page</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sign-in/">

    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.5/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <!-- Favicons -->
    <link rel="apple-touch-icon" href="https://getbootstrap.com/docs/4.5/assets/img/favicons/apple-touch-icon.png"
          sizes="180x180">
    <link rel="icon" href="https://getbootstrap.com/docs/4.5/assets/img/favicons/favicon-32x32.png" sizes="32x32"
          type="image/png">
    <link rel="icon" href="https://getbootstrap.com/docs/4.5/assets/img/favicons/favicon-16x16.png" sizes="16x16"
          type="image/png">
    <link rel="manifest" href="https://getbootstrap.com/docs/4.5/assets/img/favicons/manifest.json">
    <link rel="mask-icon" href="https://getbootstrap.com/docs/4.5/assets/img/favicons/safari-pinned-tab.svg"
          color="#563d7c">
    <link rel="icon" href="https://getbootstrap.com/docs/4.5/assets/img/favicons/favicon.ico">
    <meta name="msapplication-config" content="https://getbootstrap.com/docs/4.5/assets/img/favicons/browserconfig.xml">
    <meta name="theme-color" content="#563d7c">


    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.5/examples/sign-in/signin.css" rel="stylesheet">
</head>
<body class="text-center">
<form class="form-signin" method="post">
    <img class="mb-4" src="https://getbootstrap.com/docs/4.5/assets/brand/bootstrap-solid.svg" alt="" width="72"
         height="72">
    <h1 class="h3 mb-3 font-weight-normal">Registration</h1>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="email" id="inputEmail" name="email" class="form-control mb-3" placeholder="Email address" required
           autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="text" id="inputNickname" name="nickname" class="form-control mb-3" placeholder="Nickname" required>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" name="password" class="form-control mb-3" placeholder="Password" required>
    <label for="inputPassword" class="sr-only">Retype password</label>
    <input type="password" id="inputPassword1" name="password1" class="form-control mb-3" placeholder="Retype password" required>
    <div class="form-group mx-sm-3 mb-2" role="group">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Create account</button>
        <a class="btn" href="/login">Log in</a>
    </div>
</form>
</body>
</html>
