/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author longle2507
 */
public class MyQuery {

    public static final String ADD_STUDENT = "insert into student_app(nameStd,gender,dob) values(?, ?, ?);";
    public static final String SHOW_ALL = "select * from student_app;";
    public static final String GET_STD_BY_ID = "select * from student_app where id = ?;";
    public static final String DELETE = "delete from student_app where id = ?;";
    public static final String EDIT = "update student_app set nameStd = ?, gender = ?, dob = ? where id = ?;";
}
