package org.example;
import java.sql.*;

public class Main {

    public static void main(String[] args)
    throws SQLException, ClassNotFoundException{
        String driverClassName
                = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bank";
        String username = "root";
        String password = "root";
        String query
                = "insert into students values(130, 'bhatt')";

        // Load driver class
        Class.forName(driverClassName);

        // Obtain a connection
        Connection con = DriverManager.getConnection(
                url, username, password);

        // Obtain a statement
        Statement st = con.createStatement();

        // Execute the query
        int count = st.executeUpdate(query);

        System.out.println(
                "number of rows affected by this query= "
                        + count);

        // Closing the connection as per the
        // requirement with connection is completed
        con.close();

    }
}