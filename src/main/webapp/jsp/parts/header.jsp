<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<header class="header">
    <div class="header-wrapper wrapper">
        <div class="left-header">
            <div class="header-logo">
                <svg class="logo" enable-background="new 0 0 24 24" height="50" viewBox="0 0 24 24" width="50"
                     xmlns="http://www.w3.org/2000/svg">
                    <path
                            d="m8.843 12.651c-1.392 0-2.521 1.129-2.521 2.521v6.306c0 1.392 1.129 2.521 2.521 2.521s2.521-1.129 2.521-2.521v-6.306c-.001-1.392-1.13-2.521-2.521-2.521z"/>
                    <path
                            d="m.019 15.172c0 1.393 1.13 2.523 2.523 2.523s2.523-1.13 2.523-2.523v-2.523h-2.521c-.001 0-.001 0-.002 0-1.393 0-2.523 1.13-2.523 2.523z"/>
                    <path
                            d="m8.846-.001c-.001 0-.002 0-.003 0-1.393 0-2.523 1.13-2.523 2.523s1.13 2.523 2.523 2.523h2.521c0-1.431 0-1.083 0-2.528-.001-1.391-1.128-2.518-2.518-2.518z"/>
                    <path
                            d="m2.525 11.37h6.318c1.393 0 2.523-1.13 2.523-2.523s-1.13-2.523-2.523-2.523h-6.318c-1.393 0-2.523 1.13-2.523 2.523s1.13 2.523 2.523 2.523z"/>
                    <path
                            d="m21.457 6.323c-1.391 0-2.518 1.127-2.518 2.518v.005 2.523h2.521c1.393 0 2.523-1.13 2.523-2.523s-1.13-2.523-2.523-2.523c-.001 0-.002 0-.003 0z"/>
                    <path
                            d="m12.641 2.522v6.325c0 1.392 1.129 2.521 2.521 2.521s2.521-1.129 2.521-2.521v-6.325c0-1.392-1.129-2.521-2.521-2.521-1.392 0-2.521 1.129-2.521 2.521z"/>
                    <path
                            d="m17.682 21.476c0-1.392-1.129-2.521-2.521-2.521h-2.521v2.523c.001 1.391 1.129 2.519 2.521 2.519s2.521-1.129 2.521-2.521z"/>
                    <path
                            d="m21.479 12.649h-6.318c-1.393 0-2.523 1.13-2.523 2.523s1.13 2.523 2.523 2.523h6.318c1.393 0 2.523-1.13 2.523-2.523s-1.13-2.523-2.523-2.523z"/>
                </svg>
            </div>
            <ul class="header-list list-reset">
                <%--<li class="headerLinks-item"><a href="#" class="link-reset link-header">Managers</a></li>
                <li class="headerLinks-item"><a href="#" class="link-reset link-header">My projects</a></li>
                <li class="headerLinks-item"><a href="?command=add_new_project_page" class="link-reset link-header">Create new project</a></li>--%>
                <!--MANAGER HEADER-->
                <fmt:setBundle basename="local"/>
                <c:set var="role" value="${user.role}"/>
                <c:if test="${role.equals('MANAGER')}">
                    <li class="headerLinks-item"><a href="?command=authorized_main_page" class="link-reset link-header">
                        <fmt:message key="local.projects"/>
                    </a>
                    </li>
                    <li class="headerLinks-item"><a href="?command=find_developer" class="link-reset link-header">
                        <fmt:message key="local.find-developer"/>
                    </a></li>
                    <li class="headerLinks-item"><a href="?command=managed_projects" class="link-reset link-header">
                        <fmt:message key="local.my-projects"/>
                    </a></li>
                    <li class="headerLinks-item"><a href="?command=manager_teams" class="link-reset link-header">
                        <fmt:message key="local.team"/>
                    </a></li>
                    <li class="headerLinks-item"><a href="?command=project_requests" class="link-reset link-header">
                        <fmt:message key="local.request-for-project"/>
                    </a></li>
                    <li class="headerLinks-item"><a href="?command=create_new_task" class="link-reset link-header">
                        <fmt:message key="local.new-task"/>
                    </a></li>
                </c:if>
                <!--DEVELOPER HEADER HEADER-->
                <c:if test="${role.equals('DEVELOPER')}">
                    <li class="headerLinks-item"><a href="?command=authorized_main_page" class="link-reset link-header">
                        <fmt:message key="local.find-team"/>
                    </a></li>
                    <li class="headerLinks-item"><a href="?command=developer_team"
                                                    class="link-reset link-header">
                        <fmt:message key="local.team"/>
                    </a></li>
                    <li class="headerLinks-item"><a href="?command=developer_tasks"
                                                    class="link-reset link-header">
                        <fmt:message key="local.tasks"/>
                    </a></li>
                </c:if>
                <!--CUSTOMER HEADER HEADER-->
                <c:if test="${role.equals('CUSTOMER')}">
                    <li class="headerLinks-item"><a href="?command=authorized_main_page" class="link-reset link-header">
                        <fmt:message key="local.managers"/>
                    </a>
                    </li>
                    <li class="headerLinks-item"><a href="?command=show_my_projects" class="link-reset link-header">
                        <fmt:message key="local.my-projects"/>
                    </a></li>
                    <li class="headerLinks-item"><a href="?command=customer_project_responses"
                                                    class="link-reset link-header">
                        <fmt:message key="local.request-for-project"/>
                    </a></li>
                    <li class="headerLinks-item"><a href="?command=add_new_project_page" class="link-reset link-header">
                        <fmt:message key="local.new-project"/>
                    </a></li>
                </c:if>
                <!--ADMIN HEADER HEADER-->
                <c:if test="${role.equals('ADMIN')}">
                    <li class="headerLinks-item"><a href="?command=authorized_main_page" class="link-reset link-header">
                        <fmt:message key="local.users"/>
                    </a>
                    </li>
                    <li class="headerLinks-item"><a href="?command=admin_projects" class="link-reset link-header">
                        <fmt:message key="local.projects"/>
                    </a>
                    </li>
                    <%--<li class="headerLinks-item"><a href="?command=admin_project_responses"
                                                    class="link-reset link-header">Project responses</a></li>
                    <li class="headerLinks-item"><a href="?command=admin_teams" class="link-reset link-header">Teams</a>
                    </li>
                    <li class="headerLinks-item"><a href="?command=admin_tasks" class="link-reset link-header">Tasks</a>
                    </li>--%>
                </c:if>
            </ul>
        </div>
        <div style="align-items: center" class="right-header">
            <h2 class="username">${user.nickname}</h2>
            <div class="dropdown">
                <button onclick="myFunction()" class="dropbtn btn-reset"></button>
                <div id="myDropdown" class="dropdown-content">
                    <a class="navigation-item" href="?command=profile">
                        <fmt:message key="local.profile"/>
                    </a>
                    <a class="navigation-item" href="?command=logout_page">
                        <fmt:message key="local.logout"/>
                    </a>
                </div>
            </div>
            <p class="user-role-title"><fmt:message key="local.role"/>:</p>
            <p class="user-role">${user.role}</p>
            <div class="lang">
                <a href="?command=language&language=ru" class="ru-lang link-reset">RU</a>
                <a href="?command=language&language=en" class="en-lang link-reset">EN</a>
            </div>
        </div>
    </div>
</header>
<script src="${pageContext.request.contextPath}/jsp/js/main.js"></script>
