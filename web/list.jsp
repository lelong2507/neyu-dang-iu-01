<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="model.entity.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Students</title>
    </head>
    <body>
        <h1>List Students!</h1>

        <table border="1">
            <tr>
                <td>NO</td>
                <td>Name</td>
                <td>Gender</td>
                <td>DateOfBirth</td>
            </tr>
            <%
                List<Student> stdList = (List<Student>) request.getAttribute("std_list");
                for (Student s : stdList) {
            %>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getGender() %></td>
                <td><%= s.getDob() %></td>
                <td>
                    <button class="edit"><a href="edit?id=<%= s.getId()%>">Edit</a></button>
                    <button class="delete"><a href="delete?id=<%= s.getId()%>">Delete</a></button>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <button><a href="addStudent.jsp">Add more!</a></button>
    </body>
</html>
