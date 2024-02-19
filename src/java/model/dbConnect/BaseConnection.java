/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dbConnect;

/**
 *
 * @author longle2507
 */
public interface BaseConnection {
    public static String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String URL = "jdbc:sqlserver://localhost:1433;databaseName=student_management;encrypt=true;trustServerCertificate=true;";
    public static String USER_NAME = "SA";
    public static String PASS_WORD = "Longpro@2003";
}
