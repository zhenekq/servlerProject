<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25.07.2021
  Time: 13:50
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
    <title><fmt:message key="local.add-new-project"/> </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/style/new_project.css">
</head>
<body>
<jsp:include page="../../parts/header.jsp"/>
<main class="main">
    <div class="bg-box">
        <div class="main-wrapper wrapper">
            <form style="left: 25%" class="progect-form" action="servlet" method="POST">
                <input type="hidden" name="command" value="add_new_project">

                <div class="progect-form-content">
                    <h2 class="main-title"><fmt:message key="local.add-new-project"/></h2>
                    <ul class="progect-list list-reset">
                        <li class="progect-item">
                            <p class="progect-subtitle"><fmt:message key="local.title-order"/>:</p>
                            <input type="text" name="title" class="progect-input btn-reset">
                        </li>
                        <li class="progect-item">
                            <p class=" textarea-text"><fmt:message key="local.short-desc"/>:</p>
                            <textarea name="description" class="progect-textarea btn-reset" cols="40" rows="5"></textarea>
                        </li>
                        <li class="progect-item">
                            <p class=" textarea-text"><fmt:message key="local.technologies-stack"/>:</p>
                            <textarea name="qualification" class="progect-textarea btn-reset" cols="40" rows="5"></textarea>
                        </li>
                        <li class="progect-item">
                            <p class="progect-subtitle"><fmt:message key="local.team-size"/>:</p>
                            <input type="number" name="teamSize" class="progect-input btn-reset">
                        </li>
                        <li class="progect-item">
                            <p class="progect-subtitle"><fmt:message key="local.deadline"/>: </p>
                            <input type="date" name="deadline" class="progect-input btn-reset">
                        </li>
                        <li class="progect-item">
                            <p class="progect-subtitle"><fmt:message key="local.cost"/>: </p>
                            <input type="number" name="cost" class="progect-input btn-reset">
                        </li>
                    </ul>
                    <input class="submit-input btn-reset" type="submit" value="<fmt:message key="local.create"/>">
                </div>
            </form>
        </div>
    </div>
</main>
<jsp:include page="../../parts/footer.jsp"/>
<script src="${pageContext.request.contextPath}/jsp/js/project_form.js"></script>
</body>
</html>