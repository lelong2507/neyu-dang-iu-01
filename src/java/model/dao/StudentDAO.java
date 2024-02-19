/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.dbConnect.ConnectDB;
import model.entity.Student;
import utils.MyQuery;

/**
 *
 * @author longle2507
 */
public class StudentDAO {

    public ConnectDB db = new ConnectDB();

    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> stdList = new ArrayList<>();
        db = ConnectDB.getInstance();
        try {
            Connection conn = db.openConnect();
            PreparedStatement st = conn.prepareStatement(MyQuery.SHOW_ALL);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("nameStd");
                String gender = rs.getString("gender");
                Date birthday = rs.getDate("dob");
                Student student = new Student(id, name, gender, birthday);
                stdList.add(student);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return stdList;
    }

    // ADD Student Method
    public void addStudent(Student std) {
        db = ConnectDB.getInstance();
        try {
            Connection con = db.openConnect();
            PreparedStatement pst = con.prepareStatement(MyQuery.ADD_STUDENT);
            pst.setString(1, std.getName());
            pst.setString(2, std.getGender());
            java.util.Date utilDate = std.getDob();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            pst.setDate(3, sqlDate);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Search by ID method
    public Student getStudentById(int id) {
        try {
            Connection conn = db.openConnect();
            PreparedStatement ps = conn.prepareStatement(MyQuery.GET_STD_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String name = rs.getString("nameStd");
            String gender = rs.getString("gender");
            Date birthday = rs.getDate("dob");
            Student student = new Student(id, name, gender, birthday);
            ps.close();
            return student;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    // Delete Student
    public void deleteStudent(int id) {
        try {
            Connection conn = db.openConnect();
            PreparedStatement ps = conn.prepareStatement(MyQuery.DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // Update Student
    public void updateStudent(Student std){
        try{
            Connection con = db.openConnect();
            PreparedStatement pst = con.prepareStatement(MyQuery.EDIT);
            pst.setString(1,std.getName());
            pst.setString(2,  std.getGender());
            java.util.Date utilDate = std.getDob();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
            pst.setDate(3,sqlDate);
            pst.setInt(4,std.getId());
            pst.executeUpdate();
            pst.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        System.out.println(dao.getStudentById(3));
    }
}
