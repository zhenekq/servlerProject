<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User information</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/style/additional.css"/>
</head>
<body>
<main class="main">
    <div class="bg-box"></div>
    <div class="info">
        <div class="info-content">
            <form class="info-form" action="servlet" method="POST">
                <input type="hidden" name="command" value="additional_info">
                <div class="user-data">
                    <div class="readonly-data">
                        <div class="readonly-box">
                            <h3 class="readonly-subtitle subtitle">Username:</h3>
                            <input class="data-input btn-reset" type="name" placeholder="User123" readonly>
                        </div>
                        <div class="readonly-box">
                            <h3 class="readonly-subtitle subtitle">User email:</h3>
                            <input class="data-input btn-reset" type="email" placeholder="user@user.com" readonly>
                        </div>
                    </div>
                    <div class="place-data">
                        <div class="place-box">
                            <h3 class="place-subtitle subtitle">Select country:</h3>
                            <select class="select-css" name="country">
                                <option>Belarus</option>
                                <option>Russia</option>
                            </select>
                        </div>
                        <div class="place-box">
                            <h3 class="place-subtitle subtitle">Select city:</h3>
                            <select class="select-css" name="city">
                                <option>Minsk</option>
                                <option>Moscow</option>
                            </select>
                        </div>
                    </div>
                    <div class="more-info">
                        <ul class="more-input-box list-reset">
                            <li class="more-item">
                                <h3 class="more-subtitle subtitle">Experience:</h3>
                                <input class="more-input btn-reset" name="experience" type="text" required>
                            </li>
                            <li class="more-item">
                                <h3 class="more-subtitle subtitle">Link to social network:</h3>
                                <input class="more-input btn-reset" name="social_link" type="text" required>
                            </li>
                            <li class="more-item">
                                <h3 class="more-subtitle subtitle">Date of Birth:</h3>
                                <input class="more-input more-date btn-reset" name="date" value="2021-01-01" type="date" required >
                            </li>
                        </ul>
                        <div class="more-textarea-box">
                            <textarea class="textarea" name="about" cols="30" rows="10" placeholder="Tell us about yourself" required></textarea>
                        </div>
                    </div>
                    <div class="save-input">
                        <input class="submit-input btn-reset" type="submit" value="Save">
                        <a href="?command=additional_info" class="skip-title subtitle link-reset">Skip</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</main>
</body>
</html>