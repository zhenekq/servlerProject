<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <fmt:setLocale value="${language}" scope="session"/>
  <fmt:setBundle basename="local"/>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/style/login.css"/>
  <title><fmt:message key="local.login"/> </title>
</head>
<body>
  <main class="main">
    <div class="login">
      <div class="login-content">
        <h1 class="login-title"><fmt:message key="local.login"/></h1>
        <form class="login-form" action="servlet" method="POST">
          <input type="hidden" name="command" value="authorization">
          <ul class="login-list list-reset">
          <li class="login-item ">
            <input class="login-input" type="name" name="email" placeholder="<fmt:message key="local.user-username"/>">
          </li>
          <li class="login-item">
            <input class="login-input" type="password" name="password" placeholder="<fmt:message key="local.password"/>">
          </li>
          </ul>
          <input class="login-submit btn-reset" type="submit" value="<fmt:message key="local.login"/>">
          <a href="?command=registration_page" class="login-link link-reset"><fmt:message key="local.i-dont"/></a>
          <p class="message_error"><c:out value="${error_message_login}"/> </p>
        </form>
      </div>
    </div>
  </main>
</body>
</html>