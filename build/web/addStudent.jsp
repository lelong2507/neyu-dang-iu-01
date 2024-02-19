<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add User</h1>
        <form action="confirm.jsp" method="POST">
            <span>Name: <input type="text" name="name"></span>
            <br>
            <br>
            <span>
                Gender
                <select name="gender">
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Other">Other</option>
                </select>
            </span>
            <br>
            <br>
            <span>DateOfBirth <input type="date" name="dob"></span>
            <br>
            <br>
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
