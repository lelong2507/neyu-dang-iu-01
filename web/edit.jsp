<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit Now!</h1>
        <form class="edit" method="POST" object="${student}">
            <span>Name: <input type="text" name="nameStd" value="${student.name}"></span>
            <br>
            <br>
            <span>Gender
                <select name="gender">
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                    <option value="other">Other</option>
                </select>

            </span>
            <br>
            <br>
            <span>DayofBirth <input type="date" name="dob" value="${student.dob}"></span>
            <br>
            <br>
            <button type="submit">Confirm!</button>
            <button><a href="list">Back to List!</a></button>
        </form> 
    </body>
</html>
