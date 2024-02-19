<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="std" class="model.entity.Student" scope="session"/>
<jsp:setProperty name="std" property="name"/>
<jsp:setProperty name="std" property="gender"/>

<%
    // Lấy giá trị của "dob" từ request parameter
    String dobValue = request.getParameter("dob");

    // Kiểm tra xem giá trị có tồn tại không
    if (dobValue != null && !dobValue.isEmpty()) {
        try {
            // Chuyển đổi chuỗi ngày tháng sang đối tượng Date
            java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dobDate = dateFormat.parse(dobValue);

            // Đặt giá trị cho trường "dob"
            std.setDob(new java.sql.Date(dobDate.getTime()));
        } catch (java.text.ParseException e) {
            // Xử lý trường hợp giá trị không hợp lệ (có thể in ra thông báo lỗi hoặc xử lý theo cách khác)
        }
    } else {
        // Xử lý trường hợp giá trị không tồn tại
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Page</title>
    </head>
    <body>
        <h1>Confirm Information</h1>
        <form action="add" method="post">
            <p>Student Name: <b>${std.name}</b></p>
            <p>Student Gender: <b>${std.gender}</b></p>
            <p>Student DOB: <b>${std.dob}</b></p>
            <button type="submit">Confirm</button>
            <button><a href="addStudent.jsp">Back</a></button>
        </form>
    </body>
</html>
