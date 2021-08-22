<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/style/login.css"/>
  <title>Login</title>
</head>
<body>
  <main class="main">
    <div class="login">
      <div class="login-content">
        <h1 class="login-title">Login</h1>
        <form class="login-form" action="servlet" method="POST">
          <input type="hidden" name="command" value="authorization">
          <ul class="login-list list-reset">
          <li class="login-item ">
            <input class="login-input" type="name" name="email" placeholder="Username">
          </li>
          <li class="login-item">
            <input class="login-input" type="password" name="password" placeholder="Password">
          </li>
          </ul>
          <input class="login-submit btn-reset" type="submit" value="Login">
          <a href="?command=registration_page" class="login-link link-reset">I dont have an account</a>
          <p class="message_error"><c:out value="${error_message_login}"/> </p>
        </form>
      </div>
    </div>
  </main>
</body>
</html>