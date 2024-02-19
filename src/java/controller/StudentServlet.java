/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.dao.StudentDAO;
import model.entity.Student;

/**
 *
 * @author longle2507
 */
public class StudentServlet extends HttpServlet {

    private StudentDAO stdDAO = new StudentDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String choice = request.getServletPath();
        System.out.println(choice);
        switch (choice) {
            case "/list":
                show_list(request, response);
                break;
            case "/confirm.jsp":
                showAdd(request, response);
                break;
            case "/edit":
                showEdit(request,response);
                break;
            case "/delete":
                deleteStudent(request, response);
                break;
            default:
                break;
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String choice = request.getServletPath();
        System.out.println(choice);
        switch (choice) {
            case "/add":
                addStudent(request, response);
                break;
            case "/edit":
                updateStudent(request, response);
                break;
            default:
                break;
        }

    }

    public void show_list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Student> stdList = stdDAO.getAllStudent();
        request.setAttribute("std_list", stdList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    public void showAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addStudent.jsp");
        dispatcher.forward(request, response);
    }

    public void showEdit(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = stdDAO.getStudentById(id);
        req.setAttribute("student", student);
        RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
        dispatcher.forward(req, res);
    }

    public void addStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("I'm here");
        Student std = (Student) (request.getSession().getAttribute("std"));
        System.out.println(std);
        stdDAO.addStudent(std);
    }

    public void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        stdDAO.deleteStudent(id);
        response.sendRedirect("list");
    }

    public void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("nameStd");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
        } catch (Exception e) {
            System.out.println(e);
        }
        Student std = new Student(id, name, gender, date);
        stdDAO.updateStudent(std);
        request.setAttribute("student", std);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request, response);
    }
}
