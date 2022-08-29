package org.example;

import java.sql.*;

import java.time.Year;

public class selectoption {
    static final String DB_URL = "jdbc:mysql://localhost:3306/bank";
    static final String USER = "root";
    static final String PASS = "root";
    static final String QUERY = "SELECT id, name FROM students";

    public static void main(String[] args){
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while(rs.next()){
                System.out.print("ID: "+rs.getInt("id")+ "\t");
                System.out.print("Name: "+rs.getString("name")+ "\n");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}