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
    <title><fmt:message key="local.user-information"/> </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/style/additional.css"/>

</head>
<body>
<main class="main">
    <div class="bg-box"></div>
    <div class="info">
        <div class="info-content">
            <form class="info-form" action="servlet" method="POST">
                <input type="hidden" name="command" value="edit_user">
                <div class="user-data">
                    <div class="readonly-data">
                        <div class="readonly-box">
                            <h3 class="readonly-subtitle subtitle"><fmt:message key="local.user-username"/>:</h3>
                            <input class="data-input btn-reset" type="name" placeholder="${user.nickname}" readonly>
                        </div>
                        <div class="readonly-box">
                            <h3 class="readonly-subtitle subtitle"><fmt:message key="local.user-email"/>:</h3>
                            <input class="data-input btn-reset" type="email" placeholder="${user.email}" readonly>
                        </div>
                    </div>
                    <div class="place-data">
                        <div class="place-box">
                            <h3 class="place-subtitle subtitle"><fmt:message key="local.country"/>:</h3>
                            <select id="country" class="select-css" name="country">
                                <option>Belarus</option>
                                <option>Russia</option>
                            </select>
                        </div>
                        <div class="place-box">
                            <h3 class="place-subtitle subtitle"><fmt:message key="local.user-city"/>:</h3>
                            <select id="city" class="select-css" name="city">
                                <option>Minsk</option>
                                <option>Moscow</option>
                            </select>
                        </div>
                    </div>
                    <div class="more-info">
                        <ul class="more-input-box list-reset">
                            <li class="more-item">
                                <h3 class="more-subtitle subtitle"><fmt:message key="local.user-experience"/>:</h3>
                                <input class="more-input btn-reset" name="experience" type="text"
                                       value="${user.userInfo.experience}">
                            </li>
                            <li class="more-item">
                                <h3 class="more-subtitle subtitle"><fmt:message key="local.user-link"/>:</h3>
                                <input class="more-input btn-reset" name="social_link"
                                       type="url" value="${user.userInfo.socialLink}">
                            </li>
                            <li class="more-item">
                                <h3 class="more-subtitle subtitle"><fmt:message key="local.user-date"/>:</h3>
                                <input class="more-input more-date btn-reset" name="date"
                                       value="${user.userInfo.dateOfRegistration}"
                                       type="date">
                            </li>
                        </ul>
                        <div class="more-textarea-box">
                            <textarea class="textarea" name="about" cols="30" rows="10"
                                      placeholder="<fmt:message key="local.tell-about-yourself"/>">${user.userInfo.qualification}</textarea>
                        </div>
                    </div>
                    <div class="save-input">
                        <input class="submit-input btn-reset" type="submit" value="<fmt:message key="local.update"/>">
                    </div>
                </div>
            </form>
        </div>
    </div>
</main>
<script>
    var requestUrl = 'https://raw.githubusercontent.com/David-Haim/CountriesToCitiesJSON/master/countriesToCities.json';
    var xhr = new XMLHttpRequest();

    xhr.open('GET', requestUrl, true);
    xhr.responseType = 'json';
    xhr.send();

    xhr.onload = function() {
        var countryList = xhr.response;
        countryFunction(countryList);
    };

    function countryFunction(jsonObj) {
        for (var key in jsonObj){
            var countryName = document.createElement('option');
            countryName.innerHTML = key;
            country.append(countryName);
        }
    }


    function cityFunction(jsonObj, countryName){

    }

    document.querySelector('#country').addEventListener('change', function() {
        const chosenCountry = this.value;

        countryFunction(cityList);
        // xhr делаем запрос городов по выбранной стране и помещаем список в select#city
    })
</script>
</body>
</html>